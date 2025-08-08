package tv.novi.techiteasy.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TV")
public class Television {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String brand;
    private String name;
    private Double price;
    private Double availableSize;
    private int refreshRate;
    private String screenType;
    private String screenQuality;
    private LocalDate soldDate;
    private LocalDate originalStockDate;
    private Boolean smartTv;
    private Boolean wifi;
    private Boolean voiceControl;
    private Boolean hdr;
    private Boolean bluetooth;
    private Boolean ambilight;  // Changed from Object to Boolean
    private Integer originalStock;
    private Integer sold;

    // Default constructor
    public Television() {
    }

    // Constructor with originalStock and sold only
    public Television(Integer originalStock, Integer sold) {
        this.originalStock = originalStock;
        this.sold = sold;
    }

    // Full constructor
    public Television(Long id, String type, String brand, String name, Double price,
                      Double availableSize, int refreshRate, String screenType,
                      String screenQuality, LocalDate soldDate, LocalDate originalStockDate,
                      Boolean smartTv, Boolean wifi, Boolean voiceControl, Boolean hdr,
                      Boolean bluetooth, Boolean ambilight, Integer originalStock, Integer sold) {
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.availableSize = availableSize;
        this.refreshRate = refreshRate;
        this.screenType = screenType;
        this.screenQuality = screenQuality;
        this.soldDate = soldDate;
        this.originalStockDate = originalStockDate;
        this.smartTv = smartTv;
        this.wifi = wifi;
        this.voiceControl = voiceControl;
        this.hdr = hdr;
        this.bluetooth = bluetooth;
        this.ambilight = ambilight;
        this.originalStock = originalStock;
        this.sold = sold;
    }

    // Getters and Setters
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

    public LocalDate getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(LocalDate soldDate) {
        this.soldDate = soldDate;
    }

    public LocalDate getOriginalStockDate() {
        return originalStockDate;
    }

    public void setOriginalStockDate(LocalDate originalStockDate) {
        this.originalStockDate = originalStockDate;
    }

    public Boolean getSmartTv() {
        return smartTv;
    }

    public void setSmartTv(Boolean smartTv) {
        this.smartTv = smartTv;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getVoiceControl() {
        return voiceControl;
    }

    public void setVoiceControl(Boolean voiceControl) {
        this.voiceControl = voiceControl;
    }

    public Boolean getHdr() {
        return hdr;
    }

    public void setHdr(Boolean hdr) {
        this.hdr = hdr;
    }

    public Boolean getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(Boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public Boolean getAmbilight() {  // Changed return type from Object to Boolean
        return ambilight;
    }

    public void setAmbilight(Boolean ambilight) {  // Changed parameter type from Object to Boolean
        this.ambilight = ambilight;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }
}