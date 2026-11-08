package com.pbo.jelantara;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name = "penjual")
public class Penjual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_penjual")
    private Long idPenjual;

    @Column(name = "nama_penjual", nullable = false)
    private String namaPenjual;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "no_hp", unique = true, nullable = false)
    private String noHp;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "poin", nullable = false)
    private Integer poin;

    public Long getIdPenjual() { return idPenjual; }
    public void setIdPenjual(Long idPenjual) { this.idPenjual = idPenjual; }
    public String getNamaPenjual() { return namaPenjual; }
    public void setNamaPenjual(String namaPenjual) { this.namaPenjual = namaPenjual; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getNoHp() { return noHp; }
    public void setNoHp(String noHp) { this.noHp = noHp; }
    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }
    public Integer getPoin() { return poin; }
    public void setPoin(Integer poin) { this.poin = poin; }
}
