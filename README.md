# WNetSS-API
 The API WNetSS (WordNet Semantic Similarity) allows the reproducibility of a wide range of SS measures pertaining to different categories including taxonomic-based, features-based and IC-based measures. This API allows the extraction of the topological parameters from the WordNet “is a” taxonomy which are used to express the semantics of concepts. Also, we give the different ways in expressing the topological parameters depth and the hyponyms’ subgraph. Moreover, an evaluation module is proposed to assess the measures accuracy that can be evaluated and compared according to several widely-used benchmarks through the correlations coefficients.
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
 # Reference the work
 Mohamed Ben Aouicha, Mohamed Ali Hadj Taieb, Abdelmajid Ben Hamadou: SISR: System for integrating semantic relatedness and similarity measures. Soft Comput. 22(6): 1855-1879 (2018) <a href="https://link.springer.com/article/10.1007/s00500-016-2438-x">LINK</a>
