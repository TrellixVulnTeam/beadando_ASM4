package murraco.service;

import murraco.exception.InsuranceNotFoundException;
import murraco.model.Insurance;
import murraco.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;

    @Autowired
    public InsuranceService(InsuranceRepository insuranceRepository) { this.insuranceRepository = insuranceRepository; }

    public Insurance addInsurance(Insurance insurance) { return insuranceRepository.save(insurance); }

    public List<Insurance> findAllInsurances() { return insuranceRepository.findAll(); }

    public Insurance updateInsurance(Insurance insurance) { return insuranceRepository.save(insurance); }

    public Insurance findInsuranceById(Long id) {
        return insuranceRepository.findInsuranceById(id).orElseThrow(() -> new InsuranceNotFoundException("Insurance by id " + id + "was not found."));
    }

    public void deleteInsurance(Long id) { insuranceRepository.deleteInsuranceById(id); }
}
