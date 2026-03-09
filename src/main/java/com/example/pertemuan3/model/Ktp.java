package com.example.pertemuan3.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "KTP")
public class Ktp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Nomor KTP is required")
    @Column(name = "nomorKtp", unique = true, nullable = false)
    private String nomorKtp;

    @NotBlank(message = "Nama Lengkap is required")
    @Column(name = "namaLengkap", nullable = false)
    private String namaLengkap;

    @NotBlank(message = "Alamat is required")
    @Column(name = "alamat", nullable = false)
    private String alamat;

    @Column(name = "tanggalLahir", nullable = false)
    private LocalDate tanggalLahir;

    @NotBlank(message = "Jenis Kelamin is required")
    @Column(name = "jenisKelamin", nullable = false)
    private String jenisKelamin;

    // Constructors
    public Ktp() {}

    public Ktp(String nomorKtp, String namaLengkap, String alamat, LocalDate tanggalLahir, String jenisKelamin) {
        this.nomorKtp = nomorKtp;
        this.namaLengkap = namaLengkap;
        this.alamat = alamat;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin = jenisKelamin;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomorKtp() {
        return nomorKtp;
    }

    public void setNomorKtp(String nomorKtp) {
        this.nomorKtp = nomorKtp;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public LocalDate getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(LocalDate tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
}
