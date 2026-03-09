package com.example.pertemuan3.mapper;

import com.example.pertemuan3.dto.KtpDto;
import com.example.pertemuan3.entity.Ktp;
import org.springframework.stereotype.Component;

@Component
public class KtpMapper {

    public KtpDto toDto(Ktp entity) {
        if (entity == null) return null;
        KtpDto dto = new KtpDto();
        dto.setId(entity.getId());
        dto.setNomorKtp(entity.getNomorKtp());
        dto.setNamaLengkap(entity.getNamaLengkap());
        dto.setAlamat(entity.getAlamat());
        dto.setTanggalLahir(entity.getTanggalLahir());
        dto.setJenisKelamin(entity.getJenisKelamin());
        return dto;
    }

    public Ktp toEntity(KtpDto dto) {
        if (dto == null) return null;
        Ktp entity = new Ktp();
        entity.setId(dto.getId());
        entity.setNomorKtp(dto.getNomorKtp());
        entity.setNamaLengkap(dto.getNamaLengkap());
        entity.setAlamat(dto.getAlamat());
        entity.setTanggalLahir(dto.getTanggalLahir());
        entity.setJenisKelamin(dto.getJenisKelamin());
        return entity;
    }
}
