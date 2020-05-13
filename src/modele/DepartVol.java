package modele;

import java.time.LocalDate;

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
	private LocalDate dateDepart;
	private int dureeVol;
}
