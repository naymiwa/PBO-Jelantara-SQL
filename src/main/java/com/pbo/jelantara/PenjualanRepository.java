package com.pbo.jelantara;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenjualanRepository extends JpaRepository<Penjualan, Long> {
    List<Penjualan> findByPenjualIdPenjualOrderByTanggalTransaksiDesc(Long idPenjual);
    List<Penjualan> findByStatusOrderByIdTransaksiDesc(String status);
    List<Penjualan> findByStatusNotOrderByIdTransaksiDesc(String status);
}
