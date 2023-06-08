package com.marketingapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.marketingapp.entities.Lead;
import com.marketingapp.repository.LeadRepository;
import com.marketingapp.utility.EmailService;

@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	private LeadRepository LeadRepo;

	@Override
	public void saveLead(Lead lead) {
		LeadRepo.save(lead);

	}

	@Override
	public List<Lead> getAllLeads() {
		List<Lead> leads = LeadRepo.findAll();
		return leads;
	}

	@Override
	public void deleteLeadById(long id) {
		LeadRepo.deleteById(id);

	}

	@Override
	public Lead updateLeadById(long id) {
		Optional<Lead> lead = LeadRepo.findById(id);
		return lead.get();
		
	}

}
