package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_3238 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long result=0;
		for(int tc=1;tc<=T;tc++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			long f[] = new long[1000000000];
			long n = Long.parseLong(st.nextToken());
			long r = Long.parseLong(st.nextToken());
			long p = Long.parseLong(st.nextToken());
			
			
			
			for(int i=1;i<p;i++)
				f[i] = (f[i - 1] * i) % p;
			result = 1;
			
			while(n>=1 ||r>=1)
			{
				long a = n%p;
				long b = r%p;
				
				if(a<b)
					result=0;
				if(result==0)
					break;
				
				result *= f[(int)a];
				result %= p;
				result *= mpow((f[(int)b] * f[(int)a - (int)b]) % p, p - 2);
			}
			System.out.println("#"+tc + " "+result);
		}

	}

	private static long mpow(long l, long m) {
		long ret = 1;

	    while (m>=1) {

	        if (m >= 1) {
	        	ret *= l;
        		ret %= m;
	        }

	        l *= l;

	        l %= m;

	        m /= 2;

	    }

	    return ret;
	}

}
