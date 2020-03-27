package com.alan2lin.makefsm.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.stringtemplate.v4.StringRenderer;

import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomStringRenderer extends StringRenderer {

    @Override
    public String toString(Object o, String formatString, Locale locale) {
    	 if ("capitalize".equals(formatString)) {
    		 return StringUtils.capitalize((String) o);
    	 }
    	 if ("uncapitalize".equals(formatString)) {
    		 return StringUtils.uncapitalize((String) o);
    	 }
		if ("trimQuotes".equals(formatString)) {
			String ret = ((String) o).replace("\"","");
			ret = ret.replace("'","");
			return ret;
		}

    	 if (formatString!=null && Pattern.matches("^random\\d+",formatString)) {
    		 String numberOnly = formatString.replaceAll("[^0-9]", "");
    		 int len = NumberUtils.toInt(numberOnly);

    		 return RandomStringUtils.randomNumeric(len).replaceAll("0+", "");
    	 }

    	 if ("today".equals(formatString)) {
    		 return DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss");
    	 }

    	 if ("convertCamel".equals(formatString)) {
    		 String v = (String) o;


    			Pattern pattern = Pattern.compile("[A-Z]+");

    			Matcher m = pattern.matcher(v);
    			String strTmp = new String();

    			while (m.find()){
    				String s = m.group() ;
    				strTmp= strTmp.replace(s, "_"+s);
    			}

    		 return strTmp.toUpperCase();
    	 }
    	 return super.toString(o, formatString, locale);


    }

}
