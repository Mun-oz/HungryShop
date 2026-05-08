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
