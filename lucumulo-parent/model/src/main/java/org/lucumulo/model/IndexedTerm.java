package org.lucumulo.model;

/**
 * Model representation of an indexed term in a document, including frequency,
 * offsets and payload lengths
 */
public interface IndexedTerm {
	/**
	 * @return the field name for this term
	 */
	public String getField();

	/**
	 * @return the term value
	 */
	public String getTerm();

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
