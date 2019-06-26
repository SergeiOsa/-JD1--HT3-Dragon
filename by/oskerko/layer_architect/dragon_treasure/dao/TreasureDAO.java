package by.oskerko.layer_architect.dragon_treasure.dao;

import java.util.List;

import by.oskerko.layer_architect.dragon_treasure.entity.Treasure;

public interface TreasureDAO {

	public List<Treasure> takeTreasure() throws DAOException;
	
	public boolean save(Treasure treasure) throws DAOException;
	
	public boolean remove(Treasure treasure) throws DAOException;
	
}
