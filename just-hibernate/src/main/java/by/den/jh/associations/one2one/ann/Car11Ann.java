/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.den.jh.associations.one2one.ann;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author mkonda
 */
@Entity
@Table(name="CAR_ONE2ONE_ANN")
public class Car11Ann {
    @Id
    @Column(name="CAR_ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name = null;
    
    private String color = null;

    // Где указан источник данной ассоциации - там и создастся доп. колонка с FK
    // В данном случае в Car будет +1 колонка = engin_id
    @OneToOne (cascade= CascadeType.ALL)
    @JoinColumn(name="ENGINE_ID")
    private Engine11Ann engine = null;

    public Car11Ann() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Engine11Ann getEngine() {
        return engine;
    }

    public void setEngine(Engine11Ann engine) {
        this.engine = engine;
    }
    
}
