## Strategy Design Pattern

## Scope / Agenda

* Strategy Pattern

---

## Class Notes and Videos

1. [Class Notes](/Notes/class_Notes/LLD/Design%20Patterns/Strategy.pdf)
2. [Class/Lecture Video](https://youtu.be/example_video_link)

---

## Strategy Pattern

### 🎯 Intent

> The **Strategy Pattern** is a behavioral design pattern that enables selecting an algorithm at runtime. It allows a family of algorithms to be defined and encapsulated in separate classes, and the client can choose the desired algorithm to be used based on the context.

---

### 🧩 Problem

Suppose you need to perform different types of calculations (e.g., calculating the tax or shipping fee) depending on the situation. The traditional approach of using conditional statements (e.g., `if`, `switch`) can lead to code that is difficult to maintain and extend.

You want a way to encapsulate these algorithms and let the client code choose which one to use at runtime without modifying the existing classes.

---

### ✅ Solution

Encapsulate the different algorithms (strategies) in separate classes. Create a context class that will interact with the strategy objects. The client code can then dynamically choose which strategy to use at runtime.

---

### 💡 Real-World Analogy

Consider a **navigation system** where the system can calculate routes using different strategies: car, walking, or bicycle. The user can select the mode of transportation, and the system will use the appropriate algorithm to calculate the route.

---

### 📦 Structure

![Structure](../../../images/design_patterns/strategy.png)


- **Context**: The class that uses a strategy to perform an operation.
- **Strategy**: Defines a family of algorithms and declares a method for performing an operation.
- **ConcreteStrategy**: Implements a specific algorithm or behavior.

---

### 🧑‍💻 Java Example

#### 1. Strategy Interface

```java
public interface PaymentStrategy {
    void pay(int amount);
}
````

#### 2. Concrete Strategies

```java
public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

public class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal");
    }
}
```

#### 3. Context Class

```java
public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    // Set the strategy dynamically at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(int amount) {
        paymentStrategy.pay(amount);
    }
}
```

#### 4. Client Code

```java
public class StrategyPatternDemo {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        // Select payment strategy at runtime
        paymentContext.setPaymentStrategy(new CreditCardPayment());
        paymentContext.executePayment(500);

        paymentContext.setPaymentStrategy(new PayPalPayment());
        paymentContext.executePayment(300);
    }
}
```

#### Output:

```
Paid 500 using Credit Card
Paid 300 using PayPal
```

---

### ✅ Pros

* **Flexibility**: The strategy pattern allows the algorithm to be selected at runtime, providing flexibility in choosing different behaviors without modifying the code.
* **Open/Closed Principle**: You can add new strategies without changing the context or existing strategies, supporting the open/closed principle.
* **Eliminates Conditionals**: Avoids complex conditional statements (like `if` or `switch`) for selecting algorithms.

---

### ❌ Cons

* **Increased Number of Classes**: Each algorithm requires its own class, which can increase the number of classes in the system.
* **Complexity**: The pattern may introduce unnecessary complexity if the number of algorithms or strategies is small.
* **Context Overhead**: If the context class has too many strategies, it could become difficult to manage and maintain.

---

### 🧠 Key Points

* The **Strategy Pattern** encapsulates a family of algorithms in separate classes, allowing the client to select the desired algorithm at runtime.
* It is useful when you need to switch between different behaviors or strategies, such as sorting algorithms, payment methods, etc.
* It promotes the **Open/Closed Principle** by allowing new strategies to be added without modifying the context or existing strategies.
* This pattern eliminates the need for complex conditionals (`if`, `switch`) to select different behaviors.

---

### 🏁 When to Use

* When you have multiple algorithms or behaviors for a task and want to allow the client to choose one at runtime.
* When you want to avoid complex conditional statements for selecting an algorithm.
* When you need to swap behaviors dynamically, depending on the context.

---
