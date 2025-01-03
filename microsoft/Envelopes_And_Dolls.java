import java.util.Arrays;

class Envelopes_And_Dolls {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,
                (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));

        int ans = 0;
        int[] dp = new int[envelopes.length];

        for (int[] e : envelopes) {
            int i = Arrays.binarySearch(dp, 0, ans, e[1]);
            if (i < 0)
                i = -(i + 1);
            dp[i] = e[1];
            if (i == ans)
                ++ans;
        }

        return ans;
    }
}
