package si.parseur;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.*;

import si.Logiciel;
import si.Materiel;

public class SIHandler implements ContentHandler {
	String baliseCourante;

	// caracteristiques d'un logiciel
	List<Logiciel> listLogiciels;
	List<Materiel> listMateriels;
	String nom, version,taille,date,editeur;
	String marque, processeur,hd,ram;

	
	public List<Logiciel> getListLogiciels() {
		return listLogiciels;
	}

	public List<Materiel> getListMateriels() {
		return listMateriels;
	}

	public SIHandler() {
		listLogiciels = new ArrayList<Logiciel>();
		listMateriels = new ArrayList<Materiel>();
	}

	public void startElement(String namespaceURI, String localName,
			String rawName, Attributes atts) throws SAXException {
		baliseCourante = localName;
	}

	// contenu de l'element courant...
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String contenu;
		if (baliseCourante != null) {
			contenu = new String(ch, start, length);
			if (baliseCourante.equals("nom"))
				nom = contenu;
			else if (baliseCourante.equals("version"))
				version = contenu;
			else if (baliseCourante.equals("taille"))
				taille = contenu;
			else if (baliseCourante.equals("date"))
				date = contenu;
			else if (baliseCourante.equals("editeur"))
				editeur = contenu;
			else if (baliseCourante.equals("marque"))
				marque = contenu;
			else if (baliseCourante.equals("processeur"))
				processeur = contenu;
			else if (baliseCourante.equals("hd"))
				hd = contenu;
			else if (baliseCourante.equals("ram"))
				ram = contenu;
		}
	}
	
	
	//TODO Test...
	public int getTest(){
		return 1;
	}

	// pour tracer ce qui se passe...
	public void startDocument() throws SAXException {
		System.out.println("***** start document");
	}

	public void endDocument() throws SAXException {
		System.out.println("***** end document");
	}

	// cloture d'un element
	public void endElement(String namespaceURI, String localName, String rawName)
			throws SAXException {
		baliseCourante = null;
		if (localName.equals("logiciel")) {
			this.listLogiciels.add(new Logiciel(nom, version, taille, date,editeur));
			System.out.println("Logiciel: " + nom + " " + version+"  "+taille+"  "+date+"  "+editeur);
		}
		else if(localName.equals("materiel")){
			this.listMateriels.add(new Materiel(nom, marque, processeur, hd, ram));
			System.out.println("Materiel: " + nom + " " + marque+"  "+processeur+"  "+hd+"  "+ram);
		}
		// completer avec les materiels...
	}
	public String getProc () {
		return this.processeur;
	}

	public void setDocumentLocator(Locator locator) {
	}

	public void startPrefixMapping(String prefix, String uri) {
	}

	public void endPrefixMapping(String prefix) {
	}

	public void ignorableWhitespace(char[] ch, int start, int length)
			throws SAXException {
	}

	public void processingInstruction(String target, String data)
			throws SAXException {
	}

	public void skippedEntity(String name) throws SAXException {
	}
}
