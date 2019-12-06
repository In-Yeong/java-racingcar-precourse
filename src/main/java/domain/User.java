package domain;

import java.util.InputMismatchException;
import java.util.Scanner;

public class User {

	public String[] EnterCarName_ReturnArray() {
		String[] CarNameArray;
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("������ �ڵ��� �̸��� 5�� ���Ϸ� �Է��ϼ���. (�̸��� ��ǥ(,) �������� ����) : ");
			String CarNameString = scanner.nextLine();
			CarNameArray = StringToArray(CarNameString);
			int error_or_not = Exception(CarNameArray);
			if (error_or_not == 0) {
				break;
			}
			System.out.println("�ڵ��� �̸��� 1�� �̻� 5�� ���Ϸ� �Է����ּ���.");
			scanner.reset();
		}
		return CarNameArray;
	}
	
	public int Exception(String[] arr) {
		int error = 0;
		for (int i=0; i<arr.length; i++) {
			if (arr[i].length() > 5 || arr[i].length() == 0) {
				error += 1;
				break;
			}
		}
		return error;
	}
	
	public String[] StringToArray(String str) {
		String[] arr;
		arr = str.split(",");
		
		for (int i=0; i<arr.length; i++) {
			String name = arr[i];
			arr[i] = name.trim();
		} 
		
		return arr;
	}
	
	public int Attempt() {
		int result=0;
		while (true) {
			System.out.print("�õ��� Ƚ���� ��ȸ�ΰ���?(1 �̻��� ���ڸ� �Է�) : ");
			int[] ErrorCheck_and_Num = Attempt_Exception();

			if (ErrorCheck_and_Num[0] == 0) {
				result = ErrorCheck_and_Num[1];
			}
			if (result != 0) {
				break;
			}
		}
		return result;
	}
	
	public int[] Attempt_Exception() {
		Scanner scanner = new Scanner(System.in);
		int TryNum = 0;
		int error = 0;
		int[] result = new int[] {0,0};
		try {
			TryNum = scanner.nextInt();
		} catch(InputMismatchException ime) {
		    System.out.println("���ڸ� �Է� �����մϴ�.");
		    scanner.reset();
		    error += 1;
		}
		result[0] = error;
		if (result[0] == 0 ) {
			result[1] = TryNum;
		}
		return result;	
	}
}
