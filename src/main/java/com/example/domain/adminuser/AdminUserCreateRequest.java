package com.example.domain.adminuser;

import com.example.annotation.SleepTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class AdminUserCreateRequest {
    @NotBlank(message = "계정 아이디는 필수값입니다.")
    private String account;

    @NotBlank(message = "비밀번호는 필수값입니다.")
    @Size(min=3, max=10)
    private String password;

    @NotBlank(message = "역할은 필수값입니다.")
    private String role;

    @NotBlank(message = "휴무시간은 필수값입니다.")
    @SleepTime(message = "휴무시간은 연도와 월이어야 합니다")
    private String sleepTime;

    public AdminUser toEntity() {
        return AdminUser.builder()
                .account(this.account)
                .password(this.password)
                .role(this.role)
                .sleepTime(this.sleepTime)
                .build();
    }
}
