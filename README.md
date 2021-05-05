# Courses_Microservices
A simple example of setting up a microservices system using Spring, Spring Boot and Spring Cloud.

# Catalog Application
A simple microservice to fetch data from the course application.

# Courses Application
A simple microservice to manage a list of courses from a mysql database.
It uses Spring Data to implement a JPA `CourseRepository` and Spring Rest to provide a REstFul interface to course `CourseController`.
It registers itself with the discovery-server at start-up via `@EnableDiscoveryClient` using its application name. This annotation enables service registration and discovery.

# Eureka Server

Service Registration and Discovery with Eureka and Spring Cloud.
By default, Eureka runs on port 8761. You can modify the port in the applications.properties file.
The configuration specifies that this is a server and stops the server process trying to register with itself using:
`eureka.client.register-with-eureka=false`

`eureka.client.fetch-registry=false`

# Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-developing-web-applications)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#howto-use-exposing-spring-data-repositories-rest-endpoint)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Eureka Discovery Client](https://docs.spring.io/spring-cloud-netflix/docs/current/reference/html/#service-discovery-eureka-clients)
* [Eureka Server](https://docs.spring.io/spring-cloud-netflix/docs/current/reference/html/#spring-cloud-eureka-server)


