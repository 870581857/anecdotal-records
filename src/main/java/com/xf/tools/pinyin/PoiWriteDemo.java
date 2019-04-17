package com.xf.tools.pinyin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Poi写Excel
 */
public class PoiWriteDemo {
    public static void main(String[] args) throws IOException {

        String inFilePath = "d://需生成拼音及助记码商品名称表20190417-V1.xls";
        String outFilePath = "d://poi.xls";
        List<String> cellList = PoiReadDemo.readExeclToString(inFilePath);
        creatExcelPinyin(cellList,outFilePath);
    }

    public static void creatExcelPinyin(List<String> cellList,String outFilePath){
        // 创建工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建工作表
        HSSFSheet sheet = workbook.createSheet("需生成拼音及助记码商品名称");
        HSSFRow rowsTitle = sheet.createRow(0);
        rowsTitle.createCell(0).setCellValue("药品名称（通用名称）B");
        rowsTitle.createCell(1).setCellValue("全拼");
        rowsTitle.createCell(2).setCellValue("首字母（助记码/符）");
        for (int row = 1; row <= cellList.size(); row++) {
            String oneCell = cellList.get(row-1);

            Map<String,String> map = handleCell(oneCell);
            String towCell = map.get("onecellStr");
            String thrCell = map.get("twocellStr");
            HSSFRow rows = sheet.createRow(row);
            rows.createCell(0).setCellValue(oneCell);
            rows.createCell(1).setCellValue(towCell);
            rows.createCell(2).setCellValue(thrCell);
        }

        File xlsFile = new File(outFilePath);
        FileOutputStream xlsStream = null;
        try {
            xlsStream = new FileOutputStream(xlsFile);
            workbook.write(xlsStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Map handleCell(String cellStr){
        Pattern p = Pattern.compile("[\\u4e00-\\u9fa5]");
        Matcher m = p.matcher(cellStr);

        String mapinitials = "";
        Map<String,String> mappinYin = new HashMap<>();
        while(m.find()){
            String oneStr = m.group();
            String initials = PinYinUtils.getHanziInitials(oneStr);
            String pinYin = PinYinUtils.getHanziPinYin(oneStr);
            mappinYin.put(oneStr,pinYin);

            mapinitials = mapinitials + initials;
        }

        for(Map.Entry map: mappinYin.entrySet()){
            String key = (String) map.getKey();
            String value = (String) map.getValue();
            cellStr = cellStr.replaceAll(key,value);
        }

        Map map = new HashMap();
        map.put("onecellStr",cellStr);
        map.put("twocellStr",mapinitials);
        return map;
    }

}