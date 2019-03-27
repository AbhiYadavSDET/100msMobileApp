package Utils.TableEnums;

public enum MemberBalanceEnum {

    BAL("balance"),
    OTHBAL("otherBalance"),
    LYBAL("loyaltyBalance"),
    FUEL("fuel"),
    PHONE("phone"),
    MEDICAL("medical"),
    NONINS("nonInsurance"),
    BUC1("bucket1"),
    BUC2("bucket2"),
    BUC3("bucket3"),
    BUC4("bucket4"),
    BUC5("bucket5"),
    BUC6("bucket6"),
    BUC7("bucket7"),;

    private String columnName;

    MemberBalanceEnum(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }

}