package armee.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("Air")
public class ArmeeAir extends Armee {

	public ArmeeAir() {
	}

	public ArmeeAir(Integer moral, Pays pays) {
		super(100, moral, pays);
		
	}

	

	
}
