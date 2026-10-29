# 馃幉 Guarida L煤dica

**Guarida L煤dica** es una aplicaci贸n web de comercio electr贸nico desarrollada con **Spring Boot** y **Spring Security**, dise帽ada espec铆ficamente para la gesti贸n y venta de juegos de mesa y un completo panel de administraci贸n para el control de pedidos, stock y usuarios.

## 馃殌 Caracter铆sticas Principales

- **Cat谩logo y Compra**: Visualizaci贸n de juegos de mesa, filtrado por categor铆as y gesti贸n de carrito/pedidos por parte de los usuarios.
- **Panel de Administraci贸n (`/admin`)**:
  * Listado avanzado de pedidos con paginaci贸n y filtros din谩micos (por estado, rango de fechas y b煤squeda por texto/ID/usuario) utilizando **JPA Criteria API / Specifications**.
  * Control de stock, usuarios y roles.
- **Seguridad Robusta**:
  * Autenticaci贸n y autorizaci贸n avanzada mediante **Spring Security**.
  * Protecci贸n contra ataques CSRF y gesti贸n de sesiones segura.
- **Persistencia y Calidad**: Integraci贸n con **PostgreSQL** mediante est谩ndares JPA e Hibernate, optimizado para evitar incoherencias de tipos de datos en la base de datos.

## 馃洜锔?Tecnolog铆as Utilizadas

- **Backend**: Java 17+, Spring Boot
- **Persistencia**: Spring Data JPA, Hibernate, Criteria API
- **Seguridad**: Spring Security
- **Base de Datos**: PostgreSQL
- **Control de Versiones**: Git & GitHub

## 鈿欙笍 Configuraci贸n y Ejecuci贸n

### 1. Clonar el repositorio
```bash
git clone https://github.com/26213g1/guaridaludica.git
cd guaridaludica
```

### 2. Configurar la Base de Datos
Modifica tus ficheros de configuraci贸n en YAML (`src/main/resources/application-dev.yaml` o `application-prod.yaml`) para apuntar a tu instancia de PostgreSQL:

```yaml
spring:
  datasource:
    url: ${SPRING_DATASOURCE_URL:jdbc:postgresql://localhost:5432/guaridadb}
    username: ${SPRING_DATASOURCE_USERNAME:tu_usuario}
    password: ${SPRING_DATASOURCE_PASSWORD:tu_contrase帽a}
    driver-class-name: org.postgresql.Driver
    hikari:
      connection-init-sql: SET timezone TO 'UTC';

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: false
    properties:
      hibernate:
        default_schema: guaridadb
```

### 3. Compilar y Ejecutar
Puedes ejecutar la aplicaci贸n utilizando el Maven Wrapper incluido en el proyecto:

```bash
# En Linux / macOS
./mvnw spring-boot:run

# En Windows
mvnw.cmd spring-boot:run
```

La aplicaci贸n estar谩 disponible por defecto en: `http://localhost:8080`

## 馃搨 Estructura del Proyecto

```text
src/
鈹溾攢鈹€ main/
鈹?  鈹溾攢鈹€ java/com/shop/guaridaludica/
鈹?  鈹?  鈹溾攢鈹€ controller/   # Controladores web y de administraci贸n
鈹?  鈹?  鈹溾攢鈹€ model/        # Entidades JPA (Pedido, Usuario, etc.)
鈹?  鈹?  鈹溾攢鈹€ repository/   # Repositorios Spring Data (con JPA Specifications)
鈹?  鈹?  鈹斺攢鈹€ service/      # L贸gica de negocio
鈹?  鈹斺攢鈹€ resources/
鈹?      鈹溾攢鈹€ static/       # Archivos CSS, JS e im谩genes
鈹?      鈹溾攢鈹€ templates/    # Vistas HTML / Thymeleaf
鈹?      鈹溾攢鈹€ application.yaml
鈹?      鈹溾攢鈹€ application-dev.yaml
鈹?      鈹斺攢鈹€ application-prod.yaml
```

## 馃搫 Licencia
Este proyecto est谩 desarrollado con fines acad茅micos y de portfolio personal.
