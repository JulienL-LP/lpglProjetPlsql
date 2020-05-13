package modele;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = {"vol", "dateDepart"})
public class DepartVol {

	private Vol vol;
	private LocalDateTime dateDepart;
	private int dureeVol;
}
