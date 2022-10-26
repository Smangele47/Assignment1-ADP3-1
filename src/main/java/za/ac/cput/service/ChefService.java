package za.ac.cput.service;

import za.ac.cput.domain.Chef;
import java.util.List;

public interface ChefService extends IService <Chef, String> {

    List<Chef> findAll();
}
