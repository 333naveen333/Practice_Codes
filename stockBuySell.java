package codes_new;

public class stockBuySell {
	
	public static int maxProfit(int[] arr) {
		
		int profit = Integer.MIN_VALUE;
		int minValue = arr[0];
		
		for(int currentPrice : arr) {
			if(currentPrice< minValue) {
				minValue = currentPrice;
			}
			
			int newProfit = currentPrice - minValue;
			
			if(newProfit >profit) {
				profit = newProfit;
			}
		}
		
		return profit;
		
	}
	
	
	public static void main (String[] args) {
		int[] arr = {1, 3, 6, 9, 11};
		System.out.print(maxProfit(arr));
	}

}
