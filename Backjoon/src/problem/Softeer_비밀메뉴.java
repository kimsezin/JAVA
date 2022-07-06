package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Softeer_비밀메뉴 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int M = Integer.parseInt(st.nextToken()); //암호길이
		int N = Integer.parseInt(st.nextToken()); //입력되는 번호길이
		int K = Integer.parseInt(st.nextToken()); //버튼 개수
		
		String password = br.readLine().replace(" ", "");
	
		String target = br.readLine().replace(" ", "");

		if(target.contains(password)) //password 포함하고 있으면
			System.out.println("secret");
		else
			System.out.println("normal");
		
	}

}
