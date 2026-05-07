# Coffee Shop POS - Design Pattern Architecture

A robust Point of Sale (POS) system for a coffee shop built entirely in Java. This project was developed as part of a *Génie Logiciel* (Software Engineering) course to demonstrate the practical application of Object-Oriented design principles.

The core architecture completely avoids "spaghetti code" by implementing **10 distinct Gang of Four (GoF) Design Patterns**, ensuring the system is highly modular, extensible, and easy to maintain.

## Design Patterns Implemented

This project successfully integrates 10 patterns across all three GoF categories:

### 1. Creational Patterns

* **Factory Method (`ItemFactory`):** Centralizes the creation of base menu items (croissants, coffees) from string inputs.
* **Builder (`MealBuilder`):** Constructs complex combinations of items (Combo Meals) using a fluent interface without massive constructors.
* **Singleton (`StoreManager`):** Guarantees a single, globally accessible instance for tracking daily revenue and order statistics to prevent data fragmentation.

### 2. Structural Patterns

* **Composite (`MenuComponent`):** Treats individual items (leaves) and menu categories (nodes) uniformly, allowing the entire menu tree to be printed with a single method call.
* **Decorator (`Beverage` & Add-ons):** Dynamically wraps base drinks with add-ons (Milk, Sugar) to calculate prices and descriptions at runtime without class explosion.
* **Facade (`OrderProcessingFacade`):** Hides the complex checkout process (calculating totals, processing payments, updating screens, logging revenue) behind a single `processCheckout()` method.

### 3. Behavioral Patterns

* **State (`OrderStatus`):** Shifts the order through lifecycle phases (`Pending` -> `Preparing` -> `Ready`), safely encapsulating business rules (e.g., preventing cancellation during preparation).
* **Observer (`OrderObserver`):** Automatically pushes state changes from the Order (Subject) to the `KitchenMonitor` and `WaiterView` (Observers) without tight coupling.
* **Command (`OrderCommand`):** Encapsulates cashier actions (Place Order, Cancel Order) into objects, allowing for a complete undo/revert feature.
* **Strategy (`PaymentStrategy`):** Defines a common interface for billing algorithms (`CashPayment`, `CreditCardPayment`), making it easy to swap or add new payment methods dynamically.

## Project Structure

The codebase is organized by domain features rather than pattern types for better readability:

```text
src/main/java/com/coffeeshop/
├── core/       # Interfaces and Singletons (MenuComponent, StoreManager)
├── menu/       # Menu items, Factory, and Builder 
├── pricing/    # Beverage base and Decorators (Milk, Sugar)
├── order/      # Order logic, States, and Commands
├── payment/    # Payment Strategies (Cash, Card)
├── system/     # UI Observers and the Facade
└── App.java   # Client simulation
```
