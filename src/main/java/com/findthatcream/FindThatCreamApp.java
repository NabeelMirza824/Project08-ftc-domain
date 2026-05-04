package com.findthatcream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Main demo application for the FindThatCream domain model.
 *
 * HOW THIS FITS INTO FINDTHATCREAM:
 * This class demonstrates all domain objects working together exactly
 * as they will in the real app. In Spring Boot (Project 17+), this
 * demo logic moves into Service and Controller layers — but the objects
 * themselves stay exactly the same.
 *
 * OOP CONCEPTS DEMONSTRATED:
 * - Polymorphism: PackagedProduct and SeasonalProduct referenced as IceCreamProduct
 * - Inheritance: child classes using parent methods directly
 * - Encapsulation: all data accessed through getters
 * - Abstraction: working with IceCreamProduct without caring about subtype
 * - Interface: Discoverable methods called on product objects
 *
 * @author Nabeel Mirza
 * @version 1.0.0
 */
public class FindThatCreamApp {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("   FindThatCream — Domain Model Demo");
        System.out.println("========================================\n");

        // ===== CREATE RETAILERS =====
        Retailer wholefoods = new Retailer("Whole Foods", "National Chain", "Nationwide");
        Retailer wegmans = new Retailer("Wegmans", "Regional Chain", "DMV");
        Retailer momOrganic = new Retailer("Mom's Organic", "Regional Chain", "DMV");
        wholefoods.setVerified(true);
        wegmans.setVerified(true);

        List<Retailer> retailerList1 = new ArrayList<>();
        retailerList1.add(wholefoods);
        retailerList1.add(wegmans);

        List<Retailer> retailerList2 = new ArrayList<>();
        retailerList2.add(wholefoods);
        retailerList2.add(momOrganic);

        // ===== CREATE BRANDS =====
        Brand jenis = new Brand("Jeni's", "Ohio-based premium ice cream", "Columbus, OH");
        Brand vanLeeuwen = new Brand("Van Leeuwen", "Brooklyn artisan ice cream", "Brooklyn, NY");

        // ===== CREATE DIETARY INFO =====
        DietaryInfo glutenSoyFree = new DietaryInfo(true, true, false);
        DietaryInfo allFree = new DietaryInfo(true, true, true);

        // ===== CREATE PRODUCTS =====
        // Q: notice we reference these as IceCreamProduct not PackagedProduct
        // what OOP concept does this demonstrate?
        // inheritance? no more directly its polymorphism
        IceCreamProduct jenisProduct = new PackagedProduct(
                "Brown Butter Almond Brittle",
                "Rich buttery ice cream with almond brittle pieces",
                jenis,
                glutenSoyFree,
                12.99,
                "1 pint",
                true
        );
        jenisProduct.setRetailers(retailerList1);

        IceCreamProduct vanLeeuwenDrop = new SeasonalProduct(
                "Sicilian Pistachio Collab",
                "Limited collab with Sicilian pistachio farmers",
                vanLeeuwen,
                allFree,
                14.99,
                "Collab",
                LocalDate.of(2026, 5, 1),
                LocalDate.of(2026, 7, 1)
        );
        vanLeeuwenDrop.setRetailers(retailerList2);

        // ===== DEMO OUTPUT =====
        System.out.println("--- Product Catalog ---");
        System.out.println(jenisProduct.getDisplaySummary());
        System.out.println("Type: " + jenisProduct.getProductType());
        System.out.println("Dietary Safe For All: " + jenisProduct.getDietaryInfo().isSafeForAll());
        System.out.println("Available at Wegmans: " + jenisProduct.isAvailableAt("Wegmans"));
        System.out.println("Available at Target: " + jenisProduct.isAvailableAt("Target"));
        System.out.println();

        System.out.println(vanLeeuwenDrop.getDisplaySummary());
        System.out.println("Type: " + vanLeeuwenDrop.getProductType());
        System.out.println("Still Available: " +
                ((SeasonalProduct) vanLeeuwenDrop).isStillAvailable());
        System.out.println("New Drop: " + vanLeeuwenDrop.isNewDrop());
        System.out.println();

        // ===== POLYMORPHISM DEMO =====
        // Q: why can we loop through these two different product types
        // using one IceCreamProduct reference?
        // they are part of same object or parent?

        System.out.println("--- All Products (Polymorphism Demo) ---");
        List<IceCreamProduct> catalog = new ArrayList<>();
        catalog.add(jenisProduct);
        catalog.add(vanLeeuwenDrop);

        for (IceCreamProduct product : catalog) {
            System.out.println(product.getDisplaySummary() +
                    " | Type: " + product.getProductType());
        }

        System.out.println("\n--- Retailer Verification Status ---");
        List<Retailer> allRetailers = new ArrayList<>();
        allRetailers.add(wholefoods);
        allRetailers.add(wegmans);
        allRetailers.add(momOrganic);

        for (Retailer retailer : allRetailers) {
            System.out.println(retailer.getName() +
                    " | Verified: " + retailer.isVerified());
        }
    }
}