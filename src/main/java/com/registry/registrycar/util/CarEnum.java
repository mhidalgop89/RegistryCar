package com.registry.registrycar.util;

public enum CarEnum {
    SUNDAY(1),
    MONDAY(2),
    TUESDAY(3),
    WEDNESDAY(4),
    THURSDAY(5),
    FRIDAY(6),
    SATURDAY(7);

    private int day;
    CarEnum(int day){
        this.day = day;
    }

}
