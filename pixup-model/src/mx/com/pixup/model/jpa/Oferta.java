package mx.com.pixup.model.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "oferta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oferta.findAll", query = "SELECT o FROM Oferta o"),
    @NamedQuery(name = "Oferta.findByIdentificador", query = "SELECT o FROM Oferta o WHERE o.identificador = :identificador"),
    @NamedQuery(name = "Oferta.findByIddisco", query = "SELECT o FROM Oferta o WHERE o.iddisco = :iddisco"),
    @NamedQuery(name = "Oferta.findByIdusuario", query = "SELECT o FROM Oferta o WHERE o.idusuario = :idusuario"),
    @NamedQuery(name = "Oferta.findByFechainicio", query = "SELECT o FROM Oferta o WHERE o.fechainicio = :fechainicio"),
    @NamedQuery(name = "Oferta.findByFechafinal", query = "SELECT o FROM Oferta o WHERE o.fechafinal = :fechafinal"),
    @NamedQuery(name = "Oferta.findByPrecio", query = "SELECT o FROM Oferta o WHERE o.precio = :precio"),
    @NamedQuery(name = "Oferta.findByTextoOferta", query = "SELECT o FROM Oferta o WHERE o.textoOferta = :textoOferta")})
public class Oferta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "identificador")
    private Integer identificador;
    @Basic(optional = false)
    @Column(name = "iddisco")
    private int iddisco;
    @Basic(optional = false)
    @Column(name = "idusuario")
    private int idusuario;
    @Basic(optional = false)
    @Column(name = "fechainicio")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Basic(optional = false)
    @Column(name = "fechafinal")
    @Temporal(TemporalType.DATE)
    private Date fechafinal;
    @Basic(optional = false)
    @Column(name = "precio")
    private double precio;
    @Basic(optional = false)
    @Column(name = "texto_oferta")
    private String textoOferta;

    public Oferta() {
    }

    public Oferta(Integer identificador) {
        this.identificador = identificador;
    }

    public Oferta(Integer identificador, int iddisco, int idusuario, Date fechainicio, Date fechafinal, double precio, String textoOferta) {
        this.identificador = identificador;
        this.iddisco = iddisco;
        this.idusuario = idusuario;
        this.fechainicio = fechainicio;
        this.fechafinal = fechafinal;
        this.precio = precio;
        this.textoOferta = textoOferta;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public int getIddisco() {
        return iddisco;
    }

    public void setIddisco(int iddisco) {
        this.iddisco = iddisco;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(Date fechafinal) {
        this.fechafinal = fechafinal;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTextoOferta() {
        return textoOferta;
    }

    public void setTextoOferta(String textoOferta) {
        this.textoOferta = textoOferta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificador != null ? identificador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oferta)) {
            return false;
        }
        Oferta other = (Oferta) object;
        if ((this.identificador == null && other.identificador != null) || (this.identificador != null && !this.identificador.equals(other.identificador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.pixup.model.jpa.Oferta[ identificador=" + identificador + " ]";
    }
    
}
