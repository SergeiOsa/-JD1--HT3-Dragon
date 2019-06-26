package by.oskerko.layer_architect.dragon_treasure.command.impl;

import java.util.List;

import by.oskerko.layer_architect.dragon_treasure.command.Command;
import by.oskerko.layer_architect.dragon_treasure.dao.DAOException;
import by.oskerko.layer_architect.dragon_treasure.entity.Treasure;
import by.oskerko.layer_architect.dragon_treasure.sevice.ProviderService;

public class SeeAllTreasuresCommand implements Command {

	@Override
	public String execute(String[] params) {
		String response = "Вот все мои сокровища: ";
		ProviderService provider = ProviderService.getInstance();
		List<Treasure> treasureList = null;
		try {
			treasureList = provider.getTreasureService().seeAllTreasures();
		} catch (DAOException e) {
			e.printStackTrace();
			response = "произошла ошибка";
		}
		response = response + treasureList.toString();
		return response;
	}

	
}
