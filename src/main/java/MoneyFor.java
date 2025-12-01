import java.text.NumberFormat;
import java.util.Locale;

public class MoneyFor {
    /**
     * 통화 표시가 필요한 돈일떄 사용하자
     * NumberFormat.getCurrencyInstance() 사용하자
     *
     * 자동으로 이래와 같은 기능을 해준다.
     * 국가별 통화 기호(₩, $)
     * 천 단위 구분
     * 소수점 자리
     * 반올림 규칙
     **/

    public static void 통화표시() {
        // 한국 통화 표시 ₩1,234,568
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.KOREA);
        String result = nf.format(1234567.7);

        // 미국 통화표시 $1,234,567.00
        NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
        String result1 = us.format(1234567);
    }
}
