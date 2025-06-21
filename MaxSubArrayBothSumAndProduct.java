package codes_new;

public class MaxSubArrayBothSumAndProduct {
	
	private static int maxSum(int[] arr) {
		int res = arr[0];
		int currentSum = arr[0];
		
		for(int i =1;i<arr.length;i++) {
			currentSum = Math.max(arr[i], currentSum+arr[i]);
			
			res = Math.max(currentSum, res);
		}
		
		return res;
	}
 	
	public static void main(String[] args) {
		int[] arr = {-2, 6, -3, -10, 0, 2};
	//	System.out.println(maxsum(arr));
		System.out.println(maxSubArrayProduct(arr));
		
	}
	
	private static int maxSubArrayProduct(int[] arr) {
		
		
		int max = arr[0];
		int min = arr[0];
		int res = arr[0];
		
		for(int i=1;i<arr.length;i++) {
			
			if(arr[i]<0) {
				int temp = max;
				max = min;
				min = temp;
			}
			max = Math.max(arr[i], arr[i]*max);
			min = Math.min(arr[i], arr[i]*min);
			
			res = Math.max(res, max);
		}
		return res;
	}

}
