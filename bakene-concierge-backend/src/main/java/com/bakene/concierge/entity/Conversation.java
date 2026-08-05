package com.bakene.concierge.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "conversations")
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String whatsappNumber;

    @Column(nullable = false)
    private String userType;

    @Column(nullable = false)
    private String currentStep;

    @Column(nullable = false)
    private String status;

    // =========================
    // SKIN CONSULTATION
    // =========================

    private String skinType;

    private String skinConcern;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    // =========================
    // CONSTRUCTORS
    // =========================

    public Conversation() {
    }

    // =========================
    // CREATE / UPDATE TIMESTAMPS
    // =========================

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();

        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // =========================
    // GETTERS
    // =========================

    public Long getId() {
        return id;
    }

    public String getWhatsappNumber() {
        return whatsappNumber;
    }

    public String getUserType() {
        return userType;
    }

    public String getCurrentStep() {
        return currentStep;
    }

    public String getStatus() {
        return status;
    }

    public String getSkinType() {
        return skinType;
    }

    public String getSkinConcern() {
        return skinConcern;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    // =========================
    // SETTERS
    // =========================

    public void setWhatsappNumber(String whatsappNumber) {
        this.whatsappNumber = whatsappNumber;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setCurrentStep(String currentStep) {
        this.currentStep = currentStep;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSkinType(String skinType) {
        this.skinType = skinType;
    }

    public void setSkinConcern(String skinConcern) {
        this.skinConcern = skinConcern;
    }
}