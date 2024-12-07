package com.certtracker.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class CertificateRequest {
    private String name;
    private String certificateUrl;
    private String certificateId;
    private LocalDate validityDate;
} 