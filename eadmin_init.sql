DROP DATABASE IF EXISTS EADMINBD;
CREATE DATABASE IF NOT EXISTS EADMINBD;
USE EADMINBD;

CREATE TABLE IF NOT EXISTS DEPARTAMENTOS (
    dept_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL UNIQUE,
    permisos INT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS EMPLEADOS (
    emp_id VARCHAR(20) PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    apellido1 VARCHAR(30) NOT NULL,
    apellido2 VARCHAR(30),
    fecha_contrato DATE,
    salario DECIMAL(10, 2) NOT NULL,
    correo VARCHAR(80) UNIQUE,
    tlf VARCHAR(20),
    direccion VARCHAR(50),
    departamento_id INT,
    notas TEXT,
    CONSTRAINT fk_dept_id
        FOREIGN KEY (departamento_id) 
        REFERENCES DEPARTAMENTOS(dept_id)
);

CREATE TABLE IF NOT EXISTS CUENTAS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(30) NOT NULL,
    clave VARCHAR(200) NOT NULL,
    emp_id VARCHAR(20) UNIQUE,
    nuevo TINYINT DEFAULT 0,
    CONSTRAINT fk_emp_id
        FOREIGN KEY (emp_id) 
        REFERENCES EMPLEADOS(emp_id)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS FICHADAS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    emp_id VARCHAR(20),
    fecha DATE,
    entrada TIME,
    salida TIME,
    CONSTRAINT fk_empleado_id
        FOREIGN KEY (emp_id)
        REFERENCES EMPLEADOS(emp_id)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS VACACIONES (
    id INT AUTO_INCREMENT PRIMARY KEY,
    emp_id VARCHAR(20),
    fecha_inicio DATE,
    fecha_fin DATE,
    estado TINYINT DEFAULT 0,
    CONSTRAINT fk_vacacion_empId
        FOREIGN KEY (emp_id)
        REFERENCES EMPLEADOS(emp_id)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS EMPRESAS (
    id VARCHAR(20) PRIMARY KEY,
    nombre VARCHAR(50),
    direccion VARCHAR(50),
    correo VARCHAR(100)
);

INSERT IGNORE INTO DEPARTAMENTOS (nombre, permisos) VALUES ('Desarrolladores', 0);
INSERT IGNORE INTO DEPARTAMENTOS (nombre, permisos) VALUES ('Recursos Humanos', 1);
INSERT IGNORE INTO DEPARTAMENTOS (nombre, permisos) VALUES ('Administración', 2);
INSERT IGNORE INTO DEPARTAMENTOS (nombre, permisos) VALUES ('Genérico', 0);
