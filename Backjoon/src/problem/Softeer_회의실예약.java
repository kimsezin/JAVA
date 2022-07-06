package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Softeer_회의실예약 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken()); // 회의실 개수
		int C = Integer.parseInt(st.nextToken()); // 회의 개수
		ArrayList<String> names = new ArrayList<>();// 회의실 이름 넣는 배열
		
		for(int i=0;i<N;i++)
		{
			String name = br.readLine(); //회의실 이름
			names.add(name);
		}
		Collections.sort(names); //이름순 정렬
		
		HashMap<String, Integer> map = new HashMap<>(); // 회의실/인덱스 맵
		for(int i=0;i<N;i++)
			map.put(names.get(i),i);
		
		int times[][] = new int[N][19]; // 각 인덱스마다 시간 체크할 배열
		
		for(int i=0; i<C;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			String name = st.nextToken(); //회의실 이름
			int start = Integer.parseInt(st.nextToken()); //시작시간
			int end = Integer.parseInt(st.nextToken()); //끝나는 시간
			
			int idx = map.get(name); //회의실 인덱스
			for(int j=start;j<=end;j++)
				times[idx][j]=1; //회의 진행되는 시간에 1부여
			
		}
		for(int i=0;i<N;i++)
		{
			ArrayList<String> result = new ArrayList<>();
			System.out.println("Room " + names.get(i)+":");
			boolean check = false; // 회의잡혀 있는지 
			String start = "";
			int cnt=0; //가능 타임 개수
			for(int j=9;j<=18;j++)
			{
				if(check==false && times[i][j]==0) //회의 없는 경우
				{
					if(j==9)
						start += "0"+j;
					else
						start += j-1;
					check=true;	
				}
				else if(check == true && times[i][j]==1)
				{
					check=false;
					result.add(start+"-"+j);
					cnt++;
					start="";
				}
			}
			if(check==true)
			{
				result.add(start+"-18");
				cnt++;
			}
			if(result.size()==0)
			{
				System.out.println("Not available");
				if(i!=N-1)
					System.out.println("-----");
			}	
			else
			{
				System.out.println(cnt + " available:");
				for(int j=0;j<result.size();j++)
					System.out.println(result.get(j));
				if(i!=N-1)
					System.out.println("-----");
			}
		}
		

	}

}
