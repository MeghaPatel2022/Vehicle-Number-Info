package com.bbotdev.vahaninfo.objectdata;

public class FuelData {

    public String cityname;
    public String citycode;
    public boolean header;

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public boolean isHeader() {
        return header;
    }

    public void setHeader(boolean header) {
        this.header = header;
    }

    @Override
    public boolean equals(Object object) {
        boolean sameSame = false;

        if (object != null && object instanceof FuelData) {
            sameSame = this.getCityname().equals(((FuelData) object).getCityname());
        }

        return sameSame;
    }
}
