package com.pbo.jelantara;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name = "produk_olahan")
public class ProdukOlahan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produk")
    private Long idProduk;

    @Column(name = "nama_produk", nullable = false)
    private String namaProduk;

    @Column(name = "deskripsi")
    private String deskripsi;

    @Column(name = "harga_poin", nullable = false)
    private Integer hargaPoin;

    @Column(name = "stok", nullable = false)
    private Integer stok;

    @Column(name = "gambar")
    private String gambar;

    public Long getIdProduk() { return idProduk; }
    public void setIdProduk(Long idProduk) { this.idProduk = idProduk; }
    public String getNamaProduk() { return namaProduk; }
    public void setNamaProduk(String namaProduk) { this.namaProduk = namaProduk; }
    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }
    public Integer getHargaPoin() { return hargaPoin; }
    public void setHargaPoin(Integer hargaPoin) { this.hargaPoin = hargaPoin; }
    public Integer getStok() { return stok; }
    public void setStok(Integer stok) { this.stok = stok; }
    public String getGambar() { return gambar; }
    public void setGambar(String gambar) { this.gambar = gambar; }
}
