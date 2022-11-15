package models;

import java.util.Objects;

public class Cat {
    private Integer id;
    private String name;
    private Integer owner_id;
    private Integer age;
    private String breed;
    private String character;
    private String owner_username;
    private String photo;

    public Cat(Integer id, String name, Integer owner_id, Integer age, String breed, String character, String photo) {
        this.id = id;
        this.name = name;
        this.owner_id = owner_id;
        this.age = age;
        this.breed = breed;
        this.character = character;
        this.photo = photo;
    }
    public Cat(String name, Integer age, String breed, String character, String owner_username, String photo) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.character = character;
        this.owner_username = owner_username;
        this.photo = photo;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getOwner_id() {
        return owner_id;
    }

    public Integer getAge() {
        return age;
    }

    public String getBreed() {
        return breed;
    }

    public String getCharacter() {
        return character;
    }

    public String getOwner_username() {
        return owner_username;
    }

    public String getPhoto() {
        return photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return id.equals(cat.id) && name.equals(cat.name) && owner_id.equals(cat.owner_id) && age.equals(cat.age) && breed.equals(cat.breed) && character.equals(cat.character);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, owner_id, age, breed, character);
    }

}
