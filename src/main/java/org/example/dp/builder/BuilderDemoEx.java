package org.example.dp.builder;

/*
-----------------------
Builder Design Pattern:
-----------------------
If we have complex process to create an object, the complexity could be because of number of args that constructor needs.

Complexity because of steps may be needed in order to create an object.

So with this pattern we remove the logic related to object construction from our code and abstracted into multile seperate classes.

The user then will easily create the object.

There are various different classes that can create to implement Builder Pattern

- Role - Product - final complex object that we want to create.

- Role - Builder - will defined interface for creating 'parts' of the product.

- Role - Concrete Builder - constructs parts and assembles final product.
                          - keep track of products it create.
- Role - Director - uses builder to construct object.
                  - knows the steps & their sequence to build product.

 */
public class BuilderDemoEx {

    final int x;
    final int y;
    final int z;
    final int l;
    final int m;

    public BuilderDemoEx(Builder builder) {
        x = builder.x;
        y = builder.y;
        z = builder.z;
        l = builder.l;
        m = builder.m;
    }

    public static class  Builder {

        int x;
        int y;
        int z;
        int l;
        int m;

        public Builder(int x,int y){
            this.x = x;
            this.y = y;
        }

        public Builder addZ(int z) {
            this.z = z;
            return this;
        }

        public Builder addL(int l) {
            this.l = l;
            return this;
        }

        public Builder addM(int m) {
            this.m = m;
            return this;
        }

        public BuilderDemoEx build() {
            BuilderDemoEx builderDemoEx = new BuilderDemoEx(this);
            return builderDemoEx;
        }

    }

    public static void main(String args[]) {
        Builder builder = new Builder(4,6);
        builder.addZ(2).addL(8).build();
        System.out.println(builder);
    }

    @Override
    public String toString() {
        return "BuilderDemoEx{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", l=" + l +
                ", m=" + m +
                '}';
    }
}
