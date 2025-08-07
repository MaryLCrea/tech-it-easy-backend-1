package tv.novi.techiteasy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tv.novi.techiteasy.models.Television;

import java.util.List;

public interface TelevisionRepository extends JpaRepository<Television, Long> {

    List<Television> findAllTelevisionsByBrandEqualsIgnoreCase(String brand);
}
