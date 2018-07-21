import java.util.Arrays;

public class DPCoinChance {
	static int getMaxCoinChangeWay(int[] coin, int n, int k) {
		int dp[] = new int[k + 1];
		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = coin[i]; j <= k; j++) {
				dp[j] = dp[j] + dp[j - coin[i]];
			}
		}
		return dp[k];
	}

	static int getMinCoinChangeWay(int[] coin, int n, int k) {
		int dp[] = new int[k + 1];
		Arrays.fill(dp, k + 1);
		dp[0] = 0;
		for (int i = 0; i < n; i++) {
			for (int j = coin[i]; j <= k; j++) {
				dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
			}
		}
		return dp[k];
	}

	public static void main(String[] args) {
		System.out.println(getMaxCoinChangeWay(new int[] { 2, 3, 5 }, 3, 10));
		System.out.println(getMinCoinChangeWay(new int[] { 2, 3, 5 }, 3, 10));

	}

}
