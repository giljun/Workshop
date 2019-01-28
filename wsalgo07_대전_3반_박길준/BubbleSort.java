package ssafy0128;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] bArray = new int[10];
		
		for (int i = 0; i < bArray.length; i++) {
			bArray[i] = (int)(Math.random()*15+1);
		}
		
		print(bArray);
		
		for (int i = bArray.length-1; i >= 0 ; i--) {
			for (int j = 0; j < i; j++) {
				if( bArray[j] > bArray[j+1] ) {
					swap(bArray, j, j+1);
				}
			}
		}
		
		print(bArray);
	}
	
	public static void swap(int[] arr, int num1, int num2) {
		int temp;
		temp = arr[num1];
		arr[num1] = arr[num2];
		arr[num2] = temp;
	}
	
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

}
