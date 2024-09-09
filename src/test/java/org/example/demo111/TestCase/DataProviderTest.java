package org.example.demo111.TestCase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
/**
 * Description :
 *
 * @author : HMF
 * Date : Created in 11:24 2023/11/16
 * @version :
 */
public class DataProviderTest {

    @DataProvider(name="testData")
    public Object[][] provider(){
        Object [][] provider = new Object [6][2];
        for (int i = 0; i < provider.length; i++) {
            provider[i][0] = "value"+i;
            provider[i][1] = i+100;
        }
        return provider;
    }

    @Test(dataProvider="testData", priority = 1, enabled = true, groups = { "sit", "checklist", "success" })
    public void getName_dataProvider(String value,int num){
        System.out.println("DataProviderTest，getName_dataProvider，用例开始执行");
        System.out.println("");
    }

}