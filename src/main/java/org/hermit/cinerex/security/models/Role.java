package org.hermit.cinerex.security.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    public Role() {

    }

    public Role(ERole name) {
        this.name = name;
    }

    public Role(long id, ERole name) {
        this.id = id;
        this.name = name;
    }

    
    /** 
     * @return long
     */
    public long getId() {
        return id;
    }

    
    /** 
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    
    /** 
     * @return ERole
     */
    public ERole getName() {
        return name;
    }

    
    /** 
     * @param name
     */
    public void setName(ERole name) {
        this.name = name;
    }

    

    

    
}
