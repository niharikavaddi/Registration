package com.Registration.service;

import com.Registration.exception.DataNotUnique;
import com.Registration.model.Admin;
import com.Registration.model.Donor;
import com.Registration.model.Requestor;

public interface RegistrationService {

	public Admin createAdmin(Admin admin) throws DataNotUnique;

	public Requestor createRequestor(Requestor requestor) throws DataNotUnique;

	public Donor createDonor(Donor donor) throws DataNotUnique;

}
