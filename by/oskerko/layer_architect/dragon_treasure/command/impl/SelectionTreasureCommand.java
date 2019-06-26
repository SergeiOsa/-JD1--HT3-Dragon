package by.oskerko.layer_architect.dragon_treasure.command.impl;

import java.util.List;

import by.oskerko.layer_architect.dragon_treasure.command.Command;
import by.oskerko.layer_architect.dragon_treasure.dao.DAOException;
import by.oskerko.layer_architect.dragon_treasure.entity.Treasure;
import by.oskerko.layer_architect.dragon_treasure.sevice.ProviderService;

public class SelectionTreasureCommand implements Command {

	@Override
	public String execute(String[] params) {
		int sum;
		String sumStr;
		String response;
		List<Treasure> selectionList = null;
		
		sumStr = params[1];
		sum = Integer.parseInt(sumStr);
		
		ProviderService provider = ProviderService.getInstance();
		try {
			selectionList = provider.getTreasureService().selectionTreasure(sum);
		} catch (DAOException e) {
			e.printStackTrace();
			response = "произошла ошибка";
		}
		
		response = "Вот сокровища на твои бабки: " + selectionList.toString();
		
		return response;
	}

}
