package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4013 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			int magnets[][] = new int[4][8];
			for(int i=0;i<4;i++)
			{
				String input = br.readLine();
				for(int j=0;j<8;j++)
					magnets[i][j]=input.charAt(j)-'0';
			}
			int K = Integer.parseInt(br.readLine());
			for(int i=0;i<K;i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int target = Integer.parseInt(st.nextToken())-1; // 몇번째 자석
				int dir = Integer.parseInt(st.nextToken()); // 어느방향
				magnets = solve(magnets,target,dir);
			}
			int result=0;
			
			for(int i=0;i<4;i++)
				if(magnets[i][0] == 1)
					result+=Math.pow(2, i);
			
			System.out.println(result);
						
		
	}

	private static int[][] solve(int[][] magnets, int target, int dir) {
		int copy_magnet[][] = new int[4][8];
		copy_magnet = copy(copy_magnet,magnets);
		int right = target+1;
		int left = target-1;
		if(dir == 1) // 시계방향
		{
			boolean check=false;
			while(right<4)
			{
				if(check==false)
				{
					if(copy_magnet[right-1][2] != copy_magnet[right][6])
					{
						turnLeft(magnets[right]);
						check=true;
					}
					else
						break;
				}
				else
				{
					if(copy_magnet[right-1][2] != copy_magnet[right][6])
					{
						turnRight(magnets[right]);
						check=true;
					}
					else
						break;
				}
				right++;
			}
			
			check=false;
			while(left>=0)
			{
				if(check==false)
				{
					if(copy_magnet[left+1][6] != copy_magnet[left][2])
					{
						turnLeft(magnets[left]);
						check=true;
					}
					else
						break;
				}
				
				else
				{
					if(copy_magnet[left+1][6] != copy_magnet[left][2])
					{
						turnRight(magnets[left]);
						check=false;
					}
					else
						break;
				}
				left--;
			}
			turnRight(magnets[target]);
		}
		else
		{
			boolean check=false;
			while(right<4)
			{
				if(check==false)
				{
					if(copy_magnet[right-1][2] != copy_magnet[right][6])
					{
						turnRight(magnets[right]);
						check=true;
					}
					else
						break;
				}
				else
				{
					if(copy_magnet[right-1][2] != copy_magnet[right][6])
					{
						turnLeft(magnets[right]);
						check=false;
					}
					else 
						break;
				}
				right++;
			}
			
			check=false;
			while(left>=0)
			{
				if(check==false)
				{
					if(copy_magnet[left+1][6] != copy_magnet[left][2])
					{
						turnRight(magnets[left]);
						check=true;
					}
					else
						break;
				}
				else
				{
					if(copy_magnet[left+1][6] != copy_magnet[left][2])
					{
						turnLeft(magnets[left]);
						check=false;
					}
					else 
						break;
				}
				left--;
			}	
			turnLeft(magnets[target]);
		}
		return magnets;
	}

	private static void turnRight(int[] magnets) {
		int temp = magnets[7];
		for (int j = 7; j >= 1; j--) {
			magnets[j] = magnets[j-1];
		}
		magnets[0]=temp;
	}

	private static int[][] copy(int[][] copy_magnet, int[][] magnets) {
		for(int i=0;i<4;i++)
			for(int j=0;j<8;j++)
				copy_magnet[i][j] = magnets[i][j];
		
		return copy_magnet;
		
	}

	private static void turnLeft(int[] magnets) {
		int temp = magnets[0];
		for(int i=1;i<8;i++)
			magnets[i-1]=magnets[i];
		magnets[7]=temp;
	}

}
