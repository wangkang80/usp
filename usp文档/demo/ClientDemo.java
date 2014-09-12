package com.dkf.client;


import javax.xml.namespace.QName;


import org.apache.axis.client.Call;
import org.apache.axis.client.Service;


import com.dkf.security.DESTools;

public class ClientDemo {
	private static final String SERVICE_ENDPOINT = "http://61.129.70.81:8689/GeneralWs/services/DkfServices?wsdl";
	
	public String sendSms(String user,String password, String[]mobiles,String content,String planTime,String filename ){
		String  result="";
		String rs=null;
		
		try {
			Service service = new Service();
    		Call call = (Call) service.createCall();
    		call.setTargetEndpointAddress(new java.net.URL(SERVICE_ENDPOINT));
    		call.setOperationName(new QName("SendSMS"));
    		result = (String.valueOf((call.invoke(new Object[] { user , password,mobiles,content,planTime,""}))));
         
		}catch(Exception e){
			e.printStackTrace();
			result="";
		}
		return result;
	}
	
	public static void main(String[] args) {
		String mobile;
		try {
			mobile = DESTools.encrypt("13000000000","C9eLew123456" );
			 String user =DESTools.encrypt("10001","C9eLew123456" ); 
			 String password=DESTools.encrypt("123", "C9eLew123456"); 
			 String content=DESTools.encrypt("你好测试1002", "C9eLew123456");
			 String mobiles[]= new String[]{mobile};
			ClientDemo clientDemo= new ClientDemo();
			String result=clientDemo.sendSms(user, password, mobiles, content, "","");
			System.out.println("result="+result);
			
			
		
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
