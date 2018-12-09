package records;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xf
 * 2018/12/7.
 */
public class PassCode {

    private final static char[] strDigits = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private final static int base = 52;

    /**
     * 加密
     **/
    public static String enCode(int num) {
        List<Integer> out = new ArrayList();
        int numTemp = num;
        while (true) {
            int rmd = numTemp % base;
            numTemp = numTemp / base;
            out.add(rmd);
            if (numTemp == 0) {
                break;
            }
        }
        Collections.reverse(out);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < out.size(); i++) {
            sb.append(strDigits[out.get(i)]);
        }
        return sb.toString();
    }

    /**
     * 解密
     **/
    public static Integer deCode(String enCode) {
        List<Integer> list = new ArrayList();
        char terms[] = enCode.toCharArray();
        for (int i = 0; i < terms.length; i++) {
            for (int j = 0; j < strDigits.length; j++) {
                if (terms[i] == strDigits[j]) {
                    list.add(j);
                    continue;
                }
            }
        }

        int out = 0;
        for (int i = 0; i < list.size(); i++) {
            out = (int) (out + list.get(i) * Math.pow(base, list.size() - i - 1));
        }
        return out;
    }

    public static void main(String[] args) {
        int a = 934342234;
        String out = enCode(a);
        System.out.println(out);
        System.out.println(deCode(out));
    }
}
