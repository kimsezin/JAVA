import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2116 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int map[][] = new int[n][6];
		for(int i=0;i<n;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<6;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int result=0;
		for(int i=0;i<6;i++)
		{
			int temp=0;
			int upIdx = findUp(i);
			for(int j=0;j<n;j++)
			{
				int max = 0;
				int maxIdx = 0;
				for(int k=0;k<6;k++)
				{
					if(k==upIdx || k==findUp(upIdx))
						continue;
					if(max<map[j][k])
					{
						max = map[j][k];
						maxIdx = k;
					}
				}
				temp+=max;
				upIdx = findUp(maxIdx);
			}
			if(result < temp)
				result = temp;
		}
		System.out.println(result);
	}
	static int findUp(int n)
	{
		int upIdx = 0;
		switch(n)
		{
		case 0: upIdx = 5;
			break;
		case 1: upIdx = 3;
			break;
		case 2: upIdx = 4;
			break;
		case 3: upIdx = 1;
			break;
		case 4 : upIdx = 2;
			break;
		case 5 : upIdx = 0;
		}
		return upIdx;
	}
}
