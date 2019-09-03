import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

public class Demo {



        public static void main(String[] args) {
            String stationInfo_title[] =
                    {"Pictures","StationLng","SiteGuide","Address","ServiceTel","SupportOrder","OperatorID","StationID","Remark","StationName",
                            "StationTel","StationLat","StationStatus","CountryCode","StationType","EquipmentOwnerID","Construction","MatchCars",
                            "ParkFee","ParkInfo","ServiceFee","Payment","ElectricityFee","AreaCode","EquipmentInfos","ParkNums","BusineHours"};

            //创建excel工作薄
            XSSFWorkbook workbook = new XSSFWorkbook();
            //创建一个工作表sheet
            XSSFSheet sheet = workbook.createSheet("stationInfo");
            //创建第一行
            XSSFRow row = sheet.createRow(0);
            //创建一个单元格
            XSSFCell cell = null;
            //插入第一行标题栏
            for (int i=0;i<stationInfo_title.length;i++) {
                cell = row.createCell(i);
                cell.setCellValue(stationInfo_title[i]);
            }

            //接着写入内容
            //StarStationInfoToExcel starStationInfoToExcel = new StarStationInfoToExcel();
            try{
                //通过接口获取StationInfos内容，json格式，用java解析
                JSONObject stationInfosJason = starStationInfoToExcel.getStationInfo();
                int pageNo = (int)stationInfosJason.get("PageNo");
                int pageCount = (int)stationInfosJason.get("PageCount");
                int itemSize =(int)stationInfosJason.get("ItemSize");
                System.out.println("pageNo:"+ pageNo);
                System.out.println("pageCount:" + pageCount);
                System.out.println("itemSize:" + itemSize);
                JSONArray stationInfosJasonArray = stationInfosJason.getJSONArray("StationInfos");

                for(int i=0;i<stationInfosJasonArray.size();i++) {
                    int colunm = 0;
                    row = sheet.createRow(i+1);//先写行数据，从第二行开始写
                    JSONObject jasonObject = stationInfosJasonArray.getJSONObject(i);
                    Iterator stationInfoKeys = jasonObject.keySet().iterator();
                    while (stationInfoKeys.hasNext()) {
                        String key = (String) stationInfoKeys.next();
                        String value = (String) jasonObject.getString(key);
                        cell = row.createCell(colunm); //先建单元格，从0开始
                        cell.setCellValue(value); //给单元格赋值
                        colunm ++;
                    }
                }
            }catch (Exception e) {
                e.printStackTrace();
            }

            //创建一个文件
            File file = new File("D:\\javaExample\\file\\stationInfo.xlsx");
            try {
                if(!file.exists()) {
                    file.createNewFile();
                }
                //创建输出流
                OutputStream outputStream = new FileOutputStream(file);
                //将拼好的Excel写入到文件流
                workbook.write(outputStream);
                //关闭输出流
                outputStream.close();
            }catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


