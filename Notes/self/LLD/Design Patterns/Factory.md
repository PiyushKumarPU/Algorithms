## Factory and Abstract Factory Design Patterns

## Scope / Agenda

* Factory Pattern
* Abstract Factory Pattern

---

## Class Notes and Videos

1. [Class Notes](/Notes/class_Notes/LLD/Design%20Patterns/Factory.pdf)
2. [Class/Lecture Video](https://youtu.be/4R33sha1nTg)

---

## Factory Pattern

### 🎯 Intent

> **Factory Method Pattern** defines an interface for creating an object, but allows subclasses to alter the type of objects that will be created.

---

### 🧩 Problem

Suppose you're building a notification service. Depending on user preferences, you might send an **Email**, **SMS**, or **Push Notification**. You don’t want the client code to know the concrete classes (tight coupling). You want a centralized way to create objects.

---

### ✅ Solution

Instead of instantiating concrete classes directly, create a **Factory** class/method to handle object creation.

---

### 💡 Real-World Analogy

A person ordering food doesn’t care how it's made in the kitchen. They just choose what they want from the menu. The kitchen (Factory) knows how to prepare it.

---

### 📦 Structure

```java
// Step 1: Create Product interface
public interface Notification {
    void notifyUser();
}

// Step 2: Implement concrete products
public class SMSNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending SMS Notification");
    }
}

public class EmailNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending Email Notification");
    }
}

// Step 3: Create Factory
public class NotificationFactory {
    public Notification createNotification(String type) {
        if ("SMS".equalsIgnoreCase(type)) {
            return new SMSNotification();
        } else if ("EMAIL".equalsIgnoreCase(type)) {
            return new EmailNotification();
        }
        return null;
    }
}

// Step 4: Client
public class NotificationService {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();
        Notification notification = factory.createNotification("EMAIL");
        notification.notifyUser();
    }
}
```

---

### ✅ Pros

* Single Responsibility Principle: Factory class handles object creation.
* Loose coupling between client code and concrete classes.
* Code becomes more readable and maintainable.

---

### ❌ Cons

* May introduce unnecessary complexity for simple scenarios.
* Difficult to manage if the number of concrete classes grows large.

---

## Abstract Factory Pattern

### 🎯 Intent

> Provides an interface for creating **families of related or dependent objects** without specifying their concrete classes.

---

### 🧩 Problem

You want to create UI elements (like Buttons and Checkboxes) for different operating systems (e.g., Windows, Mac). Each OS has its own version of these UI components. You want a way to create families of objects without knowing their concrete implementations.

---

### ✅ Solution

Use an **Abstract Factory** to create related objects without binding your code to specific classes.

---

### 💡 Real-World Analogy

Consider a **Furniture Factory**. IKEA can produce modern and Victorian styles of chairs and tables. Abstract Factory provides an interface to create a full set of furniture from a specific style.

---

### 📦 Structure

```java
// Step 1: Abstract product
interface Button {
    void render();
}

interface Checkbox {
    void render();
}

// Step 2: Concrete products
class WindowsButton implements Button {
    public void render() {
        System.out.println("Windows Button");
    }
}

class MacButton implements Button {
    public void render() {
        System.out.println("Mac Button");
    }
}

class WindowsCheckbox implements Checkbox {
    public void render() {
        System.out.println("Windows Checkbox");
    }
}

class MacCheckbox implements Checkbox {
    public void render() {
        System.out.println("Mac Checkbox");
    }
}

// Step 3: Abstract factory
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Step 4: Concrete factories
class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }

    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }

    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

// Step 5: Client
public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void renderUI() {
        button.render();
        checkbox.render();
    }

    public static void main(String[] args) {
        GUIFactory factory = new MacFactory(); // switch to WindowsFactory as needed
        Application app = new Application(factory);
        app.renderUI();
    }
}
```

---

### ✅ Pros

* Ensures that products created are compatible (family).
* Encourages consistency in product usage.
* Supports open/closed principle.

---

### ❌ Cons

* Adding new product families requires extending every factory.
* Increases number of classes and interfaces.

---

## 🧠 Key Differences

| Aspect       | Factory Pattern               | Abstract Factory Pattern              |
| ------------ | ----------------------------- | ------------------------------------- |
| Purpose      | Creates a single product      | Creates families of related products  |
| Flexibility  | Easy to extend single product | Harder to add new families            |
| Object Types | One per method                | Multiple, grouped in families         |
| Client Usage | Chooses type based on input   | Uses factory to get all product types |

---
