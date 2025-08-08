package tv.novi.techiteasy.dtos;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class TelevisionRequestDto {

    @NotNull(message = "Type is required")
    private String type;
    @NotNull(message = "Brand is required")
    private String brand;
    @Size(max = 20, message = "Name must be between 0-20 characters")
    private String name;
    @Positive(message = "Price must be higher than zero")
    private Double price;
    private Double availableSize;
    private int refreshRate;
    private String screenType;
    private String screenQuality;
    private LocalDate soldDate;
    private LocalDate originalStockDate;
    private Boolean ambilight;
    private Boolean blueTooth;
    private Boolean hdr;
    private Integer originalStock;
    private Boolean smartTv;
    private Integer sold;
    private Boolean voiceControl;
    private Boolean wifi;


    public String getType() {return type;    }
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

    public LocalDate getSoldDate() { return soldDate;   }
    public void setSoldDate(String soldDate) {
        this.soldDate = LocalDate.parse(soldDate);
    }

    public LocalDate getOriginalStockDate() {
        return originalStockDate;
    }
    public void setOriginalStockDate(String originalStockDate) {
        this.originalStockDate = LocalDate.parse(originalStockDate);
    }

    public Boolean getAmbilight() {
        return ambilight;
    }
    public void setAmbilight(Boolean ambilight) { this.ambilight = ambilight;    }

    public Boolean getBluetooth() {
        return blueTooth;
    }
    public void setBlueTooth(Boolean blueTooth) {
        this.blueTooth = blueTooth;
    }

    public Boolean getHdr() {
        return hdr;
    }
    public void setHdr(Boolean hdr) {
        this.hdr = hdr;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }
    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }

    public Boolean getSmartTv() {
        return smartTv;
    }
    public void setSmartTv(Boolean smartTv) {
        this.smartTv = smartTv;
    }

    public Integer getSold() {
        return sold;
    }
    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public Boolean getVoiceControl() {
        return voiceControl;
    }
    public void setVoiceControl(Boolean voiceControl) {
        this.voiceControl = voiceControl;
    }

    public Boolean getWifi() {
        return wifi;
    }
    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }
}













