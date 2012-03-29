package org.lucumulo.model;

/**
 * Model to describe the content of a document field
 */
public interface IndexedDocumentContentField {
	/**
	 * Get the fields binary content and place it into the byte buffer provider,
	 * at the given offset
	 * 
	 * @param buf
	 *            Buffer to store field binary contents
	 * @param offset
	 *            Offset in buffer to store field contents
	 * @return Number of bytes copied to buffer
	 */
	public int getByteContent(byte[] buf, int offset);

	/**
	 * Convenience method to get field contents as a {@link String}
	 * 
	 * @return String interpretation of field contents
	 */
	public String getStringContent();

	/**
	 * @return flag to denote if the field contents are compressed
	 */
	public boolean isCompressed();

	/**
	 * @return flag to denote if the field contents have been tokenized
	 */
	public boolean isTokenized();

	/**
	 * @return flag to denote if the field contents represent binary data
	 */
	public boolean isBinary();

	/**
	 * @see {@link #isFloat()} , {@link #isInt()}, {@link #isDouble()},
	 *      {@link #isLong()}
	 * @return flag to denote if the field contents represent a number
	 */
	public boolean isNumeric();

	/**
	 * @return flag to denote if the field contents represent a float number (4
	 *         bytes)
	 */
	public boolean isFloat();

	/**
	 * @return flag to denote if the field contents represent a int number (4
	 *         bytes)
	 */
	public boolean isInt();

	/**
	 * @return flag to denote if the field contents represent a double number (8
	 *         bytes)
	 */
	public boolean isDouble();

	/**
	 * @return flag to denote if the field contents represent a long number (8
	 *         bytes)
	 */
	public boolean isLong();

	/**
	 * @return the field content length, in bytes
	 */
	public int getContentLength();
}
