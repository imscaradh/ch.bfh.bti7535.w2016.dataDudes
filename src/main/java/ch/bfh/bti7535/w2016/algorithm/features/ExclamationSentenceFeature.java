package ch.bfh.bti7535.w2016.algorithm.features;

import ch.bfh.bti7535.w2016.data.Classification;
import ch.bfh.bti7535.w2016.data.Document;

import java.util.List;

public class ExclamationSentenceFeature extends SentenceFeature {

	@Override
	public void train(List<Document> documents, Classification classification) {
		execute(documents, classification, Type.EXCLAMATION);
	}
}
