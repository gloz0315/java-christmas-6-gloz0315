package christmas.fix;

public enum UnitView {

    WON("원"),
    NUMBER("개");

    private final String unit;

    UnitView(String unit) {
        this.unit = unit;
    }

    public String message() {
        return unit;
    }
}
