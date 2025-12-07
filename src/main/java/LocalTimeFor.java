import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalTimeFor {
    public static void main(String[] args) {
        // 시간 생성
        LocalTime now = LocalTime.now(); // 11:57:33.049876
        LocalTime localTime = LocalTime.of(12, 30, 12); // 12:30:12

        // 파싱
        LocalTime parse = LocalTime.parse("22:12:30");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH-mm-ss");
        LocalTime parsed = LocalTime.parse("23-12-45", dateTimeFormatter);

        // 시간, 분, 초 얻기
        int hour = localTime.getHour();// 12
        int minute = localTime.getMinute(); // 30
        int second = localTime.getSecond(); // 12
        int nano = localTime.getNano(); // 049876

        // 시간 비교
        LocalTime localTime1 = LocalTime.of(12, 30, 0);
        LocalTime localTime2 = LocalTime.of(13, 40, 0);

        boolean after = localTime1.isAfter(localTime2);// false
        boolean before = localTime1.isBefore(localTime2);// true

        // 시간 더하기
        LocalTime localTime3 = localTime.plusHours(2);// 14:30:12
        LocalTime localTime4 = localTime.plusMinutes(30);// 13:00:12
        LocalTime localTime5 = localTime.plusSeconds(30);// 12:30:42

        // 시간 빼기
        LocalTime localTime6 = localTime.minusHours(2);// 10:30:12
        LocalTime localTime7 = localTime.minusMinutes(30);// 12:00:12
        LocalTime localTime8 = localTime.minusSeconds(30);// 12:29:42

        // 두 시간 차이
        LocalTime time1 = LocalTime.of(12, 30, 30);
        LocalTime time2 = LocalTime.of(13, 30, 30);

        Duration between = Duration.between(time1, time2);
        long seconds = between.getSeconds(); // 3600

        long diffHours = ChronoUnit.HOURS.between(time1, time2); // 1
        long diffMinutes = ChronoUnit.MINUTES.between(time1, time2); // 60
        long diffSeconds = ChronoUnit.SECONDS.between(time1, time2); // 3600
    }
}
