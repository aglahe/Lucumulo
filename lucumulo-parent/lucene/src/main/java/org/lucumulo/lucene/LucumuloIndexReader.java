package org.lucumulo.lucene;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldSelectorResult;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.FieldSelector;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.TermDocs;
import org.apache.lucene.index.TermEnum;
import org.apache.lucene.index.TermFreqVector;
import org.apache.lucene.index.TermPositions;
import org.apache.lucene.index.TermVectorMapper;
import org.lucumulo.dao.IndexReadDao;
import org.lucumulo.model.IndexedDocumentContent;
import org.lucumulo.model.IndexedDocumentContentField;

/**
 * Index reader for Accumulo backed Lucene indexes
 */
public class LucumuloIndexReader extends IndexReader {
	/** DAO for reading index objects from Accumulo */
	protected IndexReadDao indexDao;

	@Override
	protected void doClose() throws IOException {

	}

	@Override
	protected void doCommit(Map<String, String> arg0) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doDelete(int arg0) throws CorruptIndexException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doSetNorm(int arg0, String arg1, byte arg2)
			throws CorruptIndexException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doUndeleteAll() throws CorruptIndexException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public int docFreq(Term arg0) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Document document(int documentId, FieldSelector fieldSelector)
			throws CorruptIndexException, IOException {
		return document((long) documentId, fieldSelector);
	}

	/**
	 * Like {@link IndexReader#document(int)}, but support long document ids
	 * 
	 * @param documentId
	 * @return
	 */
	public Document document(long documentId) {
		return document(documentId, null);
	}

	/**
	 * Like {@link IndexReader#document(int, FieldSelector)}, but support long
	 * document ids
	 * 
	 * @param documentId
	 * @param fieldSelector
	 *            Filter document fields (null for no filtering)
	 * @return
	 */
	public Document document(long documentId, FieldSelector fieldSelector) {
		IndexedDocumentContent modelDoc = indexDao.getDocument(documentId);
		if (modelDoc != null) {
			Document doc = new Document();
			FieldSelectorResult fieldSelectorResult = null;

			// iterate through all the fields and populate doc as required
			forEachFields: for (Entry<String, IndexedDocumentContentField> entry : modelDoc
					.getFieldContents()) {
				fieldSelectorResult = fieldSelector == null ? FieldSelectorResult.LOAD
						: fieldSelector.accept(entry.getKey());

				switch (fieldSelectorResult) {
				case NO_LOAD:
					// skip field load
					continue;

				case LATENT:
				case LAZY_LOAD:
				case LOAD:
					addDocField(doc, entry, true);
					// we don't have any special way to handle lazy / latent so
					// we'll just load them in now
					break;

				case SIZE:
					addDocField(doc, entry, false);
					break;

				case SIZE_AND_BREAK:
				case LOAD_AND_BREAK:
					addDocField(doc, entry, true);
					break forEachFields;

				default:
					throw new RuntimeException("No handler logic for "
							+ fieldSelectorResult);
				}
			}
		}

		return null;
	}

	/**
	 * Add a field to the given document
	 * 
	 * @param doc
	 * @param entry
	 * @param b
	 */
	private void addDocField(Document doc,
			Entry<String, IndexedDocumentContentField> entry, boolean sizeOnly) {

		if (sizeOnly) {
			byte[] b = new byte[4];
			b[0] = 0;
			b[1] = 0;
			b[2] = 0;
			b[3] = 0;

			doc.add(new Field(entry.getKey(), b));
		}
	}

	@Override
	public Collection<String> getFieldNames(FieldOption fieldOption) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TermFreqVector getTermFreqVector(int arg0, String arg1)
			throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getTermFreqVector(int arg0, TermVectorMapper arg1)
			throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void getTermFreqVector(int arg0, String arg1, TermVectorMapper arg2)
			throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public TermFreqVector[] getTermFreqVectors(int arg0) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasDeletions() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDeleted(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int maxDoc() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public byte[] norms(String arg0) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void norms(String arg0, byte[] arg1, int arg2) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public int numDocs() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TermDocs termDocs() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TermPositions termPositions() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TermEnum terms() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TermEnum terms(Term arg0) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
