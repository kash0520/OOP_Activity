# UML Class Diagrams

The `.puml` files are PlantUML source. Render these with PlantUML (or a compatible IntelliJ plugin).
The diagrams below are also provided as Mermaid so **GitHub displays them without installing PlantUML**.

## Product Class

```mermaid
classDiagram
class Product {
  -Long id
  -String name
  -double price
  +Product()
  +Product(Long id, String name, double price)
  +getId() Long
  +getName() String
  +getPrice() double
  +setId(Long id) void
  +setName(String name) void
  +setPrice(double price) void
}
```

## Customer and Address Association

```mermaid
classDiagram
class Customer {
  -Long id
  -String name
  -String email
  -Address address
  +getId() Long
  +getName() String
  +getEmail() String
  +getAddress() Address
}
class Address {
  -String street
  -String city
  -String postcode
  +getStreet() String
  +getCity() String
  +getPostcode() String
}
Customer --> Address : has an
```

## Controller and Service Layer

```mermaid
classDiagram
class ProductService {
  -List~Product~ products
  -Long nextId
  +getAllProducts() List~Product~
  +getProductById(Long id) Optional~Product~
  +addProduct(Product product) Product
  +deleteProduct(Long id) void
  +findByName(String name) List~Product~
}
class ProductController {
  -ProductService productService
  +getAllProducts() List~Product~
  +getProductById(Long id) Product
  +addProduct(Product product) Product
  +deleteProduct(Long id) void
  +search(String name) List~Product~
}
class Product {
  -Long id
  -String name
  -double price
}
ProductController ..> ProductService : uses
ProductService --> Product : contains
```

## Product Inheritance Hierarchy

```mermaid
classDiagram
class Product {
  -Long id
  -String name
  -double price
  +getName() String
  +getPrice() double
}
class DigitalProduct {
  -String downloadUrl
  -double fileSizeMB
  +getDownloadUrl() String
  +getFileSizeMB() double
}
class PhysicalProduct {
  -double weightKg
  -String dimensions
  +getWeightKg() double
  +getDimensions() String
}
Product <|-- DigitalProduct
Product <|-- PhysicalProduct
```
