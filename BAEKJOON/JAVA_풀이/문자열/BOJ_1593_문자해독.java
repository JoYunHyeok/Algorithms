import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int wSize, sSize;
    static String w;
    static String s;
    
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	wSize = sc.nextInt(); 
    	sSize = sc.nextInt();
    	
    	w = sc.next();
    	s = sc.next();
    	
    	int[] wArray = new int[52]; // �迭�� ����� ���� ���� ����x
    	int[] sArray = new int[52];
    	
    	for(char c : w.toCharArray()) {
    		sliding(c, wArray, 1);
    	}
    	
    	
    	int start = 0;
    	int cnt =0;
    	int size =0;
    	for(int i=0; i<sSize; i++) { // �񱳵Ǿ����� ������� �����̵�
    		char sChar = s.charAt(i);
    		sliding(sChar, sArray, 1);
    		size++;
    		
    		if(size == wSize) {
    			if(Arrays.equals(wArray, sArray)) {
    				cnt++;
    			}
    			sliding(s.charAt(start), sArray, -1);
    			start++;
    			size--;
    		}
    	}
    	
    	System.out.println(cnt);
    }

	private static void sliding(char word, int[] array, int diff) {
		if('a' <= word && word <= 'z') {
			array[word-'a'] += diff;
		}else {
			array[word-'A'+26] += diff; //26�����ִ°� ���� �ʱ�
		}
	}

}