package by.oskerko.layer_architect.dragon_treasure.command.impl;

import by.oskerko.layer_architect.dragon_treasure.command.Command;

public class NoSearchCommand implements Command {

	@Override
	public String execute(String[] params) {
		String response;
		response = "нет такой команды";
		return response;
	}

}
