/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wnetssexamples;

import WordNetSemanticSimilarity.DataBaseConnection.DataBaseConnection;
import WordNetSemanticSimilarity.FeaturesApproach.FeatruresMeasures;
import WordNetSemanticSimilarity.WordNetTreatment.BaseName;
import WordNetSemanticSimilarity.WordNetTreatment.Depth;
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
public class Example4 {
    public static void main(String[] args) throws FileNotFoundException, JWNLException,WordnetTreatmentException, SQLException, TransformerConfigurationException, TransformerException, ParserConfigurationException, SAXException, IOException 
    {
        ////////////////////////////////////////////////////////////////////////
        //      Wordnet Semantic Similarity Features Approach                 //
        //////////////////////////////////////////////////////////////////////// 
        String pathFilePropertiesWordNet="file_properties.xml";
        String pathWordNetDictFolder="WordNet Data\\3.0\\dict";
        DataBaseConnection dbc=new DataBaseConnection("localhost",3306,BaseName.name,"root","") ;
        dbc.openConnection();             
        WordNetVersion version=WordNetVersion.WordNet3dot0;
        POS pos=POS.NOUN;
        WordNetProcessing WP=new WordNetProcessing(dbc,pathFilePropertiesWordNet,pathWordNetDictFolder,version,pos);                    
        FeatruresMeasures fm=new FeatruresMeasures(WP);
        /*double ss1=fm.Rodriguez_2003("car", "wheel", Depth.depthMax);
        System.out.println("ss_Rodriguez= "+ss1);
        double ss2=fm.Tversky_1977("car", "wheel");
        System.out.println("ss_Tversky= "+ss2);
        double ss3=fm.XSimilarity_2006("car", "wheel");
        System.out.println("ss_XSimilarity= "+ss3);  */
        
         String fileName ="D:\\These++++\\Houcemeddine\\Lettre  Houcemeddine\\set.txt";
         FileReader inputFile = new FileReader(fileName);
         BufferedReader bufferReader = new BufferedReader(inputFile);
         bufferReader = new BufferedReader(new FileReader(fileName));
         String ligne;
         while ((ligne = bufferReader.readLine()) != null) {
             StringTokenizer st=new StringTokenizer(ligne,"\t");
             String w1=st.nextToken().toLowerCase().trim();
             String w2=st.nextToken().toLowerCase().trim();
             //double ss3=fm.XSimilarity_2006(w1, w2);
            // double ss3=fm.Tversky_1977(w1,w2);
             double ss3=fm.Rodriguez_2003(w1, w2, Depth.depthMax);;
             System.out.println(ss3);
         }
    }
    
}
