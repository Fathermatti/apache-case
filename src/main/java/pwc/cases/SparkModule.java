package pwc.cases;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class SparkModule extends AbstractModule
{  
	@Override 
	protected void configure() 
	{
	}
	
	@Provides
	@Singleton
	JavaSparkContext provideInputEventRingBuffer()
	{
		SparkConf conf = new SparkConf().setAppName("Simple Application").setMaster("local");
		return new JavaSparkContext(conf);
	}
}
