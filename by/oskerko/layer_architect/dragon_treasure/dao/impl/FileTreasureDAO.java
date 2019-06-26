package by.oskerko.layer_architect.dragon_treasure.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.oskerko.layer_architect.dragon_treasure.dao.DAOException;
import by.oskerko.layer_architect.dragon_treasure.dao.TreasureDAO;
import by.oskerko.layer_architect.dragon_treasure.entity.Treasure;

public class FileTreasureDAO implements TreasureDAO {

	File file = new File("D:\\Java\\Workspace\\jd1-layer-architect-dragon\\sources\\treasure.txt");
	public static final String regex = "  ";

	@Override
	public List<Treasure> takeTreasure() throws DAOException {

		List<Treasure> treasureList = new ArrayList<Treasure>();

		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(file));
			String line;
			try {
				while ((line = reader.readLine()) != null) {
					String[] treasureStr;
					int id;
					String name;
					int price;

					treasureStr = line.split(regex);
					id = Integer.valueOf(treasureStr[0]);
					name = treasureStr[1];
					price = Integer.valueOf(treasureStr[2]);
					Treasure tresure = new Treasure(id, name, price);
					treasureList.add(tresure);

				}
			} catch (NumberFormatException | IOException e) {
				throw new DAOException(e);
			}
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					throw new DAOException(e);
				}
			}
		}

		return treasureList;
	}

	@Override
	public boolean save(Treasure treasure) throws DAOException {
		boolean isSave = false;
		FileWriter fw;
		BufferedWriter bw = null;
		String line;
		Integer intId;
		String id;
		String name;
		Integer intPrice;
		String price;

		intId = treasure.getId();
		id = intId.toString();
		intPrice = treasure.getPrice();
		price = intPrice.toString();
		name = treasure.getName();
		line = id + regex + name + regex + price;
		System.out.println(line);
		try {
			fw = new FileWriter(file, true);
			bw = new BufferedWriter(fw);
			bw.newLine();
			bw.write(line);
			isSave = true;

		} catch (IOException e) {
			throw new DAOException(e);
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				throw new DAOException(e);
			}

		}
		return isSave;
	}

	@Override
	public boolean remove(Treasure treasure) throws DAOException {
		List<Treasure> tr;
		tr = takeTreasure();
		boolean isRemove = tr.remove(treasure);
		BufferedWriter bw = null;

		Treasure temp;
		String line;
		Integer intId;
		String id;
		String name;
		Integer intPrice;
		String price;

		try {
			bw = new BufferedWriter(new FileWriter(file));

			for (int i = 0; i < tr.size(); i++) {
				temp = tr.get(i);
				intId = temp.getId();
				id = intId.toString();
				name = temp.getName();
				intPrice = temp.getPrice();
				price = intPrice.toString();
				line = id + regex + name + regex + price;
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			throw new DAOException(e);
		}
		try {
			bw.close();
		} catch (IOException e) {
			throw new DAOException(e);
		}
		return isRemove;

	}

}
