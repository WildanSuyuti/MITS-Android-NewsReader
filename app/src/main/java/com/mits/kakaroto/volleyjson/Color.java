package com.mits.kakaroto.volleyjson;

/**
 * Created by sunari on 25/12/16.
 */

public class Color {
    private int number;
    private String colorName, colorHex;

    public Color(int number, String colorName, String colorHex) {
        this.number = number;
        this.colorName = colorName;
        this.colorHex = colorHex;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorHex() {
        return colorHex;
    }

    public void setColorHex(String colorHex) {
        this.colorHex = colorHex;
    }
}
