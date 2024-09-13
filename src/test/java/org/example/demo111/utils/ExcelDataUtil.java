package org.example.demo111.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelDataUtil {
    String classname;
    String casename;

    /**
     * @param classname
     *            excel文件名
     * @param casename
     *            sheet名
     */
    public ExcelDataUtil(String classname, String casename) {
        this.classname = classname;
        this.casename = casename;
    }

    /**
     * 获取excel文件的路径
     *
     * @return
     */
    public String getPath() {
        String path = ".\\src\\test\\java\\org\\example\\demo111\\testdata\\" + classname + ".xls";
        return path;
    }

    /**
     * 获取excel对应sheet中的数据
     *
     * @return
     * @throws IOException
     */
    public Object[][] getExcelData() {
        File file = new File(getPath());
        Workbook book = null;
        Sheet sheet = null;
        try {
            book = Workbook.getWorkbook(file);
            sheet = book.getSheet(casename);
        } catch (Exception e) {
            System.out.println(classname + ".xls文件读取失败");
            System.out.println(".e.getMessage():"+e.getMessage());
        }

        int rows = sheet.getRows();
        int cols = sheet.getColumns();
        // 如果行数少于2，则没有必要再继续运行下去了，不会返回数据，直接退出程序
        if (rows <= 1) {
            System.out.println(classname + ".xls的" + casename + " sheet没有数据");
            System.exit(0);
        }
        // 为了返回值是Object[][]类型，定义一个多行单列的二维数组
        HashMap<String, String>[][] arrMap = new HashMap[rows - 1][1];
        // 对数组中的所有元素初始化
        for (int i = 0; i < rows - 1; i++) {
            arrMap[i][0] = new HashMap<>();
        }
        // 定义一个list，存储第一行的标题，作为key用
        // 需要注意的是，getCell(col,row),第一个纵坐标，第二个位横坐标
        List<String> list = new ArrayList<String>();
        for (int c = 0; c < cols; c++) {
            list.add(sheet.getCell(c, 0).getContents());
        }
        // 以行为单位，将一行的数据，以键值对的形式，存进一个哈希表里
        for (int r = 1; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                arrMap[r - 1][0].put(list.get(c), sheet.getCell(c, r).getContents());
            }
        }
        book.close();
        //System.out.println("getExcelData()读取excel后，arrMap："+arrMap.toString());
        return arrMap;
    }
}
