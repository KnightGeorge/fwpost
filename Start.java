package fwpost;

import java.util.Scanner;

public class Start {
	void StartWork() throws Exception {
		//��ʽ����
		FileName fileName = new FileName();
		String postString = fileName.yesterday();
		DATAN datan = new DATAN();
		datan.Datan(postString);
		boolean flag = true;
		//�ж��Ƿ��ѯ������־
		while (flag){
			System.out.println("�Ƿ��ѯ�������ڣ�������yes(Y)/no(N)����");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			String getWord = scanner.nextLine();
			if ((getWord.equals("yes")) || getWord.equals("Y")) {
				System.out.println("���������¸�ʽ:20180817");
				String getDate = scanner.nextLine();
				String GetFileName = fileName.FindDate(getDate);
				datan.Datan(GetFileName);
				flag = true;
			}
			else {
				System.out.println("ллʹ�ã�����С����ת��֧������719583668@qq.com");
				flag = false;
			}	
		}
	}
}
