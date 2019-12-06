package com.chapter_6._1_interfaces.ssozh;

public interface ISsozhComparable<T> {
    public int ssozhCompareTo(T other);
    public default int  defaultCompareTo(T other) {return 0;}
}

