/**
 * 최장증가수열
 * http://wootool.tistory.com/96 하고 다른 방법으로 품
 * @author Wonjin Heo
 *
 */
public class DPLongestIncreasingSubsequence {

	public static void main(String[] args) {
		//int[] input = new int[] { 10, 20, 10, 30, 20, 50 };
		int[] input = new int[] { 10, 20, 1};

		int[] cache = new int[input.length];
		cache[0] = 1;
		int max = 0;
		for (int i = 1; i < input.length; i++) {
			int min = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (input[i] > input[j]) {
					if (min < cache[j]) {
						min = cache[j];
					}
				} else if (input[i] == input[j]) {
					min = cache[j] - 1;
					continue;
				}
			}
			cache[i] = min + 1;
			max = Math.max(max, cache[i]);

		}
		System.out.println(max);
	}

}
