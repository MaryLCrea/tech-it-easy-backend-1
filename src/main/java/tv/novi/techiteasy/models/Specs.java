package tv.novi.techiteasy.models;

import tv.novi.techiteasy.models.enums.AvailableSize;
import tv.novi.techiteasy.models.enums.RefreshRate;
import tv.novi.techiteasy.models.enums.ScreenQuality;
import tv.novi.techiteasy.models.enums.ScreenType;

public class Specs {

    private AvailableSize size;
    private RefreshRate refreshRate;
    private ScreenType screentype;
    private ScreenQuality screenQuality;

    public Specs(AvailableSize size, RefreshRate refreshRate, ScreenQuality screenQuality, ScreenType screentype) {
        this.size = size;
        this.refreshRate = refreshRate;
        this.screenQuality = screenQuality;
        this.screentype = screentype;
    }

    public AvailableSize getSize() {
        return size;
    }

    public void setSize(AvailableSize size) {
        this.size = size;
    }

    public RefreshRate getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(RefreshRate refreshRate) {
        this.refreshRate = refreshRate;
    }

    public ScreenType getScreentype() {
        return screentype;
    }

    public void setScreentype(ScreenType screentype) {
        this.screentype = screentype;
    }

    public ScreenQuality getScreenQuality() {
        return screenQuality;
    }

    public void setScreenQuality(ScreenQuality screenQuality) {
        this.screenQuality = screenQuality;
    }
}



