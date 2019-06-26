package by.oskerko.layer_architect.dragon_treasure.sevice;

import by.oskerko.layer_architect.dragon_treasure.sevice.impl.TreasureServiceImpl;

public final class ProviderService {

	private static volatile ProviderService instance;
	private TreasureService treasureService = new TreasureServiceImpl();

	private ProviderService() {
	}

	public static ProviderService getInstance() {
		if (instance == null) {
			synchronized (ProviderService.class) {
				if (instance == null) {
					instance = new ProviderService();
				}
			}
		}
		return instance;
	}

	public TreasureService getTreasureService() {
		return treasureService;
	}

}
