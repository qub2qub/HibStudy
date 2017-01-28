/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.den.jh.associations.one2one.ann;

import javax.persistence.*;

/**
 *
 * @author mkonda
 */
@Entity
@Table(name="ENGINE_ONE2ONE_ANN_UNI")
public class EngineUni {
    
    @Id
    @Column(name="ENGINE_ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id = 0;
    
    private String make = null;
    
    private String model = null;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
