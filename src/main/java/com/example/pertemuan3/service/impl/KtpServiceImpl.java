package com.example.pertemuan3.service.impl;

import com.example.pertemuan3.dto.KtpDto;
import com.example.pertemuan3.entity.Ktp;
import com.example.pertemuan3.mapper.KtpMapper;
import com.example.pertemuan3.repository.KtpRepository;
import com.example.pertemuan3.service.KtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KtpServiceImpl implements KtpService {

    @Autowired
    private KtpRepository ktpRepository;

    @Autowired
    private KtpMapper ktpMapper;

    @Override
    public KtpDto createKtp(KtpDto ktpDto) {
        if (ktpRepository.findByNomorKtp(ktpDto.getNomorKtp()).isPresent()) {
            throw new RuntimeException("Nomor KTP already exists: " + ktpDto.getNomorKtp());
        }
        Ktp ktp = ktpMapper.toEntity(ktpDto);
        return ktpMapper.toDto(ktpRepository.save(ktp));
    }

    @Override
    public List<KtpDto> getAllKtp() {
        return ktpRepository.findAll().stream()
                .map(ktpMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public KtpDto getKtpById(Integer id) {
        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KTP not found with id: " + id));
        return ktpMapper.toDto(ktp);
    }

    @Override
    public KtpDto updateKtp(Integer id, KtpDto ktpDetails) {
        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KTP not found with id: " + id));
        
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
        
        return ktpMapper.toDto(ktpRepository.save(ktp));
    }

    @Override
    public void deleteKtp(Integer id) {
        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KTP not found with id: " + id));
        ktpRepository.delete(ktp);
    }
}
