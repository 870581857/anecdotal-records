package com.xf.tools.pinyin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Poi 读 Excel
 */
public class PoiReadDemo {

    public static List<String> readExeclToString(String filePath){
        List<String> list = new ArrayList();
        File xlsFile = new File("d://需生成拼音及助记码商品名称表20190417-V1.xls");
        // 获得工作簿
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(xlsFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        // 获得工作表个数

        //工作表个数 int sheetCount = workbook.getNumberOfSheets();
        // 第一个工作表
        Sheet sheet = workbook.getSheetAt(0);

        //行数
        int rows = sheet.getLastRowNum() + 1;

        //读取数据
        for (int row = 1; row < rows; row++) {
            Row r = sheet.getRow(row);
            String cellStr = r.getCell(0).getStringCellValue();
            if(StringUtils.isNotEmpty(cellStr.replaceAll(" ",""))){
                list.add(cellStr);
            }
        }
        System.out.println(list.toString());
        return list;
    }
}