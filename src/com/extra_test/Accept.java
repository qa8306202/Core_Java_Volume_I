package com.extra_test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * accept()  exists in Consumer interface, which is used to accept  the "input" entry to "action".
 * the code citing:https://www.geeksforgeeks.org/java-8-consumer-interface-in-java-with-examples/
 *
 *     /**
 *      * Performs this operation on the given arguments.
 *      *
 *      * @param t the first input argument
 *      * @param u the second input argument
 *       void accept(T t,U u);
 */
public class Accept {
    public static void main(String args[])
    {
        // Consumer to display a number
        Consumer<Integer> display = a -> System.out.println(a);

        // Implement display using accept()
        display.accept(10);

        // learn foreach from dynamic debug
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<11;i++)
            list.add(i);
        list.forEach(a->{
            // ArrayList实现类中有一个forEach,forEach中有final Object[] es = elementData;
            // elementData就是list这个实例对象中的全部数据。然后通过for循环“喂”给sout这个“动作”
            System.out.println(a);
        });

        Map<String,Integer> maps = new HashMap<>();
        maps.put("ssozh",1);
        maps.put("azhang",2);
        maps.put("shuang",3);
        // 1. HashMap默认创建了一个Node[]大小为16，名字为tab
        // 2. 将maps这个实力类中的table放入 tab -->可以通过反射setAccessible(true)来访问table了解内部结构
        // 3. 遍历tab，执行"action"
        maps.forEach((k,v)->{
            System.out.println(k);
        });

//        // Consumer to multiply 2 to every integer of a list
//        Consumer<List<Integer>> modify = list ->
//        {
//            for (int i = 0; i < list.size(); i++)
//                list.set(i, 2 * list.get(i));
//        };
//
//        // Consumer to display a list of numbers
//        Consumer<List<Integer> >
//                dispList = list -> list.stream().forEach(a -> System.out.print(a + " "));
//
//        List<Integer> list = new ArrayList<Integer>();
//        list.add(2);
//        list.add(1);
//        list.add(3);
//
//        // Implement modify using accept()
//        modify.accept(list);
//
//        // Implement dispList using accept()
//        dispList.accept(list);

    }

}
