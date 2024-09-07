package org.example.demo111.utils;

import java.util.Map;

public class CaseInfo {
    ///{$d}isexcute 为y的时候表示需要执行

    //用例参数 在excel中知己以字段名开头
    private Map<String,String> caseParam;
    //用例说明 在excel中以{$d}开头
    private Map<String,String> caseDesc;
    //用例预置条件 在excel中以{$p}开头
    private Map<String,String> casePreset;

    public Map<String, String> getCaseParam() {
        return caseParam;
    }
    public void setCaseParam(Map<String, String> caseParam) {
        this.caseParam = caseParam;
    }
    public Map<String, String> getCaseDesc() {
        return caseDesc;
    }
    public void setCaseDesc(Map<String, String> caseDesc) {
        this.caseDesc = caseDesc;
    }
    public Map<String, String> getCasePreset() {
        return casePreset;
    }
    public void setCasePreset(Map<String, String> casePreset) {
        this.casePreset = casePreset;
    }

}
