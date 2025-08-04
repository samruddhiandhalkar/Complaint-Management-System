package com.example.ComplentManagmentSystem;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/complaints")
//@CrossOrigin(origins = "http://localhost:5032") 
public class ComplaintController {

    @Autowired
    private ComplaintRepository complaintRepository;

    @PostMapping
    public Complaint createComplaint(@RequestBody Complaint complaint) 
    {
        return complaintRepository.save(complaint);
    }

    @GetMapping
    public List<Complaint> getAllComplaints() 
    {
        return complaintRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Complaint> getComplaintById(@PathVariable Long id) 
    {
        return complaintRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Complaint updateComplaint(@PathVariable Long id, @RequestBody Complaint updatedComplaint) 
    {
        return complaintRepository.findById(id)
                .map(complaint -> {
                    complaint.setName(updatedComplaint.getName());
                    complaint.setEmail(updatedComplaint.getEmail());
                    complaint.setSubject(updatedComplaint.getSubject());
                    complaint.setDescription(updatedComplaint.getDescription());
                    return complaintRepository.save(complaint);
                })
                .orElseGet(() -> 
                {
                    updatedComplaint.setId(id);
                    return complaintRepository.save(updatedComplaint);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteComplaint(@PathVariable Long id) 
    {
        complaintRepository.deleteById(id);
    }
}
