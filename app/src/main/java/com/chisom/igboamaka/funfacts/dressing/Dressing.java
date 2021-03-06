package com.chisom.igboamaka.funfacts.dressing;

public class Dressing {
    private final int dressing_image;
    private final String dressing_type;
    private final String dressing_description;

    public Dressing(int dressing_image, String dressing_type, String dressing_description) {
        this.dressing_image = dressing_image;
        this.dressing_type = dressing_type;
        this.dressing_description = dressing_description;
    }

    public int getDressing_image() {
        return dressing_image;
    }

    public String getDressing_type() {
        return dressing_type;
    }

    public String getDressing_description() {
        return dressing_description;
    }
}
