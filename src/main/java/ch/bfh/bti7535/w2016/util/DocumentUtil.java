package ch.bfh.bti7535.w2016.util;

import ch.bfh.bti7535.w2016.data.Document;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DocumentUtil {
	private static String[] sentenceEnds = new String[] { ".", "?", "!" };

	public static int countWords(Document doc) {
		Map<String, Document.WordProperty> content = doc.getContentWithWordProperties();

		int matches = 0;
		for (String token : content.keySet()) {
			matches += content.get(token).getOccurrence();
		}
		return matches;
	}

	public static int countSingleWord(Document doc, String word) {
		Map<String, Document.WordProperty> content = doc.getContentWithWordProperties();
		Document.WordProperty wordProperty = content.get(word);
		return (wordProperty != null) ? content.get(word).getOccurrence() : 0;
	}

	public static int countSentences(List<Document> documents) {
		int sum = 0;
		for (Document doc : documents) {
			sum += countSentences(doc);
		}
		return sum;
	}

	public static int countSentences(Document doc) {
		Map<String, Document.WordProperty> content = doc.getContentWithWordProperties();

		int sentences = 0;
		for (String word : content.keySet()) {
			if (CollectionUtil.isStringInList(word, sentenceEnds))
				sentences += content.get(word).getOccurrence();
		}

		return sentences;
	}

	public static int countPointSenctences(Document doc) {
		Map<String, Document.WordProperty> content = doc.getContentWithWordProperties();

		int sentences = 0;
		for (String word : content.keySet()) {
			if (word.contains(sentenceEnds[0]))
				sentences += content.get(word).getOccurrence();
		}

		return sentences;
	}

	public static int countQuestionSenctences(Document doc) {
		Map<String, Document.WordProperty> content = doc.getContentWithWordProperties();

		int sentences = 0;
		for (String word : content.keySet()) {
			if (word.contains(sentenceEnds[1]))
				sentences += content.get(word).getOccurrence();
		}

		return sentences;
	}

	public static int countExclamationSenctences(Document doc) {
		Map<String, Document.WordProperty> content = doc.getContentWithWordProperties();

		int sentences = 0;
		for (String word : content.keySet()) {
			if (word.contains(sentenceEnds[2]))
				sentences += content.get(word).getOccurrence();
		}

		return sentences;
	}

	public static int countSpecificWord(Document doc, String searchWord) {
	    List<String> content = doc.getContent();

	    int searchWordAmount = 0;
	    for (String word : content) {
	        if(Objects.equals(word, searchWord)) searchWordAmount++;
        }

        return searchWordAmount;
    }
}
