package com.app.globalgates.mapper;

import com.app.globalgates.common.pagination.Criteria;
import com.app.globalgates.dto.TempProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class ProductMapperTests {
    @Autowired
    private TempProductMapper tempProductMapper;

    @Test
    public void testSelectProducts() {
        Criteria criteria = new Criteria(1, tempProductMapper.selectTotal());

        List<TempProductDTO> foundProducts = tempProductMapper.selectProducts(criteria);
        log.info("찾은 상품 : {}", foundProducts);
    }
}
