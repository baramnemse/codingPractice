import java.util.Arrays;

public class DPCoinChance {
	static int getMaxCoinChangeWay(int[] coin, int n, int k) {
		int cache[] = new int[k + 1];
		// 0 원을 바꿀수 있는 방법은 하나
		cache[0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = coin[i]; j <= k; j++) {
				cache[j] = cache[j] + cache[j - coin[i]];
			}
		}
		return cache[k];
	}

	static int getMinCoinChangeWay(int[] coin, int n, int k) {
		int cache[] = new int[k + 1];
		// 가장 작은 동전으로 바꿨을 경우 동전의 갯수 보다 1크게
		Arrays.fill(cache, k+1);
		cache[0] = 0;
		for (int i = 0; i < n; i++) {
			for (int j = coin[i]; j <= k; j++) {
				// 특정 동전까지의 최소 교환 방법은 특정 동전이 한번 교환에 사용됐다고 가정이다.
				cache[j] = Math.min(cache[j], cache[j - coin[i]] + 1);
			}
		}
		return cache[k];
	}

	public static void main(String[] args) {
		System.out.println(getMaxCoinChangeWay(new int[] { 2, 3, 5 }, 3, 10));
		System.out.println(getMinCoinChangeWay(new int[] { 2, 3, 5 }, 3, 10));

	}

}
