package tv.novi.techiteasy.dtos;

import java.time.LocalDate;

public class TelevisionResponseDto {
    public Long id;
    public String type;
    public String brand;
    public String name;
    public Double price;
    public Double availableSize;
    public int refreshRate;
    public String screenType;
    public String screenQuality;
    public String soldDate;
    public String originalStockDate;
    private Boolean wifi;
    private Boolean smartTv;

    public TelevisionResponseDto() {
    }

    public TelevisionResponseDto(String originalStockDate, String soldDate, String screenQuality, String screenType, int refreshRate, Double availableSize, Double price, String name, String brand, String type, Long id) {
        this.originalStockDate = originalStockDate;
        this.soldDate = soldDate;
        this.screenQuality = screenQuality;
        this.screenType = screenType;
        this.refreshRate = refreshRate;
        this.availableSize = availableSize;
        this.price = price;
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAvailableSize() {
        return availableSize;
    }

    public void setAvailableSize(Double availableSize) {
        this.availableSize = availableSize;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public String getScreenQuality() {
        return screenQuality;
    }

    public void setScreenQuality(String screenQuality) {
        this.screenQuality = screenQuality;
    }

    public String getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(String soldDate) {
        this.soldDate = soldDate;
    }

    public String getOriginalStockDate() {
        return originalStockDate;
    }

    public void setOriginalStockDate(String originalStockDate) {
        this.originalStockDate = originalStockDate;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public void setSmartTv(Boolean smartTv) {
        this.smartTv = smartTv;
    }

    public void setVoiceControl(Boolean voiceControl) {
    }

    public void setHdr(Boolean hdr) {
    }

    public void setBluetooth(Boolean bluetooth) {
    }

    public void setOriginalStock(Integer originalStock) {
    }

    public void setSold(Integer sold) {
    }

    public void setAmbiLight(Object ambiLight) {
    }
}
