package com.example.DBMSPro.Repository;

import com.example.DBMSPro.Models.PrescriptionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends JpaRepository<PrescriptionDetails,Long> {
}
