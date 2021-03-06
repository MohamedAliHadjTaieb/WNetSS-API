# Introduction
<p align="justify">Determining the Semantic Similarity (SS) between word pairs is an important component in several research fields such as artificial intelligence, information retrieval, natural language processing and biomedical domain. The majority of SS measures are assessed using the lexical database WordNet.</p>
<img src="https://user-images.githubusercontent.com/19282671/112055772-8d103f80-8b57-11eb-9ce6-2e84841c0336.png"/ align="center">
<br>

# WNetSS-API
 <p align="justify">The API WNetSS (WordNet Semantic Similarity) allows the reproducibility of a wide range of SS measures pertaining to different categories including taxonomic-based, features-based and IC-based measures. This API allows the extraction of the topological parameters from the WordNet “is a” taxonomy which are used to express the semantics of concepts. Also, we give the different ways in expressing the topological parameters depth and the hyponyms’ subgraph. Moreover, an evaluation module is proposed to assess the measures accuracy that can be evaluated and compared according to several widely-used benchmarks through the correlations coefficients.</p>
<br>
WNetSS API can be dowloaded: <a href="https://github.com/MohamedAliHadjTaieb/WNetSS-API/raw/main/WNetSS%20jar.rar">link</a>

 
 <img src="https://user-images.githubusercontent.com/19282671/112054825-5e459980-8b56-11eb-82f3-df2330db8f93.png" align="center"/>
 <br>
 
 # Information Content (IC) based semantic similarity measures
 <p align="justify">The IC-based similarity measure was first introduced by Resnik. The basic idea of IC is that general and abstract entities found in a discourse present less IC than more concrete and specialized ones. This principle is inspired from the work of Shannon. The more probable a concept appears, the less information it conveys. The concept has then been modified and extended by several authors to include other methods. Although they commonly rely on IC values assigned to the concepts in the ontology. IC-based measures are based on couples (IC computing method, IC measure). Concerning the computing IC methods, they follow two strategies: statistical corpora analysis and exploiting only the topological parameters of “is a” taxonomy known as intrinsic computing method.</p>
 <img src="https://user-images.githubusercontent.com/19282671/112056548-6e5e7880-8b58-11eb-8a21-7a6b8f164522.png" align="center"/>
 <br>
 
 # Instructions for using the API
The instructions that must be followed are:
<ul>
 <li> install the MySQL </li>

<li>install the English WordNet (2.1 and/or 3.0)</li>

<li>copy the file "file_properties.xml", that contains the configuration for accessing to the WordNet data, in your work folder.</li>

<li>Treating the wordNet "is a" taxonomy (verbal or nominal) as it is indicated in Example0.java (for creating the wordnet database) 
  and Example1.java (for extracting the paramters)</li>

<li>Exploiting the semantic similarity measures such as presented in the provided examples.</li>
</ul>
For more information visit the file <a href="https://github.com/MohamedAliHadjTaieb/WNetSS-API/blob/main/Readme.txt">readme.txt</a>

# Examples
10 Exmaples using the WNetSS API are provided for helping the developers.
<ul>
 <li>Example0: Creating data base and loading WordNet data.</li>

 <li>Example1: Extracting Topological Parameters of Nominal WordNet "is a" taxonomy.</li>

 <li>Example2: Wordnet Semantic Similarity Taxonomic Measures.</li>

 <li>Example3: Wordnet Semantic Similarity Information Content Approach.</li>

 <li>Example4: Wordnet Semantic Similarity Features Approach.</li>

 <li>Example5: Studying the accuracy of semantic measures through the nominal benchmarks.</li>

 <li>Example6: Extracting Topological Parameters of Verbal WordNet "is a" taxonomy.</li>

 <li>Example7: Studying the accuracy of semantic measures through the verbal benchmarks.</li>

 <li>Example8: Wordnet "is a" taxonomy - Topological paramters.</li>

 <li>Example9: Wordnet "is a" taxonomy - Length Shortest Path Similarity Measure.</li>
</ul> <br><br>
 For downloading all Examples follow this link : <a href="https://drive.google.com/file/d/11Kvs2oJtxEC8TZgZPRWNlLc2MweMG98A/view?usp=sharing">download examples</a>
 
 # Reference the work
 Mohamed Ben Aouicha, Mohamed Ali Hadj Taieb, Abdelmajid Ben Hamadou: SISR: System for integrating semantic relatedness and similarity measures. Soft Comput. 22(6): 1855-1879 (2018) <a href="https://link.springer.com/article/10.1007/s00500-016-2438-x">LINK</a>
