package com.ab.directory.service;


import java.util.Map;
import java.util.TreeSet;

public interface GenericChildService<E,T,K,S> {
    public E  getFirstChild(K key, Map<K,T> map);
    public TreeSet<E> getAllChildren(K key, Map<K,T> map);
    public S addSingleChild(K key, Map<K,T> map,E child);
    public S addAllChildren(K key,Map<K,T> map,TreeSet<E> children);
}
