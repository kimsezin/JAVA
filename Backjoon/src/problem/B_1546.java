package problem;

import java.util.*;
public class B_1546 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num=sc.nextInt();
		int max=0;
		double score[]=new double[num];
		for(int i=0;i<num;i++)
		{
			int temp=sc.nextInt();
			score[i]=temp;
			if(temp > max)
				max=temp;
		}
		double sum=0;
		for(int i=0;i<num;i++)
		{
			score[i] = score[i]/max*100;
			sum+=score[i];
		}
		System.out.println(sum/num);
		sc.close();
	}

}
