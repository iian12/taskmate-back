package com.jygoh.taskmate.domain.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinRequestDto {

    private String username;

    private String password;

    private String email;
}
