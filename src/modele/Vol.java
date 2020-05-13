package modele;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = {"noVol"})
public class Vol {

	private String noVol;
	private String depart;
	private String arrivee;

}
