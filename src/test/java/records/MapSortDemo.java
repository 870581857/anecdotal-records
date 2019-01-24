package records;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class MapSortDemo {

    public static void main(String[] args) {

        Map<String, String> map = new TreeMap<String, String>();

        map.put("5年以上", "kfc");
        map.put("1-2年", "wnba");
        map.put("1年以下", "nba");
        map.put("2-5年", "cba");

        Map<String, String> resultMap = sortMapByKey(map);    //按Key进行排序

        for (Map.Entry<String, String> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    
    /**
     * 使用 Map按key进行排序
     * @param map
     * @return
     */
    public static Map<String, String> sortMapByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        Map<String, String> sortMap = new TreeMap<String, String>(
                new MapKeyComparator());

        sortMap.putAll(map);

        return sortMap;
    }
}


class MapKeyComparator implements Comparator<String> {

//    @Override
//    public int compare(String str1, String str2) {
//        Integer a = Integer.parseInt(str1);
//        Integer b = Integer.parseInt(str2);
//        return a.intValue()-b.intValue();
//    }

//    @Override
//    public int compare(String str1, String str2) {
//        return str1.compareTo(str2);
//    }

    @Override
    public int compare(String str1, String str2) {
        int a = 0;
        int b = 0;
        if(str1.equals("5年以上")){
            a = 4;
        }else if(str1.equals("2-5年")){
            a = 3;
        }else if(str1.equals("1-2年")){
            a = 2;
        }else if(str1.equals("1年以下")){
            a = 1;
        }

        if(str2.equals("5年以上")){
            b = 4;
        }else if(str2.equals("2-5年")){
            b = 3;
        }else if(str2.equals("1-2年")){
            b = 2;
        }else if(str2.equals("1年以下")){
            b = 1;
        }

        return b-a;
    }

}