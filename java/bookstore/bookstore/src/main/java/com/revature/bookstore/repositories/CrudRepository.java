package com.revature.bookstore.repositories;

public interface CrudRepository<T> {

    T findById(int id);
    T findByUsername(String userName,String password);
    T save(T newResource);
    boolean update(T updatedResource);
    boolean deleteById(int id);

}
