package com.app.globalgates.mapper;

import com.app.globalgates.common.pagination.Criteria;
import com.app.globalgates.dto.TempProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TempProductMapper {
    // 추천 상품 전체 조회
    public List<TempProductDTO> selectProducts(Criteria criteria);

    // 상품 총 개수
    public int selectTotal();
}
