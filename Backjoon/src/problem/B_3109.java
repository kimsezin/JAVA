package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_3109 {
	static int R,C;
	static char map[][];
	
	static int dx[] = {-1,0,1}; //위, 옆, 아래
	static int dy[] = {1,1,1}; // 오른쪽 한칸
	
	static int result=0; // 순서 카운팅
	static boolean check; // 한번 도달했는지 확인용
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int i=0;i<R;i++)
		{
			String temp = br.readLine();
			for(int j=0;j<C;j++)
				map[i][j] = temp.charAt(j);
		}
		for(int i=0;i<R;i++)
		{
			check=false; // i행에서 출발한 파이프가 가장 오른쪽 행에 닿았을 때 true
			recur(i,0);
		}
		System.out.println(result);
	}

	static void recur(int row, int col)
	{
		if(col==C-1)
		{
			check=true; //가장 오른쪽 행에 닿은것을 체크
			result++; //횟수 카운팅
			return;
		}	
		
		
		for(int i=0;i<3;i++)
		{
			int nx = row+dx[i]; //위, 옆, 아래
			int ny = col+dy[i]; // 오른쪽 1칸
			
			if(nx >=0 && nx<R && ny < C)
			{
				if(map[nx][ny]=='.') // 도착한 칸이 .이고 이 전 행에서 들리지 않은 곳일때
				{
					map[nx][ny]='x'; // 해당 칸 x로 만들어 다음 행에서 못쓰게하기
					recur(nx,ny); // 재귀
					if(check==true) //가장 오른쪽 행에 닿았을 때는 출발한 행에서 더이상 탐색할 필요 없으므로 return
						return;
				}
			}
		}
		
	
	}
}
