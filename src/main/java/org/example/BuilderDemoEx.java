package org.example;

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
        BuilderDemoEx.Builder builder = new BuilderDemoEx.Builder(4,6);
        builder.addZ(2).addL(8).addM(12).build();
        System.out.println(builder);
    }
}
