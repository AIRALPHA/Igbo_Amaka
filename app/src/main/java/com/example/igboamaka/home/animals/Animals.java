package com.example.igboamaka.home.animals;

public class Animals {
    private String igboAnimal;
    private String englishAnimal;
    private int animalImage;
    private int backGroundColour;
    private int audio;

    public Animals(String englishAnimal, String igboAnimal, int animalImage, int backGroundColour, int audio) {
        this.igboAnimal = igboAnimal;
        this.englishAnimal = englishAnimal;
        this.animalImage = animalImage;
        this.backGroundColour = backGroundColour;
        this.audio = audio;
    }

    public String getIgboAnimal() {
        return igboAnimal;
    }

    public String getEnglishAnimal() {
        return englishAnimal;
    }

    public int getAnimalImage() {
        return animalImage;
    }

    public int getBackGroundColour() {
        return backGroundColour;
    }

    public int getAudio() { return audio; }
}
