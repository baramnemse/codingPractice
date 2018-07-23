import java.util.Stack;

public class BalancedBrackets {

	static String check(String str) {

		Stack<Character> stack = new Stack();

		char left = 0;

		for (int i = 0; i < str.length(); i++) {

			left = str.charAt(i);

			if (left == '[' || left == '(' || left == '{') {

				stack.push(str.charAt(i));

			} else {

				if (stack.isEmpty()) {

					return "NO";

				}

				char right = stack.pop();

				if (right == '[' && left != ']' || right == '{' && left != '}' || right == '(' && left != ')') {

					return "NO";

				}

			}

		}

		if (!stack.isEmpty()) {

			return "NO";

		}

		return "YES";

	}

	public static void main(String[] args) {
		System.out.println(check("{[()]}"));
		System.out.println(check("{[(])}"));
	}

}
