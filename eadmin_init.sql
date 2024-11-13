DROP DATABASE IF EXISTS EADMINBD;
CREATE DATABASE IF NOT EXISTS EADMINBD;
USE EADMINBD;

CREATE TABLE IF NOT EXISTS DEPARTAMENTOS (
    dept_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    permisos INT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS EMPLEADOS (
    emp_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    apellido1 VARCHAR(30) NOT NULL,
    apellido2 VARCHAR(30),
    fecha_contrato DATE,
    salario DECIMAL(10, 2),
    correo VARCHAR(80) UNIQUE,
    tlf VARCHAR(20),
    direccion VARCHAR(50),
    departamento_id INT,
    notas VARCHAR(500) DEFAULT 'Notas',
    CONSTRAINT fk_dept_id
        FOREIGN KEY (departamento_id) 
        REFERENCES DEPARTAMENTOS(dept_id)
);

CREATE TABLE IF NOT EXISTS CUENTAS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(30) NOT NULL,
    clave VARCHAR(200) NOT NULL,
    emp_id INT UNIQUE,
    nuevo TINYINT DEFAULT 0 CHECK (nuevo IN (0, 1)),
    CONSTRAINT fk_emp_id
        FOREIGN KEY (emp_id) 
        REFERENCES EMPLEADOS(emp_id)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS FICHADAS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    emp_id INT,
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
    emp_id INT,
    fecha_inicio DATE,
    fecha_fin DATE,
    aceptada TINYINT DEFAULT 0 CHECK (aceptada IN (0, 1, 2)),
    CONSTRAINT fk_vacacion_empId
        FOREIGN KEY (emp_id)
        REFERENCES EMPLEADOS(emp_id)
        ON DELETE CASCADE
);

INSERT INTO DEPARTAMENTOS (nombre, permisos) VALUES ('Desarrolladores', 0);
INSERT INTO DEPARTAMENTOS (nombre, permisos) VALUES ('Recursos Humanos', 1);
INSERT INTO DEPARTAMENTOS (nombre, permisos) VALUES ('Administración', 2);
INSERT INTO DEPARTAMENTOS (nombre, permisos) VALUES ('Genérico', 0);