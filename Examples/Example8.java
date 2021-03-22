/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wnetssexamples;

import WordNetSemanticSimilarity.DataBaseConnection.DataBaseConnection;
import WordNetSemanticSimilarity.WordNetTreatment.BaseName;
import WordNetSemanticSimilarity.WordNetTreatment.Depth;
import WordNetSemanticSimilarity.WordNetTreatment.TopologicalParameters;
import WordNetSemanticSimilarity.WordNetTreatment.WordNetProcessing;
import WordNetSemanticSimilarity.WordNetTreatment.WordNetVersion;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import net.sf.extjwnl.JWNLException;
import net.sf.extjwnl.data.IndexWord;
import net.sf.extjwnl.data.POS;
import net.sf.extjwnl.data.Synset;
import org.xml.sax.SAXException;

/**
 * @author Mohamed Ali Hadj Taieb and Mohamed Ben Aouicha
 */
public class Example8 {
     public static void main(String[] args) throws TransformerConfigurationException, TransformerException, ParserConfigurationException, SAXException, IOException, JWNLException, SQLException
     {
        ////////////////////////////////////////////////////////////////////////
        //             Wordnet "is a" taxonomy - Topological paramters
        //////////////////////////////////////////////////////////////////////// 
         String pathFilePropertiesWordNet="file_properties.xml";
         String pathWordNetDictFolder="WordNet Data\\3.0\\dict";
         WordNetVersion version=WordNetVersion.WordNet3dot0;    
         POS pos=POS.NOUN;
         DataBaseConnection dbc=new DataBaseConnection("localhost",3306,BaseName.name,"root","") ;
         TopologicalParameters tp=new TopologicalParameters(dbc,version,pos);
         dbc.openConnection(); 
         IndexWord w=WordNetProcessing.getWordnet(pathWordNetDictFolder,pathFilePropertiesWordNet).getIndexWord(pos,"car");
         if(w!=null )
         {
             List<Synset> l=w.getSenses();
             int n1=l.size();
             for(int i=0;i<n1;i++)
             {
                 Synset syn=l.get(i);
                 System.out.println(syn+" ==> "+tp.getDepth(((Long)syn.getKey()).longValue(), Depth.depthMax));
             }  
         }                               
         dbc.closeConnection();        
     }
    
}
