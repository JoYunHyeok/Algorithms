package ��������;

public class ����ﰢ�� {
	// �����ִ� �ﰢ��
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ù��° Ǯ��
//		for(int i=0; i<5; i++) {
//			for(int k=i; k<4; k++) {
//				System.out.print(" ");
//			}
//			for(int j=0; j<=i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		//�ι�° Ǯ��
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
