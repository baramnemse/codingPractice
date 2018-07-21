import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QRemind {
	public static void main(String[] args) {
		int input[] = new int[] { 2, 3, 5 };
		System.out.println(makeChange(10, input));
		System.out.println(makeChange2(10, input));
	}

	static int makeChange(int money, int coins[]) {
		int cache[] = new int[money + 1];
		// 0원을 바꿀 방법
		cache[0] = 1;
		for (int i = 0; i < coins.length; i++) {
			for (int k = coins[i]; k <= money; k++) {
				cache[k] = cache[k] + cache[k - coins[i]];
			}
		}
		return cache[money];
	}

	static int makeChange2(int money, int coins[]) {
		int cache[] = new int[money + 1];
		Arrays.fill(cache, money + 1);
		cache[0] = 0;
		for (int i = 0; i < coins.length; i++) {
			for (int k = coins[i]; k <= money; k++) {
				cache[k] = Math.min(cache[k], cache[k - coins[i]] + 1);
			}
		}
		return cache[money];
	}
}
