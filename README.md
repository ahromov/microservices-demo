# microservices-demo

# To build and run the project, you need to set up environment variables: 

**_WORK_ENV_** - with the "default" value (recommended for local startup)
or "dev" to run microservices in docker, while building images must be done on a docker machine with Postgres RDBMS

**_SERVER_IP_** - with the value of a public or internal IP address (for example, "192.168.0.1", not localhost) for communication between services

# Build config and discovery services by command:
`docker build -t <image/name> .
`
# Build gateway service by command:
`docker build --build-arg SERVER_IP -t <image/name> .
`
# Build note and person services by command:
`docker build --build-arg SERVER_IP --build-arg WORK_ENV -t <image/name> .
`
# Run each images instances by command:
(in this order config, discover, gateway and others services)

`docker run -p out_port:service_port <image/name>
`

# RESTful documentation:
For person and note services will available the OpenAPI swagger on OWN ports by URL: ex. [http://host:port/swagger-ui.html]() 

# Enjoy:)