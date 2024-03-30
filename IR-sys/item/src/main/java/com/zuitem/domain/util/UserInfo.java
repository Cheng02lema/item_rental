package com.zuitem.domain.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserInfo {
    private String username;

    private String password;
    private String type;
    private String idcard;
    private String phone;
    private Integer user_id;
    private String nickname;
}
