package com.app.globalgates.dto;

import com.app.globalgates.common.enumeration.Status;
import com.app.globalgates.domain.PostVO;
import com.app.globalgates.domain.TempProductVO;

public class TempProductDTO {
    private Long id;
    private Long memberId;
    private Status postStatus;
    private String postTitle;
    private String postContent;
    private String location;
    private Long replyPostId;

    // tbl_post-product 속성
    private Long productCategoryId;
    private int productPrice;
    private int productStock;

    public PostVO toPostVO() {
        return PostVO.builder()
                .id(id)
                .memberId(memberId)
                .postStatus(postStatus)
                .postTitle(postTitle)
                .postContent(postContent)
                .location(location)
                .replyPostId(replyPostId)
                .build();
    }

    public TempProductVO toProductVO() {
        return TempProductVO.builder()
                .id(id)
                .productCategoryId(productCategoryId)
                .productPrice(productPrice)
                .productStock(productStock)
                .build();
    }
}
