package com.pbo.jelantara;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetugasRepository extends JpaRepository<Petugas, Long> {
    Optional<Petugas> findByEmailAndPassword(String email, String password);
    Optional<Petugas> findByEmail(String email);
}
