package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_19236 {

	static class fish
	{
		int no, dir;

		public fish(int no, int dir) {
			super();
			this.no = no;
			this.dir = dir;
		}
	}
	
	int dx[] = {-1,-1,0,1,1,1,0,-1}, dy[] = {0,-1,-1,-1,0,1,1,1};
	
	static fish map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new fish[4][4];
		
		for(int i=0;i<4;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<4;j++)
			{
				int no = Integer.parseInt(st.nextToken()); //물고기번호
				int dir = Integer.parseInt(st.nextToken())-1 ; //방향
				
				map[i][j] = new fish(no,dir);
			}
		}
		
		solution();
	}
	
	private static void solution() {
		
		
	}

}
