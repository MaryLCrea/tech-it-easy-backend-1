package tv.novi.techiteasy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tv.novi.techiteasy.models.Television;

public interface TelevisionRepository extends JpaRepository<Television, Integer> {

}
