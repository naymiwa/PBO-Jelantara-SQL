package com.pbo.jelantara;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

@Controller
public class PusatController {

    @Value("${jelantara.ambang-kapasitas}")
    private double ambangKapasitas;

    @Autowired
    private PenjualanRepository penjualanRepository;
    @Autowired
    private PusatRepository pusatRepository;
    @Autowired
    private StokMinyakRepository stokMinyakRepository;
    @Autowired
    private ProdukOlahanRepository produkOlahanRepository;
    @Autowired
    private PenukaranPoinRepository penukaranPoinRepository;

    @GetMapping("/pusat")
    public String halamanPusat(Model model, HttpSession session) {
        if (!"pusat".equals(session.getAttribute("role"))) {
            return "redirect:/login";
        }
        StokMinyak stok = stokMinyakRepository.findAll().isEmpty()
                ? buatStokBaru() : stokMinyakRepository.findAll().get(0);
        double persen = stok.getBatasStok() > 0
                ? stok.getJumlahMinyak() / stok.getBatasStok() * 100 : 0;
        double sisa = stok.getBatasStok() - stok.getJumlahMinyak();
        double persenSafe = Math.max(0, Math.min(100, persen));
        String statusTank = persen >= 100 ? "KRITIS - TANGKI PENUH"
                : persen >= ambangKapasitas ? "PERHATIAN - MENDEKATI BATAS" : "AMAN";
        model.addAttribute("stok", stok);
        model.addAttribute("persen", Math.round(persenSafe * 10) / 10.0);
        model.addAttribute("sisaKapasitas", sisa);
        model.addAttribute("statusTank", statusTank);
        model.addAttribute("listPenjualan", penjualanRepository.findAll());
        model.addAttribute("listProduk", produkOlahanRepository.findAll());
        model.addAttribute("listPenukaran", penukaranPoinRepository.findAll());
        return "pusat";
    }

    @PostMapping("/pusat/produk")
    public String tambahProduk(@RequestParam String namaProduk,
                               @RequestParam String deskripsi,
                               @RequestParam Integer hargaPoin,
                               @RequestParam Integer stok,
                               @RequestParam(required = false) String gambar,
                               HttpSession session) {
        if (!"pusat".equals(session.getAttribute("role"))) {
            return "redirect:/login";
        }
        ProdukOlahan produk = new ProdukOlahan();
        produk.setNamaProduk(namaProduk);
        produk.setDeskripsi(deskripsi == null || deskripsi.isEmpty() ? "-" : deskripsi);
        produk.setHargaPoin(hargaPoin);
        produk.setStok(stok);
        produk.setGambar(gambar == null || gambar.isEmpty() ? "-" : gambar);
        produkOlahanRepository.save(produk);
        return "redirect:/pusat?sukses=Produk+berhasil+ditambahkan+ke+katalog";
    }

    @PostMapping("/pusat/batas")
    public String ubahBatasStok(@RequestParam Double batasStok, HttpSession session) {
        if (!"pusat".equals(session.getAttribute("role"))) {
            return "redirect:/login";
        }
        StokMinyak stok = stokMinyakRepository.findAll().isEmpty()
                ? buatStokBaru() : stokMinyakRepository.findAll().get(0);
        stok.setBatasStok(batasStok);
        stokMinyakRepository.save(stok);
        return "redirect:/pusat?sukses=Batas+stok+berhasil+diperbarui";
    }

    private StokMinyak buatStokBaru() {
        StokMinyak stok = new StokMinyak();
        stok.setJumlahMinyak(0.0);
        stok.setBatasStok(10000.0);
        stok.setJumlahUpdate(0.0);
        stok.setTglUpdate(LocalDate.now());
        stok.setPusat(pusatRepository.findAll().get(0));
        return stok;
    }
}
