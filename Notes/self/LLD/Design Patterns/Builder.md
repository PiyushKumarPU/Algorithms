
## Builder Design Pattern

## Scope / Agenda

* Builder Pattern

---

## Class Notes and Videos

1. [Class Notes](/Notes/class_Notes/LLD/Design%20Patterns/Builder.pdf)
2. [Class/Lecture Video](https://youtu.be/6Mz5DmbSKJQ)

---

## Builder Pattern

### 🎯 Intent

> **Builder Pattern** is a creational design pattern that allows for the step-by-step construction of a complex object. It separates the construction of the object from its representation, allowing the same construction process to create different representations.

---

### 🧩 Problem

When an object has:
- Many attributes (some mandatory, some optional).
- Complex construction logic.
- Need to set properties in a specific sequence.
You might face challenges like telescoping constructors or numerous setter methods.

---

### ✅ Solution

Instead of using constructors or setters, create a **Builder** class that provides methods to construct the object step by step. Finally, a `build()` method will return the fully constructed object.

---

### 💡 Real-World Analogy

Consider building a complex sandwich at a deli counter. The customer chooses various components such as bread type, fillings, sauces, and toppings step by step. At the end, they get their customized sandwich (complex object).

---

### 📦 Structure

```

Client --> Builder (interface) --> ConcreteBuilder
|
Director (optional)
↓
Product (Complex Object)

````

---

### 🧑‍💻 Java Example

#### 1. Product (Complex Object)

```java
public class Sandwich {
    private String bread;
    private String filling;
    private String sauce;
    private boolean cheese;
    private boolean lettuce;

    public Sandwich(String bread, String filling, String sauce, boolean cheese, boolean lettuce) {
        this.bread = bread;
        this.filling = filling;
        this.sauce = sauce;
        this.cheese = cheese;
        this.lettuce = lettuce;
    }

    @Override
    public String toString() {
        return "Sandwich with " + bread + ", " + filling + ", " + sauce + ", Cheese: " + cheese + ", Lettuce: " + lettuce;
    }
}
````

#### 2. Builder

```java
public class SandwichBuilder {
    private String bread;
    private String filling;
    private String sauce;
    private boolean cheese;
    private boolean lettuce;

    public SandwichBuilder setBread(String bread) {
        this.bread = bread;
        return this;
    }

    public SandwichBuilder setFilling(String filling) {
        this.filling = filling;
        return this;
    }

    public SandwichBuilder setSauce(String sauce) {
        this.sauce = sauce;
        return this;
    }

    public SandwichBuilder addCheese(boolean cheese) {
        this.cheese = cheese;
        return this;
    }

    public SandwichBuilder addLettuce(boolean lettuce) {
        this.lettuce = lettuce;
        return this;
    }

    public Sandwich build() {
        return new Sandwich(bread, filling, sauce, cheese, lettuce);
    }
}
```

#### 3. Client

```java
public class SandwichShop {
    public static void main(String[] args) {
        Sandwich sandwich = new SandwichBuilder()
                                .setBread("Whole Wheat")
                                .setFilling("Veggies")
                                .setSauce("Mayonnaise")
                                .addCheese(true)
                                .addLettuce(true)
                                .build();

        System.out.println(sandwich);
    }
}
```

---

### ✅ Pros

* **Readable** code using method chaining.
* Can handle complex object creation with various optional and required parameters.
* Object is always in a valid state upon construction.
* Supports **immutable** final objects.

---

### ❌ Cons

* Requires additional builder classes.
* Can introduce overhead for simple objects.
* More code up front compared to constructors.

---

## 🧠 Key Points

* **Builder** allows for step-by-step construction of a complex object.
* Separate object construction from representation.
* Method chaining provides a clean, readable API for building the object.
* It's useful when an object has multiple optional parameters or complex construction logic.

---

## 🏁 When to Use

* When an object needs to be constructed step-by-step with many optional parameters.
* When constructing an object is complex and involves conditional logic.
* When you need to return immutable objects.

---

### ⚖️ Pros and Cons

| Aspect       | Builder Pattern                                                   |
| ------------ | ----------------------------------------------------------------- |
| Purpose      | Step-by-step construction of complex objects                      |
| Flexibility  | Allows customization at each step                                 |
| Object Types | Complex, with optional and required fields                        |
| Client Usage | Easy to customize object without multiple constructors or setters |

---
