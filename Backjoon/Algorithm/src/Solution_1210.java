import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210 {
	static int test_case;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (test_case = 1; test_case <= 10; test_case++) {
			br.readLine();
			int map[][] = new int[100][100];
			int target = 0;
			
			for (int i = 0; i < 100; i++) {

				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 2)
						target = j;
				}
			}
			int floor = 99;
			while (floor != 0) {
				if (target + 1 < 100 && map[floor][target + 1] == 1) {
					for (int i = target + 1; i < 100; i++) {
						if(i==99)
						{
							floor--;
							target=i;
							break;
						}
							if (map[floor][i] != 1) {
							target = i - 1;
							floor--;
							break;
						}
					}
				} else if (target - 1 > 0 && map[floor][target - 1] == 1) {
					for (int i = target - 1; i >= 0; i--) {
						if(i==0)
						{
							floor--;
							target=0;
							break;
						}
						if (map[floor][i] != 1) {
							target = i + 1;
							floor--;
							break;
						}
					}
				} else
					floor--;
			}
			System.out.println("#" + test_case + " " + target);
		}
	}
}
