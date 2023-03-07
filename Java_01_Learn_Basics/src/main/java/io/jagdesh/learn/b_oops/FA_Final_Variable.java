package io.jagdesh.learn.b_oops;

public class FA_Final_Variable {
    final int speedLimit = 90;
    void run() {
        //speedLimit = 400;
    }
    public static void main(String[] args) {
        FA_Final_Variable obj=new  FA_Final_Variable();
        obj.run();  // Compile Time Error
    }
}
