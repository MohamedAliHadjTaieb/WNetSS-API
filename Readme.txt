                                           WNetSS Java API

                          Authors: Mohamed Ali Hadj Taieb and Mohamed Ben Aouicha

                         contacts: mohamedali.hadjtaieb@gmail.com
                                   benaouicha.mohamed@gmail.com

			     Date: May 2016


*************************************************************************************************

Presentation

*************************************************************************************************

WNetSS is a java API for measuring semantic similarity between words using WordNet-based measures.
It ensures the reproductibility of semantic similaruty measures existing in the literature and it allows to the 
acadameics for proposing new models using the extracted paramters.
 
This API is composed of 3 modules:

	1- Treatment Wordnet module    : for extracting the topological parameters from the WordNet "is a" taxonomies (nominal and verbal ones).

	2- Semantic similarity measures: it includes the WordNet-based semantic similarity measures between words. These measures pertain to
                                         three categories: taxonomic-based, information content-based and features-based measures.

	3- Accuracy assessment         : it includes 10 benchmarks used for evaluating semantic similarity measures. Moreover, it allows to compute the
                                         the Pearson and Spearman correlation coefficents as evaluation metrics.


*************************************************************************************************

Folders

*************************************************************************************************

The folders included in the shared link are:

- WNetSS jar: contains the necessary packages .jar (including WNetSS.jar) for exploiting the WordNet-based semantic similarity measures.

- WNetSS API source code: contains the source code of the Java API WNetSS.

- WNetSS javadoc: The javadoc of the API WNetSS.

- WNetSSExamples: conatins 10 examples for explaining the use of the WNetSS services.It includes the data of English WordNet 2.1 and 3.0




*************************************************************************************************

Informations

*************************************************************************************************

- A java Doc is provided with this API for helping the develpoers.

- The English WordNet versions taken in consideration are: 2.1 and 3.0.

- WNetSS is able to treat the verb  and noun WordNet "is a" taxonomies.

- The module of WordNet treatment allows the extraction of the topological paramters from the WordNet "is a" taxonomies such as : 
  depth, hyponyms, ancestors and the lowest common subsumer.

- The depth is expressed in several ways: depthmax, depthmin, depthProb, and depthWH

- The hyponyms quantification is expressed in sevral ways: HypoCard, HypDepthmax, HypLeaf, HypDepthProb and HypDepthWH

- WNetSS is the first API that provides the intrinsic Information Content-based similarity measures based on two paramters: 
  the IC computing method and the IC-based measure. Each IC computing method exploiting the depth and/or the hyponyms can be 
  parametrized using the diffrent ways to express them.

- The benchamrks trated in this API are: RG65, MC30, AG203, WordSim353,SimLex666, GM30, MTurk771, MeSH38, YP130 and SimLex222. 
  It is important to note that YP130 and SimLex222 are verbal benchamrks. Also, for the MeSH38, it contains biomedical terms.

- The packages used in the developent of the WNetSS API are:

	+ commons-logging-1.1.1.jar
	+ commons-math3-3.4.1.jar
	+ extjwnl-1.6.7.jar
	+ extjwnl-utilities-1.6.7.jar
	+ lucene-analyzers-common-4.0.0.jar
	+ mysql-connector-java-5.1.21.jar
        + concurrentlinkedhashmap-lru-1.3.1.jar

- The WNetSS and the Examples are developed via NetBeans 7.3.1


*************************************************************************************************

Instructions

*************************************************************************************************

N.B    10 Exmaples using the WNetSS API are provided for helping the developers.


The instructions that must be followed are:

- install the MySQL 

- install the English WordNet (2.1 and/or 3.0)

- copy the file "file_properties.xml", that contains the configuration for accessing to the WordNet data, in your work folder.

- Treating the wordNet "is a" taxonomy (verbal or nominal) as it is indicated in Example0.java (for creating the wordnet database) 
  and Example1.java (for extracting the paramters).

- Exploiting the semantic similarity measures such as presented in the provided examples.


*************************************************************************************************

Examples

*************************************************************************************************

-Example0: Creating data base and loading WordNet data.

-Example1: Extracting Topological Parameters of Nominal WordNet "is a" taxonomy.

-Example2: Wordnet Semantic Similarity Taxonomic Measures.

-Example3: Wordnet Semantic Similarity Information Content Approach.

-Example4: Wordnet Semantic Similarity Features Approach.

-Example5: Studying the accuracy of semantic measures through the nominal benchmarks.

-Example6: Extracting Topological Parameters of Verbal WordNet "is a" taxonomy.

-Example7: Studying the accuracy of semantic measures through the verbal benchmarks

-Example8: Wordnet "is a" taxonomy - Topological paramters.

-Example9: Wordnet "is a" taxonomy - Length Shortest Path Similarity Measure.
