package by.oskerko.layer_architect.dragon_treasure.controller;

import by.oskerko.layer_architect.dragon_treasure.command.Command;
import by.oskerko.layer_architect.dragon_treasure.command.ProviderCommand;

public class Controller {

	private ProviderCommand provider = new ProviderCommand();
	
	public String doAction(String request) {
		
		String[] params = request.split("  ");
		String response;
		
		Command command = provider.getCommand(params[0]);
		response = command.execute(params);
		
		return response;
		
	}
	
}
