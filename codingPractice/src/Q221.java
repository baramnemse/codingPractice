/**
 * 문자열 뒤집기
 * @author Wonjin Heo
 *
 */
public class Q221 {
	public static void main(String[] args) {
		// 홀수 문자
		System.out.println(reverseString("abc".toCharArray()));
		// 짝수 문자
		System.out.println(reverseString("abbc".toCharArray()));
	}

	/**
	 * 연산복잡도O(n)
	 * 
	 * @param text
	 * @return
	 */
	static char[] reverseString(char[] text) {
		for (int i = 0; i < text.length / 2; i++) {
			char buffer = text[i];
			text[i] = text[text.length - i - 1];
			text[text.length - i - 1] = buffer;
		}
		return text;
	}

}
