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
        television.setSoldDate(dto.getSoldDate());
        television.setOriginalStockDate(dto.getOriginalStockDate());

        return television;
    }
    public TelevisionResponseDto transferToDto(Television television) {
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
        dto.setAmbilight(television.getAmbilight());
        dto.setOriginalStock(television.getOriginalStock());
        dto.setSold(television.getSold());
        dto.setSoldDate(television.getSoldDate());
        dto.setOriginalStockDate(television.getOriginalStockDate());

        return dto;
    }

    public TelevisionResponseDto saveTelevision(TelevisionRequestDto inputDto) {
        Television tv = transferToTelevision(inputDto);
        televisionRepository.save(tv);

        return transferToDto(tv);
    }
}