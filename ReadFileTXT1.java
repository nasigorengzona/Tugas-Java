import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.io.File;
import java.util.stream.Stream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ReadFileTXT1 {
	public static void main(String []args) {
		try {
			Stream<String> baris = Files.lines(new File("LowerCaseText.txt").toPath());
			List<String> allBaris = baris.collect(Collectors.toList());
			List<String> newtext = new ArrayList<String>();
			for (String s: allBaris) 
				newtext.add(s.toUpperCase());
			try {
				Files.write(new File("UpperCaseText.txt").toPath(),
					newtext,
					StandardOpenOption.CREATE,
					StandardOpenOption.WRITE
					);
				System.out.println("BERHASIL  " + new File("UpperCaseText.txt").getAbsolutePath()); 
			} catch (IOException e) {
				System.err.println("I/O exception when writing to file");
			}
		} catch (IOException e) {
			System.err.println("I/O exception occured when reading file check if there's file in directory");
		} catch (SecurityException e) {
			System.err.println("Security exception occured when reading file");
		}
	}
}