package Orga_reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Logs_writer {
	private File file = new File("mails_sent.log");

	/**
	 * Allow to write a XML file with FileWriter methods.
	 */
	public Logs_writer(String logs) {
		// csv_Reader = new CSV_Reader("DI_usersv2.csv");
		FileWriter fw;
		try {
			fw = new FileWriter(file,true);
			fw.write(logs);
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Error : Vérifier le séparateur de CSV_Reader");
		}
	}

}
