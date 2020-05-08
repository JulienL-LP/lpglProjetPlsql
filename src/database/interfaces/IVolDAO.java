package database.interfaces;

import modele.Vol;

public interface IVolDAO extends IDAO<Vol> {

	Vol getById(String pk);
}
