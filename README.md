# Quarkus Social API

A robust RESTful API built with Quarkus framework for managing users and posts. This project demonstrates the implementation of a social media backend with modern Java technologies and best practices.

## 🚀 Features

- **User Management**
  - Create, Read, Update, Delete (CRUD) operations
  - User profile with name and age
  
- **Post Management**
  - Create and list posts by user
  - Posts with title, content, and tags
  - Timestamp tracking for posts

- **Database Integration**
  - PostgreSQL database with Flyway migrations
  - Hibernate ORM with Panache
  
- **API Documentation**
  - OpenAPI/Swagger UI integration
  - Comprehensive endpoint documentation

## 🛠️ Tech Stack

- **Framework**: Quarkus 3.17.8
- **Language**: Java 21
- **Database**: PostgreSQL
- **ORM**: Hibernate with Panache
- **Migration**: Flyway
- **Documentation**: OpenAPI/Swagger UI
- **Containerization**: Docker & Docker Compose
- **Build Tool**: Maven

## 📋 Prerequisites

- JDK 21
- Docker and Docker Compose
- Maven 3.x

## 🏃‍♂️ Running the Application

### Using Docker Compose

1. Clone the repository:

```
git clone https://github.com/mayumisiano/quarkus-social.git
```

2. Build and run the application:

```
docker compose up --build -d
```


The application will be available at:
- API: http://localhost:8080


## 🔄 API Endpoints

### Users
- `GET /users` - List all users
- `POST /users` - Create a new user
- `PUT /users/{id}` - Update a user
- `DELETE /users/{id}` - Delete a user

### Posts
- `GET /users/{userId}/posts` - List user's posts
- `POST /users/{userId}/posts` - Create a new post

## 📊 Database Schema

### Users Table

```sql
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL
);
```

### Posts Table

```sql
CREATE TABLE posts (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_id INT NOT NULL REFERENCES users(id)
);
```

## 📦 Project Structure

```
quarkus-social/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── io/
│ │ │ └── io/github/mayumisiano/
│ │ │ └── io/github/mayumisiano/quarkus-social/
│ │ │ └── io/github/mayumisiano/quarkus-social/resource/
│ │ │ └── io/github/mayumisiano/quarkus-social/model/
│ │ ├── resources/
│ │ │ ├── application.properties
│ │ │ ├── db/
│ │ │ └── migration/
│ ├── test/
│ │ ├── java/
│ │ └── resources/
│ └── docker/
│ └── docker-compose.yml
└── pom.xml

```

## 📚 Documentation

Access the API documentation through Swagger UI at:
- http://localhost:8080/q/swagger-ui


## Quarkus 
This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it's not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus-social-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

