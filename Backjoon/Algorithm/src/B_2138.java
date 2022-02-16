import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_2138 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean bulb[] = new boolean[N];
		boolean target_bulb[] = new boolean[N];
		String temp = br.readLine();
		for(int i=0;i<N;i++)
			if(temp.charAt(i) == '1')
				bulb[i]=true;
			
		String target = br.readLine();
		for(int i=0;i<N;i++)
			if(target.charAt(i)=='1')
				target_bulb[i]=true;
		
		boolean bulb_first[] = new boolean[N];
		
		for(int i=0;i<N;i++)
			bulb_first[i] = bulb[i];
		int cnt_first=1;
		int cnt=0;
		bulb_first[0]=!bulb[0];
		bulb_first[1]=!bulb[1];
		
		for(int i=1;i<N;i++)
		{
			if(bulb_first[i-1] != target_bulb[i-1])
			{
				cnt_first++;
				bulb_first[i-1]=!bulb_first[i-1];
				bulb_first[i]=!bulb_first[i];
				if(i!=N-1)
					bulb_first[i+1]=!bulb_first[i+1];
			}
			if(bulb[i-1]!=target_bulb[i-1])
			{
				cnt++;
				bulb[i-1]=!bulb[i-1];
				bulb[i]=!bulb[i];
				if(i!=N-1)
					bulb[i+1]=!bulb[i+1];
			}
		}
		if(Arrays.toString(bulb).equals(Arrays.toString(target_bulb)))
		{
			System.out.println(cnt);
			return;
		}
		else if(Arrays.toString(bulb_first).equals(Arrays.toString(target_bulb)))
		{
			System.out.println(cnt_first);
			return;
		}
		System.out.println(-1);
	}

}
