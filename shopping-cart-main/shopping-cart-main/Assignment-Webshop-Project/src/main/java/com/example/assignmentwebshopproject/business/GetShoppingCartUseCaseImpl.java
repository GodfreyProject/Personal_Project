package com.example.assignmentwebshopproject.business;


import com.example.assignmentwebshopproject.business.impl.GetShoppingCartUseCase;
import com.example.assignmentwebshopproject.business.impl.GetUserUseCase;
import com.example.assignmentwebshopproject.configuration.exception.InvalidUserException;
import com.example.assignmentwebshopproject.dto.AccessTokenDTO;
import com.example.assignmentwebshopproject.dto.ShoppingCartDTO;
import com.example.assignmentwebshopproject.dto.UserDTO;
import com.example.assignmentwebshopproject.persistence.ShoppingCartRepository;
import com.example.assignmentwebshopproject.persistence.UserRepository;
import com.example.assignmentwebshopproject.persistence.entity.RoleEnum;
import com.example.assignmentwebshopproject.persistence.entity.ShoppingCart;
import com.example.assignmentwebshopproject.persistence.entity.User;
import com.example.assignmentwebshopproject.security.auth.UnauthorizedDataAccessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GetShoppingCartUseCaseImpl implements GetShoppingCartUseCase {
    private final ShoppingCartRepository shoppingCartRepository;

    private final AccessTokenDTO requestAccessToken;

    @Override
    public Optional<ShoppingCartDTO> getShoppingCart(Long Id) {

        Optional<ShoppingCart> ShoppingDTO = shoppingCartRepository.findById(Id);


        {
            if(ShoppingDTO.isEmpty()){
                throw  new InvalidUserException("THAT_ORDER_ID_DOES_NOT_EXISTS");
            }

                // return userRepository.findById(Id).map(UserDTOConverter::convertUserToDTO);


            return shoppingCartRepository.findById(Id).map(ShoppingCartDTOConverter::convertShoppingToDTO);
        }

    }

}



