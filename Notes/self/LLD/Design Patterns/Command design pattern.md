## Command Design Pattern

## Scope / Agenda

* Command Pattern

---

## Class Notes and Videos

1. [Class Notes](/Notes/class_Notes/LLD/Design%20Patterns/Command.pdf)
2. [Class/Lecture Video](https://youtu.be/example_video_link)

---

## Command Pattern

### 🎯 Intent

> The **Command Pattern** is a behavioral design pattern that turns a request into a stand-alone object. This object contains all the information needed to execute the request, including the method call, the method arguments, and the object that owns the method. It decouples the sender from the receiver by encapsulating a request as an object.

---

### 🧩 Problem

You want to decouple the sender of a request from the object that will perform the action. For example, in a simple UI system, you want to execute various commands (like opening a file, saving a file, etc.) without the UI component knowing the details of how these actions are performed.

---

### ✅ Solution

Use the **Command Pattern** to encapsulate each request into a separate object that contains the method to call and the parameters needed to call it. The invoker class will hold a reference to these command objects and execute them when necessary.

---

### 💡 Real-World Analogy

Consider a **TV Remote Control**. The remote has buttons for different functions like power, volume, and channel control. Each button is mapped to a specific command. The user just presses a button without worrying about how the command is executed.

---

### 📦 Structure

```

Client --> Command --> Invoker
^
|
Receiver

````

- **Command**: Declares an interface for executing a request.
- **ConcreteCommand**: Defines a binding between a receiver object and an action.
- **Invoker**: Asks the command to execute the request.
- **Receiver**: Knows how to perform the operations to satisfy a request.
- **Client**: Creates a command object and sets its receiver.

---

### 🧑‍💻 Java Example

#### 1. Command Interface

```java
public interface Command {
    void execute();
}
````

#### 2. Concrete Command Classes

```java
public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
```

#### 3. Receiver Class

```java
public class Light {
    public void turnOn() {
        System.out.println("The light is ON");
    }

    public void turnOff() {
        System.out.println("The light is OFF");
    }
}
```

#### 4. Invoker Class

```java
public class RemoteControl {
    private Command slot;

    public void setCommand(Command command) {
        this.slot = command;
    }

    public void pressButton() {
        slot.execute();
    }
}
```

#### 5. Client Code

```java
public class CommandPatternDemo {
    public static void main(String[] args) {
        Light light = new Light();
        
        LightOnCommand lightOn = new LightOnCommand(light);
        LightOffCommand lightOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();
        
        remote.setCommand(lightOn);
        remote.pressButton(); // Output: The light is ON
        
        remote.setCommand(lightOff);
        remote.pressButton(); // Output: The light is OFF
    }
}
```

---

### ✅ Pros

* **Decouples sender and receiver**: The sender only knows the command interface and does not need to know the details of how the request is executed.
* **Extensibility**: New commands can be added without changing the existing classes, promoting the open/closed principle.
* **Undo/Redo functionality**: Command objects can be stored and reversed, enabling the undo/redo feature in applications like text editors.

---

### ❌ Cons

* **Increased number of classes**: For each command, you need to create a concrete class, which can lead to a large number of command classes in some applications.
* **Complexity**: If overused, it can lead to an overcomplicated design with too many objects.

---

### 🧠 Key Points

* **Command Pattern** encapsulates a request as an object, allowing for parameterization of clients with different requests.
* It helps decouple the sender and the receiver by abstracting the command execution.
* Command objects can be queued, logged, and executed at different times, enabling advanced features like undo/redo functionality.

---

### 🏁 When to Use

* When you need to decouple the sender of a request from the receiver.
* When you need to parameterize objects according to the action they perform (e.g., different button presses triggering different actions).
* When you want to implement undo/redo functionality in your system.
* When you want to queue requests, schedule tasks, or log requests.

---
