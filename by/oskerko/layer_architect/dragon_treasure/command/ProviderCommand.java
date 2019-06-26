package by.oskerko.layer_architect.dragon_treasure.command;

import java.util.HashMap;
import java.util.Map;

import by.oskerko.layer_architect.dragon_treasure.command.impl.MostExpensiveTreasureCommand;
import by.oskerko.layer_architect.dragon_treasure.command.impl.NoSearchCommand;
import by.oskerko.layer_architect.dragon_treasure.command.impl.RemoveTreasureCommand;
import by.oskerko.layer_architect.dragon_treasure.command.impl.SaveTreasureCommand;
import by.oskerko.layer_architect.dragon_treasure.command.impl.SeeAllTreasuresCommand;
import by.oskerko.layer_architect.dragon_treasure.command.impl.SelectionTreasureCommand;

public class ProviderCommand {

	private Map<String, Command> commands = new HashMap<String, Command>();
	
	public ProviderCommand() {
		commands.put("most_expensive_treasure", new MostExpensiveTreasureCommand());
		commands.put("see_all_treasures", new SeeAllTreasuresCommand());
		commands.put("selection_treasure", new SelectionTreasureCommand());
		commands.put("save_treasure", new SaveTreasureCommand());
		commands.put("remove_treasure", new RemoveTreasureCommand());

	}
	
	public Command getCommand(String commandName) {
		Command command;
		command = commands.get(commandName);
		if(command == null) {
			return new NoSearchCommand();
		}
		return command;
	}
}
