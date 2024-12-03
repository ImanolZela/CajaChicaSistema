BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Caja_Chica" (
	"caja_id"	INTEGER,
	"nombre_proyecto"	VARCHAR(100),
	"usuario_id"	INTEGER,
	"monto_asignado"	DECIMAL(10, 2),
	"fecha_apertura"	DATE NOT NULL,
	"fecha_cierre"	DATE,
	"estado_proyecto"	BOOLEAN NOT NULL CHECK("estado_proyecto" IN (0, 1)),
	PRIMARY KEY("caja_id" AUTOINCREMENT),
	FOREIGN KEY("usuario_id") REFERENCES "Usuarios"("usuario_id")
);
CREATE TABLE IF NOT EXISTS "Categorias_Gasto" (
	"categoria_id"	INTEGER,
	"nombre_categoria"	VARCHAR(50) NOT NULL,
	PRIMARY KEY("categoria_id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "Movimientos_Caja_Chica" (
	"movimiento_id"	INTEGER,
	"caja_id"	INTEGER NOT NULL,
	"tipo_movimiento"	BOOLEAN NOT NULL CHECK("tipo_movimiento" IN (0, 1)),
	"monto_movimiento"	DECIMAL(10, 2) NOT NULL,
	"fecha_movimiento"	DATE NOT NULL,
	"usuario_id"	INTEGER NOT NULL,
	"saldo_resultante"	DECIMAL(10, 2),
	PRIMARY KEY("movimiento_id" AUTOINCREMENT),
	FOREIGN KEY("caja_id") REFERENCES "Caja_Chica"("caja_id"),
	FOREIGN KEY("usuario_id") REFERENCES "Usuarios"("usuario_id")
);
CREATE TABLE IF NOT EXISTS "Rendicion_Gastos" (
	"rendicion_id"	INTEGER,
	"caja_id"	INTEGER NOT NULL,
	"categoria_id"	INTEGER NOT NULL,
	"tipo_comprobante"	VARCHAR(20) NOT NULL,
	"num_comprobante"	VARCHAR(20) NOT NULL,
	"descripcion_gasto"	VARCHAR(255),
	"monto"	DECIMAL(10, 2) NOT NULL,
	"fecha_gasto"	DATE NOT NULL,
	"usuario_id"	INTEGER NOT NULL,
	"estado"	VARCHAR(20) DEFAULT 'Pendiente',
	PRIMARY KEY("rendicion_id" AUTOINCREMENT),
	FOREIGN KEY("caja_id") REFERENCES "Caja_Chica"("caja_id"),
	FOREIGN KEY("categoria_id") REFERENCES "Categorias_Gasto"("categoria_id"),
	FOREIGN KEY("usuario_id") REFERENCES "Usuarios"("usuario_id")
);
CREATE TABLE IF NOT EXISTS "Roles" (
	"rol_id"	INTEGER,
	"nombre_rol"	VARCHAR(50) NOT NULL,
	PRIMARY KEY("rol_id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "Usuarios" (
	"usuario_id"	INTEGER,
	"nombres"	VARCHAR(100) NOT NULL,
	"apellidos"	VARCHAR(100) NOT NULL,
	"dni_ce"	VARCHAR(12) NOT NULL UNIQUE,
	"fecha_nacimiento"	DATE NOT NULL,
	"correo"	VARCHAR(100) NOT NULL UNIQUE,
	"direccion"	VARCHAR(200),
	"password"	VARCHAR(255) NOT NULL,
	"fecha_registro"	DATE NOT NULL,
	"fecha_baja"	DATE,
	"rol_id"	INTEGER NOT NULL,
	PRIMARY KEY("usuario_id" AUTOINCREMENT),
	FOREIGN KEY("rol_id") REFERENCES "Roles"("rol_id")
);
INSERT INTO "Caja_Chica" VALUES (1,'Línea 2 del Metro de Lima',1,5000,'2024-10-01',NULL,1);
INSERT INTO "Caja_Chica" VALUES (2,'Majes-Siguas II',2,3000,'2024-10-01',NULL,1);
INSERT INTO "Caja_Chica" VALUES (3,'Gasoducto Sur Peruano',3,4000,'2024-10-01',NULL,1);
INSERT INTO "Caja_Chica" VALUES (4,'Proyecto Chavimochic',4,3500,'2024-10-01',NULL,1);
INSERT INTO "Categorias_Gasto" VALUES (1,'Almuerzo');
INSERT INTO "Categorias_Gasto" VALUES (2,'Transporte');
INSERT INTO "Categorias_Gasto" VALUES (3,'Hospedaje');
INSERT INTO "Movimientos_Caja_Chica" VALUES (1,1,0,22.5,'2024-10-01',1,4977.5);
INSERT INTO "Movimientos_Caja_Chica" VALUES (2,1,0,18.3,'2024-10-02',2,4959.2);
INSERT INTO "Movimientos_Caja_Chica" VALUES (3,1,0,23,'2024-10-03',3,4936.2);
INSERT INTO "Movimientos_Caja_Chica" VALUES (4,2,0,16.5,'2024-10-01',2,2983.5);
INSERT INTO "Movimientos_Caja_Chica" VALUES (5,2,0,15,'2024-10-02',4,2968.5);

INSERT INTO "Movimientos_Caja_Chica" VALUES (10,1,1,28,'2024-11-01',1,NULL);
INSERT INTO "Movimientos_Caja_Chica" VALUES (11,1,0,35,'2024-11-02',1,NULL);
INSERT INTO "Movimientos_Caja_Chica" VALUES (12,1,0,45,'2024-11-03',1,NULL);
INSERT INTO "Movimientos_Caja_Chica" VALUES (13,1,0,51,'2024-11-04',1,NULL);
INSERT INTO "Movimientos_Caja_Chica" VALUES (14,1,0,56,'2024-11-05',1,NULL);
INSERT INTO "Movimientos_Caja_Chica" VALUES (15,1,0,25,'2024-11-06',1,NULL);
IN}
INSERT INTO "Rendicion_Gastos" VALUES (1,1,1,'Factura','F001-0001','Almuerzo equipo',22.5,'2024-10-01',1,'Aprobado');
INSERT INTO "Rendicion_Gastos" VALUES (2,1,2,'Boleta','B001-0002','Pasaje a obra',18.3,'2024-10-02',2,'Aprobado');
INSERT INTO "Rendicion_Gastos" VALUES (3,2,3,'Factura','F002-0003','Hospedaje',16.5,'2024-10-01',2,'Aprobado');
INSERT INTO "Rendicion_Gastos" VALUES (4,3,1,'Boleta','B003-0004','Comida en obra',25,'2024-10-01',3,'Aprobado');
INSERT INTO "Rendicion_Gastos" VALUES (5,4,2,'Factura','F004-0005','Transporte personal',19.5,'2024-10-01',4,'Pendiente');
INSERT INTO "Rendicion_Gastos" VALUES (6,1,1,'Boleta','B001-0001','Almuerzo equipo',32.5,'2024-10-01',5,'Pendiente');
INSERT INTO "Rendicion_Gastos" VALUES (7,1,2,'Factura','F001-0002','Transporte a obra',28,'2024-10-02',5,'Pendiente');
INSERT INTO "Rendicion_Gastos" VALUES (8,1,3,'Boleta','B001-0003','Materiales menores',34,'2024-10-03',5,'Pendiente');
INSERT INTO "Rendicion_Gastos" VALUES (9,1,1,'Factura','F001-0004','Cena equipo',25,'2024-10-04',5,'Pendiente');
INSERT INTO "Rendicion_Gastos" VALUES (10,2,3,'Boleta','B002-0005','Hospedaje',29,'2024-10-01',5,'Pendiente');
INSERT INTO "Rendicion_Gastos" VALUES (11,2,1,'Factura','F002-0006','Almuerzo equipo',27.5,'2024-10-02',5,'Pendiente');
INSERT INTO "Rendicion_Gastos" VALUES (12,2,2,'Boleta','B002-0007','Pasajes',31.2,'2024-10-03',5,'Pendiente');
INSERT INTO "Rendicion_Gastos" VALUES (13,2,3,'Factura','F002-0008','Alquiler de equipo',45,'2024-10-04',5,'Pendiente');
INSERT INTO "Rendicion_Gastos" VALUES (14,3,1,'Boleta','B003-0009','Comida en obra',26.5,'2024-10-01',5,'Pendiente');
INSERT INTO "Rendicion_Gastos" VALUES (15,3,2,'Factura','F003-0010','Transporte personal',36,'2024-10-02',5,'Pendiente');
INSERT INTO "Rendicion_Gastos" VALUES (16,3,3,'Boleta','B003-0011','Hospedaje',38,'2024-10-03',5,'Pendiente');
INSERT INTO "Rendicion_Gastos" VALUES (17,3,1,'Factura','F003-0012','Almuerzo',24,'2024-10-04',5,'Pendiente');
INSERT INTO "Rendicion_Gastos" VALUES (18,4,2,'Boleta','B004-0013','Transporte personal',33,'2024-10-01',5,'Pendiente');
INSERT INTO "Rendicion_Gastos" VALUES (19,4,1,'Factura','F004-0014','Almuerzo equipo',28.5,'2024-10-02',5,'Pendiente');
INSERT INTO "Rendicion_Gastos" VALUES (20,4,3,'Boleta','B004-0015','Hospedaje',30,'2024-10-03',5,'Pendiente');
INSERT INTO "Rendicion_Gastos" VALUES (21,4,2,'Factura','F004-0016','Cena',42,'2024-10-04',5,'Pendiente');
INSERT INTO "Roles" VALUES (1,'Auditor');
INSERT INTO "Roles" VALUES (2,'Contador');
INSERT INTO "Usuarios" VALUES (1,'Imanol','Zela','12345601','1990-01-01','imanol.zela@email.com','Av. Auditoría 123','123456','2024-09-15',NULL,1);
INSERT INTO "Usuarios" VALUES (2,'Dylan','Villacorta','12345602','1992-02-15','dylan.villacorta@email.com','Calle Revisión 456','654321','2024-09-15',NULL,1);
INSERT INTO "Usuarios" VALUES (3,'Diego','Damian','12345603','1988-08-10','diego.damian@email.com','Jr. Proyectos 789','123456','2024-09-15',NULL,1);
INSERT INTO "Usuarios" VALUES (4,'Andres','Moloche','12345604','1995-07-05','andres.moloche@email.com','Av. Control 101','654321','2024-09-15',NULL,1);
INSERT INTO "Usuarios" VALUES (5,'Karem','Yapias','12345608','1990-01-01','karem.Yapias@email.com','Av. Auditoría 123','123456','2024-09-15',NULL,2);
COMMIT;
