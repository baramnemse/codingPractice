import java.util.HashSet;
import java.util.Set;

public class SherlockAndTheValidString {

    static String isValid(String s) {

        // 히스토그램 만들기
        int histogramArray[] = new int[25];
        for(int i=0;i<s.length();i++){
            histogramArray[s.charAt(i)-'a']++;
        }
        
        Set c= new HashSet();
        
        int index=0;
        for(int i=0;i<histogramArray.length;i++){
            if(histogramArray[i]!=0){
                c.add(histogramArray[i]);
                index=histogramArray[i];
            }
        }
        // 카테고리가 1개인 경우
        if(c.size()==1){
            return "YES";
        }
        // 카테고리가 2개 이상이면 안된다
        if(c.size()>2){
            return "NO";
        }
        // 카테고리가 2개인 경우
        // 카테고리 중 하나가 1개인 경우 YES
        int freq1=0;
        int freq2=0;
        for(int i:histogramArray){
            if(i!=0){
                if(i==index){
                    freq1++;
                }else{
                    freq2++;
                }
            }
        }
        if(freq1==1||freq2==1){
            return "YES";
        }
        return "NO";
    }

	public static void main(String[] args) {
		System.out.println(isValid("aaaabbcc"));

	}

}
