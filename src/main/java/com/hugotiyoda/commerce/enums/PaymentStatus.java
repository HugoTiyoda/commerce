package com.hugotiyoda.commerce.enums;

public enum PaymentStatus {
    PENDING (1, "Pending"),
    PAID(2,"Paid"),
    CANCELED(3, "Canceled");

    int code;
    String description;

    PaymentStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static PaymentStatus toEnum(Integer code) {
        if (code == null) return null;

        for (PaymentStatus i : PaymentStatus.values()) {
            if (code.equals(i.getCode())){
                return i;
            }
        }
        throw new IllegalArgumentException("Invalid ID");
    }
}
