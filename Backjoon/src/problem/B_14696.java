package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14696 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int aCnt = Integer.parseInt(st.nextToken());
			int A[] = new int[5];
			
			for(int j=0;j<aCnt;j++)
				A[Integer.parseInt(st.nextToken())]++;
			
			st = new StringTokenizer(br.readLine()," ");
			int bCnt = Integer.parseInt(st.nextToken());
			int B[] = new int[5];
			
			for(int j=0;j<bCnt;j++)
				B[Integer.parseInt(st.nextToken())]++;
			
			
			if(A[4]>B[4])
				System.out.println("A");
			else if(A[4]<B[4])
				System.out.println("B");
			else
			{
				if(A[3]>B[3])
					System.out.println("A");
				else if(A[3]<B[3])
					System.out.println("B");
				else
				{
					if(A[2]>B[2])
						System.out.println("A");
					else if(A[2]<B[2])
						System.out.println("B");
					else
					{
						if(A[1]>B[1])
							System.out.println("A");
						else if(A[1]<B[1])
							System.out.println("B");
						else
							System.out.println("D");
					}
				}
			}
		}
		
		

	}

}
