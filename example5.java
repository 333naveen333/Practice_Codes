package Codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class example5 {
    
	public void printMissing(int[] arr)
	{
		int n= arr.length-1;
		int i=0;
		while(n>0)
		{
			int n1=arr[i];
			int n2=arr[i+1];
			for(int j=n1+1;j<n2;j++)
			{
				System.out.println(j);
			}
			n-=1;
			i+=1;
		}
		int n3=arr[arr.length-1]+1;
		while(n3<100)
		{
			System.out.println(n3);
			n3+=1;
		}
	}
	
	
	
	
	
	public static void main(String[] args)
	{
		example5 e=new example5();
		Integer[] arr= {1,44,4,5,8};
		Arrays.sort(arr);
		//e.printMissing(arr);
	}
}
