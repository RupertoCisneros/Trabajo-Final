/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author srcisnerosv
 */
@Entity
@Table(name = "REM_CATALOGO", catalog = "MDMQ_REMETFU", schema = "Remetfu")

public class RemCatalogo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CATALOGO_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long catalogoId;
    @Basic(optional = false)
    @Column(name = "USUARIO_CREACION", nullable = false, length = 30)
    private String usuarioCreacion;
    @Basic(optional = false)
    @Column(name = "TERMINAL_CREACION", nullable = false, length = 30)
    private String terminalCreacion;
    @Basic(optional = false)
    @Column(name = "FECHA_CREACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @Column(name = "USUARIO_MODIFICACION", nullable = false, length = 30)
    private String usuarioModificacion;
    @Basic(optional = false)
    @Column(name = "TERMINAL_MODIFICACION", nullable = false, length = 30)
    private String terminalModificacion;
    @Basic(optional = false)
    @Column(name = "FECHA_MODIFICACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Size(max = 200)
    @Column(length = 200)
    private String nombre;
    @Size(max = 15)
    @Column(length = 15)
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agenciaUba", fetch = FetchType.LAZY)
    private Set<RemRecepcionAnimales> remRecepcionAnimalesSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "especie", fetch = FetchType.LAZY)
    private Set<RemRecepcionAnimales> remRecepcionAnimalesSet1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "raza", fetch = FetchType.LAZY)
    private Set<RemRecepcionAnimales> remRecepcionAnimalesSet2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sexo", fetch = FetchType.LAZY)
    private Set<RemRecepcionAnimales> remRecepcionAnimalesSet3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoReproductivo", fetch = FetchType.LAZY)
    private Set<RemRecepcionAnimales> remRecepcionAnimalesSet4;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colorPredominante", fetch = FetchType.LAZY)
    private Set<RemRecepcionAnimales> remRecepcionAnimalesSet5;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colorSecundario", fetch = FetchType.LAZY)
    private Set<RemRecepcionAnimales> remRecepcionAnimalesSet6;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procesoEjecucion", fetch = FetchType.LAZY)
    private Set<RemRecepcionAnimales> remRecepcionAnimalesSet7;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pruebaComportamiento", fetch = FetchType.LAZY)
    private Set<RemRecepcionAnimales> remRecepcionAnimalesSet8;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoTutoria", fetch = FetchType.LAZY)
    private Set<RemRetiroAnimales> remRetiroAnimalesSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "situacionIntervencion", fetch = FetchType.LAZY)
    private Set<RemRetiroAnimales> remRetiroAnimalesSet1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "admZonal", fetch = FetchType.LAZY)
    private Set<RemRetiroAnimales> remRetiroAnimalesSet2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parroquia", fetch = FetchType.LAZY)
    private Set<RemRetiroAnimales> remRetiroAnimalesSet3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "motivoRetiro", fetch = FetchType.LAZY)
    private Set<RemRetiroAnimales> remRetiroAnimalesSet4;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAnimal", fetch = FetchType.LAZY)
    private Set<RemTipoAnimalTutor> remTipoAnimalTutorSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargo", fetch = FetchType.LAZY)
    private Set<RemComiteEticaDet> remComiteEticaDetSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enfermedadesDetectadas", fetch = FetchType.LAZY)
    private Set<RemEnfermedadesAnimales> remEnfermedadesAnimalesSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoChequeo", fetch = FetchType.LAZY)
    private Set<RemAtencionAnimales> remAtencionAnimalesSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "atencionRealizada", fetch = FetchType.LAZY)
    private Set<RemAtencionAnimales> remAtencionAnimalesSet1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoIdentificacionVisible", fetch = FetchType.LAZY)
    private Set<RemAtencionAnimales> remAtencionAnimalesSet2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "establecimiento", fetch = FetchType.LAZY)
    private Set<RemMicrochipMascotaUba> remMicrochipMascotaUbaSet;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference("tipoCatalogoId")
    @JoinColumn(name = "TIPO_CATALOGO_ID", referencedColumnName = "TIPO_CATALOGO_ID", nullable = false)
    private RemTipoCatalogo tipoCatalogoId;

    @OneToMany(mappedBy = "tipoUsuario", fetch = FetchType.LAZY)
    private Set<RemPerfil> remPerfilSet;
    @OneToMany(mappedBy = "catalogoId", fetch = FetchType.LAZY)
    private Set<RemAnalista> remAnalistaSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoUsuario", fetch = FetchType.LAZY)
    private Set<RemUsuarios> remUsuariosSet;
    @OneToMany(mappedBy = "admZonal", fetch = FetchType.LAZY)
    private Set<RemUsuarios> remUsuariosSet1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nacionalidad", fetch = FetchType.LAZY)
    private Set<RemUsuarios> remUsuariosSet2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genero", fetch = FetchType.LAZY)
    private Set<RemUsuarios> remUsuariosSet3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parroquia", fetch = FetchType.LAZY)
    private Set<RemRegistroProfesional> remRegistroProfesional;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estado", fetch = FetchType.LAZY)
    private Set<RemRegistroProfesional> remRegistroProfesionalEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catalogoId", fetch = FetchType.LAZY)
    private Set<RemPerfilAcademico> remPerfilAcademicoSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estado", fetch = FetchType.LAZY)
    private Set<RemAnalisisTramiteRegistroProfesional> remAnalisisTramiteRegistroProfesionalEstado;
    @OneToMany(mappedBy = "tipoUsuario", fetch = FetchType.LAZY)
    private Set<RemUsuarioPerfil> remUsuarioPerfilSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "establecimiento", fetch = FetchType.LAZY)
    private Set<RemMicrochipMascota> remMicrochipMascotaSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "raza", fetch = FetchType.LAZY)
    private Set<RemAnimalTutor> remAnimalTutorSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoReproductivo", fetch = FetchType.LAZY)
    private Set<RemAnimalTutor> remAnimalTutorSet1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "especie", fetch = FetchType.LAZY)
    private Set<RemAnimalTutor> remAnimalTutorSet2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "motivoFallecimiento", fetch = FetchType.LAZY)
    private Set<RemAnimalTutor> remAnimalTutorSet3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estado", fetch = FetchType.LAZY)


    private Set<RemAnimalTutor> remAnimalTutorSet4;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permanencia", fetch = FetchType.LAZY)
    private Set<RemAnimalTutor> remAnimalTutorSet5;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colorPredominante", fetch = FetchType.LAZY)
    private Set<RemAnimalTutor> remAnimalTutorSet6;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colorSecundario", fetch = FetchType.LAZY)
    private Set<RemAnimalTutor> remAnimalTutorSet7;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parroquia", fetch = FetchType.LAZY)
    private Set<RemAnimalTutor> remAnimalTutorSet8;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoVivienda", fetch = FetchType.LAZY)
    private Set<RemAnimalTutor> remAnimalTutorSet9;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pruebaComportamiento", fetch = FetchType.LAZY)
    private Set<RemAnimalTutor> remAnimalTutorSet10;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoTutoria", fetch = FetchType.LAZY)
    private Set<RemAnimalTutor> remAnimalTutorSet11;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sexo", fetch = FetchType.LAZY)
    private Set<RemAnimalTutor> remAnimalTutorSet12;

    public RemCatalogo() {
    }

    public RemCatalogo(Long catalogoId, String usuarioCreacion, String terminalCreacion, Date fechaCreacion, String usuarioModificacion, String terminalModificacion, Date fechaModificacion, String nombre, String estado, RemTipoCatalogo tipoCatalogoId) {
        this.catalogoId = catalogoId;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.terminalModificacion = terminalModificacion;
        this.fechaModificacion = fechaModificacion;
        this.nombre = nombre;
        this.estado = estado;
        this.tipoCatalogoId = tipoCatalogoId;
    }


    public Long getCatalogoId() {
        return catalogoId;
    }

    public void setCatalogoId(Long catalogoId) {
        this.catalogoId = catalogoId;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getTerminalCreacion() {
        return terminalCreacion;
    }

    public void setTerminalCreacion(String terminalCreacion) {
        this.terminalCreacion = terminalCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public String getTerminalModificacion() {
        return terminalModificacion;
    }

    public void setTerminalModificacion(String terminalModificacion) {
        this.terminalModificacion = terminalModificacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public RemTipoCatalogo getTipoCatalogoId() {
        return tipoCatalogoId;
    }

    public void setTipoCatalogoId(RemTipoCatalogo tipoCatalogoId) {
        this.tipoCatalogoId = tipoCatalogoId;
    }

    public Set<RemPerfil> getRemPerfilSet() {
        return remPerfilSet;
    }

    public void setRemPerfilSet(Set<RemPerfil> remPerfilSet) {
        this.remPerfilSet = remPerfilSet;
    }

    public Set<RemAnalista> getRemAnalistaSet() {
        return remAnalistaSet;
    }

    public void setRemAnalistaSet(Set<RemAnalista> remAnalistaSet) {
        this.remAnalistaSet = remAnalistaSet;
    }

    public Set<RemUsuarios> getRemUsuariosSet() {
        return remUsuariosSet;
    }

    public void setRemUsuariosSet(Set<RemUsuarios> remUsuariosSet) {
        this.remUsuariosSet = remUsuariosSet;
    }

    public Set<RemUsuarios> getRemUsuariosSet1() {
        return remUsuariosSet1;
    }

    public void setRemUsuariosSet1(Set<RemUsuarios> remUsuariosSet1) {
        this.remUsuariosSet1 = remUsuariosSet1;
    }

    public Set<RemUsuarios> getRemUsuariosSet2() {
        return remUsuariosSet2;
    }

    public void setRemUsuariosSet2(Set<RemUsuarios> remUsuariosSet2) {
        this.remUsuariosSet2 = remUsuariosSet2;
    }

    public Set<RemUsuarios> getRemUsuariosSet3() {
        return remUsuariosSet3;
    }

    public void setRemUsuariosSet3(Set<RemUsuarios> remUsuariosSet3) {
        this.remUsuariosSet3 = remUsuariosSet3;
    }

    public Set<RemRegistroProfesional> getRemRegistroProfesional() {
        return remRegistroProfesional;
    }

    public void setRemRegistroProfesional(Set<RemRegistroProfesional> remRegistroProfesional) {
        this.remRegistroProfesional = remRegistroProfesional;
    }

    public Set<RemPerfilAcademico> getRemPerfilAcademicoSet() {
        return remPerfilAcademicoSet;
    }

    public void setRemPerfilAcademicoSet(Set<RemPerfilAcademico> remPerfilAcademicoSet) {
        this.remPerfilAcademicoSet = remPerfilAcademicoSet;
    }

    public Set<RemRegistroProfesional> getRemRegistroProfesionalEstado() {
        return remRegistroProfesionalEstado;
    }

    public void setRemRegistroProfesionalEstado(Set<RemRegistroProfesional> remRegistroProfesionalEstado) {
        this.remRegistroProfesionalEstado = remRegistroProfesionalEstado;
    }

    public Set<RemAnalisisTramiteRegistroProfesional> getRemAnalisisTramiteRegistroProfesionalEstado() {
        return remAnalisisTramiteRegistroProfesionalEstado;
    }

    public void setRemAnalisisTramiteRegistroProfesionalEstado(Set<RemAnalisisTramiteRegistroProfesional> remAnalisisTramiteRegistroProfesionalEstado) {
        this.remAnalisisTramiteRegistroProfesionalEstado = remAnalisisTramiteRegistroProfesionalEstado;
    }

    public Set<RemUsuarioPerfil> getRemUsuarioPerfilSet() {
        return remUsuarioPerfilSet;
    }

    public void setRemUsuarioPerfilSet(Set<RemUsuarioPerfil> remUsuarioPerfilSet) {
        this.remUsuarioPerfilSet = remUsuarioPerfilSet;
    }

    public Set<RemMicrochipMascota> getRemMicrochipMascotaSet() {
        return remMicrochipMascotaSet;
    }

    public void setRemMicrochipMascotaSet(Set<RemMicrochipMascota> remMicrochipMascotaSet) {
        this.remMicrochipMascotaSet = remMicrochipMascotaSet;
    }

    public Set<RemAnimalTutor> getRemAnimalTutorSet() {
        return remAnimalTutorSet;
    }

    public void setRemAnimalTutorSet(Set<RemAnimalTutor> remAnimalTutorSet) {
        this.remAnimalTutorSet = remAnimalTutorSet;
    }

    public Set<RemAnimalTutor> getRemAnimalTutorSet1() {
        return remAnimalTutorSet1;
    }

    public void setRemAnimalTutorSet1(Set<RemAnimalTutor> remAnimalTutorSet1) {
        this.remAnimalTutorSet1 = remAnimalTutorSet1;
    }

    public Set<RemAnimalTutor> getRemAnimalTutorSet2() {
        return remAnimalTutorSet2;
    }

    public void setRemAnimalTutorSet2(Set<RemAnimalTutor> remAnimalTutorSet2) {
        this.remAnimalTutorSet2 = remAnimalTutorSet2;
    }

    public Set<RemAnimalTutor> getRemAnimalTutorSet4() {
        return remAnimalTutorSet4;
    }

    public void setRemAnimalTutorSet4(Set<RemAnimalTutor> remAnimalTutorSet4) {
        this.remAnimalTutorSet4 = remAnimalTutorSet4;
    }

    public Set<RemAnimalTutor> getRemAnimalTutorSet5() {
        return remAnimalTutorSet5;
    }

    public void setRemAnimalTutorSet5(Set<RemAnimalTutor> remAnimalTutorSet5) {
        this.remAnimalTutorSet5 = remAnimalTutorSet5;
    }

    public Set<RemAnimalTutor> getRemAnimalTutorSet6() {
        return remAnimalTutorSet6;
    }

    public void setRemAnimalTutorSet6(Set<RemAnimalTutor> remAnimalTutorSet6) {
        this.remAnimalTutorSet6 = remAnimalTutorSet6;
    }

    public Set<RemAnimalTutor> getRemAnimalTutorSet7() {
        return remAnimalTutorSet7;
    }

    public void setRemAnimalTutorSet7(Set<RemAnimalTutor> remAnimalTutorSet7) {
        this.remAnimalTutorSet7 = remAnimalTutorSet7;
    }

    public Set<RemAnimalTutor> getRemAnimalTutorSet8() {
        return remAnimalTutorSet8;
    }

    public void setRemAnimalTutorSet8(Set<RemAnimalTutor> remAnimalTutorSet8) {
        this.remAnimalTutorSet8 = remAnimalTutorSet8;
    }

    public Set<RemAnimalTutor> getRemAnimalTutorSet9() {
        return remAnimalTutorSet9;
    }

    public void setRemAnimalTutorSet9(Set<RemAnimalTutor> remAnimalTutorSet9) {
        this.remAnimalTutorSet9 = remAnimalTutorSet9;
    }

    public Set<RemAnimalTutor> getRemAnimalTutorSet10() {
        return remAnimalTutorSet10;
    }

    public void setRemAnimalTutorSet10(Set<RemAnimalTutor> remAnimalTutorSet10) {
        this.remAnimalTutorSet10 = remAnimalTutorSet10;
    }

    public Set<RemAnimalTutor> getRemAnimalTutorSet11() {
        return remAnimalTutorSet11;
    }

    public void setRemAnimalTutorSet11(Set<RemAnimalTutor> remAnimalTutorSet11) {
        this.remAnimalTutorSet11 = remAnimalTutorSet11;
    }

    public Set<RemAnimalTutor> getRemAnimalTutorSet12() {
        return remAnimalTutorSet12;
    }

    public void setRemAnimalTutorSet12(Set<RemAnimalTutor> remAnimalTutorSet12) {
        this.remAnimalTutorSet12 = remAnimalTutorSet12;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Set<RemComiteEticaDet> getRemComiteEticaDetSet() {
        return remComiteEticaDetSet;
    }

    public void setRemComiteEticaDetSet(Set<RemComiteEticaDet> remComiteEticaDetSet) {
        this.remComiteEticaDetSet = remComiteEticaDetSet;
    }

    public Set<RemRecepcionAnimales> getRemRecepcionAnimalesSet() {
        return remRecepcionAnimalesSet;
    }

    public void setRemRecepcionAnimalesSet(Set<RemRecepcionAnimales> remRecepcionAnimalesSet) {
        this.remRecepcionAnimalesSet = remRecepcionAnimalesSet;
    }

    public Set<RemRecepcionAnimales> getRemRecepcionAnimalesSet1() {
        return remRecepcionAnimalesSet1;
    }

    public void setRemRecepcionAnimalesSet1(Set<RemRecepcionAnimales> remRecepcionAnimalesSet1) {
        this.remRecepcionAnimalesSet1 = remRecepcionAnimalesSet1;
    }

    public Set<RemRecepcionAnimales> getRemRecepcionAnimalesSet2() {
        return remRecepcionAnimalesSet2;
    }

    public void setRemRecepcionAnimalesSet2(Set<RemRecepcionAnimales> remRecepcionAnimalesSet2) {
        this.remRecepcionAnimalesSet2 = remRecepcionAnimalesSet2;
    }

    public Set<RemRecepcionAnimales> getRemRecepcionAnimalesSet3() {
        return remRecepcionAnimalesSet3;
    }

    public void setRemRecepcionAnimalesSet3(Set<RemRecepcionAnimales> remRecepcionAnimalesSet3) {
        this.remRecepcionAnimalesSet3 = remRecepcionAnimalesSet3;
    }

    public Set<RemRecepcionAnimales> getRemRecepcionAnimalesSet4() {
        return remRecepcionAnimalesSet4;
    }

    public void setRemRecepcionAnimalesSet4(Set<RemRecepcionAnimales> remRecepcionAnimalesSet4) {
        this.remRecepcionAnimalesSet4 = remRecepcionAnimalesSet4;
    }

    public Set<RemRecepcionAnimales> getRemRecepcionAnimalesSet5() {
        return remRecepcionAnimalesSet5;
    }

    public void setRemRecepcionAnimalesSet5(Set<RemRecepcionAnimales> remRecepcionAnimalesSet5) {
        this.remRecepcionAnimalesSet5 = remRecepcionAnimalesSet5;
    }

    public Set<RemRecepcionAnimales> getRemRecepcionAnimalesSet6() {
        return remRecepcionAnimalesSet6;
    }

    public void setRemRecepcionAnimalesSet6(Set<RemRecepcionAnimales> remRecepcionAnimalesSet6) {
        this.remRecepcionAnimalesSet6 = remRecepcionAnimalesSet6;
    }

    public Set<RemRecepcionAnimales> getRemRecepcionAnimalesSet7() {
        return remRecepcionAnimalesSet7;
    }

    public void setRemRecepcionAnimalesSet7(Set<RemRecepcionAnimales> remRecepcionAnimalesSet7) {
        this.remRecepcionAnimalesSet7 = remRecepcionAnimalesSet7;
    }

    public Set<RemRecepcionAnimales> getRemRecepcionAnimalesSet8() {
        return remRecepcionAnimalesSet8;
    }

    public void setRemRecepcionAnimalesSet8(Set<RemRecepcionAnimales> remRecepcionAnimalesSet8) {
        this.remRecepcionAnimalesSet8 = remRecepcionAnimalesSet8;
    }

    public Set<RemRetiroAnimales> getRemRetiroAnimalesSet() {
        return remRetiroAnimalesSet;
    }

    public void setRemRetiroAnimalesSet(Set<RemRetiroAnimales> remRetiroAnimalesSet) {
        this.remRetiroAnimalesSet = remRetiroAnimalesSet;
    }

    public Set<RemRetiroAnimales> getRemRetiroAnimalesSet1() {
        return remRetiroAnimalesSet1;
    }

    public void setRemRetiroAnimalesSet1(Set<RemRetiroAnimales> remRetiroAnimalesSet1) {
        this.remRetiroAnimalesSet1 = remRetiroAnimalesSet1;
    }

    public Set<RemRetiroAnimales> getRemRetiroAnimalesSet2() {
        return remRetiroAnimalesSet2;
    }

    public void setRemRetiroAnimalesSet2(Set<RemRetiroAnimales> remRetiroAnimalesSet2) {
        this.remRetiroAnimalesSet2 = remRetiroAnimalesSet2;
    }

    public Set<RemRetiroAnimales> getRemRetiroAnimalesSet3() {
        return remRetiroAnimalesSet3;
    }

    public void setRemRetiroAnimalesSet3(Set<RemRetiroAnimales> remRetiroAnimalesSet3) {
        this.remRetiroAnimalesSet3 = remRetiroAnimalesSet3;
    }

    public Set<RemRetiroAnimales> getRemRetiroAnimalesSet4() {
        return remRetiroAnimalesSet4;
    }

    public void setRemRetiroAnimalesSet4(Set<RemRetiroAnimales> remRetiroAnimalesSet4) {
        this.remRetiroAnimalesSet4 = remRetiroAnimalesSet4;
    }

    public Set<RemEnfermedadesAnimales> getRemEnfermedadesAnimalesSet() {
        return remEnfermedadesAnimalesSet;
    }

    public void setRemEnfermedadesAnimalesSet(Set<RemEnfermedadesAnimales> remEnfermedadesAnimalesSet) {
        this.remEnfermedadesAnimalesSet = remEnfermedadesAnimalesSet;
    }

    public Set<RemAtencionAnimales> getRemAtencionAnimalesSet() {
        return remAtencionAnimalesSet;
    }

    public void setRemAtencionAnimalesSet(Set<RemAtencionAnimales> remAtencionAnimalesSet) {
        this.remAtencionAnimalesSet = remAtencionAnimalesSet;
    }

    public Set<RemAtencionAnimales> getRemAtencionAnimalesSet1() {
        return remAtencionAnimalesSet1;
    }

    public void setRemAtencionAnimalesSet1(Set<RemAtencionAnimales> remAtencionAnimalesSet1) {
        this.remAtencionAnimalesSet1 = remAtencionAnimalesSet1;
    }

    public Set<RemAtencionAnimales> getRemAtencionAnimalesSet2() {
        return remAtencionAnimalesSet2;
    }

    public void setRemAtencionAnimalesSet2(Set<RemAtencionAnimales> remAtencionAnimalesSet2) {
        this.remAtencionAnimalesSet2 = remAtencionAnimalesSet2;
    }

    public Set<RemTipoAnimalTutor> getRemTipoAnimalTutorSet() {
        return remTipoAnimalTutorSet;
    }

    public void setRemTipoAnimalTutorSet(Set<RemTipoAnimalTutor> remTipoAnimalTutorSet) {
        this.remTipoAnimalTutorSet = remTipoAnimalTutorSet;
    }

    public Set<RemMicrochipMascotaUba> getRemMicrochipMascotaUbaSet() {
        return remMicrochipMascotaUbaSet;
    }

    public void setRemMicrochipMascotaUbaSet(Set<RemMicrochipMascotaUba> remMicrochipMascotaUbaSet) {
        this.remMicrochipMascotaUbaSet = remMicrochipMascotaUbaSet;
    }

    public Set<RemAnimalTutor> getRemAnimalTutorSet3() {
        return remAnimalTutorSet3;
    }

    public void setRemAnimalTutorSet3(Set<RemAnimalTutor> remAnimalTutorSet3) {
        this.remAnimalTutorSet3 = remAnimalTutorSet3;
    }

    
    @Override
    public String toString() {
        return "RemCatalogo{" + "catalogoId=" + catalogoId + ", usuarioCreacion=" + usuarioCreacion + ", terminalCreacion=" + terminalCreacion + ", fechaCreacion=" + fechaCreacion + ", usuarioModificacion=" + usuarioModificacion + ", terminalModificacion=" + terminalModificacion + ", fechaModificacion=" + fechaModificacion + ", nombre=" + nombre + ", estado=" + estado + ", remRecepcionAnimalesSet=" + remRecepcionAnimalesSet + ", remRecepcionAnimalesSet1=" + remRecepcionAnimalesSet1 + ", remRecepcionAnimalesSet2=" + remRecepcionAnimalesSet2 + ", remRecepcionAnimalesSet3=" + remRecepcionAnimalesSet3 + ", remRecepcionAnimalesSet4=" + remRecepcionAnimalesSet4 + ", remRecepcionAnimalesSet5=" + remRecepcionAnimalesSet5 + ", remRecepcionAnimalesSet6=" + remRecepcionAnimalesSet6 + ", remRecepcionAnimalesSet7=" + remRecepcionAnimalesSet7 + ", remRecepcionAnimalesSet8=" + remRecepcionAnimalesSet8 + ", remRetiroAnimalesSet=" + remRetiroAnimalesSet + ", remRetiroAnimalesSet1=" + remRetiroAnimalesSet1 + ", remRetiroAnimalesSet2=" + remRetiroAnimalesSet2 + ", remRetiroAnimalesSet3=" + remRetiroAnimalesSet3 + ", remRetiroAnimalesSet4=" + remRetiroAnimalesSet4 + ", remTipoAnimalTutorSet=" + remTipoAnimalTutorSet + ", remComiteEticaDetSet=" + remComiteEticaDetSet + ", remEnfermedadesAnimalesSet=" + remEnfermedadesAnimalesSet + ", remAtencionAnimalesSet=" + remAtencionAnimalesSet + ", remAtencionAnimalesSet1=" + remAtencionAnimalesSet1 + ", remAtencionAnimalesSet2=" + remAtencionAnimalesSet2 + ", remMicrochipMascotaUbaSet=" + remMicrochipMascotaUbaSet + ", tipoCatalogoId=" + tipoCatalogoId + ", remPerfilSet=" + remPerfilSet + ", remAnalistaSet=" + remAnalistaSet + ", remUsuariosSet=" + remUsuariosSet + ", remUsuariosSet1=" + remUsuariosSet1 + ", remUsuariosSet2=" + remUsuariosSet2 + ", remUsuariosSet3=" + remUsuariosSet3 + ", remRegistroProfesional=" + remRegistroProfesional + ", remRegistroProfesionalEstado=" + remRegistroProfesionalEstado + ", remPerfilAcademicoSet=" + remPerfilAcademicoSet + ", remAnalisisTramiteRegistroProfesionalEstado=" + remAnalisisTramiteRegistroProfesionalEstado + ", remUsuarioPerfilSet=" + remUsuarioPerfilSet + ", remMicrochipMascotaSet=" + remMicrochipMascotaSet + ", remAnimalTutorSet=" + remAnimalTutorSet + ", remAnimalTutorSet1=" + remAnimalTutorSet1 + ", remAnimalTutorSet2=" + remAnimalTutorSet2 + ", remAnimalTutorSet3=" + remAnimalTutorSet3 + ", remAnimalTutorSet4=" + remAnimalTutorSet4 + ", remAnimalTutorSet5=" + remAnimalTutorSet5 + ", remAnimalTutorSet6=" + remAnimalTutorSet6 + ", remAnimalTutorSet7=" + remAnimalTutorSet7 + ", remAnimalTutorSet8=" + remAnimalTutorSet8 + ", remAnimalTutorSet9=" + remAnimalTutorSet9 + ", remAnimalTutorSet10=" + remAnimalTutorSet10 + ", remAnimalTutorSet11=" + remAnimalTutorSet11 + ", remAnimalTutorSet12=" + remAnimalTutorSet12 + '}';
    }


}
