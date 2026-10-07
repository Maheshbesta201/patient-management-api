package com.westgate.patient.exception;

public class ClinicalRecordNotFoundException
        extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClinicalRecordNotFoundException(Long id) {

        super("Clinical record not found with id: " + id);
    }
}