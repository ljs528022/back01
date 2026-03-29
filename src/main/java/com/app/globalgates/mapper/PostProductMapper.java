package com.app.globalgates.mapper;

import com.app.globalgates.common.pagination.Criteria;
import com.app.globalgates.domain.PostProductVO;
import com.app.globalgates.dto.PostProductDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostProductMapper {
//    상품 등록
    public void insert(PostProductVO postProductVO);

//    특정 회원의 판매품목 목록 조회
    public List<PostProductDTO> selectAllByMemberId(Long memberId);

//    특정 회원의 판매품목 목록 조회 (페이징)
    public List<PostProductDTO> selectAllByMemberIdWithPaging(
            @Param("criteria") Criteria criteria,
            @Param("memberId") Long memberId
    );

//    추천 상품 전체 조회
    public List<PostProductDTO> selectRecommendProducts(@Param("criteria") Criteria criteria);

//    특정 회원의 상품 총 개수
    public int selectTotalByMemberId(Long memberId);

//    상품 총 개수
    public int selectTotal();
}
