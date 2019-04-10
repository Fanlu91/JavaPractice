package com.fanlu.small;

import java.util.Scanner;

public class NumberRelated {
    /**
     * given 10 output 10 5 6 3 4 2 1
     * given 6 output 6 3 4 2 1
     *
     * @param input number
     */
    public void GetTheRestOfNumbers(int input) {
        int temp = 0;
        while (input != 1) {
            if (input % 2 == 0) {
                temp = input;
                input /= 2;
                System.out.print(input + " ");
            } else {
                input = input + temp + 1;
                System.out.print(input + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please input the number: ");
        int number = s.nextInt();
        NumberRelated nr = new NumberRelated();
        nr.GetTheRestOfNumbers(number);
    }
}
