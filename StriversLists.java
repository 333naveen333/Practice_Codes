package JavaEight;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
public class StriversLists {
	
	public static void main(String[] args) {
		//any doubt why we followed any approach - u can check in striver explaination
		// check same question in site and check explanation or observations
		
		//Set Matrix Zero
		setMatrixZero();
		
		printPascalTriangle();
		
		//https://takeuforward.org/data-structure/
		//next_permutation-find-next-lexicographically-greater-permutation/
		
		//find next lexicographically greater permutation
		nextPermutation();
		
		//Maximum Subarray Sum in an Array where k is not given like in slifing wondoe question
		// here need to check all combinaion of subarrays
		maxSubArraySum();
		
		//same question using kadane alogortihm
		maxSubArraySumUsingKadane();
		
		//Sort an array of 0s, 1s and 2s
		//used brtueforce as its also o(n)// enahned approcah is complicated
		sort012();
		
		//Stock Buy And Sell
		stockBuySell();
		
		//optimized - o(n)
		stockOptimized();
		
		//Merge Overlapping Sub-intervals
		//mergeOverLappedIntervals();
		
		//Merge two Sorted Arrays 
		// inside 1 duplicate problem also there
         mergeTwoSortedArrays();
         
         findRepAndMissElement();
         
         //Count inversions in an array
         //inversions are: For i & j < size of an array if i < j 
         //then you have to find pair (a[i], a[j]) such that a[i] > a[j].
         //simple for loop as below
         countInversions();
         
         //Search in a sorted 2D matrix
         // for this as its sorted rows
         // we can do bin search in each row for optimized instead of 2 for loop check
         searchIn2DSortedMatrix();
         
         
         //https://takeuforward.org/data-structure/search-in-a-sorted-2d-matrix/
      //see this optimal approach if  u need but i think above one(searchIn2DSortedMatrix) is enough
         sameSearchWithFlattening();
         
         //without math.pow
         powerXToN();
         
         //Grid Unique Paths - Count Paths in matrix
         gridUniquePaths();
         
         //two sum 
         towSum();
         
         threeSum();
         
         //4sum - simlar to 3 sum - we can make 3 loops here and 1 set in last loop
         // to check contains do same check
         
         /* Longest Consecutive Sequence in an Array
        	 Input: [100, 200, 1, 3, 2, 4] Output: 4
        	 Explanation: The longest consecutive subsequence is 1, 2, 3, and 4.
        	 Input: [3, 8, 5, 7, 6] Output: 4
        	 Explanation: The longest consecutive subsequence is 5, 6, 7, and 8. */
         largestConsectutiveSubSeq();
         
         
         //Length of the longest subarray with zero Sum
         largest0Subbary();
		
	}

	private static void largest0Subbary() {
		System.out.println();
		int arr[] = {6, -2, 2, -8, 1, 7, 4, -10};
		int n= arr.length;
		int res=0;
		for(int i=0;i<n;i++) {
			int sum=0;
			for(int j=i;j<n;j++) {
				sum+=arr[j];
				if(sum==0) {
					res = Math.max(res, j-i+1);
				}
			}
			
		}
		
		System.out.println(res);
		
	}

	private static void largestConsectutiveSubSeq() {
		int[] arr = {4, 5,1,6,2};
	    int n = arr.length;
	    
	    Arrays.sort(arr);
	    int small = arr[0];
	    int max=1, cnt =0;;
	    // 1 2 4 5 6 
	    for(int i=0;i<n;i++) {
	    	
	    	if(arr[i]-1 == small) {
	    		cnt++;
	    		small=arr[i];
	    	}
	    	else {
	    		cnt=1;
	    		small=arr[i]; // we can move this outside i.e., common for both
	    	}
	    	max= Math.max(cnt, max);
	    	//cnt=0;
	    }
	    System.out.println(max);
		
	}

	private static void threeSum() {
		int[] arr = {-1, 0, 1, 2, -1, -4};
		int n= arr.length;
		
		int target = 0;
		
		
		for(int i=0;i<n;i++) {
			Set<Integer> set = new HashSet<>();
			for(int j=i+1;j<n;j++) {
				
				int needMore = target - (arr[i]+arr[j]);
				if(set.contains(needMore)) {
					System.out.println("found triplet "+ arr[i]+" "+ arr[j]+" "+needMore
							);
				}
				set.add(arr[j]);
			}
		
		}
		
	}

	private static void towSum() {
        int[] arr = {2, 6, 5, 8, 11};
        int target = 8;
        
        // 1 way - we can do for i and for j=i+1 ...and if  arr[i]+arr[j]== target found 2sum
        
        //2 way - using set
        
        Set<Integer> set = new HashSet<>();
        
        for(int i=0;i<arr.length;i++) {
        	
        	int current = arr[i];
        	int needMore = target - current;
        	if(set.contains(needMore)) {
        		System.out.println("found a pair");
        		break;
        	}
        	set.add(arr[i]);
        }
        
        
        //3 way - using 2 pointer
        // as 2 pointer works for sorted arrays
        Arrays.sort(arr);
        
        int start = 0, end = arr.length-1;
        
        while(start<end) {
        	int sum = arr[start]+arr[end];
        	
        	if(sum == target) {
        		System.out.println("found a pair");
        		break;
        	}
        	else if(sum<target) {
        		start++;
        	}
        	else {
        		end--;
        	}
        }
        
		
	}

	private static void gridUniquePaths() {
		
		/*input: m = 2, n = 2
				Output: 2
				Explanation: There are two paths
				(0, 0) -> (0, 1) -> (1, 1)
				(0, 0) -> (1, 0) -> (1, 1)

				Input: m = 2, n = 3
				Output: 3
				Explanation: There are three paths
				(0, 0) -> (0, 1) -> (0, 2) -> (1, 2)
				(0, 0) -> (0, 1) -> (1, 1) -> (1, 2)
				(0, 0) -> (1, 0) -> (1, 1) -> (1, 2)
		
		*/
		 int m = 2, n = 3;
		 
		 int count = getPathcount(m, n);
		 System.out.println("paths "+ count);
		
	}

	private static int getPathcount(int m, int n) {
		if(m==1 || n==1) {
			return 1;
		}
		
		return getPathcount(m-1, n) + getPathcount(m, n-1);
	}

	private static void powerXToN() {
		double X = 2, N=-10;
		double res=1.0;
		
		if(N<0) {
			X=1/X;
			N=-N;
		}
		
		
		while(N>0) {
			
			if(N%2==1) {
				res = res*X;
				N=N-1;
			}
			else {
				X= X*X;
				N=N/2;
			}
		}
		System.out.println(res);
		System.out.println(Math.pow(2, -10));
		
	}

	private static void sameSearchWithFlattening() {
		System.out.println();
		List<List<Integer>> matrix = new ArrayList<>();
		matrix.add(Arrays.asList(1,2,3));
		matrix.add(Arrays.asList(4,5,6));
		matrix.add(Arrays.asList(7,8,9));
		
		int target = 5;
		
		int start = 0;
		int end =( matrix.get(0).size() ) * (matrix.size()) - 1;
		
		while(start<end) {
			int mid = start+ (end-start)/2;
			
			int row = mid /  matrix.get(0).size();
			int col = mid %  matrix.get(0).size();
			
			 if (matrix.get(row).get(col) == target) { System.out.println(true);
			 break;}
	            else if (matrix.get(row).get(col) < target) start = mid + 1;
	            else end = mid - 1;
		}
		
	}

	private static void searchIn2DSortedMatrix() {
		System.out.println();
		List<List<Integer>> matrix = new ArrayList<>();
		matrix.add(Arrays.asList(1,2,3));
		matrix.add(Arrays.asList(4,5,6));
		matrix.add(Arrays.asList(7,8,9));
		
		int target = 10;
		boolean finding = false;
		
		// bruteforce - for i and for j and if check
		
		//optimized - bin search in each row as rows are sorted
		for(int i =0 ;i<matrix.size();i++) {
			
			int start = 0;
			int end = matrix.get(i).size()-1;			
			if(target ==matrix.get(i).get(start) || target == matrix.get(i).get(end) ) {
				finding = true;
			}
			if(target<matrix.get(i).get(end) && target > matrix.get(i).get(start)) {
				
				finding = binSearch(matrix.get(i), target, start, end);
				
			}
		}
		System.out.println(finding);
		
		
	}

	private static boolean binSearch(List<Integer> list, int target, int start,int end) {
		/*
		int start = 2_000_000_000;
		int end = 2_100_000_000;
		int mid = (start + end) / 2;  
		here it can be a integer overflow occurs so safe to use s + (e-s) /2
		*/
		
		// we can also check if sort is in asc or desc 
		// if its desc - opppstie to below
		//i.e,
//		else if (target > list.get(mid)) {
//			start = mid-1;
//		}
//		else {
//			end = mid+1;
//		}
		
		
		while(start<end) {  //<= when we want to corners or last and first indexes - as we checked
			// those above so not using <= instead using < direclty
			int mid = start+ (end-start)/2;
			if(list.get(mid)==target) {
				return true;
			}
			else if (target > list.get(mid)) {
				start = mid+1;
			}
			else {
				end = mid-1;
			}

		}
		return false;
		
	}

	private static void countInversions() {
		int[] a = {5, 4, 3, 2, 1};
		int c=0;
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i]>a[j]) {
					c++;
				}
			}
		}
		System.out.println(c);
		
	}

	private static void findRepAndMissElement() {
		List<Integer> list = Arrays.asList(3,1,2,5,4,6,7,5);
		
		list.sort((a,b) -> a-b);//1 2 3 3 5
		int sum=0;
		for(int i : list) {
			sum+=i;
		}
		//first find rep
		int rep = 0; //repetatedElementIndex
		for(int i=0;i<list.size()-1;i++) {
			if(list.get(i)==list.get(i+1)) {
				rep=list.get(i);
				break;
			}
			
		}
		
		int sumWithoutRep = sum - rep;
		int n= list.size();
		int neededSumForNElements = (n * (n+1) )/2;
		
		System.out.println("rep " + rep+ "missing elemt "+ (neededSumForNElements - sumWithoutRep));
		
	}

	private static void mergeTwoSortedArrays() {
		System.out.println();
		int[] arr1 = {1,4,7,8};
		int[] arr2 = {0,1,3,4};
		int[] arr3 = new int[arr1.length+arr2.length];
//		arr3 = Arrays.copyOfRange(arr1, 0, arr1.length);
//		arr3 = Arrays.copyOfRange(arr2, arr1.length, arr2.length);
		// this code wont work becaue second copy range will overwrotes and as 
		// start ppint is 1.length // output will be empty list
		
		
		//correct one is to use system.copy
		System.arraycopy(arr1, 0, arr3, 0, arr1.length);
		System.arraycopy(arr2, 0, arr3, arr1.length, arr2.length);
		Arrays.sort(arr3);
		System.out.println(Arrays.toString(arr3));
		
		// to find duplicate in list - can be big stuff - but can use for freq also
		List<Integer> list = List.of(1,2,2,3,4,5);
		list.stream().collect(Collectors.groupingBy(Function.identity(), 
				LinkedHashMap::new, Collectors.counting())).entrySet().stream().filter(x -> x.getValue()>1).forEach(x -> System.out.println(x.getKey()));
	
		
		// or simple list to map
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i : list) {
			int value = map.getOrDefault(i, 0);
			map.put(i, value+1);
		}
		
		for(Map.Entry<Integer, Integer> m: map.entrySet()) {
			//m.getKey() 
			// another way to iterate over map
		}
		map.forEach((x,y)-> System.out.println(x +" "+y));
	
	}

	private static void mergeOverLappedIntervals() {
		
		// see below code which is from  copilot for revsion
		
		int[][] intervals = null;
		        // Step 1: Check if the input is empty or has only one interval
		        if (intervals.length <= 1) {
//		            return intervals;
		        }

		        // Step 2: Sort the intervals by their start time
		        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		        // Step 3: Create a list to store merged intervals
		        List<int[]> merged = new ArrayList<>();

		        // Step 4: Initialize the first interval
		        int[] currentInterval = intervals[0];
		        merged.add(currentInterval);

		        // Step 5: Iterate through the intervals
		        for (int[] interval : intervals) {
		            int currentEnd = currentInterval[1];
		            int nextStart = interval[0];
		            int nextEnd = interval[1];

		            // Step 6: Check for overlap
		            if (nextStart <= currentEnd) {
		                // Merge intervals by updating the end
		                currentInterval[1] = Math.max(currentEnd, nextEnd);
		            } else {
		                // No overlap, add the new interval
		                currentInterval = interval;
		                merged.add(currentInterval);
		            }
		        

		        // Step 7: Convert the list to an array and return
		        //return merged.toArray(new int[merged.size()][]);
		    }

		    // Main method to test the function
		   

		
		
		System.out.println();
		List<List<Integer>> lists = new ArrayList<>();
		lists.add(new ArrayList<>(Arrays.asList(1,3)));
		lists.add(new ArrayList<>(Arrays.asList(2,6)));
		lists.add(new ArrayList<>(Arrays.asList(8,10)));
		lists.add(new ArrayList<>(Arrays.asList(15,23)));
		
		lists.sort((a,b)-> Integer.compare(a.get(0), b.get(0)));
		
		
		List<Integer> l1 = lists.get(0);
		
		for(List<Integer> list : lists) {
			
			int currentEnd = l1.get(1);
			
			int nextStart = list.get(0);
			int nextEnd = list.get(1);
			//halted....
//			if(currentEnd <= nextStart) {
//				list.set(, new ArrayList<>(Arrays.asList(l1)))
//			}
			
		}
		
		
	}

	private static void stockOptimized() {
		int[] arr = {7,1,5,3,6,4};
		int max=0;
		int min=Integer.MAX_VALUE; //or start stock
		//have used min =0; and faced a bug - so always try to use Integer.MAX_VALUE
		for(int i=0;i<arr.length;i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]-min);
		}
		System.out.println(max);
	}

	private static void stockBuySell() {
		System.out.println();
		int[] arr = {7,1,5,3,6,4};
		int max=0;
		for(int  i =0;i<arr.length;i++) {
			int current=0;
			for(int j=i;j<arr.length;j++) {
				current= arr[j]-arr[i];
				max = Math.max(max, current);
			}
		}
		System.out.println(max);
		
	}

	private static void sort012() {
		System.out.println();
		int[] arr = {0,1,2,1,2,1,2,0,1,0,0};
		int c0=0, c1=0,c2=0;
		for(int i : arr) {
			if(i==0) {
				c0++;
			}
			else if (i==1) {
				c1++;
			}
			else {
				c2++;
			}
		}
		
		for(int i=0;i<c0;i++) {
			arr[i]=0;
		}
		for(int i=0;i<c1;i++) {
			arr[i+c0]=1;
		}
		for(int i=0;i<c2;i++) {
			arr[i+c0+c1]=2;
		}
		
		for(int i :arr) {
			System.out.print(i+" ");		}
		
	}

	private static void maxSubArraySumUsingKadane() {
		System.out.println();
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		int current=arr[0], max=arr[0];
		
		for(int i=1;i<arr.length;i++) {
			current = Math.max(arr[i], arr[i]+current);
			max = Math.max(max, current);
		}
		
		System.out.println(max);
		
	}

	private static void maxSubArraySum() {
		System.out.println();
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		int max=0;
		int start = 0,end = 0;
		for(int i=0;i<arr.length;i++) {
			int current=0;
			for(int j=i;j<arr.length;j++) {
				System.out.println(i+" "+ j+" ");
				current +=arr[j];
				if(current>max) {
					max=current;
					start = i;
					end =j;
				}
			}
			
			
		}
		
		System.out.println(start+" "+ end+" "+ max);
		
	}

	private static void nextPermutation() {
		int[] arr = {2, 1, 5, 4, 3, 0, 0};
		int bp = 0;  // breakpoint
		for(int i=arr.length-1 ;i>0;i--) {
			if(arr[i]>arr[i-1]) {
				bp=i-1; // here we want 1 not 5 in above exmaple so i-1
			}
		}
		if(bp<=0) {
		System.out.println("its the last one in lexo..list of comination needs to return first one now");
		  // reverse whole array
		
		}
		int swap = arr[bp]; // this one needs to swap with next greater element in right side of list 
		// swap 1 and 3
		
		// 2 3 5 4 1 0 0 
		
		for(int i=arr.length-1 ; i> bp;i--) {
			if(arr[i]>arr[bp]) {
				int temp = arr[i];
				arr[i] = arr[bp];
				arr[bp] = temp;
				
				break;
			}
		}
		
		for(int i =0;i<bp+1;i++) {
			System.out.print(arr[i]+" ");
		}
		for(int i=arr.length-1 ; i>bp;i--) {
			System.out.print(arr[i]+" ");
		}
		
		// now reverse after bp // 2 3 0 0 1 4 5
		
		
		
		
		
	}

	private static void printPascalTriangle() {
		
		int row=5;
		
		for(int i=1;i<=row;i++) {
			for(int j=1;j<=i;j++) {
				int res = calcNcR(i-1,j-1); // as ith row and jth col res = n-1 C r-1
				System.out.print(res +" ");
			}
			System.out.println();
		}
		
	}

	private static int calcNcR(int n, int r) {
		int res =1;
		//  nCr = (n*(n-1)*(n-2)*.....*(n-r+1)) / (r*(r-1)*(r-2)*....1)
		for(int i=0;i< r;i++) {
			res = res * (n-i);
			res = res / (i+1);
		}
		return res;
		
		// or do ( n! ) / (n-r !)*(r1); 
		
	}

	private static void setMatrixZero() {
		
		List<List<Integer>> matrix = new ArrayList<>();
		
		// if we give list.of will get unsup operatio while modifiying
		matrix.add(new ArrayList<>(Arrays.asList(1,1,1)));
		matrix.add(new ArrayList<>(Arrays.asList(0,0,1)));
		matrix.add(new ArrayList<>(Arrays.asList(1,1,1)));
		
		int r = matrix.size();
		int c = matrix.get(0).size();
		
		int[] row = new int[r];
		int[] col = new int[c];
		
		for(int i=0;i<r;i++) {
			for (int j=0;j<c;j++) {
				if(matrix.get(i).get(j) == 0) {
					row[i] = 1;
					col[j] = 1;
				}
			}
		}
		
		for(int i=0;i<r;i++) {
			for (int j=0;j<c;j++) {
				if(row[i] == 1 || col[j] == 1) {
					matrix.get(i).set(j, 0);
				}
			}
		
	}
		
		
		matrix.forEach(i -> System.out.println(i.toString()));

	}}
