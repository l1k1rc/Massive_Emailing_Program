package Orga_reader;

import java.io.*;

public class Deserialize {

	private int data;

	public Deserialize() {
		try {
			FileInputStream fileIn = new FileInputStream("data.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			data = (Integer) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Data not found.");
			c.printStackTrace();
			return;
		}
		System.out.println(data);
	}
	public int getData() {
		return data;
	}
}