CREATE TABLE rol  (
  id_rol SERIAL NOT NULL,
  nombre varchar(255) NOT NULL,
  PRIMARY KEY ( id_rol)
);

CREATE TABLE usuario  (
  id_usuario SERIAL NOT NULL,
  nombre varchar(255) NOT NULL,
  activo  char(1) ,

   id_rol int4 NOT NULL,
  PRIMARY KEY ( id_usuario)
);

ALTER TABLE usuario ADD CONSTRAINT forekey  FOREIGN KEY ( id_rol ) REFERENCES rol( id_rol );


-- Insert

insert into rol (nombre) values('rol_1');
insert into rol (nombre) values('rol_2');
insert into rol (nombre) values('rol_3');

insert into usuario (nombre,activo,id_rol) values('usuario_1','Y',1);
insert into usuario (nombre,activo,id_rol) values('usuario_2','N',2);
insert into usuario (nombre,activo,id_rol) values('usuario_3','Y',3);

