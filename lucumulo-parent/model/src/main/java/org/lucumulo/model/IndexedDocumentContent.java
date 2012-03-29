package org.lucumulo.model;

import java.util.Map.Entry;

/**
 * An indexed document with field content and deleted flag
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
	 * @return Field content value, or null if no content available for field
	 */
	public IndexedDocumentContentField getFieldContent(String field);

	/**
	 * @return Iterate over the field name / content value pairs for this
	 *         document
	 */
	public Iterable<Entry<String, IndexedDocumentContentField>> getFieldContents();

	/**
	 * @return whether this document has been marked as deleted
	 */
	public boolean isDeleted();
}
