package com.findthatcream;
/**
 * This class creates a small object that can attach to any ice cream product to help determine wether
 * its soy, gluten, or nut free.
 *
 * It should give yes or no for each of those and is probably gonna
 * use booleans I think. This class helps build this feature efficiently and in a way that
 * other filter checks can be added later.
 *
 * By putting it in its own class, dietary information is organized, reusable, and easy to expand.
 *
 * OOP concepts:
 * This class has ONE job.
 * Encapsulation — the three boolean fields will be private.
 * Nobody can just reach in and change glutenFree directly. They have to go through a getter or setter.
 *
 * SPRING BOOT CONNECTION:
 * When we reach Project 17, this class will become a JPA @Embeddable object,
 * meaning it gets stored as part of the product table in our MySQL database.
 *
 *  @author Nabeel Mirza
 *  @version 1.0.0
 */

public class DietaryInfo {
        // FIELDS - all private for encapsulation
        // Private so that only this class can access it and data stays secure.
        private boolean isGlutenFree;
        private boolean isSoyFree;
        private boolean isNutFree;

        // CONSTRUCTOR - takes all three flags as parameters
        // Constructor is the method that will be called to actually create the object.
        public DietaryInfo(boolean isGlutenFree, boolean isSoyFree, boolean isNutFree) {
            this.isGlutenFree = isGlutenFree;
            this.isSoyFree = isSoyFree;
            this.isNutFree = isNutFree;
        }

        // GETTERS - allow read access to private fields
        // Getters are needed as part of encapsulation so that we can choose what is shown when you
        // get these variables.
        public boolean isGlutenFree() { return isGlutenFree; }
        public boolean isSoyFree() { return isSoyFree; }
        public boolean isNutFree() { return isNutFree; }

        // SETTERS - allow controlled write access
        // Setting through a setter allows you to check and choose the data you are setting before
        // it actually gets changed.
        public void setGlutenFree(boolean isGlutenFree) { this.isGlutenFree = isGlutenFree; }
        public void setSoyFree(boolean isSoyFree) { this.isSoyFree = isSoyFree; }
        public void setNutFree(boolean isNutFree) { this.isNutFree = isNutFree; }

        // UTILITY METHOD
        // Returns true if product is safe for all three dietary restrictions
        // It needs return type boolean.
        public boolean isSafeForAll() {
            return isGlutenFree && isSoyFree && isNutFree;
        }

        // toString - lets us print a DietaryInfo object in a readable way
        // Q: what happens if we don't override toString?
        @Override
        public String toString() {
            return "DietaryInfo{" +
                    "glutenFree=" + isGlutenFree+
                    ", soyFree=" + isSoyFree +
                    ", nutFree=" + isNutFree +
                    '}';
        }
    }




