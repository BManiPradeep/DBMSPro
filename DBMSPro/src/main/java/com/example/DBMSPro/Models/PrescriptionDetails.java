package com.example.DBMSPro.Models;

import jakarta.persistence.*;

import java.util.UUID;

public class PrescriptionDetails {
    private Long PrescriptionId;
    private Long OrderId;
    private String PrescriptionDes;
    private String VerificationStatus;

    public Long getPrescriptionId() {
        return PrescriptionId;
    }

    public void setPrescriptionId(Long prescriptionId) {
        if(prescriptionId==0){
            prescriptionId=(long) UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        }
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
        this.PrescriptionId=(long) UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;;
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
