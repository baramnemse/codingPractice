import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Q1 {

	public static void main(String[] args) {
		List<Integer> input = new ArrayList();
		input.add(1);
		input.add(2);
		input.add(3);
		input.add(4);
		input.add(5);
		List result=cardinalitySort(input);
		System.out.println(result);
		
	}


	 static List<Integer> cardinalitySort(List<Integer> nums) {

	     // 결과

	     List result = new ArrayList();

	     Map cache = new HashMap();

	     

	     //정수를 이진수 스트링으로 표현

	     for(Integer num:nums){

	         String biString = Integer.toBinaryString(num);

	         // 1의 갯수

	         int count =0;

	         for(int i=0;i<biString.length();i++){

	             if(biString.charAt(i)=='1'){

	                 count++;

	             }

	         }

	         // 1갯수, 숫자로 입력

	         cache.put(num,count);

	     }

	     // 소팅하여 1의 숫자가 작은 순으로 결과에 넣어야함

	     int[] unsortedArray=new int[cache.size()];

	     int i=0;

	     for(Object num:cache.values()){

	         unsortedArray[i]=(int)num;

	         i++;

	     }

	     Arrays.sort(unsortedArray);

	     for(int count:unsortedArray){

	         result.add(cache.get(count));

	     }

	     return result;
	 }

}
