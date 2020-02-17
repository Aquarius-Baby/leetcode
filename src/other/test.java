package other;

import java.util.*;

public class test {
    public static void main(String[] args) {

        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        hashMap.put(1, 3);
        hashMap.put(5, 1);
        hashMap.put(2, 8);
        hashMap.put(4, 3);
        System.out.println("============HashMap=============");

        for (Integer integer : hashMap.keySet()) {
            System.out.println(integer + " : " + hashMap.get(integer));
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>((n1, n2) -> n2 - n1);
        treeMap.put(1, 3);
        treeMap.put(5, 1);
        treeMap.put(2, 8);
        treeMap.put(4, 3);
        System.out.println("============TreeMap=============");

        for (Integer integer : treeMap.keySet()) {
            System.out.println(integer + " : " + treeMap.get(integer));
        }

        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, 3);
        linkedHashMap.put(5, 1);
        linkedHashMap.put(2, 8);
        linkedHashMap.put(4, 3);

        System.out.println("============LinkedHashMap=============");
        linkedHashMap.get(5);

        for (Integer integer : linkedHashMap.keySet()) {
            System.out.println(integer + " : " + linkedHashMap.get(integer));
        }

        LinkedHashMap<Integer, Integer> linkedHashMap2 = new LinkedHashMap<Integer, Integer>(10, (float) 0.75, true);
        linkedHashMap2.put(1, 3);
        linkedHashMap2.put(5, 1);
        linkedHashMap2.put(2, 8);
        linkedHashMap2.put(4, 3);

        System.out.println("============linkedHashMap2=============");
        linkedHashMap2.get(5);

        // 不能使用keyset进行遍历，会报错
        // 原因是,在迭代过程中如果操作了当前的元素，
        // 根据LinkedHashMap访问顺序的规则，当前的元素会被放到最后面，
        // 当执行下次循环时，就是去获取最后一个元素的后一个元素，所以会报错。
        Iterator<Map.Entry<Integer, Integer>> iterator = linkedHashMap2.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> t = iterator.next();
            System.out.println(t.getKey() + " : " + t.getValue());
        }

    }
}
