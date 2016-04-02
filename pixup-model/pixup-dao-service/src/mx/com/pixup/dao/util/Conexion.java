package mx.com.pixup.dao.util;

import mx.com.pixup.dao.exception.PixUpDAOException;
import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

public class Conexion {

    private static final String JDBC_MYSQL = "jdbc:mysql:";
    private final static String JDBC_MYSQL_DRIVER   = "com.mysql.jdbc.Driver";

    
    private String servidor;
    private String baseDatos;
    private String cadena;
    private String usuario;
    private String contrasenia;
    private Connection conexion = null;

    private Conexion(){}
    
    public static Conexion getInterface(){
        return new Conexion();
    }
    
    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getBaseDatos() {
        return baseDatos;
    }

    public void setBaseDatos(String baseDatos) {
        this.baseDatos = baseDatos;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public Connection getConexionFromProperties(String file) throws PixUpDAOException {
        try {
            File file_props = new File(file);
            Properties prop = new Properties();
            prop.load(new FileInputStream(file_props));
            setUsuario(prop.getProperty("usuario"));
            setContrasenia(prop.getProperty("clave"));
            setServidor(prop.getProperty("servidor"));
            setBaseDatos(prop.getProperty("basedatos"));
            return getConnection2MySql(getServidor(), getBaseDatos(), getUsuario(), getContrasenia());
        } catch (java.io.IOException ioe) {
            throw new PixUpDAOException("El archivo de propiedades no se ha logrado cargar o no es el que se esperaba en "+file, ioe);
        }        
    }
    
    public Connection getConexion() throws PixUpDAOException {
        try {
            if (conexion!=null && conexion.isClosed()) {   
                System.out.print("PixUp:::Conexion-Closed, generating new Connection ...");
                conexion = getConnection2MySql(getServidor(), getBaseDatos(), getUsuario(), getContrasenia());
                System.out.println("\t\t[OK]");
            } else if(conexion==null) {
                System.out.print("PixUp:::Conexion-Empty, generating new Connection ...");
                conexion = getConnection2MySql(getServidor(), getBaseDatos(), getUsuario(), getContrasenia());
                System.out.println("\t\t[OK]");
            }
            System.out.println("PixUp:::Conexion-Exists, done");
            return conexion;
        } catch(SQLException e){
            throw new PixUpDAOException("Imposible entregar una conexi�n ahora. Ocurri� una excepci�n, revise el log.", e);
        }        
    }

    public Connection getConnection2MySql(String servidor, String basedatos, String usuario, String contrasenia) throws PixUpDAOException {
        return getConnectionMySql(JDBC_MYSQL + "//" + servidor + '/' + basedatos + "?noAccessToProcedureBodies=true", usuario, contrasenia);
    }

    public Connection getConnectionMySql(String cadena, String usuario, String contrasenia) throws PixUpDAOException {
        Connection cn;
        try {
            Class.forName(JDBC_MYSQL_DRIVER).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace(System.out);              
            throw new PixUpDAOException("Imposible localizar la clase "+JDBC_MYSQL_DRIVER+", no se ha logrado la conexi�n a la base de datos.", e);
        } catch (IllegalAccessException e){
            e.printStackTrace(System.out);
            throw new PixUpDAOException("Imposible acceder la clase "+JDBC_MYSQL_DRIVER+", no se ha logrado la conexi�n a la base de datos.", e);
        } catch (InstantiationException e){
            e.printStackTrace(System.out);
            throw new PixUpDAOException("Imposible generar la instancia de la clase "+JDBC_MYSQL_DRIVER+", no se ha logrado la conexi�n a la base de datos.", e);
        }
        try {
            cn = DriverManager.getConnection(cadena, usuario, contrasenia);
            conexion = cn;
            return cn;
        } catch(SQLException e){
            e.printStackTrace(System.out);
            throw new PixUpDAOException("Imposible conectar a la base de datos, se gener� una excepci�n al acceder a la base de datos. Revise el log.", e);
        }
    }

    /***
     * Valida el acceso de un usuario a una determinada base de datos
     *
     * @param servidor: servidor de datos
     * @param bd: base de datos a la que se quiere acceder
     * @param u: usuario que requiere conectarse
     * @param c: contrasenia del usuario
     * @return true si la conexión se realiza, false si se tiene un error de
     * loggeado
     * @throws PixUpDAOException
     */
    public boolean validaUsuarioMySql(String servidor, String bd, String u, String c) throws PixUpDAOException {
        String urlConn = "";
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            urlConn = JDBC_MYSQL + "//" + servidor + '/' + bd + "?noAccessToProcedureBodies=true";
            con = DriverManager.getConnection(urlConn, u, c);
            return (con != null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace(System.out);              
            throw new PixUpDAOException("Imposible localizar la clase "+JDBC_MYSQL_DRIVER+", no se ha logrado la conexi�n a la base de datos.", e);
        } catch (IllegalAccessException e){
            e.printStackTrace(System.out);
            throw new PixUpDAOException("Imposible acceder la clase "+JDBC_MYSQL_DRIVER+", no se ha logrado la conexi�n a la base de datos.", e);
        } catch (InstantiationException e){
            e.printStackTrace(System.out);
            throw new PixUpDAOException("Imposible generar la instancia de la clase "+JDBC_MYSQL_DRIVER+", no se ha logrado la conexi�n a la base de datos.", e);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            throw new PixUpDAOException("Imposible conectar a la base de datos, se gener� una excepci�n al acceder a la base de datos. Revise el log.", e);
        } finally {
            setUsuario(u);
            setContrasenia(c);
            setServidor(servidor);
            setBaseDatos(bd);
            setCadena(urlConn);
            conexion = con;
        }
    }

    public static String md5(Connection conexion, String cadena) throws PixUpDAOException {
        try {
            PreparedStatement stm = conexion.prepareStatement("SELECT MD5(?);");
            stm.setString(1, cadena);
            ResultSet rst = stm.executeQuery();
            if (rst.next()) {
                return rst.getString(1);
            }
            return "";
        } catch(SQLException e) {
            e.printStackTrace(System.out);
            throw new PixUpDAOException("La consulta no se ha logrado realizar. Revise el log.", e);
        }
    }

    public static String md5(Connection conexion, String cadena, int inicio, int longitud) throws PixUpDAOException {
        try {
            PreparedStatement stm = conexion.prepareStatement("SELECT cadena(?,?,?);");
            stm.setString(1, cadena);
            stm.setInt(2, inicio);
            stm.setInt(3, longitud);
            ResultSet rst = stm.executeQuery();
            if (rst.next()) {
                return rst.getString(1);
            }
            return "";
        } catch(SQLException e) {
            e.printStackTrace(System.out);
            throw new PixUpDAOException("La consulta no se ha logrado realizar. Revise el log.", e);
        }
    }

    /***
     * cuentaRegistros devuelve el n�mero de registros devueltos en la consulta anterior.
     * @param conexion Objeto Connection con el que se realizo la consulta con la funci�n SQL_CALC_FOUND_ROWS
     * @return valor long con el numero de resgistros localizados
     * @throws PixUpDAOException
     ***/
    public long cuentaRegistros(Connection conexion) throws PixUpDAOException {
        try {
            long regresa = 0;
            if (conexion != null) {
                PreparedStatement pst = conexion.prepareStatement("SELECT FOUND_ROWS() AS total;");
                ResultSet rst = pst.executeQuery();
                if (rst.next()) {
                    regresa = rst.getLong(1);
                }
            }
            return regresa;
        } catch(SQLException e){
            e.printStackTrace(System.out);
            throw new PixUpDAOException("La consulta no se ha logrado realizar. Revise el log.", e);
        }
    }

}
