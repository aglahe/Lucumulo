package org.lucumulo.model.adapters;

import org.lucumulo.model.IndexedTerm;

/**
 * Simple implementation for {@link IndexedTerm}
 */
public class IndexedTermAdapter implements IndexedTerm {
	protected String field;
	protected String term;
	protected long documentId;
	protected long termFrequency;
	protected int[] termOffsets;
	protected int[] termPayloads;

	@Override
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Override
	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	@Override
	public long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(long documentId) {
		this.documentId = documentId;
	}

	@Override
	public long getTermFrequency() {
		return termFrequency;
	}

	public void setTermFrequency(long termFrequency) {
		this.termFrequency = termFrequency;
	}

	@Override
	public int[] getTermOffsets() {
		return termOffsets;
	}

	public void setTermOffsets(int[] termOffsets) {
		this.termOffsets = termOffsets;
	}

	@Override
	public int[] getTermPayloads() {
		return termPayloads;
	}

	public void setTermPayloads(int[] termPayloads) {
		this.termPayloads = termPayloads;
	}

}
