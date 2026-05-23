# 🍔 HungryShop - Backend

**HungryShop** es una solución de backend desarrollada para la gestión integral de una tienda de comida. Este proyecto fue creado como parte del curso **Fullstack I**, enfocándose en la implementación de una arquitectura limpia y escalable utilizando el ecosistema de Spring.

---
## 🛠️ Tecnologías y Herramientas
* **Lenguaje:** Java 17.
* **Framework:** Spring Boot 3.x.
* **Gestión de Dependencias:** Maven.
* **Persistencia:** Spring Data JPA.
* **Base de Datos:** H2 / MySQL (Configurable vía application.properties).
* **IDE Recomendado:** Visual Studio Code.
* **Otras:** Lombok (para agilizar el desarrollo) y WebClient (para consumo de APIs externas).

---

## 📂 Estructura del Proyecto
El código está organizado siguiendo las mejores prácticas de separación de responsabilidades:

*   **`com.duoc.hungryshop.model`**: Contiene las entidades del dominio (`Cliente`, `Pedido`, `Producto`).
*   **`com.duoc.hungryshop.service`**: Capa de lógica de negocio, incluyendo el cálculo automático de totales de pedidos.
*   **`com.duoc.hungryshop.controller`**: Endpoints REST para la comunicación con el cliente.
*   **`com.duoc.hungryshop.repository`**: Interfaces de acceso a datos.
*   **`com.duoc.hungryshop.dto`**: Objetos para transferencia de datos.
*   **`com.duoc.hungryshop.exception`**: Manejo centralizado de errores con `GlobalExceptionHandler`.

---

## 🌦️ Funcionalidades Destacadas
1.  **Gestión de Pedidos:** Creación y consulta de órdenes de compra con cálculo de total validado en el servidor.
2.  **Mantenimiento de Catálogo:** CRUD completo para productos y clientes.
3.  **Integración de Clima:** Consumo de la API **Open-Meteo** para obtener datos climáticos en tiempo real de Santiago, Chile.
4.  **Validación de Datos:** Uso de anotaciones para asegurar la integridad de la información recibida.

---

### 🚀 Cómo se ejecuta

Sigue estos pasos para levantar el proyecto en tu entorno local:

#### 1. Requisitos Previos
* **Java Development Kit (JDK):** Versión 17 o superior instalada.
* **Visual Studio Code:** Configurado con *Spring Boot Extension Pack* y *Extension Pack for Java*.
* **Laragon:** Entorno local activo para MySQL.
* **HeidiSQL** Revisar las tablas de forma local.

#### 2. Configurar la Base de Datos
El proyecto está configurado para conectarse a una base de datos local y generar las tablas de forma automática gracias a Hibernate al iniciar la aplicación.

1. Abre **Laragon** y haz clic en el botón **"Iniciar todo"** (Start All).
2. Haz clic en el botón **"Base de datos"** (Database) en Laragon para abrir **HeidiSQL**.
3. Conéctate a tu sesión de `localhost`, asegurándote de especificar el puerto **3307** (usuario `root` y sin contraseña).
4. Crea una base de datos vacía llamada exactamente: `hungryshop_db`.
5. El archivo `src/main/resources/application.properties` ya viene configurado para apuntar a este puerto de la siguiente manera:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3307/hungryshop_db
   spring.datasource.username=root
   spring.datasource.password=
   spring.jpa.hibernate.ddl-auto=update

#### 3. Compilar y Ejecutar la Aplicación

1. Clonar este repositorio.
2. Abrir la carpeta raiz en su IDE (Se recomienda Visual Studio Code)
3. Desplegar la terminal y ejecute el siguiente comando para levantar el servidor
   ```
   ./mvnw spring-boot:run
4. El servidor se iniciará exitosamente en el puerto predeterminado:
   ```HTTP
   http://localhost:8080

---

## 👨‍💻 Autor

**Marcelo Muñoz**  

   

