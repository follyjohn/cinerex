package org.hermit.cinerex.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

/** 
 * @return Long
 */

/** 
 * @return Date
 */

/** 
 * @return boolean
 */

/** 
 * @return boolean
 */

/** 
 * @return int
 */

/** 
 * @return String
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "seances")
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;    

    
}
               