package by.oskerko.layer_architect.dragon_treasure.sevice.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import by.oskerko.layer_architect.dragon_treasure.dao.DAOException;
import by.oskerko.layer_architect.dragon_treasure.dao.ProviderDAO;
import by.oskerko.layer_architect.dragon_treasure.dao.TreasureDAO;
import by.oskerko.layer_architect.dragon_treasure.entity.Treasure;
import by.oskerko.layer_architect.dragon_treasure.sevice.TreasureService;

public class TreasureServiceImpl implements TreasureService {

	public boolean validation(List<Treasure> treasureList) throws DAOException {
		boolean isValid = false;
		if (treasureList == null) {
			throw new DAOException();
		}
		isValid = true;
		
		return isValid;
	}

	@Override
	public List<Treasure> seeAllTreasures() throws DAOException {
		ProviderDAO provider = ProviderDAO.getInstance();
		TreasureDAO treasureDAO = provider.getTreasureDAO();
		List<Treasure> treasureList = treasureDAO.takeTreasure();

		validation(treasureList);

		return treasureList;
	}

	@Override
	public Treasure mostExpensiveTreasure() throws DAOException {
		int price = 0;
		int index = 0;

		ProviderDAO provider = ProviderDAO.getInstance();
		TreasureDAO treasureDAO = provider.getTreasureDAO();
		List<Treasure> treasureList = treasureDAO.takeTreasure();

		validation(treasureList);

		for (int i = 0; i < treasureList.size(); i++) {
			if (treasureList.get(i).getPrice() > price) {
				price = treasureList.get(i).getPrice();
				index = i;
			}
		}

		return treasureList.get(index);
	}

	@Override
	public List<Treasure> selectionTreasure(int sum) throws DAOException {

		List<Treasure> selectionList = new ArrayList<Treasure>();

		Random r = new Random();

		ProviderDAO provider = ProviderDAO.getInstance();
		TreasureDAO treasureDAO = provider.getTreasureDAO();
		List<Treasure> treasureList = treasureDAO.takeTreasure();

		validation(treasureList);

		int minPrice = treasureList.get(0).getPrice();
		int indexMinPrice = 0;
		for (int i = 1; i < treasureList.size(); i++) {
			if (treasureList.get(i).getPrice() < minPrice) {
				minPrice = treasureList.get(i).getPrice();
				indexMinPrice = i;
			}
		}

		while ((sum > 0) && (sum > minPrice)) {
			int x = r.nextInt(treasureList.size());

			if ((treasureList.get(x).getPrice() < sum) && (sum > 0)) {
				if (!selectionList.contains(treasureList.get(x))) {
					selectionList.add(treasureList.get(x));
					sum = sum - treasureList.get(x).getPrice();

					if (x == indexMinPrice) {
						for (int i = 1; i < treasureList.size(); i++) {
							if (treasureList.get(i).getPrice() < minPrice) {
								minPrice = treasureList.get(i).getPrice();
								indexMinPrice = i;
							}
						}
					}
				}
			}
		}

		return selectionList;
	}

	@Override
	public void saveTreasure(String[] params) throws DAOException {
		int id;
		String name;
		int price;

		id = Integer.parseInt(params[1]);
		name = params[2];
		price = Integer.parseInt(params[3]);

		Treasure treasure = new Treasure(id, name, price);
		ProviderDAO provider = ProviderDAO.getInstance();
		provider.getTreasureDAO().save(treasure);

	}

	@Override
	public void removeTreasure(String[] params) throws DAOException {
		int id;
		String name;
		int price;

		id = Integer.parseInt(params[1]);
		name = params[2];
		price = Integer.parseInt(params[3]);

		Treasure treasure = new Treasure(id, name, price);
		ProviderDAO provider = ProviderDAO.getInstance();
		provider.getTreasureDAO().remove(treasure);
	}

}
