package com.le.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.le.wechat.entity.ImageMessage;
import com.le.wechat.entity.TextMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * ClassName:MessUtil
 * @author admin
 * 
 *
 */
public class MessageUtil {
	/** 
     * ������Ϣ���ͣ��ı� 
     */  
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";  

    /** 
     * ������Ϣ���ͣ����� 
     */  
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";  

    /** 
     * ������Ϣ���ͣ�ͼ�� 
     */  
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";  

    /** 
     * ������Ϣ���ͣ��ı� 
     */  
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";  

    /** 
     * ������Ϣ���ͣ�ͼƬ 
     */  
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";  

    /** 
     * ������Ϣ���ͣ����� 
     */  
    public static final String REQ_MESSAGE_TYPE_LINK = "link";  

    /** 
     * ������Ϣ���ͣ�����λ�� 
     */  
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";  

    /** 
     * ������Ϣ���ͣ���Ƶ 
     */  
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";  

    /** 
     * ������Ϣ���ͣ����� 
     */  
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";  

    /** 
     * �¼����ͣ�subscribe(����) 
     */  
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";  

    /** 
     * �¼����ͣ�unsubscribe(ȡ������) 
     */  
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";  

    /**
     * ɨ���������ά���¼�
     */
    public static final String EVENT_TYPE_SCAN="SCAN";
    /**
     * �ϱ�����λ���¼�
     */
    public static final String EVENT_TYPE_LOCATION="LOCATION";
    /** 
     * �¼����ͣ�CLICK(�Զ���˵�����¼�) 
     */  
    public static final String EVENT_TYPE_VIEW="CLICK";
    /**
     * ����˵���ת����ʱ���¼�����
     */
    public static final String EVENT_TYPE_CLICK="VIEW";
    
    /**
     * 
     * @param request
     * @return
     * @throws Exception
     */
    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {  
        // ����������洢�� HashMap ��   
        Map<String, String> map = new HashMap<String, String>();  

        // �� request ��ȡ��������   
        InputStream inputStream = request.getInputStream();  
        // ��ȡ������   
        SAXReader reader = new SAXReader();  
        Document document = reader.read(inputStream);  
        // �õ� xml ��Ԫ��   
        Element root = document.getRootElement();  
        // �õ���Ԫ�ص������ӽڵ�   
        List<Element> elementList = root.elements();  

        // ���������ӽڵ�   
        for (Element e : elementList)  
            map.put(e.getName(), e.getText());  

        // �ͷ���Դ   
        inputStream.close();  
        inputStream = null;  

        return map;  
    }  
    
    /**
     * 获取请求中的xml数据
     * @param request
     * @return
     * @throws IOException 
     */
    public static String convertXML(HttpServletRequest request) throws Exception{
    	InputStream inputStream = request.getInputStream();  
    	  SAXReader reader = new SAXReader();  
          Document document = reader.read(inputStream);  
          String asXML = document.asXML();
          inputStream.close();
    	return asXML;
    }
    
    public static Map<String, String> parseXml(InputStream inputStream) throws Exception {  
        // ����������洢�� HashMap ��   
        Map<String, String> map = new HashMap<String, String>();  
        // ��ȡ������   
        SAXReader reader = new SAXReader();  
        Document document = reader.read(inputStream);  
        // �õ� xml ��Ԫ��   
        Element root = document.getRootElement();  
        // �õ���Ԫ�ص������ӽڵ�   
        List<Element> elementList = root.elements();  

        // ���������ӽڵ�   
        for (Element e : elementList)  
            map.put(e.getName(), e.getText());  

        // �ͷ���Դ   
        inputStream.close();  
        inputStream = null;  

        return map;  
    }  
    
    /**
     * @Description: 文本消息对象转换成 xml
     * @param @param textMessage
     * @param @return
     * @author dapengniao
     * @date 2016 年 3 月 8 日 下午 4:13:22
     */
    public static String textMessageToXml(TextMessage textMessage) {
        xstream.alias("xml", textMessage.getClass());
        return xstream.toXML(textMessage);
    }
    
    
    /**
     * @Description: 图文消息对象转换成 xml
     * @param @param newsMessage
     * @param @return
     * @author dapengniao
     * @date 2016 年 3 月 8 日 下午 4:14:09
     */
   /* public static String newsMessageToXml(ImageMessage newsMessage) {
        xstream.alias("xml", newsMessage.getClass());
        xstream.alias("item", new ImageMessage().getClass());
        return xstream.toXML(newsMessage);
    }**/

   
    /**
     * @Description: 图片消息对象转换成 xml
     * @param @param imageMessage
     * @param @return
     * @author dapengniao
     * @date 2016 年 3 月 9 日 上午 9:25:51
     */
    public static String imageMessageToXml(ImageMessage imageMessage) {
        xstream.alias("xml", imageMessage.getClass());
        return xstream.toXML(imageMessage);
    }
    
    
    /**
     * 对象到 xml 的处理
     */
    private static XStream xstream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // 对所有 xml 节点的转换都增加 CDATA 标记
                boolean cdata = true;

                @SuppressWarnings("rawtypes")
                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                }

                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                    	
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });
    
}
