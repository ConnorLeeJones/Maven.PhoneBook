package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    Map<String, List<String>> map;

    public PhoneBook(Map<String, List<String>> map) {
        this.map = map;
    }

    public PhoneBook() {
        this(new LinkedHashMap<>());
    }

    public void add(String name, String phoneNumber) {
        if (map.containsKey(name)){
            map.get(name).add(phoneNumber);
        } else {
            map.put(name, new ArrayList<>());
            map.get(name).add(phoneNumber);
        }
    }

    public void addAll(String name, String... phoneNumbers) {
        map.put(name, Arrays.asList(phoneNumbers));
    }

    public void remove(String name) {
        map.remove(name);
    }

    public Boolean hasEntry(String name) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            for (String number : entry.getValue()) {
                if (number.equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<String> lookup(String name) {
        return map.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for (Map.Entry<String, List<String>> entry : map.entrySet()){
            for (String number : entry.getValue()){
                if (number.equals(phoneNumber)){
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        ArrayList<String> allNames = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : map.entrySet()){
            allNames.add(entry.getKey());
        }
        return allNames;
    }

    public Map<String, List<String>> getMap() {
        return map;
    }
}
