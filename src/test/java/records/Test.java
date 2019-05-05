package records;

/**
 * Created by DCJS
 * 2019/1/16.
 */
public class Test {
    public static void main(String[] args) {
        ttt();
    }

    public static int ttt(){
        String tradeNo = "PgiqBYwrZ8CUmrqlTryq20190416";
        String key = String.format("hash_payorders_%s", tradeNo.substring(24, 26));
        System.out.println(key);
        return 0;
    }
}
