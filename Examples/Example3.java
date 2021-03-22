/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wnetssexamples;

import WordNetSemanticSimilarity.DataBaseConnection.DataBaseConnection;
import WordNetSemanticSimilarity.ICApproach.ICApproachException;
import WordNetSemanticSimilarity.ICApproach.ICComputingMethod;
import WordNetSemanticSimilarity.ICApproach.ICMeasure;
import WordNetSemanticSimilarity.ICApproach.WordNetICApproaches;
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
public class Example3 {
    public static void main(String[] args) throws FileNotFoundException, JWNLException, WordnetTreatmentException, SQLException, TransformerConfigurationException, TransformerException, ParserConfigurationException, SAXException, IOException, ICApproachException
    {
        ////////////////////////////////////////////////////////////////////////
        //      Wordnet Semantic Similarity Information Content Approach      //
        //////////////////////////////////////////////////////////////////////// 
        String pathFilePropertiesWordNet="file_properties.xml";
        String pathWordNetDictFolder="WordNet Data\\3.0\\dict";
        DataBaseConnection dbc=new DataBaseConnection("localhost",3306,BaseName.name,"root","") ;
        dbc.openConnection();             
        WordNetVersion version=WordNetVersion.WordNet3dot0;
        POS pos=POS.NOUN;
        WordNetProcessing WP=new WordNetProcessing(dbc,pathFilePropertiesWordNet,pathWordNetDictFolder,version,pos);                    
        WordNetICApproaches  wic= new WordNetICApproaches(WP);
        //ICComputingMethod.Zhou2008.setHyponyms(Hyponyms.HypDepthWH);
        //ICComputingMethod.Zhou2008.setDepth(Depth.depthWH);
        ICComputingMethod.HadjTaieb2014.setDepth(Depth.depthMax);
        ICComputingMethod.HadjTaieb2014.setHyponyms(Hyponyms.HypCard);
        
         String fileName ="D:\\These++++\\Houcemeddine\\Lettre  Houcemeddine\\set.txt";
         FileReader inputFile = new FileReader(fileName);
         BufferedReader bufferReader = new BufferedReader(inputFile);
         bufferReader = new BufferedReader(new FileReader(fileName));
         String ligne;
         while ((ligne = bufferReader.readLine()) != null) {
             StringTokenizer st=new StringTokenizer(ligne,"\t");
             String w1=st.nextToken();
             String w2=st.nextToken();
             double ss=wic.SemanticSimilarityICComputing(w1,w2, ICComputingMethod.HadjTaieb2014, ICMeasure.Lin1998);              
             System.out.println(ss); 
         }
           
            bufferReader.close();
    }
    
}
