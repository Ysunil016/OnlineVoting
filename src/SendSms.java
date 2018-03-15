import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Random;


public class SendSms{

        public String sms(String vid,String num)
    	{
            
            
            //Your authentication key
            String authkey = "202394Agj0490VUm5aa73672";
            //Multiple mobiles numbers separated by comma
            String mobiles = num;
            //Sender ID,While using route4 sender id should be 6 characters long.
            String senderId = "102234";
            Random r = new Random();
            int neww = r.nextInt(9999);
            //Your message to send, Add URL encoding here.
            String message = "Your OTP for Virtual ID :'"+vid+"' is --> '"+neww+"'";
            //define route
            String val = String.valueOf(neww);
            String route="default";
            //Prepare Url
            URLConnection myURLConnection=null;
            URL myURL=null;
            BufferedReader reader=null;

            //encoding message
            String encoded_message=URLEncoder.encode(message);

            //Send SMS API
            String mainUrl="http://api.msg91.com/api/sendhttp.php?";

            //Prepare parameter string
            StringBuilder sbPostData= new StringBuilder(mainUrl);
            sbPostData.append("authkey="+authkey);
            sbPostData.append("&mobiles="+mobiles);
            sbPostData.append("&message="+encoded_message);
            sbPostData.append("&route="+route);
            sbPostData.append("&sender="+senderId);

            //final string
            mainUrl = sbPostData.toString();
            try
            {
                //prepare connection
                myURL = new URL(mainUrl);
                myURLConnection = myURL.openConnection();
                myURLConnection.connect();
                reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
                //reading response
                String response;
                while ((response = reader.readLine()) != null)
                //print response
                System.out.println(response);

                //finally close connection
                reader.close();
            }
            catch (IOException e)
            {
                    e.printStackTrace();
            }
            return val;
        }
}