import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class JO_1681 {
  
    static int min, sum, N, map[][];
    static boolean visited[];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        for(int x = 0; x<N; x++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            for(int y = 0; y<N; y++) 
                map[x][y]=Integer.parseInt(st.nextToken());
        }
        min = Integer.MAX_VALUE;
        for(int j = 1; j<N; j++) { 
            visited = new boolean[N];
            sum = 0;
            if(map[0][j]!=0) {
                dfs(0,j,1);
            }
        }
        System.out.println(min);
    }
    public static void dfs(int x, int y, int cnt) {
        if(sum>min) {
            return;
        }
        sum = sum + map[x][y];  
        visited[x] = true; 
        if(cnt==(N-1)) {
            sum += map[y][0];   
            if(map[y][0]==0) 
                return;
            min = Math.min(min, sum);
            sum -= map[y][0];  
            return;
        }
        
        for(int i = 0; i<N; i++) {
            if(!visited[i] && map[y][i]!=0 && (sum<min) ) {  
                dfs(y,i,cnt+1);
                sum -= map[y][i]; 
                visited[i] = false; 
            }
        }
    }
}