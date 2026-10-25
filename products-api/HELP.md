# Products API Help

## Setup
- Java 17 or later
- Maven
- Spring Boot 3.5.7
- Springdoc OpenAPI 2.8.17
- Java package: `uk.ac.westminster.productsapi`

## Run
Open `pom.xml` as a Maven project in IntelliJ IDEA and wait for dependencies to load.
Run `ProductsApiApplication`, or run `mvn spring-boot:run` from the project folder.
Open http://localhost:8080/swagger-ui.html to explore and test the API.

## Tests
Run `mvn test` from the project folder, or run `ProductsApiApplicationTests` in IntelliJ IDEA.

## Endpoints
- GET `/hello`, `/goodbye`, `/status`
- GET `/customers/{id}`
- GET `/products`, `/products/{id}`
- GET `/products/search?name=Code`
- POST `/products`
- DELETE `/products/{id}`

## Behavior
Products are stored in memory and reset on restart. The initial catalogue contains
an E-book and a Monitor. A missing product ID returns an empty response with status 200.
POST accepts plain products and digital or physical products. Jackson selects the
subtype using its distinct fields.

## UML diagrams
See `docs/uml/README.md` for Mermaid diagrams and the `.puml` files in the same
folder for PlantUML sources.
