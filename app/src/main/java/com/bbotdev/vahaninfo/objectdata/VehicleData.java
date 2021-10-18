package com.bbotdev.vahaninfo.objectdata;

public class VehicleData {

    public String registrationNo;
    public String Name;
    public String responce;

    public String getResponce() {
        return responce;
    }

    public void setResponce(String responce) {
        this.responce = responce;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    @Override
    public boolean equals(Object object) {
        boolean sameSame = false;

        if (object != null && object instanceof VehicleData) {
            sameSame = this.getRegistrationNo().equals(((VehicleData) object).getRegistrationNo());
        }

        return sameSame;
    }

}
