package com.curelight.vaccineservice.dto;

import java.util.List;

public class VaccineList {

    private List<Vaccine> vaccineList;

    public VaccineList() {
    }

    public List<Vaccine> getVaccineList() {
        return vaccineList;
    }

    public void setVaccineList(List<Vaccine> vaccineList) {
        this.vaccineList = vaccineList;
    }
}
