package com.example.ScheduleDemo.Util;


import java.io.BufferedReader;
import java.io.IOException;

public class JsonToString {
    public static String convertJsonToString(BufferedReader buffereReader) throws IOException {
        String res, jsonToString = "";
        while ((res = buffereReader.readLine()) != null) {
            jsonToString += res;
        }
        return jsonToString;
    }
}
