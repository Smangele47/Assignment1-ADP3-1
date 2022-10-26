package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Chef;

import java.util.List;

@Repository
public interface ChefRepository extends JpaRepository<Chef,String> {
//    List<Chef> findAll();
//
//    Chef update (Chef chef);
//    boolean delete (String ChefID);
}