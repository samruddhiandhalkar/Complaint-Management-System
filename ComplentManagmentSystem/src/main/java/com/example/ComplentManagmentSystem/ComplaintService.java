package com.example.ComplentManagmentSystem;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository repo;

    public Complaint saveComplaint(Complaint complaint) {
        return repo.save(complaint);
    }

    public List<Complaint> getAllComplaints() {
        return repo.findAll();
    }

    public Optional<Complaint> getComplaintById(Long id) {
        return repo.findById(id);
    }

    public Complaint updateComplaint(Long id, Complaint complaint) {
        Complaint existing = repo.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(complaint.getName());
            existing.setEmail(complaint.getEmail());
            existing.setSubject(complaint.getSubject());
            existing.setDescription(complaint.getDescription());
            return repo.save(existing);
        }
        return null;
    }

    public boolean deleteComplaint(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
