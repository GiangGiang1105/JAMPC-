
import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import utils.Constants;

public class PHPModle {

	private String PHPDir = "";
	

	public PHPModle() {
	}

	public static String runPHP(File file, int lengh) throws InterruptedException {
		String html = "";

		String path = String.valueOf(file);

		Runtime runtime = Runtime.getRuntime();
		try {
			ProcessBuilder pb = new ProcessBuilder();
			pb = new ProcessBuilder(Constants.PHP, path);
			System.out.println("Path" + path);
			Process process = Runtime.getRuntime().exec(new String[] { "cmd", "/C", "php " + path });

			process.waitFor();
			InputStream fis = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			String line = null;

			if (fis.read() == -1) {
				BufferedReader r = new BufferedReader(new InputStreamReader(process.getErrorStream()));
				System.out.println("ERROR!" + r.readLine());
				String s = null;
				while ((s = r.readLine()) != null) {

					System.out.println(s);
				}
			}
			while ((line = br.readLine()) != null) {
				html += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return html;
	}
}
