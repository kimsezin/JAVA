import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2491 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//------------------------- input -----------------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int arr[] = new int[N];
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		//------------------------- input -----------------------
		
		//------------------------- solve -----------------------
		int max=1; // 최대 길이 저장할 변수 (하나의 수도 하나의 순열이기 때문에 1로 초기화)
		int cnt=1; 
		for(int i=0;i<N-1;i++)
		{
			if(arr[i]<= arr[i+1]) //다음 값이 증가하거나 같은값이 나오는 경우
				cnt++;
			else // 증가하거나 같은 값이 아닐경우 순열 길이 초기화 시키고 다시찾기
				cnt=1;
			max = Math.max(max, cnt); //지금까지의 max값과 비교
		}
		cnt=1;
		for(int i=0;i<N-1;i++)
		{
			if(arr[i]>= arr[i+1]) //다음 값이 감소하거나 같은값이 나오는 경우
				cnt++;
			else // 감소하거나 같은 값이 아닐경우 순열 길이 초기화 시키고 다시찾기
				cnt=1; 
			max = Math.max(max, cnt); //지금까지의 max값과 비교
		}
		System.out.println(max);
	}

}
