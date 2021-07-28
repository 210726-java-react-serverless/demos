package com.revature.java_basics;

public class OverloadingDemo {

    private static class Overloader {

        public void test(int i) {
            System.out.println("int: " + i);
        }

        // Not allowed
//        public int test(int i) {
//
//        }

        public void test(Integer i) {
            System.out.println("Integer: " + i);
        }

        public void test(int... ints) {
            System.out.println("Varargs");
            for (int i : ints) {
                System.out.println(i);
            }
        }

        public void test(double d) {
            System.out.println("double: " + d);
        }

        // this results in a compilation error because we already have a method named test that takes in
        // an array of ints (in the form of varargs)
        // we can fix it by adding or changing parameters in the method signature (String s/ int s)
        public void test(int s, int[] ints) {
            System.out.println("Varargs");
            for (int i : ints) {
                System.out.println(i);
            }
        }

    }







    public static void main(String[] args) {

        Overloader overloader = new Overloader();

        overloader.test(1); // test(int)

        /*
            If we were to remove the test(int i) method from Overloader, the above method invocation
            would call the test(double d) method. This is because the compiler will choose the
            method that results in the least amount of work being done. From this we can infer that
            converting an int-> double is less expensive than int -> Integer
         */

        overloader.test(new Integer(4));    // test(Integer)

        overloader.test();      // test(int...)

        overloader.test(1, 2);  // test(int...)

        overloader.test(new int[] {1, 2, 3, 4, 5}); // test(int...)

        overloader.test(4, new int[] {1, 2, 3, 4, 5});


    }

}
