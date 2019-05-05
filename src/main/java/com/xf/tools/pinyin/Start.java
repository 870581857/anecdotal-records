package com.xf.tools.pinyin;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.*;
import java.util.List;

public class Start {

    public static void main(String[] args) throws IOException {
        String inFilePath = "d://需生成拼音及助记码商品名称表20190417-V1.xls";
        String outFilePath = "d://poi.xls";
        PinYinUtils.initPinyin();
        List<String> cellList = PoiReadDemo.readExeclToString(inFilePath);
        PoiWriteDemo.creatExcelPinyin(cellList,outFilePath);
    }
}
