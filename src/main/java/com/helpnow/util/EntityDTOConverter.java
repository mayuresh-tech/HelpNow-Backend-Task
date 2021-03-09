package com.helpnow.util;

import com.helpnow.dto.CardDTO;
import com.helpnow.dto.UserDTO;
import com.helpnow.entity.CardEntity;
import com.helpnow.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

@SuppressWarnings("serial")
public class EntityDTOConverter {

    private EntityDTOConverter() {

    }

    private static ModelMapper getUserDTOMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(new PropertyMap<UserEntity, UserDTO>() {
            @Override
            protected void configure() {
            }
        });
        return mapper;
    }

    public static UserDTO getUserDTOFromEntity(UserEntity userEntity) {
        return getUserDTOMapper().map(userEntity, UserDTO.class);
    }

    public static UserEntity getUserEntityFromDTO(UserDTO userDTO) {
        return new ModelMapper().map(userDTO, UserEntity.class);
    }

    private static ModelMapper getCardDTOMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(new PropertyMap<CardEntity, CardDTO>() {
            @Override
            protected void configure() {
            }
        });
        return mapper;
    }

    public static CardDTO getCardDTOFromEntity(CardEntity cardEntity) {
        CardDTO cardDTO = getCardDTOMapper().map(cardEntity, CardDTO.class);
        cardDTO.setCardExpireDay(cardEntity.getCardExpireDay().getDayOfMonth());
        cardDTO.setCardExpireMonth(cardEntity.getCardExpireMonth().getMonthValue());
        cardDTO.setCardExpireYear(cardEntity.getCardExpireYear().getYear());
        return cardDTO;
    }

    public static CardEntity getCardEntityFromDTO(CardDTO cardDTO) {
        return new ModelMapper().map(cardDTO, CardEntity.class);
    }
}
