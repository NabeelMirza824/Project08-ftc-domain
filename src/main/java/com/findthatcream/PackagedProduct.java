package com.findthatcream;

/**
 * Represents a standard packaged ice cream product in FindThatCream.
 * Examples: Jeni's Brown Butter Almond Brittle pint, Graeter's Black
 * Raspberry Chip pint — products that are always available year round.
 *
 * HOW THIS FITS INTO FINDTHATCREAM:
 * Most products in our catalog at launch will be PackagedProducts —
 * standard pints and bars that retailers carry consistently. This class
 * extends IceCreamProduct and adds packaging-specific data like container
 * size and whether it is a limited collab or permanent catalog item.
 *
 * OOP CONCEPTS DEMONSTRATED:
 * - Inheritance: extends IceCreamProduct, gets all parent fields and methods
 * - super keyword: calls parent constructor to set shared fields
 * - Method overriding: provides concrete implementation of getProductType()
 * - Polymorphism: can be referenced as IceCreamProduct anywhere in the app
 *
 * SPRING BOOT CONNECTION:
 * Becomes a @Entity with @DiscriminatorValue("PACKAGED"). Joins to the
 * base ice_cream_product table in MySQL via @Inheritance(JOINED) strategy.
 *
 * @author Nabeel Mirza
 * @version 1.0.0
 */
public class PackagedProduct extends IceCreamProduct {

    // FIELDS specific to PackagedProduct — not in parent class
    // Q: why don't we put these fields in IceCreamProduct instead?
    // these are usnoque to packaged prodcut not ice cream product?
    private String containerSize; // e.g. "1 pint", "3.6 oz bar"
    private boolean isPermanentCatalog; // true = always available, false = limited run

    // CONSTRUCTOR
    // Q: what does super() do here and why is it the first line?
    // super brings those variables from parent class. not sure why in first line
    public PackagedProduct(String flavorName, String description, Brand brand,
                           DietaryInfo dietaryInfo, double price,
                           String containerSize, boolean isPermanentCatalog) {
        super(flavorName, description, brand, dietaryInfo, price);
        this.containerSize = containerSize;
        this.isPermanentCatalog = isPermanentCatalog;
    }

    // OVERRIDE - provides concrete implementation of abstract method from parent
    // Q: what would happen if we forgot to implement this method?
    // method would not compile or run?
    @Override
    public String getProductType() {
        return "Packaged Product";
    }

    // GETTERS
    public String getContainerSize() { return containerSize; }
    public boolean isPermanentCatalog() { return isPermanentCatalog; }

    // SETTERS
    public void setContainerSize(String containerSize) { this.containerSize = containerSize; }
    public void setPermanentCatalog(boolean isPermanentCatalog) {
        this.isPermanentCatalog = isPermanentCatalog;
    }

    // toString - extends parent toString with PackagedProduct specific fields
    // Q: why do we call super.toString() here instead of rewriting everything?
    // it is more efficent to use whats alraeady written then add what we need
    @Override
    public String toString() {
        return super.toString() +
                " PackagedProduct{" +
                "containerSize='" + containerSize + '\'' +
                ", isPermanentCatalog=" + isPermanentCatalog +
                '}';
    }
}