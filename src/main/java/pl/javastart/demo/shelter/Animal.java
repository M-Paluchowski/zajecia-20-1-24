package pl.javastart.demo.shelter;

import java.util.Objects;

public class Animal {
    private String name;
    private String description;
    private String imageUrl;
    private AnimalSpecies species;

    public Animal() {

    }

    public Animal(String name, String description, String imageUrl, AnimalSpecies species) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AnimalSpecies getSpecies() {
        return species;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setSpecies(AnimalSpecies species) {
        this.species = species;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", species=" + species +
                '}';
    }
}
