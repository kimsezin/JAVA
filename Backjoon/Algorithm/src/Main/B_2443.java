package Main;

import java.util.Scanner;

public class B_2443 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		for(int i=0;i<N;i++)
		{
            for(int j=0;j<i;j++)
			{
				System.out.print(" ");
			}
			for(int j=0;j<(N*2)-(i*2+1);j++)
			{
				System.out.print("*");
			}
			
			System.out.println();
		}
	}

}
