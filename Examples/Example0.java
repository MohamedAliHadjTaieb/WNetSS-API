/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wnetssexamples;

import WordNetSemanticSimilarity.DataBaseConnection.DataBaseConnection;
import WordNetSemanticSimilarity.WordNetTreatment.BaseName;
import WordNetSemanticSimilarity.WordNetTreatment.WordNetProcessing;
import WordNetSemanticSimilarity.WordNetTreatment.WordNetVersion;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import net.sf.extjwnl.JWNLException;
import org.xml.sax.SAXException;

/**
 *
 * @author Mohamed Ali Hadj Taieb and Mohamed Ben Aouicha
 */
public class Example0 {
    public static void main(String[] args) throws SQLException, FileNotFoundException, JWNLException, TransformerConfigurationException, TransformerException, ParserConfigurationException, SAXException, IOException 
     {
        ////////////////////////////////////////////////////////////////////////
        //              Wordnet Loading
        ////////////////////////////////////////////////////////////////////////   
         
            String pathFilePropertiesWordNet="file_properties.xml";
            String pathWordNetDictFolder="WordNet Data\\2.1\\dict";
            WordNetVersion version=WordNetVersion.WordNet2dot1;        
            DataBaseConnection dbc0=new DataBaseConnection("localhost",3306,"root","") ;
            WordNetProcessing.initialize(dbc0);              
            DataBaseConnection dbc=new DataBaseConnection("localhost",3306,BaseName.name,"root","") ;
            dbc.openConnection(); 
            WordNetProcessing WP=new WordNetProcessing(dbc,pathFilePropertiesWordNet,pathWordNetDictFolder,version);                    
            WP.LoadWordNetInDataBase();                   
            dbc.closeConnection();        
     }
}
