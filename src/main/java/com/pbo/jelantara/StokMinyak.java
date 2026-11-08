package com.pbo.jelantara;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import java.time.LocalDate;

@Entity
@Table(name = "stok_minyak")
public class StokMinyak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_stok")
    private Long idStok;

    @Column(name = "jumlah_minyak", nullable = false)
    private Double jumlahMinyak;

    @Column(name = "batas_stok", nullable = false)
    private Double batasStok;

    @Column(name = "jumlah_update", nullable = false)
    private Double jumlahUpdate;

    @Column(name = "tgl_update", nullable = false)
    private LocalDate tglUpdate;

    @ManyToOne
    @JoinColumn(name = "penjualan_id")
    private Penjualan penjualan;

    @ManyToOne
    @JoinColumn(name = "pusat_id")
    private Pusat pusat;

    public Long getIdStok() { return idStok; }
    public void setIdStok(Long idStok) { this.idStok = idStok; }
    public Double getJumlahMinyak() { return jumlahMinyak; }
    public void setJumlahMinyak(Double jumlahMinyak) { this.jumlahMinyak = jumlahMinyak; }
    public Double getBatasStok() { return batasStok; }
    public void setBatasStok(Double batasStok) { this.batasStok = batasStok; }
    public Double getJumlahUpdate() { return jumlahUpdate; }
    public void setJumlahUpdate(Double jumlahUpdate) { this.jumlahUpdate = jumlahUpdate; }
    public LocalDate getTglUpdate() { return tglUpdate; }
    public void setTglUpdate(LocalDate tglUpdate) { this.tglUpdate = tglUpdate; }
    public Penjualan getPenjualan() { return penjualan; }
    public void setPenjualan(Penjualan penjualan) { this.penjualan = penjualan; }
    public Pusat getPusat() { return pusat; }
    public void setPusat(Pusat pusat) { this.pusat = pusat; }
}
