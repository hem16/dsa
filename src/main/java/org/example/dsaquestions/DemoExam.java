package org.example.dsaquestions;

public class DemoExam {
    public void method1(){
        Error error = new Error();
        System.out.println(error instanceof Throwable);
        System.out.println(error instanceof Error);
        //System.out.println(error instanceof Exception);
        //System.out.println(error instanceof RuntimeException);
    }


    public static void main(String[] args) {
        DemoExam ex = new DemoExam();
        ex.method1();
    }
}
