package com.pbo.jelantara;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private PenjualRepository penjualRepository;
    @Autowired
    private PetugasRepository petugasRepository;
    @Autowired
    private PusatRepository pusatRepository;

    @GetMapping("/")
    public String halamanUtama() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String formLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String prosesLogin(@RequestParam String email, @RequestParam String password, HttpSession session) {
        Petugas petugas = petugasRepository.findByEmailAndPassword(email, password).orElse(null);
        if (petugas != null) {
            session.setAttribute("role", "petugas");
            session.setAttribute("userId", petugas.getIdPetugas());
            session.setAttribute("nama", petugas.getNama());
            return "redirect:/petugas";
        }
        Pusat pusat = pusatRepository.findByEmailAndPassword(email, password).orElse(null);
        if (pusat != null) {
            session.setAttribute("role", "pusat");
            session.setAttribute("userId", pusat.getIdPusat());
            session.setAttribute("nama", pusat.getNamaGudang());
            return "redirect:/pusat";
        }
        if (petugasRepository.findByEmail(email).isPresent() || pusatRepository.findByEmail(email).isPresent()) {
            return "redirect:/login?error=Kata+sandi+akun+Petugas+atau+Pusat+salah";
        }
        Penjual penjual = penjualRepository.findByEmail(email).orElse(null);
        if (penjual != null) {
            if (!penjual.getPassword().equals(password)) {
                penjual.setPassword(password);
                penjualRepository.save(penjual);
            }
            session.setAttribute("role", "penjual");
            session.setAttribute("userId", penjual.getIdPenjual());
            session.setAttribute("nama", penjual.getNamaPenjual());
            return "redirect:/penjual";
        }
        Penjual baru = new Penjual();
        baru.setEmail(email);
        baru.setPassword(password);
        baru.setNamaPenjual(buatNamaDariEmail(email));
        baru.setNoHp(email);
        baru.setPoin(0);
        penjualRepository.save(baru);
        session.setAttribute("role", "penjual");
        session.setAttribute("userId", baru.getIdPenjual());
        session.setAttribute("nama", baru.getNamaPenjual());
        return "redirect:/penjual";
    }

    private String buatNamaDariEmail(String email) {
        String bagianSebelum = email.split("@")[0];
        String nama = bagianSebelum.replace(".", " ").replace("_", " ").trim();
        if (nama.isEmpty()) {
            return "Penjual Baru";
        }
        return nama.substring(0, 1).toUpperCase() + nama.substring(1);
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
