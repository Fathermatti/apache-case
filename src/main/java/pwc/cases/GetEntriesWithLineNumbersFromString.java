package pwc.cases;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.spark.api.java.function.PairFlatMapFunction;

import scala.Tuple2;

public class GetEntriesWithLineNumbersFromString implements PairFlatMapFunction<String, String, Long>
{
	public Iterator<Tuple2<String, Long>> call(String line)
	{
		String[] lineNumberAndString = line.split(":");
		
		long lineNumber = Long.parseLong(lineNumberAndString[0]);
		String[] entries = lineNumberAndString[1].split(" ");

		ArrayList<Tuple2<String, Long>> entriesWithLineNumbers = new ArrayList<Tuple2<String, Long>>();

		for (int i = 1; i < entries.length; i++)
		{
			entriesWithLineNumbers.add(new Tuple2<String, Long>(entries[i], lineNumber));
		}

		return entriesWithLineNumbers.iterator();
	}
}
