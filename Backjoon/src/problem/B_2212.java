package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_2212 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		if(N<=k)
		{
			System.out.println(0);
			return;
		}
		int input[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++)
			input[i] = Integer.parseInt(st.nextToken());
		
		int result=0;
		Arrays.sort(input);
		int diff[] = new int[N-1];
		for(int i=0;i<N-1;i++)
			diff[i] = input[i+1]-input[i];
		
		Arrays.sort(diff);
		for(int i=1;i<=k-1;i++)
			diff[N-1-i]=0;
		
		for(int i=0;i<N-1;i++)
			result+=diff[i];
		System.out.println(result);

	}

}
