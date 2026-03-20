package com.app.globalgates.common.search;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@NoArgsConstructor
public class AdSearch {
    private Long memberId;
    private String keyword;
    private String filter;
}
