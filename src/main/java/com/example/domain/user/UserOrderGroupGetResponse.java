package com.example.domain.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class UserOrderGroupGetResponse {
    private UserGetResponse userGetResponse;

    @Builder
    public UserOrderGroupGetResponse(UserGetResponse userGetResponse) {
        this.userGetResponse = userGetResponse;
    }

    public static UserOrderGroupGetResponse from(UserGetResponse userGetResponse) {
        return UserOrderGroupGetResponse.builder()
                .userGetResponse(userGetResponse)
                .build();
    }
}
