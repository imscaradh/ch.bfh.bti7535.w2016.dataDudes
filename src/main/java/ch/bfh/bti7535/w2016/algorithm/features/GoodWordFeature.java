package ch.bfh.bti7535.w2016.algorithm.features;

import ch.bfh.bti7535.w2016.data.Classification;
import ch.bfh.bti7535.w2016.data.Document;
import ch.bfh.bti7535.w2016.util.DocumentUtil;

import java.util.List;

public class GoodWordFeature extends AbstractFeature {

	@Override
	public void train(List<Document> documents, Classification classification) {
		List<String> content;
		int wordAmount = 0;
		int goodWordAmount = 0;

		for (Document doc : documents) {
			if (doc.getGoldStandard().equals(classification)) {
				content = doc.getContent();
				wordAmount += content.size();
			}
		}

		for (Document doc : documents) {
			if (doc.getGoldStandard().equals(classification))
				goodWordAmount += DocumentUtil.countSpecificWord(doc, "good");
		}

		float result = (wordAmount > 0.0001) ? goodWordAmount / wordAmount : 0;
		setProbability(classification, result);
	}
}