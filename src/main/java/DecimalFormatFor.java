import java.text.DecimalFormat;

public class DecimalFormatFor {
    /**
     * 돈, 퍼센트 등 포메팅 할때 사용
     * 날짜는 LocalDateTime 사용하자
     * 자바에서는 숫자의 Format을 변경할 수 있는 클래스를 제공한다.
     */

    public static void 포멧들(){
        // 100을 곱하고 뒤에 %를 넣어준다.
        DecimalFormat df = new DecimalFormat("#.##%");
        df.format(0.1234); // 12.34%
        df.format(1); // 100%
        df.format(2); // 200%
        df.format(0.5); // 50%

        // "12.30%" 같이 소수점 이하 두 자리를 항상 유지하려면
        DecimalFormat dff = new DecimalFormat("0.00%");
        dff.format(0.1234); // 12.34%
        dff.format(0.5); // 50.00%

        // 돈 : 천원 단위 콤마 넣기 + 원
        DecimalFormat dfff = new DecimalFormat("#,###원");
        dfff.format(100000000); // 100,000,000원
    }
}
