package com.revature.bookstore.repositories;

public interface CrudRepository<T> {

    T findById(int id);
    int getNextId();
    T save(T newResource);
    boolean update(T updatedResource);
    boolean deleteById(int id);

}
