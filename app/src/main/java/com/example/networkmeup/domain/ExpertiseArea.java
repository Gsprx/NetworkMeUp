package com.example.networkmeup.domain;

public class ExpertiseArea {
    private String area;

    public ExpertiseArea(String area){
        validateArea(area);
    }

    public String getArea(){
        return this.area;
    }

    public void setArea(String area){
        validateArea(area);
    }

    private void validateArea(String area){
        if (area != null){
            this.area = area;
        }
        else{
            throw new NullPointerException("Area cannot be empty.");
        }
    }
    public boolean equals (ExpertiseArea expertiseArea){
        return (this.area.equals(expertiseArea.area));
    }
}
