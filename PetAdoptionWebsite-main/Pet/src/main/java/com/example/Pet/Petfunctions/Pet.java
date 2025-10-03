package com.example.Pet.Petfunctions;

public class Pet {

    private String PDesc;
    private int PID;
    private String PPhoto;
     private String PName;
     private int PAge;
     private String PBreed;
     private String PHealth;



    private int Sid;
public Pet(){

}
    public Pet(String PDesc, int PID, String PPhoto, String PName, int PAge, String PBreed, String PHealth, int Sid) {
        this.PDesc = PDesc;
        this.PID = PID;
        this.PPhoto = PPhoto;
        this.PName = PName;
        this.PAge = PAge;
        this.PBreed = PBreed;
        this.PHealth = PHealth;
        this.Sid = Sid;
    }

    public int getPAge() {
        return PAge;
    }

    public String getPBreed() {
        return PBreed;
    }

    public void setPBreed(String PBreed) {
        this.PBreed = PBreed;
    }

    public void setPAge(int PAge) {
        this.PAge = PAge;
    }

    public String getPDesc() {
        return PDesc;
    }

    public String getPHealth() {
        return PHealth;
    }

    public void setPHealth(String PHealth) {
        this.PHealth = PHealth;
    }

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public String getPName() {
        return PName;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }

    public void setPDesc(String PDesc) {
        this.PDesc = PDesc;
    }

    public String getPPhoto() {
        return PPhoto;
    }

    public void setPPhoto(String PPhoto) {
        this.PPhoto = PPhoto;
    }

    public int getSid() {
        return Sid;
    }

    public void setSid(int sid) {
        Sid = sid;
    }
}