package com.patient.service.api.sevice;

import com.patient.service.api.entity.Patient;
import com.patient.service.api.rpository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Long id, Patient updatedPatient) {
        Optional<Patient> existingPatientOptional = patientRepository.findById(id);
        if (existingPatientOptional.isPresent()) {
            Patient existingPatient = existingPatientOptional.get();
            existingPatient.setName(updatedPatient.getName());
            existingPatient.setAge(updatedPatient.getAge());
            return patientRepository.save(existingPatient);
        } else {
            throw new IllegalArgumentException("Patient not found with ID: " + id);
        }
    }

    public void deletePatient(Long id) {

        System.out.println("balu");

        patientRepository.deleteById(id);
    }
}

