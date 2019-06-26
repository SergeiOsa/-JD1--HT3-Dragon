package by.oskerko.layer_architect.dragon_treasure.sevice;

import java.util.List;

import by.oskerko.layer_architect.dragon_treasure.dao.DAOException;
import by.oskerko.layer_architect.dragon_treasure.entity.Treasure;

/*Реализовать возможность просмотра сокровищ, 
 * выбора самого дорогого по стоимости сокровища
   и выбора сокровищ на заданную сумму.*/

public interface TreasureService {

	public List<Treasure> seeAllTreasures() throws DAOException;
	
	public Treasure mostExpensiveTreasure() throws DAOException;
	
	public List<Treasure> selectionTreasure(int sum) throws DAOException;
	
	public void saveTreasure(String[] params) throws DAOException;
	
	public void removeTreasure(String[] params) throws DAOException;
	
}
