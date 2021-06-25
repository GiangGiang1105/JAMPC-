import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;


public class JavaHTTPServer extends Thread {
	
	



	static final File WEB_ROOT = new File(".");
	static final String DEFAULT_FILE = "index.html";
	static final String FILE_NOT_FOUND = "404.html";
	static final String METHOD_NOT_SUPPORTED = "not_supported.html";
	//port to listen connection
	static final int PORT = 8000; 
	//verbose mode 
	static final boolean verbose = true; 
	//client connection via Socket Class 
	private Socket connect; 
	
	public JavaHTTPServer(Socket connect) {
		this.connect = connect;
	}
	
	
	/*
	 * public static void main(String[] args) { try { ServerSocket serverConnect =
	 * new ServerSocket(PORT);
	 * System.out.println("Server started. \n Listening for connections on Port : "+
	 * PORT+".../n");
	 * 
	 * while(true) { JavaHTTPServer myServer = new
	 * JavaHTTPServer(serverConnect.accept()); if(verbose) {
	 * System.out.println("Connect opened. ("+ new Date()+")"); } //created đeicated
	 * thread to manage the client connection Thread thread = new Thread(myServer);
	 * thread.start(); } } catch (IOException e) {
	 * System.err.println("Server Connection error : "+e.getMessage()); }
	 * 
	 * }
	 */


	@Override
	public void run() {
		
		//we manage our particular client connection
		while(true) {
			BufferedReader in = null; 
			PrintWriter out = null; 
			BufferedOutputStream dataOut = null; 
			String fileRequested = null; 
			try {
				//we read characters from the client via input stream on the socket 
				in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
				//we get character output stream to client(for headers);
				out = new PrintWriter(connect.getOutputStream());
				//get binary output stream to client (for requested data)
				dataOut = new BufferedOutputStream(connect.getOutputStream()); 
				
				//get first line of the request from the client 
				String input = in.readLine();
				
				System.out.println("input: " + input != null ? input : "/n"+"/n");
				StringTokenizer parse = new StringTokenizer(input != null ? input : "" +"/n");
				String method = input != null ? parse.nextToken().toUpperCase(): ""; //we get the HTTP method ò the client 
				System.out.println("method: " +method+"/n");
				//we get file requested 
				fileRequested = input != null ?parse.nextToken().toLowerCase(): "";
				System.out.println("fileRequest" +fileRequested+"/n");
				//we support only GET and HEAD methods , we check 
				if (!method.equals("GET") && !method.equals("HEAD")) {
					if (verbose) {
						System.out.println("501 Not Implemented: "+method+" method. " );
					}
					//we return the not supported file to the client 
					File file = new File(WEB_ROOT, METHOD_NOT_SUPPORTED); 
					int fileLength = (int) file.length();
					String contentMimeType = "text/html"; 
					//read connect to return to client 
					byte[] fileData = readFileData(file, fileLength,contentMimeType);
					//we send HTTP Headers with data to client 
					out.println("HTTP/1.1 501 Not Implemented ");
					out.println("Server: Java HTTP Server from SSaurel: 1.0");
					out.println("Date : " + new Date());
					out.println("Content-type:"+contentMimeType );
					out.println("Content-length: "+ fileLength);
					out.println();//blank character output stream buffer
					out.flush();//flush character output stream buffer
					dataOut.write(fileData, 0, fileData.length);
					dataOut.flush();
					
					
				} else {
					System.out.println("ahihiahaiah");
					/*
					 * // GET or HEAD method*/
					if (fileRequested.endsWith("/")) { 
						fileRequested  +=DEFAULT_FILE; 
						System.out.println("DEFAULT_FILE"+fileRequested);
					}
					
					File file = new File(WEB_ROOT, fileRequested);
					System.out.println(file.getPath());
					int filelength = (int) file.length();
					String content = getContentType(fileRequested);
					
					if (method.equals("GET")) {//GET method so we return content
						if (file.exists()) {
							byte[] fileData = readFileData(file, filelength, content);
							out.println("HTTP/1.1 200 OK");
							out.println("Server: Java HTTP Server from SSaurel: 1.0");
							out.println("Date : " + new Date());
							out.println("Content-type:"+"text/html" );
//							out.println("Content-length: "+ filelength);
							out.println();//blank character output stream buffer
							out.flush();//flush character output stream buffer
							int lenght = fileData.length;
							System.out.println("lenghtDtae"+ lenght);
							dataOut.write(fileData, 0, fileData.length);
							
							dataOut.flush();
						}else {
							fileNotFound(out, dataOut, fileRequested);
						}
						
					}
					if(verbose) {
						System.out.println("File" +fileRequested + " of type " + content + "returned");
					}
				}
				
			}catch (FileNotFoundException fnfe) {
				try {
					fileNotFound(out, dataOut, fileRequested);
				} catch (IOException e) {
					System.err.println("Error with file not found exception: "+ e.getMessage());
				}
			} 
			catch (IOException e) {
				System.err.println("Server error : " + e);
			}
			finally {
				try {
					connect.close();
					if (in != null) in.close();
					out.close();
				} 
				catch (IOException e) {
					System.err.println("Error closing stream : "+e.getMessage());
				}
				if (verbose) {
					System.out.println("Connection closed.\n");
				}
			}
		}
		
	}
	
	private byte[] readFileData(File file, int filelength, String content) {
		FileInputStream fileIn = null; 
		byte[] fileData = null ;
		try {
			if(content.equals("text/html")) {
				fileData = new byte[filelength];
				fileIn = new  FileInputStream(file);
				fileIn.read(fileData);
			}
			else {
				String html="";
				String canonicalPath = file.getCanonicalPath();
				String path = canonicalPath.substring(0, canonicalPath.lastIndexOf(File.separator));
				String name = file.getName();
				if(name.endsWith(".cpp")) {
					CModle cmodel = new CModle();
					html = cmodel.runC(file, filelength);				
				}
				else {
					PHPModle php = new PHPModle();
					html = php.runPHP(file, filelength);
				} 
				fileData = html.getBytes();
			}
			
		}catch (IOException e) {
			System.out.println("getmessage: "+ e.getMessage());
			e.getStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			if (fileIn != null) {
				try {
					fileIn.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return fileData;
	}
	private String getContentType(String fileRequested) {
		if (fileRequested.endsWith(".htm") || fileRequested.endsWith(".html")) {
			return "text/html";
			
		}
		else {
			return "text/plain";
		}
	}
	
	private void fileNotFound(PrintWriter out, OutputStream dataOut, String fileRequested) throws IOException {
		File file = new File(WEB_ROOT, FILE_NOT_FOUND);
		int filelength = (int)file.length();
		String content = "text/html"; 
		byte[] fileData = readFileData(file, filelength, content);
		out.println("HTTP/1.1 404 File Not Found ");
		out.println("Server: Java HTTP Server from SSaurel: 1.0");
		out.println("Date : " + new Date());
		out.println("Content-type:"+content );
		out.println("Content-length: "+ filelength);
		out.println();//blank character output stream buffer
		out.flush();//flush character output stream buffer
		
		dataOut.write(fileData, 0, filelength);
		dataOut.flush();
		
		if (verbose) {
			System.out.println("File" +fileRequested+" not found");
		}
	}
	
}
