package com.helpnow.service.impl;

import com.helpnow.dto.CardDTO;
import com.helpnow.entity.CardEntity;
import com.helpnow.entity.UserEntity;
import com.helpnow.repository.CardRepository;
import com.helpnow.repository.UserRepository;
import com.helpnow.service.CardService;
import com.helpnow.service.UserService;
import com.helpnow.util.EncryptUtils;
import com.helpnow.util.EntityDTOConverter;
import com.helpnow.util.ErrorMessages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@Service
@Slf4j
public class CardServiceImpl implements CardService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    UserService userService;

    @Override
    public CardDTO getCardDetails(String userEmail, String userPassword) {
        UserEntity userEntity = userRepository.findByUserEmailAndUserPassword(userEmail, EncryptUtils.encrypt(userPassword));
        if (userEntity != null) {
            return EntityDTOConverter.getCardDTOFromEntity(userEntity.getCardEntity());
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public CardDTO updateBalance(String paymentGatewayAuth, String userEmail, String userPassword, Long addMoney) {
        UserEntity userEntity = userRepository.findByUserEmailAndUserPassword(userEmail, EncryptUtils.encrypt(userPassword));
        if (userEntity != null) {
            CardEntity cardEntity = userEntity.getCardEntity();

            /**
             **  Check if Payment Gateway Response is correct
             **/
            if (true) {
                cardEntity.setCardBalance((cardEntity.getCardBalance() + addMoney));
                try {
                    cardRepository.save(cardEntity);
                } catch (Exception e) {
                    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ErrorMessages.CONTACT_ADMIN);
                }
                return EntityDTOConverter.getCardDTOFromEntity(userEntity.getCardEntity());
            }
            else {
                return null;
            }
        } else {
            return null;
        }
    }
}
