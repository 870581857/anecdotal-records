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
        try{
            System.out.println("11111111111111111");
            return 1;
        }catch (Exception e){
            System.out.println("222222222222222222");
        }finally {
            System.out.println("333333333333333333");
        }

        return 0;
    }
}
