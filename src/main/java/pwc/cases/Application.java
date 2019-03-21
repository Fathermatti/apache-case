package pwc.cases;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Application
{
	public static void main(String[] args)
	{
		Injector injector = Guice.createInjector(new SparkModule());
		InvertedIndexBuilder invertedIndexBuilder = injector.getInstance(InvertedIndexBuilder.class);
		
		String inputFile = "main.txt";
		InvertedIndex invertedIndex = invertedIndexBuilder.Build(inputFile);

		System.out.println("Index length: " + invertedIndex.wordCounts.size());
		System.out.println("Occurences of the word \"book\": " + invertedIndex.wordCounts.get("book").toString());
		System.out.println("Line numbers for the word \"book\": " + invertedIndex.index.lookup("book").toString());
	}
}
 