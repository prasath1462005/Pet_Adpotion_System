package com.example.Pet.ShelterFunctions;

import org.springframework.stereotype.Component;


public class Shelter {


    private int Sid;
    private String Sname;
    private String Spass;
    private  String Semail;
    private String SPhoneNo;

    public int getSid() {
        return Sid;
    }

    public void setSid(int sid) {
        Sid = sid;
    }

    public String getSPhoneNo() {
        return SPhoneNo;
    }

    public void setSPhoneNo(String SPhoneNo) {
        this.SPhoneNo = SPhoneNo;
    }

    public String getSpass() {
        return Spass;
    }

    public void setSpass(String spass) {
        Spass = spass;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public Shelter(int Sid , String Sname, String Spass, String Semail, String SPhoneNo){
        this.Sid=Sid;
        this.Sname=Sname;
        this.Spass=Spass;
        this.Semail=Semail;
        this.SPhoneNo=SPhoneNo;

    }
  public Shelter(){}

    public String getSemail() {
        return Semail;
    }

    public void setSemail(String semail) {
        Semail = semail;
    }
}

