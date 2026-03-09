package com.example.pertemuan3.controller;

import com.example.pertemuan3.dto.KtpDto;
import com.example.pertemuan3.model.ApiResponse;
import com.example.pertemuan3.service.KtpService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ktp")
@CrossOrigin(origins = "*")
public class KtpController {

    @Autowired
    private KtpService ktpService;

    @PostMapping
    public ResponseEntity<ApiResponse<KtpDto>> createKtp(@Valid @RequestBody KtpDto ktpDto) {
        KtpDto savedKtp = ktpService.createKtp(ktpDto);
        return ResponseEntity.ok(new ApiResponse<>(true, "Data KTP Berhasil Ditambahkan", savedKtp));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<KtpDto>>> getAllKtp() {
        List<KtpDto> list = ktpService.getAllKtp();
        return ResponseEntity.ok(new ApiResponse<>(true, "Berhasil Mengambil Semua Data KTP", list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<KtpDto>> getKtpById(@PathVariable Integer id) {
        KtpDto ktp = ktpService.getKtpById(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Berhasil Mengambil Data KTP dengan ID: " + id, ktp));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<KtpDto>> updateKtp(@PathVariable Integer id, @Valid @RequestBody KtpDto ktpDto) {
        KtpDto updatedKtp = ktpService.updateKtp(id, ktpDto);
        return ResponseEntity.ok(new ApiResponse<>(true, "Data KTP Berhasil Diperbarui", updatedKtp));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteKtp(@PathVariable Integer id) {
        ktpService.deleteKtp(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Data KTP Berhasil Dihapus", "Successfully deleted KTP with ID: " + id));
    }
}
