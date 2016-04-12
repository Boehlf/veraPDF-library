package org.verapdf.processor;

import org.verapdf.processor.config.Config;
import org.verapdf.report.ItemDetails;

import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * ProcessorApi encapsulates all validation
 * Created by Shemyakov Sergey on 4/11/16.
 */
public interface ProcessorApi {

	/**
	 * Method performs pdf validation with given options
	 *
	 * @param pdfFile input stream, containing file to be validated
	 * @param fileDetails details about file to be validated
	 * @param config settings used in validation
	 * @param report output stream, in which report will be written
	 */
	public void validate(InputStream pdfFile, ItemDetails fileDetails,
						 Config config, FileOutputStream report);

}
