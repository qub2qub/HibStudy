/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.den.jh.collections.set.ann;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author mkonda
 */
@Entity(name="SHOWROOM_SET_ANN_JOINTABLE")
@Table(name="SHOWROOM_SET_ANN_JOINTABLE")
public class Showroom {
    @Id
    @Column(name="SHOWROOM_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id = 0;

    private String manager = null;
    private String location = null;
    @OneToMany
    @JoinTable (
            name="SHOWROOM_CAR_SET_ANN_JOINTABLE",
            joinColumns = @JoinColumn(name="CAR_IN_ROOM_FK") // имя колонки FK, в которой будут ид шоурума
     )
    @Cascade(CascadeType.ALL)
    private Set<Car> cars = null;

    public Showroom(){
        
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
