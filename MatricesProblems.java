package JavaEight;

import java.util.Arrays;

public class MatricesProblems {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4 }, // 13 9 5 1
				{ 5, 6, 7, 8 }, // 14 10 6 2
				{ 9, 10, 11, 12 }, // 15 11 7 3
				{ 13, 14, 15, 16 } // 16 12 8 4
		};
//		transpose(arr);
////				
//		matrixMultiply();
//		
//		rotateBy90(arr);
//		
//		rotateCounter90(arr);

		// symmectric ==> find transpose and check if its equal with original one
		// i.e., deeptostring of org == transpeose ->symmetric

		spiralTraverse(arr);
		// google this 
	}

	private static void spiralTraverse(int[][] arr) {

		int left = 0, top = 0, bottom = arr.length - 1, right = arr[0].length - 1;

		while (left <= right && top <= bottom) {

			for (int i = left; i <= right; i++) {// left right
				System.out.print(arr[top][i] + " "); // top
			}
			top++;

			for (int i = top; i <= bottom; i++) { // t b
				System.out.print(arr[i][right] + " ");//r
			}
			right--;

			if (top <= bottom) {
				for (int i = right; i >= left; i--) {//r l
					System.out.print(arr[bottom][i] + " ");//b
				}
				bottom--;
			}

			if (left <= right) {
				for (int i = bottom; i >= top; i--) {//b t
					System.out.print(arr[i][left] + " ");//l
				}
				left++;
			}
			

		}
	}

	private static void rotateCounter90(int[][] arr) {

//		4 8 12 16
//		3 7 11 15
//		2 6 10 14
//		1 5 9 13

		rotateRows(arr);

		arr = transpose(arr);
		System.out.println(Arrays.deepToString(arr));

	}

	private static void rotateBy90(int[][] arr) {

		// first transpose and then rotate each row

		arr = transpose(arr);

		rotateRows(arr);

		System.out.println(Arrays.deepToString(arr));

	}

	private static void rotateRows(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			int start = 0, end = arr[i].length - 1;
			while (start < end) {
				int temp = arr[i][start];
				arr[i][start] = arr[i][end];
				arr[i][end] = temp;
				start++;
				end--;
			}
		}

	}

	private static void matrixMultiply() {
		int[][] arrA = { { 1, 2, 3, 4 }, { 4, 5, 6, 7 }, { 5, 6, 7, 8 } };
		int[][] arrB = { { 2, 4, 3 }, { 2, 4, 2 }, { 1, 2, 4 }, { 1, 2, 3 } };

		int rowA = 3, colA = 4, rowB = 4, colB = 3;
		int[][] res = new int[rowA][colB];
		if (colA != rowB) {
			System.out.println("cant multiply");
		} else {
			for (int i = 0; i < rowA; i++) {
				for (int j = 0; j < colB; j++) {
					for (int k = 0; k < colA; k++) { // or k<rowB as both =
						res[i][j] += arrA[i][k] * arrB[k][j];
					}
				}
			}
			System.out.println(Arrays.deepToString(res));
		}

	}

	private static int[][] transpose(int[][] arr2) {
		// reverse a 2*2 array

		// here remember when we create input array
		// List<List<Integer>> list = Arrays.asList( Array.asList(1,2),Array.asList(1,2
		// );
		// use this instead od List.of (List.of(1,2), List.of(1,2))) - as we will be
		// usign
		// collections.reverse - to not get any muatble exceptioms

		// int[][] arr2 = {{1,2,3}, {2,3,4},{4,5,6}};
		// 1 2 3
		// 2 3 4
		// 4 5 6
		int[][] transpose = new int[4][4];
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				transpose[i][j] = arr2[j][i];
			}

		}
		return transpose;
		// 1 2 4
		// 2 3 5
		// 3 4 6
		// System.out.println(Arrays.deepToString(transpose));
	}
}
