package com.mkyong.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ReadCVS2
 */
public class ReadCVS2 {

	public static void main(String[] args) {
		ReadCVS2 obj = new ReadCVS2();
		obj.run();
	}

	public void run() {

		String csvFile = "resources/GeoIPCountryWhois.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {
			Map<String, String> maps = new HashMap<String, String>();

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] country = line.split(cvsSplitBy);

				maps.put(country[4], country[5]);
			}

			//loop map
			for (Map.Entry<String, String> entry : maps.entrySet()) {
				System.out.println("Country [code= " + entry.getKey() + " , name=" + entry.getValue() + "]");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Done");
	}
}
