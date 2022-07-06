package problem;

import java.util.Scanner;

public class B_2440 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N-i;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
