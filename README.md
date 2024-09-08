# EPDMS Microservice Sample Appilcation

This is spring boot sample application with asynchronous/non-blocking implementation with Spring Webflux/Reactive Flow

## Description

This is a sample application to build any other microservice based on the boundaries of a microservices as required by business team.
Please refer this sample application to start your development from .NET to Spring Boot Microservices architecture.
This implementation covers following features, 
* Actuator
* Spring Cloud API Gateway
* Eureka Netflix Service Registry
* Eureka Netflix Service Discovery
* Circuit Breaker Design Patterns / Fault Tolerance
* Docker Containerization
* Config Server


## Getting Started
This is an example of how you may give instructions on setting up your project locally. To get a local copy up and running follow these simple example steps.

### Dependencies

* Java 21
* Postgres latest version
* VS Code for .NET Code
* Maven/Gradle latest version
* IntelliJ Idea or any other IDE
* Postman or any other Rest Client 
* Docker latest version
* Spring Boot latest version
* Spring Webflux 
* pgAdmin 4
* Kubernetes

### Installing

* Please clone the application from Github/Bitbucket into IntelliJ Idea or any other IDE
* Please clone other services API-GATEWAY, EPDMS-SERVICE-DISCOVERY-EUREKA-SERVER

### Executing program

* Please do clean, compile and build all the applications in your IDE 
* Please create a postgres database user as postgres, please refer properties file for postgres database details
* Please find a file in resource/schema.sql and run it pgAdmin 4 in Query Tool.
* Once database schema setup is done, please do the following steps
* Please run each application step by step
* EPDMS-SERVICE-DISCOVERY-EUREKA-SERVER
* API-GATEWAY
* EPDMS-REACTIVE-APP
* Please sit and relax, all set now and open the service discovery url to verify all services are running and registered with discovery service


### Endpoints URLs for Spring Boot Setting Applications
* Eureka Server - Netflix Eureka Service Registry and Service Discovery App
  
  URL: http://localhost:8761/


* Spring Cloud API Gateway App
  
  URL: http://localhost:8084/


* EPDMS Spring Boot/Reactive App

  URL: http://localhost:8040/swagger-ui/index.html


* Spring Cloud Config Server
  
  URL: http://localhost:8030/application/default


* Spring Boot Actuator for Monitoring
  
  URL: http://localhost:8040/actuator

## Q&A
Please feel free to any questions ?

## Version History
* Sample Application

## Implementation Coverage

* Actuator
* Spring Cloud API Gateway
* Eureka Netflix Service Registry
* Eureka Netflix Service Discovery
* Circuit Breaker Design Patterns / Fault Tolerance
* Docker Containerization
* Config Server
* Spring Security
* JWT Implementation

## Terminology and Service Responsibilities

### Spring Boot Actuator
* Spring Boot Actuator is a sub-project of Spring Boot. It adds several production grade services to your application with little effort on your part. In this guide, you will build an application and then see how to add these services.
* Monitoring our app, gathering metrics, and understanding traffic or the state of our database becomes trivial with this dependency.
* The main benefit of this library is that we can get production-grade tools without actually having to implement these features ourselves.
* The actuator mainly exposes operational information about the running application — health, metrics, info, dump, env, etc. It uses HTTP endpoints or JMX beans to enable us to interact with it.
* Once this dependency is on the classpath, several endpoints are available for us out of the box. As with most Spring modules, we can easily configure or extend it in many ways.
* Example of some of the actuator endpoints


* /auditevents lists security audit-related events such as user login/logout. Also, we can filter by principal or type among other fields.
* /beans returns all available beans in our BeanFactory. Unlike /auditevents, it doesn’t support filtering.
* /conditions, formerly known as /autoconfig, builds a report of conditions around autoconfiguration.
* /configprops allows us to fetch all @ConfigurationProperties beans.
* /env returns the current environment properties. Additionally, we can retrieve single properties.
* /flyway provides details about our Flyway database migrations.
* /health summarizes the health status of our application.
* /heapdump builds and returns a heap dump from the JVM used by our application.
* /info returns general information. It might be custom data, build information or details about the latest commit.
* /liquibase behaves like /flyway but for Liquibase.
* /logfile returns ordinary application logs.
* /loggers enables us to query and modify the logging level of our application.
* /metrics details metrics of our application. This might include generic metrics as well as custom ones.
* /prometheus returns metrics like the previous one, but formatted to work with a Prometheus server.
* /scheduledtasks provides details about every scheduled task within our application.
* /sessions lists HTTP sessions, given we are using Spring Session.
* /shutdown performs a graceful shutdown of the application.
* /threaddump dumps the thread information of the underlying JVM.

### Spring Cloud API Gateway

* An application programming interface (API) gateway functions as a reverse proxy to receive all API calls, aggregates the services needed to fulfill them, and returns the appropriate result. All that clients must know is how to get to the API gateway.
* A consistent and steady point of access is provided by the API gateway, regardless of the offline status, or instability of the backend services.
* Spring Cloud Gateway aims to provide a simple, yet effective way to route to APIs and provide cross cutting concerns to them such as: security, monitoring/metrics, and resiliency. There are two distinct flavors of Spring Cloud Gateway: Server and Proxy Exchange. Each flavor offers WebFlux and MVC compatibility.
* An API gateway not only services requests but also provides functionality to return requested data as the client’s needs. Before forwarding an API request to the API endpoint for processing, an API gateway can apply the necessary pre and/or post-processing filters such as Single Sign-On (SSO), rate limiting, request validation, and tracing. An API gateway offers all these features and more, making APIs easier to maintain, secure, and design and use. At the end of the day, an API gateway simplifies external access and reduces communication complexity between microservices by acting as a single point of entry for several backend APIs.
* Built on Spring Framework and Spring Boot
* Able to match routes on any request attribute.
* Predicates and filters are specific to routes.
* Circuit Breaker integration.
* Spring Cloud DiscoveryClient integration
* Easy to write Predicates and Filters
* Request Rate Limiting
* Path Rewriting

### Eureka Netflix Service Discovery and Service Registry
* Eureka Server is an application that holds the information about all client-service applications. Every Micro service will register into the Eureka server and Eureka server knows all the client applications running on each port and IP address. Eureka Server is also known as Discovery Server.
* It offers a way to automatically detect services on a network, making it possible for microservices to locate and communicate with each other.
* A central database or registry that keeps track of information about available services in the system.
* Each microservice, when it starts or shuts down, registers or deregisters itself with the service registry. This includes information such as its network location, IP address, and the ports it is using.
* The microservice that offers a specific functionality or resource is considered a service provider.
* The microservice that needs to use the functionality provided by another service is considered a service consumer.
* Service discovery systems handle dynamic updates seamlessly. As new microservices are added or existing ones are removed or scaled, the service registry is updated accordingly.
* Service discovery often involves load balancing mechanisms. When a service has multiple instances, load balancing ensures that requests are distributed optimally across these instances, improving performance and resource utilization.
* Unlike traditional monolithic architectures where communication may be centralized, service discovery enables decentralized communication among microservices. Services can find and communicate with each other without relying on a central authority.
* Service discovery systems often include health checking mechanisms to monitor the status of service instances. Unhealthy or unreachable instances can be automatically excluded from the registry to ensure that only healthy services are used.
* Centralized Service Registry: Eureka Server knows about all client applications and their locations. This centralization simplifies service discovery.
* Automatic Registration: Microservices automatically register themselves with Eureka Server, reducing manual configuration efforts.
* Load Balancing: Eureka Server can help implement load balancing among service instances.
* Health Checks: Eureka Server can perform health checks on registered services, ensuring robustness and reliability.
* Integration with Spring Cloud: Eureka Server seamlessly integrates with the Spring Cloud ecosystem, enabling easy scaling and deployment.


### Circuit Breaker Design Patterns
* The Circuit Breaker pattern in microservices is a fault-tolerance mechanism that monitors and controls interactions between services. It dynamically manages service availability by temporarily interrupting requests to failing services, preventing system overload, and ensuring graceful degradation in distributed environments.
#### Characteristics of Circuit Breaker Pattern
###### Fault Tolerance
* Enhances fault tolerance by isolating and managing failures in individual services.
###### Monitoring
* Continuously monitors interactions between services to detect issues in real time.
###### Failure Isolation
* Temporarily stops requests to failing services, preventing cascading failures and minimizing disruptions.
###### Fallback Mechanism
* Provides fallback responses or error messages to clients during service failures, ensuring graceful degradation.
###### Automatic Recovery
* Automatically transitions back to normal operation when the failing service recovers, improving system reliability

### Config Server
* Spring Cloud Config Server provides an HTTP resource-based API for external configuration (name-value pairs or equivalent YAML content). The server is embeddable in a Spring Boot application, by using the @EnableConfigServer annotation.
* Spring Cloud Config provides server and client-side support for externalized configuration in a distributed system.
* With the Config Server you have a central place to manage external properties for applications across all environments.
* With the Config Server, you have a central place to manage external properties for applications across all environments.
* 



## Convert Existing EPDMS to Spring Boot

* Setup both codes (.NET & Java Converted) in your local machine
* Pick the controller from java converted code
* Create an Spring Boot Application, refer spring boot setting application
* Paste the Java Converted Controller in your Spring Boot application
* Analysis the imported dependencies in that controller
* Copy all the dependencies classes from Java converted code
* Once all imported dependencies are added to spring boot application classpath
* Please ask Topia team to provide the request and response payload, if they have
* If request and response payload is available, then please analysis and fixed your code at Service and DAO layer accordingly
* If payload is not available, then please try to understand the Service and DAO layer classes
* After understanding, please fixed the code and converted it to spring boot syntax

## References

* Please refer the Spring Boot official documentation for extensive application building in microservice architecture.
* https://spring.io/guides/gs/actuator-service
* https://www.baeldung.com/spring-boot-actuators
* https://spring.io/projects/spring-cloud-gateway
* https://www.linkedin.com/pulse/what-api-gateway-exactly-spring-cloud-ilkin-mehdiyev-cacgf#:~:text=An%20application%20programming%20interface%20(API,get%20to%20the%20API%20gateway
* https://www.tutorialspoint.com/spring_boot/spring_boot_eureka_server.htm#:~:text=Eureka%20Server%20is%20an%20application,also%20known%20as%20Discovery%20Server
* https://docs.spring.io/spring-cloud-gateway/reference/index.html#:~:text=Spring%20Cloud%20Gateway%20aims%20to,offers%20WebFlux%20and%20MVC%20compatibility
* https://spring.io/guides/gs/service-registration-and-discovery
* https://medium.com/@vishnuganb/eureka-server-the-ultimate-service-registry-for-microservices-359af8013dc3
* https://www.geeksforgeeks.org/spring-boot-eureka-server/
* https://www.geeksforgeeks.org/what-is-circuit-breaker-pattern-in-microservices/
* https://medium.com/@minadev/circuit-breaker-pattern-in-microservices-9568320f2059
* https://spring.io/guides/gs/cloud-circuit-breaker
* https://docs.spring.io/spring-cloud-config/reference/server.html#:~:text=Spring%20Cloud%20Config%20Server%20provides,ConfigServer.java
* https://spring.io/projects/spring-cloud-config
* https://docs.spring.io/spring-cloud-config/docs/current/reference/html/
