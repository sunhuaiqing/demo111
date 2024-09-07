package org.example.demo111.TestCase;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    public static void main(String[] args) {
        try {
            // 创建文件输入流
            FileInputStream file = new FileInputStream(new File("D:\\IDEAProjects\\demo111\\excel\\temp.xlsx"));

            // 使用WorkbookFactory创建Workbook对象，同时根据文件类型选择对应的实现类
            Workbook workbook = WorkbookFactory.create(file);

            // 获取第一个Sheet
            Sheet sheet = workbook.getSheetAt(0);

            // 遍历Sheet中的每一行和每一列
            for (Row row : sheet) {
                for (Cell cell : row) {
                    // 读取单元格的值
                    String cellValue = cell.getStringCellValue();
                    System.out.println(cellValue);
                }
            }

            // 关闭文件输入流
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
