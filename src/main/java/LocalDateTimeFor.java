import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeFor {

    // 현재 날짜와 시간으로 객체 생성, 2025-12-01T16:27:57.645017
    private static LocalDateTime currentDateTime = LocalDateTime.now();
    // 특정 날짜와 시간으로 객체 생성, 2023-04-10T15:30
    private static LocalDateTime customDateTime = LocalDateTime.of(2023, Month.APRIL, 10, 15, 30);
    // 문자열로부터 객체 생성, 2023-04-10T15:30
    private static LocalDateTime parsedDateTime = LocalDateTime.parse("2023-04-10T15:30:00");

    public static void 날짜_시간_정보() {
        int year = currentDateTime.getYear();                 // 2025
        Month month = currentDateTime.getMonth();             // APRIL
        DayOfWeek dayOfWeek = currentDateTime.getDayOfWeek(); //MONDAY
        int day = currentDateTime.getDayOfMonth();
        int hour = currentDateTime.getHour();                 // 16
        int minute = currentDateTime.getMinute();             // 55
        int second = currentDateTime.getSecond();             // 31
    }

    public static void 날짜_시간_조작() {
        // 다음날
        LocalDateTime tomorrow = currentDateTime.plusDays(1);
        // 한시간 전
        LocalDateTime oneHourAgo = currentDateTime.minusHours(1);
        // 다음달
        LocalDateTime TimeNextMonth = currentDateTime.withMonth(currentDateTime.getMonth().getValue() + 1);
    }

    public static void 날짜_서식_파싱() {
        // yyyy-MM-ddTHH:mm:ss 형식에서 T를 빼고 싶을때 등등 포메터 지정 가능
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        LocalDateTime parsedDateTimeWithFormatter = LocalDateTime.parse("2023-04-10 15:30:00", formatter);
    }

    public static void 날짜_비교() {
        boolean isBefore = currentDateTime.isBefore(customDateTime);
        boolean isAfter = currentDateTime.isAfter(customDateTime);
        boolean isEqual = currentDateTime.isEqual(customDateTime);
    }

    public static void 날짜_시간_분리() {
        // 날짜만 분리
        LocalDate localDate = currentDateTime.toLocalDate(); // 2025-12-01
        // 시간만 분리
        LocalTime localTime = currentDateTime.toLocalTime(); // 16:40:12.562241
    }

    public static void 년_월_일_시간_변경() {
        // 년도 변경, 2027-12-01T16:40:12.561213
        currentDateTime.withYear(2027);
        // 월 변경, 2027-03-01T16:40:12.561213
        currentDateTime.withMonth(3);
        // 일 변경, 2027-12-10T16:40:12.561213, 해당 월에 변경하고자 하는 날이 없으면 예외 발생
        currentDateTime.withDayOfMonth(10);
    }
}
