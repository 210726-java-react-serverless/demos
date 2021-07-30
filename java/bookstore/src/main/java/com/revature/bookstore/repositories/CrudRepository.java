package com.revature.bookstore.repositories;

public interface CrudRepository<T> {

    T FindByID(int id);
    T Save(T newResource);
    boolean Update(T updatedResource);
    boolean DeleteById(int id);
}
