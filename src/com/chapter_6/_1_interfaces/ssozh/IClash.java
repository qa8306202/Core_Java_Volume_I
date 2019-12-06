package com.chapter_6._1_interfaces.ssozh;

public interface IClash<T>{
    public default int defaultCompareTo(T other){return 1;}
}
