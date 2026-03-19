package com.app.globalgates.audit;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter @Setter
@SuperBuilder
public abstract class Period {
    private String createdDatetime;
    private String updatedDatetime;
}
