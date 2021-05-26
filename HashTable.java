package com.company;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashTable {
    public static void main (String args[]){
        Enumeration nums;

        Hashtable <String, Integer> map = new Hashtable<>();
        map.put("bir",1);
        map.put("eki",2);
        map.put("yw",3);
        map.put("tort",4);
        map.put("bes",5);

        nums = map.keys();
        System.out.println("Keys are :");
        while(nums.hasMoreElements()){
            System.out.print(nums.nextElement() + " ");
        }
        System.out.println();

        nums = map.elements();
        System.out.println("Values are :");
        while(nums.hasMoreElements()){
            System.out.print(nums.nextElement() + " ");
        }

        System.out.println();
        System.out.println("Hashtable contains a key bir? : "+map.containsKey("bir"));
        System.out.println("Hashtable contains a value 2? : "+map.containsValue(2));
        System.out.println("Value for key Jyw : "+map.get("yw"));
        map.putIfAbsent("nol",0);

        String key;
        nums = map.keys();
        while(nums.hasMoreElements()) {
            key = (String) nums.nextElement();
            System.out.println("Kazakh: " + key + " Numerical: " +
                    map.get(key));
        }

    }
}