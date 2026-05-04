package com.findthatcream;

import java.time.LocalDate;

/**
 * Represents a limited or seasonal ice cream product in FindThatCream.
 * Examples: holiday collabs, summer-only flavors, brand partnership drops,
 * TikTok viral limited releases — any flavor that is not permanently available.
 *
 * HOW THIS FITS INTO FINDTHATCREAM:
 * Seasonal and limited drops are a huge part of FindThatCream's value. When
 * a Jeni's x Goldbelly collab drops for two weeks only, users need to know
 * immediately where to find it. SeasonalProduct tracks the availability window
 * and drop type so the app can surface it correctly in the New Drops section.
 *
 * OOP CONCEPTS DEMONSTRATED:
 * - Inheritance: extends IceCreamProduct, reuses all parent fields and methods
 * - super keyword: calls parent constructor for shared fields
 * - Method overriding: getProductType() returns seasonal-specific label
 * - Polymorphism: treated as IceCreamProduct anywhere in the app
 * - Additional behavior: adds drop-specific logic parent doesn't have
 *
 * SPRING BOOT CONNECTION:
 * Becomes a @Entity with @DiscriminatorValue("SEASONAL"). The availableUntil
 * field will be used in a scheduled job that auto-removes expired drops.
 *
 * @author Nabeel Mirza
 * @version 1.0.0
 */
public class SeasonalProduct extends IceCreamProduct {

    // FIELDS specific to SeasonalProduct
    // Q: why does SeasonalProduct need availableUntil but PackagedProduct doesn't?
    // this is a uniwue feature of seasonla product its not a permanent product
    private String dropType;        // "Holiday", "Collab", "Summer", "Limited Run"
    private LocalDate availableFrom;
    private LocalDate availableUntil;
    private boolean isSoldOut;

    // CONSTRUCTOR
    public SeasonalProduct(String flavorName, String description, Brand brand,
                           DietaryInfo dietaryInfo, double price,
                           String dropType, LocalDate availableFrom,
                           LocalDate availableUntil) {
        super(flavorName, description, brand, dietaryInfo, price);
        this.dropType = dropType;
        this.availableFrom = availableFrom;
        this.availableUntil = availableUntil;
        this.isSoldOut = false;
        // mark as new drop automatically since it just dropped
        this.setNewDrop(true);
    }

    // OVERRIDE
    // Q: both PackagedProduct and SeasonalProduct override getProductType()
    // but return different values — what OOP concept is this?
    // this is polymorphism
    @Override
    public String getProductType() {
        return "Seasonal Drop — " + dropType;
    }

    // EXTRA METHOD unique to SeasonalProduct
    // Q: could we put this method in IceCreamProduct instead? why or why not?
    // why would we do that? isStillAvailable is mostly for seasonl products not others
    public boolean isStillAvailable() {
        return !isSoldOut && LocalDate.now().isBefore(availableUntil);
    }

    // GETTERS
    public String getDropType() { return dropType; }
    public LocalDate getAvailableFrom() { return availableFrom; }
    public LocalDate getAvailableUntil() { return availableUntil; }
    public boolean isSoldOut() { return isSoldOut; }

    // SETTERS
    public void setDropType(String dropType) { this.dropType = dropType; }
    public void setAvailableFrom(LocalDate availableFrom) { this.availableFrom = availableFrom; }
    public void setAvailableUntil(LocalDate availableUntil) { this.availableUntil = availableUntil; }
    public void setSoldOut(boolean isSoldOut) { this.isSoldOut = isSoldOut; }

    // toString
    @Override
    public String toString() {
        return super.toString() +
                " SeasonalProduct{" +
                "dropType='" + dropType + '\'' +
                ", availableUntil=" + availableUntil +
                ", isSoldOut=" + isSoldOut +
                '}';
    }
}