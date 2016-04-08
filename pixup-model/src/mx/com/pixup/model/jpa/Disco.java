package mx.com.pixup.model.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "disco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disco.findAll", query = "SELECT d FROM Disco d"),
    @NamedQuery(name = "Disco.findById", query = "SELECT d FROM Disco d WHERE d.id = :id"),
    @NamedQuery(name = "Disco.findByTitulo", query = "SELECT d FROM Disco d WHERE d.titulo = :titulo"),
    @NamedQuery(name = "Disco.findByFechaLanzamiento", query = "SELECT d FROM Disco d WHERE d.fechaLanzamiento = :fechaLanzamiento"),
    @NamedQuery(name = "Disco.findByPrecio", query = "SELECT d FROM Disco d WHERE d.precio = :precio"),
    @NamedQuery(name = "Disco.findByCantidadDisponible", query = "SELECT d FROM Disco d WHERE d.cantidadDisponible = :cantidadDisponible")})
public class Disco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @Column(name = "fecha_lanzamiento")
    @Temporal(TemporalType.DATE)
    private Date fechaLanzamiento;
    @Basic(optional = false)
    @Column(name = "precio")
    private float precio;
    @Basic(optional = false)
    @Column(name = "cantidad_disponible")
    private int cantidadDisponible;
    @JoinColumn(name = "id_idioma", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Idioma idIdioma;
    @JoinColumn(name = "id_pais", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Pais idPais;
    @JoinColumn(name = "id_disquera", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Disquera idDisquera;
    @JoinColumn(name = "id_genero_musical", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private GeneroMusical idGeneroMusical;
    @JoinColumn(name = "id_promocion", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Promocion idPromocion;
    @JoinColumn(name = "id_iva", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Iva idIva;

    public Disco() {
    }

    public Disco(Integer id) {
        this.id = id;
    }

    public Disco(Integer id, String titulo, Date fechaLanzamiento, float precio, int cantidadDisponible) {
        this.id = id;
        this.titulo = titulo;
        this.fechaLanzamiento = fechaLanzamiento;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public Idioma getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Idioma idIdioma) {
        this.idIdioma = idIdioma;
    }

    public Pais getIdPais() {
        return idPais;
    }

    public void setIdPais(Pais idPais) {
        this.idPais = idPais;
    }

    public Disquera getIdDisquera() {
        return idDisquera;
    }

    public void setIdDisquera(Disquera idDisquera) {
        this.idDisquera = idDisquera;
    }

    public GeneroMusical getIdGeneroMusical() {
        return idGeneroMusical;
    }

    public void setIdGeneroMusical(GeneroMusical idGeneroMusical) {
        this.idGeneroMusical = idGeneroMusical;
    }

    public Promocion getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(Promocion idPromocion) {
        this.idPromocion = idPromocion;
    }

    public Iva getIdIva() {
        return idIva;
    }

    public void setIdIva(Iva idIva) {
        this.idIva = idIva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disco)) {
            return false;
        }
        Disco other = (Disco) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.pixup.model.jpa.Disco[ id=" + id + " ]";
    }
    
}
