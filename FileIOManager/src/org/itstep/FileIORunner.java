package org.itstep;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itstep.model.Account;

public class FileIORunner {

	public static void main(String[] args) {
		
		Account test = new Account();
		test.setAge(10);
		test.setFirstname("Testname");
		test.setLogin("Testlogin");
		test.setPassword("Testpass");
		test.setSecondname("Testsurname");
		
		FileWriter fw = null;
	
		File file = new File("test.txt");
		if ( ! file.exists()){
			try {
				file.createNewFile();
				fw = new FileWriter("test.txt");
				
				fw.write("Name "+test.getFirstname()+System.getProperty("line.separator"));
				fw.write("Surname "+test.getSecondname()+System.getProperty("line.separator"));
				fw.write("Login "+test.getLogin()+System.getProperty("line.separator"));
				fw.write("Password "+test.getPassword()+System.getProperty("line.separator"));
				fw.write("Age "+test.getAge()+System.getProperty("line.separator"));
				
			} catch (IOException e) {
				Logger.getLogger(FileIORunner.class.getName()).log(Level.SEVERE, null, e);
			} finally {
				try {
					fw.close();
				} catch(IOException e) {
					Logger.getLogger(FileIORunner.class.getName()).log(Level.SEVERE, null, e);
				}
			}
		}
		
		
		FileReader fr = null;
		BufferedReader br = null;
		Account filetest = new Account();
		
		if (file.exists()){
			try {
				fr = new FileReader("test.txt");
				br = new BufferedReader(fr);
				
				String temp = br.readLine();
				filetest.setFirstname(temp.substring(5));
				temp = br.readLine();
				filetest.setSecondname(temp.substring(8));
				temp = br.readLine();
				filetest.setLogin(temp.substring(6));
				temp = br.readLine();
				filetest.setPassword(temp.substring(9));
				temp = br.readLine();
				filetest.setAge(Integer.parseInt(temp.substring(4)));				
			} catch (IOException e) {
				Logger.getLogger(FileIORunner.class.getName()).log(Level.SEVERE, null, e);
			} finally {
				try {
					br.close();
					fr.close();
				} catch(IOException e) {
					Logger.getLogger(FileIORunner.class.getName()).log(Level.SEVERE, null, e);
				}
			}
		}
	
	
	}

}
