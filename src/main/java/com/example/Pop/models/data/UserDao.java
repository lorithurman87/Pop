package com.example.Pop.models.data;

import com.example.Pop.models.User;
import org.springframework.stereotype.Repository;
//import javax.transaction.Transactional;
//import org.springframework.data.repository.CrudRepository;

import java.util.List;


@Repository
//@Transactional
public interface UserDao /*extends CrudRepository<User, Integer> */{

    public List<User> findByUsername(String username);
}
//public class UserDao { }


