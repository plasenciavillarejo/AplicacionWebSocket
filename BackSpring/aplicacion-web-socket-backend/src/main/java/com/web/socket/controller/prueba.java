package com.web.socket.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class prueba {

	public static void main(String[] args) throws IOException {
		
	       // Ruta 1
        List<String> stopsRoute1 = Arrays.asList("Stop A", "Stop B", "Stop C","Stop X", "Stop Y", "Stop Z");
        List<String> timesRoute1 = Arrays.asList("08:00", "08:15", "08:30","09:00", "09:15", "09:30");
        
        File routeFile = new File("src/main/resources/ficheros/route_1.txt");
		String zipPath = "src/main/resources/ficheros/gtfs.zip";

	     try (PrintWriter writer = new PrintWriter(new FileWriter(routeFile))) {
	    	   for (int i = 0; i < stopsRoute1.size(); i++) {
	    		   writer.append(stopsRoute1.get(i) + ",");
	    	    }
	    	    writer.println(); // Nueva línea después de la cabecera
	    	   for (int i = 0; i < timesRoute1.size(); i++) {
	    	        writer.append(timesRoute1.get(i) + ",");
	    	    } 
         }
	        String directoryPath = "src/main/resources/ficheros/";
	     File directory = new File(directoryPath);
	        File[] files = directory.listFiles();

	        // Crear el archivo ZIP de salida
	        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipPath))) {
	            // Iterar sobre la lista de archivos
	            for (File file : files) {
	                // Verificar si es un archivo TXT
	                if (file.isFile() && file.getName().endsWith(".txt")) {
	                    // Agregar el archivo al archivo ZIP
	                	try (InputStream is = new FileInputStream(file)) {
	                        ZipEntry zipEntry = new ZipEntry(file.getName());
	                        zipOut.putNextEntry(zipEntry);

	                        byte[] bytes = new byte[1024];
	                        int length;
	                        while ((length = is.read(bytes)) >= 0) {
	                            zipOut.write(bytes, 0, length);
	                        }
	                    }
	                }
	            }
	        }
	     
	     /*
        List<String> filePaths = Arrays.asList("src/main/resources/ficheros/route.txt",
        "src/main/resources/ficheros/stop.txt");
        
		try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipPath))) {
		    for (String filePath : filePaths) {
		        File fileToZip = new File(filePath);
		        zipOut.putNextEntry(new ZipEntry(fileToZip.getName()));
		        Files.copy(fileToZip.toPath(), zipOut);
		    }
		}*/
		
	}

}
