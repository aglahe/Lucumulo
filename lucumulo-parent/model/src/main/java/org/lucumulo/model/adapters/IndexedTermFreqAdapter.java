package org.lucumulo.model.adapters;

import org.lucumulo.model.IndexedTermFreq;

/**
 * Simple implementation for {@link IndexedTermFreq}
 */
public class IndexedTermFreqAdapter implements IndexedTermFreq {
	protected String term;
	protected String field;
	protected long documentFrequency;

	@Override
	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	@Override
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Override
	public long getDocumentFrequency() {
		return documentFrequency;
	}

	public void setDocumentFrequency(long documentFrequency) {
		this.documentFrequency = documentFrequency;
	}
}
