package com.spring5.springserviceproject.MapService;

import com.spring5.springserviceproject.Model.BaseEntity;

import java.util.*;

public abstract class MapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long,T> map = new HashMap<>();

      T save(T object){

          if(object!=null) {
              if (object.getId() == null)
                  object.setId(getNextId());

              map.put(object.getId(), object);
          }
          else{
              throw new RuntimeException();
          }

          return object;
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

    private Long getNextId(){

          Long nextId = null;

          try{
              nextId= Collections.max(map.keySet())+1;
          }
          catch (NoSuchElementException ex){
              return 1L;
          }

          return nextId;
      }

}
