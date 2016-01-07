package si;

import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.io.*;

import si.parseur.*;

public class testXML {

  public static void main(String argv[]) throws Exception {
   if(argv.length != 1)
    System.err.println("usage : java test.testXML fichier.xml");
   else {
    System.out.println("analyse de "+argv[0]+"...");

    // Le parseur SAX
    XMLReader reader
    = XMLReaderFactory.createXMLReader("org.apache.xerces.parsers.SAXParser");

    // Creation d'un flot XML sur le fichier d'entree
    InputSource input = new InputSource(new FileInputStream(argv[0]));

    // Connexion du ContentHandler
    SIHandler handler = new SIHandler();
    reader.setContentHandler(handler);
    // Lancement du traitement...
    reader.parse(input);
   }
  }
}