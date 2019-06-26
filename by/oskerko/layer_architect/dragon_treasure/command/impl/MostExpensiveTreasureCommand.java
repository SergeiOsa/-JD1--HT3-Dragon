package by.oskerko.layer_architect.dragon_treasure.command.impl;

import by.oskerko.layer_architect.dragon_treasure.command.Command;
import by.oskerko.layer_architect.dragon_treasure.dao.DAOException;
import by.oskerko.layer_architect.dragon_treasure.entity.Treasure;
import by.oskerko.layer_architect.dragon_treasure.sevice.ProviderService;

public class MostExpensiveTreasureCommand implements Command {

	@Override
	public String execute(String[] params) {
		String response = "Вот самое дорогое сокровище: ";
		ProviderService provider = ProviderService.getInstance();
		Treasure mostExpensiveTreasure = null;
		try {
			mostExpensiveTreasure = provider.getTreasureService().mostExpensiveTreasure();
		} catch (DAOException e) {
			e.printStackTrace();
			response = "произошла ошибка";
		}
		response = response + mostExpensiveTreasure.toString();
		return response;
	}

}
