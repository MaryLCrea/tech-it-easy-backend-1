//package tv.novi.techiteasy.services;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import tv.novi.techiteasy.dtos.TelevisionRequestDto;
//import tv.novi.techiteasy.dtos.TelevisionResponseDto;
//import tv.novi.techiteasy.models.Television;
//import tv.novi.techiteasy.repositories.TelevisionRepository;
//import tv.novi.techiteasy.exceptions.RecordNotFoundException;
//import java.util.List;
//import java.util.stream.Collectors;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;
//
//@Service
//public class TelevisionService {
//
//    private final TelevisionRepository televisionRepository;
//
//    @Autowired
//    public TelevisionService(TelevisionRepository televisionRepository) {
//        this.televisionRepository = televisionRepository;
//    }
//
//
//    public static TelevisionResponseDto toDto(Television television) {
//        TelevisionResponseDto dto = new TelevisionResponseDto();
//        dto.setId(television.getId());
//        dto.setType(television.getType());
//        dto.setBrand(television.getBrand());
//        dto.setName(television.getName());
//        dto.setPrice(television.getPrice());
//        dto.setAvailableSize(television.getAvailableSize());
//        dto.setRefreshRate(String.valueOf(television.getRefreshRate()));
//        dto.setScreenType(television.getScreenType());
//        dto.setScreenQuality(television.getScreenQuality());
//        dto.setSoldDate(television.getSoldDate());
//        dto.setOriginalStockDate(television.getOriginalStockDate());
//        return dto;
//    }
//
//    // DTO -> Entity
//    public static Television toEntity(TelevisionRequestDto inputDto) {
//        Television tv = new Television();
//        tv.setType(inputDto.getType());
//        tv.setBrand(inputDto.getBrand());
//        tv.setName(inputDto.getName());
//        tv.setPrice(inputDto.getPrice());
//        tv.setAvailableSize(inputDto.getAvailableSize());
//        tv.setRefreshRate(inputDto.getRefreshRate());
//        tv.setScreenType(inputDto.getScreenType());
//        tv.setScreenQuality(inputDto.getScreenQuality());
//        tv.setSoldDate(inputDto.getSoldDate());
//        tv.setOriginalStockDate(inputDto.getOriginalStockDate());
//        return tv;
//    }
//
//    public List<TelevisionResponseDto> getAllTelevisions() {
//        return televisionRepository.findAll()
//                .stream()
//                .map(TelevisionService::toDto)
//                .collect(Collectors.toList());
//    }
//
//    public TelevisionResponseDto getTelevisionById(Long id) {
//        Television tv = televisionRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Television not found"));
//        return toDto(tv);
//    }
//
//    public TelevisionResponseDto saveTelevision(TelevisionRequestDto inputDto) {
//        Television tv = toEntity(inputDto);
//        Television saved = televisionRepository.save(tv);
//        return toDto(saved);
//    }
//
//    public TelevisionResponseDto updateTelevision(Long id, TelevisionRequestDto inputDto) {
//        Television existing = televisionRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Television not found"));
//
//        existing.setType(inputDto.getType());
//        existing.setBrand(inputDto.getBrand());
//        existing.setName(inputDto.getName());
//        existing.setPrice(inputDto.getPrice());
//        existing.setAvailableSize(inputDto.getAvailableSize());
//        existing.setRefreshRate(inputDto.getRefreshRate());
//        existing.setScreenType(inputDto.getScreenType());
//        existing.setScreenQuality(inputDto.getScreenQuality());
//        existing.setSoldDate(inputDto.getSoldDate());
//        existing.setOriginalStockDate(inputDto.getOriginalStockDate());
//        Television updated = televisionRepository.save(existing);
//        return toDto(updated);
//    }
//
//    public void deleteTelevision(Long id) {
//        televisionRepository.deleteById(id);
//        }
//    }

package tv.novi.techiteasy.services;

import tv.novi.techiteasy.dtos.TelevisionRequestDto;
import tv.novi.techiteasy.dtos.TelevisionResponseDto;
import tv.novi.techiteasy.exceptions.RecordNotFoundException;
import tv.novi.techiteasy.models.Television;
import tv.novi.techiteasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository){
        this.televisionRepository = televisionRepository;
    }

    public List<TelevisionResponseDto> getAllTelevisions() {
        List<Television> tvList = televisionRepository.findAll();
        List<TelevisionResponseDto> tvDtoList = new ArrayList<>();

        for(Television tv : tvList) {
            TelevisionResponseDto dto = transferToDto(tv);
            tvDtoList.add(dto);
        }
        return tvDtoList;
    }

    public List<TelevisionResponseDto> getAllTelevisionsByBrand(String brand) {
        List<Television> tvList = televisionRepository.findAllTelevisionsByBrandEqualsIgnoreCase(brand);
        List<TelevisionResponseDto> tvDtoList = new ArrayList<>();

        for(Television tv : tvList) {
            TelevisionResponseDto dto = transferToDto(tv);
            tvDtoList.add(dto);
        }
        return tvDtoList;
    }

    public TelevisionResponseDto getTelevisionById(Long id) {
        Optional<Television> televisionOptional = televisionRepository.findById(id);

        if (televisionOptional.isPresent()){
            Television tv = televisionOptional.get();
            return transferToDto(tv);
        } else {
            throw new RecordNotFoundException("geen televisie gevonden");
        }
    }


    public TelevisionResponseDto addTelevision(TelevisionRequestDto dto) {

        Television tv = transferToTelevision(dto);
        televisionRepository.save(tv);

        return transferToDto(tv);
    }

    public void deleteTelevision(@RequestBody Long id) {

        televisionRepository.deleteById(id);

    }

    public TelevisionResponseDto updateTelevision(Long id, TelevisionRequestDto newTelevision) {

        Optional<Television> televisionOptional = televisionRepository.findById(id);
        if (televisionOptional.isPresent()){

            Television television1 = televisionOptional.get();

            television1.setAmbilight(newTelevision.getAmbilight());
            television1.setAvailableSize(newTelevision.getAvailableSize());
            television1.setBluetooth(newTelevision.getBluetooth());
            television1.setBrand(newTelevision.getBrand());
            television1.setHdr(newTelevision.getHdr());
            television1.setName(newTelevision.getName());
            television1.setOriginalStock(newTelevision.getOriginalStock());
            television1.setPrice(newTelevision.getPrice());
            television1.setRefreshRate(newTelevision.getRefreshRate());
            television1.setScreenQuality(newTelevision.getScreenQuality());
            television1.setScreenType(newTelevision.getScreenType());
            television1.setSmartTv(newTelevision.getSmartTv());
            television1.setSold(newTelevision.getSold());
            television1.setType(newTelevision.getType());
            television1.setVoiceControl(newTelevision.getVoiceControl());
            television1.setWifi(newTelevision.getWifi());
            Television returnTelevision = televisionRepository.save(television1);

            return transferToDto(returnTelevision);

        } else {

            throw new  RecordNotFoundException("geen televisie gevonden");
        }
    }

    public Television transferToTelevision(TelevisionRequestDto dto){
        var television = new Television();

        television.setType(dto.getType());
        television.setBrand(dto.getBrand());
        television.setName(dto.getName());
        television.setPrice(dto.getPrice());
        television.setAvailableSize(dto.getAvailableSize());
        television.setRefreshRate(dto.getRefreshRate());
        television.setScreenType(dto.getScreenType());
        television.setScreenQuality(dto.getScreenQuality());
        television.setSmartTv(dto.getSmartTv());
        television.setWifi(dto.getWifi());
        television.setVoiceControl(dto.getVoiceControl());
        television.setHdr(dto.getHdr());
        television.setBluetooth(dto.getBluetooth());
        television.setAmbilight(dto.getAmbilight());
        television.setOriginalStock(dto.getOriginalStock());
        television.setSold(dto.getSold());

        return television;
    }

        public TelevisionResponseDto transferToDto(Television television){
        TelevisionResponseDto dto = new TelevisionResponseDto();

        dto.setId(television.getId());
        dto.setType(television.getType());
        dto.setBrand(television.getBrand());
        dto.setName(television.getName());
        dto.setPrice(television.getPrice());
        dto.setAvailableSize(television.getAvailableSize());
        dto.setRefreshRate(television.getRefreshRate());
        dto.setScreenType(television.getScreenType());
        dto.setScreenQuality(television.getScreenQuality());
        dto.setSmartTv(television.getWifi());
        dto.setWifi(television.getWifi());
        dto.setVoiceControl(television.getVoiceControl());
        dto.setHdr(television.getHdr());
        dto.setBluetooth(television.getBluetooth());
        dto.setAmbiLight(television.getAmbilight());
        dto.setOriginalStock(television.getOriginalStock());
        dto.setSold(television.getSold());

        return dto;
    }

    public TelevisionResponseDto saveTelevision(TelevisionRequestDto inputDto) {
        Television tv = new Television();
        tv.setBrand(inputDto.getBrand());
        tv.setName(inputDto.getName());
        tv.setPrice(inputDto.getPrice());

        televisionRepository.save(tv);

        TelevisionResponseDto dto = new TelevisionResponseDto();
        dto.setId(tv.getId());
        dto.setBrand(tv.getBrand());
        dto.setName(tv.getName());
        dto.setPrice(tv.getPrice());


        return dto;
    }
}
