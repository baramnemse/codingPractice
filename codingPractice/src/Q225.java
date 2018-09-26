import java.util.Arrays;

/**
 * 문자열압축
 * 
 * @author Wonjin Heo
 *
 */
public class Q225 {
	public static void main(String[] args) {
		System.out.println(true == "abc".equals(zipString("abc")));
		System.out.println(true == "a1b6c1".equals(zipString("abbbbbbc")));
	}

	/**
	 * 연산복잡도 O(n)
	 * 공간복잡도 최대 O(2n)
	 * @param text
	 * @return
	 */
	static String zipString(String text) {
		StringBuffer result = new StringBuffer();
		char textBuffer[] = text.toCharArray();
		char prevChar = 0;
		int count = 1;
		for (char c : textBuffer) {
			if (prevChar == c) {
				count++;
			} else {
				if (prevChar != 0) {
					result.append(prevChar);
					result.append(count);
					count = 1;
				}
			}
			prevChar = c;
		}
		result.append(prevChar);
		result.append(count);

		if (text.length() < result.toString().length()) {
			return text;
		} else {
			return result.toString();
		}
	}

	static boolean checkSerial(char[] text1, char[] text2) {
		Arrays.sort(text1);
		Arrays.sort(text2);
		return new String(text1).equals(new String(text2));
	}

}
