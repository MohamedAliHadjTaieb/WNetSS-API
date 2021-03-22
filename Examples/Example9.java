/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wnetssexamples;

import BenchmarkEvaluation.Benchmarks;
import BenchmarkEvaluation.Correlation;
import BenchmarkEvaluation.CorrelationException;
import BenchmarkEvaluation.WordCoupleBenchmark;
import WordNetSemanticSimilarity.DataBaseConnection.DataBaseConnection;
import WordNetSemanticSimilarity.PathApproach.MinPathLength;
import WordNetSemanticSimilarity.WordNetTreatment.BaseName;
import WordNetSemanticSimilarity.WordNetTreatment.WordNetProcessing;
import WordNetSemanticSimilarity.WordNetTreatment.WordNetVersion;
import WordNetSemanticSimilarity.WordNetTreatment.WordnetTreatmentException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
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
public class Example9 {
     public static void main(String[] args) throws SQLException, FileNotFoundException, JWNLException, TransformerException, TransformerConfigurationException, ParserConfigurationException, SAXException, IOException, WordnetTreatmentException, CorrelationException 
     {
        ////////////////////////////////////////////////////////////////////////
        //  Wordnet "is a" taxonomy - Length Shortest Path Similarity Measure
        //////////////////////////////////////////////////////////////////////// 
        String pathFilePropertiesWordNet="file_properties.xml";
        String pathWordNetDictFolder="WordNet Data\\3.0\\dict";
        POS pos=POS.NOUN;
        WordNetVersion version=WordNetVersion.WordNet3dot0;                    
        DataBaseConnection dbc=new DataBaseConnection("localhost",3306,BaseName.name,"root","") ;
        dbc.openConnection(); 
        WordNetProcessing WP=new WordNetProcessing(dbc,pathFilePropertiesWordNet,pathWordNetDictFolder,version,pos);                       
        ///////////////////////////////////////////////////////     
        MinPathLength mpl= new MinPathLength(WP);
        Benchmarks bench=Benchmarks.SimLex666;
        System.out.println("Size= "+bench.getSize());        
        double[] computedValues=new double[bench.getSize()];
        Iterator<WordCoupleBenchmark> it=bench.getIterator();
        int i=-1;
        while(it.hasNext())
        {
            i++;
            WordCoupleBenchmark couple=it.next();
            double ss=mpl.getMinPathLength(couple.getWord1(), couple.getWord2());
            System.out.println(couple.getWord1()+","+couple.getWord2()+"    ss= "+ss);
            computedValues[i]=ss;
        }
        double r=Correlation.computePearsonCorrelation(bench.getJudgments(), computedValues);
        double p=Correlation.computeSpearmanCorrelation(bench.getJudgments(), computedValues);
        double r1=Correlation.computePearsonCorrelationWithoutNonTreatedCouples(bench.getJudgments(), computedValues,mpl);
        double p1=Correlation.computeSpearmanCorrelationWithoutNonTreatedCouples(bench.getJudgments(), computedValues,mpl);

        System.out.println("r="+r);
        System.out.println("p="+p);
        System.out.println("r1="+r1);
        System.out.println("p1="+p1);
       /*  double ss=mpl.getMinPathLength("gem", "jewel");
         System.out.println("ss="+ss);*/
        dbc.closeConnection();
        //////////////////////////////////////////////////////////////////////    
     }
    
}
