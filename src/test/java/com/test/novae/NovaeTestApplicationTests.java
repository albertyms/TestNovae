package com.test.novae;

import com.test.novae.entity.CreditCardEntity;
import com.test.novae.service.CreditCardService;
import com.test.novae.util.Utils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class NovaeTestApplicationTests {

    @Autowired
    Utils utils;

    @Autowired
    CreditCardService service;

    @Test
    void contextLoads() {
    }

    @Test
    void createCreditCard() {

        String expiredDateSrt1 = "12/2021";
        String expiredDateSrt2 = "12/2022";
        String expiredDateSrt3 = "12/2023";

        //Date expiredDate1 = utils.returnDate(expiredDateSrt1);
        //Date expiredDate2 = utils.returnDate(expiredDateSrt2);
        //Date expiredDate3 = utils.returnDate(expiredDateSrt3);

        CreditCardEntity card1 = new CreditCardEntity("Albert Medina", "5280000100020003",
				"Carrera 1", expiredDateSrt1, "123", "5280000100020003");
        CreditCardEntity card2 = new CreditCardEntity("Albert Medina", "5280000200030005",
				"Carrera 1", expiredDateSrt2, "123", "5280000100020003");
        CreditCardEntity card3 = new CreditCardEntity("Albert Medina", "5280000300040005",
				"Carrera 1", expiredDateSrt3, "123", "5280000100020003");

		List<CreditCardEntity> listCards = new ArrayList<>();
		listCards.add(card1);
		listCards.add(card2);
		listCards.add(card3);

		for (CreditCardEntity card: listCards) {
			CreditCardEntity infoCard;
			card.setCardNumber(utils.encrypt(card.getCardNumber()));
			card.setCvv(utils.encrypt(card.getCvv()));
			card.setMaskNumber(utils.maskingCard(card.getMaskNumber()));
			infoCard = card;
			infoCard = service.create(infoCard);

			assertNotNull(infoCard.getCardNumber());
		}


    }


}
