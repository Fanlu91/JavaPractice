package com.fanlu.geektime;

public class BinarySearchPractice {
    // 二分查找的递归实现
    public int bsearch(int[] a, int n, int val) {
        return bsearchInternally(a, 0, n - 1, val);
    }


    private int bsearchInternally(int[] a, int low, int high, int value) {

        int mid = low + (high - low) / 2;
        if (a[mid] == value)
            return mid;

        if (high <= low)
            return -1;

        if (a[mid] > value) {
            return bsearchInternally(a, low, mid - 1, value);
        } else {
            return bsearchInternally(a, mid + 1, high, value);
        }
    }

    public int bsearchFirstOccurance(int[] a, int n, int val) {
        int occur = bsearchInternally(a, 0, n - 1, val);
        int first = occur;
        for (int i = occur; i >= 0; i--) {
//            System.out.println(a[i]);
            if (a[i] != a[occur])
                break;
            first = i;
        }
        return first;
    }

    public int bsearchFirstOccurance2(int[] a, int n, int val) {
        int low = 0;
        int high = n - 1;

        while (high >= low) {
            int mid = low + ((high - low) >> 1);
            // >= move high even already get the val
            if (a[mid] > val) {
                high = mid - 1;
            } else if ((a[mid] < val)) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (a[mid - 1] != val))
                    return mid;
                else
                    high = mid - 1;
            }

        }
        if (low < n && a[low] == val) {
            return low;
        }
        return -1;
    }

    public int bsearchFirstBiggerOrEqual(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if ((mid == 0) || (a[mid - 1] < value)) return mid;
                else high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int bsearchLastSmallerOrEqual(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] > value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }



    private double getSquareoot(double number) {
        if (number < 0) {
            return Double.NaN;
        }
        double low, high;


        if (number > 1) {
            low = 1;
            high = number;
        } else {
            low = number;
            high = 1;
        }

        int index = 50;
        double tmp = low + (high - low) / 2;
        while (index != 0) {
            if (tmp * tmp == number) {
                return tmp;
            }
            //reached the limitation
            if (low == high) {
                return tmp;
            }

            System.out.println(high + " " + low + " " + tmp + " " + (high - low));

            if (tmp * tmp > number) {
                high = tmp;
            } else {
                low = tmp;
            }
            tmp = low + (high - low) / 2;
            index--;
        }
        return tmp;
    }

//    private double getSquareootWithDigit(double number, int digit) {
//        if (number < 0) {
//            return Double.NaN;
//        }
//        double low, high;
//
//        int intBitCount = 1;
//        double foo = number;
//        // get bit count of int digits
//        while (true) {
//            foo /= 10;
//            if (foo < 1)
//                break;
//            intBitCount++;
//        }
//        System.out.println(intBitCount);
//
//        intBitCount = intBitCount / 2 + 1;
//
//        double squareRoot = 0;
//        for (int i = intBitCount; i > 0; i--) {
//
//            double base = Math.pow(10,i);
//            // incomplete
//
//        }
//        return squareRoot;
//    }


    public static void main(String[] args) {
        BinarySearchPractice binarySearchPractice = new BinarySearchPractice();
        binarySearchPractice.getSquareoot(16384);
//        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] b = {1, 2, 2, 2, 2, 3, 3, 3, 5, 6};

//        System.out.println(binarySearchPractice.bsearch(a, 10, 3));
//        System.out.println(binarySearchPractice.bsearch(a, 10, -9));
//        System.out.println(binarySearchPractice.bsearch(a, 10, 4));
//        System.out.println(binarySearchPractice.bsearch(a, 10, 0));
//        System.out.println(binarySearchPractice.bsearch(a, 10, 11));
//
//        System.out.println("result: " + binarySearchPractice.bsearch(b, 10, 2));
//        System.out.println("result: " + binarySearchPractice.bsearchFirstOccurance(b, 10, 2));
//        System.out.println("result: " + binarySearchPractice.bsearchFirstOccurance2(b, 10, 2));
//
//        System.out.println("result: " + binarySearchPractice.bsearch(b, 10, 3));
//        System.out.println("result: " + binarySearchPractice.bsearchFirstOccurance(b, 10, 3));
//        System.out.println("result: " + binarySearchPractice.bsearchFirstOccurance2(b, 10, 3));


    }
}
