package codes_new;

import java.util.Arrays;

public class productOfAllExceptItself {

	private static int[] result(int[] arr) {
		int res=1;
		int zeroCount = 0;
		int indexAtZero = -1;
		int[] ans= new int[arr.length]; 
		for(int i=0;i<arr.length;i++) {
			
			if(arr[i]==0) {
				zeroCount++;
				indexAtZero = i;
			}else {
			res*=arr[i];
			}
		}
		
		if(zeroCount>1) {
			return new int[] {0};
		}
		else if (zeroCount==1) {
			ans[indexAtZero] = res;
		}
		else {
		for(int i=0;i<arr.length;i++) {
			if(indexAtZero!=i) {
			ans[i] = res/arr[i];
			}
		}
		}
		return ans;
	}
	
	
	public static void main(String[] args) {
		int[] arr = {10, 3, 5, 6, 2};
		Arrays.stream(result(arr)).forEach(i->System.out.print(i + " "));
	}
}
