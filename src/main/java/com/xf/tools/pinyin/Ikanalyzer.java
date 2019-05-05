package com.xf.tools.pinyin;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;
public class Ikanalyzer {
	public static Set<String> ikstr(String inStr){
		StringReader re = new StringReader(inStr);
		IKSegmenter ik = new IKSegmenter(re,true);
		Lexeme lex = null;
		Set<String> out = new HashSet<>();
		try {
			while((lex=ik.next())!=null){
				out.add(lex.getLexemeText());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(out);
		return out;
	}
}
