package 별찍기모음;

public class 공백삼각형 {
	// 공백있는 삼각형
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//첫번째 풀이
//		for(int i=0; i<5; i++) {
//			for(int k=i; k<4; k++) {
//				System.out.print(" ");
//			}
//			for(int j=0; j<=i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		//두번째 풀이
		for(int i=0; i<5; i++) {
			for(int j=4; j>=0; j--) {
				if(i<j) {
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

}
