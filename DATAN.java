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
		List<String> getDoc = new ArrayList<String>();//�н�html�ļ���
		List<Map<String, String>> FullDoc = new ArrayList<Map<String,String>>();
		List<String> getKey = new ArrayList<String>(); 
		Map<String , String> GetMap = new HashMap<String,String>();
		Map<String , String> NoSameMap = new HashMap<String,String>();
		Map<String, Integer> SumMap = new HashMap<String,Integer>();
		String key =new String();
		//��ȡhtml������
		for(int i=5;i<FullLink.size();i++) {
			getDoc.add(FullLink.get(i));
			TotalPost ++;
		}
		//TotalPost = getDoc.size();
		System.out.println(getURL);
		//����ȡ�����ݷ���list�У�˳����map��keyȥ��
		for(String get:getDoc) {
			GetMap = readHtmler.ReadHtmlContenter(get);
			FullDoc.add(GetMap);//��ȡÿ�����ӵ�html���ݷ���list
			NoSameMap.putAll(GetMap);//����ȥ��
		}
		//���ȥ�غ��ʼ�����
		Iterator<Map.Entry< String , String>> itNoSame = NoSameMap.entrySet().iterator();
		while (itNoSame.hasNext()) {
			Map.Entry<String , String> entry = itNoSame.next();
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		System.out.println();
		//��ȡ����key
		for(Map<String , String> i:FullDoc) {
			key = i.keySet().toString();
			getKey.add(key);	
		}
		//ͳ�Ƹ���key���ֵĴ���
		for(String item: getKey){
            if(SumMap.containsKey(item)){
                SumMap.put(item, SumMap.get(item).intValue() + 1);
            }else{
                SumMap.put(item, new Integer(1));
            }
        }
		//�������
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
		System.out.println("�ʼ�����:"+TotalPost);
	}
}
