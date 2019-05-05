package com.xf.tools.pinyin;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 拼音工具类
 */
public class PinYinUtils {
    //多音词表
    private static Map<String, List<String>> pinyinMap = new HashMap<String, List<String>>();

    /**
     * 获取汉字首字母的方法。
     * 说明：暂时解决不了多音字的问题，只能使用取多音字的第一个音的方案
     * @param hanzi 汉子字符串
     * @return 大写汉子首字母; 如果都转换失败,那么返回null
     */
    public static String getHanziInitials(String hanzi) {
        String result = null;
        if (null != hanzi && !"".equals(hanzi)) {
            char[] charArray = hanzi.toCharArray();
            StringBuffer sb = new StringBuffer();
            for (char ch : charArray) {
                // 逐个汉字进行转换， 每个汉字返回值为一个String数组（因为有多音字）
                String[] stringArray = PinyinHelper.toHanyuPinyinStringArray(ch);
                if (null != stringArray) {
                    sb.append(stringArray[0].charAt(0));
                }
            }
            if (sb.length() > 0) {
                result = sb.toString().toUpperCase();
            }
        }
        return result;
    }

    /**
     * 获取汉字拼音的方法。
     */
    public static String getHanziPinYin(String hanzi,Set<String> ikStr) throws BadHanyuPinyinOutputFormatCombination {
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

        int initSize = ikStr.size();
        String result = null;
        if (null != hanzi && !"".equals(hanzi)) {
            char[] charArray = hanzi.toCharArray();
            StringBuffer sb = new StringBuffer();
            for (char ch : charArray) {
                // 逐个汉字进行转换， 每个汉字返回值为一个String数组（因为有多音字）
                String[] stringArray = PinyinHelper.toHanyuPinyinStringArray(ch,defaultFormat);

                if (null != stringArray) {
                    Set<String> set = new LinkedHashSet<>(Arrays.asList(stringArray));
                    if(set.size() == 1){
                        //把第几声这个数字给去掉
                        sb.append(stringArray[0]);
                    }else{
                        //多音字,不是声调不同
                        for(String pset : set){
                            List<String> dyc = pinyinMap.get(pset);
                            if(dyc != null){
                                ikStr.removeAll(dyc);
                            }
                            if(initSize!=ikStr.size()){
                                sb.append(pset);
                                break;
                            }
                        }
                        if(sb.toString().equals("")){
                            sb.append(stringArray[0]);
                        }
                    }
                }
            }
            if (sb.length() > 0) {
                result = sb.toString();
            }
        }
        return result;
    }

    /**
     * 初始化 所有的多音字词组
     */
    public static void initPinyin() {
        // 读取多音字的全部拼音表;
        InputStream file = null;
        try {
            file = new FileInputStream(new File("d:\\duoyinzi_dic.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BufferedReader br = null;
        String s = null;
        try {
            br = new BufferedReader(new InputStreamReader(file,"UTF-8"));
            while ((s = br.readLine()) != null) {
                if (s != null) {
                    String[] arr = s.split("#");
                    String pinyin = arr[0];
                    String chinese = arr[1];

                    if (chinese != null) {
                        String[] strs = chinese.split(" ");
                        //去空
                        List<String> list = arr2List(strs);
                        pinyinMap.put(pinyin, list);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 数组转换成集合，并且去掉空格
    private static List<String> arr2List(String[] strs) {
        if(strs!=null&&strs.length>0){
            List<String> list = new ArrayList<String>();
            for (int i = 0; i < strs.length; i++) {
                if(!"".equals(strs[i].trim())){
                    list.add(strs[i].trim());
                }
            }
            return list;
        }else{
            return null;
        }
    }


    public static void main(String[] args) {
//        System.out.println(PinYinUtils.getHanziInitials("补血调经片"));
        initPinyin();
        try {
            Pattern p = Pattern.compile("[\\u4e00-\\u9fa5]");
            Matcher m = p.matcher("补血调经片");
            Map<String,String> mappinYin = new HashMap<>();
            while(m.find()){
                String oneStr = m.group();
                String pinYin = PinYinUtils.getHanziPinYin(oneStr,Ikanalyzer.ikstr("补血调经片"));
                System.out.println(pinYin);
                mappinYin.put(oneStr,pinYin);
            }
        } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
            badHanyuPinyinOutputFormatCombination.printStackTrace();
        }

    }
}