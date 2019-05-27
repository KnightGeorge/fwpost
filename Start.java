package fwpost;

import java.util.Scanner;

public class Start {
	void StartWork() throws Exception {
		//正式环境
		FileName fileName = new FileName();
		String postString = fileName.yesterday();
		DATAN datan = new DATAN();
		datan.Datan(postString);
		boolean flag = true;
		//判断是否查询其他日志
		while (flag){
			System.out.println("是否查询其他日期？请输入yes(Y)/no(N)继续");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			String getWord = scanner.nextLine();
			if ((getWord.equals("yes")) || getWord.equals("Y")) {
				System.out.println("请输入如下格式:20180817");
				String getDate = scanner.nextLine();
				String GetFileName = fileName.FindDate(getDate);
				datan.Datan(GetFileName);
				flag = true;
			}
			else {
				System.out.println("谢谢使用，打赏小费请转账支付宝：719583668@qq.com");
				flag = false;
			}	
		}
	}
}
