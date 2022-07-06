package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_12018 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int classes[][] = new int[101][101]; //최대 과목수, 수강인원 100개씩
		int canRegist[] = new int[101]; // 내가 들을 수 있는 수업 개수
		Arrays.fill(canRegist, 101); // 최대 마일리지로 채우고
		
		for(int i=0;i<100;i++)
			Arrays.fill(classes[i], 101);

		for(int i=0;i<N;i++)
		{
			boolean check = false;
			st = new StringTokenizer(br.readLine()," ");
			int student = Integer.parseInt(st.nextToken());
			int max = Integer.parseInt(st.nextToken());
			classes[i] = new int[student];
			if(student < max)
				check=true;
			
			
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<student;j++)
				classes[i][j]= Integer.parseInt(st.nextToken());
			
			Arrays.sort(classes[i]);
			
			if(check==true)
				canRegist[i]=1;
			else
				canRegist[i] = classes[i][student-max];
		}
		
		Arrays.sort(canRegist);
		
		int cnt=0;
		for(int i=0;i<N;i++)
			if(M - canRegist[i]>=0)
			{
				cnt++;
				M-=canRegist[i];
			}
		
		System.out.println(cnt);
	}

}
