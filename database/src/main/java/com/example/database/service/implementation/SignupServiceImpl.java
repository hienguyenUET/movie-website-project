package com.example.database.service.implementation;

import com.example.database.model.entity.User;
import com.example.database.repository.SignupRepository;
import com.example.database.service.service.SignupService;
import org.springframework.stereotype.Service;

@Service
public class SignupServiceImpl implements SignupService {
    final SignupRepository signupRepository;

    public SignupServiceImpl(SignupRepository signupRepository) {
        this.signupRepository = signupRepository;
    }

    @Override
    public void save(User user) {
        signupRepository.save(user);
    }
}
