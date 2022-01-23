package Main;
import java.util.*;
public class B_8958 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int sum=0;
		int num=sc.nextInt();
		for(int i=0;i<num;i++)
		{
			String temp = sc.next();
			int cnt=0;
			for(int j=0;j<temp.length();j++)
			{
				if(temp.charAt(j)=='O')
				{
					cnt++;
					sum+=cnt;
				}
				else
				{
					cnt=0;
				}
			}
			System.out.println(sum);
			sum=0;
		}
		sc.close();
	}

}
