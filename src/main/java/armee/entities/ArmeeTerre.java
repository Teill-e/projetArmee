package armee.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("Terre")
public class ArmeeTerre extends Armee{

	
	public ArmeeTerre() {
	}

	public ArmeeTerre(Integer moral, Pays pays) {
		super(100, moral, pays);
		
	}

	
	
}
