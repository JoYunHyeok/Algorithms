package 별찍기모음;

public class 피라미드 {
	// 피라미드
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 피라미드 삼각형
		for(int i=0; i<4; i++) {
			for(int j=0; j<3-i; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<2*i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		// 역피라미드 삼각형
		for(int i=0; i<4; i++) {
			for(int j=0; j<i; j++) {
				System.out.print(" ");
			}
			// 0 2 4 6
			for(int j=7; j>i*2; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
