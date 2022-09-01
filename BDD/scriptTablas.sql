USE [MDMQ_REMETFU]
GO

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL') and o.name = 'REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL_FKY01')
alter table Remetfu.REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL
   drop constraint REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL_FKY01
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL') and o.name = 'REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL_FKY02')
alter table Remetfu.REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL
   drop constraint REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL_FKY02
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL') and o.name = 'REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL_FKY03')
alter table Remetfu.REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL
   drop constraint REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL_FKY03
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ANALISTA') and o.name = 'REM_ANALISTA_FKY01')
alter table Remetfu.REM_ANALISTA
   drop constraint REM_ANALISTA_FKY01
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ANALISTA') and o.name = 'REM_ANALISTA_FKY02')
alter table Remetfu.REM_ANALISTA
   drop constraint REM_ANALISTA_FKY02
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ANALISTA') and o.name = 'REM_ANALISTA_FKY03')
alter table Remetfu.REM_ANALISTA
   drop constraint REM_ANALISTA_FKY03
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ANIMAL_TUTOR') and o.name = 'REM_ANIMAL_TUTOR_FKY01')
alter table Remetfu.REM_ANIMAL_TUTOR
   drop constraint REM_ANIMAL_TUTOR_FKY01
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ANIMAL_TUTOR') and o.name = 'REM_ANIMAL_TUTOR_FKY02')
alter table Remetfu.REM_ANIMAL_TUTOR
   drop constraint REM_ANIMAL_TUTOR_FKY02
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ANIMAL_TUTOR') and o.name = 'REM_ANIMAL_TUTOR_FKY03')
alter table Remetfu.REM_ANIMAL_TUTOR
   drop constraint REM_ANIMAL_TUTOR_FKY03
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ANIMAL_TUTOR') and o.name = 'REM_ANIMAL_TUTOR_FKY05')
alter table Remetfu.REM_ANIMAL_TUTOR
   drop constraint REM_ANIMAL_TUTOR_FKY05
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ANIMAL_TUTOR') and o.name = 'REM_ANIMAL_TUTOR_FKY06')
alter table Remetfu.REM_ANIMAL_TUTOR
   drop constraint REM_ANIMAL_TUTOR_FKY06
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ANIMAL_TUTOR') and o.name = 'REM_ANIMAL_TUTOR_FKY07')
alter table Remetfu.REM_ANIMAL_TUTOR
   drop constraint REM_ANIMAL_TUTOR_FKY07
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ANIMAL_TUTOR') and o.name = 'REM_ANIMAL_TUTOR_FKY08')
alter table Remetfu.REM_ANIMAL_TUTOR
   drop constraint REM_ANIMAL_TUTOR_FKY08
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ANIMAL_TUTOR') and o.name = 'REM_ANIMAL_TUTOR_FKY09')
alter table Remetfu.REM_ANIMAL_TUTOR
   drop constraint REM_ANIMAL_TUTOR_FKY09
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ANIMAL_TUTOR') and o.name = 'REM_ANIMAL_TUTOR_FKY10')
alter table Remetfu.REM_ANIMAL_TUTOR
   drop constraint REM_ANIMAL_TUTOR_FKY10
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ANIMAL_TUTOR') and o.name = 'REM_ANIMAL_TUTOR_FKY11')
alter table Remetfu.REM_ANIMAL_TUTOR
   drop constraint REM_ANIMAL_TUTOR_FKY11
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ANIMAL_TUTOR') and o.name = 'REM_ANIMAL_TUTOR_FKY12')
alter table Remetfu.REM_ANIMAL_TUTOR
   drop constraint REM_ANIMAL_TUTOR_FKY12
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ANIMAL_TUTOR') and o.name = 'REM_ANIMAL_TUTOR_FKY13')
alter table Remetfu.REM_ANIMAL_TUTOR
   drop constraint REM_ANIMAL_TUTOR_FKY13
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ANIMAL_TUTOR') and o.name = 'REM_ANIMAL_TUTOR_FKY14')
alter table Remetfu.REM_ANIMAL_TUTOR
   drop constraint REM_ANIMAL_TUTOR_FKY14
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ANIMAL_TUTOR') and o.name = 'REM_ANIMAL_TUTOR_FKY15')
alter table Remetfu.REM_ANIMAL_TUTOR
   drop constraint REM_ANIMAL_TUTOR_FKY15
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ANIMAL_TUTOR') and o.name = 'REM_ANIMAL_TUTOR_FKY16')
alter table Remetfu.REM_ANIMAL_TUTOR
   drop constraint REM_ANIMAL_TUTOR_FKY16
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ANIMAL_TUTOR') and o.name = 'REM_ANIMAL_TUTOR_FKY17')
alter table Remetfu.REM_ANIMAL_TUTOR
   drop constraint REM_ANIMAL_TUTOR_FKY17
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ANIMAL_TUTOR') and o.name = 'REM_ANIMAL_TUTOR_FKY19')
alter table Remetfu.REM_ANIMAL_TUTOR
   drop constraint REM_ANIMAL_TUTOR_FKY19
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ANIMAL_TUTOR') and o.name = 'REM_ANIMAL_TUTOR_FKY20')
alter table Remetfu.REM_ANIMAL_TUTOR
   drop constraint REM_ANIMAL_TUTOR_FKY20
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ANIMAL_TUTOR') and o.name = 'REM_ANIMAL_TUTOR_FKY21')
alter table Remetfu.REM_ANIMAL_TUTOR
   drop constraint REM_ANIMAL_TUTOR_FKY21
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ANIMAL_TUTOR') and o.name = 'REM_ANIMAL_TUTOR_FKY22')
alter table Remetfu.REM_ANIMAL_TUTOR
   drop constraint REM_ANIMAL_TUTOR_FKY22
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ANIMAL_TUTOR') and o.name = 'REM_ANIMAL_TUTOR_FKY23')
alter table Remetfu.REM_ANIMAL_TUTOR
   drop constraint REM_ANIMAL_TUTOR_FKY23
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ANIMAL_TUTOR') and o.name = 'REM_ANIMAL_TUTOR_FKY24')
alter table Remetfu.REM_ANIMAL_TUTOR
   drop constraint REM_ANIMAL_TUTOR_FKY24
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ANIMAL_TUTOR') and o.name = 'REM_ANIMAL_TUTOR_FKY25')
alter table Remetfu.REM_ANIMAL_TUTOR
   drop constraint REM_ANIMAL_TUTOR_FKY25
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ATENCION_ANIMALES') and o.name = 'REM_ATENCION_ANIMALES_FKY01')
alter table Remetfu.REM_ATENCION_ANIMALES
   drop constraint REM_ATENCION_ANIMALES_FKY01
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ATENCION_ANIMALES') and o.name = 'REM_ATENCION_ANIMALES_FKY02')
alter table Remetfu.REM_ATENCION_ANIMALES
   drop constraint REM_ATENCION_ANIMALES_FKY02
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ATENCION_ANIMALES') and o.name = 'REM_ATENCION_ANIMALES_FKY03')
alter table Remetfu.REM_ATENCION_ANIMALES
   drop constraint REM_ATENCION_ANIMALES_FKY03
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ATENCION_ANIMALES') and o.name = 'REM_ATENCION_ANIMALES_FKY04')
alter table Remetfu.REM_ATENCION_ANIMALES
   drop constraint REM_ATENCION_ANIMALES_FKY04
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ATENCION_ANIMALES') and o.name = 'REM_ATENCION_ANIMALES_FKY05')
alter table Remetfu.REM_ATENCION_ANIMALES
   drop constraint REM_ATENCION_ANIMALES_FKY05
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ATENCION_ANIMALES') and o.name = 'REM_ATENCION_ANIMALES_FKY06')
alter table Remetfu.REM_ATENCION_ANIMALES
   drop constraint REM_ATENCION_ANIMALES_FKY06
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ATENCION_ANIMALES') and o.name = 'REM_ATENCION_ANIMALES_FKY07')
alter table Remetfu.REM_ATENCION_ANIMALES
   drop constraint REM_ATENCION_ANIMALES_FKY07
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ATENCION_ANIMALES') and o.name = 'REM_ATENCION_ANIMALES_FKY08')
alter table Remetfu.REM_ATENCION_ANIMALES
   drop constraint REM_ATENCION_ANIMALES_FKY08
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_CATALOGO') and o.name = 'REM_CATALOGO_FKY01')
alter table Remetfu.REM_CATALOGO
   drop constraint REM_CATALOGO_FKY01
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_COMITE_ETICA_DET') and o.name = 'REM_COMITE_ETICA_DET_FKY01')
alter table Remetfu.REM_COMITE_ETICA_DET
   drop constraint REM_COMITE_ETICA_DET_FKY01
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_COMITE_ETICA_DET') and o.name = 'REM_COMITE_ETICA_DET_FKY03')
alter table Remetfu.REM_COMITE_ETICA_DET
   drop constraint REM_COMITE_ETICA_DET_FKY03
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_CONTROL_ACCESO') and o.name = 'REM_CONTROL_ACCESO_FKY01')
alter table Remetfu.REM_CONTROL_ACCESO
   drop constraint REM_CONTROL_ACCESO_FKY01
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ENFERMEDADES_ANIMALES') and o.name = 'REM_ENFERMEDADES_ANIMALES_FKY01')
alter table Remetfu.REM_ENFERMEDADES_ANIMALES
   drop constraint REM_ENFERMEDADES_ANIMALES_FKY01
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ENFERMEDADES_ANIMALES') and o.name = 'REM_ENFERMEDADES_ANIMALES_FKY02')
alter table Remetfu.REM_ENFERMEDADES_ANIMALES
   drop constraint REM_ENFERMEDADES_ANIMALES_FKY02
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_MENU') and o.name = 'REM_MENU_FKY01')
alter table Remetfu.REM_MENU
   drop constraint REM_MENU_FKY01
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_MENU_PERFIL') and o.name = 'REM_MENU_PERFIL_FKY01')
alter table Remetfu.REM_MENU_PERFIL
   drop constraint REM_MENU_PERFIL_FKY01
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_MENU_PERFIL') and o.name = 'REM_MENU_PERFIL_FKY02')
alter table Remetfu.REM_MENU_PERFIL
   drop constraint REM_MENU_PERFIL_FKY02
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_MICROCHIP_MASCOTA') and o.name = 'REM_MICROCHIP_MASCOTA_FKY01')
alter table Remetfu.REM_MICROCHIP_MASCOTA
   drop constraint REM_MICROCHIP_MASCOTA_FKY01
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_MICROCHIP_MASCOTA') and o.name = 'REM_MICROCHIP_MASCOTA_FKY02')
alter table Remetfu.REM_MICROCHIP_MASCOTA
   drop constraint REM_MICROCHIP_MASCOTA_FKY02
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_MICROCHIP_MASCOTA') and o.name = 'REM_MICROCHIP_MASCOTA_FKY03')
alter table Remetfu.REM_MICROCHIP_MASCOTA
   drop constraint REM_MICROCHIP_MASCOTA_FKY03
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_NOMENCLATURA') and o.name = 'REM_NOMENCLATURA_FKY01')
alter table Remetfu.REM_NOMENCLATURA
   drop constraint REM_NOMENCLATURA_FKY01
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ORDENES_PAGO') and o.name = 'REM_ORDENES_PAGO_FKY01')
alter table Remetfu.REM_ORDENES_PAGO
   drop constraint REM_ORDENES_PAGO_FKY01
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_ORDENES_PAGO') and o.name = 'REM_ORDENES_PAGO_FKY02')
alter table Remetfu.REM_ORDENES_PAGO
   drop constraint REM_ORDENES_PAGO_FKY02
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_PERFIL') and o.name = 'REM_PERFIL_FKY01')
alter table Remetfu.REM_PERFIL
   drop constraint REM_PERFIL_FKY01
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_PERFIL_ACADEMICO') and o.name = 'REM_PERFIL_ACADEMICO_FKY01')
alter table Remetfu.REM_PERFIL_ACADEMICO
   drop constraint REM_PERFIL_ACADEMICO_FKY01
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_PERFIL_ACADEMICO') and o.name = 'REM_PERFIL_ACADEMICO_FKY02')
alter table Remetfu.REM_PERFIL_ACADEMICO
   drop constraint REM_PERFIL_ACADEMICO_FKY02
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_RECEPCION_ANIMALES') and o.name = 'REM_RECEPCION_ANIMALES_FKY01')
alter table Remetfu.REM_RECEPCION_ANIMALES
   drop constraint REM_RECEPCION_ANIMALES_FKY01
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_RECEPCION_ANIMALES') and o.name = 'REM_RECEPCION_ANIMALES_FKY02')
alter table Remetfu.REM_RECEPCION_ANIMALES
   drop constraint REM_RECEPCION_ANIMALES_FKY02
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_RECEPCION_ANIMALES') and o.name = 'REM_RECEPCION_ANIMALES_FKY03')
alter table Remetfu.REM_RECEPCION_ANIMALES
   drop constraint REM_RECEPCION_ANIMALES_FKY03
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_RECEPCION_ANIMALES') and o.name = 'REM_RECEPCION_ANIMALES_FKY04')
alter table Remetfu.REM_RECEPCION_ANIMALES
   drop constraint REM_RECEPCION_ANIMALES_FKY04
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_RECEPCION_ANIMALES') and o.name = 'REM_RECEPCION_ANIMALES_FKY05')
alter table Remetfu.REM_RECEPCION_ANIMALES
   drop constraint REM_RECEPCION_ANIMALES_FKY05
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_RECEPCION_ANIMALES') and o.name = 'REM_RECEPCION_ANIMALES_FKY06')
alter table Remetfu.REM_RECEPCION_ANIMALES
   drop constraint REM_RECEPCION_ANIMALES_FKY06
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_RECEPCION_ANIMALES') and o.name = 'REM_RECEPCION_ANIMALES_FKY07')
alter table Remetfu.REM_RECEPCION_ANIMALES
   drop constraint REM_RECEPCION_ANIMALES_FKY07
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_RECEPCION_ANIMALES') and o.name = 'REM_RECEPCION_ANIMALES_FKY08')
alter table Remetfu.REM_RECEPCION_ANIMALES
   drop constraint REM_RECEPCION_ANIMALES_FKY08
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_RECEPCION_ANIMALES') and o.name = 'REM_RECEPCION_ANIMALES_FKY09')
alter table Remetfu.REM_RECEPCION_ANIMALES
   drop constraint REM_RECEPCION_ANIMALES_FKY09
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_RECEPCION_ANIMALES') and o.name = 'REM_RECEPCION_ANIMALES_FKY10')
alter table Remetfu.REM_RECEPCION_ANIMALES
   drop constraint REM_RECEPCION_ANIMALES_FKY10
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_REGISTRO_PROFESIONAL') and o.name = 'REM_REGISTRO_PROFESIONAL_FKY01')
alter table Remetfu.REM_REGISTRO_PROFESIONAL
   drop constraint REM_REGISTRO_PROFESIONAL_FKY01
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_REGISTRO_PROFESIONAL') and o.name = 'REM_REGISTRO_PROFESIONAL_FKY02')
alter table Remetfu.REM_REGISTRO_PROFESIONAL
   drop constraint REM_REGISTRO_PROFESIONAL_FKY02
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_REGISTRO_PROFESIONAL') and o.name = 'REM_REGISTRO_PROFESIONAL_FKY03')
alter table Remetfu.REM_REGISTRO_PROFESIONAL
   drop constraint REM_REGISTRO_PROFESIONAL_FKY03
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_REGISTRO_PROFESIONAL') and o.name = 'REM_REGISTRO_PROFESIONAL_FKY04')
alter table Remetfu.REM_REGISTRO_PROFESIONAL
   drop constraint REM_REGISTRO_PROFESIONAL_FKY04
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_REGISTRO_PROFESIONAL') and o.name = 'REM_REGISTRO_PROFESIONAL_FKY05')
alter table Remetfu.REM_REGISTRO_PROFESIONAL
   drop constraint REM_REGISTRO_PROFESIONAL_FKY05
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_RETIRO_ANIMALES') and o.name = 'REM_RETIRO_ANIMALES_FKY02')
alter table Remetfu.REM_RETIRO_ANIMALES
   drop constraint REM_RETIRO_ANIMALES_FKY02
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_RETIRO_ANIMALES') and o.name = 'REM_RETIRO_ANIMALES_FKY03')
alter table Remetfu.REM_RETIRO_ANIMALES
   drop constraint REM_RETIRO_ANIMALES_FKY03
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_RETIRO_ANIMALES') and o.name = 'REM_RETIRO_ANIMALES_FKY04')
alter table Remetfu.REM_RETIRO_ANIMALES
   drop constraint REM_RETIRO_ANIMALES_FKY04
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_RETIRO_ANIMALES') and o.name = 'REM_RETIRO_ANIMALES_FKY05')
alter table Remetfu.REM_RETIRO_ANIMALES
   drop constraint REM_RETIRO_ANIMALES_FKY05
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_RETIRO_ANIMALES') and o.name = 'REM_RETIRO_ANIMALES_FKY06')
alter table Remetfu.REM_RETIRO_ANIMALES
   drop constraint REM_RETIRO_ANIMALES_FKY06
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_RETIRO_ANIMALES') and o.name = 'REM_RETIRO_ANIMALES_FKY07')
alter table Remetfu.REM_RETIRO_ANIMALES
   drop constraint REM_RETIRO_ANIMALES_FKY07
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_RETIRO_ANIMALES') and o.name = 'REM_RETIRO_ANIMALES_FKY08')
alter table Remetfu.REM_RETIRO_ANIMALES
   drop constraint REM_RETIRO_ANIMALES_FKY08
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_RUBROS_SAO') and o.name = 'REM_RUBROS_SAO_FKY03')
alter table Remetfu.REM_RUBROS_SAO
   drop constraint REM_RUBROS_SAO_FKY03
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_SUBTIPO_REGISTRO') and o.name = 'REM_SUBTIPO_REGISTRO_FKY01')
alter table Remetfu.REM_SUBTIPO_REGISTRO
   drop constraint REM_SUBTIPO_REGISTRO_FKY01
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_TIPO_ANIMAL_TUTOR') and o.name = 'REM_TIPO_ANIMAL_TUTOR_FKY01')
alter table Remetfu.REM_TIPO_ANIMAL_TUTOR
   drop constraint REM_TIPO_ANIMAL_TUTOR_FKY01
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_TIPO_ANIMAL_TUTOR') and o.name = 'REM_TIPO_ANIMAL_TUTOR_FKY02')
alter table Remetfu.REM_TIPO_ANIMAL_TUTOR
   drop constraint REM_TIPO_ANIMAL_TUTOR_FKY02
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_TIPO_ANIMAL_TUTOR') and o.name = 'REM_TIPO_ANIMAL_TUTOR_FKY03')
alter table Remetfu.REM_TIPO_ANIMAL_TUTOR
   drop constraint REM_TIPO_ANIMAL_TUTOR_FKY03
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_TITULO_PROFESIONAL') and o.name = 'REM_TITULO_PROFESIONAL_FKY01')
alter table Remetfu.REM_TITULO_PROFESIONAL
   drop constraint REM_TITULO_PROFESIONAL_FKY01
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_TRAMITE_REASIGNACION') and o.name = 'REM_TRAMITE_REASIGNACION_FKY01')
alter table Remetfu.REM_TRAMITE_REASIGNACION
   drop constraint REM_TRAMITE_REASIGNACION_FKY01
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_TRAMITE_REASIGNACION') and o.name = 'REM_TRAMITE_REASIGNACION_FKY02')
alter table Remetfu.REM_TRAMITE_REASIGNACION
   drop constraint REM_TRAMITE_REASIGNACION_FKY02
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_TRAMITE_REGISTRO_PROFESIONAL') and o.name = 'FK82wfr3y4vrogt4ghek12t5ksq')
alter table Remetfu.REM_TRAMITE_REGISTRO_PROFESIONAL
   drop constraint FK82wfr3y4vrogt4ghek12t5ksq
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_TUTORES_COMUNITARIOS') and o.name = 'REM_TUTORES_COMUNITARIOS_FKY01')
alter table Remetfu.REM_TUTORES_COMUNITARIOS
   drop constraint REM_TUTORES_COMUNITARIOS_FKY01
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_TUTORES_COMUNITARIOS') and o.name = 'REM_TUTORES_COMUNITARIOS_FKY02')
alter table Remetfu.REM_TUTORES_COMUNITARIOS
   drop constraint REM_TUTORES_COMUNITARIOS_FKY02
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_TUTOR_MASCOTA') and o.name = 'REM_TUTOR_MASCOTA_FKY01')
alter table Remetfu.REM_TUTOR_MASCOTA
   drop constraint REM_TUTOR_MASCOTA_FKY01
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_USUARIOS') and o.name = 'REM_USUARIOS_FKY01')
alter table Remetfu.REM_USUARIOS
   drop constraint REM_USUARIOS_FKY01
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_USUARIOS') and o.name = 'REM_USUARIOS_FKY02')
alter table Remetfu.REM_USUARIOS
   drop constraint REM_USUARIOS_FKY02
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_USUARIOS') and o.name = 'REM_USUARIOS_FKY03')
alter table Remetfu.REM_USUARIOS
   drop constraint REM_USUARIOS_FKY03
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_USUARIOS') and o.name = 'REM_USUARIOS_FKY04')
alter table Remetfu.REM_USUARIOS
   drop constraint REM_USUARIOS_FKY04
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_USUARIO_PERFIL') and o.name = 'REM_USUARIO_PERFIL_FKY01')
alter table Remetfu.REM_USUARIO_PERFIL
   drop constraint REM_USUARIO_PERFIL_FKY01
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_USUARIO_PERFIL') and o.name = 'REM_USUARIO_PERFIL_FKY02')
alter table Remetfu.REM_USUARIO_PERFIL
   drop constraint REM_USUARIO_PERFIL_FKY02
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Remetfu.REM_USUARIO_PERFIL') and o.name = 'REM_USUARIO_PERFIL_FKY03')
alter table Remetfu.REM_USUARIO_PERFIL
   drop constraint REM_USUARIO_PERFIL_FKY03
go

--if exists (select 1
--            from  sysindexes
--           where  id    = object_id('Remetfu.REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL')
--            and   name  = 'REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL_UNQ01'
--            and   indid > 0
--            and   indid < 255)
--   drop index Remetfu.REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL.REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL_UNQ01
--go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL')
            and   type = 'U')
   drop table Remetfu.REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_ANALISTA')
            and   type = 'U')
   drop table Remetfu.REM_ANALISTA
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_ANIMAL_TUTOR')
            and   type = 'U')
   drop table Remetfu.REM_ANIMAL_TUTOR
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_ARCHIVOS')
            and   type = 'U')
   drop table Remetfu.REM_ARCHIVOS
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_ATENCION_ANIMALES')
            and   type = 'U')
   drop table Remetfu.REM_ATENCION_ANIMALES
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_CATALOGO')
            and   type = 'U')
   drop table Remetfu.REM_CATALOGO
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_COMITE_ETICA_CAB')
            and   type = 'U')
   drop table Remetfu.REM_COMITE_ETICA_CAB
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_COMITE_ETICA_DET')
            and   type = 'U')
   drop table Remetfu.REM_COMITE_ETICA_DET
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_CONTROL_ACCESO')
            and   type = 'U')
   drop table Remetfu.REM_CONTROL_ACCESO
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_ENFERMEDADES_ANIMALES')
            and   type = 'U')
   drop table Remetfu.REM_ENFERMEDADES_ANIMALES
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_FERIADOS')
            and   type = 'U')
   drop table Remetfu.REM_FERIADOS
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_MENU')
            and   type = 'U')
   drop table Remetfu.REM_MENU
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_MENU_CABECERA')
            and   type = 'U')
   drop table Remetfu.REM_MENU_CABECERA
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_MENU_PERFIL')
            and   type = 'U')
   drop table Remetfu.REM_MENU_PERFIL
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_MICROCHIP_MASCOTA')
            and   type = 'U')
   drop table Remetfu.REM_MICROCHIP_MASCOTA
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_NOMENCLATURA')
            and   type = 'U')
   drop table Remetfu.REM_NOMENCLATURA
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_ORDENES_PAGO')
            and   type = 'U')
   drop table Remetfu.REM_ORDENES_PAGO
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_PARAMETROS')
            and   type = 'U')
   drop table Remetfu.REM_PARAMETROS
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_PERFIL')
            and   type = 'U')
   drop table Remetfu.REM_PERFIL
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_PERFIL_ACADEMICO')
            and   type = 'U')
   drop table Remetfu.REM_PERFIL_ACADEMICO
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_RECEPCION_ANIMALES')
            and   type = 'U')
   drop table Remetfu.REM_RECEPCION_ANIMALES
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_REGISTRO_PROFESIONAL')
            and   type = 'U')
   drop table Remetfu.REM_REGISTRO_PROFESIONAL
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_REMETFU')
            and   type = 'U')
   drop table Remetfu.REM_REMETFU
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_RETIRO_ANIMALES')
            and   type = 'U')
   drop table Remetfu.REM_RETIRO_ANIMALES
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_RUBROS_SAO')
            and   type = 'U')
   drop table Remetfu.REM_RUBROS_SAO
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_SECUENCIAL')
            and   type = 'U')
   drop table Remetfu.REM_SECUENCIAL
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_SUBTIPO_REGISTRO')
            and   type = 'U')
   drop table Remetfu.REM_SUBTIPO_REGISTRO
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_TIPO_ANIMAL_TUTOR')
            and   type = 'U')
   drop table Remetfu.REM_TIPO_ANIMAL_TUTOR
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_TIPO_CATALOGO')
            and   type = 'U')
   drop table Remetfu.REM_TIPO_CATALOGO
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_TIPO_REGISTRO')
            and   type = 'U')
   drop table Remetfu.REM_TIPO_REGISTRO
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_TITULO_PROFESIONAL')
            and   type = 'U')
   drop table Remetfu.REM_TITULO_PROFESIONAL
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_TRAMITE_REASIGNACION')
            and   type = 'U')
   drop table Remetfu.REM_TRAMITE_REASIGNACION
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_TRAMITE_REGISTRO_PROFESIONAL')
            and   type = 'U')
   drop table Remetfu.REM_TRAMITE_REGISTRO_PROFESIONAL
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_TUTORES_COMUNITARIOS')
            and   type = 'U')
   drop table Remetfu.REM_TUTORES_COMUNITARIOS
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_TUTOR_MASCOTA')
            and   type = 'U')
   drop table Remetfu.REM_TUTOR_MASCOTA
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_USUARIOS')
            and   type = 'U')
   drop table Remetfu.REM_USUARIOS
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Remetfu.REM_USUARIO_PERFIL')
            and   type = 'U')
   drop table Remetfu.REM_USUARIO_PERFIL
go


---------------------------  CREACION DE TABLAS  -------------------
CREATE TABLE [MDMQ_REMETFU].[Remetfu].[REM_PARAMETROS](
	[PARAMETROS_ID] INT IDENTITY(1,1),
	[DESCRIPCION] VARCHAR(100),
	[VALOR] VARCHAR(30),
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
	 CONSTRAINT [REM_PARAMETROS_PKY] PRIMARY KEY CLUSTERED 
(
	[PARAMETROS_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo del parametro, autonumerico' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PARAMETROS', @level2type=N'COLUMN',@level2name=N'PARAMETROS_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Descripcion del parametro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PARAMETROS', @level2type=N'COLUMN',@level2name=N'DESCRIPCION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Valor del parametro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PARAMETROS', @level2type=N'COLUMN',@level2name=N'VALOR'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se creo el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PARAMETROS', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PARAMETROS', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PARAMETROS', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de la Ultima modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PARAMETROS', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PARAMETROS', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PARAMETROS', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla que contendra datos de Parametros utilizados por el sistema' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PARAMETROS'
GO

CREATE TABLE [MDMQ_REMETFU].[Remetfu].[REM_FERIADOS](
	[FERIADOS_ID] [bigint] IDENTITY(1,1) NOT NULL,
	[DESCRIPCION] [varchar](255) NOT NULL,
	[FECHA_FERIADO] [datetime] NOT NULL,
	[ESTADO] VARCHAR(15) NOT NULL,
    CONSTRAINT REM_FERIADOS_CHK01 CHECK( ESTADO IN('ACT','INA') ),
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
 CONSTRAINT [REM_FERIADOS_PKY] PRIMARY KEY CLUSTERED 
(
[FERIADOS_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo del feriado, autonumerico' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_FERIADOS', @level2type=N'COLUMN',@level2name=N'FERIADOS_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Descripcion del feriado' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_FERIADOS', @level2type=N'COLUMN',@level2name=N'DESCRIPCION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha feriado' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_FERIADOS', @level2type=N'COLUMN',@level2name=N'FECHA_FERIADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado: ACT = ACTIVO INA = INACTIVO' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_FERIADOS', @level2type=N'COLUMN',@level2name=N'ESTADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se creo el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_FERIADOS', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_FERIADOS', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_FERIADOS', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de la Ultima modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_FERIADOS', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_FERIADOS', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_FERIADOS', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla que contendra fechas de feriados utilizados por el sistema' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_FERIADOS'
GO


CREATE TABLE Remetfu.[REM_ARCHIVOS](
	[ARCHIVO_ID] [uniqueidentifier] NOT NULL,
	[NOMBRE_ARCHIVO] [varchar](300) NOT NULL,
	[TIPO_ARCHIVO] [varchar](150) NOT NULL,
	[HASH] [varchar](150) NOT NULL,
	[RUTA] [varchar](300) NOT NULL,
	[OBSERVACION] [varchar](300) NULL,
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
 CONSTRAINT [REM_ARCHIVOS_PKY] PRIMARY KEY CLUSTERED 
(
	[ARCHIVO_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO


EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo unico de identificacion del archivo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ARCHIVOS', @level2type=N'COLUMN',@level2name=N'ARCHIVO_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Nombre del Archivo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ARCHIVOS', @level2type=N'COLUMN',@level2name=N'NOMBRE_ARCHIVO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tipo de archivo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ARCHIVOS', @level2type=N'COLUMN',@level2name=N'TIPO_ARCHIVO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Hash del archivo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ARCHIVOS', @level2type=N'COLUMN',@level2name=N'HASH'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Ruta de grabacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ARCHIVOS', @level2type=N'COLUMN',@level2name=N'RUTA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Observacion del archivo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ARCHIVOS', @level2type=N'COLUMN',@level2name=N'OBSERVACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se crea el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ARCHIVOS', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ARCHIVOS', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ARCHIVOS', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de la ultima modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ARCHIVOS', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ARCHIVOS', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ARCHIVOS', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla para contener datos del ubicacion de los archivos de Remetfu' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ARCHIVOS'
GO


CREATE TABLE Remetfu.[REM_TIPO_REGISTRO](
	[TIPO_REGISTRO_ID] [int] identity(1,1) NOT NULL,
	[DESCRIPCION] [varchar](50) NOT NULL,
	[NOVEDAD1] [varchar](80) NULL,
	[NOVEDAD2] [varchar](80) NULL,
	[ESTADO] VARCHAR(15) NOT NULL,
    CONSTRAINT REM_TIPO_REGISTRO_CHK01 CHECK( ESTADO IN('ACT','INA') ),
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
 CONSTRAINT [REM_TIPO_REGISTRO_PKY] PRIMARY KEY CLUSTERED 
(
	[TIPO_REGISTRO_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de tipo de Registros' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TIPO_REGISTRO', @level2type=N'COLUMN',@level2name=N'TIPO_REGISTRO_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Descripcion del tipo de Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TIPO_REGISTRO', @level2type=N'COLUMN',@level2name=N'DESCRIPCION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Campo de datos Libre' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TIPO_REGISTRO', @level2type=N'COLUMN',@level2name=N'NOVEDAD1'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Campo de datos Libre' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TIPO_REGISTRO', @level2type=N'COLUMN',@level2name=N'NOVEDAD2'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado: ACT = ACTIVO INA = INACTIVO ITE=INACTIVO TEMPORAL' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TIPO_REGISTRO', @level2type=N'COLUMN',@level2name=N'ESTADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se crea el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TIPO_REGISTRO', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal Utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TIPO_REGISTRO', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TIPO_REGISTRO', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TIPO_REGISTRO', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal Utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TIPO_REGISTRO', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de modificacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TIPO_REGISTRO', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla para contener datos de Tipos de Registros' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TIPO_REGISTRO'
GO

CREATE TABLE Remetfu.[REM_SUBTIPO_REGISTRO](
	[SUBTIPO_REGISTRO_ID] [int] identity(1,1) NOT NULL,
	[TIPO_REGISTRO_ID] [int] NOT NULL,
	CONSTRAINT REM_SUBTIPO_REGISTRO_FKY01 FOREIGN KEY (TIPO_REGISTRO_ID)
        REFERENCES Remetfu.REM_TIPO_REGISTRO (TIPO_REGISTRO_ID),
	[DESCRIPCION] [varchar](100) NOT NULL,
	[TIPO_FORMULARIO] [int] NOT NULL,
	[NOVEDAD1] [varchar](80) NULL,
	[NOVEDAD2] [varchar](800) NULL,
	[NOVEDAD3] [varchar](800) NULL,
	[VALOR1] [numeric](15,2) NULL,
	[VALOR2] [numeric](15,2) NULL,
	[ESTADO] VARCHAR(15) NOT NULL,
    CONSTRAINT REM_SUBTIPO_REGISTRO_CHK01 CHECK( ESTADO IN('ACT','INA') ),
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
 CONSTRAINT [REM_SUBTIPO_REGISTRO_PKY] PRIMARY KEY CLUSTERED 
(
	[SUBTIPO_REGISTRO_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de Subtipo de Registros' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_SUBTIPO_REGISTRO', @level2type=N'COLUMN',@level2name=N'SUBTIPO_REGISTRO_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de tipo de Registros' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_SUBTIPO_REGISTRO', @level2type=N'COLUMN',@level2name=N'TIPO_REGISTRO_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Descripcion del tipo de Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_SUBTIPO_REGISTRO', @level2type=N'COLUMN',@level2name=N'DESCRIPCION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tipo de Formulario utilizado del tipo de Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_SUBTIPO_REGISTRO', @level2type=N'COLUMN',@level2name=N'TIPO_FORMULARIO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Campo de datos Libre' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_SUBTIPO_REGISTRO', @level2type=N'COLUMN',@level2name=N'NOVEDAD1'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Campo de datos Libre' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_SUBTIPO_REGISTRO', @level2type=N'COLUMN',@level2name=N'NOVEDAD2'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Campo de datos Libre' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_SUBTIPO_REGISTRO', @level2type=N'COLUMN',@level2name=N'NOVEDAD3'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Porcentajes de cobro de cada subtipo de registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_SUBTIPO_REGISTRO', @level2type=N'COLUMN',@level2name=N'VALOR1'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Campo de valor diponible' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_SUBTIPO_REGISTRO', @level2type=N'COLUMN',@level2name=N'VALOR2'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado: ACT = ACTIVO INA = INACTIVO ITE=INACTIVO TEMPORAL' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_SUBTIPO_REGISTRO', @level2type=N'COLUMN',@level2name=N'ESTADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se crea el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_SUBTIPO_REGISTRO', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal Utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_SUBTIPO_REGISTRO', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_SUBTIPO_REGISTRO', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_SUBTIPO_REGISTRO', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal Utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_SUBTIPO_REGISTRO', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de la ultima modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_SUBTIPO_REGISTRO', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla para contener datos de Tipos de Registros' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_SUBTIPO_REGISTRO'
GO


CREATE TABLE Remetfu.[REM_TIPO_CATALOGO](
	[TIPO_CATALOGO_ID] [int] IDENTITY (1,1) NOT NULL,
	[NOMBRE] [varchar](100) NOT NULL,
	[ESTADO] VARCHAR(15) NOT NULL,
    CONSTRAINT REM_TIPO_CATALOGO_CHK01 CHECK( ESTADO IN('ACT','INA') ),
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
 CONSTRAINT [REM_TIPO_CATALOGO_PKY] PRIMARY KEY CLUSTERED 
(
	[TIPO_CATALOGO_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Secuencial de Tipos de Catálogos' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TIPO_CATALOGO', @level2type=N'COLUMN',@level2name=N'TIPO_CATALOGO_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Nombre de Tipo de Catalogos' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TIPO_CATALOGO', @level2type=N'COLUMN',@level2name=N'NOMBRE'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado: ACT = ACTIVO INA = INACTIVO ITE=INACTIVO TEMPORAL' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TIPO_CATALOGO', @level2type=N'COLUMN',@level2name=N'ESTADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se crea el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TIPO_CATALOGO', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal Utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TIPO_CATALOGO', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TIPO_CATALOGO', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TIPO_CATALOGO', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal Utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TIPO_CATALOGO', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de la  ltima modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TIPO_CATALOGO', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla de Tipos de Catalogos' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TIPO_CATALOGO'
GO


CREATE TABLE Remetfu.[REM_CATALOGO](
	[CATALOGO_ID] [int] IDENTITY (1,1) NOT NULL,
	[TIPO_CATALOGO_ID] [int] NOT NULL,
	CONSTRAINT REM_CATALOGO_FKY01 FOREIGN KEY (TIPO_CATALOGO_ID)
        REFERENCES Remetfu.REM_TIPO_CATALOGO (TIPO_CATALOGO_ID),
	[NOMBRE] [varchar](200) NULL,
	[ESTADO] VARCHAR(15)
    CONSTRAINT REM_CATALOGO_CHK01 CHECK( ESTADO IN('ACT','INA') ),
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
    CONSTRAINT [REM_CATALOGO_PKY] PRIMARY KEY CLUSTERED 
(
	[CATALOGO_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Secuencial general del Catálogo ingresado' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_CATALOGO', @level2type=N'COLUMN',@level2name=N'CATALOGO_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tipo de Catálogo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_CATALOGO', @level2type=N'COLUMN',@level2name=N'TIPO_CATALOGO_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Nombre de cada item del Catalogo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_CATALOGO', @level2type=N'COLUMN',@level2name=N'NOMBRE'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado: ACT = ACTIVO INA = INACTIVO ITE=INACTIVO TEMPORAL' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_CATALOGO', @level2type=N'COLUMN',@level2name=N'ESTADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se crea el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_CATALOGO', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal Utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_CATALOGO', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_CATALOGO', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_CATALOGO', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal Utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_CATALOGO', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de la  ltima modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_CATALOGO', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla de Catalogos' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_CATALOGO'
GO

CREATE TABLE Remetfu.[REM_NOMENCLATURA](
	[NOMENCLATURA_ID] [int] identity(1,1) NOT NULL,
	[SUBTIPO_REGISTRO_ID] [int] NOT NULL,
	CONSTRAINT REM_NOMENCLATURA_FKY01 FOREIGN KEY (SUBTIPO_REGISTRO_ID)
        REFERENCES Remetfu.REM_SUBTIPO_REGISTRO(SUBTIPO_REGISTRO_ID),
	[SECUENCIAL_TMP] [bigint] NOT NULL,
	[NOMENCLATURA_TMP] [varchar](50) NOT NULL,
	[SECUENCIAL_FINAL] [bigint] NOT NULL,
	[NOMENCLATURA_FINAL] [varchar](50) NOT NULL,
	[NUMERO_DIGITOS] [int] NOT NULL,	
	[ESTADO] [char](3) NULL,
    CONSTRAINT REM_NOMENCLATURA_CHK01 CHECK( ESTADO IN('ACT','INA') ),
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
 CONSTRAINT [REM_NOMENCLATURA_PKY] PRIMARY KEY CLUSTERED 
(
	[NOMENCLATURA_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de Nomenclatura' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_NOMENCLATURA', @level2type=N'COLUMN',@level2name=N'NOMENCLATURA_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de Tipo de Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_NOMENCLATURA', @level2type=N'COLUMN',@level2name=N'SUBTIPO_REGISTRO_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Secuencial de nomenclatura Temporal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_NOMENCLATURA', @level2type=N'COLUMN',@level2name=N'SECUENCIAL_TMP'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Descripcion de nomenclatura Temporal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_NOMENCLATURA', @level2type=N'COLUMN',@level2name=N'NOMENCLATURA_TMP'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Secuencial de nomenclatura Final' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_NOMENCLATURA', @level2type=N'COLUMN',@level2name=N'SECUENCIAL_FINAL'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Descripcion de nomenclatura Final' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_NOMENCLATURA', @level2type=N'COLUMN',@level2name=N'NOMENCLATURA_FINAL'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Numero de digitos para setear la impresion del registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_NOMENCLATURA', @level2type=N'COLUMN',@level2name=N'NUMERO_DIGITOS'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado de la Nomenclatura' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_NOMENCLATURA', @level2type=N'COLUMN',@level2name=N'ESTADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se crea el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_NOMENCLATURA', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal Utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_NOMENCLATURA', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_NOMENCLATURA', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_NOMENCLATURA', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal Utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_NOMENCLATURA', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de la ultima modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_NOMENCLATURA', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla para contener datos de Nomenclaturas de Registros' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_NOMENCLATURA'
GO


CREATE TABLE Remetfu.[REM_PERFIL](
	[PERFIL_ID] [bigint] identity(1,1) NOT NULL,
	[NOMBRE] [varchar](50) NULL,
	[DESCRIPCION] [varchar](200) NULL,
	[ESTADO] [char](3) NULL,
    CONSTRAINT REM_PERFIL_CHK01 CHECK( ESTADO IN('ACT','INA') ),
	[TIPO_USUARIO] [int] NULL,
	CONSTRAINT REM_PERFIL_FKY01 FOREIGN KEY (TIPO_USUARIO)
        REFERENCES Remetfu.REM_CATALOGO (CATALOGO_ID),
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
 CONSTRAINT [REM_PERFIL_PKY] PRIMARY KEY CLUSTERED 
(
	[PERFIL_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Secuencial Codigo del Perfil' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PERFIL', @level2type=N'COLUMN',@level2name=N'PERFIL_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Nombre del Perfil' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PERFIL', @level2type=N'COLUMN',@level2name=N'NOMBRE'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Descripcion del Perfil' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PERFIL', @level2type=N'COLUMN',@level2name=N'DESCRIPCION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado: ACT = ACTIVO INA = INACTIVO ITE=INACTIVO TEMPORAL' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PERFIL', @level2type=N'COLUMN',@level2name=N'ESTADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Se refiere al tipo de Usuario INT: Interno CIU= Ciudadano' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PERFIL', @level2type=N'COLUMN',@level2name=N'TIPO_USUARIO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se crea el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PERFIL', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PERFIL', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PERFIL', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de la ultima modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PERFIL', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PERFIL', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PERFIL', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Perfiles de acceso al aplicativo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PERFIL'
GO

CREATE TABLE Remetfu.[REM_USUARIOS](
	[USUARIO_ID] [bigint] IDENTITY(1,1) NOT NULL,
	[TIPO_IDENTIFICACION] [char](1) NOT NULL,
	[NRO_IDENTIFICACION] [char](13) NOT NULL,
	CONSTRAINT REM_USUARIOS_UNQ01 UNIQUE(NRO_IDENTIFICACION),
	[NOMBRES] [varchar](50) NULL,
	[APELLIDOS] [varchar](50) NULL,
	[DENOMINACION] [varchar](80) NULL,
	[MAIL] [varchar](60) NULL,
    [MAIL_PERSONAL] [varchar](60) NULL,
    [DIRECCION] [char](200) NULL,
	[TELEFONO] [char](10) NULL,
	[MOVIL] [char](15) NULL,
	[ACEPTACION_MEDIOS] [char](10) NULL,
	[ESTADO] [char](3) NULL,
	CONSTRAINT REM_USUARIOS_CHK01 CHECK( ESTADO IN('ACT','INA','BLQ') ),
	[CIM] [varchar](30) NULL,
	[SSO_ID] [varchar](100) NOT NULL,
	[USERNAME] [varchar](30) NOT NULL,
	[CLAVE] [varchar](30) NOT NULL,
	[TIPO_USUARIO] [int] NOT NULL,
	CONSTRAINT REM_USUARIOS_FKY01 FOREIGN KEY (TIPO_USUARIO)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[ADM_ZONAL] [int] NULL,
	CONSTRAINT REM_USUARIOS_FKY02 FOREIGN KEY (ADM_ZONAL)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[FECHA_NACIMIENTO] [datetime] NOT NULL,
	[NACIONALIDAD] [int] NULL,
	CONSTRAINT REM_USUARIOS_FKY03 FOREIGN KEY (NACIONALIDAD)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[GENERO] [int] NULL,
	CONSTRAINT REM_USUARIOS_FKY04 FOREIGN KEY (GENERO)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[DISCAPACIDAD] [char](3) NULL,
		CONSTRAINT REM_USUARIOS_CHK02 CHECK( DISCAPACIDAD IN('SI','NO') ),
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
	 CONSTRAINT [REM_USUARIOS_PKY] PRIMARY KEY CLUSTERED 
(
	[USUARIO_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo unico identificador de usuario' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIOS', @level2type=N'COLUMN',@level2name=N'USUARIO_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tipo de Identificacion C=Cedula R=RUC P = Pasaporte de usuarios' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIOS', @level2type=N'COLUMN',@level2name=N'TIPO_IDENTIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Ingresara el numero de identificacion del usuario' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIOS', @level2type=N'COLUMN',@level2name=N'NRO_IDENTIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Nombres del usuario' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIOS', @level2type=N'COLUMN',@level2name=N'NOMBRES'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Apellidos del usuario' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIOS', @level2type=N'COLUMN',@level2name=N'APELLIDOS'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Denominacion del usuario' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIOS', @level2type=N'COLUMN',@level2name=N'DENOMINACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Ingresara el correo electronico del usuario' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIOS', @level2type=N'COLUMN',@level2name=N'MAIL'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Correo electronico personal del usuario' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIOS', @level2type=N'COLUMN',@level2name=N'MAIL_PERSONAL'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'En el caso de usuarios ciudadanos se llenaria el campo con los datos de PAM con el cual se autentica, en el caso de usuarios internos este campo estara vacio' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIOS', @level2type=N'COLUMN',@level2name=N'DIRECCION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'En el caso de usuarios ciudadanos se llenaria el campo con los datos de PAM con el cual se autentica, en el caso de usuarios internos este campo estara vacio' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIOS', @level2type=N'COLUMN',@level2name=N'TELEFONO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'En el caso de usuarios ciudadanos se llenaria el campo con los datos de PAM con el cual se autentica, en el caso de usuarios internos este campo estara vacio' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIOS', @level2type=N'COLUMN',@level2name=N'MOVIL'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Aceptación de medios Tecnologicos' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIOS', @level2type=N'COLUMN',@level2name=N'ACEPTACION_MEDIOS'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado: ACT = ACTIVO INA = INACTIVO ITE=INACTIVO TEMPORAL' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIOS', @level2type=N'COLUMN',@level2name=N'ESTADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo interno municipal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIOS', @level2type=N'COLUMN',@level2name=N'CIM'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Identificacion KeyCloack' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIOS', @level2type=N'COLUMN',@level2name=N'SSO_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'codigo de usuario para empleados municipio, para externos el dato va vacio' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIOS', @level2type=N'COLUMN',@level2name=N'USERNAME'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Clave de acceso usuario interno' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIOS', @level2type=N'COLUMN',@level2name=N'CLAVE'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tipo de Usuario' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIOS', @level2type=N'COLUMN',@level2name=N'TIPO_USUARIO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de Administracion Zonal a la que pertenece el usuario' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIOS', @level2type=N'COLUMN',@level2name=N'ADM_ZONAL'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de nacimiento' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIOS', @level2type=N'COLUMN',@level2name=N'FECHA_NACIMIENTO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Nacionalidad del Profesional' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIOS', @level2type=N'COLUMN',@level2name=N'NACIONALIDAD'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Genero del Profesional' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIOS', @level2type=N'COLUMN',@level2name=N'GENERO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Discapacidad: SI/NO' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIOS', @level2type=N'COLUMN',@level2name=N'DISCAPACIDAD'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se creo el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIOS', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIOS', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIOS', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de la ?ltima modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIOS', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIOS', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIOS', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla que contendra todos los usuarios creados para el uso del sistema para la intranet, para los ciudadanos se encuentra PAM, los usuarios ser?n usuarios federados en keycloak y los ciudadanos en el reino de Ciudadanos' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIOS'
GO

CREATE TABLE Remetfu.[REM_USUARIO_PERFIL](
	[USUARIO_PERFIL_ID] [bigint] IDENTITY(1,1) NOT NULL,
	[USUARIO_ID] [bigint] NOT NULL,
	CONSTRAINT REM_USUARIO_PERFIL_FKY01 FOREIGN KEY (USUARIO_ID)
        REFERENCES Remetfu.REM_USUARIOS(USUARIO_ID),
	[PERFIL_ID] [bigint] NULL,
	CONSTRAINT REM_USUARIO_PERFIL_FKY02 FOREIGN KEY (PERFIL_ID)
        REFERENCES Remetfu.REM_PERFIL(PERFIL_ID),
	[TIPO_USUARIO] [int] NOT NULL,
	CONSTRAINT REM_USUARIO_PERFIL_FKY03 FOREIGN KEY (TIPO_USUARIO)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	CONSTRAINT REM_USUARIO_PERFIL_UNQ01 UNIQUE (USUARIO_ID,PERFIL_ID),
	[DESCRIPCION] [varchar](60) NULL,
	[ESTADO] [char](3) NULL,
    CONSTRAINT REM_USUARIO_PERFIL_CHK01 CHECK( ESTADO IN('ACT','INA') ),
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
 CONSTRAINT [REM_USUARIO_PERFIL_PKY] PRIMARY KEY CLUSTERED 
(
	[USUARIO_PERFIL_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO


EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo unico identificador de usuario' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIO_PERFIL', @level2type=N'COLUMN',@level2name=N'USUARIO_PERFIL_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Id del perfil de usuario' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIO_PERFIL', @level2type=N'COLUMN',@level2name=N'USUARIO_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Perfil del usuario' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIO_PERFIL', @level2type=N'COLUMN',@level2name=N'PERFIL_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tipo de usuario, Municipal/Ciudadano' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIO_PERFIL', @level2type=N'COLUMN',@level2name=N'TIPO_USUARIO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Descripcion de la opcion que va a salir en el Menu' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIO_PERFIL', @level2type=N'COLUMN',@level2name=N'DESCRIPCION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado: ACT = ACTIVO INA = INACTIVO ITE=INACTIVO TEMPORAL' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIO_PERFIL', @level2type=N'COLUMN',@level2name=N'ESTADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se crea el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIO_PERFIL', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIO_PERFIL', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIO_PERFIL', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIO_PERFIL', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIO_PERFIL', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de modificacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIO_PERFIL', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Registro de perfil por usuario' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_USUARIO_PERFIL'
GO

CREATE TABLE Remetfu.[REM_ANALISTA](
	[ANALISTA_ID] [bigint] identity(1,1) NOT NULL ,
	[PERFIL_ID] [bigint] NOT NULL ,
	CONSTRAINT REM_ANALISTA_FKY01 FOREIGN KEY (PERFIL_ID)
        REFERENCES Remetfu.REM_PERFIL(PERFIL_ID),
	[USUARIO_ID] [bigint] NOT NULL ,
	CONSTRAINT REM_ANALISTA_FKY02 FOREIGN KEY (USUARIO_ID)
        REFERENCES Remetfu.REM_USUARIOS (USUARIO_ID),
	CONSTRAINT REM_ANALISTA_UNQ01 UNIQUE(PERFIL_ID,USUARIO_ID),
	[CATALOGO_ID] [int] NULL , --Motivo de Permiso/Vacación
	CONSTRAINT REM_ANALISTA_FKY03 FOREIGN KEY (CATALOGO_ID)
        REFERENCES Remetfu.REM_CATALOGO (CATALOGO_ID),
	[FECHA_DESDE] [datetime] NULL,
	[FECHA_HASTA] [datetime] NULL,
	[OBSERVACION] [varchar](500) NULL,
	[AUTORIZACION_SALIDA] [int] NULL , --Autorización de Salida
	[ESTADO] [char](3) NULL
	CONSTRAINT REM_ANALISTA_CHK01 CHECK( ESTADO IN('ACT','INA','PER','VAC') ),
	[NRO_TRAMITES] [bigint] NULL ,
	[NRO_TRAMITES_MES] [bigint] NULL ,
	[MES_TRAMITES] [datetime] NULL,
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
 CONSTRAINT [REM_ANALISTA_PKY] PRIMARY KEY CLUSTERED 
(
	[ANALISTA_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de Analista' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISTA', @level2type=N'COLUMN',@level2name=N'ANALISTA_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de Perfil' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISTA', @level2type=N'COLUMN',@level2name=N'PERFIL_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de Usuario' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISTA', @level2type=N'COLUMN',@level2name=N'USUARIO_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tipo de solicitud de inactivo: PER = PERMISO, VAC = VACACIONES' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISTA', @level2type=N'COLUMN',@level2name=N'CATALOGO_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha inicio solicitud inactivo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISTA', @level2type=N'COLUMN',@level2name=N'FECHA_DESDE'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha fin solicitud inactivo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISTA', @level2type=N'COLUMN',@level2name=N'FECHA_HASTA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Observacion solicitud inactivo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISTA', @level2type=N'COLUMN',@level2name=N'OBSERVACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Autorizacion solicitud inactivo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISTA', @level2type=N'COLUMN',@level2name=N'AUTORIZACION_SALIDA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado de Registro: ACT = ACTIVO, INA = INACTIVO, PER = PERMISO, VAC = VACACIONES' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISTA', @level2type=N'COLUMN',@level2name=N'ESTADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Total tramite realizados' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISTA', @level2type=N'COLUMN',@level2name=N'NRO_TRAMITES'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Nro. tramites mes' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISTA', @level2type=N'COLUMN',@level2name=N'NRO_TRAMITES_MES'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Mes de trabajo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISTA', @level2type=N'COLUMN',@level2name=N'MES_TRAMITES'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se crea el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISTA', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISTA', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISTA', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de la ultima modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISTA', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISTA', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISTA', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla que contiene datos de los Analistas' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISTA'
GO


CREATE TABLE Remetfu.[REM_TRAMITE_REASIGNACION](
	[TRAMITE_REASIGNACION_ID] [bigint] NOT NULL ,
	[ANALISTA_ANTES] [bigint] NOT NULL ,
	CONSTRAINT REM_TRAMITE_REASIGNACION_FKY01 FOREIGN KEY (ANALISTA_ANTES)
        REFERENCES Remetfu.REM_ANALISTA(ANALISTA_ID),
	[ANALISTA_DESPUES] [bigint] NOT NULL ,
	CONSTRAINT REM_TRAMITE_REASIGNACION_FKY02 FOREIGN KEY (ANALISTA_DESPUES)
        REFERENCES Remetfu.REM_ANALISTA(ANALISTA_ID),
	[MOTIVO] [varchar](500) NOT NULL,
	[FECHA_REASIGNACION] [datetime] NOT NULL,
	[USUARIO_REASIGNACION] [varchar](30) NOT NULL,
	[TERMINAL_REASIGNACION] [varchar](30) NOT NULL,
 CONSTRAINT [REM_TRAMITE_REASIGNACION_PKY] PRIMARY KEY CLUSTERED 
(
	[TRAMITE_REASIGNACION_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de Reasignación de Analista' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TRAMITE_REASIGNACION', @level2type=N'COLUMN',@level2name=N'TRAMITE_REASIGNACION_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Analista Antes' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TRAMITE_REASIGNACION', @level2type=N'COLUMN',@level2name=N'ANALISTA_ANTES'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Analista Despues' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TRAMITE_REASIGNACION', @level2type=N'COLUMN',@level2name=N'ANALISTA_DESPUES'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Motivo de Reasignacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TRAMITE_REASIGNACION', @level2type=N'COLUMN',@level2name=N'MOTIVO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha que se realiza la Reasignacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TRAMITE_REASIGNACION', @level2type=N'COLUMN',@level2name=N'FECHA_REASIGNACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario que se realiza la Reasignacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TRAMITE_REASIGNACION', @level2type=N'COLUMN',@level2name=N'USUARIO_REASIGNACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal que se realiza la Reasignacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TRAMITE_REASIGNACION', @level2type=N'COLUMN',@level2name=N'TERMINAL_REASIGNACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla que contiene datos de los Analistas' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TRAMITE_REASIGNACION'
GO


CREATE TABLE Remetfu.[REM_REGISTRO_PROFESIONAL](
	[REGISTRO_PROFESIONAL_ID] [bigint] IDENTITY(1,1) NOT NULL,
	[SECUENCIAL_TMP] [bigint] NOT NULL,
	[SECUENCIAL_FINAL] [bigint] NOT NULL,
	[USUARIO_ID] [bigint] NOT NULL,
	CONSTRAINT REM_REGISTRO_PROFESIONAL_FKY01 FOREIGN KEY (USUARIO_ID)
        REFERENCES Remetfu.REM_USUARIOS(USUARIO_ID),
	[VISA_TRABAJO] [uniqueidentifier] NULL,
	CONSTRAINT REM_REGISTRO_PROFESIONAL_FKY02 FOREIGN KEY (VISA_TRABAJO)
        REFERENCES Remetfu.REM_ARCHIVOS(ARCHIVO_ID),
	[PARROQUIA] [int] NOT NULL,
	CONSTRAINT REM_REGISTRO_PROFESIONAL_FKY03 FOREIGN KEY (PARROQUIA)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[SUBTIPO_REGISTRO_ID] [int] NOT NULL,
	CONSTRAINT REM_REGISTRO_PROFESIONAL_FKY04 FOREIGN KEY (SUBTIPO_REGISTRO_ID)
        REFERENCES Remetfu.REM_SUBTIPO_REGISTRO(SUBTIPO_REGISTRO_ID),
	[BARRIO] [varchar](150) NULL,
	[CALLE_PRINCIPAL] [varchar](150) NULL,
	[CALLE_NUMERO] [varchar](15) NULL,
	[CALLE_SECUNDARIA] [varchar](150) NULL,
	[CALLE_REFERENCIA1] [varchar](150) NULL,
	[CALLE_REFERENCIA2] [varchar](150) NULL,	
	[ESTADO] [int] NOT NULL,
	CONSTRAINT REM_REGISTRO_PROFESIONAL_FKY05 FOREIGN KEY (ESTADO)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	CONSTRAINT REM_REGISTRO_PROFESIONAL_UNQ01 UNIQUE(USUARIO_ID,SUBTIPO_REGISTRO_ID,ESTADO),
	[ACUERDO_RESPONSABILIDAD] [char](3) NOT NULL,
	CONSTRAINT REM_REGISTRO_PROFESIONAL_CHK03 CHECK( ACUERDO_RESPONSABILIDAD IN('SI','NO') ),
	[EXPERIENCIA_LABORAL] [varchar](300) NULL,
	[AGREMIADO] [char](3) NOT NULL,
	CONSTRAINT REM_REGISTRO_PROFESIONAL_CHK04 CHECK( AGREMIADO IN('SI','NO') ),
	[NOMBRE_GREMIO] [varchar](100) NULL,	
	[FECHA_INACTIVO] [datetime] NULL,
	[DIAS_INACTIVO] [int] NULL,
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
 CONSTRAINT [REM_REGISTRO_PROFESIONAL_PKY] PRIMARY KEY CLUSTERED 
(
	[REGISTRO_PROFESIONAL_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO


EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de Registro de Profesionales' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'REGISTRO_PROFESIONAL_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Numeracion Temporal de Profesionales' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'SECUENCIAL_TMP'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'numeracion Definitiva de Profesionales cuando ya ha sido aprobado el tramite' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'SECUENCIAL_FINAL'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo unico identificador de usuario' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'USUARIO_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de identificacion del archivo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'VISA_TRABAJO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Parroquia donde vive el Profesional' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'PARROQUIA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Subtipo de Registro del Profesional' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'SUBTIPO_REGISTRO_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Barrio donde vive el Profesional' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'BARRIO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Calle principal donde vive el Profesional' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'CALLE_PRINCIPAL'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Numero de calle donde vive el Profesional' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'CALLE_NUMERO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Calle secundaria donde vive el Profesional' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'CALLE_SECUNDARIA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Referencia1 calle donde vive el Profesional' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'CALLE_REFERENCIA1'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Referencia2 calle donde vive el Profesional' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'CALLE_REFERENCIA2'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado: ACT = ACTIVO INA = INACTIVO ITE=INACTIVO TEMPORAL' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'ESTADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Identifica si el profesional acepto el acuerdo de responsabilidad' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'ACUERDO_RESPONSABILIDAD'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Identifica si el profesional posee experiencia Laboral' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'EXPERIENCIA_LABORAL'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Identifica si el profesional pertenece a un Gremio' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'AGREMIADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Nombre del Gremio al que pertenece el profesional' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'NOMBRE_GREMIO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de inactivacion cuando se le suspende el acceso al contribuyente' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'FECHA_INACTIVO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Dias de inactivo cuando se le suspende el acceso al contribuyente' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'DIAS_INACTIVO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se crea el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de la ultima modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla para contener datos de Profesionales registrados en la PAM, son usuarios federados en keycloak y los ciudadanos en el reino de Ciudadanos' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REGISTRO_PROFESIONAL'
GO


CREATE TABLE Remetfu.[REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL](
	[ANALSIS_TRAMITE_REGISTRO_PROFESIONAL_ID] [bigint] IDENTITY(1,1) NOT NULL ,
	[REGISTRO_PROFESIONAL_ID] [bigint] NOT NULL ,
	CONSTRAINT REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL_FKY01 FOREIGN KEY (REGISTRO_PROFESIONAL_ID)
        REFERENCES Remetfu.REM_REGISTRO_PROFESIONAL(REGISTRO_PROFESIONAL_ID),
	CONSTRAINT REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL_UNQ01 UNIQUE(REGISTRO_PROFESIONAL_ID),
	[ANALISTA_ID] [bigint] NOT NULL ,
	CONSTRAINT REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL_FKY02 FOREIGN KEY (ANALISTA_ID)
        REFERENCES Remetfu.REM_ANALISTA (ANALISTA_ID),
	[FECHA_ASIGNA] [datetime] NOT NULL,
	[FECHA_VIGENCIA] [datetime] NOT NULL,
	[ESTADO] [int] NOT NULL,
	CONSTRAINT REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL_FKY03 FOREIGN KEY (ESTADO)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[FECHA_APROBACION] [datetime],
	[NOVEDAD_APROBACION] [varchar](500),
	[FECHA_DEVOLUCION] [datetime],
	[MOTIVO_DEVOLUCION] [varchar](500),
	[FECHA_RECHAZO] [datetime],
	[MOTIVO_RECHAZO] [varchar](500),
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
 CONSTRAINT [REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL_PKY] PRIMARY KEY CLUSTERED 
(
	[ANALSIS_TRAMITE_REGISTRO_PROFESIONAL_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de asignacion de tramite al Analista' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'ANALSIS_TRAMITE_REGISTRO_PROFESIONAL_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo del profesional' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'REGISTRO_PROFESIONAL_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de Analista de Tramites' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'ANALISTA_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de Asignacion del tramite' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'FECHA_ASIGNA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de Vigencia del tramite' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'FECHA_VIGENCIA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado de Registro: PRE = PREREGISTRO, ING = INGRESADO, REI=REINGRESADO, ASI = ASIGNADO, APR=APROBADO, RCH = RECHAZADO, DEV=DEVUELTO, EMI=EMITIDO, CPD=COMPROBADO' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'ESTADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de Aprobacion del tramite' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'FECHA_APROBACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Novedad en la Aprobacion del tramite' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'NOVEDAD_APROBACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de Devolucion del tramite' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'FECHA_DEVOLUCION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Motivo de Devolucion del tramite' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'MOTIVO_DEVOLUCION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de Rechazo del tramite' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'FECHA_RECHAZO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Motivo de Rechazo del tramite' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'MOTIVO_RECHAZO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se crea el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de la ultima modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla que contiene datos de asignacion de tramites a los Analistas' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL'
GO


--DROP TABLE Remetfu.[REM_ORDENES_PAGO]
--GO

CREATE TABLE Remetfu.[REM_ORDENES_PAGO](
	[ORDENES_PAGO_ID] [bigint] IDENTITY(1,1) NOT NULL ,
	[SUBTIPO_REGISTRO_ID] [int] NOT NULL,
	CONSTRAINT REM_ORDENES_PAGO_FKY01 FOREIGN KEY (SUBTIPO_REGISTRO_ID)
        REFERENCES Remetfu.REM_SUBTIPO_REGISTRO(SUBTIPO_REGISTRO_ID),
	[NRO_REGISTRO] [bigint] NOT NULL ,
	[FECHA_ING] [datetime] NOT NULL,
	[ESTADO] [int] NOT NULL,
	CONSTRAINT REM_ORDENES_PAGO_FKY02 FOREIGN KEY (ESTADO)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[ORDENPAGO_SAO] [varchar](20) NULL,
	[ESTADO_SAO] [char](3) NULL,
	[FECHA_REG_SAO] [datetime] NULL,
	[FECHA_PAGO_SAO] [datetime] NULL,
	[FECHA_BAJA_SAO] [datetime] NULL,
	[CODIGO_QR] [varchar](200) NOT NULL,
	[VALOR_SAO] [numeric](18,2) NOT NULL,
	[CONCEPTO_SAO] [varchar](200) NOT NULL,
	[CI_DEUDOR] [varchar](15) NOT NULL,
	[NOVEDAD] [varchar](200) NOT NULL,
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
 CONSTRAINT [REM_ORDENES_PAGO_PKY] PRIMARY KEY CLUSTERED 
(
	[ORDENES_PAGO_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de tramite' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'ORDENES_PAGO_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de Subtipo Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'SUBTIPO_REGISTRO_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo del Registro, la operacion a la que se hacer referencia' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'NRO_REGISTRO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de ingreso del tramite' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'FECHA_ING'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado de Registro: PRE = PREREGISTRO, ING = INGRESADO, REI=REINGRESADO, ASI = ASIGNADO, APR=APROBADO, RCH = RECHAZADO, DEV=DEVUELTO, EMI=EMITIDO, CPD=COMPROBADO' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'ESTADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Orden de pago SAO' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'ORDENPAGO_SAO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado de la orden de pago SAO' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'ESTADO_SAO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de Generacion de orden de pago SAO' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'FECHA_REG_SAO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de Pago de orden de pago SAO' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'FECHA_PAGO_SAO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de Baja de orden de pago SAO' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'FECHA_BAJA_SAO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo QR del tramite' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'CODIGO_QR'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Valor de Pago' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'VALOR_SAO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Concepto de Pago' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'CONCEPTO_SAO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Identificación del deudor' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'CI_DEUDOR'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Novedad de la forma de Pago' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'NOVEDAD'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se crea el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de la ultima modificaci?n' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla para contener datos de tramites de los profesionales' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO'
GO

CREATE TABLE Remetfu.[REM_TITULO_PROFESIONAL](
	[TITULO_PROFESIONAL_ID] [bigint] IDENTITY(1,1) NOT NULL,
	[REGISTRO_PROFESIONAL_ID] [bigint] NOT NULL,
	CONSTRAINT REM_TITULO_PROFESIONAL_FKY01 FOREIGN KEY (REGISTRO_PROFESIONAL_ID)
        REFERENCES Remetfu.REM_REGISTRO_PROFESIONAL(REGISTRO_PROFESIONAL_ID),
	CONSTRAINT REM_TITULO_PROFESIONAL_UNQ01 UNIQUE(REGISTRO_PROFESIONAL_ID),
	[NRO_REGISTRO] [varchar](20) NOT NULL,
	[FECHA_REGISTRO] [datetime] NOT NULL,
	[NOMBRE_TITULO] [varchar](100) NOT NULL,
	[INSTITUCION_TITULO] [varchar](100) NOT NULL,
	[NIVEL_TITULO] [varchar](100) NOT NULL,
	[TIPO_TITULO] [varchar](100) NOT NULL,
	[RECONOCIDO_POR] [varchar](100) NOT NULL,
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
 CONSTRAINT [REM_TITULO_PROFESIONAL_PKY] PRIMARY KEY CLUSTERED 
(
	[TITULO_PROFESIONAL_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo unico de registro del profesional' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TITULO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'TITULO_PROFESIONAL_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo del profesional' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TITULO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'REGISTRO_PROFESIONAL_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Numero de Registro del titulo en la Senecyt' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TITULO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'NRO_REGISTRO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de Registro del titulo en la Senecyt' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TITULO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'FECHA_REGISTRO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Nombre del titulo en la Senecyt' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TITULO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'NOMBRE_TITULO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Institucion que otorga el titulo en la Senecyt' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TITULO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'INSTITUCION_TITULO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Nivel del titulo en la Senecyt: Tercer, Cuarto' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TITULO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'NIVEL_TITULO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tipo de titulo en la Senecyt: Nacional, Internacional' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TITULO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'TIPO_TITULO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Institucion que reconoce el titulo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TITULO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'RECONOCIDO_POR'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se crea el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TITULO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TITULO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TITULO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de la ultima modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TITULO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TITULO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TITULO_PROFESIONAL', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla para contener datos de titulo peofesional del profesional' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TITULO_PROFESIONAL'
GO

CREATE TABLE Remetfu.[REM_PERFIL_ACADEMICO](
	[PERFIL_ACADEMICO_ID] [bigint] IDENTITY(1,1) NOT NULL ,
	[REGISTRO_PROFESIONAL_ID] [bigint] NOT NULL,
	CONSTRAINT REM_PERFIL_ACADEMICO_FKY01 FOREIGN KEY (REGISTRO_PROFESIONAL_ID)
        REFERENCES Remetfu.REM_REGISTRO_PROFESIONAL(REGISTRO_PROFESIONAL_ID),
	[CATALOGO_ID] [int] NOT NULL,
	CONSTRAINT REM_PERFIL_ACADEMICO_FKY02 FOREIGN KEY (CATALOGO_ID)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	CONSTRAINT REM_PERFIL_ACADEMICO_UNQ01 UNIQUE(REGISTRO_PROFESIONAL_ID,CATALOGO_ID),
	[FECHA_REGISTRO] [datetime] NOT NULL,
	[ESTADO] [char](3) NOT NULL,
	CONSTRAINT REM_PERFIL_ACADEMICO_CHK02 CHECK( ESTADO IN('ACT','INA','ITE') ),
	[DOCUMENTO_ACREDITA] [varchar](100) NULL,
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
 CONSTRAINT [REM_PERFIL_ACADEMICO_PKY] PRIMARY KEY CLUSTERED 
(
	[PERFIL_ACADEMICO_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de Perfil Academico' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PERFIL_ACADEMICO', @level2type=N'COLUMN',@level2name=N'PERFIL_ACADEMICO_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo del profesional' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PERFIL_ACADEMICO', @level2type=N'COLUMN',@level2name=N'REGISTRO_PROFESIONAL_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo del Perfil Academico escogido' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PERFIL_ACADEMICO', @level2type=N'COLUMN',@level2name=N'CATALOGO_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de Registro del Perfil Academico del profesional' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PERFIL_ACADEMICO', @level2type=N'COLUMN',@level2name=N'FECHA_REGISTRO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado: ACT = ACTIVO INA = INACTIVO ITE=INACTIVO TEMPORAL' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PERFIL_ACADEMICO', @level2type=N'COLUMN',@level2name=N'ESTADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Institucion que emite el certificado' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PERFIL_ACADEMICO', @level2type=N'COLUMN',@level2name=N'DOCUMENTO_ACREDITA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se crea el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PERFIL_ACADEMICO', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PERFIL_ACADEMICO', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PERFIL_ACADEMICO', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de la ultima modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PERFIL_ACADEMICO', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PERFIL_ACADEMICO', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PERFIL_ACADEMICO', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla para contener datos de titulo peofesional del profesional' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_PERFIL_ACADEMICO'
GO


CREATE TABLE Remetfu.[REM_MENU_CABECERA](
	[MENU_CABECERA_ID] [int] IDENTITY (1,1) NOT NULL,
	[NOMBRE] [varchar](100) NOT NULL,
	[DESCRIPCION] [varchar](100) NOT NULL,
	[ESTADO] VARCHAR(15) NOT NULL,
    CONSTRAINT REM_MENU_CABECERA_CHK01 CHECK( ESTADO IN('ACT','INA') ),
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
 CONSTRAINT [REM_MENU_CABECERA_PKY] PRIMARY KEY CLUSTERED 
(
	[MENU_CABECERA_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo del Modulo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU_CABECERA', @level2type=N'COLUMN',@level2name=N'MENU_CABECERA_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Nombre del Modulo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU_CABECERA', @level2type=N'COLUMN',@level2name=N'NOMBRE'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Descripcion del Modulo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU_CABECERA', @level2type=N'COLUMN',@level2name=N'DESCRIPCION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado: ACT = ACTIVO INA = INACTIVO ITE=INACTIVO TEMPORAL' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU_CABECERA', @level2type=N'COLUMN',@level2name=N'ESTADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se crea el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU_CABECERA', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU_CABECERA', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU_CABECERA', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de la ultima modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU_CABECERA', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU_CABECERA', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU_CABECERA', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Modulos de acceso al aplicativo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU_CABECERA'
GO



CREATE TABLE Remetfu.[REM_MENU](
	[MENU_ID] [int] IDENTITY (1,1) NOT NULL,
	[NOMBRE] [varchar](100) NOT NULL,
	[DESCRIPCION] [varchar](100) NOT NULL,
	[MENU_CABECERA_ID] [int] NOT NULL,
	CONSTRAINT REM_MENU_FKY01 FOREIGN KEY (MENU_CABECERA_ID)
        REFERENCES Remetfu.REM_MENU_CABECERA (MENU_CABECERA_ID),
	[ICONO] [varchar](50) NOT NULL,
	[RUTA] [varchar](150) NOT NULL,
	[ESTADO] VARCHAR(15) NOT NULL,
    CONSTRAINT REM_MENU_CHK02 CHECK( ESTADO IN('ACT','INA') ),
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
 CONSTRAINT [REM_MENU_PKY] PRIMARY KEY CLUSTERED 
(
	[MENU_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO


EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo del Menu' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU', @level2type=N'COLUMN',@level2name=N'MENU_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Nombre de la Menu' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU', @level2type=N'COLUMN',@level2name=N'NOMBRE'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Descripcion de la Menu' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU', @level2type=N'COLUMN',@level2name=N'DESCRIPCION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Opcion de la que depende en el Menu' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU', @level2type=N'COLUMN',@level2name=N'MENU_CABECERA_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Icono en el Menu' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU', @level2type=N'COLUMN',@level2name=N'ICONO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Ruta de la opcion en el Menu' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU', @level2type=N'COLUMN',@level2name=N'RUTA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado: ACT = ACTIVO INA = INACTIVO ITE=INACTIVO TEMPORAL' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU', @level2type=N'COLUMN',@level2name=N'ESTADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se crea el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de la  ltima modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Perfiles de acceso al aplicativo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU'
GO


CREATE TABLE Remetfu.[REM_MENU_PERFIL](
	[PERFIL_ID] [bigint] NOT NULL,
	CONSTRAINT REM_MENU_PERFIL_FKY01 FOREIGN KEY (PERFIL_ID)
        REFERENCES Remetfu.REM_PERFIL (PERFIL_ID),
	[MENU_ID] [int] NOT NULL,
	CONSTRAINT REM_MENU_PERFIL_FKY02 FOREIGN KEY (MENU_ID)
        REFERENCES Remetfu.REM_MENU (MENU_ID),
	[ESTADO] VARCHAR(15) NOT NULL,
    CONSTRAINT REM_MENU_PERFIL_CHK01 CHECK( ESTADO IN('ACT','INA') ),
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
 CONSTRAINT [REM_MENU_PERFIL_PKY] PRIMARY KEY CLUSTERED 
(
	[PERFIL_ID],
	[MENU_ID]
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo del Perfil de usuario' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU_PERFIL', @level2type=N'COLUMN',@level2name=N'PERFIL_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo del Menu' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU_PERFIL', @level2type=N'COLUMN',@level2name=N'MENU_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado: ACT = ACTIVO INA = INACTIVO ITE=INACTIVO TEMPORAL' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU_PERFIL', @level2type=N'COLUMN',@level2name=N'ESTADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se crea el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU_PERFIL', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU_PERFIL', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU_PERFIL', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de la ultima modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU_PERFIL', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU_PERFIL', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU_PERFIL', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Opciones en el Menu por Perfiles de acceso al aplicativo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MENU_PERFIL'
GO

CREATE TABLE [Remetfu].[REM_TUTOR_MASCOTA](
	[TUTOR_ID] [bigint] IDENTITY(1,1) NOT NULL,
	[USUARIO_ID] [bigint] NOT NULL,
	CONSTRAINT REM_TUTOR_MASCOTA_FKY01 FOREIGN KEY (USUARIO_ID)
        REFERENCES Remetfu.REM_USUARIOS(USUARIO_ID),
	[DIRECCION] [varchar](200) NOT NULL,
	[ESTADO] [char](3) NULL,
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
 CONSTRAINT [REM_TUTOR_MASCOTA_PKY] PRIMARY KEY CLUSTERED 
(
	[TUTOR_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [REMETFU_IDX]
GO

ALTER TABLE [Remetfu].[REM_TUTOR_MASCOTA]  WITH CHECK ADD  CONSTRAINT [REM_TUTOR_MASCOTA_CHK01] CHECK  (([ESTADO]='ITE' OR [ESTADO]='INA' OR [ESTADO]='ACT'))
GO

ALTER TABLE [Remetfu].[REM_TUTOR_MASCOTA] CHECK CONSTRAINT [REM_TUTOR_MASCOTA_CHK01]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de Tutor' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TUTOR_MASCOTA', @level2type=N'COLUMN',@level2name=N'TUTOR_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo unico identificador de usuario' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TUTOR_MASCOTA', @level2type=N'COLUMN',@level2name=N'USUARIO_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Direccion fisica del Tutor' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TUTOR_MASCOTA', @level2type=N'COLUMN',@level2name=N'DIRECCION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado: ACT = ACTIVO INA = INACTIVO ITE=INACTIVO TEMPORAL' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TUTOR_MASCOTA', @level2type=N'COLUMN',@level2name=N'ESTADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se crea el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TUTOR_MASCOTA', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal Utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TUTOR_MASCOTA', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TUTOR_MASCOTA', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TUTOR_MASCOTA', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal Utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TUTOR_MASCOTA', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de la ultima modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TUTOR_MASCOTA', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla para contener datos de Tutores de Animales de Compania' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TUTOR_MASCOTA'
GO

CREATE TABLE Remetfu.[REM_MICROCHIP_MASCOTA](
	[MICROCHIP_MASCOTA_ID] [bigint] IDENTITY(1,1) NOT NULL,
	[TUTOR_ID] bigint NOT NULL,
	CONSTRAINT REM_MICROCHIP_MASCOTA_FKY01 FOREIGN KEY (TUTOR_ID)
        REFERENCES Remetfu.REM_TUTOR_MASCOTA(TUTOR_ID),
	[VETERINARIO] bigint NOT NULL,
	CONSTRAINT REM_MICROCHIP_MASCOTA_FKY02 FOREIGN KEY (VETERINARIO)
        REFERENCES Remetfu.REM_REGISTRO_PROFESIONAL(REGISTRO_PROFESIONAL_ID),
	[CODIGO_MICROCHIP] [varchar](30) NOT NULL,
	[FECHA_INGRESO] [datetime] NOT NULL,
	[INFORMACION_CONSIDERADA] [varchar](02) NOT NULL,
	CONSTRAINT REM_MICROCHIP_MASCOTA_CHK01 CHECK( INFORMACION_CONSIDERADA IN('SI','NO')),
	[ESTABLECIMIENTO] [int] NOT NULL,
	CONSTRAINT REM_MICROCHIP_MASCOTA_FKY03 FOREIGN KEY (ESTABLECIMIENTO)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[OBSERVACION] [varchar](300) NULL,
	[ACUERDO_RESPONSABILIDAD] [varchar](03) NOT NULL,
	CONSTRAINT REM_MICROCHIP_MASCOTA_CHK02 CHECK( ACUERDO_RESPONSABILIDAD IN('SI','NO') ),
	[ESTADO] [char](3) NOT NULL,
	CONSTRAINT REM_MICROCHIP_MASCOTA_CHK03 CHECK( ESTADO IN('ACT','INA','ITE')),
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
 CONSTRAINT [REM_MICROCHIP_MASCOTA_PKY] PRIMARY KEY CLUSTERED 
(
	[MICROCHIP_MASCOTA_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de Secuencial de registro del chip' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA', @level2type=N'COLUMN',@level2name=N'MICROCHIP_MASCOTA_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo del Tutor' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA', @level2type=N'COLUMN',@level2name=N'TUTOR_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo del veterinario' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA', @level2type=N'COLUMN',@level2name=N'VETERINARIO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo Chip MDMQ' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA', @level2type=N'COLUMN',@level2name=N'CODIGO_MICROCHIP'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de ingreso registro/compra del chip' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA', @level2type=N'COLUMN',@level2name=N'FECHA_INGRESO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Informacion considerada' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA', @level2type=N'COLUMN',@level2name=N'INFORMACION_CONSIDERADA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tipo de establecimiento' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA', @level2type=N'COLUMN',@level2name=N'ESTABLECIMIENTO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Observacion al momento de registro del chip' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA', @level2type=N'COLUMN',@level2name=N'OBSERVACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Acuerdo de responsabilidad' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA', @level2type=N'COLUMN',@level2name=N'ACUERDO_RESPONSABILIDAD'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado: ACT = ACTIVO INA = INACTIVO ITE=INACTIVO TEMPORAL' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA', @level2type=N'COLUMN',@level2name=N'ESTADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se crea el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de la ultima modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla para contener datos de Chips de Animales de Compania' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA'
GO

CREATE TABLE Remetfu.[REM_MICROCHIP_MASCOTA_UBA](
	[MICROCHIP_MASCOTA_UBA_ID] [bigint] IDENTITY(1,1) NOT NULL,
	[TUTOR_ID] bigint NOT NULL,
	CONSTRAINT REM_MICROCHIP_MASCOTA_UBA_FKY01 FOREIGN KEY (TUTOR_ID)
        REFERENCES Remetfu.REM_TUTOR_MASCOTA(TUTOR_ID),
	[FUNCIONARIO_UBA] bigint NOT NULL,
	CONSTRAINT REM_MICROCHIP_MASCOTA_UBA_FKY02 FOREIGN KEY (FUNCIONARIO_UBA)
        REFERENCES Remetfu.REM_USUARIOS(USUARIO_ID),
	[CODIGO_MICROCHIP] [varchar](30) NOT NULL,
	[FECHA_INGRESO] [datetime] NOT NULL,
	[INFORMACION_CONSIDERADA] [varchar](02) NOT NULL,
	CONSTRAINT REM_MICROCHIP_MASCOTA_UBA_CHK01 CHECK( INFORMACION_CONSIDERADA IN('SI','NO')),
	[ESTABLECIMIENTO] [int] NOT NULL,
	CONSTRAINT REM_MICROCHIP_MASCOTA_UBA_FKY03 FOREIGN KEY (ESTABLECIMIENTO)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[OBSERVACION] [varchar](300) NULL,
	[ACUERDO_RESPONSABILIDAD] [varchar](03) NOT NULL,
	CONSTRAINT REM_MICROCHIP_MASCOTA_UBA_CHK02 CHECK( ACUERDO_RESPONSABILIDAD IN('SI','NO') ),
	[ESTADO] [char](3) NOT NULL,
	CONSTRAINT REM_MICROCHIP_MASCOTA_UBA_CHK03 CHECK( ESTADO IN('ACT','INA','ITE')),
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
 CONSTRAINT [REM_MICROCHIP_MASCOTA_UBA_PKY] PRIMARY KEY CLUSTERED 
(
	[MICROCHIP_MASCOTA_UBA_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de Secuencial de registro del chip' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA_UBA', @level2type=N'COLUMN',@level2name=N'MICROCHIP_MASCOTA_UBA_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo del Tutor' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA_UBA', @level2type=N'COLUMN',@level2name=N'TUTOR_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo del veterinario UBA, viene de la tabla de usuarios' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA_UBA', @level2type=N'COLUMN',@level2name=N'FUNCIONARIO_UBA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo Chip MDMQ' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA_UBA', @level2type=N'COLUMN',@level2name=N'CODIGO_MICROCHIP'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de ingreso registro/compra del chip' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA_UBA', @level2type=N'COLUMN',@level2name=N'FECHA_INGRESO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Informacion considerada' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA_UBA', @level2type=N'COLUMN',@level2name=N'INFORMACION_CONSIDERADA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tipo de establecimiento' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA_UBA', @level2type=N'COLUMN',@level2name=N'ESTABLECIMIENTO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Observacion al momento de registro del chip' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA_UBA', @level2type=N'COLUMN',@level2name=N'OBSERVACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Acuerdo de responsabilidad' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA_UBA', @level2type=N'COLUMN',@level2name=N'ACUERDO_RESPONSABILIDAD'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado: ACT = ACTIVO INA = INACTIVO ITE=INACTIVO TEMPORAL' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA_UBA', @level2type=N'COLUMN',@level2name=N'ESTADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se crea el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA_UBA', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA_UBA', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA_UBA', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de la ultima modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA_UBA', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA_UBA', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA_UBA', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla para contener datos de Chips de Animales de Compania' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_MICROCHIP_MASCOTA_UBA'
GO


CREATE TABLE Remetfu.[REM_CONTROL_ACCESO](
	[CONTROL_ACCESO_ID] [bigint] identity(1,1) NOT NULL,
	[TERMINAL_CONEXION] [varchar](30) NOT NULL,
	[USUARIO_ID] [bigint] NOT NULL,
	CONSTRAINT [REM_CONTROL_ACCESO_FKY01] FOREIGN KEY([USUARIO_ID])
	REFERENCES [Remetfu].[REM_USUARIOS] ([USUARIO_ID]),
	[NOVEDAD1] [varchar](80) NULL,
	[NOVEDAD2] [varchar](80) NULL,
	[FECHA_ACCESO] [datetime] NOT NULL,
	[RESPUESTA] [varchar](80) NULL,
 CONSTRAINT [REM_CONTROL_ACCESO_PKY] PRIMARY KEY CLUSTERED 
(
	[CONTROL_ACCESO_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de Acceso' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_CONTROL_ACCESO', @level2type=N'COLUMN',@level2name=N'CONTROL_ACCESO_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal/IP desde donde se conecta el usuario' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_CONTROL_ACCESO', @level2type=N'COLUMN',@level2name=N'TERMINAL_CONEXION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'C digo de usuario que se conecta al sistema' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_CONTROL_ACCESO', @level2type=N'COLUMN',@level2name=N'USUARIO_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Campo de datos Libre' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_CONTROL_ACCESO', @level2type=N'COLUMN',@level2name=N'NOVEDAD1'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Campo de datos Libre' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_CONTROL_ACCESO', @level2type=N'COLUMN',@level2name=N'NOVEDAD2'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha/Hora de Conexion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_CONTROL_ACCESO', @level2type=N'COLUMN',@level2name=N'FECHA_ACCESO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Respuesta de conexion, se conecta o no' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_CONTROL_ACCESO', @level2type=N'COLUMN',@level2name=N'RESPUESTA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla que contendra datos de conexion al sistema' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_CONTROL_ACCESO'
GO


-------------------------------------------------------------------------------------------------------------

--DROP TABLE Remetfu.[REM_RETIRO_ANIMALES]
--GO

CREATE TABLE Remetfu.[REM_RETIRO_ANIMALES](
	[RETIRO_ANIMALES_ID] [bigint] IDENTITY(1,1) NOT NULL,
	[FUNCIONARIO_UBA] [bigint] NOT NULL,
	CONSTRAINT REM_RETIRO_ANIMALES_FKY02 FOREIGN KEY (FUNCIONARIO_UBA)
        REFERENCES Remetfu.REM_USUARIOS(USUARIO_ID),
	[ADM_ZONAL] [int] NOT NULL,
	CONSTRAINT REM_RETIRO_ANIMALES_FKY03 FOREIGN KEY (ADM_ZONAL)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[PARROQUIA] [int] NOT NULL,
	CONSTRAINT REM_RETIRO_ANIMALES_FKY04 FOREIGN KEY (PARROQUIA)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[BARRIO] [varchar](150) NULL,
	[CALLE_PRINCIPAL] [varchar](150) NULL,
	[CALLE_NUMERO] [varchar](15) NULL,
	[CALLE_SECUNDARIA] [varchar](150) NULL,
	[CALLE_REFERENCIA1] [varchar](150) NULL,
	[CALLE_REFERENCIA2] [varchar](150) NULL,	
	[MOTIVO_RETIRO] [int] NOT NULL,
	CONSTRAINT REM_RETIRO_ANIMALES_FKY05 FOREIGN KEY (MOTIVO_RETIRO)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[MOTIVO_RETIRO_ARCHIVO] [uniqueidentifier] NULL,
	CONSTRAINT REM_RETIRO_ANIMALES_FKY08 FOREIGN KEY (MOTIVO_RETIRO_ARCHIVO)
        REFERENCES Remetfu.REM_ARCHIVOS(ARCHIVO_ID),
	[OBSERVACION_RETIRO] [varchar](800) NULL,
	[ESTADO_TUTORIA] [int] NOT NULL,
	CONSTRAINT REM_RETIRO_ANIMALES_FKY06 FOREIGN KEY (ESTADO_TUTORIA)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[TUTOR_CONDICION_CALLE] [varchar](03) NOT NULL,
	CONSTRAINT REM_RETIRO_ANIMALES_CHK04 CHECK( TUTOR_CONDICION_CALLE IN('SI','NO') ),
	[OBSERVACION_TUTOR] [varchar](800) NULL,
	[SITUACION_INTERVENCION] [int] NOT NULL,
	CONSTRAINT REM_RETIRO_ANIMALES_FKY07 FOREIGN KEY (SITUACION_INTERVENCION)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[OBSERVACION_INTERVENCION] [varchar](800) NULL,
	[ACUERDO_RESPONSABILIDAD] [varchar](03) NOT NULL,
	[FECHA_REGISTRO] [datetime] NOT NULL,
	[ESTADO] [char](3) NOT NULL,
	CONSTRAINT REM_RETIRO_ANIMALES_CHK10 CHECK( ESTADO IN('ACT','INA','ITE')),
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
 CONSTRAINT [REM_RETIRO_ANIMALES_PKY] PRIMARY KEY CLUSTERED 
(
	[RETIRO_ANIMALES_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de Secuencial de retiro del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RETIRO_ANIMALES', @level2type=N'COLUMN',@level2name=N'RETIRO_ANIMALES_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Identificacion del funcionario que entrega el animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RETIRO_ANIMALES', @level2type=N'COLUMN',@level2name=N'FUNCIONARIO_UBA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Administración Zonal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RETIRO_ANIMALES', @level2type=N'COLUMN',@level2name=N'ADM_ZONAL'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Parroquia' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RETIRO_ANIMALES', @level2type=N'COLUMN',@level2name=N'PARROQUIA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Barrio de residencia del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RETIRO_ANIMALES', @level2type=N'COLUMN',@level2name=N'BARRIO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Calle principal de direccion del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RETIRO_ANIMALES', @level2type=N'COLUMN',@level2name=N'CALLE_PRINCIPAL'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Numero de calle de direccion del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RETIRO_ANIMALES', @level2type=N'COLUMN',@level2name=N'CALLE_NUMERO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Calle secundaria de direccion del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RETIRO_ANIMALES', @level2type=N'COLUMN',@level2name=N'CALLE_SECUNDARIA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Referencia de direccion del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RETIRO_ANIMALES', @level2type=N'COLUMN',@level2name=N'CALLE_REFERENCIA1'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Referencia2 de direccion del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RETIRO_ANIMALES', @level2type=N'COLUMN',@level2name=N'CALLE_REFERENCIA2'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Motivo de Retiro del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RETIRO_ANIMALES', @level2type=N'COLUMN',@level2name=N'MOTIVO_RETIRO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Identificador unico del archivo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RETIRO_ANIMALES', @level2type=N'COLUMN',@level2name=N'MOTIVO_RETIRO_ARCHIVO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Observaciones Motivo de Retiro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RETIRO_ANIMALES', @level2type=N'COLUMN',@level2name=N'OBSERVACION_RETIRO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado tutoria' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RETIRO_ANIMALES', @level2type=N'COLUMN',@level2name=N'ESTADO_TUTORIA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Condición de Calle del tutor' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RETIRO_ANIMALES', @level2type=N'COLUMN',@level2name=N'TUTOR_CONDICION_CALLE'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Observaciones tutor' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RETIRO_ANIMALES', @level2type=N'COLUMN',@level2name=N'OBSERVACION_TUTOR'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Situacion intervencion del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RETIRO_ANIMALES', @level2type=N'COLUMN',@level2name=N'SITUACION_INTERVENCION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Observaciones Situacion intervencion del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RETIRO_ANIMALES', @level2type=N'COLUMN',@level2name=N'OBSERVACION_INTERVENCION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Acepta Acuerdo de Responsabilidad' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RETIRO_ANIMALES', @level2type=N'COLUMN',@level2name=N'ACUERDO_RESPONSABILIDAD'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de Registro del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RETIRO_ANIMALES', @level2type=N'COLUMN',@level2name=N'FECHA_REGISTRO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado: ACT = ACTIVO INA = INACTIVO ITE=INACTIVO TEMPORAL' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RETIRO_ANIMALES', @level2type=N'COLUMN',@level2name=N'ESTADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se crea el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RETIRO_ANIMALES', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RETIRO_ANIMALES', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RETIRO_ANIMALES', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de la ultima modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RETIRO_ANIMALES', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RETIRO_ANIMALES', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RETIRO_ANIMALES', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla para contener datos de Retiro de Animales de Compania' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RETIRO_ANIMALES'
GO

CREATE TABLE Remetfu.[REM_ANIMAL_TUTOR](
	[ANIMAL_TUTOR_ID] [bigint] IDENTITY(1,1) NOT NULL,
	[SECUENCIAL_TMP] [bigint] NOT NULL,
	[SECUENCIAL_FINAL] [bigint] NOT NULL,
	[TUTOR_ID] bigint NOT NULL,
	CONSTRAINT REM_ANIMAL_TUTOR_FKY01 FOREIGN KEY (TUTOR_ID)
        REFERENCES Remetfu.REM_TUTOR_MASCOTA(TUTOR_ID),
	[COMUNITARIO] [varchar](02) NOT NULL,
	CONSTRAINT REM_ANIMAL_TUTOR_CHK01 CHECK( COMUNITARIO IN('SI','NO')),
	[ESTADO_TUTORIA] [int] NOT NULL,
	CONSTRAINT REM_ANIMAL_TUTOR_FKY02 FOREIGN KEY (ESTADO_TUTORIA)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[PROCEDENCIA_ANIMAL] [int] NOT NULL,
	CONSTRAINT REM_ANIMAL_TUTOR_FKY03 FOREIGN KEY (ESTADO_TUTORIA)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[MICROCHIP_MASCOTA_ID] [bigint] NULL,
	CONSTRAINT REM_ANIMAL_TUTOR_FKY05 FOREIGN KEY (MICROCHIP_MASCOTA_ID)
        REFERENCES Remetfu.REM_MICROCHIP_MASCOTA(MICROCHIP_MASCOTA_ID),
	[OBSERVACION_MICROCHIP] [varchar](300) NULL,
	[NOMBRE_ANIMAL] [varchar](100) NOT NULL,
	[FECHA_NACIMIENTO] [datetime] NOT NULL,
	[ESPECIE] [int] NOT NULL,
	CONSTRAINT REM_ANIMAL_TUTOR_FKY06 FOREIGN KEY (ESPECIE)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[RAZA] [int] NOT NULL,
	CONSTRAINT REM_ANIMAL_TUTOR_FKY07 FOREIGN KEY (RAZA)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[SEXO] [int] NOT NULL,
	CONSTRAINT REM_ANIMAL_TUTOR_FKY08 FOREIGN KEY (SEXO)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[ESTADO_REPRODUCTIVO] [int] NOT NULL,
	CONSTRAINT REM_ANIMAL_TUTOR_FKY09 FOREIGN KEY (ESTADO_REPRODUCTIVO)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[COLOR_PREDOMINANTE] [int] NOT NULL,
	CONSTRAINT REM_ANIMAL_TUTOR_FKY10 FOREIGN KEY (COLOR_PREDOMINANTE)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[COLOR_SECUNDARIO] [int] NOT NULL,
	CONSTRAINT REM_ANIMAL_TUTOR_FKY11 FOREIGN KEY (COLOR_SECUNDARIO)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[SENIALES_PARTICULARES] [varchar](300) NULL,
	[IDENTIFICACION_FOTOGRAFICA1] [uniqueidentifier] NULL,
	CONSTRAINT REM_ANIMAL_TUTOR_FKY19 FOREIGN KEY (IDENTIFICACION_FOTOGRAFICA1)
        REFERENCES Remetfu.REM_ARCHIVOS(ARCHIVO_ID),
	[IDENTIFICACION_FOTOGRAFICA2] [uniqueidentifier] NULL,
	CONSTRAINT REM_ANIMAL_TUTOR_FKY20 FOREIGN KEY (IDENTIFICACION_FOTOGRAFICA2)
        REFERENCES Remetfu.REM_ARCHIVOS(ARCHIVO_ID),
	[IDENTIFICACION_VISIBLE] [uniqueidentifier] NULL,
	CONSTRAINT REM_ANIMAL_TUTOR_FKY21 FOREIGN KEY (IDENTIFICACION_VISIBLE)
        REFERENCES Remetfu.REM_ARCHIVOS(ARCHIVO_ID),
	[PERMANENCIA] [int] NOT NULL,
	CONSTRAINT REM_ANIMAL_TUTOR_FKY12 FOREIGN KEY (PERMANENCIA)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[PERMANENCIA_OTROS] [varchar](50) NULL,
	[PARROQUIA] [int] NOT NULL,
	CONSTRAINT REM_ANIMAL_TUTOR_FKY13 FOREIGN KEY (PARROQUIA)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[BARRIO] [varchar](150) NULL,
	[CALLE_PRINCIPAL] [varchar](150) NULL,
	[CALLE_NUMERO] [varchar](15) NULL,
	[CALLE_SECUNDARIA] [varchar](150) NULL,
	[CALLE_REFERENCIA1] [varchar](150) NULL,
	[CALLE_REFERENCIA2] [varchar](150) NULL,	
	[TIPO_VIVIENDA] [int] NOT NULL,
	CONSTRAINT REM_ANIMAL_TUTOR_FKY14 FOREIGN KEY (TIPO_VIVIENDA)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[MT2_VIVIENDA] [numeric](5,2) NULL,
	[MT2_PERMANENCIA] [numeric](5,2) NULL,
	[CERRAMIENTO] [varchar](03) NOT NULL,
	CONSTRAINT REM_ANIMAL_TUTOR_CHK04 CHECK( CERRAMIENTO IN('SI','NO') ),
	[ESTATUS_VIVIENDA] [int] NOT NULL,
	CONSTRAINT REM_ANIMAL_TUTOR_FKY15 FOREIGN KEY (TIPO_VIVIENDA)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[ESTATUS_VIVIENDA_OTROS] [varchar](50) NULL,
	[ENFERMEDAD_CATASTROFICA] [varchar](03) NOT NULL,
	CONSTRAINT REM_ANIMAL_TUTOR_CHK05 CHECK( ENFERMEDAD_CATASTROFICA IN('SI','NO') ),
	[DESCRIPCION_ENFERMEDAD] [varchar](300) NULL,
	[EXAMEN_COMPORTAMENTAL] [varchar](03) NOT NULL,
	CONSTRAINT REM_ANIMAL_TUTOR_CHK06 CHECK( EXAMEN_COMPORTAMENTAL IN('SI','NO') ),
	[EXAMEN_COMPORTAMENTAL_ARCHIVO] [uniqueidentifier] NULL,
	CONSTRAINT REM_ANIMAL_TUTOR_FKY24 FOREIGN KEY (EXAMEN_COMPORTAMENTAL_ARCHIVO)
        REFERENCES Remetfu.REM_ARCHIVOS(ARCHIVO_ID),
	[PRUEBA_COMPORTAMIENTO] [int] NULL,
	CONSTRAINT REM_ANIMAL_TUTOR_FKY16 FOREIGN KEY (PRUEBA_COMPORTAMIENTO)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[EXAMEN_FISICO] [varchar](300) NULL,
	[CERTIFICADO_VACUNACION] [varchar](03) NOT NULL,
	CONSTRAINT REM_ANIMAL_TUTOR_CHK07 CHECK( CERTIFICADO_VACUNACION IN('SI','NO') ),
	[CERTIFICADO_VACUNACION_ARCHIVO] [uniqueidentifier] NULL,
	CONSTRAINT REM_ANIMAL_TUTOR_FKY22 FOREIGN KEY (CERTIFICADO_VACUNACION_ARCHIVO)
        REFERENCES Remetfu.REM_ARCHIVOS(ARCHIVO_ID),
	[CERTIFICADO_ESTERILIZACION] [varchar](03) NOT NULL,
	CONSTRAINT REM_ANIMAL_TUTOR_CHK08 CHECK( CERTIFICADO_ESTERILIZACION IN('SI','NO') ),
	[CERTIFICADO_ESTERILIZACION_ARCHIVO] [uniqueidentifier] NULL,
	CONSTRAINT REM_ANIMAL_TUTOR_FKY23 FOREIGN KEY (CERTIFICADO_ESTERILIZACION_ARCHIVO)
        REFERENCES Remetfu.REM_ARCHIVOS(ARCHIVO_ID),
	[FECHA_FALLECIMIENTO] [datetime] NULL,
	[MOTIVO_FALLECIMIENTO] [int] NULL,
	CONSTRAINT REM_ANIMAL_TUTOR_FKY17 FOREIGN KEY (MOTIVO_FALLECIMIENTO)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[ACUERDO_RESPONSABILIDAD] [varchar](03) NOT NULL,
	CONSTRAINT REM_ANIMAL_TUTOR_CHK09 CHECK( ACUERDO_RESPONSABILIDAD IN('SI','NO') ),
	[FECHA_REGISTRO] [datetime] NOT NULL,
	[ESTADO] [int] NOT NULL,
	CONSTRAINT REM_ANIMAL_TUTOR_FKY25 FOREIGN KEY (ESTADO)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
 CONSTRAINT [REM_ANIMAL_TUTOR_PKY] PRIMARY KEY CLUSTERED 
(
	[ANIMAL_TUTOR_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de Secuencial de registro del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'ANIMAL_TUTOR_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Secuencial Temporal Preregistro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'SECUENCIAL_TMP'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Secuencial Final Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'SECUENCIAL_FINAL'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo del Tutor' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'TUTOR_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Comunitario S/N' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'COMUNITARIO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado de la Tutoria' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'ESTADO_TUTORIA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Procedencia del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'PROCEDENCIA_ANIMAL'
GO
--EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tipo de animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'TIPO_ANIMAL'
--GO
--EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Identificador unico del archivo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'ANEXO_VISIBLE'
--GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo microchip' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'MICROCHIP_MASCOTA_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Observaciones microchip' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'OBSERVACION_MICROCHIP'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Nombre animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'NOMBRE_ANIMAL'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha nacimiento del animal, fecha aproximada' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'FECHA_NACIMIENTO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Especie del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'ESPECIE'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Raza del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'RAZA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Sexo del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'SEXO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado Reproductivo del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'ESTADO_REPRODUCTIVO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Color predominante del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'COLOR_PREDOMINANTE'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Color secundario del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'COLOR_SECUNDARIO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Señales particulares del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'SENIALES_PARTICULARES'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Identificador unico del archivo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'IDENTIFICACION_FOTOGRAFICA1'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Identificador unico del archivo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'IDENTIFICACION_FOTOGRAFICA2'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Identificador unico del archivo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'IDENTIFICACION_VISIBLE'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Lugar de Permanencia del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'PERMANENCIA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Descripcion del otro lugar de permanencia del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'PERMANENCIA_OTROS'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Parroquia de residencia del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'PARROQUIA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Barrio de residencia del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'BARRIO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Calle principal de direccion del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'CALLE_PRINCIPAL'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Numero de calle de direccion del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'CALLE_NUMERO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Calle secundaria de direccion del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'CALLE_SECUNDARIA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Referencia de direccion del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'CALLE_REFERENCIA1'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Referencia2 de direccion del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'CALLE_REFERENCIA2'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tipo de Vivienda del tutor' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'TIPO_VIVIENDA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Metros cuadrados de la vivienda' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'MT2_VIVIENDA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Metros cuadrados del lugar de permanencia del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'MT2_PERMANENCIA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Identifica si la vivienda tiene cerramiento' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'CERRAMIENTO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estatus de la vivienda del tutor' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'ESTATUS_VIVIENDA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Descripcion en caso de otro tipo de estatus diferente al catalogo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'ESTATUS_VIVIENDA_OTROS'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Identifica si el animal tiene enfermedad catastrofica' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'ENFERMEDAD_CATASTROFICA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Descripcion de la enfermedad en caso de escoger si' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'DESCRIPCION_ENFERMEDAD'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Examen comportamental' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'EXAMEN_COMPORTAMENTAL'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Prueba del examen comportamental' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'PRUEBA_COMPORTAMIENTO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Prueba digital de examen comportamental' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'EXAMEN_COMPORTAMENTAL_ARCHIVO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Descripcion del examen fisico realizado al animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'EXAMEN_FISICO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Identificación si el animal tiene vacunas' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'CERTIFICADO_VACUNACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Identificador unico del archivo de vacunacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'CERTIFICADO_VACUNACION_ARCHIVO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Identificación si el animal ha sido esterelizado' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'CERTIFICADO_ESTERILIZACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Identificador unico del archivo de certificado de esterelizacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'CERTIFICADO_ESTERILIZACION_ARCHIVO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de Fallecimiento' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'FECHA_FALLECIMIENTO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Motivo de fallecimiento' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'MOTIVO_FALLECIMIENTO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Acepta Acuerdo de Responsabilidad' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'ACUERDO_RESPONSABILIDAD'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de Registro del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'FECHA_REGISTRO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado: ACT = ACTIVO INA = INACTIVO ITE=INACTIVO TEMPORAL' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'ESTADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se crea el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de la ultima modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla para contener datos de Animales de Compania con tutor' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ANIMAL_TUTOR'
GO

CREATE TABLE Remetfu.[REM_TUTORES_COMUNITARIOS](
	[TUTORES_COMUNITARIOS_ID] [bigint] IDENTITY(1,1) NOT NULL,
	[ANIMAL_TUTOR_ID] [bigint] NOT NULL,
	CONSTRAINT REM_TUTORES_COMUNITARIOS_FKY01 FOREIGN KEY (ANIMAL_TUTOR_ID)
        REFERENCES Remetfu.REM_ANIMAL_TUTOR(ANIMAL_TUTOR_ID),
	[TUTOR_ID] bigint NULL,
	CONSTRAINT REM_TUTORES_COMUNITARIOS_FKY02 FOREIGN KEY (TUTOR_ID)
        REFERENCES Remetfu.REM_TUTOR_MASCOTA(TUTOR_ID),
 CONSTRAINT [REM_TUTORES_COMUNITARIOS_PKY] PRIMARY KEY CLUSTERED 
(
	[TUTORES_COMUNITARIOS_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de Secuencial de tutores comunitarios' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TUTORES_COMUNITARIOS', @level2type=N'COLUMN',@level2name=N'TUTORES_COMUNITARIOS_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo del Animal Tutor' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TUTORES_COMUNITARIOS', @level2type=N'COLUMN',@level2name=N'ANIMAL_TUTOR_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de Tutor' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TUTORES_COMUNITARIOS', @level2type=N'COLUMN',@level2name=N'TUTOR_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla para contener datos de Tutores Comunitarios de Animales de Compania con tutor' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TUTORES_COMUNITARIOS'
GO

CREATE TABLE Remetfu.[REM_TIPO_ANIMAL_TUTOR](
	[TIPO_ANIMAL_TUTOR_ID] [bigint] IDENTITY(1,1) NOT NULL,
	[ANIMAL_TUTOR_ID] [bigint] NOT NULL,
	CONSTRAINT REM_TIPO_ANIMAL_TUTOR_FKY01 FOREIGN KEY (ANIMAL_TUTOR_ID)
        REFERENCES Remetfu.REM_ANIMAL_TUTOR(ANIMAL_TUTOR_ID),
	[TIPO_ANIMAL] [int] NOT NULL,
	CONSTRAINT REM_TIPO_ANIMAL_TUTOR_FKY02 FOREIGN KEY (TIPO_ANIMAL)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
 	[DOCUMENTO_ACREDITA] [uniqueidentifier] NULL,
	CONSTRAINT REM_TIPO_ANIMAL_TUTOR_FKY03 FOREIGN KEY (DOCUMENTO_ACREDITA)
        REFERENCES Remetfu.REM_ARCHIVOS(ARCHIVO_ID),
	[NOMBRE_INSTITUCION] [varchar](50) NULL,
	[TELEFONO_INSTITUCION] [varchar](15) NULL,
CONSTRAINT [REM_TIPO_ANIMAL_TUTOR_PKY] PRIMARY KEY CLUSTERED 
(
	[TIPO_ANIMAL_TUTOR_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de Secuencial de tipo de animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TIPO_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'TIPO_ANIMAL_TUTOR_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo del Animal Tutor' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TIPO_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'ANIMAL_TUTOR_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de tipo de animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TIPO_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'TIPO_ANIMAL'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Documento que certifica el tipo de animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TIPO_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'DOCUMENTO_ACREDITA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Nombre de la institucion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TIPO_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'NOMBRE_INSTITUCION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Telefono de la institucion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TIPO_ANIMAL_TUTOR', @level2type=N'COLUMN',@level2name=N'TELEFONO_INSTITUCION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla para contener datos de tipos y caracteristicas de Animales de Compania' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_TIPO_ANIMAL_TUTOR'
GO


--IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'Remetfu.[REM_RECEPCION_ANIMALES]') AND type in (N'U'))
--DROP TABLE Remetfu.[REM_RECEPCION_ANIMALES]
--GO

CREATE TABLE Remetfu.[REM_RECEPCION_ANIMALES](
	[RECEPCION_ANIMALES_ID] [bigint] IDENTITY(1,1) NOT NULL,
	[FUNCIONARIO_UBA] [bigint] NOT NULL,
	CONSTRAINT REM_RECEPCION_ANIMALES_FKY01 FOREIGN KEY (FUNCIONARIO_UBA)
        REFERENCES Remetfu.REM_USUARIOS(USUARIO_ID),
	[AGENCIA_UBA] [int] NOT NULL,
	CONSTRAINT REM_RECEPCION_ANIMALES_FKY02 FOREIGN KEY (AGENCIA_UBA)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[ESPECIE] [int] NOT NULL,
	CONSTRAINT REM_RECEPCION_ANIMALES_FKY03 FOREIGN KEY (ESPECIE)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[RAZA] [int] NOT NULL,
	CONSTRAINT REM_RECEPCION_ANIMALES_FKY04 FOREIGN KEY (RAZA)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[SEXO] [int] NOT NULL,
	CONSTRAINT REM_RECEPCION_ANIMALES_FKY05 FOREIGN KEY (SEXO)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[ESTADO_REPRODUCTIVO] [int] NOT NULL,
	CONSTRAINT REM_RECEPCION_ANIMALES_FKY06 FOREIGN KEY (ESTADO_REPRODUCTIVO)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[COLOR_PREDOMINANTE] [int] NOT NULL,
	CONSTRAINT REM_RECEPCION_ANIMALES_FKY07 FOREIGN KEY (COLOR_PREDOMINANTE)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[COLOR_SECUNDARIO] [int] NOT NULL,
	CONSTRAINT REM_RECEPCION_ANIMALES_FKY08 FOREIGN KEY (COLOR_SECUNDARIO)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[SENIALES_PARTICULARES] [varchar](300) NULL,
	[PROCESO_EJECUCION] [int] NOT NULL,
	CONSTRAINT REM_RECEPCION_ANIMALES_FKY09 FOREIGN KEY (PROCESO_EJECUCION)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[DESCRIPCION_PROCESO] [varchar](250) NULL,
	[EXAMEN_COMPORTAMENTAL] [varchar](03) NOT NULL,
	CONSTRAINT REM_RECEPCION_ANIMALES_CHK06 CHECK( EXAMEN_COMPORTAMENTAL IN('SI','NO') ),
	[PRUEBA_COMPORTAMIENTO] [int] NULL,
	CONSTRAINT REM_RECEPCION_ANIMALES_FKY10 FOREIGN KEY (PRUEBA_COMPORTAMIENTO)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[ACUERDO_RESPONSABILIDAD] [varchar](03) NOT NULL,
	[FECHA_REGISTRO] [datetime] NOT NULL,
	[ESTADO] [char](3) NOT NULL,
	CONSTRAINT REM_RECEPCION_ANIMALES_CHK10 CHECK( ESTADO IN('ACT','INA','ITE')),
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
 CONSTRAINT [REM_RECEPCION_ANIMALES_PKY] PRIMARY KEY CLUSTERED 
(
	[RECEPCION_ANIMALES_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de Secuencial de recepcion del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RECEPCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'RECEPCION_ANIMALES_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Identificacion del funcionario que recibe el animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RECEPCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'FUNCIONARIO_UBA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Agencia UBA' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RECEPCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'AGENCIA_UBA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Especie del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RECEPCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'ESPECIE'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Raza del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RECEPCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'RAZA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Sexo del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RECEPCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'SEXO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado Reproductivo del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RECEPCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'ESTADO_REPRODUCTIVO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Color predominante del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RECEPCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'COLOR_PREDOMINANTE'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Color secundario del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RECEPCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'COLOR_SECUNDARIO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Señales particulares del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RECEPCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'SENIALES_PARTICULARES'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Proceso en ejecucion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RECEPCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'PROCESO_EJECUCION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Descripcion del proceso en ejecucion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RECEPCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'DESCRIPCION_PROCESO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Examen comportamental' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RECEPCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'EXAMEN_COMPORTAMENTAL'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Prueba del examen comportamental' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RECEPCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'PRUEBA_COMPORTAMIENTO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Acepta Acuerdo de Responsabilidad' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RECEPCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'ACUERDO_RESPONSABILIDAD'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de Registro del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RECEPCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'FECHA_REGISTRO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado: ACT = ACTIVO INA = INACTIVO ITE=INACTIVO TEMPORAL' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RECEPCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'ESTADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se crea el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RECEPCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RECEPCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RECEPCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de la ultima modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RECEPCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RECEPCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RECEPCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla para contener datos de Recepcion de Animales de Compania' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RECEPCION_ANIMALES'
GO

--drop table Remetfu.[REM_ENFERMEDADES_ANIMALES]
--go
--drop table Remetfu.[REM_ATENCION_ANIMALES]
--go

CREATE TABLE Remetfu.[REM_ATENCION_ANIMALES](
	[ATENCION_ANIMALES_ID] [bigint] IDENTITY(1,1) NOT NULL,
	[FUNCIONARIO_UBA] [bigint] NOT NULL,
	CONSTRAINT REM_ATENCION_ANIMALES_FKY01 FOREIGN KEY (FUNCIONARIO_UBA)
        REFERENCES Remetfu.REM_USUARIOS(USUARIO_ID),
	[MICROCHIP_MASCOTA_ID] [bigint] NULL,
	CONSTRAINT REM_ATENCION_ANIMALES_FKY02 FOREIGN KEY (MICROCHIP_MASCOTA_ID)
        REFERENCES Remetfu.REM_MICROCHIP_MASCOTA(MICROCHIP_MASCOTA_ID),
	[NOMBRE_ANIMAL] [varchar](100) NOT NULL,
	[IDENTIFICACION_FOTOGRAFICA1] [uniqueidentifier] NULL,
	CONSTRAINT REM_ATENCION_ANIMALES_FKY06 FOREIGN KEY (IDENTIFICACION_FOTOGRAFICA1)
        REFERENCES Remetfu.REM_ARCHIVOS(ARCHIVO_ID),
	[IDENTIFICACION_FOTOGRAFICA2] [uniqueidentifier] NULL,
	CONSTRAINT REM_ATENCION_ANIMALES_FKY07 FOREIGN KEY (IDENTIFICACION_FOTOGRAFICA2)
        REFERENCES Remetfu.REM_ARCHIVOS(ARCHIVO_ID),
	[FECHA_NACIMIENTO] [datetime] NOT NULL,
	[TIPO_IDENTIFICACION_VISIBLE] [int] NOT NULL,
	CONSTRAINT REM_ATENCION_ANIMALES_FKY03 FOREIGN KEY (TIPO_IDENTIFICACION_VISIBLE)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[IDENTIFICACION_VISIBLE] [uniqueidentifier] NULL,
	CONSTRAINT REM_ATENCION_ANIMALES_FKY08 FOREIGN KEY (IDENTIFICACION_VISIBLE)
        REFERENCES Remetfu.REM_ARCHIVOS(ARCHIVO_ID),
	[ESTADO_CHEQUEO] [int] NOT NULL,
	CONSTRAINT REM_ATENCION_ANIMALES_FKY04 FOREIGN KEY (ESTADO_CHEQUEO)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[ATENCION_REALIZADA] [int] NOT NULL,
	CONSTRAINT REM_ATENCION_ANIMALES_FKY05 FOREIGN KEY (ATENCION_REALIZADA)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[OBSERVACIONES] [varchar](300) NOT NULL,
	[FECHA_REGISTRO] [datetime] NOT NULL,
	[ESTADO] [char](3) NOT NULL,
	CONSTRAINT REM_ATENCION_ANIMALES_CHK1 CHECK( ESTADO IN('ACT','INA','ITE')),
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
 CONSTRAINT [REM_ATENCION_ANIMALES_PKY] PRIMARY KEY CLUSTERED 
(
	[ATENCION_ANIMALES_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de Secuencial de datos tecnicos del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ATENCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'ATENCION_ANIMALES_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Identificacion del Veterinario UBA que atiende al animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ATENCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'FUNCIONARIO_UBA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Chip Mascota' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ATENCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'MICROCHIP_MASCOTA_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Nombre del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ATENCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'NOMBRE_ANIMAL'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Identificador unico del archivo foto1 animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ATENCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'IDENTIFICACION_FOTOGRAFICA1'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Identificador unico del archivo foto2 animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ATENCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'IDENTIFICACION_FOTOGRAFICA2'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de Nacimiento' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ATENCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'FECHA_NACIMIENTO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tipo de Identificacion visible' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ATENCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'TIPO_IDENTIFICACION_VISIBLE'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Identificador unico del Archivo identificacion visible' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ATENCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'IDENTIFICACION_VISIBLE'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado Chequeo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ATENCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'ESTADO_CHEQUEO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Atencion realizada al animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ATENCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'ATENCION_REALIZADA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Observaciones sobre el chequeo realizado' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ATENCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'OBSERVACIONES'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de Registro del chequeo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ATENCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'FECHA_REGISTRO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado: ACT = ACTIVO INA = INACTIVO ITE=INACTIVO TEMPORAL' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ATENCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'ESTADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se crea el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ATENCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ATENCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ATENCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de la ultima modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ATENCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ATENCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ATENCION_ANIMALES', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla para contener datos de Atención de Animales de Compania' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ATENCION_ANIMALES'
GO


CREATE TABLE Remetfu.[REM_ENFERMEDADES_ANIMALES](
	[ENFERMEDADES_ANIMALES_ID] [bigint] IDENTITY(1,1) NOT NULL,
	[ATENCION_ANIMALES_ID] [bigint] NOT NULL,
	CONSTRAINT REM_ENFERMEDADES_ANIMALES_FKY01 FOREIGN KEY (ATENCION_ANIMALES_ID)
        REFERENCES Remetfu.REM_ATENCION_ANIMALES(ATENCION_ANIMALES_ID),
	[ENFERMEDADES_DETECTADAS] [int] NOT NULL,
	CONSTRAINT REM_ENFERMEDADES_ANIMALES_FKY02 FOREIGN KEY (ENFERMEDADES_DETECTADAS)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[FECHA_REGISTRO] [datetime] NOT NULL,
	[ESTADO] [char](3) NOT NULL,
	CONSTRAINT REM_ENFERMEDADES_ANIMALES_CHK10 CHECK( ESTADO IN('ACT','INA','ITE')),
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
 CONSTRAINT [REM_ENFERMEDADES_ANIMALES_PKY] PRIMARY KEY CLUSTERED 
(
	[ENFERMEDADES_ANIMALES_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO


EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de Secuencial de registro de enfermedades del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ENFERMEDADES_ANIMALES', @level2type=N'COLUMN',@level2name=N'ENFERMEDADES_ANIMALES_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de Secuencial de datos tecnicos del animal' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ENFERMEDADES_ANIMALES', @level2type=N'COLUMN',@level2name=N'ATENCION_ANIMALES_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de enfermedad sobre el chequeo realizado' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ENFERMEDADES_ANIMALES', @level2type=N'COLUMN',@level2name=N'ENFERMEDADES_DETECTADAS'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de Registro del chequeo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ENFERMEDADES_ANIMALES', @level2type=N'COLUMN',@level2name=N'FECHA_REGISTRO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado: ACT = ACTIVO INA = INACTIVO ITE=INACTIVO TEMPORAL' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ENFERMEDADES_ANIMALES', @level2type=N'COLUMN',@level2name=N'ESTADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se crea el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ENFERMEDADES_ANIMALES', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ENFERMEDADES_ANIMALES', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ENFERMEDADES_ANIMALES', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de la ultima modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ENFERMEDADES_ANIMALES', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ENFERMEDADES_ANIMALES', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ENFERMEDADES_ANIMALES', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla para contener datos de Atención de Animales de Compania' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ENFERMEDADES_ANIMALES'
GO


CREATE TABLE Remetfu.[REM_COMITE_ETICA_CAB](
	[COMITE_ETICA_CAB_ID] [bigint] IDENTITY(1,1) NOT NULL,
	[NOMBRE_INSTITUCION] [varchar](300) NOT NULL,
	[FACULTAD_INVESTIGACION] [varchar](300) NOT NULL,
	[FECHA_REGISTRO] [datetime] NOT NULL,
	[ESTADO] [char](3) NOT NULL,
	CONSTRAINT REM_COMITE_ETICA_CAB_CHK01 CHECK( ESTADO IN('ACT','INA','ITE')),
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
 CONSTRAINT [REM_COMITE_ETICA_CAB_PKY] PRIMARY KEY CLUSTERED 
(
	[COMITE_ETICA_CAB_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO


EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de Secuencial de Comites de Etica' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_COMITE_ETICA_CAB', @level2type=N'COLUMN',@level2name=N'COMITE_ETICA_CAB_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Nombre de la Institución que realiza a investigacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_COMITE_ETICA_CAB', @level2type=N'COLUMN',@level2name=N'NOMBRE_INSTITUCION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Nombre de la Facultad o intitucion de investigacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_COMITE_ETICA_CAB', @level2type=N'COLUMN',@level2name=N'FACULTAD_INVESTIGACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de Registro del chequeo' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_COMITE_ETICA_CAB', @level2type=N'COLUMN',@level2name=N'FECHA_REGISTRO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado: ACT = ACTIVO INA = INACTIVO ITE=INACTIVO TEMPORAL' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_COMITE_ETICA_CAB', @level2type=N'COLUMN',@level2name=N'ESTADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se crea el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_COMITE_ETICA_CAB', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_COMITE_ETICA_CAB', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_COMITE_ETICA_CAB', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de la ultima modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_COMITE_ETICA_CAB', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_COMITE_ETICA_CAB', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_COMITE_ETICA_CAB', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla para contener datos de la cabecera de Comites de etica' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_COMITE_ETICA_CAB'
GO

CREATE TABLE Remetfu.[REM_COMITE_ETICA_DET](
	[COMITE_ETICA_DET_ID] [bigint] IDENTITY(1,1) NOT NULL,
	[COMITE_ETICA_CAB_ID] [bigint] NOT NULL,
	CONSTRAINT REM_COMITE_ETICA_DET_FKY01 FOREIGN KEY (COMITE_ETICA_CAB_ID)
        REFERENCES Remetfu.REM_COMITE_ETICA_CAB(COMITE_ETICA_CAB_ID),
	[IDENTIFICACION] [varchar](15) NOT NULL,
	CONSTRAINT REM_COMITE_ETICA_DET_UNQ01 UNIQUE (COMITE_ETICA_CAB_ID,IDENTIFICACION),
	[NOMBRES] [varchar](100) NOT NULL,
	[CARGO] [int] NOT NULL,
	CONSTRAINT REM_COMITE_ETICA_DET_FKY03 FOREIGN KEY (CARGO)
        REFERENCES Remetfu.REM_CATALOGO(CATALOGO_ID),
	[NUMERO_SENECYT] [varchar](50) NULL,
	[CORREO] [varchar](50) NULL,
	[TELEFONO] [varchar](15) NULL,
	[ESTADO] [char](3) NOT NULL,
	CONSTRAINT REM_COMITE_ETICA_DET_CHK01 CHECK( ESTADO IN('ACT','INA','ITE')),
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
 CONSTRAINT [REM_COMITE_ETICA_DET_PKY] PRIMARY KEY CLUSTERED 
(
	[COMITE_ETICA_DET_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO


EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de Secuencial Detalle de Comites de Etica' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_COMITE_ETICA_DET', @level2type=N'COLUMN',@level2name=N'COMITE_ETICA_DET_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de Cabecera de Comites de Etica' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_COMITE_ETICA_DET', @level2type=N'COLUMN',@level2name=N'COMITE_ETICA_CAB_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Identificacion integrante del comite' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_COMITE_ETICA_DET', @level2type=N'COLUMN',@level2name=N'IDENTIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Nombre integrante del comite' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_COMITE_ETICA_DET', @level2type=N'COLUMN',@level2name=N'NOMBRES'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Cargo que ocupa dentro del comite' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_COMITE_ETICA_DET', @level2type=N'COLUMN',@level2name=N'CARGO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Numero Senecyt del integrante del comite' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_COMITE_ETICA_DET', @level2type=N'COLUMN',@level2name=N'NUMERO_SENECYT'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Correo integrante del comite' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_COMITE_ETICA_DET', @level2type=N'COLUMN',@level2name=N'CORREO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Telefono integrante del comite' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_COMITE_ETICA_DET', @level2type=N'COLUMN',@level2name=N'TELEFONO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado: ACT = ACTIVO INA = INACTIVO ITE=INACTIVO TEMPORAL' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_COMITE_ETICA_DET', @level2type=N'COLUMN',@level2name=N'ESTADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se crea el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_COMITE_ETICA_DET', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_COMITE_ETICA_DET', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_COMITE_ETICA_DET', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de la ultima modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_COMITE_ETICA_DET', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_COMITE_ETICA_DET', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_COMITE_ETICA_DET', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla para contener datos del Detalle de Comites de etica' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_COMITE_ETICA_DET'
GO

if exists (select 1 from  sysobjects where  id = object_id('Remetfu.REM_REMETFU') and   type = 'U')
   drop table Remetfu.REM_REMETFU
go

CREATE TABLE Remetfu.[REM_REMETFU](
	[REMETFU_ID] [bigint] IDENTITY(1,1) NOT NULL,
	[TIPO_IDENTIFICACION] [char](1) NOT NULL,
	[NRO_IDENTIFICACION] [char](13) NOT NULL,
	CONSTRAINT REM_REMETFU_UNQ01 UNIQUE(NRO_IDENTIFICACION),
	[NOMBRES] [varchar](50) NULL,
	[APELLIDOS] [varchar](50) NULL,
	[MAIL] [varchar](60) NULL,
	[DIRECCION] [char](200) NULL,
	[TELEFONO] [char](10) NULL,
	[MOVIL] [char](15) NULL,
	[FIRMA] image NULL,
	[ESTADO] [char](3) NULL,
	CONSTRAINT REM_REMETFU_CHK01 CHECK( ESTADO IN('ACT','INA','BLQ') ),
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
 CONSTRAINT [REM_REMETFU_PKY] PRIMARY KEY CLUSTERED 
(
	[REMETFU_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO


EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Codigo de Secuencial control de Empresa' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REMETFU', @level2type=N'COLUMN',@level2name=N'REMETFU_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tipo de Identificacion del director UBA' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REMETFU', @level2type=N'COLUMN',@level2name=N'TIPO_IDENTIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Numero de identificacion director UBA' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REMETFU', @level2type=N'COLUMN',@level2name=N'NRO_IDENTIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Nombres del director UBA' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REMETFU', @level2type=N'COLUMN',@level2name=N'NOMBRES'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Apellidos del director UBA' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REMETFU', @level2type=N'COLUMN',@level2name=N'APELLIDOS'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Correo electronico del director UBA' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REMETFU', @level2type=N'COLUMN',@level2name=N'MAIL'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Direccion del director UBA' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REMETFU', @level2type=N'COLUMN',@level2name=N'DIRECCION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Numero de telefono del director UBA' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REMETFU', @level2type=N'COLUMN',@level2name=N'TELEFONO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Numero de celular del director UBA' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REMETFU', @level2type=N'COLUMN',@level2name=N'MOVIL'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Firma del director del director UBA' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REMETFU', @level2type=N'COLUMN',@level2name=N'FIRMA'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado: ACT = ACTIVO INA = INACTIVO ITE=INACTIVO TEMPORAL' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REMETFU', @level2type=N'COLUMN',@level2name=N'ESTADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se crea el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REMETFU', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REMETFU', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REMETFU', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de la ultima modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REMETFU', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REMETFU', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REMETFU', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla para contener datos del Director de UBA' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_REMETFU'
GO

--DROP TABLE Remetfu.[REM_RUBROS_SAO]
CREATE TABLE Remetfu.[REM_RUBROS_SAO](
[RUBROS_SAO_ID] [numeric](5, 0) identity (1,1) NOT NULL,
[SAO_TIPO_ORDEN_PAGO_RUBRO_ID] [varchar](10) NULL,
[SAO_TIPO_ORDEN_PAGO_ID] [varchar](10) NULL,
[SAO_RUBRO_ID] [varchar](10) NULL,
[SAO_RUBRO_ANT] [varchar](10) NULL,
[SUBTIPO_REGISTRO_ID] [int] not NULL,
	CONSTRAINT REM_RUBROS_SAO_FKY03 FOREIGN KEY (SUBTIPO_REGISTRO_ID)
        REFERENCES Remetfu.REM_SUBTIPO_REGISTRO(SUBTIPO_REGISTRO_ID),
[SAO_DETALLE] [varchar](350) NULL,
	[ESTADO] [char](3) NULL,
	CONSTRAINT REM_RUBROS_SAO_CHK01 CHECK( ESTADO IN('ACT','INA','BLQ') ),
	[USUARIO_CREACION] [varchar](30) NOT NULL,
	[TERMINAL_CREACION] [varchar](30) NOT NULL,
	[FECHA_CREACION] [datetime] NOT NULL,
	[USUARIO_MODIFICACION] [varchar](30) NOT NULL,
	[TERMINAL_MODIFICACION] [varchar](30) NOT NULL,	
	[FECHA_MODIFICACION] [datetime] NOT NULL,
CONSTRAINT [PK_REM_RUBROS_SAO] PRIMARY KEY CLUSTERED
(
[RUBROS_SAO_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON REMETFU_IDX
) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Llave primaria de la tabla' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RUBROS_SAO', @level2type=N'COLUMN',@level2name=N'RUBROS_SAO_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'SAO TIPO ORDEN PAGO RUBRO ID' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RUBROS_SAO', @level2type=N'COLUMN',@level2name=N'SAO_TIPO_ORDEN_PAGO_RUBRO_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'SAO TIPO ORDEN PAGO ID' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RUBROS_SAO', @level2type=N'COLUMN',@level2name=N'SAO_TIPO_ORDEN_PAGO_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'SAO RUBRO ID' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RUBROS_SAO', @level2type=N'COLUMN',@level2name=N'SAO_RUBRO_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'SAO RUBRO ANTERIOR' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RUBROS_SAO', @level2type=N'COLUMN',@level2name=N'SAO_RUBRO_ANT'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'SUBTIPO DE REGISTRO' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RUBROS_SAO', @level2type=N'COLUMN',@level2name=N'SUBTIPO_REGISTRO_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Detalle' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RUBROS_SAO', @level2type=N'COLUMN',@level2name=N'SAO_DETALLE'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Estado: ACT = ACTIVO INA = INACTIVO ITE=INACTIVO TEMPORAL' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RUBROS_SAO', @level2type=N'COLUMN',@level2name=N'ESTADO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se crea el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RUBROS_SAO', @level2type=N'COLUMN',@level2name=N'USUARIO_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Usuario con el cual se modifica el registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RUBROS_SAO', @level2type=N'COLUMN',@level2name=N'USUARIO_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de creacion del Registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RUBROS_SAO', @level2type=N'COLUMN',@level2name=N'FECHA_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha de la ultima modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RUBROS_SAO', @level2type=N'COLUMN',@level2name=N'FECHA_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la creacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RUBROS_SAO', @level2type=N'COLUMN',@level2name=N'TERMINAL_CREACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Terminal utilizada para la modificacion' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RUBROS_SAO', @level2type=N'COLUMN',@level2name=N'TERMINAL_MODIFICACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla para parametrizar los tipos de rubros de SAO.' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_RUBROS_SAO'
GO

/*
CREATE TABLE Remetfu.[REM_ORDENES_PAGO](
[ORDEN_PAGO_ID] [int] IDENTITY(1,1) NOT NULL,
[LICENCIAS_ID] [varchar](50) NOT NULL,
[FECHA_REGISTRO] [datetime] NOT NULL,
[USUARIO_REGISTRO] [varchar](max) NOT NULL,
[VALOR] [decimal](18, 2) NOT NULL,
[CONCEPTO] [varchar](max) NOT NULL,
[IP] [varchar](max) NOT NULL,
[CI_DEUDOR] [varchar](15) NOT NULL,
[PROYECTO] [varchar](max) NOT NULL,
[OBSERVACION] [varchar](max) NULL,
[EC_SOLICITUD_ID] [varchar](50) NOT NULL,
[ORDEN_PAGO] [varchar](max) NOT NULL,
[ADICIONAL] [varchar](max) NULL,
[PARAMETRO] [varchar](max) NULL,
CONSTRAINT [REM_ORDENES_PAGO] PRIMARY KEY CLUSTERED
(
[ORDEN_PAGO_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON Remetfu
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

ALTER TABLE Remetfu.[REM_ORDENES_PAGO] WITH NOCHECK ADD CONSTRAINT [FK_GestionMunicipalEC_REM_ORDENES_PAGO_1] FOREIGN KEY([SLUM_LICENCIAS_ID])
REFERENCES Remetfu.[SLUM_LICENCIAS_CABECERA] ([SLUM_LICENCIAS_ID])
GO

ALTER TABLE Remetfu.[REM_ORDENES_PAGO] CHECK CONSTRAINT [FK_GestionMunicipalEC_REM_ORDENES_PAGO_1]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'llave primaria' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'REM_ORDENES_PAGO_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'código de la tabla SLUM_LICENCIAS_ID' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'SLUM_LICENCIAS_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha y hora de creación del registro' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'FECHA_REGISTRO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'nombre del usuario que realiza la actividad ' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'USUARIO_REGISTRO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'el valor a pagar' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'VALOR'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'tipo de licencia que hay que pagar' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'CONCEPTO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'IP de la máquina que realiza la actividad ' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'IP'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'cédula de identidad del deudor' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'CI_DEUDOR'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Nombre del proyecto de contrucción' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'PROYECTO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Observación de la pantalla' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'OBSERVACION'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'el ID de lo solicitud' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'EC_SOLICITUD_ID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'número de la orden de pago' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'ORDEN_PAGO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'campos para consultas' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'ADICIONAL'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'campos para consultas' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO', @level2type=N'COLUMN',@level2name=N'PARAMETRO'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tabla principal para guardar los datos de las ordenes de pago de las licencias.' , @level0type=N'SCHEMA',@level0name=N'Remetfu', @level1type=N'TABLE',@level1name=N'REM_ORDENES_PAGO'
GO

*/

