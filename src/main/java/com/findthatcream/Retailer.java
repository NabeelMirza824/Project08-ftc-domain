package com.findthatcream;

/**
 * Represents a retail store that carries FindThatCream products.
 *
 * HOW THIS FITS INTO FINDTHATCREAM:
 * Retailers are the core value of the app — users come to FindThatCream
 * specifically to find WHICH retailers carry their favorite flavors.
 * Every product has a list of Retailer objects showing where to buy it.
 * Whole Foods, Wegmans, Target etc. are all Retailer objects.
 *
 * OOP CONCEPTS DEMONSTRATED:
 * - Encapsulation: all fields private, controlled through getters/setters
 * - Validation: retailer name cannot be null or empty
 * - toString: prints retailer info readably
 *
 * SPRING BOOT CONNECTION:
 * Becomes a @Entity with a @ManyToMany relationship to IceCreamProduct.
 * One retailer carries many products, one product is carried by many retailers.
 *
 * @author Nabeel Mirza
 * @version 1.0.0
 */
public class Retailer {

    // FIELDS
    private String name;
    private String locationType; // "National Chain" or "Regional Chain"
    private String region;       // e.g. "DMV", "Southeast", "Nationwide"
    private boolean isVerified;  // has admin confirmed this retailer carries the product?

    // CONSTRUCTOR
    public Retailer(String name, String locationType, String region) {
        this.name = name;
        this.locationType = locationType;
        this.region = region;
        this.isVerified = false; // unverified by default until admin confirms
    }

    // GETTERS
    public String getName() { return name; }
    public String getLocationType() { return locationType; }
    public String getRegion() { return region; }
    public boolean isVerified() { return isVerified; }

    // SETTERS WITH VALIDATION
    // Q: why does name need validation but locationType and region do not?
    // name is something the user has while the others are already pre set things by us for the app
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Retailer name cannot be null or empty");
        }
        this.name = name;
    }

    public void setLocationType(String locationType) { this.locationType = locationType; }
    public void setRegion(String region) { this.region = region; }
    public void setVerified(boolean isVerified) { this.isVerified = isVerified; }

    // toString
    @Override
    public String toString() {
        return "Retailer{" +
                "name='" + name + '\'' +
                ", locationType='" + locationType + '\'' +
                ", region='" + region + '\'' +
                ", isVerified=" + isVerified +
                '}';
    }
}