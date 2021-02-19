package com.test.novae.controller;

import com.test.novae.entity.CreditCardEntity;
import com.test.novae.request.CreditCardRequest;
import com.test.novae.service.CreditCardService;
import com.test.novae.util.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/creditCard")
@Validated
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CreditCardController {
    private final Logger logger = LogManager.getLogger(CreditCardController.class);

    @Autowired
    CreditCardService service;

    @Autowired
    Utils utils;

    @PostMapping
    public ResponseEntity<CreditCardEntity> create(@Validated @RequestBody CreditCardRequest request) {
        try {
            CreditCardEntity creditCard = new CreditCardEntity();
            creditCard.setCardHolderName(request.getCardHolderName());
            creditCard.setCardNumber(utils.encrypt(request.getCardNumber()));
            creditCard.setBillingAddress(request.getBillingAddress());
            creditCard.setCvv(utils.encrypt(request.getCvv()));
            creditCard.setMaskNumber(utils.maskingCard(request.getMaskNumber()));
            creditCard.setExpireDate(utils.returnDate(request.getExpireDate()));
            creditCard.setCreationDate(new Date());
            return ResponseEntity.ok(service.create(creditCard));
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<CreditCardEntity> findById(@PathVariable Long id) {
        try {
            Optional<CreditCardEntity> creditCard = service.findById(id);
            return creditCard.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<CreditCardEntity>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CreditCardEntity> update(@PathVariable Long id, @Validated @RequestBody CreditCardRequest request) {
        try {
            Optional<CreditCardEntity> creditCard = service.findById(id);
            if(creditCard.isPresent()) {
                creditCard.get().setCardHolderName(request.getCardHolderName());
                creditCard.get().setCardNumber(utils.encrypt(request.getCardNumber()));
                creditCard.get().setBillingAddress(request.getBillingAddress());
                creditCard.get().setCvv(utils.encrypt(request.getCvv()));
                creditCard.get().setMaskNumber(utils.maskingCard(request.getMaskNumber()));
                creditCard.get().setExpireDate(utils.returnDate(request.getExpireDate()));
                return ResponseEntity.ok(service.update(creditCard.get()));
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        try {
            Optional<CreditCardEntity> creditCard = service.findById(id);
            if (creditCard.isPresent()) {
                service.delete(creditCard.get());
                return new ResponseEntity<>(id, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

}
