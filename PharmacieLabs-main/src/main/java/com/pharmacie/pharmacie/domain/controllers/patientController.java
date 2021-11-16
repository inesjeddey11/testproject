package com.pharmacie.pharmacie.domain.controllers;
import java.util.List;

import com.pharmacie.pharmacie.domain.entities.patient;
import com.pharmacie.pharmacie.domain.services.patientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class patientController {

    @Autowired
    private final patientService pService;

    public patientController(patientService ps) {
        this.pService = ps;
    }
    
    @GetMapping("/api/v1/patient/showAll")
    public List<patient> showAll() {
        return pService.getPatientAll();
    }

    @PostMapping("/api/v1/patient/register")
    public void registerPatient(@RequestBody patient p) {
        pService.addNewPatient(p);
    }

    @DeleteMapping("/api/v1/patient/delete")
    public void deletePatient(@RequestBody int id) {
        pService.deletePatient(id);
    }

    @RequestMapping(value = "/addPatient" , method = RequestMethod.GET)
    public ModelAndView patientForm() {
        return new ModelAndView("addPatient", "pat", new patient());
    }

    @RequestMapping(value = "/addPatient" , method = RequestMethod.POST)
    public void processRegister(@ModelAttribute("pat") patient pat) {
        pService.addNewPatient(pat);
    }


}
