import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CModle {
	private static final String C = "g++ ";

	public CModle() {
	}
	public static String runC(File file, int lengh) throws InterruptedException {
		String html = "";
		String path = String.valueOf(file);
		String filePath =path.substring(0,path.lastIndexOf(File.separator));
		System.out.println("FIle Path "+filePath);
		String fileName = file.getName();
		System.out.println("File Name"+fileName);
		String fileexe = fileName.substring(0, fileName.lastIndexOf(".cpp"));
		 System.out.println("Fileexe"+fileexe);
		try {
			// if (compile_C(path, fileexe)) {
			ProcessBuilder compile = new ProcessBuilder("cmd", "/C",
					"g++ " + path + " -o "
							+ filePath+"\\"+fileexe);
			Process process_compile = compile.start();
			process_compile.waitFor();
			if (process_compile.exitValue() == 0) {
				System.out.println("HIHI tahafhnh công");
			}
			if (process_compile.exitValue() == -1) {
				// that means something was written to stderr, and you can do something like
				System.out.println("Lỗi ");
				System.exit(-1);
			}
			ProcessBuilder pb = new ProcessBuilder(filePath+"\\"+fileexe+".exe"  );
			Process process = pb.start();
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

			/*
			 * } else { System.out.println("Not fishion"); }
			 */
		} catch (IOException e) {
			e.printStackTrace();
		}
		return html;
	}

}
