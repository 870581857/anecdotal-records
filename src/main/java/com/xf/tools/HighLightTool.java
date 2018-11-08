package com.xf.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xf
 * 2018/11/8.
 */
public class HighLightTool {

    public String highlight(String key, String str) {

        String styleStart = "<i style=\"color: #20a4f3;\">";
        String styleEnd = "</i>";

        String regex = styleStart + key + "[\\s\\S]*?" + styleEnd;
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return str;
        }

        int index = 0;
        List<Integer> indexSpans = new ArrayList<Integer>();
        while ((index = str.toLowerCase().indexOf(key.toLowerCase(), index)) != -1) {
            indexSpans.add(index);
            index = index + key.length();
            indexSpans.add(index);
        }

        StringBuffer sb = new StringBuffer(str);
        for (int i = 0; i < indexSpans.size(); i++) {
            int sum = sb.length() - str.length();
            if (i % 2 == 0) {
                sb.insert(indexSpans.get(i) + sum, styleStart);
            }
            if (i % 2 == 1) {
                sb.insert(indexSpans.get(i) + sum, styleEnd);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
