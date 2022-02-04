

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1208 {

	static int arr[] = new int[100];
	
	static int findMaxidx()
	{
		int max = 0;
		int max_idx=0;
		for(int i=0;i<100;i++)
		{
			if(max < arr[i])
			{
				max = arr[i];
				max_idx = i;
			}
		}
		return max_idx;
	}
	static int findMinidx()
	{
		int min = 101;
		int min_idx=0;
		for(int i=0;i<100;i++)
		{
			if(min > arr[i])
			{
				min = arr[i];
				min_idx = i;
			}
		}
		return min_idx;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test_case = 1;test_case <=10;test_case++)
		{
			int cnt= Integer.parseInt(br.readLine());
			String input[] = new String[100];
			input = br.readLine().split(" ");
			for(int i=0;i<100;i++)
			{
				arr[i] = Integer.parseInt(input[i]);
			}
			int max_idx=0;
			int min_idx=0;
			for(int i=0;i<cnt;i++)
			{
				max_idx = findMaxidx();
				min_idx = findMinidx();
				arr[max_idx]--;
				arr[min_idx]++;
			}
			max_idx = findMaxidx();
			min_idx = findMinidx();
			System.out.println("#"+test_case + " "+ (arr[max_idx]-arr[min_idx]));
		}

	}

}
