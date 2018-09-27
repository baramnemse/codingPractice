import java.util.Arrays;

/**
 * 회전하면 같은 문자인지 확인
 * 
 * @author Wonjin Heo
 *
 */
public class Q233 {
	public static void main(String[] args) {
		System.out.println(isRotationString("abc", "bca"));
		System.out.println(isRotationString("abc", "abcd"));
	}
	
	static boolean isRotationString(String s1, String s2){
		if(s1.length()==s2.length()){
			// s1을 이어서 더하면 반드시 s2를 포함하게 된다.
			return (s1+s1).indexOf(s2)!=-1;
		}
		return false;
	}
}
