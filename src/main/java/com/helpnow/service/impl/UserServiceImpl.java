package com.helpnow.service.impl;

import com.helpnow.dto.UserDTO;
import com.helpnow.entity.CardEntity;
import com.helpnow.entity.UserEntity;
import com.helpnow.repository.CardRepository;
import com.helpnow.repository.UserRepository;
import com.helpnow.service.UserService;
import com.helpnow.util.EncryptUtils;
import com.helpnow.util.EntityDTOConverter;
import com.helpnow.util.ErrorMessages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    CardRepository cardRepository;

    @Override
    public String createUser(UserDTO userDTO, String password) {
        if (userRepository.findByUserEmail(userDTO.getUserEmail()) == null) {
            UserEntity userEntity = EntityDTOConverter.getUserEntityFromDTO(userDTO);
            userEntity.setUserDBId(UUID.randomUUID().toString());
            userEntity.setUserPassword(EncryptUtils.encrypt(password));
            CardEntity cardEntity = new CardEntity();
            cardEntity.setCardDBId(UUID.randomUUID().toString());
            cardEntity.setCardBalance(30L);
            LocalDate localDate = LocalDate.now().plusYears(3);
            cardEntity.setCardExpireDay(localDate);
            cardEntity.setCardExpireMonth(localDate);
            cardEntity.setCardExpireYear(localDate);
            cardEntity.setCardHolderName(userEntity.getUserName());

            try {
                userRepository.save(userEntity);
                cardRepository.save(cardEntity);
                return userEntity.getUserDBId();
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.CONTACT_ADMIN);
            }
        } else {
            return "Duplicate";
        }
    }

    @Override
    public UserDTO signInUser(String email, String password) {
        UserEntity userEntity = userRepository.findByUserEmailAndUserPassword(email, EncryptUtils.encrypt(password));

        if (userEntity != null) {
            return EntityDTOConverter.getUserDTOFromEntity(userEntity);
        } else {
            return null;
        }
    }

}
