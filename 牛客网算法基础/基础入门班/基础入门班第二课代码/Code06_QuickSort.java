package class02;

import java.util.Arrays;

public class Code06_QuickSort {

	//
	public static void quickSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		quickSort(arr, 0, arr.length - 1);
	}
	// arr[l..r]排好序
	public static void quickSort(int[] arr, int l, int r) {
		if (l < r) {
			// 随机选l..r中的数，与r做交换，再partition
			swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
			int[] p = partition(arr, l, r);
			quickSort(arr, l, p[0] - 1); // p[0] =区左边界， 这一行代表<区
			quickSort(arr, p[1] + 1, r); // >区
		}
	}

	// 这是一个处理arr[1..r]的函数
	// 默认以arr[r]做划分，arr[r] -> p        <p        ==p      >p
	// 返回等于区域（左边界， 右边界），，所以返回一个长度为2的数组res, res[0], res[1]
	public static int[] partition(int[] arr, int l, int r) {
		int less = l - 1; // <区右边界
		int more = r; // >区左边界，最后一个数最为划分值
		while (l < more) { // L表示当前数的位置 只要当前值不与>区碰到执行while
			if (arr[l] < arr[r]) { // 当前数<划分值(p)
				swap(arr, ++less, l++); // 3个操作：当前数与<区后一个数换位置，<区右扩，当前数往后跳
			} else if (arr[l] > arr[r]) {
				swap(arr, --more, l);
			} else {
				l++;
			}
		}
		swap(arr, more, r); // >区最左数与最后数做交换，因为以最后一个为划分值，最后一个没考虑呢
		return new int[] { less + 1, more };
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			quickSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		quickSort(arr);
		printArray(arr);

	}

}
