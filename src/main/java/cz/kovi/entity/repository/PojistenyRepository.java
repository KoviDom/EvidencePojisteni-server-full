package cz.kovi.entity.repository;

import cz.kovi.entity.PojistenyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PojistenyRepository extends JpaRepository<PojistenyEntity, Long> {
}
