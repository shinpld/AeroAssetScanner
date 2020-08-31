package com.example.aeroassetscanner;

public class AItem {
    String Asset,Asset_Sup,Asset_description,Building_Fl,CoCd,Created_on,Description2,Found,
            Invent_no,Location,Location_name,Rack,Remark,Room,Room__1,SNo,Serial_number,Updated;


    public AItem() {
    }

    public AItem(String asset, String asset_Sup, String asset_description, String building_Fl, String coCd, String created_on, String description2, String found, String invent_no, String location, String location_name, String rack, String remark, String room, String room__1, String SNo, String serial_number, String updated) {
        Asset = asset;
        Asset_Sup = asset_Sup;
        Asset_description = asset_description;
        Building_Fl = building_Fl;
        CoCd = coCd;
        Created_on = created_on;
        Description2 = description2;
        Found = found;
        Invent_no = invent_no;
        Location = location;
        Location_name = location_name;
        Rack = rack;
        Remark = remark;
        Room = room;
        Room__1 = room__1;
        this.SNo = SNo;
        Serial_number = serial_number;
        Updated = updated;
    }

    public String getAsset() {
        return Asset;
    }

    public void setAsset(String asset) {
        Asset = asset;
    }

    public String getAsset_Sup() {
        return Asset_Sup;
    }

    public void setAsset_Sup(String asset_Sup) {
        Asset_Sup = asset_Sup;
    }

    public String getAsset_description() {
        return Asset_description;
    }

    public void setAsset_description(String asset_description) {
        Asset_description = asset_description;
    }

    public String getBuilding_Fl() {
        return Building_Fl;
    }

    public void setBuilding_Fl(String building_Fl) {
        Building_Fl = building_Fl;
    }

    public String getCoCd() {
        return CoCd;
    }

    public void setCoCd(String coCd) {
        CoCd = coCd;
    }

    public String getCreated_on() {
        return Created_on;
    }

    public void setCreated_on(String created_on) {
        Created_on = created_on;
    }

    public String getDescription2() {
        return Description2;
    }

    public void setDescription2(String description2) {
        Description2 = description2;
    }

    public String getFound() {
        return Found;
    }

    public void setFound(String found) {
        Found = found;
    }

    public String getInvent_no() {
        return Invent_no;
    }

    public void setInvent_no(String invent_no) {
        Invent_no = invent_no;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getLocation_name() {
        return Location_name;
    }

    public void setLocation_name(String location_name) {
        Location_name = location_name;
    }

    public String getRack() {
        return Rack;
    }

    public void setRack(String rack) {
        Rack = rack;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getRoom() {
        return Room;
    }

    public void setRoom(String room) {
        Room = room;
    }

    public String getRoom__1() {
        return Room__1;
    }

    public void setRoom__1(String room__1) {
        Room__1 = room__1;
    }

    public String getSNo() {
        return SNo;
    }

    public void setSNo(String SNo) {
        this.SNo = SNo;
    }

    public String getSerial_number() {
        return Serial_number;
    }

    public void setSerial_number(String serial_number) {
        Serial_number = serial_number;
    }

    public String getUpdated() {
        return Updated;
    }

    public void setUpdated(String updated) {
        Updated = updated;
    }
}
