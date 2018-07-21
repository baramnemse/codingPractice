import java.util.Arrays;

/**
 * 최장증가수열
 * 
 * @author Wonjin Heo
 *
 */
public class DPLongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] input = new int[] { 2, 7, 4, 3, 8 };
		// int[] input = new int[] { 5, 4, 3, 2, 1, 6, 7, 8 };

		System.out.println(getLIS(input));
	}

	static int getLIS(int[] input) {
		int size = input.length;
		int[] cache = new int[size];
		// 처음값을 넣고 시작한다.
		cache[0] = input[0];
		int max = 1;
		int temp = 0;

		for (int i = 1; i < size; i++) {
			if (cache[max - 1] < input[i])
				cache[max++] = input[i];
			else if (cache[0] > input[i])
				cache[0] = input[i];
			else {
				// key보다 큰 첫번째 위치
				temp = Arrays.binarySearch(cache, 0, max, input[i]);
				if (temp < 0) {
					temp = -temp - 1;
				}
				cache[temp] = input[i];
			}
		}
		return max;
	}

}
