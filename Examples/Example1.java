/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wnetssexamples;

import WordNetSemanticSimilarity.DataBaseConnection.DataBaseConnection;
import WordNetSemanticSimilarity.WordNetTreatment.BaseName;
import WordNetSemanticSimilarity.WordNetTreatment.WordNetProcessing;
import WordNetSemanticSimilarity.WordNetTreatment.WordNetVersion;
import WordNetSemanticSimilarity.WordNetTreatment.WordnetTreatmentException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import net.sf.extjwnl.JWNLException;
import net.sf.extjwnl.data.POS;
import org.xml.sax.SAXException;

/**
 *
 * @author Mohamed Ali Hadj Taieb and Mohamed Ben Aouicha
 */
public class Example1 {
     public static void main(String[] args) 
     {
        ////////////////////////////////////////////////////////////////////////
        //  Extracting Topological Parameters of Nominal WordNet "is a" taxonomy
        ////////////////////////////////////////////////////////////////////////   
         try
         {
            String pathFilePropertiesWordNet="file_properties.xml";
            String pathWordNetDictFolder="WordNet Data\\2.1\\dict";
            WordNetVersion version=WordNetVersion.WordNet2dot1;
            POS pos=POS.VERB;            
            DataBaseConnection dbc=new DataBaseConnection("localhost",3306,BaseName.name,"root","") ;            
            WordNetProcessing WP=new WordNetProcessing(dbc,pathFilePropertiesWordNet,pathWordNetDictFolder,version,pos);                    
            WP.fullWordNetTreatment();
         }
         catch(SQLException ex)
         {
             ex.printStackTrace();
         }
         catch(FileNotFoundException ex)
         {
               ex.printStackTrace();
         }
         catch(JWNLException ex)
         {
               ex.printStackTrace();
         }
         catch(TransformerConfigurationException ex)
         {
               ex.printStackTrace();
         }
         catch(TransformerException ex)
         {
               ex.printStackTrace();
         }
         catch(ParserConfigurationException ex)
         {
               ex.printStackTrace();
         }
         catch(SAXException ex)
         {
               ex.printStackTrace();
         }
         catch(IOException ex)
         {
               ex.printStackTrace();
         }
         catch(WordnetTreatmentException ex)
         {
               ex.printStackTrace();
         }
         catch(Exception ex)
         {
               ex.printStackTrace();
         }
         
     }
    
}
