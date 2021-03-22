/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wnetssexamples;

import WordNetSemanticSimilarity.DataBaseConnection.DataBaseConnection;
import WordNetSemanticSimilarity.TaxonomicApproach.TaxonomicMeasures;
import WordNetSemanticSimilarity.WordNetTreatment.BaseName;
import WordNetSemanticSimilarity.WordNetTreatment.Depth;
import WordNetSemanticSimilarity.WordNetTreatment.Hyponyms;
import WordNetSemanticSimilarity.WordNetTreatment.WordNetProcessing;
import WordNetSemanticSimilarity.WordNetTreatment.WordNetVersion;
import WordNetSemanticSimilarity.WordNetTreatment.WordnetTreatmentException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.StringTokenizer;
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
public class Example2 {
    public static void main(String[] args) throws JWNLException, SQLException, WordnetTreatmentException, FileNotFoundException, TransformerConfigurationException, TransformerException, ParserConfigurationException, SAXException, IOException
    {
        ////////////////////////////////////////////////////////////////////////
        //              Wordnet Semantic Similarity Taxonomic Measures
        //////////////////////////////////////////////////////////////////////// 
        String pathFilePropertiesWordNet="file_properties.xml";
        String pathWordNetDictFolder="WordNet Data\\3.0\\dict";
        DataBaseConnection dbc=new DataBaseConnection("localhost",3306,BaseName.name,"root","") ;
        dbc.openConnection();             
        WordNetVersion version=WordNetVersion.WordNet3dot0;
        POS pos=POS.NOUN;
        WordNetProcessing WP=new WordNetProcessing(dbc,pathFilePropertiesWordNet,pathWordNetDictFolder,version,pos);                    
        TaxonomicMeasures tm= new TaxonomicMeasures(WP);
        
         String fileName ="D:\\These++++\\Houcemeddine\\Lettre  Houcemeddine\\set.txt";
         FileReader inputFile = new FileReader(fileName);
         BufferedReader bufferReader = new BufferedReader(inputFile);
         bufferReader = new BufferedReader(new FileReader(fileName));
         String ligne;
         while ((ligne = bufferReader.readLine()) != null) {
             StringTokenizer st=new StringTokenizer(ligne,"\t");
             String w1=st.nextToken().toLowerCase().trim();
             String w2=st.nextToken().toLowerCase().trim();
             double ss=0;
             if(w1.equalsIgnoreCase(w2))
                 ss=1;
             else
            //ss=tm.HadjTaieb_2014(w1,w2, Hyponyms.HypLeaf, Depth.depthProb);
             //ss=tm.HadjTaieb_2014(w1,w2, Hyponyms.HypLeaf, Depth.depthMax);              
             //double ss=tm.MubaidNguyen_2006(w1, w1, Depth.depthMax, 1, 1, 1);
             //ss=tm.Li_2003(w1, w2, Depth.depthMax, 0.2, 0.6);
              ss=tm.Gao_2015_Strategy2(w1, w2, 19, Depth.depthMax, 1, 5);
             //System.out.println("["+w1+"]***["+w2+"]="+ss); 
             System.out.println(ss);
         }
           
            bufferReader.close();
               
    }
    
}
