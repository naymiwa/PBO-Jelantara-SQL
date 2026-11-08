package com.pbo.jelantara;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name = "pusat")
public class Pusat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pusat")
    private Long idPusat;

    @Column(name = "nama_gudang", nullable = false)
    private String namaGudang;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    public Long getIdPusat() { return idPusat; }
    public void setIdPusat(Long idPusat) { this.idPusat = idPusat; }
    public String getNamaGudang() { return namaGudang; }
    public void setNamaGudang(String namaGudang) { this.namaGudang = namaGudang; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
