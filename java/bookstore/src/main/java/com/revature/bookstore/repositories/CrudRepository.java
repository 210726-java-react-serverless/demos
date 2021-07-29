package com.revature.bookstore.repositories;

public interface CrudRepository<T> {

<<<<<<< HEAD


=======
>>>>>>> 846980801a1c42168f47cf961a68229b941ed89f
    T findById(int id);
    T save(T newResource);
    boolean update(T updatedResource);
    boolean deleteById(int id);
<<<<<<< HEAD
=======

>>>>>>> 846980801a1c42168f47cf961a68229b941ed89f
}
