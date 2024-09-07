package org.example.demo111.utils;
import org.apache.poi.ss.usermodel.*;

import java.io.File;


public class ExcelUtil_2 {
    //读取连续行列表格文件，传入开始的行列索引
    public static Object[][] getDatas(String excelPath, int rowStartNum, int rowEndNum, int cellStartNum, int cellEndNum) {

        //新建二维数组存储读取的数据，二维数组创建：object[][] datas=new Object[7][2];
        Object[][] datas = null;
        try {
            //获取workbook对象
            Workbook workbook = WorkbookFactory.create(new File(excelPath));
            //获取Sheet对象
            Sheet sheet = workbook.getSheet("Sheet1");
            datas = new Object[rowEndNum - rowStartNum + 1][cellEndNum - cellStartNum + 1];
            for (int i = rowStartNum; i <= rowEndNum; i++) {
                //根据行索引获取行
                Row row = sheet.getRow(i); //函数中传入的是索引值 ，所以此处不需要减1
                for (int j = cellStartNum; j <= cellEndNum; j++) {
                    //根据列索引获取列，并指定单元格数据为空的策略，否则单元格为空时，会报空指针异常。
                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    //将列设置为字符串类型
                    cell.setCellType(CellType.STRING);
                    //获取单元格数据
                    String value = cell.getStringCellValue();
                    //将单元格数据存储到数组中
                    datas[i - rowStartNum][j - cellStartNum] = value;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }
}