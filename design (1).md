# JELANTARA — Mobile App Design Specification

> **Dokumen acuan untuk Figma Make**  
> Produk: Jelantara — platform pengelolaan minyak jelantah  
> Platform: Mobile app, responsive untuk frame ponsel  
> Status: UI/UX prototype berdasarkan kebutuhan analisis dan referensi visual yang diberikan  
> Bahasa antarmuka: Bahasa Indonesia  
> Target utama: Penjual, Petugas, dan Pengelola Pusat

---

## 1. Tujuan Produk

Jelantara membantu proses pengelolaan minyak jelantah agar lebih terorganisasi dan mudah ditelusuri. Sistem menghubungkan tiga peran:

1. **Penjual** — mengajukan penjualan/penjemputan minyak jelantah, memantau proses, melihat transaksi dan poin, serta menukar poin dengan produk.
2. **Petugas** — menangani tugas penjemputan, memeriksa minyak, mencatat hasil penerimaan, memperbarui status, dan melihat riwayat tugas.
3. **Pengelola Pusat** — memantau transaksi dan stok, mengelola kapasitas penyimpanan, harga minyak, petugas, serta katalog produk reward.

### Masalah yang ingin diselesaikan
- Informasi jadwal dan status penjemputan belum mudah dipantau.
- Pencatatan transaksi manual menyulitkan pencarian data dan berisiko menimbulkan kesalahan.
- Informasi jumlah minyak, harga, pembayaran, dan poin perlu tercatat secara konsisten.
- Stok dan kapasitas penyimpanan perlu dipantau agar pengelola dapat melakukan tindakan sebelum penuh.
- Informasi produk, stok reward, dan proses penukaran poin perlu transparan.

### Prinsip desain
- **Simple first:** satu layar berfokus pada satu pekerjaan utama.
- **Role-based:** konten, menu, dan hak akses menyesuaikan peran.
- **Transparent:** jumlah, harga, status, poin, dan stok ditampilkan dengan jelas.
- **Traceable:** transaksi dan perubahan status memiliki riwayat.
- **Consistent:** komponen, istilah, ikon, jarak, dan pola interaksi konsisten.
- **Mobile-first:** nyaman digunakan dengan satu tangan dan tidak mengandalkan hover.

---

## 2. Referensi Visual dan Keputusan Desain

Gunakan gambar yang dilampirkan pengguna sebagai referensi utama:
- Referensi design system: tipografi Inter, gaya modern dan bersih, spacing kelipatan 4 px, radius kecil hingga besar, ikon outline, tombol rounded, kartu putih dengan border tipis, dan shadow minimal.
- Referensi login: logo Jelantara, aksen kuning, pilihan peran Penjual/Petugas/Pusat, input rounded, tombol utama kuning.
- Referensi dashboard Petugas: ringkasan tugas, kartu penjemputan, alamat, estimasi volume, waktu janji temu, catatan, peta mini, navigasi bawah.
- Referensi detail transaksi: poin diperoleh, tahapan status, rincian transaksi, tombol bantuan dan unduh bukti.
- Referensi dashboard Pusat: tangki stok, volume saat ini, kapasitas maksimum, persentase terisi, ringkasan volume, daftar minyak masuk.
- Referensi pemilihan peran/login: kartu peran Penjual, Petugas, Pusat Minyak.

### Resolusi dan layout
- Desain untuk frame dasar **393 × 852 px** (setara referensi iPhone yang diberikan).
- Gunakan safe area atas dan bawah.
- Konten dapat di-scroll vertikal.
- Padding horizontal halaman: 20 px.
- Jarak antar-section: 20–24 px.
- Hindari horizontal scrolling kecuali benar-benar diperlukan.
- Bottom navigation selalu berada di bawah pada halaman utama masing-masing peran.

### Catatan konflik warna referensi
Slide design-system yang dilampirkan menuliskan primary biru `#2563EB` dan secondary oranye `#F59E0B`, tetapi seluruh contoh UI aplikasi yang dilampirkan secara konsisten menggunakan **kuning sebagai warna aksi utama**. Untuk menjaga kesesuaian dengan tampilan aplikasi yang sudah dibuat, spesifikasi ini menetapkan **kuning sebagai primary UI**. Biru dari slide tidak digunakan sebagai warna tombol utama; bila dibutuhkan untuk informasi sekunder, gunakan hanya secara terbatas dan konsisten. Jangan mencampur dua sistem warna dalam satu layar.

---

## 3. Design Tokens

### 3.1 Color palette

| Token | Hex | Penggunaan |
|---|---|---|
| `color.primary` | `#FFC400` | Tombol utama, tab aktif, ikon aksi utama, indikator aktif |
| `color.primary.dark` | `#E5A900` | Teks/ikon di atas latar kuning bila perlu kontras lebih kuat |
| `color.primary.soft` | `#FFF8DF` | Latar lembut kartu informasi dan highlight |
| `color.secondary` | `#F59E0B` | Aksen sekunder, label, indikator |
| `color.text` | `#171717` | Judul dan teks utama |
| `color.text.secondary` | `#737373` | Deskripsi, metadata, placeholder |
| `color.text.muted` | `#A3A3A3` | Teks nonaktif |
| `color.background` | `#FFFFFF` | Latar utama |
| `color.surface` | `#FFFFFF` | Kartu dan modal |
| `color.surface.subtle` | `#FAFAFA` | Latar input/area sekunder |
| `color.border` | `#E5E5E5` | Border input, kartu, divider |
| `color.success` | `#16A34A` | Berhasil/selesai |
| `color.warning` | `#D97706` | Menunggu/perlu perhatian |
| `color.danger` | `#DC2626` | Ditolak, gagal, kesalahan |
| `color.info` | `#2563EB` | Informasi netral bila diperlukan |
| `color.overlay` | `rgba(0,0,0,0.40)` | Overlay modal |

**Aturan kontras:** tombol kuning memakai teks hitam `#171717`, bukan putih. Status tidak boleh dibedakan hanya dengan warna; selalu sertakan label teks dan/atau ikon.

### 3.2 Typography

Font utama: **Inter**. Jika tidak tersedia, gunakan sans-serif modern yang paling mendekati.

| Style | Ukuran | Weight | Line height | Penggunaan |
|---|---:|---:|---:|---|
| Display | 28 px | 700 | 34 px | Headline login/hero |
| H1 | 24 px | 700 | 30 px | Judul halaman |
| H2 | 20 px | 700 | 26 px | Judul section |
| H3 | 16 px | 600 | 22 px | Judul kartu |
| Body | 14 px | 400 | 21 px | Teks isi |
| Body strong | 14 px | 600 | 21 px | Nilai penting |
| Caption | 12 px | 400 | 16 px | Metadata |
| Button | 14–16 px | 600–700 | 20 px | Label tombol |
| Small label | 11 px | 600 | 14 px | Badge kecil |

Gunakan sentence case. Hindari terlalu banyak teks kapital penuh.

### 3.3 Spacing

Gunakan skala kelipatan 4 px:
`4, 8, 12, 16, 20, 24, 32, 40, 48`.

- Page horizontal padding: 20 px.
- Jarak label ke input: 8 px.
- Jarak antar-input: 16 px.
- Padding kartu: 16 px.
- Jarak antar-kartu: 12–16 px.
- Section spacing: 24 px.

### 3.4 Radius, border, shadow

| Komponen | Radius |
|---|---:|
| Small chip/badge | 8 px |
| Input | 24 px / pill |
| Button | 22–24 px / pill |
| Card kecil | 16 px |
| Card besar | 20 px |
| Bottom sheet/modal | 24 px (sudut atas) |
| Avatar | 50% |

- Border standar: `1 px solid #E5E5E5`.
- Shadow: sangat halus, misalnya `0 4px 18px rgba(0,0,0,0.06)`.
- Hindari shadow tebal dan efek glassmorphism.
- Kartu utama putih, bersih, dan memiliki pemisahan visual yang cukup.

### 3.5 Iconography

- Gunakan ikon outline konsisten, ketebalan garis sekitar 2 px.
- Gunakan satu keluarga ikon (Lucide atau Material Symbols Outlined).
- Ukuran umum: 20–24 px; ikon kecil 16 px.
- Ikon yang disarankan: droplet, truck, calendar, clock, receipt, wallet, gift, bell, warehouse, chart, package, user, settings, map-pin, search, filter, download, chevron, check-circle, alert-circle.
- Ikon harus memiliki label jika maknanya tidak langsung jelas.

---

## 4. Struktur Aplikasi dan Navigasi

### 4.1 Entry flow

`Splash → Welcome/Login → Pilih Peran → Login/Register → Dashboard sesuai peran`

Jika pengguna memilih peran pada layar login, sistem menampilkan form yang sesuai. Setelah autentikasi berhasil, arahkan pengguna ke dashboard berdasarkan role akun. Jangan hanya mengandalkan pilihan tab di UI untuk memberikan hak akses; role harus berasal dari akun yang terautentikasi.

### 4.2 Role dan menu

#### A. Penjual
Bottom navigation:
1. **Beranda**
2. **Transaksi**
3. **Poin**
4. **Profil**

Fungsi:
- Beranda: ringkasan saldo poin, CTA jual/ajukan penjemputan, status transaksi terakhir, informasi singkat.
- Transaksi: daftar transaksi, filter status/tanggal, detail transaksi, bukti transaksi.
- Poin: saldo poin, katalog produk, detail produk, penukaran, riwayat penukaran.
- Profil: data akun, alamat, nomor telepon, bantuan, keluar.

#### B. Petugas
Bottom navigation:
1. **Penugasan**
2. **Riwayat**
3. **Profil**

Fungsi:
- Penugasan: tugas hari ini, daftar penjemputan, detail tugas, update status, pemeriksaan dan pencatatan.
- Riwayat: daftar tugas/transaksi yang pernah ditangani dan filter.
- Profil: identitas petugas, pusat penugasan, bantuan, keluar.

#### C. Pengelola Pusat
Bottom navigation:
1. **Overview**
2. **Transaksi**
3. **Tangki Stok**
4. **Katalog**

Fungsi:
- Overview: ringkasan transaksi, volume minyak, aktivitas terbaru, peringatan.
- Transaksi: seluruh transaksi, pencarian, filter, detail, status.
- Tangki Stok: volume saat ini, kapasitas maksimum, persentase, stok masuk, peringatan kapasitas.
- Katalog: kelola produk reward, deskripsi, foto, harga poin, stok produk.
- Pengaturan harga, kapasitas, dan petugas dapat diletakkan di halaman Profil/Pengaturan atau menu pengelolaan lanjutan. Jangan menampilkan fitur pengelolaan kepada role yang tidak berwenang.

---

## 5. Screen Specification — Umum

### 5.1 Splash screen
- Logo droplet Jelantara di tengah.
- Nama “Jelantara”.
- Tagline: “Kelola Jelantah, Raih Berkah”.
- Background putih.
- Aksen kuning pada logo.
- Transisi singkat menuju welcome/login.

### 5.2 Welcome / Login
Komposisi:
1. Header logo Jelantara dan ikon ilustrasi sederhana.
2. Headline: **“Kelola Jelantah, Raih Berkah”**.
3. Subheadline: “Masuk untuk melanjutkan ke Jelantara.”
4. Segmented role selector: Penjual, Petugas, Pusat.
5. Judul form berubah sesuai role, contoh “Masuk sebagai Penjual”.
6. Field Email / No. Handphone.
7. Field Kata Sandi dengan show/hide password.
8. Link “Lupa Kata Sandi?”.
9. Tombol primary “MASUK KE SISTEM”.
10. Divider “atau masuk dengan”.
11. Tombol “Masuk dengan Google” (hanya tampil jika autentikasi Google benar-benar disediakan).
12. Link daftar akun untuk role yang boleh registrasi.

Perilaku:
- Role selector mengubah konteks login dan label tombol.
- Validasi email/nomor telepon dan password.
- Tampilkan error di bawah field, bukan hanya toast.
- Tombol memiliki state default, pressed, loading, disabled.
- Lupa kata sandi membuka alur reset.
- Registrasi penjual meminta data minimum: nama, nomor HP, email (opsional jika sesuai kebijakan), password, alamat.
- Akun Petugas dan Pusat dibuat/diundang oleh pengelola, kecuali kebijakan produk menentukan lain.

### 5.3 Pemilihan peran (alternatif layar)
Jika menggunakan layar pemilihan role terpisah:
- Headline “Welcome back.”
- Deskripsi: “Pilih peran akun (Penjual, Petugas, atau Pusat Minyak) untuk masuk ke halaman utama masing-masing.”
- Tiga role cards: Penjual, Petugas, Pusat Minyak.
- Kartu aktif memiliki border kuning dan background kuning lembut.
- Tombol login mengikuti role yang dipilih.
- Pertahankan konsistensi dengan role selector pada login; jangan membuat dua pola yang membingungkan. Pilih satu pola final.

---

## 6. Screen Specification — Penjual

### 6.1 Beranda Penjual
Urutan konten:
1. Header sapaan: “Halo, [Nama]” dan avatar/notifikasi.
2. Kartu saldo poin dengan nilai besar dan CTA “Lihat Poin”.
3. CTA utama **“Jual Minyak Jelantah”** atau **“Ajukan Penjemputan”**.
4. Kartu status transaksi aktif: ID, tanggal, status, jumlah estimasi jika ada.
5. Ringkasan transaksi (misalnya total liter dan transaksi selesai); tampilkan hanya data yang tersedia.
6. Produk reward pilihan/tersedia.
7. Aktivitas transaksi terbaru.

Perilaku:
- CTA membuka form pengajuan.
- Kartu transaksi membuka detail.
- Saldo poin menuju halaman Poin.
- Jika belum ada transaksi, tampilkan empty state dengan CTA untuk mulai menjual.

### 6.2 Form Ajukan Penjemputan / Penjualan
Field:
- Alamat penjemputan (pilih alamat tersimpan atau isi alamat).
- Perkiraan jumlah minyak (liter).
- Jenis minyak (jika jenis memang dicatat dalam proses).
- Catatan untuk petugas (opsional).
- Foto minyak (opsional jika kebutuhan operasional mengizinkan).
- Pilihan jadwal/tanggal hanya jika sistem memang mendukung penjadwalan langsung. Jika jadwal ditentukan petugas/pusat, tampilkan “Jadwal akan dikonfirmasi”.
- Tombol “Kirim Permintaan”.

Tampilkan catatan bahwa jumlah yang dimasukkan merupakan estimasi dan jumlah final mengikuti hasil pemeriksaan petugas, bila proses bisnis menggunakan estimasi.

State:
- Form kosong, terisi, validasi, loading, sukses, gagal.
- Setelah berhasil, tampilkan nomor permintaan dan status awal.
- Cegah submit ganda saat request sedang diproses.

### 6.3 Daftar Transaksi Penjual
- Search berdasarkan ID transaksi bila dibutuhkan.
- Filter chip: Semua, Menunggu, Diproses, Berhasil, Ditolak, Dibatalkan.
- Card transaksi menampilkan tanggal, ID, jumlah minyak, status, dan total pembayaran bila sudah final.
- Status menggunakan badge dan teks.
- Empty state: “Belum ada transaksi”.

### 6.4 Detail Transaksi Penjual
Tampilkan:
- Status/progress transaksi.
- Poin diperoleh (hanya jika sudah dihitung/terkonfirmasi).
- ID transaksi dan tanggal.
- Jumlah minyak final.
- Harga per liter yang diterapkan.
- Total pembayaran.
- Petugas yang menangani (jika tersedia).
- Lokasi penjemputan.
- Catatan dan bukti/foto bila ada.
- Tombol “Unduh Bukti” setelah transaksi memiliki data final.
- Tombol bantuan.

Progress yang dapat digunakan:
1. Permintaan dibuat.
2. Penjemputan dijadwalkan / dijemput (sesuaikan proses aktual).
3. Diverifikasi pusat.
4. Pembayaran/poin dikonfirmasi.

Jangan menampilkan semua tahap sebagai selesai jika status belum mencapainya. Jika ditolak atau dibatalkan, tampilkan alasan jika tersedia.

### 6.5 Halaman Poin
- Saldo poin saat ini.
- Riwayat poin masuk dan keluar.
- CTA “Lihat Katalog”.
- Penjelasan singkat aturan perolehan poin, hanya jika rumus telah ditetapkan.

### 6.6 Katalog Reward
Card produk:
- Foto produk.
- Nama produk.
- Deskripsi singkat.
- Harga dalam poin.
- Stok/ketersediaan.
- Tombol “Lihat Detail”.

Detail produk:
- Foto besar.
- Nama, deskripsi, harga poin, stok.
- Tombol “Tukar Poin”.
- Konfirmasi sebelum penukaran.
- Validasi saldo poin dan stok sebelum submit.
- Setelah berhasil, buat catatan penukaran dan tampilkan status.

Jika stok habis, tombol nonaktif dan label “Stok habis”. Jangan mengizinkan penukaran jika poin tidak cukup.

### 6.7 Riwayat Penukaran
- ID penukaran, tanggal, produk, poin yang digunakan, status.
- Detail alamat pengantaran jika proses pengiriman digunakan.
- Status pembatalan dan pengembalian poin harus dapat ditelusuri.
- Jika produk tidak tersedia/rusak dan penukaran dibatalkan, tampilkan status pembatalan serta informasi pengembalian poin setelah dikonfirmasi.

---

## 7. Screen Specification — Petugas

### 7.1 Dashboard Petugas / Penugasan
Ikuti struktur referensi:
- Header avatar/inisial, nama petugas, status aktif.
- Ikon notifikasi.
- Judul “Tugas Hari Ini”.
- Ringkasan: jumlah tugas hari ini, selesai, liter terkumpul, poin dibagikan (jika metrik ini memang relevan dan tersedia).
- Tampilkan jumlah penjemputan tersisa.
- Kartu tugas prioritas.

Kartu tugas:
- ID permintaan.
- Status tugas.
- Nama penjual/lokasi usaha.
- Alamat.
- Estimasi volume.
- Jadwal/janji temu.
- Catatan penjual.
- Peta mini atau tombol “Buka Navigasi” bila integrasi peta tersedia.
- CTA “Lihat Detail” / “Mulai Penjemputan”.

Catatan: jangan membuat jarak dan estimasi waktu palsu. Jika belum ada API peta/rute, gunakan placeholder peta yang jelas sebagai prototipe, bukan data navigasi nyata.

### 7.2 Detail Penugasan
Tampilkan:
- ID permintaan dan status.
- Data penjual dan nomor kontak (gunakan hanya jika diizinkan).
- Alamat lengkap.
- Estimasi jumlah minyak.
- Jadwal dan catatan.
- Tombol navigasi (jika tersedia).
- Riwayat perubahan status.
- CTA sesuai status: “Mulai Penjemputan”, “Tandai Dijemput”, “Lanjut Pemeriksaan”.

### 7.3 Pemeriksaan Minyak
Form:
- Jumlah minyak aktual (liter).
- Jenis minyak (jika diperlukan).
- Hasil pemeriksaan: diterima / ditolak.
- Catatan pemeriksaan.
- Foto bukti (opsional).
- Tombol “Simpan Hasil Pemeriksaan”.

Jika ditolak:
- Wajib mengisi alasan penolakan.
- Status menjadi ditolak.
- Jangan menambahkan jumlah ke stok.
- Jangan menghitung pembayaran/poin sebagai transaksi berhasil.

Jika diterima:
- Lanjutkan ke ringkasan transaksi.
- Jumlah final menjadi dasar perhitungan sesuai aturan sistem.

### 7.4 Konfirmasi Transaksi
Tampilkan ringkasan:
- Nama penjual dan ID transaksi.
- Jumlah minyak final.
- Harga per liter yang berlaku.
- Total pembayaran = jumlah liter diterima × harga per liter.
- Poin = jumlah liter × aturan konversi poin yang ditetapkan.
- Tombol “Konfirmasi Transaksi”.

Penting:
- Rumus poin harus berasal dari konfigurasi bisnis, jangan hardcode angka contoh.
- Simpan harga yang digunakan pada transaksi sebagai snapshot agar transaksi lama tidak berubah saat harga diperbarui.
- Minta konfirmasi sebelum menyelesaikan transaksi.
- Setelah sukses, tampilkan bukti transaksi.

### 7.5 Riwayat Petugas
- Daftar penugasan/transaksi yang pernah ditangani.
- Filter berdasarkan tanggal dan status.
- Informasi ringkas: ID, penjual, jumlah minyak, tanggal, status.
- Detail dapat dibuka kembali, tetapi perubahan data historis dibatasi sesuai hak akses.

### 7.6 Profil Petugas
- Nama, ID petugas, pusat penugasan, nomor kontak.
- Status akun.
- Bantuan dan logout.
- Tidak menyediakan pengaturan harga atau kapasitas jika kewenangan tersebut milik pengelola pusat.

---

## 8. Screen Specification — Pengelola Pusat

### 8.1 Overview
- Header nama pusat/gudang dan tombol profil/keluar.
- Ringkasan transaksi hari ini.
- Total volume minyak masuk hari ini/minggu/bulan.
- Jumlah transaksi menunggu verifikasi.
- Kartu peringatan kapasitas.
- Aktivitas minyak masuk terbaru.
- Shortcut ke transaksi, tangki stok, dan katalog.

Gunakan angka dari data. Untuk prototipe, tandai data dummy dengan jelas.

### 8.2 Transaksi Pusat
- Daftar semua transaksi.
- Search ID transaksi/nama penjual.
- Filter tanggal, status, petugas.
- Card/baris ringkas: ID, penjual, tanggal, volume, total pembayaran, status.
- Detail transaksi dan riwayat status.
- Hak koreksi data dibatasi; setiap perubahan penting harus tercatat sebagai audit trail.

### 8.3 Tangki Stok
Ikuti referensi dashboard:
- Ilustrasi tangki sederhana.
- Volume saat ini (liter).
- Kapasitas maksimum (liter).
- Persentase kapasitas = volume saat ini ÷ kapasitas maksimum × 100%.
- Sisa kapasitas = kapasitas maksimum − volume saat ini.
- Ringkasan volume hari ini, minggu ini, bulan ini.
- Daftar minyak masuk: nama penjual, waktu, volume, ID transaksi.
- Indikator peringatan saat mendekati ambang yang ditentukan.

Ambang peringatan 80–90% pernah menjadi kebutuhan awal, tetapi angka final harus menjadi konfigurasi yang disepakati. Jangan mengunci angka tersebut jika belum dikonfirmasi.

State kapasitas:
- Normal: kapasitas masih aman.
- Warning: mendekati ambang.
- Critical: hampir penuh/penuh.
- Data error: volume atau kapasitas tidak tersedia.

Jika kapasitas penuh, tampilkan peringatan dan informasi tindak lanjut. Jangan mengarang mekanisme pemindahan minyak yang belum disepakati.

### 8.4 Pengaturan Harga Minyak
- Menampilkan harga aktif per jenis minyak (jika harga dibedakan berdasarkan jenis).
- Form ubah harga dengan validasi nilai positif.
- Konfirmasi sebelum menyimpan.
- Catat tanggal mulai berlaku dan siapa yang mengubah.
- Perubahan harga baru berlaku untuk transaksi berikutnya, bukan mengubah transaksi lama.

### 8.5 Pengelolaan Katalog Reward
- Daftar produk.
- Tambah/edit produk: nama, deskripsi, foto, harga poin, stok.
- Aktif/nonaktif produk.
- Validasi harga poin dan stok tidak negatif.
- Produk stok nol ditampilkan sebagai habis dan tidak dapat ditukar.
- Perubahan stok dan katalog hanya untuk role berwenang.

### 8.6 Pengaturan Kapasitas dan Petugas
- Kapasitas maksimum penyimpanan.
- Ambang peringatan kapasitas.
- Daftar petugas dan status.
- Penugasan petugas jika mekanisme penugasan dikelola pusat.
- Perubahan konfigurasi harus memiliki konfirmasi.

---

## 9. Business Rules dan Logika Sistem

### 9.1 Transaksi penjualan minyak
1. Penjual membuat permintaan.
2. Sistem menyimpan permintaan dengan status awal.
3. Petugas melakukan penjemputan sesuai alur operasional yang disepakati.
4. Petugas memeriksa minyak.
5. Jika ditolak, alasan dicatat dan transaksi tidak menambah stok.
6. Jika diterima, petugas mencatat jumlah final.
7. Sistem mengambil harga aktif yang berlaku.
8. Sistem menghitung total pembayaran.
9. Sistem menghitung poin berdasarkan aturan konversi.
10. Setelah transaksi dikonfirmasi berhasil, stok diperbarui dan riwayat disimpan.
11. Bukti transaksi tersedia untuk penjual.

**Formula:**
- `total_pembayaran = jumlah_minyak_final × harga_per_liter_saat_transaksi`
- `poin_diperoleh = jumlah_minyak_final × poin_per_liter` (hanya jika aturan konversi ini disetujui; jika tidak, gunakan konfigurasi yang berlaku).

### 9.2 Stok minyak
- Stok bertambah hanya dari transaksi yang diterima dan dikonfirmasi.
- Transaksi ditolak/dibatalkan tidak menambah stok.
- Kapasitas maksimum harus tersimpan pada konteks pusat/gudang penyimpanan, bukan diulang pada setiap catatan mutasi jika model data menggunakan riwayat pergerakan stok.
- Tampilkan satuan liter secara konsisten.
- Cegah stok menjadi negatif atau melebihi kapasitas tanpa peringatan dan prosedur yang jelas.

### 9.3 Penukaran poin
1. Penjual memilih produk.
2. Sistem memeriksa saldo poin.
3. Sistem memeriksa stok produk.
4. Penjual mengonfirmasi penukaran.
5. Sistem mencatat penukaran dan mengurangi poin/stok sesuai mekanisme transaksi yang aman.
6. Jika penukaran dibatalkan karena produk tidak tersedia/rusak, status pembatalan dicatat dan poin dikembalikan.
7. Riwayat penukaran tetap tersimpan.

### 9.4 Status
Gunakan status yang konsisten dan jangan mencampur status penjemputan dengan status pemeriksaan/transaksi.

Contoh status transaksi:
- Menunggu pemeriksaan
- Diproses
- Berhasil
- Ditolak
- Dibatalkan

Contoh status penjemputan (jika dipisahkan):
- Menunggu penjadwalan
- Terjadwal
- Dalam perjalanan
- Dijemput
- Gagal dijemput
- Dijadwalkan ulang

Finalisasi daftar status harus mengikuti proses bisnis yang disetujui.

---

## 10. Komponen UI Reusable

Buat komponen reusable berikut di Figma Make:

1. `AppHeader` — judul, subtitle, avatar, notification.
2. `BottomNavigation` — menu sesuai role, active state.
3. `PrimaryButton` — kuning, teks hitam, tinggi 48–52 px.
4. `SecondaryButton` — putih, border abu, teks hitam.
5. `TextField` — label, input, leading/trailing icon, helper/error.
6. `RoleSelector` — tiga pilihan role.
7. `StatusBadge` — label status dengan warna semantik.
8. `SummaryCard` — angka utama dan caption.
9. `TransactionCard` — ID, tanggal, volume, nilai, status.
10. `PickupTaskCard` — penjual, alamat, jadwal, estimasi, catatan.
11. `ProductCard` — gambar, nama, poin, stok.
12. `PointBalanceCard` — saldo poin dan CTA.
13. `ProgressStepper` — tahapan proses transaksi.
14. `InventoryTankCard` — volume, kapasitas, persentase.
15. `AlertBanner` — warning/success/error.
16. `EmptyState` — ikon, judul, deskripsi, CTA.
17. `SearchBar` — input pencarian.
18. `FilterChips` — filter horizontal.
19. `ConfirmationModal` — ringkasan tindakan dan tombol konfirmasi.
20. `Toast/Snackbar` — feedback singkat.

Semua komponen harus memiliki konsistensi padding, radius, tipografi, dan state.

### Button states
- Default
- Pressed
- Loading
- Disabled

### Input states
- Default
- Focus
- Filled
- Error
- Disabled

### Card states
- Default
- Pressed
- Selected
- Disabled (bila relevan)

### Status badge
- Menunggu: amber lembut.
- Diproses: biru lembut atau abu-biru.
- Berhasil: hijau lembut.
- Ditolak/dibatalkan: merah lembut.
- Netral: abu-abu.
Selalu gunakan teks status yang eksplisit.

---

## 11. Interaction dan Prototype Flow

Buat prototype dengan navigasi yang dapat diklik, bukan hanya layar statis.

### Flow A — Login dan role
`Welcome/Login → Pilih Penjual/Petugas/Pusat → Isi kredensial → Validasi → Dashboard role`

### Flow B — Penjual mengajukan penjemputan
`Beranda Penjual → Jual Minyak Jelantah → Isi alamat/estimasi/catatan → Review → Kirim → Konfirmasi berhasil → Detail permintaan`

### Flow C — Penjual melihat transaksi
`Beranda → Transaksi → Filter/cari → Detail transaksi → Unduh bukti (prototype action)`

### Flow D — Penjual menukar poin
`Beranda → Poin → Katalog → Detail produk → Tukar poin → Konfirmasi → Status penukaran`

### Flow E — Petugas menyelesaikan tugas
`Dashboard Petugas → Detail tugas → Mulai penjemputan → Tandai dijemput → Pemeriksaan → Input jumlah final → Ringkasan pembayaran/poin → Konfirmasi → Bukti transaksi`

Jika penjemputan dan pemeriksaan terjadi di lokasi berbeda, buat transisi yang sesuai. Jangan memaksakan satu urutan tanpa validasi proses lapangan.

### Flow F — Pusat memantau stok
`Overview Pusat → Tangki Stok → Detail stok masuk → Peringatan kapasitas`

### Flow G — Pusat mengubah harga
`Pengaturan Harga → Edit harga → Review perubahan → Konfirmasi → Harga aktif diperbarui`

### Flow H — Pusat mengelola reward
`Katalog → Tambah/Edit Produk → Isi detail → Simpan → Produk tampil di katalog Penjual`

---

## 12. Data Dummy untuk Prototype

Gunakan data dummy yang konsisten pada seluruh layar. Beri label bahwa data hanya contoh.

### Akun demo
- Penjual: Siti Rahmawati
- Petugas: Andi Pratama
- Pusat: Gudang Bandung

### Contoh transaksi
- ID: `TRX-0936`
- Penjual: Warung Makan Bu Sari
- Jumlah: `15 liter`
- Harga contoh: `Rp4.000/liter`
- Total contoh: `Rp60.000`
- Poin contoh: `450 poin`
- Status: `Diverifikasi pusat` atau sesuaikan tahap flow yang sedang ditampilkan.

Jangan menganggap contoh nilai tersebut sebagai ketentuan bisnis final. Angka harga dan poin pada prototype harus diberi label data simulasi.

### Contoh tugas petugas
- ID: `ORD-2318`
- Lokasi: Warung Makan Bu Sari
- Alamat contoh: Jl. Melati No. 12, Coblong, Bandung
- Estimasi: 15 liter
- Janji temu: 10:00 WIB
- Catatan: “Jerigen di samping dapur belakang.”

### Contoh stok pusat
- Volume saat ini: `6.500 L`
- Kapasitas maksimum: `10.000 L`
- Terisi: `65%`
- Sisa kapasitas: `3.500 L`

Pastikan angka antarhalaman konsisten jika memakai transaksi dan stok yang sama.

---

## 13. Accessibility dan Usability

- Area sentuh tombol minimal sekitar 44 × 44 px.
- Teks isi minimal 14 px; caption jangan terlalu kecil.
- Kontras teks dan background harus jelas.
- Jangan mengandalkan warna saja untuk status.
- Field wajib memiliki label permanen, bukan placeholder saja.
- Berikan pesan error yang menjelaskan cara memperbaiki input.
- Gunakan format angka Indonesia: `Rp60.000`, `1.500 L`, `10.00 WIB`.
- Satuan liter selalu ditampilkan.
- Konfirmasi untuk aksi penting: menyelesaikan transaksi, menolak minyak, mengubah harga, menghapus/nonaktifkan produk, dan menukar poin.
- Hindari form terlalu panjang; kelompokkan field dan gunakan ringkasan sebelum submit.

---

## 14. Empty, Loading, Error, dan Success States

Setiap halaman yang mengambil data harus memiliki:
- **Loading:** skeleton card atau spinner dengan konteks.
- **Empty:** ilustrasi ikon sederhana, judul, penjelasan, CTA jika relevan.
- **Error:** pesan yang mudah dimengerti dan tombol coba lagi.
- **Success:** konfirmasi tindakan dan langkah berikutnya.
- **Offline/connection issue:** beri tahu bahwa data belum dapat diperbarui; jangan menampilkan data seolah real-time.

Contoh:
- Empty transaksi: “Belum ada transaksi. Transaksi yang kamu lakukan akan muncul di sini.”
- Empty tugas: “Tidak ada penugasan untuk saat ini.”
- Stok habis: “Produk sedang tidak tersedia.”
- Poin tidak cukup: “Poin kamu belum mencukupi untuk menukar produk ini.”
- Gagal simpan: “Data belum berhasil disimpan. Periksa koneksi lalu coba lagi.”

---

## 15. Scope dan Hal yang Belum Boleh Diasumsikan

Hal berikut masih perlu validasi dengan pemilik proses/wawancara sebelum dijadikan aturan final:
- Apakah penjual memilih jadwal langsung atau jadwal dikonfirmasi petugas/pusat.
- Apakah penjemputan dilakukan oleh petugas pusat atau pihak pengangkut terpisah.
- Apakah status penjemputan dan status pemeriksaan menjadi dua alur terpisah.
- Rumus konversi liter menjadi poin.
- Harga minyak per jenis dan mekanisme tanggal mulai berlaku.
- Ambang notifikasi kapasitas (misalnya 80–90%) dan tindakan ketika kapasitas penuh.
- Apakah foto wajib pada permintaan atau pemeriksaan.
- Mekanisme pembayaran (tunai, transfer, atau dicatat sebagai pembayaran oleh pusat).
- Mekanisme pengiriman produk reward.
- Apakah petugas dapat mengubah transaksi setelah dikonfirmasi.
- Apakah penjual dapat membatalkan permintaan dan sampai tahap apa.

Jangan membuat fitur seolah-olah sudah menjadi ketentuan jika belum didukung kebutuhan yang tervalidasi. Jika perlu, tampilkan sebagai placeholder/prototype dengan label “Contoh” atau “Akan dikonfirmasi”.

---

## 16. Instruksi Final untuk Figma Make

Bangun **high-fidelity mobile app prototype** Jelantara berdasarkan spesifikasi ini dan gambar referensi yang diberikan.

Prioritas implementasi:
1. Terapkan design tokens secara konsisten.
2. Buat tiga pengalaman role yang berbeda: Penjual, Petugas, Pengelola Pusat.
3. Bangun layar utama dan alur inti yang dapat diklik.
4. Gunakan komponen reusable.
5. Gunakan data dummy yang konsisten dan tandai sebagai simulasi.
6. Buat state loading, empty, error, success, disabled, dan confirmation.
7. Pastikan bottom navigation dan role-based navigation berfungsi.
8. Pertahankan visual minimalis putih-kuning-hitam seperti referensi aplikasi.
9. Jangan menambahkan warna dekoratif, ilustrasi berlebihan, atau fitur yang tidak relevan.
10. Jangan membuat integrasi backend, pembayaran, Google login, peta, notifikasi push, atau unduhan file seolah benar-benar berjalan jika belum tersedia. Untuk prototype, gunakan simulasi interaksi yang jelas.

### Output yang diharapkan
- Mobile app screens untuk Penjual, Petugas, dan Pengelola Pusat.
- Login/role selection.
- Dashboard masing-masing role.
- Form dan detail transaksi.
- Penjemputan dan pemeriksaan petugas.
- Stok dan kapasitas pusat.
- Katalog dan penukaran poin.
- Reusable component set.
- Prototype flow antarhalaman yang dapat diuji.
- Tampilan konsisten pada frame 393 × 852 px dan adaptif pada ukuran ponsel lain.

**Arah visual akhir:** modern, clean, minimal, dominan putih dengan aksen kuning, teks hitam, garis/border abu-abu muda, ikon outline, tombol pill, kartu rounded, dan shadow sangat halus.
