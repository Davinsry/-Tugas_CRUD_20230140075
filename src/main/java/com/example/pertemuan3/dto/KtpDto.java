package com.example.pertemuan3.dto;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

public class KtpDto {
    private Integer id;
    
    @NotBlank(message = "Nomor KTP is required")
    private String nomorKtp;
    
    @NotBlank(message = "Nama Lengkap is required")
    private String namaLengkap;
    
    @NotBlank(message = "Alamat is required")
    private String alamat;
    
    private LocalDate tanggalLahir;
    
    @NotBlank(message = "Jenis Kelamin is required")
    private String jenisKelamin;

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNomorKtp() { return nomorKtp; }
    public void setNomorKtp(String nomorKtp) { this.nomorKtp = nomorKtp; }
    public String getNamaLengkap() { return namaLengkap; }
    public void setNamaLengkap(String namaLengkap) { this.namaLengkap = namaLengkap; }
    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }
    public LocalDate getTanggalLahir() { return tanggalLahir; }
    public void setTanggalLahir(LocalDate tanggalLahir) { this.tanggalLahir = tanggalLahir; }
    public String getJenisKelamin() { return jenisKelamin; }
    public void setJenisKelamin(String jenisKelamin) { this.jenisKelamin = jenisKelamin; }
}
