package com.pbo.jelantara;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;

import java.time.LocalDate;

@Entity
@Table(name = "penjualan")
public class Penjualan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaksi")
    private Long idTransaksi;

    @Column(name = "tanggal_transaksi", nullable = false)
    private LocalDate tanggalTransaksi;

    @Column(name = "jumlah_minyak", nullable = false)
    private Double jumlahMinyak;

    @Column(name = "jenis_minyak", nullable = false)
    private String jenisMinyak;

    @Column(name = "lokasi_penjemputan", nullable = false)
    private String lokasiPenjemputan;

    @Column(name = "catatan")
    private String catatan;

    @Column(name = "foto")
    private String foto;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "hasil_point")
    private Integer hasilPoint;

    @Column(name = "total_harga")
    private Double totalHarga;

    @Column(name = "harga_minyak", nullable = false)
    private Double hargaMinyak;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "penjual_id", nullable = false)
    private Penjual penjual;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "petugas_id")
    private Petugas petugas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pusat_id")
    private Pusat pusat;

    public Long getIdTransaksi() { return idTransaksi; }
    public void setIdTransaksi(Long idTransaksi) { this.idTransaksi = idTransaksi; }
    public LocalDate getTanggalTransaksi() { return tanggalTransaksi; }
    public void setTanggalTransaksi(LocalDate tanggalTransaksi) { this.tanggalTransaksi = tanggalTransaksi; }
    public Double getJumlahMinyak() { return jumlahMinyak; }
    public void setJumlahMinyak(Double jumlahMinyak) { this.jumlahMinyak = jumlahMinyak; }
    public String getJenisMinyak() { return jenisMinyak; }
    public void setJenisMinyak(String jenisMinyak) { this.jenisMinyak = jenisMinyak; }
    public String getLokasiPenjemputan() { return lokasiPenjemputan; }
    public void setLokasiPenjemputan(String lokasiPenjemputan) { this.lokasiPenjemputan = lokasiPenjemputan; }
    public String getCatatan() { return catatan; }
    public void setCatatan(String catatan) { this.catatan = catatan; }
    public String getFoto() { return foto; }
    public void setFoto(String foto) { this.foto = foto; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Integer getHasilPoint() { return hasilPoint; }
    public void setHasilPoint(Integer hasilPoint) { this.hasilPoint = hasilPoint; }
    public Double getTotalHarga() { return totalHarga; }
    public void setTotalHarga(Double totalHarga) { this.totalHarga = totalHarga; }
    public Double getHargaMinyak() { return hargaMinyak; }
    public void setHargaMinyak(Double hargaMinyak) { this.hargaMinyak = hargaMinyak; }
    public Penjual getPenjual() { return penjual; }
    public void setPenjual(Penjual penjual) { this.penjual = penjual; }
    public Petugas getPetugas() { return petugas; }
    public void setPetugas(Petugas petugas) { this.petugas = petugas; }
    public Pusat getPusat() { return pusat; }
    public void setPusat(Pusat pusat) { this.pusat = pusat; }
}
