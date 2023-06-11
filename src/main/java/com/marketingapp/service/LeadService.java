package com.marketingapp.service;

import java.util.List;

import com.marketingapp.entity.Lead;

public interface LeadService {
public void saveLead(Lead lead);

public List<Lead> getAllLead();

public void deleteById(long id);

public Lead getById(long id);
}
