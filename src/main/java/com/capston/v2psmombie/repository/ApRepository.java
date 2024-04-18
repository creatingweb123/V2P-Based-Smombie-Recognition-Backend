package com.capston.v2psmombie.repository;

import com.capston.v2psmombie.domain.Ap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApRepository extends JpaRepository<Ap, Integer> {

    Optional<Ap> findByName(String name);
}
