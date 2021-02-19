package com.test.novae.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "credit_card", schema="public")
public class CreditCardEntity {

    @GenericGenerator(
            name = "cardGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "card_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1"),
            }
    )

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "cardGenerator")
    private Long id;
    @Column(name = "card_holder_name")
    private String cardHolderName;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "billing_address")
    private String billingAddress;
    @Column(name = "expired_date")
    private Date expireDate;
    @Column(name = "cvv")
    private String cvv;
    @Column(name = "mark_number")
    @NotNull(message = "maskNumber cannot be null")
    private String maskNumber;
    @Column(name="creation_date")
    private Date creationDate;

    public CreditCardEntity() {
    }

    public CreditCardEntity(String cardHolderName, String cardNumber, String billingAddress, Date expireDate, String cvv, String maskNumber) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.billingAddress = billingAddress;
        this.expireDate = expireDate;
        this.cvv = cvv;
        this.maskNumber = maskNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getMaskNumber() {
        return maskNumber;
    }

    public void setMaskNumber(String maskNumber) {
        this.maskNumber = maskNumber;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
