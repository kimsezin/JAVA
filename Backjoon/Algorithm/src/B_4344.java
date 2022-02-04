
import java.util.*;
public class B_4344 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		
		for(int i=0;i<test_case;i++)
		{
			int num=sc.nextInt();
			double sum=0;
			int score[] = new int[num];
			for(int j=0;j<num;j++)
			{
				int temp=sc.nextInt();
				score[j]=temp;
				sum+=temp;
			}
			sum/=num;
			
			int cnt=0;
			for(int j=0;j<num;j++)
			{
				if(score[j] > sum)
				{
					cnt++;
				}
			}
			
			System.out.println(String.format("%.3f%%", cnt/(double)num*100));
			sc.close();
		
		}
		
		

	}

}
