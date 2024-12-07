package com.certtracker.service;

import com.certtracker.dto.CertificateRequest;
import com.certtracker.model.Certificate;
import com.certtracker.repository.CertificateRepository;
import com.certtracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CertificateService {
    private final CertificateRepository certificateRepository;
    private final UserRepository userRepository;

    public List<Certificate> getCurrentUserCertificates() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(username)
            .map(user -> certificateRepository.findByUserId(user.getId()))
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Certificate addCertificate(CertificateRequest request) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("User not found"));

        Certificate certificate = new Certificate();
        certificate.setName(request.getName());
        certificate.setCertificateUrl(request.getCertificateUrl());
        certificate.setCertificateId(request.getCertificateId());
        certificate.setValidityDate(request.getValidityDate());
        certificate.setUser(user);

        return certificateRepository.save(certificate);
    }
} 