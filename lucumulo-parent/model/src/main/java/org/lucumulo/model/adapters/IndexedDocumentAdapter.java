package org.lucumulo.model.adapters;

import java.util.Map;
import java.util.TreeMap;

import org.lucumulo.model.IndexedDocument;

/**
 * Simple implementation of {@link IndexedDocument}
 */
public class IndexedDocumentAdapter implements IndexedDocument {
	protected long documentId;

	protected Map<String, String> fieldValues = new TreeMap<String, String>();

	protected boolean isDeleted;

	@Override
	public long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(long documentId) {
		this.documentId = documentId;
	}

	@Override
	public String getFieldValue(String field) {
		return fieldValues.get(field);
	}

	public void setFieldValue(String field, String value) {
		fieldValues.put(field, value);
	}

	@Override
	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}
