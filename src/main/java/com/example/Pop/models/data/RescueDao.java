package com.example.Pop.models.data;

import com.example.Pop.models.Rescue;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


@Repository
@Transactional
public interface RescueDao extends CrudRepository<Rescue, Integer> {

    public List<Rescue> findByUsername(String username);
}
