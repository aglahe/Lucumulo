package org.lucumulo.model;

/**
 * Model representation of a term (field, value) in the index
 */
public interface IndexedTerm {
	/**
	 * @return the term's value
	 */
	public String getTerm();

	/**
	 * @return the term's field
	 */
	public String getField();

}
