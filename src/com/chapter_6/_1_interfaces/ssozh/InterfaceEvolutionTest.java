package com.chapter_6._1_interfaces.ssozh;

public class InterfaceEvolutionTest implements ISsozhComparable<InterfaceEvolutionTest>,IClash<InterfaceEvolutionTest>{
    private int id;
    //这个是必须有的，不然会报错，你继承了这个接口却没有提供这个服务
    public int ssozhCompareTo(InterfaceEvolutionTest other){
        return Integer.compare(id,other.id);
    }
    // 下面这个是可以实现的方法，也可以不覆盖的。比如SsozhEmployee没有覆盖，也可以正常编译和运行。因为他default了。
    // 而这里必须实现，应该ISsozhComparable和IClash都有这个方法的接口冲突。
    // 但如果这个类是继承的超类，超类中有这个方法，则优先使用超类中的方法，而忽略接口中的默认方法，这就是类优先原则。同样对于Object中的equal方法和toString方法不要定义默认接口
    public int defaultCompareTo(InterfaceEvolutionTest other){
        return 1;
    }

}
