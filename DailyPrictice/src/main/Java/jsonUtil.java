
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.util.Iterator;


public class jsonUtil {
    public static String loadJson(String url) throws Exception {
        //读取url,返回json串
        StringBuilder json = new StringBuilder();
        URL oracle = new URL(url);
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String inputLine = null;
        while((inputLine = in.readLine()) != null){
            json.append(inputLine);
        }
        in.close();

        return json.toString();
    }
    public static void main(String[] args) throws Exception {
        String url = "https://agent.pizzahut.com.cn:21001/rest/ynzhawd0mdd4eg/bskfc560/im/statistics/agentLoginDetail?startTime=20190729140000&endTime=20190729143000&beginIndex=0&pageSize=100";
        String json = loadJson(url);
        //System.out.println(json);
        JSONObject jsonObj = new JSONObject(json);
        System.out.println(jsonObj.toString());

        //创建excel工作薄
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建一个工作表sheet
        XSSFSheet sheet = workbook.createSheet("stationInfo");
        //创建第一行
        XSSFRow row = sheet.createRow(0);
        //创建一个单元格
        XSSFCell cell = null;
        //插入第一行标题栏
    }
}
