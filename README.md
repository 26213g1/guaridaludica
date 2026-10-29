# 🎲 Guarida Lúdica

**Guarida Lúdica** es una aplicación web de comercio electrónico desarrollada con **Spring Boot** y **Spring Security**, diseñada específicamente para la gestión y venta de juegos de mesa y un completo panel de administración para el control de pedidos, stock y usuarios.

## 🚀 Características Principales

* **Catálogo y Compra**: Visualización de juegos de mesa, filtrado por categorías y gestión de carrito/pedidos por parte de los usuarios.
* **Panel de Administración (`/admin`)**:
  * Listado avanzado de pedidos con paginación y filtros dinámicos (por estado, rango de fechas y búsqueda por texto/ID/usuario) utilizando **JPA Criteria API**.
  * Control de stock, usuarios y roles.
* **Seguridad Robusta**:
  * Autenticación y autorización avanzada mediante **Spring Security**.
  * Protección contra ataques CSRF y gestión de sesiones segura.
* **Portabilidad de Base de Datos**: Compatible con **PostgreSQL** y **MySQL** gracias al uso de estándares de persistencia con Spring Data JPA e Hibernate.

## 🛠️ Tecnologías Utilizadas

* **Backend**: Java 17+, Spring Boot
* **Persistencia**: Spring Data JPA, Hibernate, Criteria API
* **Seguridad**: Spring Security
* **Base de Datos**: PostgreSQL / MySQL
* **Control de Versiones**: Git & GitHub

## ⚙️ Configuración y Ejecución

### 1. Clonar el repositorio
```bash
git clone https://github.com/jmmoraj-jpg/guaridaludica.git
cd guaridaludica
```

### 2. Configurar la Base de Datos
Modifica el fichero `src/main/resources/application.properties` para apuntar a tu base de datos (PostgreSQL o MySQL):
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/guaridadb
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
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
│   │   ├── repository/   # Repositorios Spring Data (con Criteria API)
│   │   └── service/      # Lógica de negocio
│   └── resources/
│       ├── static/       # Archivos CSS, JS e imágenes
│       ├── templates/    # Vistas HTML / Thymeleaf
│       └── application.properties
```

## 📄 Licencia
Este proyecto está desarrollado con fines académicos y de portfolio personal.