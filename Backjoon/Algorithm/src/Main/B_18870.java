package Main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B_18870 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int min = 1000000001;
		
		int N = sc.nextInt();
		int arr[] = new int[N];
		int copy_arr[] = new int[N];
		int rank=0;
		for(int i=0;i<N;i++)
		{
			arr[i] = sc.nextInt();
			copy_arr[i] = arr[i];
		}
		Arrays.sort(arr);
	
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i=0;i<arr.length;i++)
		{
			if(!map.containsKey(arr[i]))
				map.put(arr[i], rank++);
		}
		for(int i=0;i<arr.length;i++)
			System.out.print(map.get(copy_arr[i])+" ");
			
	}

}
