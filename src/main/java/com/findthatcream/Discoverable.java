package com.findthatcream;

import java.util.List;

/**
 * Defines the contract for any discoverable item in FindThatCream.
 *
 * HOW THIS FITS INTO FINDTHATCREAM:
 * Any product that can be discovered by users must be able to answer two
 * questions: which retailers carry it, and is it available at a specific
 * retailer? Any class that implements this interface MUST provide answers
 * to both questions. This enforces consistency across all product types.
 *
 * OOP CONCEPTS DEMONSTRATED:
 * - Abstraction: defines WHAT must be done, not HOW
 * - Polymorphism: any class implementing this can be treated as Discoverable
 * - Interface as contract: guarantees these methods exist on any product
 *
 * SPRING BOOT CONNECTION:
 * In Project 20 (REST API), our controller will call getRetailers() on any
 * Discoverable product to build the retailer availability response — without
 * caring whether it's a PackagedProduct or SeasonalProduct.
 *
 * @author Nabeel Mirza
 * @version 1.0.0
 */
public interface Discoverable {

    // Any product must be able to return its list of retailers
    // Q: why does this return List<Retailer> and not just Retailer?
    // because we need to return a list
    List<Retailer> getRetailers();

    // Any product must be able to check if it's at a specific retailer
    // Q: what does boolean return type tell you about what this method does?
    //this method is a yes or no true or false kind of return
    boolean isAvailableAt(String retailerName);

    // Returns a short summary of the product for display on homepage cards
    // Q: why would this be useful in the frontend later?
    // so when user clicks a ice cream they can see that easily
    String getDisplaySummary();
}