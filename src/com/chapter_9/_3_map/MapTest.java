package com.chapter_9._3_map;

import com.chapter_5._3_equals.Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        Map<String, Employee> staff = new HashMap<>();
        staff.put("144-24-5464", new Employee("Amy Lee"));
        staff.put("567-24-2546", new Employee("Harry Hacker"));
        staff.put("159-64-7935", new Employee("Gary Cooper"));
        staff.put("456-62-5527", new Employee("Francesca Cruz"));

        // print all entries
        System.out.println(staff);
//        staff.forEach((k,v)->
//                System.out.println("key="+k+",value="+v));

        //remove an entry
        staff.remove("567-24-2546");  // return null ?

        //replace an entry
        staff.put("456-62-5527",new Employee("Francesca Miller"));

        //look up a value
        System.out.println(staff.get("157-62-7935"));  // 如果找不到则默认返回null，也可以使用方法getOrDefault

        // iterate through all entries
        staff.forEach((k,v)->
                System.out.println("key="+k+",value="+v));

        //视图：keySet, values, entrySet 三个方法。
        Set<String> keys = staff.keySet();
        /** keySet是一个共有方法，他会返回一个keySet类（在HashMap中的实现），final class KeySet extends AbstractSet<K>
         *     public Set<K> keySet() {
         *         Set<K> ks = keySet;
         *         if (ks == null) {
         *             ks = new KeySet();
         *             keySet = ks;
         *         }
         *         return ks;
         *     }
         */
        for(String key:keys){
            System.out.println(key);
        }

    }
}

