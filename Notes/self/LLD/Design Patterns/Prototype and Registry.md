
## Prototype and Registry Design Patterns

## Scope / Agenda

* Prototype Pattern
* Registry Pattern

---

## Class Notes and Videos

1. [Class Notes](/Notes/class_Notes/LLD/Design%20Patterns/Prototype%20and%20Registry.pdf)
2. [Class/Lecture Video](https://youtu.be/TvZekIEp65o)

---

## Prototype Pattern

### 🎯 Intent

> **Prototype Pattern** is a creational design pattern that allows cloning of objects, ensuring that the cloning process creates a new object with the same properties but without modifying the original object.

---

### 🧩 Problem

When you need to create many objects of the same type, but object creation is expensive (either in terms of computation or memory), you might end up duplicating the construction logic. This leads to unnecessary complexity and performance overhead.

---

### ✅ Solution

Instead of creating new instances from scratch, use **Prototype** objects that can be cloned. A `clone()` method is implemented in the prototype to generate a copy of the object.

---

### 💡 Real-World Analogy

Consider the process of photocopying a document. The photocopier doesn't need to recreate the entire document from scratch; it simply makes a copy. The original document is unchanged, and you can have as many copies as needed.

---

### 📦 Structure

```

Client --> Prototype (abstract class or interface) --> ConcretePrototype
↓
Clone()
↓
Product (Cloned Object)

````

---

### 🧑‍💻 Java Example

#### 1. Prototype Interface

```java
public interface Prototype {
    Prototype clone();
}
````

#### 2. Concrete Prototype

```java
public class ConcretePrototype implements Prototype {
    private String data;

    public ConcretePrototype(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype(this.data);
    }

    @Override
    public String toString() {
        return "ConcretePrototype{data='" + data + "'}";
    }
}
```

#### 3. Client

```java
public class PrototypeClient {
    public static void main(String[] args) {
        ConcretePrototype original = new ConcretePrototype("Original Data");
        ConcretePrototype cloned = (ConcretePrototype) original.clone();
        
        System.out.println("Original: " + original);
        System.out.println("Cloned: " + cloned);
    }
}
```

---

### ✅ Pros

* **Performance**: Cloning is generally faster than creating a new object from scratch, especially for complex objects.
* **Decouples creation logic**: Reduces the need to know the exact class or constructor to call when creating a new object.
* **Flexible object creation**: Allows easy creation of objects with slight modifications from the prototype.

---

### ❌ Cons

* **Complexity in implementation**: Cloning objects may introduce complexity, especially if objects contain references to other objects that also need to be cloned.
* **Deep vs. shallow cloning**: Managing deep and shallow cloning can be tricky if objects have nested references.
* **Maintenance**: Keeping all prototypes in sync can become difficult as the system grows, especially if there are many different object configurations.

---

## 🧠 Key Points

* **Prototype Pattern** is useful for creating duplicate objects without having to know how the object is created.
* It supports both **shallow** and **deep** cloning depending on the implementation.
* Allows cloning of complex objects efficiently, reducing the overhead of object creation.

---

## 🏁 When to Use

* When the cost of creating an object is substantial and cloning an existing instance is more efficient.
* When you need to create many identical objects, with minor modifications, efficiently.
* When creating new objects involves a complex creation process or substantial setup.

---

## Registry Design Pattern

### 🎯 Intent

> **Registry Pattern** is a creational design pattern that provides a global access point to a registry of objects. It allows the registration and retrieval of objects, typically by some identifier.

---

### 🧩 Problem

In some cases, you may need to access a set of objects globally without explicitly passing them around. For example, a logging framework where the logger object should be accessible anywhere without re-initializing it.

---

### ✅ Solution

Implement a **Registry** that holds the objects and exposes methods to register and retrieve them globally. It allows the client code to fetch the appropriate object from a central place without needing to know the exact class or configuration.

---

### 💡 Real-World Analogy

Think of a **Library Registry** where books are stored under certain genres. A reader doesn't need to know where each book is located in the library; they just look up the genre and find the available books under it. The registry acts as the lookup mechanism.

---

### 📦 Structure

```
Client --> Registry (stores objects)
                        ↓
                     Register()
                        ↓
                   Get() - Retrieves the object by key
```

---

### 🧑‍💻 Java Example

#### 1. Registry Class

```java
import java.util.HashMap;
import java.util.Map;

public class Registry {
    private Map<String, Prototype> registry = new HashMap<>();

    public void register(String key, Prototype prototype) {
        registry.put(key, prototype);
    }

    public Prototype getPrototype(String key) {
        Prototype prototype = registry.get(key);
        return prototype != null ? prototype.clone() : null;
    }
}
```

#### 2. Client

```java
public class RegistryClient {
    public static void main(String[] args) {
        // Creating and registering prototypes
        Registry registry = new Registry();
        ConcretePrototype prototype1 = new ConcretePrototype("Prototype 1");
        ConcretePrototype prototype2 = new ConcretePrototype("Prototype 2");

        registry.register("Prototype1", prototype1);
        registry.register("Prototype2", prototype2);

        // Retrieving and cloning prototypes
        ConcretePrototype clone1 = (ConcretePrototype) registry.getPrototype("Prototype1");
        ConcretePrototype clone2 = (ConcretePrototype) registry.getPrototype("Prototype2");

        System.out.println("Cloned Prototype1: " + clone1);
        System.out.println("Cloned Prototype2: " + clone2);
    }
}
```

---

### ✅ Pros

* **Global access**: Easy to access objects without needing to pass them explicitly throughout the application.
* **Centralized management**: Helps in managing the lifecycle of objects in a centralized location.
* **Efficient**: Eliminates the need to re-create objects and allows reusing prototypes.

---

### ❌ Cons

* **Tight coupling**: The client code might become dependent on the registry for accessing objects.
* **Global state**: Having a global registry can sometimes lead to difficulties in managing state, especially in multi-threaded environments.
* **Scalability**: In large systems, managing a large number of objects in the registry might become cumbersome.

---

## 🧠 Key Points

* **Registry Pattern** helps manage and access objects globally in an application.
* Objects can be registered and cloned, and clients can fetch them based on a key.
* It can be combined with the **Prototype Pattern** to facilitate the global cloning of objects.

---

## 🏁 When to Use

* When you need to provide global access to a set of objects.
* When you need to avoid passing references to objects around in your codebase.
* When you want to centralize the management and configuration of prototypes.

---

### ⚖️ Pros and Cons

| Aspect       | Prototype Pattern                 | Registry Pattern                |
| ------------ | --------------------------------- | ------------------------------- |
| Purpose      | Cloning objects efficiently       | Centralized object registration |
| Flexibility  | Supports shallow and deep cloning | Allows global access to objects |
| Object Types | Objects with similar structure    | Objects with global access      |
| Client Usage | Creates clones of prototypes      | Retrieves objects from registry |

---
