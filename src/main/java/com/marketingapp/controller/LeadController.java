package com.marketingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp.dto.LeadDto;
import com.marketingapp.entities.Lead;
import com.marketingapp.services.LeadService;
import com.marketingapp.utility.EmailService;

@Controller
public class LeadController {

	@Autowired
	private LeadService leadService;

	@Autowired
	private EmailService emailService;

	// http://localhost:8080/create
	@RequestMapping("/create")
	public String createLead() {
		return "create_lead";

	}
//   ModelAttribute use for only Entity object
	@RequestMapping("/saveLead")
	public String saveLead(@ModelAttribute Lead lead, Model model) {
		leadService.saveLead(lead);
		emailService.EmailSender(lead.getEmail(), "Text", "Good Friday");
		model.addAttribute("msg", "Record is saved!!");
		return "create_lead";

	}
//	@RequestMapping("/saveLead")
//	public String saveLead(@RequestParam("firstName") String firstName,
//			@RequestParam("lastName") String lastName,
//			@RequestParam("email") String email,
//			@RequestParam("mobile") long mobile) {
//		Lead lead=new Lead();
//		lead.setFirstName(firstName);
//		lead.setLastName(lastName);
//		lead.setEmail(email);
//		lead.setMobile(mobile);
//		leadService.saveLead(lead);
//		return "create_lead";
//		
//	}

//	@RequestMapping("/saveLead")
//	public String saveLead(LeadDto dto) {
//		Lead l=new Lead();
//		l.setId(dto.getId());
//		l.setFirstName(dto.getFirstName());
//		l.setLastName(dto.getLastName());
//		l.setEmail(dto.getEmail());
//		l.setMobile(dto.getMobile());
//		leadService.saveLead(l);
//		return "create_lead";
//		
//	}
	// http://localhost:8080/listall
	@RequestMapping("/listall")
	public String getAllLeads(Model model) {
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads", leads);
		return "search_result";

	}

	@RequestMapping("/delete")
	public String deleteLeadById(@RequestParam("id") long id, Model model) {
		leadService.deleteLeadById(id);
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads", leads);
		return "search_result";
	}

	@RequestMapping("/update")
	public String updateLeadById(@RequestParam("id") long id, Model model) {
		Lead lead = leadService.updateLeadById(id);
		model.addAttribute("lead", lead);
		return "update_lead";
	}

	@RequestMapping("/updateLead")
	public String updateLead(LeadDto dto, Model model) {
		Lead l = new Lead();
		l.setId(dto.getId());
		l.setFirstName(dto.getFirstName());
		l.setLastName(dto.getLastName());
		l.setEmail(dto.getEmail());
		l.setMobile(dto.getMobile());
		leadService.saveLead(l);
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads", leads);
		return "search_result";
	}
}
