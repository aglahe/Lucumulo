package org.lucumulo.model.adapters;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.lucumulo.model.IndexedDocumentContent;
import org.lucumulo.model.IndexedDocumentContentField;

/**
 * Simple implementation of {@link IndexedDocumentContent}
 */
public class IndexedDocumentContentAdapter implements IndexedDocumentContent {
	protected long documentId;

	protected Map<String, IndexedDocumentContentField> fieldValues = new TreeMap<String, IndexedDocumentContentField>();

	protected boolean isDeleted;

	@Override
	public long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(long documentId) {
		this.documentId = documentId;
	}

	@Override
	public IndexedDocumentContentField getFieldContent(String field) {
		return fieldValues.get(field);
	}

	public void setFieldValue(String field, IndexedDocumentContentField value) {
		fieldValues.put(field, value);
	}

	@Override
	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public Iterable<Entry<String, IndexedDocumentContentField>> getFieldContents() {
		return fieldValues.entrySet();
	}
}
