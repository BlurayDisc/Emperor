/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emperor.data;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import emperor.controller.GameController;
import emperor.model.ChinaPoliticalSystem;
import emperor.model.Person;
import emperor.model.Player;

/**
 *
 * @author RuN
 */
public class XmlParser {
    
    private static final XmlParser instance = new XmlParser();
    
    private Document doc;
    private final String filePath;
    
    private XmlParser() {
        
        filePath = "src" + File.separator + "emperor" + File.separator + "data" + File.separator + "save.xml";
    }
    
    public void readFile() {
        try {
            parseFile();                 // reads the xml file into a Document object.
            parseDocument();             // reads the document and store the information in a PoliticalSystem object.
        } catch (SAXException | IOException | ParserConfigurationException | XPathExpressionException e) {e.printStackTrace();}
        //System.out.println(bookList);       // print out the book list.
    }
        
    public void updateFile() {
        try {
            parseFile();                 // reads the xml file into a Document Object Model.
            updateDocument();            // upodates the Document Object Model.
            writeFile();                 // writes the Document into a file.
        } catch (SAXException | IOException | ParserConfigurationException | TransformerException e) {e.printStackTrace();}
    }
    
    private void updateDocument() {
        
        Node timeNode = doc.getElementsByTagName("systemTime").item(0);
        long currentTime = getCurrentTime() / 1000;
        timeNode.setTextContent(Long.toString(currentTime));
        
        ChinaPoliticalSystem china = ChinaPoliticalSystem.getInstance();
        Node balance = doc.getElementsByTagName("balance").item(0);
        balance.setTextContent(Long.toString(china.getBalance()));
        
        Node theft = doc.getElementsByTagName("theft").item(0);
        theft.setTextContent(Long.toString(china.getTheft()));
        
        Node taxes = doc.getElementsByTagName("taxes").item(0);
        taxes.setTextContent(Long.toString(china.getTaxes()));
        
        NodeList personels = doc.getElementsByTagName("person");
        Player player = Player.getInstance();
        for (int i = 0; i < personels.getLength(); i++) {
            personels.item(i).setTextContent(player.getPersonels().get(i).getName());
        }
    }

    private void parseDocument() throws XPathExpressionException {
        
        XPath xpath = XPathFactory.newInstance().newXPath();
        String string;
        Node node;
        
        // Parse SystemTime
        string = "player/systemTime";
        double previousTime = (double) xpath.evaluate(string, doc, XPathConstants.NUMBER);
        
        // Parse Info
        string = "player/info";
        node = (Node)xpath.evaluate(string, doc, XPathConstants.NODE);
        string = "balance";
        double balance = (double) xpath.evaluate(string, node, XPathConstants.NUMBER);
        string = "taxes";
        double taxes = (double) xpath.evaluate(string, node, XPathConstants.NUMBER);
        string = "theft";
        double theft = (double) xpath.evaluate(string, node, XPathConstants.NUMBER);
        string = "popularity";
        double popularity = (double) xpath.evaluate(string, node, XPathConstants.NUMBER);
        string = "power";
        double power = (double) xpath.evaluate(string, node, XPathConstants.NUMBER);
        
        // Parser Structures
        string = "player/structures";
        // Structure parsing code goes here...
        
        // Parser Technology
        string = "player/technology";
        // Technology parsing code goes here...
        
        // Parse Politics
        string = "player/politics";
        // Politics parsing code goes here...
        
        // Update
        ChinaPoliticalSystem china = ChinaPoliticalSystem.getInstance();
        GameController gc = GameController.getInstance();
        
        gc.setPreviousTime((long) previousTime);
        china.setBalance((long) balance);
        china.setTaxes((long) taxes);
        china.setTheft((long) theft);
        china.setPopularity((int) popularity);
        china.setPower((int) power);
        
        // Update Player Personel List
        NodeList personels = doc.getElementsByTagName("person");
        Player player = Player.getInstance();
        for (int i = 0; i < personels.getLength(); i++) {
            player.addPersonels(new Person(personels.item(i).getTextContent()));
        }
    }
    
    @SuppressWarnings("unused") 
    private void createDocument() throws ParserConfigurationException {
        // Creates a new Document
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        doc = documentBuilder.newDocument();
    }
    
    private void parseFile() throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        doc = builder.parse(new File(filePath));
    }
    
    private void writeFile() throws TransformerException {
        // Write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(filePath));
        transformer.transform(source, result);
    }
    
    public static XmlParser getInstance() {
        return instance;
    }
    
    public long getCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTimeInMillis();
    }
}
