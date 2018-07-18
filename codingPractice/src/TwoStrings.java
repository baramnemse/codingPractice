import java.util.HashSet;
import java.util.Set;

public class TwoStrings {

	public static void main(String[] args) {
		System.out.println(twoStrings("hello", "world"));

	}

	/**
	 * 안좋은 알고리즘 O(n^2)
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	static String twoStrings2(String s1, String s2) {
		for (int i = 0; i < s1.length(); i++) {
			if (s2.indexOf(s1.charAt(i)) != -1) {
				return "YES";
			}
		}
		return "NO";
	}

	/**
	 * 중복을 허용안하는 Set의 성질과 교집합을 구하는 retainAll로 O(n)복잡도로 해결
	 * @param s1
	 * @param s2
	 * @return
	 */
	static String twoStrings(String s1, String s2) {
		Set<Character> leftSet = new HashSet<>();
		Set<Character> rightSet = new HashSet<>();

		for (int i = 0; i < s1.length(); i++) {
			leftSet.add(s1.charAt(i));
		}
		for (int i = 0; i < s2.length(); i++) {
			rightSet.add(s2.charAt(i));
		}
		leftSet.retainAll(rightSet);
		if (leftSet.size() > 0) {
			return "YES";
		} else {
			return "NO";
		}
	}

}
