package cz.kovi.entity.repository;

import cz.kovi.entity.PojisteniEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PojisteniRepository extends JpaRepository<PojisteniEntity, Long> {
}
