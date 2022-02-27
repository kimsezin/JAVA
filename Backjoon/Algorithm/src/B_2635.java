import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B_2635 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int start = Integer.parseInt(br.readLine());
		int result=0;
		ArrayList<Integer> resultList = new ArrayList<>();
		for(int i=1;i<=start;i++)
		{
			ArrayList<Integer> dp = new ArrayList<>();
			dp.add(start);
			dp.add(i);
			int idx=1;
			while(true)
			{
				if(dp.get(idx-1)-dp.get(idx) >=0)
				{
					dp.add(dp.get(idx-1)-dp.get(idx));
					idx++;
					if(result < dp.size())
					{
						result = dp.size();
						resultList = dp;
					}
				}
				else
					break;
			}
		}
		System.out.println(resultList.size());
		for(int i=0;i<resultList.size();i++)
			System.out.print(resultList.get(i)+" ");
		

	}

}
