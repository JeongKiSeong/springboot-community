package com.JKS.community.dto;

import com.JKS.community.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class MemberFormDto {
    private String loginId;
    private String password;
    private String name;

    public MemberFormDto(Member member) {
        this.loginId = member.getLoginId();
        this.password = member.getPassword();
        this.name = member.getName();
    }
}