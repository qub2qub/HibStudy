/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.den.jh.associations.one2one.ann;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author mkonda
 */
@Entity
@Table(name="ENGINE_ONE2ONE_ANN")
public class Engine11Ann {
    
    @Id
    @Column(name="ENGINE_ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id = 0;
    
    private String make = null;
    
    private String model = null;

    // какое имя у поля в car, в котором хранится данный engine
    @OneToOne(mappedBy="engine")
    private Car11Ann car = null;

    public Car11Ann getCar() {
        return car;
    }

    public void setCar(Car11Ann car) {
        this.car = car;
    }

    
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
