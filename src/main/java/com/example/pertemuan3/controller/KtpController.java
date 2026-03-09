package com.example.pertemuan3.controller;

import com.example.pertemuan3.model.Ktp;
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
    public ResponseEntity<Ktp> createKtp(@Valid @RequestBody Ktp ktp) {
        return ResponseEntity.ok(ktpService.createKtp(ktp));
    }

    @GetMapping
    public ResponseEntity<List<Ktp>> getAllKtp() {
        return ResponseEntity.ok(ktpService.getAllKtp());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ktp> getKtpById(@PathVariable Integer id) {
        return ResponseEntity.ok(ktpService.getKtpById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ktp> updateKtp(@PathVariable Integer id, @Valid @RequestBody Ktp ktp) {
        return ResponseEntity.ok(ktpService.updateKtp(id, ktp));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteKtp(@PathVariable Integer id) {
        ktpService.deleteKtp(id);
        return ResponseEntity.ok("Successfully deleted KTP with ID: " + id);
    }
}
