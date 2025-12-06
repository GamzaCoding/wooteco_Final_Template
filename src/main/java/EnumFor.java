public enum EnumFor {
    GOLD("골드", 10_000),
    SILVER("실버", 5_000),
    BRONZE("브론즈", 0)
    ;

    private final String name;
    private final int money;

    EnumFor(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }
    public int getMoney() {
        return money;
    }
}
