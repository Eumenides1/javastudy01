package Util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @ClassName: Test
 * @Description: TODO
 *
 * Excel 导入导出 是POI
 * 开发一个系统这个系统可以与Excel进行交互
 * 数据导入还有数据导出
 *
 */
public class Test {
    public static void main(String[] args) throws IOException {
        //1.创建一个工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //2.创建Sheet
        HSSFSheet sheet = workbook.createSheet("学生信息");
        //3.创建行
        HSSFRow row = sheet.createRow(0);
        //4.创建列
        HSSFCell cell = row.createCell(0);
        //5.填充数据
        cell.setCellValue("ajax");
        //6.输出Excel文件
        OutputStream outputStream = new FileOutputStream("d://Student.xls");
        //通过workbook的write方法，实现excel的输出
        workbook.write(outputStream);
        outputStream.close();
    }
}
