package com.findthatcream;

import java.util.List;

/**
 * Abstract base class for all ice cream products in FindThatCream.
 *
 * HOW THIS FITS INTO FINDTHATCREAM:
 * Every product in our catalog — whether it's a standard packaged pint or a
 * limited seasonal drop — shares common data: a brand, flavor name, description,
 * and dietary info. This class holds all that shared data so we never repeat it
 * in PackagedProduct or SeasonalProduct. It also implements Discoverable so
 * every product can answer retailer availability questions.
 *
 * OOP CONCEPTS DEMONSTRATED:
 * - Abstraction: abstract class cannot be instantiated directly
 * - Inheritance: PackagedProduct and SeasonalProduct extend this class
 * - Encapsulation: all fields private, accessed through getters/setters
 * - Polymorphism: abstract method getProductType() forces each subclass
 *   to define its own product type label
 * - Interface implementation: implements Discoverable contract
 *
 * SPRING BOOT CONNECTION:
 * In Project 21 (JPA), this becomes a @Entity with @Inheritance(strategy =
 * InheritanceType.JOINED) — meaning PackagedProduct and SeasonalProduct each
 * get their own database table that joins back to the base product table.
 *
 * @author Nabeel Mirza
 * @version 1.0.0
 */
public abstract class IceCreamProduct implements Discoverable {

    // FIELDS - private for encapsulation
    // Q: why do we declare fields here instead of in PackagedProduct/SeasonalProduct?
    // since this is the parent class?
    private String flavorName;
    private String description;
    private Brand brand;
    private DietaryInfo dietaryInfo;
    private List<Retailer> retailers;
    private boolean isNewDrop;
    private double price;

    // CONSTRUCTOR
    // Q: if this class is abstract and can't be instantiated, why does it have a constructor?
    // so its child classes can use it ?
    public IceCreamProduct(String flavorName, String description, Brand brand,
                           DietaryInfo dietaryInfo, double price) {
        this.flavorName = flavorName;
        this.description = description;
        this.brand = brand;
        this.dietaryInfo = dietaryInfo;
        this.price = price;
        this.isNewDrop = false; // new products are not marked as new drop by default
    }

    // ABSTRACT METHOD
    // Q: what does abstract method mean and what does it force subclasses to do?
    // abstract method is a blue print with methods that are implemented and also methods that
    // will be implemented later?
    public abstract String getProductType();

    // IMPLEMENTED METHODS FROM Discoverable INTERFACE
    // This is a real method with logic — not abstract
    // Q: why can we implement this here instead of forcing each subclass to do it?
    // since subclasses can call a parent method?
    @Override
    public List<Retailer> getRetailers() {
        return retailers;
    }

    @Override
    public boolean isAvailableAt(String retailerName) {
        // loop through retailers list and check if any match the given name
        for (Retailer retailer : retailers) {
            if (retailer.getName().equalsIgnoreCase(retailerName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getDisplaySummary() {
        return brand.getName() + " — " + flavorName + " | $" + price;
    }

    // GETTERS
    public String getFlavorName() { return flavorName; }
    public String getDescription() { return description; }
    public Brand getBrand() { return brand; }
    public DietaryInfo getDietaryInfo() { return dietaryInfo; }
    public boolean isNewDrop() { return isNewDrop; }
    public double getPrice() { return price; }

    // SETTERS
    public void setFlavorName(String flavorName) { this.flavorName = flavorName; }
    public void setDescription(String description) { this.description = description; }
    public void setBrand(Brand brand) { this.brand = brand; }
    public void setDietaryInfo(DietaryInfo dietaryInfo) { this.dietaryInfo = dietaryInfo; }
    public void setNewDrop(boolean isNewDrop) { this.isNewDrop = isNewDrop; }
    public void setPrice(double price) { this.price = price; }

    // SETTER FOR RETAILERS
    public void setRetailers(List<Retailer> retailers) { this.retailers = retailers; }

    // toString
    @Override
    public String toString() {
        return "IceCreamProduct{" +
                "brand=" + brand.getName() +
                ", flavor='" + flavorName + '\'' +
                ", price=$" + price +
                ", isNewDrop=" + isNewDrop +
                ", dietary=" + dietaryInfo +
                '}';
    }
}