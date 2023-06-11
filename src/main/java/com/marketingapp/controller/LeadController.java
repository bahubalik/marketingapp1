package com.marketingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp.dto.LeadDto;
import com.marketingapp.entity.Lead;
import com.marketingapp.service.LeadService;
import com.marketingapp.utitlity.EmailService;

@Controller
public class LeadController {

	@Autowired
	private LeadService leadService;
	
	@Autowired
	private EmailService emailservice;
	
	//http://localhost:8080/create
	@RequestMapping("/create")
	public String viewCreateLead() {
		return "create_lead";
	}
	@RequestMapping("/saveLead")
	public String saveLead(Lead lead, ModelMap model) {
		leadService.saveLead(lead);
		emailservice.sendEmail(lead.getEmail(), "test", "bhosadike");
		model.addAttribute("msg", "Record is Saved!!");
		return "create_lead";
	}
	//http://localhost:8080/listAll
	@RequestMapping("/listAll")
	public String getAll(Model model) {
		List<Lead> lead = leadService.getAllLead();
		model.addAttribute("leads", lead);
		return "search_lead";
	}
	@RequestMapping("/delete")
	public String deleteById(@RequestParam("id") long id, Model model) {
		leadService.deleteById(id);
		List<Lead> lead = leadService.getAllLead();
		model.addAttribute("leads", lead);
		return "search_lead";
	}
	@RequestMapping("/update")
	public String getByid(@RequestParam("id") long id,Model model) {
		Lead lead = leadService.getById(id);
		model.addAttribute("lead", lead);
		return "update_lead";
	}
	@RequestMapping("/updateLead")
	public String updateById(LeadDto dto,Model model) {
		Lead l = new Lead();
		l.setId(dto.getId());
		l.setFirstName(dto.getFirstName());
		l.setLastName(dto.getLastName());
		l.setEmail(dto.getEmail());
		l.setMobile(dto.getMobile());
		
		leadService.saveLead(l);
		
		List<Lead> lead = leadService.getAllLead();
		model.addAttribute("leads", lead);
		return "search_lead";
	}
}
