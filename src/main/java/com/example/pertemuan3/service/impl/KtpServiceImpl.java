package com.example.pertemuan3.service.impl;

import com.example.pertemuan3.model.Ktp;
import com.example.pertemuan3.repository.KtpRepository;
import com.example.pertemuan3.service.KtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class KtpServiceImpl implements KtpService {

    @Autowired
    private KtpRepository ktpRepository;

    @Override
    public Ktp createKtp(Ktp ktp) {
        if (ktpRepository.findByNomorKtp(ktp.getNomorKtp()).isPresent()) {
            throw new RuntimeException("Nomor KTP already exists: " + ktp.getNomorKtp());
        }
        return ktpRepository.save(ktp);
    }

    @Override
    public List<Ktp> getAllKtp() {
        return ktpRepository.findAll();
    }

    @Override
    public Ktp getKtpById(Integer id) {
        return ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KTP not found with id: " + id));
    }

    @Override
    public Ktp updateKtp(Integer id, Ktp ktpDetails) {
        Ktp ktp = getKtpById(id);
        
        // Check if new nomorKtp already exists in another record
        ktpRepository.findByNomorKtp(ktpDetails.getNomorKtp())
                .ifPresent(existingKtp -> {
                    if (!existingKtp.getId().equals(id)) {
                        throw new RuntimeException("Nomor KTP already exists in another record");
                    }
                });

        ktp.setNomorKtp(ktpDetails.getNomorKtp());
        ktp.setNamaLengkap(ktpDetails.getNamaLengkap());
        ktp.setAlamat(ktpDetails.getAlamat());
        ktp.setTanggalLahir(ktpDetails.getTanggalLahir());
        ktp.setJenisKelamin(ktpDetails.getJenisKelamin());
        
        return ktpRepository.save(ktp);
    }

    @Override
    public void deleteKtp(Integer id) {
        Ktp ktp = getKtpById(id);
        ktpRepository.delete(ktp);
    }
}
