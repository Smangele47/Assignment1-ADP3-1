package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Meal;

import java.util.List;
@Repository
public interface MealRepository extends JpaRepository<Meal,String> {
//    List<Meal> findAll();
//
//    T create(T t);
//    T read(ID id);
//    T update(T t);
//    boolean delete(ID id);

//    Meal update (Meal meal);
//    boolean delete (String MealCode);
}
