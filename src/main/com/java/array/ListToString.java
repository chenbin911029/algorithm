package main.com.java.array;


import java.util.List;

public class ListToString {
    public String listToString(List list, char separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(separator);
        }
        return sb.toString().substring(0,sb.toString().length()-1);
    }

    public String listToString2(List list, char separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < list.size(); i++) {
            if (i == list.size() - 1) {
                sb.append(list.get(i));
            } else {
                sb.append(list.get(i));
                sb.append(separator);
            }
        }
        return sb.toString();
    }

    public String listToString3(List list, char separator) {
        return org.apache.commons.lang.StringUtils.join(list.toArray(),separator);
    }
}
