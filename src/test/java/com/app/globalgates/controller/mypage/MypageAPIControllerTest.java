package com.app.globalgates.controller.mypage;

import com.app.globalgates.auth.CustomUserDetails;
import com.app.globalgates.dto.MemberDTO;
import com.app.globalgates.dto.PostProductWithPagingDTO;
import com.app.globalgates.service.PostProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MypageAPIControllerTest {

    @Mock
    private PostProductService postProductService;

    @InjectMocks
    private MypageAPIController mypageAPIController;

    @Test
    void getMyProducts_returnsPagingDataForAuthenticatedMember() {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(7L);

        CustomUserDetails userDetails = new CustomUserDetails(memberDTO);
        PostProductWithPagingDTO pagingDTO = new PostProductWithPagingDTO();

        when(postProductService.getMyProducts(1, 7L)).thenReturn(pagingDTO);

        PostProductWithPagingDTO result = mypageAPIController.getMyProducts(1, userDetails);

        assertSame(pagingDTO, result);
        verify(postProductService).getMyProducts(1, 7L);
    }
}
