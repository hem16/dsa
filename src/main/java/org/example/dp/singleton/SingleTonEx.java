package org.example.dp.singleton;

public class SingleTonEx {
    private static SingleTonEx INSTANCE = null;
    private SingleTonEx(){
    }

    public static SingleTonEx getInstance(){
      if(INSTANCE == null){
          synchronized (SingleTonEx.class) {
              if(INSTANCE == null) {
                  INSTANCE = new SingleTonEx();

              }
          }
      }
    return INSTANCE;
    }
}

class S {
    public static void main(String args[]){
        System.out.println(SingleTonEx.getInstance());
        System.out.println(SingleTonEx.getInstance());
    }


}
