package records;

/**
 * Created by DCJS
 * 2018/11/14.
 */
public class Test {
    public static void main(String[] args) {
        String phone = "1";
        String candidateName = "33333";
        String jobName ="java ";
        String firstMsg = "已找到候选人电话，电话："+ phone + "候选人：" + candidateName + "（" + (jobName==null?"":jobName) + "）";
        System.out.println(firstMsg);
    }
}
