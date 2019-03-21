package pwc.cases;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import com.google.inject.Inject;

public class InvertedIndexBuilder
{
	private JavaSparkContext sparkContext;

	@Inject
	public InvertedIndexBuilder(JavaSparkContext sparkContext)
	{
		this.sparkContext = sparkContext;
	}

	public InvertedIndex Build(String fileName)
	{
		JavaRDD<String> lines = sparkContext.textFile(fileName);

		System.out.println("Number of lines being indexed: " + lines.count());

		JavaPairRDD<String, Long> entriesWithLineNumbers = lines
				.flatMapToPair(new GetEntriesWithLineNumbersFromString());

		JavaPairRDD<String, Long> wordsWithLineNumbers = entriesWithLineNumbers
				.filter(entryAndLineNumber -> !entryAndLineNumber._1.isEmpty());

		System.out.println("Number of words being indexed: " + wordsWithLineNumbers.count());

		return new InvertedIndex(
				wordsWithLineNumbers.countByKey(), 
				wordsWithLineNumbers.groupByKey().cache());

	}
}
