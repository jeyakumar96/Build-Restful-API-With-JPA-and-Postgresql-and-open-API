# Employee Management

A Spring Boot RESTful API project for managing employees using **JPA**, **PostgreSQL**, and **OpenAPI (Swagger)**.

---

## 📌 Requirements

Before running the application, make sure you have:

- Java 17+ (check with `java -version`)
- Maven 3.8+ (check with `mvn -version`)
- PostgreSQL running locally or remotely
- IntelliJ IDEA (recommended, but you can use any IDE)

---

## Build the project
mvn clean install

## Run the application
mvn spring-boot:run

# 📖 Swagger / OpenAPI Documentation

Swagger UI is enabled via **springdoc-openapi**.

## 🚀 How to Access Swagger

1. Run the application:
   ```bash
   mvn spring-boot:run
2. Open your browser and go to:
   👉 Swagger UI: http://localhost:8081/swagger-ui/index.html

   👉 OpenAPI JSON: http://localhost:8081/v3/api-docs

   👉 OpenAPI YAML: http://localhost:8081/v3/api-docs.yaml
