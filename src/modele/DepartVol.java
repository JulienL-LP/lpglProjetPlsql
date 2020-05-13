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
	
	public DepartVol(Vol vol, LocalDateTime dateDepart, int dureeVol) {
		super();
		this.vol = vol;
		this.dateDepart = dateDepart;
		this.dureeVol = dureeVol;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

	public LocalDateTime getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(LocalDateTime dateDepart) {
		this.dateDepart = dateDepart;
	}

	public int getDureeVol() {
		return dureeVol;
	}

	public void setDureeVol(int dureeVol) {
		this.dureeVol = dureeVol;
	}
	
	
}
