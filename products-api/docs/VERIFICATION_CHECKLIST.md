# Verification checklist

## Application and API documentation
- [ ] Import `pom.xml` as a Maven project in IntelliJ IDEA.
- [ ] Run `ProductsApiApplication`.
- [ ] Verify `/hello`, `/goodbye`, and `/status` return their messages.
- [ ] Open `/swagger-ui.html` and check the listed endpoints.

## Models and encapsulation
- [ ] Verify `Product` has private fields, getters, setters, and constructors.
- [ ] Verify `Person` includes name and email accessors.
- [ ] Verify `/customers/1` returns a nested address.
- [ ] Check the Product and Customer/Address UML diagrams.

## Product operations
- [ ] Verify listing, lookup, creation, deletion, and name search.
- [ ] Verify new products receive an ID.
- [ ] Verify a missing product ID returns an empty response with status 200.
- [ ] Check the controller/service UML diagram.

## Inheritance
- [ ] Verify `DigitalProduct` and `PhysicalProduct` extend `Product`.
- [ ] Verify `/products` initially contains an E-book and a Monitor.
- [ ] Verify a plain product can be posted to `/products`.
- [ ] Verify digital and physical products can be posted using their subtype fields.
- [ ] Check that inheritance arrows in the UML diagram point to `Product`.

## Behavior notes
- Products are stored in memory; changes are reset when the application restarts.
- Jackson subtype deduction uses the digital or physical fields to select the product subtype. A plain Product body also works.
