package fwpost;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Stringcheck {

}

class ReadHtmler{
	//获取完整url;例如:172.16.40.4/mails/20180817/%5bxxxxxxxxxxxxxxxx.html
	List<String> ReadHtmler(String html) throws Exception {
		/*FileName fileName = new FileName();
		String postString = fileName.yesterday();*/
		Document document =Jsoup.connect(html).get();
		Elements getlink = document.select("a"); 
		List<String> hrefList = new ArrayList<String>();
		List<String> TotalList = new ArrayList<String>();
		//获取源url
		for(Element e:getlink) {
			hrefList.add(e.attr("href"));
			//System.out.println(e.attr("href"));
		}
		//拼接完整链接
		for(String href:hrefList){
			if (href.indexOf(".") == 0) {
				continue;
			}
			TotalList.add(html.concat(href));
		}
		return TotalList;
	}
	
	//获取html内容
	Map<String, String> ReadHtmlContenter(String html) throws IOException {
		//System.out.println("I'm In");
		Document document = Jsoup.connect(html).get();
		String geth2 = document.selectFirst("h2").toString().replaceAll("<(/)?h2>?", "");
		String geth3 = document.selectFirst("h3").toString().replaceAll("<(/)?h3>?", "");
		String getp = document.selectFirst("p").toString().replaceAll("<(/)?p?>", "");
		Map<String, String> coMap = new HashMap<String,String>();
		coMap.put(geth2, geth3.concat(getp));
		/*String[] arraryDoc = {geth2,geth3.concat(getp)};
		List<String> totalDoc = new ArrayList<String>();
		for (String str:arraryDoc) {
			totalDoc.add(str);
		}*/
		return coMap;
	}
}