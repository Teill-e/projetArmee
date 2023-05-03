package armee.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("Marine")
public class Marine extends Armee {

	
	public Marine() {
	}

	public Marine(Integer moral, Pays pays) {
		super(100, moral, pays);
		
	}

	
}
