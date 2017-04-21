package XML;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/** A XMLReader which can read files */
class XMLFileReader extends XMLReader {  
    /** Make a new XMLFileReader
     * @param file The file to read the data from
     * @throws IOException If the file cannot be opened because of an IO error
     */
    public XMLFileReader (File file) throws IOException { 
	// Just to gain some speeeeed! dropped the 'new GZIPInputStream('
	super(new FileInputStream(file));
    }
}
