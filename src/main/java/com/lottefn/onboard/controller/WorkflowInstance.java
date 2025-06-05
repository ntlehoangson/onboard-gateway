package com.lottefn.onboard.controller;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "workflow_instance")
public class WorkflowInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderId;

    private String phone;

    private String userId;

    private String currentState;


//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "workflow_step_history", joinColumns = @JoinColumn(name = "workflow_instance_id"))
//    @Column(name = "step")
//    private List<String> stepHistory = new ArrayList<>();

    // Dữ liệu verify
    private String username;
    private Boolean firstAuthen;
    private Boolean forgotPassword;
    private Boolean otpSent;
    private Boolean passwordSetFirstTime;

    // Dữ liệu eKYC
    private String dob;
    private String fullName;
    private String queQuan;
    private String nguyenQuan;
    private String diaChi;
    private String trangThai;
    private String congViec;
    private String gioiTinh;

    // Dữ liệu AddInfo
    private String tenCoQuan;
    private Integer soLanAccept;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // getters/setters ...
}
