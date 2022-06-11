package utils;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class FileUtil {
	//��¼������֤
    public static String selectUPwd(String uname,String path)
    {
		String result="";
		try
		{
			//登录密码验证�?
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line=null;
        System.out.println("--"+uname);
        while(result==""&&(line=br.readLine())!=null) {
        String[] arr= line.split(",");
        
        //System.out.println("--"+arr[0]);
        if(uname.equals(arr[0]))
        {
        	result= arr[1];
        	//System.out.println("--"+result); 
        }
		}
        br.close();//�ر��ļ�
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
    	
    }
  //添加用户信息到user.txt文件
    public static Boolean insertUser(String name,String password,String email,String phone,String path)
    {
    	Boolean falg=false;
    	try{

        OutputStream os = new FileOutputStream(path,true);
		PrintWriter pw=new PrintWriter(os);
        pw.println(name+","+password+","+email+","+phone);
    		pw.close();
		os.close();
        	falg=true;
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
		return falg;
    	
    }


}
