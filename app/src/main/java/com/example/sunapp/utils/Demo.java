package com.example.sunapp.utils;

public class Demo {
    private static int[] arr = {1, 5, 3, 7, 2,2,2,2, 10};

    public static void main(String[] args) {
        chaRU(arr);
    }

    private static int[] chaRU(int[] arr) {

        int length = arr.length;

        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0 && arr[j] <= arr[j - 1]; j--) {
                int t = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = t;
            }
        }
        for (int i : arr) {
            System.out.print(i + "");
        }
        return arr;
    }
}
