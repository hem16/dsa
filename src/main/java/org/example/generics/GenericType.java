package org.example.generics;

public class GenericType<T> {
    
    T t;
    
    public GenericType(T t){
        this.t=t;
    }
    
    public void printIt(){
        System.out.println("t = " + t);
    }
}
