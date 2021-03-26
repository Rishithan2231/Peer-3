import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathConstants;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * DOM handler to read XML information, to create this, and to print it.
 *
 * @author CSCU9T4, University of Stirling
 * @version 11/03/20
 */
public class DOMMenu {

    /**
     * Document builder
     */
    private static DocumentBuilder builder = null;

    /**
     * XML document
     */
    private static Document document = null;

    /**
     * XPath expression
     */
    private static XPath path = null;

    /**
     * XML Schema for validation
     */
    private static Schema schema = null;

    /*----------------------------- General Methods ----------------------------*/

    /**
     * Main program to call DOM parser.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) throws XPathExpressionException 
{
       
        String xsd = args[1];

        // load XML file into "document"
        loadDocument( String xml = args[0];);

        if (validateDocument(xsd)) {
            // print staff.xml using DOM methods and XPath queries
            printNodes();
    }

    /**
     * Set global document by reading the given file.
     *
     * @param filename XML file to read
     */
    private static void loadDocument(String filename) {
        try {
            // create a document builder
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            builder = builderFactory.newDocumentBuilder();

            // create an XPath expression
            XPathFactory xpathFactory = XPathFactory.newInstance();
            path = xpathFactory.newXPath();

            // parse the document for later searching
            document = builder.parse(new File(filename));
        } catch (Exception exception) {
            System.err.println("could not load document " + exception);
        }
    }

    /*-------------------------- DOM and XPath Methods -------------------------*/

    /**
     * Validate the document given a schema file
     *
     * @param filename XSD file to read
     */
    private static Boolean validateDocument(String filename) {
        try {
            String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
            SchemaFactory factory = SchemaFactory.newInstance(language);
            schema = factory.newSchema(new File(filename));
            Validator validator = schema.newValidator();
            validator.validate(new DOMSource(document));
            return true;
        } catch (SAXException | IOException e) {
             e.printStackTrace();
            return false;
        }
    }

    /**
     * Print nodes using DOM methods and XPath queries.
     */
    private static void printNodes() {
     NodeList item = document.getElementsByTagName("item");
    NodeList name = document.getElementsByTagName("name");
    NodeList price = document.getElementsByTagName("price");
    NodeList description = document.getElementsByTagName("description");
  
  }}

    /**
     * Get result of XPath query.
     *
     * @param query XPath query
     * @return result of query
     */
//Need to do more. 
    }
}
