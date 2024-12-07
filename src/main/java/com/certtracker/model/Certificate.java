package com.certtracker.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "certificates")
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String certificateUrl;
    private String certificateId;
    private LocalDate validityDate;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
} 