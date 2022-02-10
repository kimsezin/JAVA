import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1233 {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <=10; test_case++)
        {
            int N = Integer.parseInt(br.readLine());
            int tree[] = new int[N+1];
            boolean check = false;
            for(int i=1;i<N+1;i++)
            {
                String temp[] = br.readLine().split(" ");
                if(temp.length == 2)
                {
                    if(temp[1].equals("+") || temp[1].equals("-") || temp[1].equals("*") || temp[1].equals("/"))
                        check=true;
                    else
                        continue;
                }
            }
            if(check==true)
                System.out.println("#"+test_case+" 0");
            else
                System.out.println("#"+test_case+" 1");
        }
    }
}
