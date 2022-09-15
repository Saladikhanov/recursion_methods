package telran.recursion.controller;

import java.util.Arrays;

public class RecursionAppl {
    public static void main(String[] args) {
	Integer[] arr = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
//	System.out.println(binarySearch(arr, 16));
//	System.out.println(binarySearchRecursion(arr, 16));
//	System.out.println(factorial(5));
//	System.out.println(factroialRecursion(5));
//	System.out.println(factroialRecursionTernary(5))
//	double res = pow(2, -2);
//	System.out.println(res);
//	int sumA = sumArray(arr);
//	System.out.println(sumA);
	reverseArray(arr);
	Arrays.stream(arr).forEach(System.out::println);
    }

    public static <T> void reverseArray(T[] arr) {
	reverseArray(arr, 0, arr.length - 1);
    }

    private static <T> void reverseArray(T[] arr, int l, int r) {
	if (l >= r) {
	    return;
	}
	T t = arr[l];
	arr[l] = arr[r];
	arr[r] = t;
	reverseArray(arr, l + 1, r - 1);
    }

    public static int sumArray(int[] arr) {
	return sumArray(arr, 0);

    }

    private static int sumArray(int[] arr, int i) {
	return i == arr.length - 1 ? arr[i] : arr[i] + sumArray(arr, i + 1);
    }

    public static double pow(double x, double n) {
	return n >= 0 ? powPositive(x, n) : 1 / powPositive(x, -n);

    }

    private static double powPositive(double x, double n) {
	return n == 0 ? 1 : x * powPositive(x, n - 1);

    }

    public static int binarySearch(int[] arr, int value) {
	int l = 0;
	int r = arr.length - 1;
	while (l <= r) {
	    int mid = (l + r) / 2;
	    if (value == arr[mid]) {
		return mid;
	    }
	    if (value < arr[mid]) {
		r = mid - 1;
	    } else {
		l = mid + 1;

	    }
	}

	return -l - 1;

    }

    public static int binarySearchRecursion(int[] arr, int value) {
	return binarySearchRecursion(arr, value, 0, arr.length);

    }

    private static int binarySearchRecursion(int[] arr, int value, int l, int r) {
	if (l > r) {
	    return -l - 1;
	}
	int mid = (l + r) / 2;
	if (value == arr[mid]) {
	    return mid;
	}
	if (value < arr[mid]) {
	    return binarySearchRecursion(arr, value, l, mid - 1);
	} else {
	    return binarySearchRecursion(arr, value, mid + 1, r);

	}
    }

    public static int factorial(int n) {
	int res = 1;
	for (int i = 1; i <= n; i++) {
	    res *= i;
	}
	return res;
    }

    public static int factroialRecursion(int n) {
	if (n == 0) {
	    return 1;
	}
	return n * factroialRecursion(n - 1);
    }

    public static int factroialRecursionTernary(int n) {
	return n == 0 ? 1 : n * factroialRecursionTernary(n - 1);
    }
}
