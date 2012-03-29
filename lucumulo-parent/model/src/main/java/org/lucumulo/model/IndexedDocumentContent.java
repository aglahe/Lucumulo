package org.lucumulo.model;

/**
 * An indexed document with fielkd content and deleted flag
 */
public interface IndexedDocumentContent {
	/**
	 * Get the document id
	 * 
	 * @return
	 */
	public long getDocumentId();

	/**
	 * Get the contents of a field
	 * 
	 * @param field
	 *            Field name to get value for
	 * @return Field value, or null if no content available for field
	 */
	public String getFieldValue(String field);

	/**
	 * @return whether this document has been marked as deleted
	 */
	public boolean isDeleted();
}
