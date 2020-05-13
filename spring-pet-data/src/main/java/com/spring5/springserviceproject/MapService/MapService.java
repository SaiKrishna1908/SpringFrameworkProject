package com.spring5.springserviceproject.MapService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class MapService<T, ID> {

    protected Map<ID,T> map = new HashMap<>();

      T save(ID id, T object){
        return map.put(id, object);
    }

     Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
          return map.get(id);
    }

    void deleteById(ID id){
          map.remove(id);
    }

    void delete(T object){
          map.entrySet().removeIf(idtEntry -> idtEntry.getValue().equals(object));
    }

}
