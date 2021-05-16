package org.hermit.cinerex.security.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

/** 
 * @return Long
 */

/** 
 * @return int
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
@Table(name = "acheteurs")
public class Acheteur extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int solde;
}
