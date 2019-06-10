package fwpost;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class DATAN {
	void Datan(String getURL) throws Exception {
		ReadHtmler readHtmler = new ReadHtmler();
		int TotalPost = 0;
		List<String> FullLink = readHtmler.ReadHtmler(getURL);
		List<String> getDoc = new ArrayList<String>();//承接html文件名
		List<Map<String, String>> FullDoc = new ArrayList<Map<String,String>>();
		List<String> getKey = new ArrayList<String>(); 
		Map<String , String> GetMap = new HashMap<String,String>();
		Map<String , String> NoSameMap = new HashMap<String,String>();
		Map<String, Integer> SumMap = new HashMap<String,Integer>();
		String key =new String();
		//获取html的链接
		for(int i=5;i<FullLink.size();i++) {
			getDoc.add(FullLink.get(i));
			TotalPost ++;
		}
		//TotalPost = getDoc.size();
		System.out.println(getURL);
		//将获取的内容放入list中，顺便做map的key去重
		for(String get:getDoc) {
			GetMap = readHtmler.ReadHtmlContenter(get);
			FullDoc.add(GetMap);//获取每条链接的html内容放入list
			NoSameMap.putAll(GetMap);//内容去重
		}
		//输出去重后邮件内容
		Iterator<Map.Entry< String , String>> itNoSame = NoSameMap.entrySet().iterator();
		while (itNoSame.hasNext()) {
			Map.Entry<String , String> entry = itNoSame.next();
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		System.out.println();
		//获取所有key
		for(Map<String , String> i:FullDoc) {
			key = i.keySet().toString();
			getKey.add(key);	
		}
		//统计各个key出现的次数
		for(String item: getKey){
            if(SumMap.containsKey(item)){
                SumMap.put(item, SumMap.get(item).intValue() + 1);
            }else{
                SumMap.put(item, new Integer(1));
            }
        }
		//排序输出
		String sb = new String();
		Set set = SumMap.keySet();
		Object[] arr = (Object[]) set.toArray();
		Arrays.sort(arr);
		for(Object key1:arr) {
			sb = (key1.toString() + ":" + SumMap.get(key1).intValue());
			System.out.println(sb);
		}
		/*Iterator<String> keys = SumMap.keySet().iterator();
		String sb = new String();
		while (keys.hasNext()) {
			key =keys.next();
			sb = (key + ":" + " " + SumMap.get(key).intValue());
			System.out.println(sb);
		}*/
		System.out.println("邮件总数:"+TotalPost);
	}
}
