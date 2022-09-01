/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.Entidades;

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
@Table(name = "REM_TUTORES_COMUNITARIOS", catalog = "MDMQ_REMETFU", schema = "Remetfu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RemTutoresComunitarios.findAll", query = "SELECT r FROM RemTutoresComunitarios r"),
    @NamedQuery(name = "RemTutoresComunitarios.findByTutoresComunitariosId", query = "SELECT r FROM RemTutoresComunitarios r WHERE r.tutoresComunitariosId = :tutoresComunitariosId")})
public class RemTutoresComunitarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TUTORES_COMUNITARIOS_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tutoresComunitariosId;
    @JoinColumn(name = "ANIMAL_TUTOR_ID", referencedColumnName = "ANIMAL_TUTOR_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemAnimalTutor animalTutorId;
    @JoinColumn(name = "TUTOR_ID", referencedColumnName = "TUTOR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private RemTutorMascota tutorId;

    public RemTutoresComunitarios() {
    }

    public RemTutoresComunitarios(Long tutoresComunitariosId, RemAnimalTutor animalTutorId, RemTutorMascota tutorId) {
        this.tutoresComunitariosId = tutoresComunitariosId;
        this.animalTutorId = animalTutorId;
        this.tutorId = tutorId;
    }

    public Long getTutoresComunitariosId() {
        return tutoresComunitariosId;
    }

    public void setTutoresComunitariosId(Long tutoresComunitariosId) {
        this.tutoresComunitariosId = tutoresComunitariosId;
    }

    public RemAnimalTutor getAnimalTutorId() {
        return animalTutorId;
    }

    public void setAnimalTutorId(RemAnimalTutor animalTutorId) {
        this.animalTutorId = animalTutorId;
    }

    public RemTutorMascota getTutorId() {
        return tutorId;
    }

    public void setTutorId(RemTutorMascota tutorId) {
        this.tutorId = tutorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tutoresComunitariosId != null ? tutoresComunitariosId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RemTutoresComunitarios)) {
            return false;
        }
        RemTutoresComunitarios other = (RemTutoresComunitarios) object;
        if ((this.tutoresComunitariosId == null && other.tutoresComunitariosId != null) || (this.tutoresComunitariosId != null && !this.tutoresComunitariosId.equals(other.tutoresComunitariosId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RemTutoresComunitarios{" + "tutoresComunitariosId=" + tutoresComunitariosId + ", animalTutorId=" + animalTutorId + ", tutorId=" + tutorId + '}';
    }

}
