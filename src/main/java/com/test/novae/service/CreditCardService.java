package com.test.novae.service;

import com.test.novae.entity.CreditCardEntity;
import com.test.novae.repository.CreditCardRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreditCardService {
    private final Logger logger = LogManager.getLogger(CreditCardService.class);

    @Autowired
    CreditCardRepository repository;

    public CreditCardEntity create(CreditCardEntity creditCard) {
        try {
            return repository.save(creditCard);
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    public CreditCardEntity update(CreditCardEntity creditCard) {
        try {
            return repository.save(creditCard);
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    public Optional<CreditCardEntity> findById(Long id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            logger.error("Error:", e);
            return Optional.empty();
        }
    }

    public Iterable<CreditCardEntity> findAll() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    public void delete (CreditCardEntity creditCard) {
        try {
            repository.delete(creditCard);
        } catch (Exception e) {
            logger.error("Error:", e);
        }
    }

    public Optional<CreditCardEntity> findByCardNumber(String number) {
        try {
            return repository.findByCardNumber(number);
        } catch (Exception e) {
            logger.error("Error:", e);
            return Optional.empty();
        }
    }

}
