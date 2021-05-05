# Courses_Microservices
A simple example of setting up a microservices system using Spring, Spring Boot and Spring Cloud.

# Catalog Application
A simple microservice application to fetch data from the course and user applications and combine them.

# Courses Application
A simple microservice application to manage a list of courses from a mysql database.
It uses Spring Data to implement a JPA `CourseRepository` and Spring Rest to provide a REstFul interface to courses `CourseController`.
It registers itself with the discovery-server at start-up via `@EnableDiscoveryClient` using its application name. 
This annotation enables service registration and discovery.

# Users Application
A simple microservice application to manage a list of users and their courses from a mysql database.
It uses Spring Data to implement a JPA `UserRepository` and Spring Rest to provide a REstFul interface to users `UserController`.
It registers itself with the discovery-server at start-up.

# Eureka Server

Service Registration and Discovery with Eureka and Spring Cloud.
By default, Eureka runs on port 8761. You can modify the port in the applications.properties file.
The configuration specifies that this is a server and stops the server process trying to register with itself using:

`eureka.client.register-with-eureka=false`

`eureka.client.fetch-registry=false`

# Config Server
This application contains remote configurations for applications using the Spring Cloud Config package.
The idea is that our programs can go to find their configuration parameters in an external place, in such a way that our applications are easily parameterizable.
## Configuration server
To create the configuration server you will need to include this dependency:

    <dependency>
    	<groupId>org.springframework.cloud</groupId>
    	<artifactId>spring-cloud-config-server</artifactId>
    </dependency>

And add `@EnableConfigServer` annotation to the main spring class.
The configuration server will use this GitHub repository and its application.properties will contain:

    server.port=8888  
    spring.application.name=config-server  
    spring.cloud.config.server.git.uri=https://github.com/mdababi1989/Courses_Microservices
The configuration file must be named after the client that is going to request the data. So if the client is named **course-service**, we must have a file called **course-service.properties** in which we will put the values in the format:
`key: value` or `key=value`
To retrieve the configurations for the profile prod, you would use this url:
*http://localhost:8888/courses-service/produ*
The default profile will be used  if you do not specify any.
if a client requests a value and that value exists in the requested profile, that value will be returned. Otherwise, the default profile would be searched , returning the assigned value if it had one.
## Configurations clients
To create the configuration client you will need to include this dependency:

    <dependency>
    	<groupId>org.springframework.cloud</groupId>
    	<artifactId>spring-cloud-starter-config</artifactId>
    </dependency>
To specify where the configuration server is, we will add the **bootstrap.properties** file:

    spring.application.name=course-service
    spring.cloud.config.uri=http://localhost:8888
    spring.profiles.active=prod (optional)
    management.endpoints.web.exposure.include=refresh

The property **management.endpoints.web.exposure.include** configures the actuator package in such a way that the URL **http://localhost:8080/actuator/refresh** will force to refresh the different properties.

#### Read the configuration

    @Component @ConfigurationProperties("courses")
     public class Configuration {
    	private int minTitleLength;
    	private int maxChapterNumber;	
    }

**courses** is the root of the properties to read. We will read  **courses.minTitleLength** and **courses.maxChapterNumber**.
We can inject the Configuration component in other classes using

    @Autowired 
    private  Configuration configuration;

# Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-developing-web-applications)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#howto-use-exposing-spring-data-repositories-rest-endpoint)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Eureka Discovery Client](https://docs.spring.io/spring-cloud-netflix/docs/current/reference/html/#service-discovery-eureka-clients)
* [Eureka Server](https://docs.spring.io/spring-cloud-netflix/docs/current/reference/html/#spring-cloud-eureka-server)


