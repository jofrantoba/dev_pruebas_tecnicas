# parametareto

Implementar en Java un servicio Rest que reciba como parámetros los atributos del objeto
empleado (que será descrito más adelante) al ser invocado mediante el método GET.
El servicio deberá validar los formatos de las fechas y que los atributos no vengan vacíos,
adicionalmente deberá validar que el empleado sea mayor de edad.
Una vez se hayan superado estas validaciones se deberá invocar un servicio web SOAP
pasando como parámetro el objeto empleado, este último servicio deberá almacenar la
información en una base de datos mysql.
El método REST responderá con el objeto en estructura JSON, en el que se deberá adicionar
la siguiente información:
- Tiempo de Vinculación a la compañía (años, meses y días).
- Edad actual del empleado (años, meses y días)

Atributos del objeto empleado:
- Nombres (String)
- Apellidos (String)
- Tipo de Documento (String)
- Número de Documento (String)
- Fecha de Nacimiento (Date)
- Fecha de Vinculación a la Compañía (Date)
- Cargo (String)
- Salario (Double)

# Versión de MySQL usada: 5.6.40
1. Entrar como root y crear el usuario:
create user 'jofrantoba'@'localhost' identified by 'jofrantoba';
create user 'jofrantoba'@'%' identified by 'jofrantoba';
2. Brindar privilegios
GRANT ALL ON *.* TO 'jofrantoba'@'localhost';
GRANT ALL ON *.* TO 'jofrantoba'@'%';
FLUSH PRIVILEGES;
3. Probar conexión remota desde workbench(Cliente Mysql)
4. Crear base de datos
create database if not exists proxyrestsoap CHARACTER  set utf8mb4 COLLATE utf8mb4_unicode_ci;
use proxyrestsoap;
5. Crear tabla empleado:
create table if not exists empleado(
id bigint(15) not null auto_increment,
nombres varchar(300) not null,
apellidos varchar(300) not null,
tipo_documento varchar(50) not null,
numero_documento varchar(25) not null,
fecha_nacimiento date not null,
fecha_vinculacion date not null,
cargo varchar(300) not null,
salario decimal(18,2) not null,
version bigint(15) not null,
is_persistente tinyint(1) not null,
primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

# Programar los servicios:
- Webservice Rest
- Webservice SOAP
- MVC

# modulos funcionales
- entity
- dao
- service
- apirest

# Dependencia del modulo jpa - config mysql
https://github.com/Jofrantoba-Coding/jofrantoba-model-jpa

# Tecnología usada:
- JDK 11
- Springboot 2.6.2
- Hibernate 5
- Jofrantoba jpa
- maven
- MySQL

# Consumir desde curl
curl -X POST -H "Content-type: application/json" -d '{"nombres":"Jonathan Franchesco","apellidos":"Torres Baca","cargo":"Developer backend","fechaNacimiento":"1988-02-23","fechaVinculacion":"2022-01-22","numeroDocumento":"45329234","salario":12000.00,"tipoDocumento":"DNI"}' "http://localhost:8000/parameta/saveEmpleado"
