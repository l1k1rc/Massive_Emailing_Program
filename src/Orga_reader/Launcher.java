package Orga_reader;

import java.util.Timer;
import java.util.TimerTask;

public class Launcher {
	/**
	 * Main method to launch
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//final CSV_Reader csv_Reader = new CSV_Reader("Export_DIv4.csv");
		final Send_mail env = new Send_mail();
		//final Deserialize deserialize = new Deserialize();
		System.out.println("Log sauvegardé dans mails_sent.log\n");
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			int i = 0;
			//int count = deserialize.getData();

			public void run() {
				//i++;
				// for (j = 1; j <= 4; j++) {
			/*	env.send(csv_Reader.getDatas().get(count)[0], csv_Reader.getDatas().get(count)[1],
						csv_Reader.getDatas().get(count)[7]);
				System.err.println("Email n°" + count + " envoyé.");
				count++;
				// }
				System.err.println("Total :" + count + "-1 email envoyés.");
				@SuppressWarnings("unused")
				Serialize serialize = new Serialize(count);*/
				env.send("test", "test", "test@edf.fr");
				i++;
				if (i == 3) {
					cancel();
					System.out.println(
							"\n-------------------------------------\n     Mails have been sents.\n-------------------------------------");				}
			}
		}, 0, Random.randomInt(5000, 15000));
		System.out.println(
				"\n-------------------------------------\n     Mail initialization.\n-------------------------------------");
	}
}
/*
 * Pour un timer en thread rapide Thread.sleep(5000)
 */
