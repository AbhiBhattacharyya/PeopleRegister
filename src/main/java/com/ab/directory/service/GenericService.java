package com.ab.directory.service;

import java.util.List;
import java.util.Map;

public interface GenericService<T,K>  {
    public Map<K,T> save(T element, Map<K,T> map);
    public T getById(K id, Map<K,T> map);
}
