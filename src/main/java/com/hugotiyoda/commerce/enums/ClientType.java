package com.hugotiyoda.commerce.enums;

public enum ClientType {
    NATURALPERSON(1, "Natural person"),
    LEGALPERSON(2, "Legal Person");



    int code;
    String description;

    ClientType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static ClientType toEnum(Integer code) {
        if (code == null) return null;

        for (ClientType i : ClientType.values()) {
            if (code.equals(i.getCode())){
                return i;
            }
        }
        throw new IllegalArgumentException("Invalid ID");
    }
}
