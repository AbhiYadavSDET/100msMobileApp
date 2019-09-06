package Utils.CouponPageEnum;

public enum CouponPageEnum {

    CouponName("1");

    private String value;

    CouponPageEnum(String val) {
        value=val;
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
