## Base de Datos - Sistema de Gestión de Caja Chica

Aquí se presenta el script para la creación de la base de datos en SQLite, incluyendo las tablas y las relaciones entre ellas.

```sql
-- Crear tabla Roles
CREATE TABLE Roles (
    rol_id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre_rol VARCHAR(50) NOT NULL
);

-- Crear tabla Usuarios
CREATE TABLE Usuarios (
    usuario_id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    dni_ce VARCHAR(12) UNIQUE NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL,
    direccion VARCHAR(200),
    password VARCHAR(255) NOT NULL,
    fecha_registro DATE NOT NULL,
    fecha_baja DATE,
    rol_id INTEGER NOT NULL,
    FOREIGN KEY (rol_id) REFERENCES Roles(rol_id)
);

-- Crear tabla Caja_Chica
CREATE TABLE Caja_Chica (
    caja_id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre_proyecto VARCHAR(100),
    usuario_id INTEGER,
    monto_asignado DECIMAL(10, 2),
    fecha_apertura DATE NOT NULL,
    fecha_cierre DATE,
    estado_proyecto BOOLEAN NOT NULL CHECK (estado_proyecto IN (0, 1)),
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(usuario_id)
);

-- Crear tabla Movimientos_Caja_Chica
CREATE TABLE Movimientos_Caja_Chica (
    movimiento_id INTEGER PRIMARY KEY AUTOINCREMENT,
    caja_id INTEGER NOT NULL,
    tipo_movimiento BOOLEAN NOT NULL CHECK (tipo_movimiento IN (0, 1)),
    monto_movimiento DECIMAL(10, 2) NOT NULL,
    fecha_movimiento DATE NOT NULL,
    usuario_id INTEGER NOT NULL,
    saldo_resultante DECIMAL(10, 2),
    FOREIGN KEY (caja_id) REFERENCES Caja_Chica(caja_id),
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(usuario_id)
);

-- Crear tabla Categorias_Gasto
CREATE TABLE Categorias_Gasto (
    categoria_id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre_categoria VARCHAR(50) NOT NULL
);

-- Crear tabla Rendicion_Gastos
CREATE TABLE Rendicion_Gastos (
    rendicion_id INTEGER PRIMARY KEY AUTOINCREMENT,
    caja_id INTEGER NOT NULL,
    categoria_id INTEGER NOT NULL,
    tipo_comprobante VARCHAR(20) NOT NULL,
    num_comprobante VARCHAR(20) NOT NULL,
    descripcion_gasto VARCHAR(255),
    monto DECIMAL(10, 2) NOT NULL,
    fecha_gasto DATE NOT NULL,
    usuario_id INTEGER NOT NULL,
    FOREIGN KEY (caja_id) REFERENCES Caja_Chica(caja_id),
    FOREIGN KEY (categoria_id) REFERENCES Categorias_Gasto(categoria_id),
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(usuario_id)
);
