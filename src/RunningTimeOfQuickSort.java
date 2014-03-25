import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class RunningTimeOfQuickSort {
	
	private static int qSwaps = 1;
	private static int iSwaps = 0;
	

	public static void main(String[] args) throws IOException {
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(in.readLine());
		String[] strArray = in.readLine().split(" ");
		int[] array1 = new int[length];
		int[] array2 = new int[length];
		for (int i = 0; i < strArray.length; i++) {
			array1[i] = Integer.parseInt(strArray[i]);
			array2[i] = Integer.parseInt(strArray[i]);
		}
		
		quickSort(array1);
		insertionSort(array2);
		System.out.println(qSwaps);
		System.out.println(iSwaps);
		System.out.println(iSwaps - qSwaps);
		for (int i = 0; i < array1.length; i++) {
			System.out.print(array1[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < array2.length; i++) {
			System.out.print(array2[i] + " ");
		}
		System.out.println();

	}
	
	private static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	private static void quickSort(int[] array, int left, int right) {
		int index = partition(array, left, right);
		if (left < index - 1) {
			quickSort(array, left, index - 1);
		}
		if (index < right) {
			quickSort(array, index, right);
		}
	}

	private static int partition(int[] array, int left, int right) {
		int pivot = array[left + ((right - left) / 2)];
		while (left <= right) {
			while (array[left] < pivot) {
				left++;
			}
			while (array[right] > pivot) {
				right--;
			}
			if (left <= right) {
				swap(array, left, right);
				left++;
				right--;
				//qSwaps++;
				//System.out.println(swaps);
			}
		}
		return left;
	}
	
	private static void swap(int[] array, int index1, int index2) {
		int tmp = array[index2];
		array[index2] = array[index1];
		array[index1] = tmp;
		qSwaps++;
	}
	
	private static void insertionSort(int[] num) {
	     int j;
	     int key;
	     int i;  

	     for (j = 1; j < num.length; j++) {
	           key = num[ j ];
	           for(i = j - 1; (i >= 0) && (num[ i ] >= key); i--) {
	                 num[ i+1 ] = num[ i ];
	          }
	           iSwaps++;
	         num[ i+1 ] = key;
	     }
	}


}
