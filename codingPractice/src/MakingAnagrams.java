
/**
 * O(n)
 * @author WONJIN
 *
 */
public class MakingAnagrams {

	static int[] makeHistogram(String s) {
		int hist[] = new int[26];
		for (int i = 0; i < s.length(); i++) {
			hist[s.charAt(i) - 'a']++;
		}
		return hist;
	}

	static int makaAnagram(String a, String b) {
		int hist1[] = makeHistogram(a);
		int hist2[] = makeHistogram(b);
		int count = 0;
		for (int i = 0; i < 26; i++) {
			count += Math.abs(hist1[i] - hist2[i]);
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(makaAnagram("cde", "abc"));
	}

}
