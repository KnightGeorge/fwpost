package fwpost;

//import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;

import javax.print.attribute.standard.RequestingUserName;

/*import javax.swing.text.html.HTMLDocument.HTMLReader;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;*/

public class show {
	public static void main(String[] args) throws Exception {
		Start task = new Start();
		task.StartWork();
	}	
}

class FileName {
	Date today = new Date();

	Calendar calendar = new GregorianCalendar();
	//获取前一天日期;例:
	public String yesterday() throws Exception {
		calendar.setTime(today);
		calendar.add(Calendar.DATE, -1);
		Date Yesterday=calendar.getTime();
		SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");//定义数据输出格式
		URL posturl = new URL("http://172.16.40.4/mails/"+ft.format(Yesterday)+"/");
		return posturl.toString();
	}
	
	String FindDate(String getDate) {
		//输入查询日期，如20180909
		String CheckURL = "http://172.16.40.4/mails/"+ getDate +"/";
		return CheckURL;
	}
}


/*//链接查看
class conn{
	URL testconn(URL url) throws Exception{
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();//链接
		conn.connect();
		int code = conn.getResponseCode();
		if (code != HttpURLConnection.HTTP_OK) {
			System.out.println("连接失败");
		}
		else {
			System.out.println("连接成功");
		}
		try {
			InputStream in = url.openStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader buf = new BufferedReader(isr);
			String text = null;
			String getline;
			while((getline = buf.readLine()) != null) {
				System.out.println(getline);
				text = text + getline ;
			}
			buf.close();
			isr.close();
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return url;
	}
}

class XML{
	void GetUrl(URL url) throws DocumentException{
		SAXReader reader = new SAXReader();
		Document document = reader.read(url);
		Element root = document.getRootElement();
		for(Iterator it = root.attributeIterator();it.hasNext();) {
			Attribute attribute = (Attribute) it.next();
			String text = attribute.getText();
			System.out.println(text);
		}
		Document document = DocumentHelper.parseText(url.toString());
		Element RootElement = document.getRootElement(); 
		List<Attribute> listAttr = RootElement.attributes();
		for(Attribute attr : listAttr) {
			String name =attr.getName();
			String value = attr.getValue();
			System.out.println(name + value);
		}
		return;
	}
}


class DownFile{
	void GetFile(URL url){
		File file = new File("D:/"+url.toString());
		if(file.getName() != file.toString()) {
			file.mkdir();
		}
		
	}
}*/