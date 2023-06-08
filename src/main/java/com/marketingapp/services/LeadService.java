package com.marketingapp.services;

import java.util.List;

import com.marketingapp.entities.Lead;

public interface LeadService {

	void saveLead(Lead lead);

	List<Lead> getAllLeads();

	void deleteLeadById(long id);

	Lead updateLeadById(long id);
	
}
