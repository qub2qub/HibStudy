/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.den.jh.associations.one2one.ann;

import by.den.jh.associations.one2one.Engine;

import javax.persistence.*;

/**
 *
 * @author mkonda
 */
@Entity
@Table(name="CAR_ONE2ONE_ANN_UNI")
public class CarUni {
    @Id
    @Column(name="CAR_ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name = null;

    private String color = null;

    @OneToOne (cascade= CascadeType.ALL)
    @JoinColumn(name="ENGINE_ID")
    private EngineUni engine = null;

    public CarUni(){
        
    }
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

    public EngineUni getEngine() {
        return engine;
    }

    public void setEngine(EngineUni engine) {
        this.engine = engine;
    }
    
}
