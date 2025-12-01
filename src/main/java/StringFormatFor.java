public class StringFormatFor {
    /**
     * %s → 문자열(String)
     * %d → 정수(int, long)
     * %f → 실수(float, double)
     * %c → 문자(char)
     * %n → 줄바꿈(플랫폼 독립적)
     * String.format("실수: %.2f", 3.14159) -> 실수: 3.14
     */

    public static void 정렬() {
        // 오른쪽 정렬, 10은 문자열 10칸 확라는 뜻
        System.out.println(String.format("|%10s|", "Java"));  // |      Java|
        // 왼쪽 정렬
        System.out.println(String.format("|%-10s|", "Java")); // |Java      |
    }

    public static void 포메팅() {
        int number = 1234;
        // 돈에 천원단위로 컴마 붙이기 #,### 형태
        System.out.println(String.format("%,d", number)); // 1,234
    }
}
