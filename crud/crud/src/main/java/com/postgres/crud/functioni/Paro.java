package com.postgres.crud.functioni;

import java.util.*;
import java.lang.*;
import java.util.stream.*;


public class Paro {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 3, 4, 4, 4, 5, 5 };
        int n = arr.length;

        // removeDuplicates() returns new size of array
        n = removeDuplicates(arr, n);

        // Print updated array
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    static int removeDuplicates(int arr[], int n){

        return 5;

    }
}