package org.project.proxibank.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**Classe {@link Company} 
 * @author LIMM
 *
 */
@Entity
@DiscriminatorValue("Company")
public class Company extends Client {

}
