package org.lucumulo.dao;

import org.lucumulo.model.IndexedDocumentContent;
import org.lucumulo.model.IndexedDocumentTerm;
import org.lucumulo.model.IndexedTermFreq;

/**
 * Data Access Layer definitions for querying the Index
 */
public interface IndexReadDao {
	/**
	 * @param field
	 *            Field name to position iterable before
	 * @param term
	 *            Term to position iterable before
	 * @param documentId
	 *            document to position iterable after (-1 for the first
	 *            document) fo rthe given (field, term) pair
	 * @return an iterable of all document terms in the index, positioned at the
	 *         given (field, term) pair. Iterable should be bounded to the given
	 *         field and term
	 */
	public Iterable<IndexedDocumentTerm> getTermDocs(String field, String term,
			long documentId);

	/**
	 * @param field
	 *            Field name to position iterable before
	 * @param term
	 *            Term to position iterable before
	 * @return an iterable of term frequencies in the index, positioned at the
	 *         given (field, term) pair. Iterable shoudl run to the end of all
	 *         terms if required
	 */
	public Iterable<IndexedTermFreq> getTerms(String field, String term);

	/**
	 * Get a document by it's document number
	 * 
	 * @param documentId
	 *            Document number to search for
	 * @return document for the given id, or null of no such document exists
	 */
	public IndexedDocumentContent getDocument(long documentId);

	/**
	 * @return the largest document id observed
	 */
	public long getMaximumDocumentId();
}
