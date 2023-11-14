package christmas.fix;

public enum BadgePrice {
    SANTA("산타", 20000),
    TREE("트리", 10000),
    STAR("별", 5000);

    private final String badge;
    private final int price;

    BadgePrice(String badge, int price) {
        this.badge = badge;
        this.price = price;
    }

    public String message() {
        return badge;
    }

    public int price() {
        return price;
    }
}
