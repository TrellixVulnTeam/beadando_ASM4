package murraco.controller;

import murraco.model.Insurance;
import murraco.service.InsuranceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {
    private final InsuranceService insuranceService;

    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public ResponseEntity<List<Insurance>> getAllInsurances() {
        List<Insurance> tasks = insuranceService.findAllInsurances();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    @GetMapping("/find/{id}")
    public ResponseEntity<Insurance> getTaskById(@PathVariable("id") Long id) {
        Insurance insurance = insuranceService.findInsuranceById(id);
        return new ResponseEntity<>(insurance, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Insurance> addInsurance(@RequestBody Insurance insurance) {
        Insurance newInsurance = insuranceService.addInsurance(insurance);
        return new ResponseEntity<>(newInsurance, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update")
    public  ResponseEntity<Insurance> updateInsurance(@RequestBody Insurance insurance) {
        Insurance updateInsurance = insuranceService.updateInsurance(insurance);
        return new ResponseEntity<>(updateInsurance, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<?> deleteInsurance(@PathVariable("id") Long id) {
        insuranceService.deleteInsurance(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
