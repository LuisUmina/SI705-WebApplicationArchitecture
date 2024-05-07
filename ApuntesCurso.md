# WEEK 2 - API REST & SPRING BOOT

## API
Una API es una interfaz que conecta aplicaciones para que **compartan informacioon**.

## REST
* **Representational State Transfer**
* Es una estilo de Arquitectura a la hora de realizar una comunicacioon entre cliente y servidor.
* Rest es una arquitectura para APIs que se conectan viia web con el protocolo HTTP. Permite acceder a la infomacioon con identificadores uunicos.

## Verbos HTTP
Los verbos involucrados en un sistema REST son
* **GET:** Se usaraa para solicitar consultas a los recursos
* **POST:** Se usaraa para insertar nuevos recusos
* **PUT/PATCH:** Se usará para actualizar recursos
* **DELETE:** Se usará para borrar recursos

## SPRING
* Es un framework para el desarrollo de aplicaciones y contenedor de inversioon de control de coodigo abierto para la plataforma Java
* La primera versioob fue escrita por *Rod Johnson*, quien lo lanzoo junto a la publicacioon de su libro *Expert One-on-One J2EE Design and Development*.
    ### Spring Boot
    * Es un proyecto de Spring que simplifica la configuracioon de aplicaciones Spring.
    * Spring boot es un que nace con la finalidad de simplificar auun maas el desarrollo de aplicaciones basadas en framework Spring Core.
    * Spring Boot busca que el desarrollador se centre en el desarrollo de la solucioon, olvidaandose por completo de la compleja configuracioon que actualmente tiene Spring Core para poder funcinar.
    ### Features
    * **Configuracioon:** Cuenta con un moodulo que autoconfigura todos los aspectos de la aplicacioon.
    * **Resolucioon de Dependencias:** Solo debemos determinar el tipo de proyecto utilizaremos y el se encarga de resolver todas las *librerias / dependecias*.
    * **Despliegue:** Se puede ejecutar como una aplicacioon Stand-alone, mediante un servidor web integrado, como es el caso de Tomcar, Jetty o Undertow.
    * **Meetricas:** Cuenta con servicios que permite consultar el estado de salud de la aplicacioon, permitiendo saber si la aplicacion estaa prendida o apagada, memoria utilizada y disponible, etc.
    * **Extensible:** Permite la creacioon de complementos, los cuales ayudan a que la comunidad de Software Libre cree nuevos moodulos que faciliten el desarrollo.


# Proyecto Demo
APP para gestionar peliculas de una productora.
## Product Backlog
En la semana 2 se realizaraa la HU01 - HU02
![Product Backlog](img_ApuntesCurso/Captura%20de%20pantalla%202024-05-06%20032553.jpeg)

## Diagrama de Base de Datos
![Diagrama de Base de Datos](img_ApuntesCurso/Captura%20de%20pantalla%202024-05-06%20032614.jpeg)

---
---
---

# MORE NOTES
## Estereotipos de Spring
### Component
* **Propoosito:** Anotación que indica que una clase es un componente de Spring.
* **Uso:** Para identificar clases genéricas gestionadas por Spring.
### Controller
* **Propósito:** Anotación que marca una clase como un controlador de Spring MVC.
* Uso: Para gestionar solicitudes web, controlando el flujo de la aplicación y devolviendo respuestas.
### Repository
* **Propoosito:** Anotación que indica que una interfaz o clase es un repositorio, es decir, un componente responsable de acceder y gestionar datos.
* **Uso:** Para definir interfaces que extienden JpaRepository o CrudRepository y proporcionar métodos para realizar operaciones de persistencia.
### Service
* **Propoosito:** Anotación que marca una clase como un servicio de Spring.
* **Uso:** Para definir la lógica empresarial de la aplicación, gestionando operaciones y coordinando la interacción entre los componentes.

## Estructura del Proyecto
### Controllers
* **Propoosito:** Carpeta que contiene los controladores de la aplicación.
* **Uso:** Para organizar las clases que gestionan las solicitudes web y controlan el flujo de la aplicación.
### Dtos
* **Propoosito:** Carpeta que contiene los DTOs (Data Transfer Objects).
* **Uso:** Para definir objetos que transportan datos entre la capa de presentación y la capa de servicio.
### Entities
* **Propoosito:** Carpeta que contiene las entidades de la aplicación.
* **Uso:** Para definir clases que representan entidades de la base de datos y mapearlas a tablas.
### Repositories
* **Propoosito:** Carpeta que contiene los repositorios de la aplicación.
* **Uso:** Para organizar las interfaces que definen operaciones de persistencia y acceso a datos.
### ServiceImplements
* **Propoosito:** Carpeta que contiene las implementaciones de servicios.
* **Uso:** Para almacenar las clases que implementan la lógica de negocio definida en las interfaces de servicio.
### ServiceInterfaces
* **Prooosito:** Carpeta que contiene las interfaces de servicios.
* **Uso:** Para definir interfaces que especifican los métodos que deben ser implementados por las clases de servicio.

![Estructura del Proyecto](img_ApuntesCurso/Captura%20de%20pantalla%202024-05-06%20152931.jpeg)


## Notaciones Comunes
### @Entity
* **Propoosito:** Anotación que marca una clase como una entidad de JPA.
* **Uso:** Para mapear la clase a una tabla en la base de datos.
### @Table(name = "nombre_tabla")
* **Propoosito:** Anotacioon que especifica el nombre de la tabla en la base de datos.
* **Uso:** Para personalizar el nombre de la tabla en la base de datos.
### @Data
* **Propoosito:** Anotación de Lombok que genera automáticamente getters, setters, toString(), equals(), y hashCode().
* **Uso:** Para reducir el coodigo repetitivo.
### @AllArgsConstructor
* **Propoosito:** Anotacioon de Lombok que genera un constructor con todos los argumentos.
* **Uso:** Para simplificar la creación de objetos inicializados con todos los atributos.
### @NoArgsConstructor
* **Propoosito:** Anotacioon de Lombok que genera un constructor sin argumentos.
* **Uso:** Para simplificar la creacioon de objetos con valores predeterminados.
### @Id
* **Propoosito:** Anotacioon que marca un campo como clave primaria.
* **Uso:** Para identificar el campo que actuua como clave primaria en la tabla de la base de datos.
### @GeneratedValue(strategy = GenerationType.IDENTITY)
* **Propoosito:** Anotacioon que especifica la estrategia de generacioon de valores de clave primaria.
* **Uso:** Para indicar que la clave primaria se genera automaaticamente mediante una identidad de base de datos.
### @Column(name = "Nombre", nullable = false, length = 20)
* **Propoosito:** Anotacioon que especifica las propiedades de una columna en la base de datos.
* **Uso:** Para definir el nombre de la columna, si es nullable y su longitud máxima.
### @RestController
* **Propoosito:** Anotacioon que combina las anotaciones `@Controller` y `@ResponseBody`, lo que significa que Spring interpretaraa el resultado del meetodo como datos JSON.
* **Uso:** Para marcar una clase como un controlador REST en Spring, que se encarga de gestionar las solicitudes HTTP y devolver respuestas en formato JSON.
### @RequestMapping("/ruta")
* **Propoosito:** Anotacioon que mapea las solicitudes HTTP a meetodos de controlador en clases anotadas con `@Controller`.
* **Uso:** Para asignar una ruta de acceso base para todos los meetodos de controlador en una clase o un meetodo de controlador especiifico.
### @GetMapping("/ruta")
* **Propoosito:** Anotacioon que mapea las solicitudes HTTP GET a meetodos de controlador en clases anotadas con `@Controller`.
* **Uso:** Para asignar una ruta de acceso especiifica a un meetodo de controlador que responde a solicitudes HTTP GET.
### @PostMapping("/ruta")
* **Propoosito:** Anotacioon que mapea las solicitudes HTTP POST a meetodos de controlador en clases anotadas con `@Controller`.
* **Uso:** Para asignar una ruta de acceso especiifica a un meetodo de controlador que responde a solicitudes HTTP POST.
### @PutMapping("/ruta")
* **Propoosito:** Anotacioon que mapea las solicitudes HTTP PUT a meetodos de controlador en clases anotadas con `@Controller`.
* **Uso:** Para asignar una ruta de acceso especiifica a un meetodo de controlador que responde a solicitudes HTTP PUT.
### @DeleteMapping("/ruta")
* **Propoosito:** Anotacioon que mapea las solicitudes HTTP DELETE a meetodos de controlador en clases anotadas con `@Controller`.
* **Uso:** Para asignar una ruta de acceso especiifica a un meetodo de controlador que responde a solicitudes HTTP DELETE.
### @RequestBody
* **Propoosito:** Anotacioon que indica que un paraametro de meetodo deberiia estar vinculado al cuerpo de la solicitud HTTP.
* **Uso:** Para indicar que el método del controlador espera recibir datos en formato JSON en el cuerpo de la solicitud HTTP.
### @PathVariable
* **Propoosito:** Anotación que se utiliza para vincular variables de plantilla de URI a parámetros de meetodo en un controlador de Spring MVC.
* **Uso:** Para extraer valores de la URI de la solicitud y asignarlos a los paraametros del meetodo del controlador.
### @Autowired
* **Propoosito:** Anotacioon que se utiliza para realizar la inyeccioon de dependencias en Spring.
* **Uso:** Para inyectar automaaticamente instancias de beans administradas por Spring en un campo, método o constructor.

---
---
---

## ModelMapper
El `ModelMapper` es una biblioteca de Java que simplifica el mapeo de objetos de un tipo a otro. En el contexto de una aplicación Spring Boot, se utiliza comúnmente para mapear entre entidades JPA y DTOs (Data Transfer Objects).
### Ejemplo de Uso
#### Insertar una nueva película
``` java
@PostMapping("/insertar")
public void insertar(@RequestBody MovieDTO movieDTO) {
    // Instancia de la clase ModelMapper
    ModelMapper d = new ModelMapper();
    
    // Mapeo de un objeto DTO a una entidad Movie
    Movie movie = d.map(movieDTO, Movie.class);
    
    // Llamada al método insert de la interfaz IMovieService
    movieService.insert(movie);
}
```

# CREACIOON / CONFIGURACIOON DEL PROYECTO

# Creando un Proyecto para el Curso
* **Paso 1:** Abrir IntelliJ IDEA
* **Paso 2:** Crear un nuevo proyecto
* **Paso 3:** Seleccionar Spring Initializr
* **Paso 4:** Ingresar el nombre del proyecto
* **Paso 5:** Seleccionar la ubicacioon del proyecto
* **Paso 6:** Seleccionar el lenguaje de programacioon (Java)
* **Paso 7:** Seleccionar el tipo de proyecto (Maven)   
* **Paso 8:** Seleccionar el group (pe.edu.upc)
* **Paso 9:** Seleccionar JDK (versioon 17)
* **Paso 10:** Seleccionar la version de Spring Boot para el curso (versioon 3.2.4)
* **Paso 10:** Agregar las dependencias necesarias
    * Spring Web
    * Spring Data JPA
    * PostgreSQL Driver
    * Spring Boot DevTools
    * Lombok

# Configuración del Archivo application.properties
El archivo `application.properties` es utilizado en aplicaciones Spring Boot para configurar propiedades específicas de la aplicación, incluida la configuración de la base de datos.
```properties
# Indica la base de datos a utilizar
spring.jpa.database=postgresql

# Determina si se generará un log de las queries que se ejecuten
spring.jpa.show-sql=false

# Determina la estrategia de creación de tablas por Hibernate
spring.jpa.hibernate.ddl-auto=create

# Indica la clase del controlador JDBC a utilizar
spring.datasource.driver-class-name=org.postgresql.Driver

# Indica la URL de la base de datos
spring.datasource.url=jdbc:postgresql://localhost/dbDemoClaseRosaSemana2(Nombre de la base de datos)

# Indica el usuario de la base de datos
spring.datasource.username=postgres

# Indica la contraseña de la base de datos
spring.datasource.password=1234 (contrasenia)
```

# Dependencias Agregadas al proyecto
```xml
        <!-- MODEL MAPPER --> <!-- https://mvnrepository.com/artifact/org.modelmapper/modelmapper -->
        <dependency>
            <groupId>org.modelmapper</groupId>
            <artifactId>modelmapper</artifactId>
            <version>3.2.0</version>
        </dependency>
        <!-- SWAGGER --> <!-- LINK -->
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.4.0</version>
        </dependency>
```

NOTA: 
* @Autowired -> Siempre debe estr en el apartado de ServiceImplement (@Service) Y Controllers (@RestController)
* Swagger -> La ruta para consultar el Swagger es: ```http://localhost:8080/swagger-ui.html```

---
---
---
---
---
# WEEK 3 - SPRING DATA JPA

PENDING . . .

# Proyecto Demo
APP para gestionar peliculas de una productora.
## Product Backlog
En la semana 3 se realizaraa la HU03 - HU04 - HU05
![Product Backlog](img_ApuntesCurso/Captura%20de%20pantalla%202024-05-06%20032553.jpeg)

## Diagrama de Base de Datos
![Diagrama de Base de Datos](img_ApuntesCurso/Captura%20de%20pantalla%202024-05-06%20032614.jpeg)



# WEEK 3 - SPRING DATA JPA & SECURITY

PENDING . . .

# Proyecto Demo
APP para gestionar peliculas de una productora.
## Product Backlog
En la semana 3 se realizaraa la HU06 - HU07 - HU08 - HU09 - HU10
![Product Backlog](img_ApuntesCurso/Captura%20de%20pantalla%202024-05-06%20032553.jpeg)

## Diagrama de Base de Datos
![Diagrama de Base de Datos](img_ApuntesCurso/Captura%20de%20pantalla%202024-05-06%20032614.jpeg)