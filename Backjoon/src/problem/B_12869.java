package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_12869 {
	static int N, numbers[], dp[], dp2[][], dp3[][][];
	static boolean visited[];
	static int input[][][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		visited = new boolean[N];
		int scv[] = new int[N];		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++)
			scv[i]=Integer.parseInt(st.nextToken());
		
		if(N==3)
		{
			dp3 = new int[61][61][61];
			dp3[scv[0]][scv[1]][scv[2]] = 0;
			
			
		}
		
		
	}
}
