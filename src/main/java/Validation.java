import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Validation {

    public static void 돈_검즘(String input) {
        // "0", "7", "12345", "01" 가능
        Pattern MONEY_REGEX = Pattern.compile("^[0-9]+$");
        if (!MONEY_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException("0 이상의 자연수를 입력해야 합니다.");
        }
    }

    public static void 특정_버튼만_누르기_검증(String inputCommand) {
        // "R", "Q" 이거만 가능, "RQ" 불가능
        Pattern MOVE_COMMAND_REGEX = Pattern.compile("^([RQ])$");
        if (!MOVE_COMMAND_REGEX.matcher(inputCommand).matches()) {
            throw new IllegalArgumentException("R 또는 Q 버튼만 입력 가능합니다.");
        }
    }

    public static void 문자열에_특정문자_포함_검증(String input) {
        // "009", "3", "66", "123" 가능
        Pattern CONTAINS_369_REGEX = Pattern.compile(".*[369].*");
        if (!CONTAINS_369_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException("3,6,9 중 하나 이상의 문자가 매칭되는게 없습니댜.");
        }
    }

    public static void 중복문자_검사(String input) {
        // "123", "QWE" 가능, "122", "333", "QQ" 불가능
        long distinctCount = input.chars()
                .distinct()
                .count();
        if (distinctCount != input.length()) {
            throw new IllegalArgumentException("중복 문자가 포함되어 있습니다: " + input);
        }
    }

    public static void 리스트에_중복값_검사() {
        List<String> sampleList1 = List.of("a", "a", "b");
        List<String> sampleList2 = List.of("a", "b", "c");

        long distinctCount = sampleList1.stream()
                .distinct()
                .count();
        if (distinctCount != sampleList1.size()) {
            throw new IllegalArgumentException("리스트안에 중복값이 있습니다.");
        }
    }

    // set을 활용한 중복값 검사
    public static void validateDuplicateNumber(List<Integer> numbers) {
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException("값이 중복입니다.");
        }
    }

    private static boolean isDuplicate(List<Integer> numbers) {
        return numbers.size() != Set.copyOf(numbers).size();
    }
}
