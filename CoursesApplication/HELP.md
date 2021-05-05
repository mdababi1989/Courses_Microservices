# Courses Application
A simple microservice to manage a list of courses from a mysql database.
It uses Spring Data to implement a JPA `CourseRepository` and Spring Rest to provide a REstFul interface to course `CourseController`.
It registers itself with the discovery-server at start-up via `@EnableDiscoveryClient` using its application name. This annotation enables service registration and discovery.

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/#build-image)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-developing-web-applications)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#howto-use-exposing-spring-data-repositories-rest-endpoint)
* [Eureka Discovery Client](https://docs.spring.io/spring-cloud-netflix/docs/current/reference/html/#service-discovery-eureka-clients)
