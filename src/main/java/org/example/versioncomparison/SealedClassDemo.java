package org.example.versioncomparison;

public class SealedClassDemo {

    sealed class Animal permits Dog,Cat {
        public void sound(){
            System.out.println("");
        }
    }

    final class Dog extends Animal {
        public void sound(){
            System.out.println("making bhow bhow");
        }
    }

    final class Cat extends Animal {
        public void sound(){
            System.out.println("making meow meow");
        }
    }

    public void makingSound(Animal animal){
        if(animal instanceof Cat c) {
            c.sound();
        }

        if(animal instanceof Dog d) {
            d.sound();
        }
    }

    SealedClassDemo sealedClassDemo = new SealedClassDemo();
    SealedClassDemo.Animal cat = new Cat();


}
