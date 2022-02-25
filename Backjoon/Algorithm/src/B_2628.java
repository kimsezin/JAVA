import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_2628 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int cnt = Integer.parseInt(br.readLine());
		ArrayList<Integer> xSplit = new ArrayList<>();
		ArrayList<Integer> ySplit = new ArrayList<>();
		
		int start_x=0, result_x=0;
		int start_y=0, result_y=0;
		for(int i=0;i<cnt;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			int type = Integer.parseInt(st.nextToken());
			int no = Integer.parseInt(st.nextToken());
			
			if(type==0)
				xSplit.add(no);
			else
				ySplit.add(no);
		}
		Collections.sort(xSplit);
		Collections.sort(ySplit);
		for(int i=0;i<xSplit.size();i++)
		{
			if(xSplit.get(i) - start_x > result_x)
				result_x = xSplit.get(i)-start_x;
			start_x = xSplit.get(i);
		}
		if(result_x < N-start_x)
			result_x = N-start_x;
		for(int i=0;i<ySplit.size();i++)
		{
			if(ySplit.get(i) - start_y > result_y)
				result_y = ySplit.get(i)-start_y;
			start_y = ySplit.get(i);
		}
		if(result_y < M-start_y)
			result_y = M-start_y;
		System.out.println(result_x * result_y);
		
	}

}
