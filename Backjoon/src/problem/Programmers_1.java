package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//80 35
//70 38
//100 41
//75 30
//160 80
//77 29
//181 68
//151 76
public class Programmers_1 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] atmos = new int[8][2];
		for(int i=0;i<8;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<2;j++)
			{
				atmos[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//atmos = new int [10][2] {{80,35},{70,38},{100,41},{75,30},{160,80},{77,29},{181,68},{151,76}};
		System.out.println(solution(atmos));
	}
	static public int solution(int[][] atmos) {
        int answer = 0;

        int day = 0 ; //day체크
        boolean check = false; //마스크 개봉
        for(int i=0;i<atmos.length;i++)
        {
            int mise = atmos[i][0]; //미세먼지
            int cho_mise = atmos[i][1]; //초미세먼지
            if(mise > 80 || cho_mise > 35)
            {
                if(mise>150 && cho_mise>75) //둘다 매우나쁨
                {
                	if(check==false)
                		answer++;
                	else
                	{
                		day=3;
                		check=false;
                	}
                	
                }
                else if(day==0) // 첫 개봉
                {
                    answer++;
                    check=true;
                }
            }
            if(check==true)
            	day++;
            if(day==3) //이틀 지나면 버리기
                {
                    check=false;
                    day=0;
                }
        }
        
        return answer;
    }
}
