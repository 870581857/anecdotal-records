package com.xf.tools.strtools;

/**
 * Created by xf
 * 2018/11/26.
 */
public class StringUtils {

    public static void main(String[] args) {
        String resumeSource = "3,1,2,3,5";
        if(resumeSource.contains("3")){
            resumeSource =resumeSource.replace("3","");
            resumeSource = resumeSource.replace(",,",",");
            if(resumeSource.startsWith(",")){
                resumeSource = resumeSource.substring(1,resumeSource.length());
            }
            if(resumeSource.endsWith(",")){
                resumeSource = resumeSource.substring(0,resumeSource.length()-1);
            }
        }
        System.out.println(resumeSource);
    }
}
