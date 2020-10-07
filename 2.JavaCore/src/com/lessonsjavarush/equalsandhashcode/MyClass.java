package com.lessonsjavarush.equalsandhashcode;

public class MyClass {
    private Long id;
    private String name;

    public MyClass(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    @Override
    public boolean equals(Object o){
        System.out.println("Equals is called: " + this + " : " + o);
        MyClass other = (MyClass) o;
        return  id.equals(other.id) && name.equals(other.name);
    }
    @Override
    public int hashCode(){
        System.out.println("Hashcode is called: " + this);
        return id.intValue();
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
