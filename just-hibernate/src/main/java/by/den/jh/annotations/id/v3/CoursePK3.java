/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.den.jh.annotations.id.v3;

import java.io.Serializable;

/**
 *
 * @author mkonda
 */
public class CoursePK3 implements Serializable {

    private String tutor = null;
    private String title = null;

    public CoursePK3() {
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CoursePK3 other = (CoursePK3) obj;
        if ((this.tutor == null) ? (other.tutor != null) : !this.tutor.equals(other.tutor)) {
            return false;
        }
        if ((this.title == null) ? (other.title != null) : !this.title.equals(other.title)) {
            return false;
        }
        return true;
    }
}
