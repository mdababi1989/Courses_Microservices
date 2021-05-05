# Eureka Server

Service Registration and Discovery with Eureka and Spring Cloud.
By default, Eureka runs on port 8761. You can modify the port in the applications.properties file.
The configuration specifies that this is a server and stops the server process trying to register with itself using:
`eureka.client.register-with-eureka=false`
`eureka.client.fetch-registry=false`

### Reference Documentation
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/#build-image)
* [Eureka Server](https://docs.spring.io/spring-cloud-netflix/docs/current/reference/html/#spring-cloud-eureka-server)

