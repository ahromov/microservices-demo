# microservices-demo

# To build and run the project, you need to set up environment variables: 

**_WORK_ENV_** - with the "default" value (recommended for local startup)
or "dev" to run microservices in docker, while building images must be done on a docker machine with Postgres RDBMS

**_DB_SERVER_IP_** - postgres server IP

**_DISC_SERVER_IP_** - discovery server IP

**_SERVER_IP_** - with the value of a public or internal IP address (for example, "192.168.0.1", not localhost) for communication between services

# Build config and discovery services by command:
`docker build -t <image/name> .
`
# Build gateway service by command:
`docker build -t demo/gate-service --build-arg DISC_SERVER_IP=<eureka_server_ip> .
`
# Build note and person services by command:
`docker build -t demo/(note or person)-service --build-arg SERVER_IP=<config_server_ip> --build-arg DB_
SERVER_IP=<db_server_ip> --build-arg DISC_SERVER_IP=<eureka_server_ip> --build-arg WORK_ENV=dev .
`
# Run each images instances by command:
(in this order config, discover, and others services)

gateway service: `docker run -p 8080:8080 <image/name>`

others: `docker run <image/name>`

# Enjoy:)