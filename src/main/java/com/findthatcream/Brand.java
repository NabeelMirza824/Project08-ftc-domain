package com.findthatcream;
/**
 * Represents a premium ice cream brand in the FindThatCream catalog.
 * HOW THIS FITS INTO FINDTHATCREAM:
 * Every ice cream product belongs to a brand. Jeni's, Van Leeuwen, Graeter's
 * etc. are all brands. This class holds brand-level information that products
 * inherit context from. In Spring Boot (Project 17), this becomes a @Entity
 * with a one-to-many relationship to IceCreamProduct — one brand has many products.
 * OOP CONCEPTS DEMONSTRATED:
 * - Encapsulation: all fields private, accessed through getters/setters
 * - Validation in setters: name cannot be null or empty
 * - toString override: prints brand info readably instead of memory address
 * - Single Responsibility: this class only manages brand data
 * SPRING BOOT CONNECTION:
 * Becomes an @Entity class. Will have @OneToMany relationship with IceCreamProduct.
 *
 * @author Nabeel Mirza
 * @version 1.0.0
 */

public class Brand {
        // FIELDS - private for encapsulation
        private String name;        // Brand name e.g. "Jeni's"
        private String description; // Short brand description
        private String originCity;  // City where brand was founded e.g. "Columbus, OH"
        private final boolean isPremium;  // All brands on FTC are premium - this enforces that

        // CONSTRUCTOR
        // Q: why do we set isPremium = true hardcoded here instead of passing it as a parameter?
        // because all ice creams in app are premium.
        public Brand(String name, String description, String originCity) {
            this.name = name;
            this.description = description;
            this.originCity = originCity;
            this.isPremium = true; // FindThatCream only features premium brands
        }

        // GETTERS
        public String getName() { return name; }
        public String getDescription() { return description; }
        public String getOriginCity() { return originCity; }
        public boolean isPremium() { return isPremium; }

        // SETTERS WITH VALIDATION
        // Q: what happens if someone tries to set name to null or empty string?
        // If someone tries that then the IllegalArgumentException is thrown.
        public void setName(String name) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Brand name cannot be null or empty");
            }
            this.name = name;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setOriginCity(String originCity) {
            this.originCity = originCity;
        }

        // toString
        @Override
        public String toString() {
            return "Brand{" +
                    "name='" + name + '\'' +
                    ", originCity='" + originCity + '\'' +
                    ", isPremium=" + isPremium +
                    '}';
        }
    }

