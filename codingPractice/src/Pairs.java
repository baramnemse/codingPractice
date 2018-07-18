import java.util.Arrays;

/**
 * 더블포인터로 품
 * @author WONJIN
 *
 */
public class Pairs {

	public static void main(String[] args) {
		System.out.println(pairs2(2, new int[] { 1, 5, 3, 4, 2 }));

	}

	/**
	 * O(n^2) 안좋음
	 * 
	 * @param k
	 * @param arr
	 * @return
	 */
	static int pairs(int k, int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] - arr[j] == k) {
					System.out.println(arr[i] + " " + arr[j]);
					count++;
				}
			}
		}
		return count;
	}

	/**
	 * O(n) 좋음
	 * 
	 * @param k
	 * @param nums
	 * @return
	 */
	static int pairs2(int k, int[] arr) {
		Arrays.sort(arr);
		int leftPointer = 0;
		int rightPointer = 1;
		int count = 0;
		while (rightPointer < arr.length) {
			if (arr[rightPointer] - arr[leftPointer] < k) {
				rightPointer++;
			} else if (arr[rightPointer] - arr[leftPointer] > k) {
				leftPointer++;
			} else {
				count++;
				rightPointer++;
				leftPointer++;
			}
		}
		return count;
	}
}
