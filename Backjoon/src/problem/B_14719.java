package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14719 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int block[] = new int[H];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<H;i++)
			block[i]=Integer.parseInt(st.nextToken());
		
		int result=0;
		for(int i=1;i<H-1;i++)
		{
			int height = block[i];
			int left=0;
			int right=0;
			for(int j = 0; j<i;j++)
				if(block[j] > height)
					if(left < block[j])
						left = block[j];
			
			for(int j=i+1;j<H;j++)
				if(block[j]>height)
					if(right<block[j])
						right = block[j];
			
			if(right != 0 && left !=0)
				result+=Math.min(right, left)-height;
		}
				
		System.out.println(result);

	}

}
