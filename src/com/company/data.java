package com.company;
import java.util.Map;
import java.util.LinkedHashMap;
public class data {

    public Map<String, String> keyVal;

    public data(String name) {
    }

    public void CsvVo(String id) {
        keyVal = new LinkedHashMap<>();// you may also use HashMap if you don't need to keep order
    }
    public Map<String, String> getKeyVal() {
        return keyVal;
    }
    public void setKeyVal(Map<String, String> keyVal) {
        this.keyVal = keyVal;
    }
    public void put(String key, String val) {
        keyVal.put(key, val);
    }
    public String get(String key) {
        return keyVal.get(key);
    }
}
