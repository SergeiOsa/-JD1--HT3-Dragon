package by.oskerko.layer_architect.dragon_treasure.dao;

import by.oskerko.layer_architect.dragon_treasure.dao.impl.FileTreasureDAO;

public final class ProviderDAO {

	private static volatile ProviderDAO instance;
	private TreasureDAO treasureDAO = new FileTreasureDAO();
	
	
	private ProviderDAO() {
	}

	public static ProviderDAO getInstance() {
		if (instance == null) {
			synchronized (ProviderDAO.class) {
				if (instance == null) {
					instance = new ProviderDAO();
				}
			}
		}
		return instance;
	}
	
	public TreasureDAO getTreasureDAO() {
		return treasureDAO;
	}

}
