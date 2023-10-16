package com.example.tp_2mobile.beans;

public class Star {
    private int id;
    private String name;
    private String image; // Renommé de "img" à "image"
    private float star;
    private static int comp;

    public Star(String name, String image, float star) { // Modifié ici aussi
        this.id = ++comp;
        this.name = name;
        this.image = image;
        this.star = star;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return image;
    }
    public void setImg(String img) {
        this.image = img;
    }

    public float getStar() {
        return star;
    }

    public void setStar(float star) {
        this.star = star;
    }
}
