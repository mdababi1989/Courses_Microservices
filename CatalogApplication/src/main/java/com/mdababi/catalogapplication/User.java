package com.mdababi.catalogapplication;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private BigInteger userId;
    private BigInteger courseId;
    private String username;
}
