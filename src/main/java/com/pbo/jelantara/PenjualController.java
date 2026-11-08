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
public class PenjualController {

    @Value("${jelantara.harga-per-liter}")
    private double hargaPerLiter;

    @Autowired
    private PenjualRepository penjualRepository;
    @Autowired
    private PenjualanRepository penjualanRepository;
    @Autowired
    private PusatRepository pusatRepository;
    @Autowired
    private ProdukOlahanRepository produkOlahanRepository;
    @Autowired
    private PenukaranPoinRepository penukaranPoinRepository;

    @GetMapping("/penjual")
    public String halamanPenjual(Model model, HttpSession session) {
        if (!"penjual".equals(session.getAttribute("role"))) {
            return "redirect:/login";
        }
        Penjual penjual = penjualRepository.findById((Long) session.getAttribute("userId")).orElse(null);
        if (penjual == null) {
            return "redirect:/logout";
        }
        model.addAttribute("penjual", penjual);
        model.addAttribute("listTransaksi", penjualanRepository.findByPenjualIdPenjualOrderByTanggalTransaksiDesc(penjual.getIdPenjual()));
        model.addAttribute("listProduk", produkOlahanRepository.findAll());
        model.addAttribute("listPenukaran", penukaranPoinRepository.findByPenjualIdPenjualOrderByTglPenukaranDesc(penjual.getIdPenjual()));
        return "penjual";
    }

    @PostMapping("/penjual/ajukan")
    public String ajukanPenjualan(@RequestParam Double jumlahMinyak,
                                  @RequestParam String jenisMinyak,
                                  @RequestParam String lokasiPenjemputan,
                                  @RequestParam String catatan,
                                  @RequestParam(required = false) String foto,
                                  HttpSession session) {
        if (!"penjual".equals(session.getAttribute("role"))) {
            return "redirect:/login";
        }
        Penjual penjual = penjualRepository.findById((Long) session.getAttribute("userId")).orElse(null);
        if (penjual == null) {
            return "redirect:/logout";
        }
        Penjualan pj = new Penjualan();
        pj.setTanggalTransaksi(LocalDate.now());
        pj.setJumlahMinyak(jumlahMinyak);
        pj.setJenisMinyak(jenisMinyak);
        pj.setLokasiPenjemputan(lokasiPenjemputan);
        pj.setCatatan(catatan == null || catatan.isEmpty() ? "-" : catatan);
        pj.setFoto(foto == null || foto.isEmpty() ? "-" : foto);
        pj.setStatus("menunggu");
        pj.setHargaMinyak(hargaPerLiter);
        pj.setPenjual(penjual);
        pj.setPusat(pusatRepository.findAll().get(0));
        penjualanRepository.save(pj);
        return "redirect:/penjual?sukses=Permintaan+penjemputan+berhasil+dibuat";
    }

    @PostMapping("/penjual/tukar")
    public String tukarPoin(@RequestParam Long produkId,
                            @RequestParam String alamatPengantaran,
                            HttpSession session) {
        if (!"penjual".equals(session.getAttribute("role"))) {
            return "redirect:/login";
        }
        Penjual penjual = penjualRepository.findById((Long) session.getAttribute("userId")).orElse(null);
        if (penjual == null) {
            return "redirect:/logout";
        }
        ProdukOlahan produk = produkOlahanRepository.findById(produkId).orElse(null);
        if (produk == null) {
            return "redirect:/penjual?error=Produk+tidak+ditemukan";
        }
        if (produk.getStok() <= 0) {
            return "redirect:/penjual?error=Stok+produk+habis";
        }
        if (penjual.getPoin() < produk.getHargaPoin()) {
            return "redirect:/penjual?error=Poin+kamu+belum+mencukupi";
        }
        PenukaranPoin pt = new PenukaranPoin();
        pt.setPenjual(penjual);
        pt.setProduk(produk);
        pt.setJumlahPoin(produk.getHargaPoin());
        pt.setHargaPoinSatuan(produk.getHargaPoin());
        pt.setAlamatPengantaran(alamatPengantaran);
        pt.setTglPenukaran(LocalDate.now());
        penukaranPoinRepository.save(pt);
        penjual.setPoin(penjual.getPoin() - produk.getHargaPoin());
        penjualRepository.save(penjual);
        produk.setStok(produk.getStok() - 1);
        produkOlahanRepository.save(produk);
        return "redirect:/penjual?sukses=Penukaran+poin+berhasil";
    }
}
