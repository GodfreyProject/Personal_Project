package com.example.assignmentwebshopproject.persistence;

import com.example.assignmentwebshopproject.persistence.entity.PaymentByCard;
import com.example.assignmentwebshopproject.persistence.entity.PaymentByCash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PayCashRepository extends JpaRepository<PaymentByCash, Long> {
    //@Query("select (count(p) > 0) from PaymentByCash p")
    boolean existsByAddress(String Address);

    boolean existsByZipcode(String zipcode);

    boolean existsByDate(String date);
}
