package com.marketingapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketingapp.entity.Lead;
import com.marketingapp.repository.LeadRepository;
@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	private LeadRepository leadRepo;
	@Override
	public void saveLead(Lead lead) {
		leadRepo.save(lead);
	}
	@Override
	public List<Lead> getAllLead() {
		List<Lead> lead = leadRepo.findAll();
		return lead;
	}
	@Override
	public void deleteById(long id) {
		leadRepo.deleteById(id);
	}
	@Override
	public Lead getById(long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		return findById.get();
	}

}
