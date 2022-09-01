/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author omaldonado
 */
@Entity
@Table(name = "REM_TIPO_ANIMAL_TUTOR", catalog = "MDMQ_REMETFU", schema = "Remetfu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RemTipoAnimalTutor.findAll", query = "SELECT r FROM RemTipoAnimalTutor r"),
    @NamedQuery(name = "RemTipoAnimalTutor.findByTipoAnimalTutorId", query = "SELECT r FROM RemTipoAnimalTutor r WHERE r.tipoAnimalTutorId = :tipoAnimalTutorId")})
public class RemTipoAnimalTutor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_ANIMAL_TUTOR_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipoAnimalTutorId;
    
    @Column(name="NOMBRE_INSTITUCION", length = 50)
    private String nombreIntitucion;
    @Column(name="TELEFONO_INSTITUCION", length = 15)
    private String telefonoIntitucion;    

    @JoinColumn(name = "ANIMAL_TUTOR_ID", referencedColumnName = "ANIMAL_TUTOR_ID", nullable = false)
    @JsonBackReference("animalTutorIdTipoAnimal")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemAnimalTutor animalTutorId;

    @JoinColumn(name = "DOCUMENTO_ACREDITA", referencedColumnName = "ARCHIVO_ID")
    @JsonBackReference("documentoAcredita")
    @ManyToOne(fetch = FetchType.LAZY)
    private RemArchivos documentoAcredita;

    @JoinColumn(name = "TIPO_ANIMAL", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("tipoAnimal")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo tipoAnimal;

    public RemTipoAnimalTutor() {
    }

    public RemTipoAnimalTutor(Long tipoAnimalTutorId, RemAnimalTutor animalTutorId, RemArchivos documentoAcredita, RemCatalogo tipoAnimal) {
        this.tipoAnimalTutorId = tipoAnimalTutorId;
        this.animalTutorId = animalTutorId;
        this.documentoAcredita = documentoAcredita;
        this.tipoAnimal = tipoAnimal;
    }

    public Long getTipoAnimalTutorId() {
        return tipoAnimalTutorId;
    }

    public void setTipoAnimalTutorId(Long tipoAnimalTutorId) {
        this.tipoAnimalTutorId = tipoAnimalTutorId;
    }

    public RemAnimalTutor getAnimalTutorId() {
        return animalTutorId;
    }

    public void setAnimalTutorId(RemAnimalTutor animalTutorId) {
        this.animalTutorId = animalTutorId;
    }

    public RemArchivos getDocumentoAcredita() {
        return documentoAcredita;
    }

    public void setDocumentoAcredita(RemArchivos documentoAcredita) {
        this.documentoAcredita = documentoAcredita;
    }

    public RemCatalogo getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(RemCatalogo tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public String getNombreIntitucion() {
        return nombreIntitucion;
    }

    public void setNombreIntitucion(String nombreIntitucion) {
        this.nombreIntitucion = nombreIntitucion;
    }

    public String getTelefonoIntitucion() {
        return telefonoIntitucion;
    }

    public void setTelefonoIntitucion(String telefonoIntitucion) {
        this.telefonoIntitucion = telefonoIntitucion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoAnimalTutorId != null ? tipoAnimalTutorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RemTipoAnimalTutor)) {
            return false;
        }
        RemTipoAnimalTutor other = (RemTipoAnimalTutor) object;
        if ((this.tipoAnimalTutorId == null && other.tipoAnimalTutorId != null) || (this.tipoAnimalTutorId != null && !this.tipoAnimalTutorId.equals(other.tipoAnimalTutorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RemTipoAnimalTutor{" + "tipoAnimalTutorId=" + tipoAnimalTutorId + ", animalTutorId=" + animalTutorId + ", documentoAcredita=" + documentoAcredita + ", tipoAnimal=" + tipoAnimal + '}';
    }

}
