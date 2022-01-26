package Main;

//알고리즘 문제를 풀어주세요.
// 문제 지정 : 백준 14500 테트로미노
// https://www.acmicpc.net/problem/14500
// 다른 문제 선정해서 풀어도 okay
import java.util.Scanner;

public class B_14500 {

	static int N,M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		int map[][] = new int[N][M];
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				map[i][j]=sc.nextInt();
			}
		}
		int max =0;
		int sum =0;
		for(int x=0;x<N;x++)
		{
			
			for(int y=0;y<M;y++)
			{
				// ㅡ
				sum+=map[x][y];
				for(int i=1;i<=3;i++)
				{
					int nx = x;
					int ny = y+i;
					if(nx >=0 && ny >= 0 && nx < N && ny <M)
					{
						sum+=map[nx][ny];
					}
					else
					{
						sum=0;
						break;
					}
						
				}
				if(sum>max)
					max = sum;
				sum=map[x][y];
				
				// ㅣ
				for(int i=1;i<=3;i++)
				{
					int nx = x+i;
					int ny = y;
					if(nx >=0 && ny >= 0 && nx < N && ny <M)
					{
						sum+=map[nx][ny];
					}
					else
					{
						sum=0;
						break;
					}
						
				}
				if(sum>max)
					max = sum;
				sum=map[x][y];
				
				// ㄴ
				for(int i=0;i<3;i++)
				{
					int nx = x+1;
					int ny = y+i;
					if(nx >=0 && ny >= 0 && nx < N && ny <M)
					{
						sum+=map[nx][ny];
					}
					else
					{
						sum=0;
						break;
					}
				}
				if(sum>max)
					max = sum;
				sum=map[x][y];
				
				// ㄴ 반전
				for(int i=0;i<3;i++)
				{
					int nx = x+1;
					int ny = y-i;
					if(nx >=0 && ny >= 0 && nx < N && ny <M)
					{
						sum+=map[nx][ny];
					}
					else
					{
						sum=0;
						break;
					}
				}
				if(sum>max)
					max = sum;
				sum=map[x][y];
				
				
				// ㅢ
				for(int i=0;i<3;i++)
				{
					int nx = x-i;
					int ny = y+1;
					if(nx >=0 && ny >= 0 && nx < N && ny <M)
					{
						sum+=map[nx][ny];
					}
					else
					{
						sum=0;
						break;
					}
				}
				if(sum>max)
					max = sum;
				sum=map[x][y];
				
				
				//ㅢ 반전
				for(int i=0;i<3;i++)
				{
					int nx = x-i;
					int ny = y-1;
					if(nx >=0 && ny >= 0 && nx < N && ny <M)
					{
						sum+=map[nx][ny];
					}
					else
					{
						sum=0;
						break;
					}
				}
				if(sum>max)
					max = sum;
				sum=map[x][y];
				
				
				//┌
				for(int i=0;i<3;i++)
				{
					int nx = x+i;
					int ny = y-1;
					if(nx >=0 && ny >= 0 && nx < N && ny <M)
					{
						sum+=map[nx][ny];
					}
					else
					{
						sum=0;
						break;
					}
				}
				if(sum>max)
					max = sum;
				sum=map[x][y];
				
				
				//┌ 반전
				for(int i=0;i<3;i++)
				{
					int nx = x+i;
					int ny = y+1;
					if(nx >=0 && ny >= 0 && nx < N && ny <M)
					{
						sum+=map[nx][ny];
					}
					else
					{
						sum=0;
						break;
					}
				}
				if(sum>max)
					max = sum;
				sum=map[x][y];
				
				
				//ㄱ
				for(int i=0;i<3;i++)
				{
					int nx = x-1;
					int ny = y-i;
					if(nx >=0 && ny >= 0 && nx < N && ny <M)
					{
						sum+=map[nx][ny];
					}
					else
					{
						sum=0;
						break;
					}
				}
				if(sum>max)
					max = sum;
				sum=map[x][y];
				
				//ㄱ 반전
				for(int i=0;i<3;i++)
				{
					int nx = x-1;
					int ny = y+i;
					if(nx >=0 && ny >= 0 && nx < N && ny <M)
					{
						sum+=map[nx][ny];
					}
					else
					{
						sum=0;
						break;
					}
				}
				if(sum>max)
					max = sum;
				sum=map[x][y];
				
				// ㅁ
				if(x+1 >=0 && y+1 >= 0 && x+1 < N && y+1 <M)
					sum+=map[x+1][y+1];
				else
					sum=map[x][y];
				if(x >=0 && y+1 >= 0 && x < N && y+1 <M)
					sum+=map[x][y+1];
				else
					sum=map[x][y];
				if(x+1 >=0 && y >= 0 && x+1 < N && y <M)
					sum+=map[x+1][y];
				else
					sum=map[x][y];
				if(sum>max)
					max = sum;
				sum=map[x][y];
				
				// ㅗ
				if(x+1 >=0 && y >= 0 && x+1 < N && y <M)
					sum+=map[x+1][y];
				for(int i=1;i<2;i++)
				{
					if(x+1 >=0 && y+i >= 0 && x+1 < N && y+i <M)
						sum+=map[x+1][y+i];
					else
						sum=map[x][y];
					if(x+1 >=0 && y-i >= 0 && x+1 < N && y-i <M)
						sum+=map[x+1][y-1];
					else
						sum=map[x][y];
				}
				if(sum>max)
					max = sum;
				sum=map[x][y];
				
				
				// ㅏ
				if(x >=0 && y-1 >= 0 && x < N && y-1 <M)
					sum+=map[x][y-1];
				for(int i=1;i<2;i++)
				{
					if(x+i>=0 && y-1 >= 0 && x+i < N && y-1 <M)
						sum+=map[x+i][y-1];
					else
						sum=map[x][y];
					if(x-i >=0 && y-1 >= 0 && x-i < N && y-1 <M)
						sum+=map[x-i][y-1];
					else
						sum=map[x][y];
				}
				if(sum>max)
					max = sum;
				sum=map[x][y];
				
				// ㅜ
				if(x-1 >=0 && y >= 0 && x-1 < N && y <M)
					sum+=map[x-1][y];
				for(int i=1;i<2;i++)
				{
					if(x-1 >=0 && y+i >= 0 && x-1 < N && y+i <M)
						sum+=map[x-1][y+i];
					else
						sum=map[x][y];
					if(x-1 >=0 && y-i >= 0 && x-1 < N && y-i <M)
						sum+=map[x-1][y-1];
					else
						sum=map[x][y];
				}
				if(sum>max)
					max = sum;
				sum=map[x][y];
				
				
				// ㅓ
				if(x >=0 && y+1 >= 0 && x < N && y+1 <M)
					sum+=map[x][y+1];
				for(int i=1;i<2;i++)
				{
					if(x+i >=0 && y+1 >= 0 && x+i < N && y+1 <M)
						sum+=map[x+i][y+1];
					else
						sum=map[x][y];
					if(x-i >=0 && y+1 >= 0 && x-i < N && y+1 <M)
						sum+=map[x-i][y+1];
					else
						sum=map[x][y];
				}
				if(sum>max)
					max = sum;
				sum=map[x][y];
				
				//ㅣ
				// ㅣ
				if(x+1 >=0 && y >= 0 && x+1 < N && y <M)
					sum+=map[x+1][y];
				else
					sum=map[x][y];
				if(x+1 >=0 && y+1 >= 0 && x+1 < N && y+1 <M)
					sum+=map[x+1][y+1];
				else
					sum=map[x][y];
				if(x+2 >=0 && y+1 >= 0 && x+2 < N && y+1 <M)
					sum+=map[x+2][y+1];
				else
					sum=map[x][y];
				if(sum>max)
					max = sum;
				sum=map[x][y];
				
				// ㅣ
				//ㅣ
				if(x+1 >=0 && y >= 0 && x+1 < N && y <M)
					sum+=map[x+1][y];
				else
					sum=map[x][y];
				if(x+1 >=0 && y-1 >= 0 && x+1 < N && y-1 <M)
					sum+=map[x+1][y-1];
				else
					sum=map[x][y];
				if(x+2 >=0 && y-1 >= 0 && x+2 < N && y-1 <M)
					sum+=map[x+2][y-1];
				else
					sum=map[x][y];
				if(sum>max)
					max = sum;
				sum=map[x][y];
				
				//ㅡ
				// ㅡ
				if(x >=0 && y+1 >= 0 && x < N && y+1 <M)
					sum+=map[x][y+1];
				else
					sum=map[x][y];
				if(x+1 >=0 && y+1 >= 0 && x+1 < N && y+1 <M)
					sum+=map[x+1][y+1];
				else
					sum=map[x][y];
				if(x+1 >=0 && y+2 >= 0 && x+1 < N && y+2 <M)
					sum+=map[x+1][y+2];
				else
					sum=map[x][y];
				if(sum>max)
					max = sum;
				sum=map[x][y];
				
				// ㅡ
				//ㅡ
				if(x >=0 && y-1 >= 0 && x < N && y-1 <M)
					sum+=map[x][y-1];
				else
					sum=map[x][y];
				if(x+1 >=0 && y-1 >= 0 && x+1 < N && y-1 <M)
					sum+=map[x+1][y-1];
				else
					sum=map[x][y];
				if(x+1 >=0 && y-2 >= 0 && x+1 < N && y-2 <M)
					sum+=map[x+1][y-2];
				else
					sum=map[x][y];
				if(sum>max)
					max = sum;
				sum=0;
				
			}
		}
		System.out.println(max);
	}

}

