package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 현대자동차_3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		if(N==2)
			System.out.println((int)(Math.pow(9, N) - (Math.pow(8, N-1) * (N - 1))));
		else
			System.out.println((int)(Math.pow(9, N) - (Math.pow(8, N-1) * (N))));

	}

}
