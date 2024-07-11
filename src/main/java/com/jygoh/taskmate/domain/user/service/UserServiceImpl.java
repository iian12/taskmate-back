package com.jygoh.taskmate.domain.user.service;

import com.jygoh.taskmate.domain.user.dto.JoinRequestDto;
import com.jygoh.taskmate.domain.user.dto.LoginRequestDto;
import com.jygoh.taskmate.domain.user.dto.UpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    @Override
    public void login(LoginRequestDto loginRequestDto) {

    }

    @Override
    public void join(JoinRequestDto joinRequestDto) {

    }

    @Override
    public void modify(UpdateRequestDto updateRequestDto) {

    }

    @Override
    public void delete(Long userId) {

    }
}
