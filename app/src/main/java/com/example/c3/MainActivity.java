package com.example.c3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

/*

1. Write a method that takes an int array and a int target value as parameters.
 The int Array will be a guaranteed to be a sorted array of unique  positive values.
  Have the method find the index in the target value if it exist in the array.  If not, return -1.
    Time complexity allowed:  O ( log n )

Example:
Int[] array:  {1,2,3,4,5,6,10,20,50}
Target: 20

Return would equal 7.

2.  Write a method to calculate the value of n^m.  The method MUST have a time complexity of less
than O( n ) ;  m can be any int value (negative and positive)
3. Write a program to remove duplicates from an array in Java without using the
Java Collection API.

 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] arr = {1, 2, 3, 4, 5, 6, 10, 20, 50};
        int target = 6;
        int result = binarySearch(arr, target);
        Log.v("TAG", String.valueOf(result));

        int exponent = exponential(4, 6);
        Log.v("TAG", "Exponent:" + String.valueOf(exponent));

    }

    private int binarySearch(int[] arr, int target) {

        int temp = 0;
        int range = arr.length - 1;

        while (range >= temp) {
            int i = temp + (range - temp) / 2;

            // Check if value is present at mid-point
            if (arr[i] == target)
                return i;

            // Ignore left half if value is greater
            if (arr[i] < target) {
                temp = i + 1;
            }
            // Ignore the right half if value is smaller
            else {
                range = i - 1;
            }
        }
        // Element doesn't exist
        return -1;


    }


    public int exponential(int n, int m) {

        // n^m

        int temp = m;

        while (m > 0) {

            Log.v("exp", n + "^" + m + " = ");

            n = n * n;
            temp--;

            Log.v("exp", String.valueOf(n));

            if (temp == 0) {
                return n;
            }

        }

        while (m < 0) {

            n = n * n;
            temp++;
            if (temp == 0) {
                return n;
            }

        }

        return n;

    }

}
