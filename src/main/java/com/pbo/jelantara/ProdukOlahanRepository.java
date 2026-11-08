package com.pbo.jelantara;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdukOlahanRepository extends JpaRepository<ProdukOlahan, Long> {
}
