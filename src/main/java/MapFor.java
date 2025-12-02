import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapFor {

    public static void mapCreate() {
        // map 생성, 저장순서가 유지되지 않는다. key는 유일, value는 중복 가능
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>(map1); //map1의 모든 값을 가진 HashMap생성
        Map<String, String> map3 = new HashMap<>(10); //초기 용량(capacity)지정

        // map 삽입, 삭제, 전부삭제
        map1.put("1", "철수");
        map1.remove("1");
        map1.clear();
        map1.putAll(map2); // 지정된 map2의 모든 key-value쌍을 추가

        // key로 꺼내보고 없으면 디퐅트 값을 반환한다.
        map1.getOrDefault("1", "없습니다.");
        String s = map1.get("1");

        // key, value 확인
        boolean b = map1.containsKey("1"); // 지정된 key객체와 일치하는 객체가 있는지 확인
        boolean b1 = map1.containsValue("철수"); // 지정된 value객체와 일치하는 객체가 있는지 확인

        // map을 순환하면서 출력
        Set<Entry<String, String>> entries = map1.entrySet();
        for (Entry<String, String> entry : entries) {
            entry.getKey();
            entry.getValue();
        }
    }

    /**
     * Enum 타입만 key로 사용 가능한 특별한 Map
     * null을 key로 넣는 경우 NullPointerException 발생
     * key에 들어갈 값을 생성 시 정의하기 때문에 Enum 타입 외에는 key로 만들 수 없다.
     */
    public static void enumMap() {
        // EnumMap은 생성 시 Rank에 정의된 순서를 따른다.
        EnumMap<Rank, Object> rankObjectEnumMap = new EnumMap<>(Rank.class);

        // 이렇게 저장해도 Rank의 순서를 따라 enumMap에 저장된다.
        rankObjectEnumMap.put(Rank.second, "둘");
        rankObjectEnumMap.put(Rank.third, "셋");
        rankObjectEnumMap.put(Rank.first, "첫");

        rankObjectEnumMap.entrySet().stream().forEach(System.out::println);
        // first=첫
        // second=둘
        // third=셋
    }

    public enum Rank {
        first, second, third
    }
}
