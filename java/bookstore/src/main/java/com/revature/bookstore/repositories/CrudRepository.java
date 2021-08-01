package com.revature.bookstore.repositories;


public interface CrudRepository<T> {

    T findById(int i);
    T save(T newResource);
    boolean update(T updatedResource);
    boolean deleteById(int id);

}
