package by.oskerko.layer_architect.dragon_treasure.command.impl;

import by.oskerko.layer_architect.dragon_treasure.command.Command;
import by.oskerko.layer_architect.dragon_treasure.dao.DAOException;
import by.oskerko.layer_architect.dragon_treasure.sevice.ProviderService;

public class SaveTreasureCommand implements Command {

	@Override
	public String execute(String[] params) {
		String response = "Добавили сокровище";
		ProviderService provider = ProviderService.getInstance();
		try {
			provider.getTreasureService().saveTreasure(params);
		} catch (DAOException e) {
			e.printStackTrace();
			response = "произошла ошибка";
		}
		return response;
	}

}
