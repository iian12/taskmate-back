package com.jygoh.taskmate.domain.user.service;

import com.jygoh.taskmate.domain.user.dto.JoinRequestDto;
import com.jygoh.taskmate.domain.user.dto.LoginRequestDto;
import com.jygoh.taskmate.domain.user.dto.UpdateRequestDto;

public interface UserService {

    void login(LoginRequestDto loginRequestDto);
    void join(JoinRequestDto joinRequestDto);
    void modify(UpdateRequestDto updateRequestDto);
    void delete(Long userId);
}
