/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.den.jh.advanced.inheritance.s1;


import javax.persistence.*;

@Entity(name="INHERITANCE_S1_EMPLOYEE_ANN")
@Table(name = "INHERITANCE_S1_EMPLOYEE_ANN")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DISCRIMINATOR", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value="EMPLOYEE")
public class ANNEmployee {
    @Id
    @Column(name="EMPLOYEE_ID")
    private int id = 0;

    private String name = null;
    private String role = null;

    public ANNEmployee(String name){
        setName(name);
    }

    public ANNEmployee() {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
