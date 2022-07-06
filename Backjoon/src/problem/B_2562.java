package problem;

import java.util.Scanner;
public class B_2562 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int max_idx=0;
		for(int i=0;i<9;i++)
		{
			int temp=sc.nextInt();
			if(temp > max)
			{
				max_idx=i;
				max=temp;
			}
		}
		System.out.println(max);
		System.out.println(max_idx+1);
		sc.close();
	}

}
