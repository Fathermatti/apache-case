package pwc.cases;

import java.util.Map;

import org.apache.spark.api.java.JavaPairRDD;

public class InvertedIndex
{
	public Map<String, Long> wordCounts;
	public JavaPairRDD<String, Iterable<Long>> index;
	
	public InvertedIndex(Map<String, Long> wordCounts, JavaPairRDD<String, Iterable<Long>> index)
	{
		this.wordCounts = wordCounts;
		this.index = index;
	}
}
