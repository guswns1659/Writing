package index;

import java.util.Arrays;

public class index{
    public static void main(String[] args) {
        String str = "(3,10)-(4,11)";
        String replaceStr= str.replace("(", "");
        replaceStr = replaceStr.replace(")", "");
        replaceStr = replaceStr.replace("-", ",");
        String[] strarr = replaceStr.split(",");
        System.out.println(Arrays.toString(strarr));
    }
}