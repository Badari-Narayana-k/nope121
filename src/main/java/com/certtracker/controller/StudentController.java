package com.certtracker.controller;

import com.certtracker.service.CertificateService;
import com.certtracker.dto.CertificateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {
    
    private final CertificateService certificateService;
    
    @GetMapping("/certificates")
    public ResponseEntity<?> getMyCertificates() {
        return ResponseEntity.ok(certificateService.getCurrentUserCertificates());
    }
    
    @PostMapping("/certificates")
    public ResponseEntity<?> addCertificate(@RequestBody CertificateRequest request) {
        return ResponseEntity.ok(certificateService.addCertificate(request));
    }
} 