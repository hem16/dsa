package org.example.dp.observer;

// ObserverDemo.java
/*
    The Observer Pattern is a behavioral design pattern that defines a one-to-many dependency
     between objects so that when one object changes state, all its dependents are notified
     and updated automatically. This pattern is commonly used in event handling systems.
 */
public class ObserverDemo {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        Observer observer1 = new ConcreteObserver("Observer 1");
        Observer observer2 = new ConcreteObserver("Observer 2");

        subject.registerObserver(observer1);
        subject.registerObserver(observer2);

        subject.setMessage("Hello, Observers!");

        subject.removeObserver(observer1);

        subject.setMessage("Goodbye, Observer 1!");
    }
}
