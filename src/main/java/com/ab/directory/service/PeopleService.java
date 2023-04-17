package com.ab.directory.service;

import com.ab.directory.model.Child;
import com.ab.directory.model.People;

import java.util.Map;
import java.util.TreeSet;

public class PeopleService implements GenericService<People,String>, GenericChildService<Child,People,String,Boolean>{

    @Override
    public Map<String,People> save(People people, Map<String,People> peopleMap) {
        peopleMap.put(people.getSsn(),people);
        return peopleMap;
    }
    @Override()
    public People getById(String id, Map<String,People> peopleMap) {
        if(!peopleMap.isEmpty() && peopleMap.containsKey(id)){
            return peopleMap.get(id);
        }
        return null;
    }

    @Override
    public Child getFirstChild(String key, Map<String, People> map) {
        People people = getById(key,map);
        if(null != people){
            if(null != people.getChildern()){
                return people.getChildern().first();
            }
        }
        return null;
    }

    @Override
    public TreeSet<Child> getAllChildren(String key, Map<String, People> map) {
        People people = getById(key,map);
        if(null != people){
            return people.getChildern();
        }
        return null;
    }

    @Override
    public Boolean addSingleChild(String key, Map<String, People> map, Child child) {
        People people = getById(key,map);
        if(null != people){
            people.addChildernItem(child);
            return true;
        }
        return false;
    }

    @Override
    public Boolean addAllChildren(String key, Map<String, People> map, TreeSet<Child> children) {
        People people = getById(key,map);
        if(null != people){
            people.setChildern(children);
            return true;
        }
        return false;
    }
}
