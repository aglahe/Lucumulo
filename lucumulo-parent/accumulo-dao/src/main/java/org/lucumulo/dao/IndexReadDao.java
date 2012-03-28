package org.lucumulo.dao;

import org.lucumulo.model.IndexedDocument;
import org.lucumulo.model.IndexedTerm;

/**
 * Data Access Layer definitions for querying the Index
 */
public interface IndexReadDao {
	/**
	 * @return an iterable of all terms in the index
	 */
	public Iterable<IndexedTerm> getTerms();

	/**
	 * @param field
	 *            Field name to position iterable before
	 * @param term
	 *            Term to position iterable before
	 * @return an iterable of all terms in the index, positioned before the
	 *         given field / term
	 */
	public Iterable<IndexedTerm> getTerms(String field, String term);

	/**
	 * Get a document by it's document number
	 * 
	 * @param documentId
	 *            Document number to search for
	 * @return document for the given id, or null of no such document exists
	 */
	public IndexedDocument getDocument(long documentId);
}
