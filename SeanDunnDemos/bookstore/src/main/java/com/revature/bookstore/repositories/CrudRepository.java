package com.revature.bookstore.repositories;

public interface CrudRepository<T> {



    // implicitly public and abstract, can't be anything else
    T findById(int id);
    T save(T newResource, int id);
    boolean update(T updatedResource);
    boolean deleteById(int id);

}
