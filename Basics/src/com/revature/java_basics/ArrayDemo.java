package com.revature.java_basics;

import java.io.ObjectStreamException;
import java.sql.SQLOutput;

/**
 * This is a simple driver class that serves to introduce associates to
 * the concept of Java arrays
 */

public class ArrayDemo {

    public static void main(String[] args) {

        int[] intArray_1 = new int[10]; // an empty array of ints, with space for 10 elements
        int intArray_2[] = new int[5];  // legal, but kinda weird
        int [] intArray_3 = new int[5]; // legal, but again, weird

        // Change the value of an element at some position within the array
        intArray_1[1] = 42;
        intArray_1[9] = 93;

        for (int i = 0; i < intArray_1.length; i++) {
//            System.out.println("The value at position " + i + "is: " + intArray_1[i]);
            System.out.printf("The value at position %d is: %s\n", i, intArray_1[i]);
        }

        // Accessing position out of the bounds of the array
//        System.out.println(intArray_1[10]); // results in an ArrayIndexOutOfBoundsException

        boolean[] boolArr = new boolean[3];
        printArrayValues(boolArr);


        String[] stringArr = new String[5];
//        stringArr[4] = 42;  // does not work, because this array only stores String values

        Object[] objectArr = new Object[5];
        objectArr[0] = "some string";
        objectArr[1] = 42; // this primitive int value will be "autoboxed" into an Integer object
        objectArr[2] = false;
        objectArr[3] = null;

        // does not work, because even though the value went in as a string, it comes out as an Object
        // however, we can cast objects to other types if we are sure that the types are compatible
//        String stringFromArray = objectArr[0];
        String stringFromArray = (String) objectArr[0]; // explicit casting
        System.out.println(stringFromArray);

        // Array in Java are of a fixed length, once instantiated, their size will not change
        // until the reference is reassigned to some other array object.

        // Making a new array that contains the same values as another but is of a different size
        Object[] largerArray = new Object[6];
        for (int i = 0; i < objectArr.length; i++) {
            largerArray[i] = objectArr[i];
        }

        System.out.println(("+-------------------------+"));

        // The above logic can be simplified by leveraging the Arrays utility class
        // to make a copy of some array and increase/decrease its size.
//        Object[] otherArray = Arrays.copyOf(objectArr, 6);

        // We can use a different syntax for iterating across aggregate structures
        // called: for-each loop, enhance for loop
//        for (Object o : otherArray) {
//            System.out.println(o);
//        }

        System.out.println(("+-------------------------+"));

        // Multidimensional arrays are possible

//        int[][] intArray_2d = new int[4][3];

        // 2D array instantiated using array literal syntax
        int[][] intArray_2d = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };

        // Iterating across multidimensional arrays

        for (int i = 0; i < intArray_2d.length; i++) {
            for (int j = 0; j < intArray_2d[i].length; j++) {
                System.out.printf("The value at position (%d, %d), is: %s\n", i, j, intArray_2d[i][j]);
            }
        }

        System.out.println(("+-------------------------+"));

        int[] arr = {33, 32, 444, 0, 45, 93, 90, 932, -6, 440};
        int[] smallArr = {1};
        int[] emptyArr = { };
        int result = findMaxValue(arr);
        System.out.println(result);


        varArgMethod("s");
        varArgMethod("s", 1);
        varArgMethod("s", 0, 4, 1);



    }

    // We need to declare this method as static so it can be accessed from other static contexts
    public static void printArrayValues(boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
//            System.out.println("The value at position " + i + "is: " + arr[i]);
            System.out.printf("The value at position %d is: %s\n", i, arr[i]);
        }
    }

    public static int findMaxValue(int[] arr) {
        // Solve edge cases first
        if (arr.length == 0) {
            return Integer.MIN_VALUE;
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Also valid - one line statements = no need for braces
//        for (int i = 1; i < arr.length; i++)
//            if (arr[i] > max)
//                max = arr[i];

        return max;
    }

    // VarArgs = variable arguments
    // literally a variable number of arguments (0 -> n)
    // must be the last param in the method
    // other params must be required
    public static void varArgMethod(String s, int... someInts) {
        System.out.println("Start");
        for (int i = 0; i < someInts.length; i++) {
            System.out.println(someInts[i]);
        }
    }


}




