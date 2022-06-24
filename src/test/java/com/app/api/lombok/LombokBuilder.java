package com.app.api.lombok;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Getter
@Data
public class LombokBuilder {
    private String firstName;
    private String lastName;
    private String email;
    private String programme;
    private String[] courses;
}
