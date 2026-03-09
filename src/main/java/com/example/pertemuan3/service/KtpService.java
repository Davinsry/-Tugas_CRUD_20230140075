package com.example.pertemuan3.service;

import com.example.pertemuan3.model.Ktp;
import java.util.List;

public interface KtpService {
    Ktp createKtp(Ktp ktp);
    List<Ktp> getAllKtp();
    Ktp getKtpById(Integer id);
    Ktp updateKtp(Integer id, Ktp ktp);
    void deleteKtp(Integer id);
}
