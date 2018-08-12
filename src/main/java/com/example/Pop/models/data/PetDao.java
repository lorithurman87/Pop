package com.example.Pop.models.data;

import com.example.Pop.models.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface PetDao extends CrudRepository<Pet, Integer> {

    public List<Pet> findById(int petId);
}
