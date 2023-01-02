# Spring Boot REST API

This is a simple REST API built using Spring Boot and Maven.

## Prerequisites

- JDK 8 or higher
- Maven 4.0 or higher

## Running the application

1. Clone the repository: `git clone https://github.com/AniketARS/spring-rest-coffee.git`
2. Go to the directory: `cd spring-rest-coffee`
3. Build the application: `mvn clean install`
4. Run the application: `java -jar target/spring-rest-coffee-0.0.1-SNAPSHOT.jar`

The application will start running on port 8080. You can access the API at http://localhost:8080/api/v1/

## API Endpoints

- `GET /api/v1/coffees`: Get a list of coffees
- `GET /api/v1/coffees/{id}`: Get a single coffee item with the given ID
- `POST /api/v1/coffees`: Create a new Coffee item
- `PUT /api/v1/coffees/{id}`: Update an existing coffee item with the given ID
- `DELETE /api/v1/coffees/{id}`: Delete the coffee item with the given ID

## Built With

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
