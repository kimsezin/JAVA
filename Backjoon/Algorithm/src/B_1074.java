import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1074 {

	static int N;
	static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		long size = exp(2,N);
		find(size,r,c);
		System.out.println(count);
	}

	static void find(long size, long r, long c)
	{
		if(size==1)
			return;
		if(r < size/2 && c < size/2) //1사분면
			find(size/2,r,c);
		else if(r<size/2 && c>=size/2)
		{
			count+=(size/2 * size/2);
			find(size/2,r,c-size/2);
		}
		else if(r>=size/2 && c<size/2)
		{
			count+=(size/2 * size/2) * 2;
			find(size/2,r-size/2,c);
		}
		else if(r>=size/2 && c>= size/2)
		{
			count+=(size/2 * size/2) * 3;
			find(size/2,r-size/2,c-size/2);
		}
	}
	static long exp(long x,long n)
	{
		if(n==1)
		{
			return x;
		}
		
		long result = exp(x,n/2);
		return (n%2==0) ? result*result:result*result*x;
	}
}
