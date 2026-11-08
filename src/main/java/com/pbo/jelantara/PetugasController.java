package com.pbo.jelantara;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

@Controller
public class PetugasController {

    @Value("${jelantara.poin-per-liter}")
    private int poinPerLiter;

    @Autowired
    private PenjualRepository penjualRepository;
    @Autowired
    private PetugasRepository petugasRepository;
    @Autowired
    private PusatRepository pusatRepository;
    @Autowired
    private PenjualanRepository penjualanRepository;
    @Autowired
    private StokMinyakRepository stokMinyakRepository;

    @GetMapping("/petugas")
    public String halamanPetugas(Model model, HttpSession session) {
        if (!"petugas".equals(session.getAttribute("role"))) {
            return "redirect:/login";
        }
        List<Penjualan> listMenunggu = penjualanRepository.findByStatusOrderByIdTransaksiDesc("menunggu");
        List<Penjualan> listRiwayat = penjualanRepository.findByStatusNotOrderByIdTransaksiDesc("menunggu");
        double literTerkumpul = listRiwayat.stream()
                .filter(t -> "berhasil".equals(t.getStatus()))
                .mapToDouble(Penjualan::getJumlahMinyak)
                .sum();
        model.addAttribute("listMenunggu", listMenunggu);
        model.addAttribute("listRiwayat", listRiwayat);
        model.addAttribute("literTerkumpul", literTerkumpul);
        return "petugas";
    }

    @PostMapping("/petugas/perbarui")
    public String perbaruiTransaksi(@RequestParam Long id,
                                    @RequestParam Double jumlahFinal,
                                    @RequestParam String hasil,
                                    @RequestParam String catatanPetugas,
                                    HttpSession session) {
        if (!"petugas".equals(session.getAttribute("role"))) {
            return "redirect:/login";
        }
        Penjualan pj = penjualanRepository.findById(id).orElse(null);
        if (pj == null) {
            return "redirect:/petugas?error=Transaksi+tidak+ditemukan";
        }
        Petugas petugas = petugasRepository.findById((Long) session.getAttribute("userId")).orElse(null);
        if (petugas == null) {
            return "redirect:/logout";
        }
        pj.setPetugas(petugas);
        if ("diterima".equals(hasil)) {
            Pusat pusat = pusatRepository.findAll().get(0);
            double totalHarga = jumlahFinal * pj.getHargaMinyak();
            int hasilPoint = (int) (jumlahFinal * poinPerLiter);
            pj.setJumlahMinyak(jumlahFinal);
            pj.setStatus("berhasil");
            pj.setTotalHarga(totalHarga);
            pj.setHasilPoint(hasilPoint);
            pj.setPusat(pusat);
            Penjual penjual = pj.getPenjual();
            penjual.setPoin(penjual.getPoin() + hasilPoint);
            penjualRepository.save(penjual);
            StokMinyak stok = stokMinyakRepository.findAll().isEmpty()
                    ? buatStokBaru(pusat) : stokMinyakRepository.findAll().get(0);
            stok.setPenjualan(pj);
            stok.setJumlahUpdate(jumlahFinal);
            stok.setTglUpdate(LocalDate.now());
            stok.setJumlahMinyak(stok.getJumlahMinyak() + jumlahFinal);
            stokMinyakRepository.save(stok);
        } else {
            pj.setStatus("ditolak");
            pj.setCatatan(pj.getCatatan() + " | Ditolak: " + catatanPetugas);
        }
        penjualanRepository.save(pj);
        return "redirect:/petugas?sukses=Status+transaksi+berhasil+diperbarui";
    }

    private StokMinyak buatStokBaru(Pusat pusat) {
        StokMinyak stok = new StokMinyak();
        stok.setJumlahMinyak(0.0);
        stok.setBatasStok(10000.0);
        stok.setJumlahUpdate(0.0);
        stok.setTglUpdate(LocalDate.now());
        stok.setPusat(pusat);
        return stok;
    }
}
