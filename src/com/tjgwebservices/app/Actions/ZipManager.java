package com.tjgwebservices.app.Actions;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;

public class ZipManager extends ActionsBase {

	public ZipManager(){}
	
	private void extractFolder(final String zipFile,final String extractFolder) 
	{
	    try
	    {
	        int BUFFER = 2048;
	        File file = new File(zipFile);

	        ZipFile zip = new ZipFile(file);
	        String newPath = extractFolder;

	        new File(newPath).mkdir();
	        Enumeration<? extends ZipEntry> zipFileEntries = zip.entries();

	        // Process each entry
	        while (zipFileEntries.hasMoreElements())
	        {
	            // grab a zip file entry
	            ZipEntry entry = (ZipEntry) zipFileEntries.nextElement();
	            String currentEntry = entry.getName();

	            File destFile = new File(newPath, currentEntry);
	            //destFile = new File(newPath, destFile.getName());
	            File destinationParent = destFile.getParentFile();

	            // create the parent directory structure if needed
	            destinationParent.mkdirs();

	            if (!entry.isDirectory())
	            {
	                BufferedInputStream is = new BufferedInputStream(zip
	                .getInputStream(entry));
	                int currentByte;
	                // establish buffer for writing file
	                byte data[] = new byte[BUFFER];

	                // write the current file to disk
	                FileOutputStream fos = new FileOutputStream(destFile);
	                BufferedOutputStream dest = new BufferedOutputStream(fos,
	                BUFFER);

	                // read and write until last byte is encountered
	                while ((currentByte = is.read(data, 0, BUFFER)) != -1) {
	                    dest.write(data, 0, currentByte);
	                }
	                dest.flush();
	                dest.close();
	                is.close();
	            }
	            zip.close();

	        }
	    }
	    catch (Exception e) 
	    {
	        System.out.println("ERROR: "+e.getMessage());
	    }	
	}

	 private void addFolderToZip(final File folder, final ZipOutputStream zip, final String baseName) throws IOException {
		    File[] files = folder.listFiles();
		    for (File file : files) {
		        if (file.isDirectory()) {
		            addFolderToZip(file, zip, baseName);
		        } else {
		            String name = file.getAbsolutePath().substring(baseName.length());
		            ZipEntry zipEntry = new ZipEntry(name);
		            zip.putNextEntry(zipEntry);
		            IOUtils.copy(new FileInputStream(file), zip);
		            zip.closeEntry();
		        }
		    }
		}
}
