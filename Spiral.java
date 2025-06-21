package Codes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Spiral {
//                                  1 2 3 0
//                                  4 5 6 0
//                                  7 8 9 0
	
	 public static void main(String args[]) {

			int arr[][]= {{1,2,3,0},{4,5,6,0},{7,8,9,0}};
			int sr=0,sc=0,er=2,ec=3;
			while(sc<= ec && sr <=er)
			{
				
				for(int i=sc;i<=ec;i++)
				{
					System.out.println(arr[sr][i]);
				}
				for(int i=sr+1;i<=er;i++)
				{
					System.out.println(arr[i][ec]);
				}
				for(int i=ec-1;i>=sc;i--)
				{
					if(sr==er)
						break;
					else
					System.out.println(arr[er][i]);
				}
				for(int i=er-1;i>=sr+1;i--)
				{
					if(sc==ec)
						break;
					else
					System.out.println(arr[i][sc]);
				}
				sr++;
				er--;
				sc++;
				ec--;
		 }
			}
			
	 
	
}

