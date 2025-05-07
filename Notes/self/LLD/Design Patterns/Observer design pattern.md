## Observer Design Pattern

## Scope / Agenda

* Observer Pattern

---

## Class Notes and Videos

1. [Class Notes](/Notes/class_Notes/LLD/Design%20Patterns/Observer.pdf)
2. [Class/Lecture Video](https://youtu.be/example_video_link)

---

## Observer Pattern

### 🎯 Intent

> The **Observer Pattern** is a behavioral design pattern that allows an object (subject) to notify other objects (observers) about changes in its state. The observers can then update themselves according to the changes. This pattern is widely used for implementing distributed event-handling systems, where one object (the subject) changes its state and all dependent objects (observers) are notified.

---

### 🧩 Problem

You have an object (the subject) that needs to notify other objects (the observers) about a state change. You don’t want the subject to be tightly coupled with its observers. You want a mechanism to automatically update the observers whenever the subject's state changes.

---

### ✅ Solution

Implement the **Observer Pattern** where the subject maintains a list of observers and notifies them when a change occurs. The observers can subscribe and unsubscribe from the subject dynamically.

---

### 💡 Real-World Analogy

Think of a **news agency** that broadcasts news. The news agency (subject) produces news and broadcasts it to all its subscribers (observers), who then act based on the news. Subscribers can sign up to receive updates, and they can unsubscribe whenever they no longer wish to receive updates.

---

### 📦 Structure

```

Subject --> Observer --> ConcreteObserver

````

- **Subject**: Maintains a list of observers and provides methods to add, remove, and notify observers.
- **Observer**: Defines the interface that the concrete observers will implement.
- **ConcreteObserver**: Implements the observer interface and updates its state based on notifications from the subject.

---

### 🧑‍💻 Java Example

#### 1. Observer Interface

```java
public interface Observer {
    void update(String message);
}
````

#### 2. ConcreteObserver Class

```java
public class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}
```

#### 3. Subject Interface

```java
public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
```

#### 4. ConcreteSubject Class

```java
import java.util.ArrayList;
import java.util.List;

public class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String news;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }

    public void setNews(String news) {
        this.news = news;
        notifyObservers();
    }
}
```

#### 5. Client Code

```java
public class ObserverPatternDemo {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();

        Subscriber subscriber1 = new Subscriber("Alice");
        Subscriber subscriber2 = new Subscriber("Bob");

        newsAgency.addObserver(subscriber1);
        newsAgency.addObserver(subscriber2);

        newsAgency.setNews("Breaking News: Design Patterns are fun!");
    }
}
```

#### Output:

```
Alice received message: Breaking News: Design Patterns are fun!
Bob received message: Breaking News: Design Patterns are fun!
```

---

### ✅ Pros

* **Loose coupling**: The subject and the observers are loosely coupled. The subject does not need to know the details of its observers, just that they implement the observer interface.
* **Dynamic and flexible**: Observers can be added or removed dynamically at runtime.
* **Supports event-driven systems**: Ideal for systems that need to react to state changes or events.

---

### ❌ Cons

* **Memory and performance overhead**: If the number of observers grows large, it can create performance issues due to frequent notifications.
* **Potential for memory leaks**: If observers are not removed properly, it could lead to memory leaks as the subject holds references to all observers.
* **Order of updates**: There is no guaranteed order of notification delivery to observers, which may not be suitable in cases where order matters.

---

### 🧠 Key Points

* The **Observer Pattern** is used when one object needs to notify multiple dependent objects about a change in state.
* It allows dynamic registration and unregistration of observers, and the observers automatically receive updates when the subject’s state changes.
* The pattern is widely used in event-driven systems, such as user interfaces and messaging systems.

---

### 🏁 When to Use

* When an object (the subject) needs to notify other objects (observers) automatically about state changes.
* When you have a one-to-many dependency where one object changes and all dependent objects need to be updated.
* When implementing event-driven systems like UI frameworks or event buses.
* When designing systems where you want to avoid tight coupling between the subject and observers.

---
