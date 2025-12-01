import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalFor {
    /**
     * 돈, 소수점, 반올림등 숫자 빡세게 나올때 사용
     * 소수점 처리를 하지 않으면 특정 연산 시 ArithmeticException이 발생할 주의
     */
    public static void 생성() {
        // 객체 생성은 무조건 아래 3개중 하나!!, 절대로 double를 통해서 생성하면 안된다.
        BigDecimal bigDecimal = new BigDecimal("200");
        BigDecimal zero = BigDecimal.ZERO;
        BigDecimal bigDecimal1 = new BigDecimal(String.valueOf(300_000_000));
    }

    public static void 반올림() {
        BigDecimal bigDecimal = new BigDecimal("20.1657");
        // 소수점 아래 첫번째 자리까지
        BigDecimal bigDecimal1 = bigDecimal.setScale(1, RoundingMode.HALF_EVEN); // 20.2
        // 소수점 아래 두번째 자리까지
        BigDecimal bigDecimal2 = bigDecimal.setScale(2, RoundingMode.HALF_EVEN); // 20.17
        // 소수점 아래 세번째 자리까지
        BigDecimal bigDecimal3 = bigDecimal.setScale(3, RoundingMode.HALF_EVEN); // 20.166
    }

    public static void 사칙연산_등() {
        BigDecimal a = new BigDecimal(10);
        BigDecimal b = new BigDecimal(3);
        // 더하기
        BigDecimal add = a.add(b); // 10 + 3 = 13
        // 빼기
        BigDecimal subtract = a.subtract(b); // 10 - 3 = 7
        // 곱하기
        BigDecimal multiply = a.multiply(b); // 10 * 3 = 30
        // 나누기, 소수점 아래 첫째자리까지, 반올림
        BigDecimal divide = a.divide(b, 1, RoundingMode.HALF_EVEN); // 10 / 3 = 3.3
        // 나머지(%)
        BigDecimal remainder = a.remainder(b); // 10 % 3 = 1
        // 절대값
        BigDecimal abs = new BigDecimal("-3").abs(); // 3
        // 최대값, 최소값
        BigDecimal max = a.max(b); // 10, 3 중 최대값
        BigDecimal min = a.min(b); // 10, 3 중 최소값
        // 부호변경
        BigDecimal negate = a.negate(); // -10;
    }

    public static void 비교연산() {
        BigDecimal a = new BigDecimal("3.14"); // unscaled value = 314, scale = 2
        BigDecimal b = new BigDecimal("3.140"); // unscaled value = 314, scale = 3

        // 주솟값을 비교한다
        System.out.println(a == b); // false

        // unscaled value와 scale을 비교한다 (값과 소수점 자리까지 함께 비교)
        a.equals(b); // false

        // unscaled value만 비교한다 (값만 비교), 반환값 1, 0, -1
        a.compareTo(b); // 0
    }

    private static BigDecimal 퍼센트계산(BigDecimal totalCashPrize, BigDecimal ticketBudget) {
        if (ticketBudget.equals(BigDecimal.ZERO)) {
            return BigDecimal.ZERO;
        }
        // 퍼센트 구하기 : (총금액 * 100) / 티켓값 , 소수점 아래 두번째 자리에서 반올림
        return totalCashPrize.multiply(new BigDecimal("100")).divide(ticketBudget, 1, RoundingMode.HALF_EVEN);
    }
}
