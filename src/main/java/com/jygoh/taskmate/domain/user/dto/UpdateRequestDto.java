package com.jygoh.taskmate.domain.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateRequestDto {

    private String email;

    private String username;
}
