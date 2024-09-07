package org.example.demo111.TestCase;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.example.demo111.utils.ExcelUtil_2;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.example.demo111.utils.CaseHelper;
import org.example.demo111.utils.CaseInfo;
import org.example.demo111.utils.ReadExcel;

public class MyTestExcel {
    protected String caseExcelPath = System.getProperty("user.dir") + "\\excel\\temp.xlsx";


    //@DataProvider(name = "dataInfo1")
   public Object[][] datas() {
    //public void datas() {
        String excelPath = "src/test/resources/temp.xlsx";
        Object[][] datas = ExcelUtil_2.getDatas(excelPath, 1, 7, 5, 6);//传入开始和结束的行列索引，注意不是行列号
        System.out.println("@@datas:" + datas);
        return datas;
    }

    //@DataProvider(name = "dataInfo")
    protected Object[][] dataInfo1() throws IOException {
        System.out.println("@@caseExcelPath:" + caseExcelPath);
        Object[][] myObj = null;
        List<Map<String, String>> list = ReadExcel.readXlsx(caseExcelPath);
        myObj = CaseHelper.getObjArrByList(list);
        return myObj;
    }

    //@Test(dataProvider = "dataInfo1")
    public void testByExcel_Body(CaseInfo c) throws IOException {
        ///获取用例说明
        System.out.println(c.getCaseDesc());
        ///获取用例需要的参数
        System.out.println(c.getCaseParam());
        //获取执行用例需要的前置条件
        System.out.println(c.getCasePreset());
    }

}