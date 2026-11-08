package com.pbo.jelantara;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenukaranPoinRepository extends JpaRepository<PenukaranPoin, Long> {
    List<PenukaranPoin> findByPenjualIdPenjualOrderByTglPenukaranDesc(Long idPenjual);
}
