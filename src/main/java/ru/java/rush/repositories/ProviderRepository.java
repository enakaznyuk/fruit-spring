package ru.java.rush.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.java.rush.entities.ProviderEntity;

@Repository
public interface ProviderRepository extends JpaRepository<ProviderEntity,Integer> {
}
