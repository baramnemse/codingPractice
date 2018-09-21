import java.util.Arrays;

/**
 * 두 문자가 순열 관계인지 확인, 순열관계란 순서만 다른 관계를 뜻함 예) abc, bac, cab 모두 순열 관계임
 * 
 * @author Wonjin Heo
 *
 */
public class Q222 {
	public static void main(String[] args) {
		// 결과가 참
		System.out.println(true == checkSerial("abc".toCharArray(),
				"bac".toCharArray()));
		// 결과가 거짓
		System.out.println(false == checkSerial("abbc".toCharArray(),
				"abc".toCharArray()));
	}

	static boolean checkSerial(char[] text1, char[] text2) {
		Arrays.sort(text1);
		Arrays.sort(text2);
		return new String(text1).equals(new String(text2));
	}

}
