package com.fq.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class XMLparse {
	/**
	 * 解析XML
	 * @param xml
	 * @return
	 * @throws Exception
	 */
	public static Map<String, String> xml2map(String xml) throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		Document document = DocumentHelper.parseText(xml);
		Element es = document.getRootElement();
		getSonElement(map, es);
		return map;
	}
	public static void getSonElement(Map<String, String> map, Element ele) {
		List sons = ele.elements();
		if (0 != sons.size()) {
			for (Iterator i = ele.elementIterator(); i.hasNext();) {
				Element son = (Element) i.next();
				map.put(son.getName(), son.getText().trim());
				getSonElement(map, son);
			}
		}
	}

	public static void main(String[] args)throws Exception{
		String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><ap><plain><resp_code>0000</resp_code><mchnt_cd>0002900F0041077</mchnt_cd><mchnt_txn_ssn>123123132123123</mchnt_txn_ssn><results><result><user_id>18655253157</user_id><ct_balance>0</ct_balance><ca_balance>0</ca_balance><cf_balance>0</cf_balance><cu_balance>0</cu_balance></result></results></plain><signature>kub/i/QpENdTRrVHPZxGAn0LtEtZ6HF5+sTDDMvWFucUY0/5MQaIVltFeJAfPbX95vJH7PkWWu25pCZC9fyQaBZS/wO5Hly4Cyr4JpRl7oKvNNbHH9Ep8L4obvGFFcDb2iEWkn6634SNsNu6A+oO9V8yO3qvOy/dI3NBAmUc9wI=</signature></ap>";
		Map<String, String> m = XMLparse.xml2map(str);
		System.out.println(m);
	}
}
