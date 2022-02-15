import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class JO_1828 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Chemical input[] = new Chemical[N];
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			input[i] = new Chemical(start, end);
		}
		
		Arrays.sort(input);
		int cnt=1;
		int max = input[0].end;
		for(int i=1;i<N;i++)
		{
			if(input[i].start <= max)
				continue;
			else
			{
				cnt++;
				max = input[i].end;
			}
		}
		System.out.println(cnt);
	}
	
	public static class Chemical implements Comparable<Chemical>
	{
		int start;
		int end;
		
		public Chemical() {}
		
		public Chemical(int start, int end)
		{
			this.start= start;
			this.end = end;
		}
		@Override
		public int compareTo(Chemical o) {
			if(this.end-o.end != 0 )
				return this.end - o.end;
			else
				return this.start - o.start;
		}
	}

}
