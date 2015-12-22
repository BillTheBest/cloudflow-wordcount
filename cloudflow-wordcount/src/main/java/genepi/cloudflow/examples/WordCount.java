package genepi.cloudflow.examples;

import java.io.IOException;

import cloudflow.core.Pipeline;
import cloudflow.core.hadoop.MapReduceRunner;
import cloudflow.core.operations.Transformer;
import cloudflow.core.records.IntegerRecord;
import cloudflow.core.records.TextRecord;
import cloudflow.core.spark.SparkRunner;

public class WordCount {

	public static class LineToWords extends
			Transformer<TextRecord, IntegerRecord> {

		private IntegerRecord out = new IntegerRecord();

		public LineToWords() {
			super(TextRecord.class, IntegerRecord.class);
		}

		public void transform(TextRecord rec) {
			String[] words = rec.getValue().split(" ");
			for (String word : words) {
				out.setKey(word);
				out.setValue(1);
				emit(out);
			}
		}
	}

	public static void main(String[] args) throws IOException {

		String tool = args[0];

		String input = args[1];
		String output = args[2];

		Pipeline pipeline = new Pipeline("WordCount", WordCount.class);
		pipeline.loadText(input).apply(LineToWords.class).sum().save(output);

		if (tool.equals("mapreduce")) {
			new MapReduceRunner().run(pipeline);
		}

		if (tool.equals("spark")) {
			new SparkRunner("yarn-client").run(pipeline);
		}

	}
}