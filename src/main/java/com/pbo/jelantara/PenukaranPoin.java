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
@Table(name = "penukaran_poin")
public class PenukaranPoin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_penukaran")
    private Long idPenukaran;

    @Column(name = "jumlah_poin", nullable = false)
    private Integer jumlahPoin;

    @Column(name = "alamat_pengantaran", nullable = false)
    private String alamatPengantaran;

    @Column(name = "harga_poin_satuan", nullable = false)
    private Integer hargaPoinSatuan;

    @Column(name = "tgl_penukaran", nullable = false)
    private LocalDate tglPenukaran;

    @ManyToOne
    @JoinColumn(name = "penjual_id", nullable = false)
    private Penjual penjual;

    @ManyToOne
    @JoinColumn(name = "produk_id", nullable = false)
    private ProdukOlahan produk;

    public Long getIdPenukaran() { return idPenukaran; }
    public void setIdPenukaran(Long idPenukaran) { this.idPenukaran = idPenukaran; }
    public Integer getJumlahPoin() { return jumlahPoin; }
    public void setJumlahPoin(Integer jumlahPoin) { this.jumlahPoin = jumlahPoin; }
    public String getAlamatPengantaran() { return alamatPengantaran; }
    public void setAlamatPengantaran(String alamatPengantaran) { this.alamatPengantaran = alamatPengantaran; }
    public Integer getHargaPoinSatuan() { return hargaPoinSatuan; }
    public void setHargaPoinSatuan(Integer hargaPoinSatuan) { this.hargaPoinSatuan = hargaPoinSatuan; }
    public LocalDate getTglPenukaran() { return tglPenukaran; }
    public void setTglPenukaran(LocalDate tglPenukaran) { this.tglPenukaran = tglPenukaran; }
    public Penjual getPenjual() { return penjual; }
    public void setPenjual(Penjual penjual) { this.penjual = penjual; }
    public ProdukOlahan getProduk() { return produk; }
    public void setProduk(ProdukOlahan produk) { this.produk = produk; }
}
