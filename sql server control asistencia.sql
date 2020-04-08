CREATE DATABASE ASISTENCIA;
GO
USE ASISTENCIA
GO

create table persona(
idpersona int primary key,
nombre varchar(50),
paterno varchar(50),
materno varchar(20),
sexo varchar(50),
cargo varchar(50),
idoficinafk int
)
go

create table oficina(
idoficina int primary key,
descripcion varchar(50)
)
go
alter table persona add constraint fk_oficina 
foreign key (idoficinafk) references oficina(idoficina)
go

create table ocurrencia(
idocurrencia int primary key,
descripcion varchar(50)
)

go
create table asistencia(
    idpersona int,
    fecha DATE,
    idocurrencia int,
    detalle varchar(50),
	primary key (fecha, idpersona )
)
go
alter table asistencia add constraint fk_asistencia
foreign key (idpersona) references persona(idpersona)
go
alter table asistencia add constraint fk_ocurrencia
foreign key (idocurrencia) references ocurrencia(idocurrencia)

go
insert into ocurrencia values(1,'PRESENTE');
insert into ocurrencia values(2,'TARDE');
insert into ocurrencia values(3,'VACACIONES');
