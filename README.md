# 🎲 Guarida Lúdica

**Guarida Lúdica** es una aplicación web de comercio electrónico desarrollada con **Spring Boot** y **Spring Security**, diseñada específicamente para la gestión y venta de juegos de mesa y un completo panel de administración para el control de pedidos, stock y usuarios.

## 🚀 Características Principales

- **Catálogo y Compra**: Visualización de juegos de mesa, filtrado por categorías y gestión de carrito/pedidos por parte de los usuarios.
- **Panel de Administración (`/admin`)**:
  * Listado avanzado de pedidos con paginación y filtros dinámicos (por estado, rango de fechas y búsqueda por texto/ID/usuario) utilizando **JPA Criteria API / Specifications**.
  * Control de stock, usuarios y roles.
- **Seguridad Robusta**:
  * Autenticación y autorización avanzada mediante **Spring Security**.
  * Protección contra ataques CSRF y gestión de sesiones segura.
- **Persistencia y Calidad**: Integración con **PostgreSQL** mediante estándares JPA e Hibernate, optimizado para evitar incoherencias de tipos de datos en la base de datos.

## 🛠️ Tecnologías Utilizadas

- **Backend**: Java 17+, Spring Boot
- **Persistencia**: Spring Data JPA, Hibernate, Criteria API
- **Seguridad**: Spring Security
- **Base de Datos**: PostgreSQL
- **Control de Versiones**: Git & GitHub

## ⚙️ Configuración y Ejecución

### 1. Clonar el repositorio

```bash
git clone https://github.com/26213g1/guaridaludica.git
cd guaridaludica
```

### 2. Configurar la Base de Datos

Modifica tus ficheros de configuración en YAML (`src/main/resources/application-dev.yaml` o `application-prod.yaml`) para apuntar a tu instancia de PostgreSQL:

```yaml
spring:
  datasource:
    url: ${SPRING_DATASOURCE_URL:jdbc:postgresql://localhost:5432/guaridadb}
    username: ${SPRING_DATASOURCE_USERNAME:tu_usuario}
    password: ${SPRING_DATASOURCE_PASSWORD:tu_contraseña}
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

Puedes ejecutar la aplicación utilizando el Maven Wrapper incluido en el proyecto:

```bash
# En Linux / macOS
./mvnw spring-boot:run

# En Windows
mvnw.cmd spring-boot:run
```

La aplicación estará disponible por defecto en: `http://localhost:8080`

## 📂 Estructura del Proyecto

```text
src/
├── main/
│   ├── java/com/shop/guaridaludica/
│   │   ├── controller/   # Controladores web y de administración
│   │   ├── model/        # Entidades JPA (Pedido, Usuario, etc.)
│   │   ├── repository/   # Repositorios Spring Data (con JPA Specifications)
│   │   └── service/      # Lógica de negocio
│   └── resources/
│       ├── static/       # Archivos CSS, JS e imágenes
│       ├── templates/    # Vistas HTML / Thymeleaf
│       ├── application.yaml
│       ├── application-dev.yaml
│       └── application-prod.yaml
```

## 📄 Licencia

Este proyecto está desarrollado con fines académicos y de portfolio personal.
