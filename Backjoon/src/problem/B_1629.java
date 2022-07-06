package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1629 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long result = exp((long)A,B,C);
		System.out.println(result%C);
	}

	static long exp(long A, int size, int c)
	{
		if(size==1)
			return A;
		long result = exp(A,size/2,c);
		if(size%2==0)
			return result*result%c;
		else
			return (result*result%c)*A%c;
		
	}
}
