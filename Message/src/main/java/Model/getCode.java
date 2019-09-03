package Model;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

@WebServlet("/getCode.do")
public class getCode extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response){
        //生成一个六位数的随机数
        String str = "";
        for (int i = 0; i < 6; i++) {
            str += Math.floor(Math.random()*10);
        }
        String phone = request.getParameter("phone");
        //将验证码添加到session中
        request.getSession().setAttribute("code",str);
        //发送短信

    }

    public static void main(String[] args) {
        getCode  t = new getCode();
        t.sendMsg("17391508190","777777");
    }

    private void sendMsg(String phone,String code){

        DefaultProfile profile = DefaultProfile.getProfile(" cn-beijing", "LTAIe7sUjxMTNjju", "eZJmG3THRqN5GUaFRNwboumytaA3BI");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("QuerySendDetails");
        request.putQueryParameter("phone", phone);
        request.putQueryParameter("SendDate", "2019-6-3");
        request.putQueryParameter("PageSize", "1");
        request.putQueryParameter("CurrentPage", "1");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
    }


