package org.lucumulo.model;

/**
 * Model representation of an indexed term in a document, including frequency,
 * offsets and payload lengths
 */
public interface IndexedDocumentTerm extends IndexedTerm {
	/**
	 * @return the parent document id
	 */
	public long getDocumentId();

	/**
	 * @return the frequency of this term in the parent document field
	 */
	public long getTermFrequency();

	/**
	 * @return the offsets of instances of this term in the parent document
	 *         field
	 */
	public int[] getTermOffsets();

	/**
	 * @return the payload lengths for instances of this term in the parent
	 *         document field, or null is not available
	 */
	public int[] getTermPayloads();
}
