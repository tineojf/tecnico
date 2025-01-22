# Reto Tecnico

## Descripción del Proyecto

Una casa de cambios digital que permita a los usuarios realizar transacciones de compra y venta de divisas. El sistema
es implementado utilizando microservicios, exponiendo APIs REST para su interacción.

[//]: # (## Endpoints Disponibles)

[//]: # (La documentación de la API Swagger se puede acceder en `http://localhost:8080/swagger-ui/index.html`.)

## Ejecutar Localmente con Docker

Esta sección explica cómo ejecutar el proyecto localmente utilizando Docker. El archivo
`docker-compose.yml` provisiona tanto la base de datos MySQL como la aplicación Spring Boot en contenedores separados,
permitiendo una configuración rápida y sencilla en tu entorno local.

### Requisitos

Para ejecutar esta aplicación, asegúrate de tener las siguientes dependencias instaladas:

- **Docker Engine**: versión 20.10.7 o superior.
    - Puedes instalar Docker Engine desde el [sitio web de Docker](https://docs.docker.com/engine/install/).
- **Docker Compose**: versión 1.29.2 o superior.
    - Puedes instalar Docker Compose desde el [sitio web de Docker](https://docs.docker.com/compose/install/).
- **Java 21**: Necesario para ejecutar la aplicación.
- **Maven 3.6** o superior: Usado para construir el proyecto y gestionar sus dependencias.

### Clonar el Repositorio

Clona el repositorio y accede al directorio del proyecto:

```bash
   git clone https://github.com/Integrator-group-5/backend.git
   cd backend
```

### Pasos para Ejecutar Localmente

Antes de comenzar, asegúrate de que el `daemon` de Docker esté ejecutándose en tu máquina o abre **Docker Desktop** para
iniciarlo.

1. **Construir e Iniciar los Contenedores**:
   Para iniciar la aplicación localmente con Docker, ejecuta el siguiente comando:

   ```bash
   docker compose up -d
   ```

2. **Detener la Aplicación**:
   Para detener los contenedores en ejecución, utiliza el siguiente comando. Esto detendrá y eliminará los contenedores,
   pero mantendrá intactos los datos de la base de datos en el volumen.

    ```bash
    docker compose down
    ```

3. **Eliminar Todos los Recursos**:
   Si deseas detener los contenedores y también eliminar los recursos asociados, como volúmenes, redes e imágenes
   creadas por Docker Compose, ejecuta. Este comando limpiará todos los recursos, incluidos los datos de MySQL que se
   hayan persistido.

    ```bash
    docker compose down --volumes --rmi all
    ```



