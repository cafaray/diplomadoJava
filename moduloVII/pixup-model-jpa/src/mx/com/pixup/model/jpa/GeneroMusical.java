package mx.com.pixup.model.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "genero_musical")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GeneroMusical.findAll", query = "SELECT g FROM GeneroMusical g"),
    @NamedQuery(name = "GeneroMusical.findById", query = "SELECT g FROM GeneroMusical g WHERE g.id = :id"),
    @NamedQuery(name = "GeneroMusical.findByNombre", query = "SELECT g FROM GeneroMusical g WHERE g.nombre = :nombre")})
public class GeneroMusical implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGeneroMusical", fetch = FetchType.EAGER)
    private List<Disco> discoList;

    public GeneroMusical() {
    }

    public GeneroMusical(Integer id) {
        this.id = id;
    }

    public GeneroMusical(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        if (!(object instanceof GeneroMusical)) {
            return false;
        }
        GeneroMusical other = (GeneroMusical) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.pixup.model.jpa.GeneroMusical[ id=" + id + " ]";
    }
    
}
