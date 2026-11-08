package com.pbo.jelantara;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PusatRepository extends JpaRepository<Pusat, Long> {
    Optional<Pusat> findByEmailAndPassword(String email, String password);
    Optional<Pusat> findByEmail(String email);
}
