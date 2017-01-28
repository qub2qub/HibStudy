/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.den.jh.advanced.inheritance.s1;

import javax.persistence.*;

@Entity(name="INHERITANCE_S1_EXECUTIVE_ANN")
@Table(name = "INHERITANCE_S1_EMPLOYEE_ANN")
@DiscriminatorValue(value="EXECUTIVE")
public class ANNExecutive extends Employee {

    @Id
    @Column(name="EMPLOYEE_ID")
    private int id = 0;
    private String role = null;

    public ANNExecutive(String name){
        super(name);
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
