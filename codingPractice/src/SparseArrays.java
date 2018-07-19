import java.util.HashMap;
import java.util.Map;

/**
 * O(n^2) > O(n)
 * @author WONJIN
 *
 */
public class SparseArrays {

	/**
	 * 안좋은 방법 O(n^2) O(nm)
	 * 
	 * @param strings
	 * @param queries
	 * @return
	 */
	static int[] matchingStrings(String[] strings, String[] queries) {
		int result[] = new int[queries.length];

		int i = 0;
		for (String query : queries) {
			for (String string : strings) {
				if (string.equals(query)) {
					result[i]++;
				}
			}
			i++;
		}
		return result;
	}

	/**
	 * O(n) O(n+m)
	 * @param strings
	 * @param queries
	 * @return
	 */
	static int[] fastMatchingStrings(String[] strings, String[] queries) {
		int result[] = new int[queries.length];

		Map<String, Integer> cache = new HashMap();

		for (String string : strings) {
			Integer value = cache.get(string);
			if (value == null) {
				cache.put(string, 1);
			} else {
				cache.put(string, value + 1);
			}

		}

		int i = 0;
		for (String query : queries) {
			result[i] = cache.get(query);
			i++;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
