package problem;

import java.io.*;

public class Solution_5607 {
    private static int MOD = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tcase; t++) {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int r = Integer.parseInt(line[1]);
            long fac[] = new long[n + 1];
            fac[0] = 1;
            for (int i = 1; i <= n; i++) fac[i] = (fac[i - 1] * i) % MOD;

            long temp = (fac[r] * fac[n - r]) % MOD;
            long temp2 = solve(temp, MOD - 2);

            System.out.println("#"+t+" "+ ((fac[n] * temp2) % MOD));
        }
    }

    private static long solve(long n, int x) {
        if (x == 0) return 1;
        long temp = solve(n, x / 2);
        long ret = (temp * temp) % MOD;
        if (x % 2 == 0) return ret;
        else return (ret * n) % MOD;
    }
}