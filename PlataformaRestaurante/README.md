# PlataformaRestaurante API

API en Spring Boot con MongoDB, organizada en tres capas:

- `models`: Entidades de dominio (documentos de MongoDB)
- `repository`: Repositorios de acceso a datos
- `services`: Lógica de negocio y orquestación
- `controllers`: Endpoints REST bajo `\n/api/*`

Configuración por defecto usa `mongodb://localhost:27017/restaurante`. Puedes cambiarla con variables de entorno `MONGODB_URI` y `MONGODB_DB`.