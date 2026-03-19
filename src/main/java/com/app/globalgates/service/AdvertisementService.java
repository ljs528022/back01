package com.app.globalgates.service;

import com.app.globalgates.common.enumeration.FileContentType;
import com.app.globalgates.dto.AdvertisementDTO;
import com.app.globalgates.dto.FileAdvertisementDTO;
import com.app.globalgates.dto.FileDTO;
import com.app.globalgates.repository.AdvertisementDAO;
import com.app.globalgates.repository.FileAdvertisementDAO;
import com.app.globalgates.repository.FileDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdvertisementService {
    private final AdvertisementDAO advertisementDAO;
    private final FileDAO fileDAO;
    private final FileAdvertisementDAO fileAdvertisementDAO;

    // 광고 등록
    public String save(AdvertisementDTO advertisementDTO,
                     ArrayList<MultipartFile> images) {
        String path = getTodayPath();

        advertisementDAO.save(advertisementDTO);

        // 이미지가 있다면 저장
        if(!images.isEmpty()) {
            images.forEach(image -> {
                UUID uuid = UUID.randomUUID();
                FileDTO fileDTO = new FileDTO();
                fileDTO.setOriginalName(image.getOriginalFilename());
                fileDTO.setFileName(uuid.toString() + "_" + image.getOriginalFilename());
                fileDTO.setFilePath(path);
                fileDTO.setFileSize(image.getSize());
                fileDTO.setContentType(image.getContentType().contains("image") ? FileContentType.IMAGE : FileContentType.ETC);
                fileDAO.save(fileDTO);

                FileAdvertisementDTO fileAdDTO = new FileAdvertisementDTO();
                fileAdDTO.setId(fileDTO.getId());
                fileAdDTO.setAdId(advertisementDTO.getId());
                fileAdvertisementDAO.save(fileAdDTO.toFileAdVO());
            });
        }

        return path;
    }

    // 광고 전체 조회
    public List<AdvertisementDTO> getAllAds() {
        return advertisementDAO.findAll();
    }

    // 광고 검색 조회

    // 광고 상세 조회


    // 오늘자 경로 생성
    public String getTodayPath(){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
}
