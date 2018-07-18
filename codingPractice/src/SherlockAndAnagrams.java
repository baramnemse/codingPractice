import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?h_l=playlist&slugs%5B%5D=interview&slugs%5B%5D=interview-preparation-kit&slugs%5B%5D=dictionaries-hashmaps
 * @author WONJIN
 *
 */
public class SherlockAndAnagrams {

	public static void main(String[] args) {
		System.out.println(sherlockAndAnagrams("kkkk"));
		// System.out.println(getKey("abba"));
	}

	static String getKey(String str) {
		char buffer[];
		buffer = str.toCharArray();
		Arrays.sort(buffer);
		return new String(buffer);
	}

	static int sherlockAndAnagrams(String str) {
		Map<String, Integer> key2count = new HashMap<String, Integer>();
		// 이웃한 모든 조합을 구함
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				String key = getKey(str.substring(i, j));
				if (!key2count.containsKey(key)) {
					key2count.put(key, 0);
				}
				key2count.put(key, key2count.get(key) + 1);
			}
		}
		int result = 0;
		// N개의 노드에서 서로 참조하는 경우의 갯수는 n(n-1)/2
		for (int num : key2count.values()) {
			result = result + num * (num - 1) / 2;
		}
		return result;

	}
}
