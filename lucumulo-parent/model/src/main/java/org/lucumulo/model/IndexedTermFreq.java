package org.lucumulo.model;

/**
 * Model representation of a term (field, value) and its document frequency in
 * the index
 */
public interface IndexedTermFreq extends IndexedTerm {
	/**
	 * @return the number of documents that contain this term
	 */
	public long getDocumentFrequency();
}
