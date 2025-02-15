package br.eng.jonnes.core.domain.model;

import java.util.Objects;

public class Friend {
    private String name;
    private String telephone;
    private int age;
    private boolean adult;

    public Friend() {
    }

    public Friend(String name, String telephone, int age, boolean adult) {
        this.name = name;
        this.telephone = telephone;
        this.age = age;
        this.adult = adult;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friend friend = (Friend) o;
        return age == friend.age && adult == friend.adult && Objects.equals(name, friend.name) && Objects.equals(telephone, friend.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, telephone, age, adult);
    }

    @Override
    public String toString() {
        return "Friend{" +
                "name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", age=" + age +
                ", adult=" + adult +
                '}';
    }
}
