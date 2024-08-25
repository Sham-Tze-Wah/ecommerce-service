package com.sham.ecommerceservice.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoneyUtils {
    public static boolean validateMoneyFormat(String money){
        String regex = "^\\d+(\\.\\d{1,2})?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(money);

        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }
}
