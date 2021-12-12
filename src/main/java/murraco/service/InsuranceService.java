package murraco.service;

import murraco.exception.InsuranceNotFoundException;
import murraco.model.Insurance;
import murraco.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceService {
    private final InsuranceRepository illnessRepository;

    @Autowired
    public InsuranceService(InsuranceRepository illnessRepository) { this.illnessRepository = illnessRepository; }

    public Insurance addInsurance(Insurance illness) { return illnessRepository.save(illness); }

    public List<Insurance> findAllInsurances() { return illnessRepository.findAll(); }

    public Insurance updateInsurance(Insurance illness) { return illnessRepository.save(illness); }

    public Insurance findInsuranceById(Long id) {
        return illnessRepository.findInsuranceById(id).orElseThrow(() -> new InsuranceNotFoundException("Insurance by id " + id + "was not found."));
    }

    public void deleteInsurance(Long id) { illnessRepository.deleteInsuranceById(id); }
}
