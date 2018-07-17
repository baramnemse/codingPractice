import java.util.Stack;

/**
 * 계산법 이해안감
 * @author Wonjin Heo
 *
 */
public class HistogramRectangle {

	public static void main(String[] args) {
		int array[] = new int[] { 3, 4, 2 };
		System.out.println(largestRectangleArea(array));

	}

	static public int largestRectangleArea(int[] heights) {
		int max = 0, i = 0;
		Stack<Integer> stack = new Stack<Integer>();

		while (i <= heights.length) {
			int no;
			if(i == heights.length){
				no=0;
			}else{
				no= heights[i];
			}
			if (stack.isEmpty() || no >= heights[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				int h = heights[stack.pop()];
				int w = stack.isEmpty() ? i : i - 1 - stack.peek();
				max = Math.max(max, h * w);
			}
		}

		return max;
	}

}
