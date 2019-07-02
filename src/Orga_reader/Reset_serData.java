package Orga_reader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Reset_serData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		Serialize serialize = new Serialize(0);
		@SuppressWarnings("unused")
		Deserialize deserialize = new Deserialize();
		File f = new File("mails_sent.log");
		try {
			PrintWriter printwriter = new PrintWriter(new FileOutputStream(f));
			printwriter.println("");
			printwriter.close();
			System.out.println("Log file cleared");
		} catch (Exception ex) {
			System.out.println("Error clear file" + f);
		}
	}

}
