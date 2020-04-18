package com.nt.utills;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.gson.Gson;

public class CommonUtills {
	static Workbook book;
	static Sheet sheet;
	public static Env env;
	static String filePath = "" + System.getProperty("user.dir") + "/resources/Nobroker.xlsx";
	static String folderPath = System.getProperty("user.dir") + "/screenshot";

	public static Env getEnv() {
		return env;
	}

	public static void setEnv(Env env) {
		CommonUtills.env = env;
	}

	public static void setEnv(String env) {
		Gson gson = new Gson();
		try {
			Env en = gson.fromJson(
					new FileReader("" + System.getProperty("user.dir") + "/resources/" + envDecider(env) + ""),
					Env.class);
			CommonUtills.env = en;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static String envDecider(String env) {
		String selectedEnv;
		if (env.contains("Prod"))
			selectedEnv = "Prod.json";
		else if (env.contains("qa3"))
			selectedEnv = "qa3.json";
		else
			selectedEnv = "qa1.json";
		return selectedEnv;
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				System.out.println(data[i][k]);
			}
		}
		return data;
	}

	public static void cleanFolder() {
		File dir = new File(folderPath);

		if (dir.isDirectory() == false) {
			System.out.println("Not a directory. Do nothing");
			return;
		}
		File[] listFiles = dir.listFiles();
		for (File file : listFiles) {
			System.out.println("Deleting " + file.getName());
			file.delete();
		}
		// now directory is empty, so we can delete it
		System.out.println("Deleting Directory. Success = " + dir.delete());

	}
}
