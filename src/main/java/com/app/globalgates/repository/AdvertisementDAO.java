package com.app.globalgates.repository;

import com.app.globalgates.common.pagination.Criteria;
import com.app.globalgates.common.search.AdSearch;
import com.app.globalgates.dto.AdvertisementDTO;
import com.app.globalgates.mapper.AdvertisementMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdvertisementDAO {
    private final AdvertisementMapper advertisementMapper;

    // 광고 등록
    public void save(AdvertisementDTO advertisementDTO) {
        advertisementMapper.insert(advertisementDTO);
    }

    // 광고 전체 조회
    public List<AdvertisementDTO> findAll() {
        return advertisementMapper.selectAll();
    }

    // 광고 검색 조회
    public List<AdvertisementDTO> findBySearch(Criteria criteria, AdSearch search) {
        return advertisementMapper.selectBySearch(criteria, search);
    }

    // 검색된 광고 개수
    public int getTotal(AdSearch search) {
        return advertisementMapper.selectTotal(search);
    }

    // 광고 상세 조회
}
