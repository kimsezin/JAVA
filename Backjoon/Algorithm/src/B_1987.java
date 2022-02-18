import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B_1987 {
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static HashSet<Character> set;
	static boolean visited[][];
	static char map[][];
	static int answer=0,R,C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		set = new HashSet<>(); //중복 검사용 set
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i=0;i<R;i++)
			map[i] = br.readLine().toCharArray();
		
		//usingSet_dfs(0,0,1); // 보충시간에 배운 set
		dfs(0,0,"");
		System.out.println(answer);
	}
	static void dfs(int x,int y ,String input)
	{
		input+=map[x][y];
        for(int i=0;i<input.length()-1;i++)
		{
			if(input.charAt(i)==map[x][y])
			{
				return;
			}
		}
        if(answer < input.length())
			answer=input.length();
        visited[x][y]=true;
		for(int i=0;i<4;i++)
		{
			int nx = x +dx[i];
			int ny = y +dy[i];
			
			if(nx >=0 && ny >= 0  && nx < R && ny < C)
			{
				if(visited[nx][ny]==false)
				{
					visited[nx][ny]=true;
					dfs(nx,ny,input);
					visited[nx][ny]=false;
				}
			}
		}
		
	}
	static void usingSet_dfs(int r, int c, int d)
	{
		int s = set.size();
		set.add(map[r][c]);
		
		if(s == set.size()) //set은 중복이 안되므로 추가가 안되면 이미 지나온 알파벳
			return;
		
		if(answer<d)
			answer = d; //거리 추가
		
		visited[r][c]=true;
		for(int i=0;i<4;i++)
		{
			int nx = r+dx[i];
			int ny = c+dy[i];
			if(nx >= 0 && ny >=0 && nx<R && ny<C)
			{
				if(visited[nx][ny]==false)
				{
					usingSet_dfs(nx,ny,d+1);
				}
			}
		}
		
		set.remove(map[r][c]);
		visited[r][c] = false;
		
	}
}
