package org.example.models;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String passportID; //Поле может быть null
    private Color eyeColor; //Поле не может быть null
    private Color hairColor; //Поле может быть null
    private Country nationality; //Поле может быть null

    public Person(String name, String passportID, Color eyeColor, Color hairColor, Country nationality){
        this.name = validateName(name);
        this.passportID = validatePassportId(passportID);
        this.eyeColor = validateEyeColor(eyeColor);
        this.hairColor = validateHairColor(hairColor);
        this.nationality = validateNationality(nationality);
    }


    private String validateName(String value){
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Coordinates value cannot be null and emptyntgВфеф.");
        }
        return value;
    }

    private String validatePassportId(String value){
        if (value == null) {
            throw new IllegalArgumentException("Coordinates value cannot be null.");
        }
        return value;
    }


    private Color validateEyeColor(Color value){
        if (value == null) {
            throw new IllegalArgumentException("Coordinates value cannot be null.");
        }
        return value;
    }

    private Color validateHairColor(Color value){
        if (value == null) {
            throw new IllegalArgumentException("Coordinates value cannot be null.");
        }
        return value;
    }

    private Country validateNationality(Country value){
        if (value == null) {
            throw new IllegalArgumentException("Coordinates value cannot be null.");
        }
        return value;
    }

    public String getName(){
        return  name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPassportID(){
        return  passportID;
    }

    public void setPassportID(String name){
        this.passportID = passportID;
    }

    public Color getEyeColor(){
        return  eyeColor;
    }

    public void setEyeColor(Color name){
        this.eyeColor = eyeColor;
    }

    public Color getHairColor(){
        return  hairColor;
    }

    public void setHairColor(Color hairColor){
        this.hairColor = hairColor;
    }

    public Country getNationality(){
        return nationality;
    }

    public void setNationality(Country nationality){
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", passportID=" + passportID +
                ", eyeColor=" + eyeColor +
                ", hairColor=" + hairColor +
                ", nationality=" + nationality +
                '}';
    }
}


