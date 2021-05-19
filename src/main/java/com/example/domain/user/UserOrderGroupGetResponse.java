package com.example.domain.user;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class UserOrderGroupGetResponse {
    private UserGetResponse userGetResponse;

    @Builder
    public UserOrderGroupGetResponse(UserGetResponse userGetResponse) {
        this.userGetResponse = userGetResponse;
    }

    public static UserOrderGroupGetResponse of(UserGetResponse userGetResponse) {
        return UserOrderGroupGetResponse.builder()
                .userGetResponse(userGetResponse)
                .build();
    }
}
