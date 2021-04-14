# Read Me First

The following was discovered as part of building this project:

* The following dependencies are not known to work with Spring Native: 'Rest Repositories, Oracle Driver, Spring
  Configuration Processor, Spring REST Docs, Rest Repositories HAL Explorer, Spring Batch, Codecentric's Spring Boot
  Admin (Server), Spring Boot DevTools, Spring Web Services'. As a result, your application may not work as expected.

# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.4/maven-plugin/reference/html/#build-image)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/2.4.4/reference/htmlsingle/#howto-use-exposing-spring-data-repositories-rest-endpoint)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/2.4.4/reference/htmlsingle/#configuration-metadata-annotation-processor)
* [Spring Batch](https://docs.spring.io/spring-boot/docs/2.4.4/reference/htmlsingle/#howto-batch-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.4.4/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [JDBC API](https://docs.spring.io/spring-boot/docs/2.4.4/reference/htmlsingle/#boot-features-sql)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/2.4.4/reference/htmlsingle/#boot-features-spring-mvc-template-engines)
* [Spring Data JDBC](https://docs.spring.io/spring-data/jdbc/docs/current/reference/html/)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.4.4/reference/htmlsingle/#boot-features-security)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.4.4/reference/htmlsingle/#production-ready)
* [Spring Native Reference Guide](https://docs.spring.io/spring-native/docs/current/reference/htmlsingle/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.4/reference/htmlsingle/#boot-features-developing-web-applications)
* [Codecentric's Spring Boot Admin (Server)](https://codecentric.github.io/spring-boot-admin/current/#getting-started)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.4.4/reference/htmlsingle/#using-boot-devtools)
* [Spring Web Services](https://docs.spring.io/spring-boot/docs/2.4.4/reference/htmlsingle/#boot-features-webservices)

### Guides

The following guides illustrate how to use some features concretely:

* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)
* [Creating a Batch Service](https://spring.io/guides/gs/batch-processing/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
* [Managing Transactions](https://spring.io/guides/gs/managing-transactions/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Using Spring Data JDBC](https://github.com/spring-projects/spring-data-examples/tree/master/jdbc/basics)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service/)

### Additional Links

These additional references should also help you:

* [Configure the Spring AOT Plugin](https://docs.spring.io/spring-native/docs/0.9.1/reference/htmlsingle/#spring-aot-maven)

## Spring Native

This project has been configured to let you generate a lightweight container running a native executable. Docker should
be installed and configured on your machine prior to creating the image,
see [the Getting Started section of the reference guide](https://docs.spring.io/spring-native/docs/0.9.1/reference/htmlsingle/#getting-started-buildpacks)
.

To create the image, run the following goal:

```
$ ./mvnw spring-boot:build-image
```

Then, you can run the app like any other container:

```
$ docker run --rm -p 8080:8080 dex:0.0.1-SNAPSHOT
```
