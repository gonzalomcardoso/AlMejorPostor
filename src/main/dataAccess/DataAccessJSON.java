package main.dataAccess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import main.model.Oferta;
import main.util.FileChecker;

public class DataAccessJSON 
{
	private static boolean exists(String filename)
	{
		return FileChecker.exists(filename);
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Oferta> readJSON(String filename)
	{
		ArrayList<Oferta> lcs = null;
		if (!exists(filename))
			return lcs;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			Type collectionType = new TypeToken<List<Oferta>>() {
			}.getType();
			lcs = (ArrayList<Oferta>) new Gson().fromJson(br, collectionType);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lcs;
	}
	
	public static boolean writeJSON(String filename, ArrayList<Oferta> lista)
	{
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(lista);
		try {
			FileWriter writer = new FileWriter(filename);
			writer.write(json);
			writer.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
