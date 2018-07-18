import java.util.Arrays;

/**
 * O(n^2)의 문제는 순서를 바꿔도 상관이 없다면 소트하여 O(n) 복잡도로 바꿀수 있다.
 * @author Wonjin Heo
 *
 */
public class MarkAndToys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Complete the maximumToys function below.
	static int maximumToys(int[] prices, int k) {
		Arrays.sort(prices);

		int pointer = 0;
		int sum = 0;

		while (pointer < prices.length && sum <= k) {
			sum += prices[pointer];
			pointer++;
		}
		if (sum > k)
			pointer--;
		return pointer;
	}
}
