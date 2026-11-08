package com.pbo.jelantara;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenjualRepository extends JpaRepository<Penjual, Long> {
    Optional<Penjual> findByEmail(String email);
}
