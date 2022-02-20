import java.util.Arrays;

public class KDT_1 {

	public static void main(String[] args) {
		int answer=solution(new int[] {1,52,125,10,25,201,244,192,128,23,203,98,154,255});
		System.out.println(answer);
		answer=solution(new int[] {0,0,255,255,0,0,255,255,255});
		System.out.println(answer);
		answer=solution(new int[] {100,50,100,200});
		System.out.println(answer);
		answer=solution(new int[] {1,1,1,1});
		System.out.println(answer);
		answer=solution(new int[] {0,1,2,3,4,5,5,5,5,7,8,9});
		System.out.println(answer);
		
	}

	public static int solution(int arr[])
	{
		Arrays.sort(arr);
		int size = arr.length; // 입력받은 배열 길이 뽑아서
		int last_idx = size-1;
		int middle_idx = last_idx/2;
		if(size==1) //사이즈가 한개인 경우
			return 0;
		if(size==2)
			if(arr[0]==arr[1])
				return 0;
			else
				return arr[0]+1;
		if(arr[0]==arr[last_idx]) // 처음값과 마지막이 같은경우
			return 0;
		else // size가 3개 이상일때 중간값이 여러개 있을경우
		{
			int after_cnt=0; // 중간값 이후로 같은값 찾기
			int before_cnt=0; // 중간값 이전으로 같은값 찾기
			for(int i=middle_idx+1; i<size;i++)
				if(arr[middle_idx]==arr[i])
					after_cnt++; // 중간값 이후 개수 체크
				else 
					break;
			for(int i=middle_idx-1; i>=0;i--)
				if(arr[middle_idx]==arr[i])
					before_cnt++; //중간값 이전 개수 체크
				else 
					break;
			if(after_cnt == 0 && before_cnt==0) // 중간값이 하나뿐일 때
				return arr[middle_idx]+1;
			else if(after_cnt > before_cnt) // 중간값 이후로 같은 값이 더 많을 시 
				return arr[middle_idx-before_cnt-1]+1;
			else // 중간값 이전으로 같은값이 더 많을시 
				return arr[middle_idx+after_cnt+1]+1;
		}
	}
}
