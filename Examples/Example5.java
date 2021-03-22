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
import WordNetSemanticSimilarity.ICApproach.ICApproachException;
import WordNetSemanticSimilarity.ICApproach.ICComputingMethod;
import WordNetSemanticSimilarity.ICApproach.ICMeasure;
import WordNetSemanticSimilarity.ICApproach.WordNetICApproaches;
import WordNetSemanticSimilarity.TaxonomicApproach.TaxonomicMeasures;
import WordNetSemanticSimilarity.TaxonomicApproach.TaxonomicMeasuresEnum;
import WordNetSemanticSimilarity.WordNetTreatment.BaseName;
import WordNetSemanticSimilarity.WordNetTreatment.Depth;
import WordNetSemanticSimilarity.WordNetTreatment.Hyponyms;
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
public class Example5 {
    public static void main(String[] args) throws FileNotFoundException, JWNLException, WordnetTreatmentException, SQLException, CorrelationException, TransformerConfigurationException, TransformerException, ParserConfigurationException, SAXException, IOException, ICApproachException 
    {
        /////////////////////////////////////////////////////////////////////////////
        //  Studying the accuracy of semantic measures through the noun benchmarks //
        ///////////////////////////////////////////////////////////////////////////// 
        String pathFilePropertiesWordNet="file_properties.xml";
        String pathWordNetDictFolder="WordNet Data\\2.1\\dict";
        WordNetVersion version=WordNetVersion.WordNet2dot1;
        POS pos=POS.NOUN;                    
        DataBaseConnection dbc=new DataBaseConnection("localhost",3306,BaseName.name,"root","") ;
        dbc.openConnection(); 
        WordNetProcessing WP=new WordNetProcessing(dbc,pathFilePropertiesWordNet,pathWordNetDictFolder,version,pos);        
        
        
        ///////////////////////////////////////////////////////
      
     /*  TaxonomicMeasures tm= new TaxonomicMeasures(WP);
       Benchmarks bench=Benchmarks.RG65;
        System.out.println("Size= "+bench.getSize());
        bench.listBenchmark();
        double[] computedValues=new double[bench.getSize()];
        Iterator<WordCoupleBenchmark> it=bench.getIterator();
        int i=-1;
        while(it.hasNext())
        {
            i++;
            WordCoupleBenchmark couple=it.next();
            double ss=tm.HadjTaieb_2014(couple.getWord1(),couple.getWord2(), Hyponyms.HypCard, Depth.depthMin);
            System.out.println(couple.getWord1()+","+couple.getWord2()+"    ss= "+ss);
            computedValues[i]=ss;
        }
       double r=Correlation.computePearsonCorrelation(bench.getJudgments(), computedValues);
        double p=Correlation.computeSpearmanCorrelation(bench.getJudgments(), computedValues);
        double r1=Correlation.computePearsonCorrelationWithoutNonTreatedCouples(bench.getJudgments(), computedValues,TaxonomicMeasuresEnum.HadjTaieb_2014);
        double p1=Correlation.computeSpearmanCorrelationWithoutNonTreatedCouples(bench.getJudgments(), computedValues,TaxonomicMeasuresEnum.HadjTaieb_2014);

        System.out.println("r="+r);
        System.out.println("p="+p);
        System.out.println("r1="+r1);
        System.out.println("p1="+p1);  
        dbc.closeConnection();*/
        //////////////////////////////////////////////////////////////////////
       /* WordNetICApproaches  wic= new WordNetICApproaches(WP);
        ICComputingMethod.Seco2004.setHyponyms(Hyponyms.HypDepthWH);
        Benchmarks bench=Benchmarks.RG65;
        System.out.println("Size= "+bench.getSize());
        bench.listBenchmark();
        double[] computedValues=new double[bench.getSize()];
        Iterator<WordCoupleBenchmark> it=bench.getIterator();
        int i=-1;
        while(it.hasNext())
        {
            i++;
            WordCoupleBenchmark couple=it.next();
            double ss=wic.SemanticSimilarityICComputing(couple.getWord1(),couple.getWord2(), ICComputingMethod.Seco2004, ICMeasure.JiangConrath1997);     
            System.out.println(couple.getWord1()+","+couple.getWord2()+"    ss= "+ss);
            computedValues[i]=ss;
        }
        double r=Correlation.computePearsonCorrelation(bench.getJudgments(), computedValues);
        double p=Correlation.computeSpearmanCorrelation(bench.getJudgments(), computedValues);
        double r1=Correlation.computePearsonCorrelationWithoutNonTreatedCouples(bench.getJudgments(), computedValues,ICMeasure.JiangConrath1997);
        double p1=Correlation.computeSpearmanCorrelationWithoutNonTreatedCouples(bench.getJudgments(), computedValues,ICMeasure.JiangConrath1997);

        System.out.println("r="+r);
        System.out.println("p="+p);
        System.out.println("r1="+r1);
        System.out.println("p1="+p1);      
        dbc.closeConnection();*/
        //////////////////////////////////////////////////////////////////////
       WordNetICApproaches  wic= new WordNetICApproaches(WP);        
        Benchmarks bench=Benchmarks.AG203;
        System.out.println("Size= "+bench.getSize());
        bench.listBenchmark();
        double[] computedValues=new double[bench.getSize()];
        Iterator<WordCoupleBenchmark> it=bench.getIterator();
        int i=-1;
        while(it.hasNext())
        {
            i++;
            WordCoupleBenchmark couple=it.next();
            double ss=wic.SemanticSimilarityICComputing(couple.getWord1(),couple.getWord2(), ICComputingMethod.BenAouicha2016, ICMeasure.Lin1998);     
            System.out.println(couple.getWord1()+","+couple.getWord2()+"    ss= "+ss);
            computedValues[i]=ss;
        }
        double r=Correlation.computePearsonCorrelation(bench.getJudgments(), computedValues);
        double p=Correlation.computeSpearmanCorrelation(bench.getJudgments(), computedValues);
        double r1=Correlation.computePearsonCorrelationWithoutNonTreatedCouples(bench.getJudgments(), computedValues,ICMeasure.Lin1998);
        double p1=Correlation.computeSpearmanCorrelationWithoutNonTreatedCouples(bench.getJudgments(), computedValues,ICMeasure.Lin1998);

        System.out.println("r="+r);
        System.out.println("p="+p);
        System.out.println("r1="+r1);
        System.out.println("p1="+p1);      
        dbc.closeConnection();
    
    }    
}
