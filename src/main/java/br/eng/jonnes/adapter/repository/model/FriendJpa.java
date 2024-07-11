package br.eng.jonnes.adapter.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class FriendJpa {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String telephone;
    private int age;
    private boolean adult;

    public FriendJpa(String name, String telephone, int age, boolean adult) {
        this.id = null;
        this.name = name;
        this.telephone = telephone;
        this.age = age;
        this.adult = adult;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }
}
