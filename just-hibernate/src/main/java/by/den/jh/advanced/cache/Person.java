/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.den.jh.advanced.cache;

/**
 *
 * @author mkonda
 */
public class Person {

    private int id = 0;
    private String firstName = null;
    private String lastName = null;
    private String nickName = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

}
