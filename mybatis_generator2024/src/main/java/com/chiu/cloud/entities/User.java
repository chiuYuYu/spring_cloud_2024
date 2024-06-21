package com.chiu.cloud.entities;

/**
 * ClassName:User
 * Package:com.chiu.cloud.entities
 * Description:
 *
 * @Author chiu
 * @Create 2024/6/19 下午 12:00
 * @Version 1.0
 */
public class User {

    private String name;
    private Integer age;
    private  Startus startus=Startus.a;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Startus getStartus() {
        return startus;
    }

    public void setStartus(Startus startus) {
        this.startus = startus;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", startus=" + startus +
                '}';
    }
}
