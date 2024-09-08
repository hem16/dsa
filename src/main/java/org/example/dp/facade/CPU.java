package org.example.dp.facade;

// CPU.java
public class CPU {
    public void freeze() {
        System.out.println("CPU is freezing...");
    }

    public void jump(long position) {
        System.out.println("CPU jumping to position: " + position);
    }

    public void execute() {
        System.out.println("CPU is executing...");
    }
}
