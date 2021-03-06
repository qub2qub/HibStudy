/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.den.jh.associations.many2many;

import java.util.Set;

/**
 *
 * @author mkonda
 */
public class Student {

    private int id = 0;
    private String name = null;
    private Set<Course> courses = null;

    public Student(String name){
        setName(name);
    }

    public Student() {
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

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

}
