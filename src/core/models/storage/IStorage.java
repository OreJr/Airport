package core.models.storage;

import java.util.List;

public interface IStorage<T, ID> { 
    boolean exists(ID id);
    boolean add(T entity); 
    T get(ID id); 
    T getOriginal(ID id); 
    List<T> getAll(); 
    List<ID> getAllEntityIds();
}