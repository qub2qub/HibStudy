/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.den.jh.advanced.inheritance.s2;

/**
 *
 * @author mkonda
 */
public class Executive extends Employee{
    private String role = null;
    
    public Executive(String name){
        super(name);
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
