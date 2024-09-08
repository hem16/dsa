package org.example.dp.facade;

/*
 * --------------------------
    Facade Design Pattern:
   --------------------------
Client has to interact with large number of interfaces and classes in a subsystem to get result. So clients get
tightly coupled with those i/f and classes. The Facade Pattern is a structural design pattern
that provides a simplified interface to a complex subsystem of classes, libraries, or frameworks.
It makes a complex system easier to use by providing a unified, high-level interface.

Role - Subsytems classes - These classes implements together to build functionality.
Role - Facade - interacts with subsystem classes to satisfy client request.
 *
 *
 */
public class FacadeDemo {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.start();
    }
}
