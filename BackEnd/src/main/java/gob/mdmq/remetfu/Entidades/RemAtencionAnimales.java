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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author oportero
 */
@Entity
@Table(name = "REM_ATENCION_ANIMALES", catalog = "MDMQ_REMETFU", schema = "Remetfu")
@NamedQueries({
    @NamedQuery(name = "RemAtencionAnimales.findAll", query = "SELECT r FROM RemAtencionAnimales r"),
    @NamedQuery(name = "RemAtencionAnimales.findByAtencionAnimalesId", query = "SELECT r FROM RemAtencionAnimales r WHERE r.atencionAnimalesId = :atencionAnimalesId"),
    @NamedQuery(name = "RemAtencionAnimales.findByNombreAnimal", query = "SELECT r FROM RemAtencionAnimales r WHERE r.nombreAnimal = :nombreAnimal"),
    @NamedQuery(name = "RemAtencionAnimales.findByFechaNacimiento", query = "SELECT r FROM RemAtencionAnimales r WHERE r.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "RemAtencionAnimales.findByFechaRegistro", query = "SELECT r FROM RemAtencionAnimales r WHERE r.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "RemAtencionAnimales.findByEstado", query = "SELECT r FROM RemAtencionAnimales r WHERE r.estado = :estado"),
    @NamedQuery(name = "RemAtencionAnimales.findByUsuarioCreacion", query = "SELECT r FROM RemAtencionAnimales r WHERE r.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "RemAtencionAnimales.findByTerminalCreacion", query = "SELECT r FROM RemAtencionAnimales r WHERE r.terminalCreacion = :terminalCreacion"),
    @NamedQuery(name = "RemAtencionAnimales.findByFechaCreacion", query = "SELECT r FROM RemAtencionAnimales r WHERE r.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "RemAtencionAnimales.findByUsuarioModificacion", query = "SELECT r FROM RemAtencionAnimales r WHERE r.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "RemAtencionAnimales.findByTerminalModificacion", query = "SELECT r FROM RemAtencionAnimales r WHERE r.terminalModificacion = :terminalModificacion"),
    @NamedQuery(name = "RemAtencionAnimales.findByFechaModificacion", query = "SELECT r FROM RemAtencionAnimales r WHERE r.fechaModificacion = :fechaModificacion")})
public class RemAtencionAnimales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ATENCION_ANIMALES_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long atencionAnimalesId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(nullable = false, length = 300)
    private String observaciones;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE_ANIMAL", nullable = false, length = 100)
    private String nombreAnimal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_NACIMIENTO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;

    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_REGISTRO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(nullable = false, length = 3)
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USUARIO_CREACION", nullable = false, length = 30)
    private String usuarioCreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TERMINAL_CREACION", nullable = false, length = 30)
    private String terminalCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CREACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USUARIO_MODIFICACION", nullable = false, length = 30)
    private String usuarioModificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TERMINAL_MODIFICACION", nullable = false, length = 30)
    private String terminalModificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_MODIFICACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "atencionAnimalesId", fetch = FetchType.LAZY)
    private Set<RemEnfermedadesAnimales> remEnfermedadesAnimalesSet;

    @JoinColumn(name = "IDENTIFICACION_FOTOGRAFICA1", referencedColumnName = "ARCHIVO_ID")
    @JsonBackReference("identificacionFotografica1")
    @ManyToOne(fetch = FetchType.LAZY)
    private RemArchivos identificacionFotografica1;

    @JoinColumn(name = "IDENTIFICACION_FOTOGRAFICA2", referencedColumnName = "ARCHIVO_ID")
    @JsonBackReference("identificacionFotografica2")
    @ManyToOne(fetch = FetchType.LAZY)
    private RemArchivos identificacionFotografica2;

    @JoinColumn(name = "IDENTIFICACION_VISIBLE", referencedColumnName = "ARCHIVO_ID")
    @JsonBackReference("identificacionVisible")
    @ManyToOne(fetch = FetchType.LAZY)
    private RemArchivos identificacionVisible;

    @JoinColumn(name = "ESTADO_CHEQUEO", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("estadoChequeo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo estadoChequeo;

    @JoinColumn(name = "ATENCION_REALIZADA", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("atencionRealizada")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo atencionRealizada;

    @JoinColumn(name = "TIPO_IDENTIFICACION_VISIBLE", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("tipoIdentificacionVisible")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo tipoIdentificacionVisible;

    @JoinColumn(name = "MICROCHIP_MASCOTA_ID", referencedColumnName = "MICROCHIP_MASCOTA_ID")
    @JsonBackReference("microchipMascotaIdDatos")
    @ManyToOne(fetch = FetchType.LAZY)
    private RemMicrochipMascota microchipMascotaId;

    @JoinColumn(name = "FUNCIONARIO_UBA", referencedColumnName = "USUARIO_ID", nullable = false)
    @JsonBackReference("funcionarioUba")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemUsuarios funcionarioUba;

    public RemAtencionAnimales() {
    }

    public RemAtencionAnimales(Long atencionAnimalesId, String observaciones, String estado, String nombreAnimal, Date fechaNacimiento, Date fechaRegistro, String usuarioCreacion, String terminalCreacion, Date fechaCreacion, String usuarioModificacion, String terminalModificacion, Date fechaModificacion, RemArchivos identificacionFotografica1, RemArchivos identificacionFotografica2, RemArchivos identificacionVisible, RemCatalogo estadoChequeo, RemCatalogo atencionRealizada, RemCatalogo tipoIdentificacionVisible, RemMicrochipMascota microchipMascotaId, RemUsuarios funcionarioUba) {
        this.atencionAnimalesId = atencionAnimalesId;
        this.observaciones = observaciones;
        this.estado = estado;
        this.nombreAnimal = nombreAnimal;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = fechaRegistro;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.terminalModificacion = terminalModificacion;
        this.fechaModificacion = fechaModificacion;
        this.identificacionFotografica1 = identificacionFotografica1;
        this.identificacionFotografica2 = identificacionFotografica2;
        this.identificacionVisible = identificacionVisible;
        this.estadoChequeo = estadoChequeo;
        this.atencionRealizada = atencionRealizada;
        this.tipoIdentificacionVisible = tipoIdentificacionVisible;
        this.microchipMascotaId = microchipMascotaId;
        this.funcionarioUba = funcionarioUba;
    }

    public Long getAtencionAnimalesId() {
        return atencionAnimalesId;
    }

    public void setAtencionAnimalesId(Long atencionAnimalesId) {
        this.atencionAnimalesId = atencionAnimalesId;
    }

    public String getNombreAnimal() {
        return nombreAnimal;
    }

    public void setNombreAnimal(String nombreAnimal) {
        this.nombreAnimal = nombreAnimal;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public Set<RemEnfermedadesAnimales> getRemEnfermedadesAnimalesSet() {
        return remEnfermedadesAnimalesSet;
    }

    public void setRemEnfermedadesAnimalesSet(Set<RemEnfermedadesAnimales> remEnfermedadesAnimalesSet) {
        this.remEnfermedadesAnimalesSet = remEnfermedadesAnimalesSet;
    }

    public RemArchivos getIdentificacionFotografica1() {
        return identificacionFotografica1;
    }

    public void setIdentificacionFotografica1(RemArchivos identificacionFotografica1) {
        this.identificacionFotografica1 = identificacionFotografica1;
    }

    public RemArchivos getIdentificacionFotografica2() {
        return identificacionFotografica2;
    }

    public void setIdentificacionFotografica2(RemArchivos identificacionFotografica2) {
        this.identificacionFotografica2 = identificacionFotografica2;
    }

    public RemArchivos getIdentificacionVisible() {
        return identificacionVisible;
    }

    public void setIdentificacionVisible(RemArchivos identificacionVisible) {
        this.identificacionVisible = identificacionVisible;
    }

    public RemCatalogo getEstadoChequeo() {
        return estadoChequeo;
    }

    public void setEstadoChequeo(RemCatalogo estadoChequeo) {
        this.estadoChequeo = estadoChequeo;
    }

    public RemCatalogo getAtencionRealizada() {
        return atencionRealizada;
    }

    public void setAtencionRealizada(RemCatalogo atencionRealizada) {
        this.atencionRealizada = atencionRealizada;
    }

    public RemCatalogo getTipoIdentificacionVisible() {
        return tipoIdentificacionVisible;
    }

    public void setTipoIdentificacionVisible(RemCatalogo tipoIdentificacionVisible) {
        this.tipoIdentificacionVisible = tipoIdentificacionVisible;
    }

    public RemMicrochipMascota getMicrochipMascotaId() {
        return microchipMascotaId;
    }

    public void setMicrochipMascotaId(RemMicrochipMascota microchipMascotaId) {
        this.microchipMascotaId = microchipMascotaId;
    }

    public RemUsuarios getFuncionarioUba() {
        return funcionarioUba;
    }

    public void setFuncionarioUba(RemUsuarios funcionarioUba) {
        this.funcionarioUba = funcionarioUba;
    }

    @Override
    public String toString() {
        return "RemAtencionAnimales{" + "atencionAnimalesId=" + atencionAnimalesId + ", observaciones=" + observaciones + ", estado=" + estado + ", nombreAnimal=" + nombreAnimal + ", fechaNacimiento=" + fechaNacimiento + ", fechaRegistro=" + fechaRegistro + ", usuarioCreacion=" + usuarioCreacion + ", terminalCreacion=" + terminalCreacion + ", fechaCreacion=" + fechaCreacion + ", usuarioModificacion=" + usuarioModificacion + ", terminalModificacion=" + terminalModificacion + ", fechaModificacion=" + fechaModificacion + ", remEnfermedadesAnimalesSet=" + remEnfermedadesAnimalesSet + ", identificacionFotografica1=" + identificacionFotografica1 + ", identificacionFotografica2=" + identificacionFotografica2 + ", identificacionVisible=" + identificacionVisible + ", estadoChequeo=" + estadoChequeo + ", atencionRealizada=" + atencionRealizada + ", tipoIdentificacionVisible=" + tipoIdentificacionVisible + ", microchipMascotaId=" + microchipMascotaId + ", funcionarioUba=" + funcionarioUba + '}';
    }

}
