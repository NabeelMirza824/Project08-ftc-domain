# 🍦 ftc-domain — FindThatCream Domain Model

**Project 08 of the EVAITCS Full Stack Curriculum**

---

## Overview

This project builds the complete domain model for FindThatCream — a mobile-first
web app that helps premium ice cream lovers find which retailers carry the newest
and most viral flavors. Every class built here becomes a real JPA entity when we
reach Spring Boot in Project 17.

---

## What Was Built

| Class | Type | OOP Concept | Spring Boot Connection |
|-------|------|-------------|----------------------|
| `DietaryInfo` | Regular Class | Encapsulation | `@Embeddable` |
| `Brand` | Regular Class | Encapsulation + Validation | `@Entity` + `@OneToMany` |
| `Discoverable` | Interface | Abstraction + Polymorphism | Service layer contract |
| `IceCreamProduct` | Abstract Class | Abstraction + Inheritance | `@Entity` + `@Inheritance` |
| `PackagedProduct` | Concrete Class | Inheritance + Polymorphism | `@Entity` + `@DiscriminatorValue` |
| `SeasonalProduct` | Concrete Class | Inheritance + Polymorphism | `@Entity` + `@DiscriminatorValue` |
| `Retailer` | Regular Class | Encapsulation + Validation | `@Entity` + `@ManyToMany` |
| `FindThatCreamApp` | Main Class | All four OOP pillars | Becomes Service + Controller layers |

---

## OOP Concepts Demonstrated

### Encapsulation
All fields are `private`. Data is accessed and modified only through
getters and setters. Setters include validation — for example, brand name
and retailer name cannot be null or empty or an `IllegalArgumentException` is thrown.

### Inheritance
`PackagedProduct` and `SeasonalProduct` both extend `IceCreamProduct`.
They inherit all shared fields (flavorName, brand, price, dietaryInfo) and
add their own unique fields on top. The `super()` constructor call ensures
the parent is fully built before the child adds anything.

### Polymorphism
Both product types are referenced as `IceCreamProduct` throughout the app.
A single `List<IceCreamProduct>` can hold both `PackagedProduct` and
`SeasonalProduct` objects. Each calls its own version of `getProductType()`
at runtime — same method name, different behavior depending on the object.

### Abstraction
`IceCreamProduct` is abstract — it cannot be instantiated directly.
It defines `getProductType()` as an abstract method that every subclass
must implement. `Discoverable` is an interface that defines a contract
of three methods any discoverable product must fulfill.

---

## Domain Model Relationships
Discoverable (interface)
↑
IceCreamProduct (abstract) ← Brand
↑              ↑
PackagedProduct  SeasonalProduct
IceCreamProduct → List<Retailer>
IceCreamProduct → DietaryInfo
---

## Sample Output
========================================
FindThatCream — Domain Model Demo
--- Product Catalog ---
Jeni's — Brown Butter Almond Brittle | $12.99
Type: Packaged Product
Dietary Safe For All: false
Available at Wegmans: true
Available at Target: false
Van Leeuwen — Sicilian Pistachio Collab | $14.99
Type: Seasonal Drop — Collab
Still Available: true
New Drop: true
--- All Products (Polymorphism Demo) ---
Jeni's — Brown Butter Almond Brittle | $12.99 | Type: Packaged Product
Van Leeuwen — Sicilian Pistachio Collab | $14.99 | Type: Seasonal Drop — Collab
--- Retailer Verification Status ---
Whole Foods | Verified: true
Wegmans | Verified: true
Mom's Organic | Verified: false
---

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Java 25 |
| Build Tool | Maven |
| IDE | IntelliJ IDEA |
| Architecture | Domain Model (feeds into Spring Boot Project 17) |

---

## How This Connects to FindThatCream

When we reach Spring Boot (Project 17-21), these classes get promoted
to full database entities with a single annotation each:

- `@Entity` on every class
- `@Embeddable` on DietaryInfo
- `@OneToMany` between Brand and IceCreamProduct
- `@ManyToMany` between IceCreamProduct and Retailer
- `@Inheritance(strategy = InheritanceType.JOINED)` on IceCreamProduct

The domain model we built here becomes the actual database schema for
FindThatCream with almost no changes needed.

---

## Author

**Nabeel Mirza**
EVAITCS Full Stack Developer Curriculum
GitHub: [@nabeelmirza824](https://github.com/nabeelmirza824)

---

## Curriculum Progress

| Project | Name | Status |
|---------|------|--------|
| 01 | PlanMyApp | ✅ Complete |
| 02 | ArchitectMyApp | ✅ Complete |
| 03 | DevEnvironmentSetup | ✅ Complete |
| 04 | ManageMyProject | ✅ Complete |
| 05 | DocumentMyCode | ✅ Complete |
| 06 | DeployMyApp | ✅ Complete |
| 07 | BuildMyCalculator | ✅ Complete |
| **08** | **ftc-domain (OOP Fundamentals)** | **✅ Complete** |
| 09 | OOP Advanced | ⬜ Up Next |
| 10-28 | ... | ⬜ Upcoming |