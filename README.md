# ForoHub API

ForoHub es una **API REST** desarrollada con **Spring Boot 3**, diseñada para gestionar un foro de discusión académico. Permite la creación, consulta, actualización y eliminación de tópicos, respuestas y usuarios, incorporando **autenticación y autorización mediante JWT**, persistencia con **MySQL**, migraciones con **Flyway** y documentación automática con **Swagger**.

El proyecto sigue **buenas prácticas de arquitectura**, separación de responsabilidades y estándares modernos de seguridad.

---

## 🚀 Tecnologías utilizadas

* Java 17+
* Spring Boot 3
* Spring Web
* Spring Data JPA
* Spring Security
* JWT (Auth0)
* Flyway Migration
* MySQL
* Lombok
* Bean Validation (Jakarta Validation)
* Swagger / OpenAPI (Springdoc)

---

## 📐 Arquitectura general

El proyecto está organizado siguiendo una arquitectura en capas:

* **Controller**: Exposición de endpoints REST.
* **Service**: Lógica de negocio y validaciones.
* **Repository**: Acceso a datos con JPA.
* **DTOs**: Transferencia segura de datos.
* **Security**: Autenticación, autorización y filtros JWT.
* **Config**: Configuraciones generales y de seguridad.
* **Model**: Entidades JPA persistentes.

---

## 🗄️ Modelo de datos

El sistema maneja las siguientes entidades principales:

* **Usuario**
* **Perfil**
* **Tópico**
* **Respuesta**
* **Curso**

Las relaciones están correctamente normalizadas y gestionadas mediante JPA/Hibernate.

---

## 🔐 Seguridad y autenticación

* Autenticación basada en **JWT (JSON Web Token)**.
* Acceso restringido a endpoints protegidos.
* Inicio de sesión mediante `/login`.
* Tokens firmados con algoritmo **HMAC256**.
* Filtro personalizado que valida el token en cada solicitud.
* Contraseñas encriptadas con **BCrypt**.

---

## 📌 Endpoints principales

### Autenticación

* `POST /login` → Generación de token JWT.

### Tópicos

* `POST /topicos` → Crear tópico.
* `GET /topicos` → Listar tópicos.
* `GET /topicos/{id}` → Detalle de tópico.
* `PUT /topicos/{id}` → Actualizar tópico.
* `DELETE /topicos/{id}` → Eliminar tópico.

### Respuestas

* `POST /respuestas`
* `GET /respuestas/topico/{id}`

### Usuarios

* CRUD completo (protegido).

---

## 📋 Reglas de negocio implementadas

* Todos los campos obligatorios son validados.
* No se permiten tópicos duplicados (mismo título y mensaje).
* Validación de existencia para actualización y eliminación.
* Manejo centralizado de errores y excepciones.
* Control de acceso basado en autenticación válida.

---

## 🧪 Pruebas del API

Se recomienda el uso de **Postman** o **Insomnia**.

### Autenticación

1. Enviar credenciales a `/login`.
2. Obtener token JWT.
3. Enviar el token en el header:

   ```
   Authorization: Bearer <TOKEN>
   ```

---

## 📄 Documentación Swagger

La API está documentada automáticamente con Swagger.

Acceso:

```
http://localhost:8080/swagger-ui.html
```

Permite:

* Visualizar endpoints.
* Probar solicitudes.
* Ver esquemas de datos.

---

## 🛠️ Configuración del proyecto

### Base de datos

Configurar en `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/forohub
spring.datasource.username=usuario
spring.datasource.password=contraseña
```

### Migraciones

Las migraciones se ejecutan automáticamente al iniciar el proyecto mediante **Flyway**.

---

## 📦 Ejecución del proyecto

```bash
mvn spring-boot:run
```

---

## ✅ Estado del proyecto

✔ API REST completa
✔ Seguridad profesional con JWT
✔ Buenas prácticas de Spring Boot
✔ Documentación integrada
✔ Lista para producción o evaluación técnica

---

## 📌 Autor

Proyecto desarrollado como ejercicio integral de **backend profesional con Spring Boot**, enfocado en seguridad, arquitectura limpia y estándares de la industria.
