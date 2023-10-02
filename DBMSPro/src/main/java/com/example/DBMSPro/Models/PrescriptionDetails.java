package com.example.DBMSPro.Models;

import jakarta.persistence.*;

@Entity
@Table(name="PRESCRIPTIONDETAILS")
public class PrescriptionDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PrescriptionId;
    private Long OrderId;
    private String PrescriptionDes;
    private String VerificationStatus;

    public Long getPrescriptionId() {
        return PrescriptionId;
    }

    public void setPrescriptionId(Long prescriptionId) {
        PrescriptionId = prescriptionId;
    }

    public Long getOrderId() {
        return OrderId;
    }

    public void setOrderId(Long orderId) {
        OrderId = orderId;
    }

    public String getPrescriptionDes() {
        return PrescriptionDes;
    }

    public void setPrescriptionDes(String prescriptionDes) {
        PrescriptionDes = prescriptionDes;
    }

    public String getVerificationStatus() {
        return VerificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        VerificationStatus = verificationStatus;
    }

    public PrescriptionDetails() {
    }

    public PrescriptionDetails(Long orderId, String prescriptionDes, String verificationStatus) {
        OrderId = orderId;
        PrescriptionDes = prescriptionDes;
        VerificationStatus = verificationStatus;
    }

    public PrescriptionDetails(Long prescriptionId, Long orderId, String prescriptionDes, String verificationStatus) {
        PrescriptionId = prescriptionId;
        OrderId = orderId;
        PrescriptionDes = prescriptionDes;
        VerificationStatus = verificationStatus;
    }


}
