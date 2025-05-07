## Adapter Design Pattern

## Scope / Agenda

* Adapter Pattern

---

## Class Notes and Videos

1. [Class Notes](/Notes/class_Notes/LLD/Design%20Patterns/Adapter.pdf)
2. [Class/Lecture Video](https://youtu.be/example_video_link)

---

## Adapter Pattern

### 🎯 Intent

> **Adapter Pattern** is a structural design pattern that allows incompatible interfaces to work together. It acts as a bridge between two incompatible interfaces by converting one interface to another.

---

### 🧩 Problem

You have two systems that you need to integrate, but their interfaces are incompatible. You want to use one system’s functionality in the other without modifying their existing code.

---

### ✅ Solution

The **Adapter** pattern involves creating a new class (the Adapter) that acts as a bridge. The Adapter wraps the incompatible class and provides a compatible interface that the client can work with.

---

### 💡 Real-World Analogy

Consider the **plug adapter** for electronics: The power socket and the plug might have different shapes or voltages, but the adapter allows the plug to fit into the socket, enabling the device to work.

---

### 📦 Structure

```

Client --> Adapter --> Adaptee (existing class)

````

---

### 🧑‍💻 Java Example

#### 1. Target Interface

```java
public interface MediaPlayer {
    void play(String audioType, String fileName);
}
````

#### 2. Adaptee (Incompatible Interface)

```java
public class MediaAdapter {
    private AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType) {
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMusicPlayer = new VlcPlayer();
        } else if(audioType.equalsIgnoreCase("mp4")){
            advancedMusicPlayer = new Mp4Player();
        }
    }

    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMusicPlayer.playVlc(fileName);
        } else if(audioType.equalsIgnoreCase("mp4")){
            advancedMusicPlayer.playMp4(fileName);
        }
    }
}
```

#### 3. Adaptee (AdvancedMediaPlayer Interface)

```java
public interface AdvancedMediaPlayer {
    void playVlc(String fileName);
    void playMp4(String fileName);
}
```

#### 4. Concrete Adaptee Implementations

```java
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // do nothing
    }
}

public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        // do nothing
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}
```

#### 5. Client Code

```java
public class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        // In-built support to play mp3 music files
        if(audioType.equalsIgnoreCase("mp3")){
            System.out.println("Playing mp3 file. Name: " + fileName);
        }
        // Adapter used for other formats like vlc and mp4
        else if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }
        else{
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}
```

#### 6. Client Code (Main)

```java
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
```

---

### ✅ Pros

* **Flexibility**: Allows the integration of classes that would otherwise be incompatible.
* **Reusability**: You can reuse existing classes by adapting them to work with other systems.
* **Loose Coupling**: Client code is not directly dependent on the incompatible class but on the adapter.

---

### ❌ Cons

* **Extra Layer of Indirection**: The adapter adds complexity by introducing an additional layer between the client and the actual implementation.
* **Potential Performance Overhead**: In cases with many adapters, performance could be slightly impacted due to the additional layer.

---

### 🧠 Key Points

* **Adapter Pattern** allows incompatible classes to work together by introducing a middle layer (the Adapter).
* It is useful when integrating legacy systems or libraries that have incompatible interfaces with modern code.
* The adapter translates calls from the client into a format that is understood by the existing class (adaptee).

---

### 🏁 When to Use

* When you have classes that can't interact because of incompatible interfaces.
* When you want to integrate legacy systems or third-party libraries without changing their existing code.
* When you want to create a flexible and reusable code structure by decoupling the client from the adaptee.

---
