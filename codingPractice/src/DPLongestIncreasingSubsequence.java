/**
 * 최장증가수열
 * 
 * @author Wonjin Heo
 *
 */
public class DPLongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] input = new int[] { 10, 20, 10, 30, 20, 50 };
		// int[] input = new int[] { 5, 4, 3, 2, 1, 6, 7, 8 };

		int[] cache = new int[input.length + 1];
		int max = 0;
		for (int i = 1; i < input.length; i++) {
			int min = 0;
			for (int j = 0; j < i; j++) {
				if (input[i] > input[j]) {
					if (min < cache[j]) {
						min = cache[j];
					}
				}
			}
			cache[i] = min + 1;
			max = Math.max(max, cache[i]);

		}
		System.out.println(max);
	}

}
