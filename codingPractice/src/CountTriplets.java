import java.util.ArrayList;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/count-triplets-1/editorial?h_l=playlist&slugs%5B%5D=interview&slugs%5B%5D=interview-preparation-kit&slugs%5B%5D=dictionaries-hashmaps
 * 
 * @author WONJIN
 *
 */
public class CountTriplets {

	public static void main(String[] args) {
		List<Long> input = new ArrayList();
		input.add(1L);
		input.add(2L);
		input.add(2L);
		input.add(4L);
		System.out.println(countTriplets(input, 4));
	}

	/**
	 * O(n^3) 안좋은 알고리즘
	 * 
	 * @param arr
	 * @param r
	 * @return
	 */
	static long countTriplets2(List<Long> arr, long r) {
		long count = 0;
		for (int i = 0; i < r; i++) {
			for (int j = i + 1; j < r; j++) {
				for (int k = j + 1; k < r; k++) {
					if (arr.get(i) < arr.get(j) && arr.get(j) < arr.get(k)) {
						count++;
					}
				}
			}
		}

		return count;
	}

	static long countTriplets(List<Long> arr, long r) {
		long count = 0;
		for (int i = 0; i < r; i++) {
			for (int j = i + 1; j < r; j++) {
				for (int k = j + 1; k < r; k++) {
					if (arr.get(i) < arr.get(j) && arr.get(j) < arr.get(k)) {
						count++;
					}
				}
			}
		}

		return count;
	}

}
