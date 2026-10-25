package uk.ac.westminster.productsapi;

// A PhysicalProduct IS-A Product because it has all the shared product
// properties and can be sold in the same catalogue.
// ShoppingCart is NOT a Product; it HAS products inside it.
public class PhysicalProduct extends Product {
    private double weightKg;
    private String dimensions;

    public PhysicalProduct() {}

    public PhysicalProduct(Long id, String name, double price,
                           double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getWeightKg() { return weightKg; }
    public String getDimensions() { return dimensions; }

    public void setWeightKg(double weightKg) { this.weightKg = weightKg; }
    public void setDimensions(String dimensions) { this.dimensions = dimensions; }
}
