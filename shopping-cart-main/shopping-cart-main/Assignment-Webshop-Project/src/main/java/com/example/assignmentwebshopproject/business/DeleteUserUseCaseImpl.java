package com.example.assignmentwebshopproject.business;

import com.example.assignmentwebshopproject.business.impl.DeleteUserUseCase;
import com.example.assignmentwebshopproject.persistence.UserRepository;

import com.example.assignmentwebshopproject.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

    @Autowired
    private UserRepository userRepository;


    @Override
    @Transactional
    public void deleteUser(Long id) {
        Optional<User> deleteUser = userRepository.findById(id);

        userRepository.deleteById(deleteUser.get().getId());

    }
}
