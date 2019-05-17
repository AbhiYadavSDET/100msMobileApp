package main.java.utils;

public enum DateFormatEnums {
    DD_MM_YYYY("dd-MM-yyyy"),
    DD_MMM_YYYY("dd MMM yyyy"),
    YYYY_MM_DD("yyyy-MM-dd"),
    DDMMYYYY("ddMMyyyy"),
    DDMMYYYYHHMMSS("ddMMyyyyHHmmSS"),
    YYYY_MM_DD_HH_MM_SS("yyyy-MM-dd HH:mm:SS"),
    DD_MM_YYYY_HH_MM_SS("dd-MM-yyyy-HH-mm-SS");

    String value;

    public String getValue() {
        return this.value;
    }

    private DateFormatEnums(String value) {
        this.value = value;
    }
}
