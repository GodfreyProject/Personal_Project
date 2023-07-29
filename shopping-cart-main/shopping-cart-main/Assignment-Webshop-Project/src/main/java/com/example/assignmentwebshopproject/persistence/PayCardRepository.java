package com.example.assignmentwebshopproject.persistence;

import com.example.assignmentwebshopproject.persistence.entity.PaymentByCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayCardRepository extends JpaRepository<PaymentByCard, Long> {
    boolean existsByAddress(String address);

    boolean existsByIbanCardno(String ibanCardno);

    boolean existsByZipcode(String zipcode);
}
