-- =====================================================================
-- JELANTARA - Database Schema & Seed Data
-- Jalankan di Query Tool pada database 'jelantara' di pgAdmin
-- Urutan: buat database 'jelantara' dulu, lalu jalankan file ini
-- =====================================================================

-- 1. PENJUAL ==========================================================
CREATE TABLE penjual (
    id_penjual BIGSERIAL PRIMARY KEY,
    nama_penjual VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    no_hp VARCHAR(255) NOT NULL UNIQUE,
    alamat VARCHAR(255),
    poin INTEGER NOT NULL
);

-- 2. PETUGAS ===========================================================
CREATE TABLE petugas (
    id_petugas BIGSERIAL PRIMARY KEY,
    nama VARCHAR(255) NOT NULL,
    no_telp VARCHAR(255) NOT NULL UNIQUE,
    status VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- 3. PUSAT =============================================================
CREATE TABLE pusat (
    id_pusat BIGSERIAL PRIMARY KEY,
    nama_gudang VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- 4. PENJUALAN =========================================================
CREATE TABLE penjualan (
    id_transaksi BIGSERIAL PRIMARY KEY,
    tanggal_transaksi DATE NOT NULL,
    jumlah_minyak FLOAT8 NOT NULL,
    jenis_minyak VARCHAR(255) NOT NULL,
    lokasi_penjemputan VARCHAR(255) NOT NULL,
    catatan VARCHAR(255),
    foto VARCHAR(255),
    status VARCHAR(255) NOT NULL,
    hasil_point INTEGER,
    total_harga FLOAT8,
    harga_minyak FLOAT8 NOT NULL,
    penjual_id BIGINT NOT NULL REFERENCES penjual(id_penjual),
    petugas_id BIGINT REFERENCES petugas(id_petugas),
    pusat_id BIGINT REFERENCES pusat(id_pusat)
);

-- 5. STOK MINYAK =======================================================
CREATE TABLE stok_minyak (
    id_stok BIGSERIAL PRIMARY KEY,
    jumlah_minyak FLOAT8 NOT NULL,
    batas_stok FLOAT8 NOT NULL,
    jumlah_update FLOAT8 NOT NULL,
    tgl_update DATE NOT NULL,
    penjualan_id BIGINT REFERENCES penjualan(id_transaksi),
    pusat_id BIGINT REFERENCES pusat(id_pusat)
);

-- 6. PRODUK OLAHAN =====================================================
CREATE TABLE produk_olahan (
    id_produk BIGSERIAL PRIMARY KEY,
    nama_produk VARCHAR(255) NOT NULL,
    deskripsi VARCHAR(255),
    harga_poin INTEGER NOT NULL,
    stok INTEGER NOT NULL,
    gambar VARCHAR(255)
);

-- 7. PENUKARAN POIN ====================================================
CREATE TABLE penukaran_poin (
    id_penukaran BIGSERIAL PRIMARY KEY,
    jumlah_poin INTEGER NOT NULL,
    alamat_pengantaran VARCHAR(255) NOT NULL,
    harga_poin_satuan INTEGER NOT NULL,
    tgl_penukaran DATE NOT NULL,
    penjual_id BIGINT NOT NULL REFERENCES penjual(id_penjual),
    produk_id BIGINT NOT NULL REFERENCES produk_olahan(id_produk)
);

-- =====================================================================
-- 8. SEED DATA AWAL
-- =====================================================================

-- Akun Petugas (login: petugas@mail.com / petugas123)
INSERT INTO petugas (nama, no_telp, status, email, password)
VALUES ('Andi Pratama', '081234567890', 'aktif', 'petugas@mail.com', 'petugas123');

-- Akun Pusat (login: pusat@mail.com / pusat123)
INSERT INTO pusat (nama_gudang, email, password)
VALUES ('Gudang Bandung', 'pusat@mail.com', 'pusat123');

-- Tangki stok awal (kapasitas 10.000 liter)
INSERT INTO stok_minyak (jumlah_minyak, batas_stok, jumlah_update, tgl_update, pusat_id)
VALUES (0, 10000, 0, CURRENT_DATE, 1);

-- Produk reward hasil olahan minyak jelantah
INSERT INTO produk_olahan (nama_produk, deskripsi, harga_poin, stok, gambar) VALUES
('Sabun Cuci Piring', 'Sabun cuci piring cair hasil olahan minyak jelantah', 150, 20, 'https://placehold.co/200/jpg?text=Sabun+Piring'),
('Sabun Cuci Tangan', 'Sabun cuci tangan gel hasil olahan minyak jelantah', 120, 15, 'https://placehold.co/200/jpg?text=Sabun+Tangan'),
('Lilin Eco Jelantara', 'Lilin tangkai ramah lingkungan dari minyak jelantah', 200, 10, 'https://placehold.co/200/jpg?text=Lilin+Eco');

-- =====================================================================
-- 9. VERIFIKASI
-- =====================================================================
-- SELECT * FROM penjual;
-- SELECT * FROM petugas;
-- SELECT * FROM pusat;
-- SELECT * FROM penjualan;
-- SELECT * FROM stok_minyak;
-- SELECT * FROM produk_olahan;
-- SELECT * FROM penukaran_poin;
