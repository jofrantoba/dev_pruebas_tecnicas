# parametareto

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
