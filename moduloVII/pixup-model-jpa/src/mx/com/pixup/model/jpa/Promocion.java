package mx.com.pixup.model.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "promocion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promocion.findAll", query = "SELECT p FROM Promocion p"),
    @NamedQuery(name = "Promocion.findById", query = "SELECT p FROM Promocion p WHERE p.id = :id"),
    @NamedQuery(name = "Promocion.findByFechaInicio", query = "SELECT p FROM Promocion p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Promocion.findByFechaFin", query = "SELECT p FROM Promocion p WHERE p.fechaFin = :fechaFin"),
    @NamedQuery(name = "Promocion.findByNombre", query = "SELECT p FROM Promocion p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Promocion.findByPorcentajeDescuento", query = "SELECT p FROM Promocion p WHERE p.porcentajeDescuento = :porcentajeDescuento"),
    @NamedQuery(name = "Promocion.findByVigente", query = "SELECT p FROM Promocion p WHERE p.vigente = :vigente")})
public class Promocion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "porcentaje_descuento")
    private float porcentajeDescuento;
    @Basic(optional = false)
    @Column(name = "vigente")
    private boolean vigente;
    @OneToMany(mappedBy = "idPromocion", fetch = FetchType.EAGER)
    private List<Disco> discoList;

    public Promocion() {
    }

    public Promocion(Integer id) {
        this.id = id;
    }

    public Promocion(Integer id, Date fechaInicio, Date fechaFin, String nombre, float porcentajeDescuento, boolean vigente) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.nombre = nombre;
        this.porcentajeDescuento = porcentajeDescuento;
        this.vigente = vigente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(float porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public boolean getVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    @XmlTransient
    public List<Disco> getDiscoList() {
        return discoList;
    }

    public void setDiscoList(List<Disco> discoList) {
        this.discoList = discoList;
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
        if (!(object instanceof Promocion)) {
            return false;
        }
        Promocion other = (Promocion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.pixup.model.jpa.Promocion[ id=" + id + " ]";
    }
    
}
