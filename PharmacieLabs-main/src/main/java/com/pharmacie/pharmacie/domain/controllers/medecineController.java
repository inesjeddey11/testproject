package com.pharmacie.pharmacie.domain.controllers;



import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pharmacie.pharmacie.domain.entities.medecine;
import com.pharmacie.pharmacie.domain.repositories.MedecineRepository;
import com.pharmacie.pharmacie.domain.services.medecineService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping("/medicine")
public class medecineController {

	private static final String RedirectAttributes = null;
	@Autowired
	private final medecineService mService;
	
	public medecineController(medecineService mService){
		this.mService = mService;
	}
	@GetMapping("/showAll")
	public String showAll(Model model){
		model.addAttribute("medicines",mService.getMedecineAll());
		for (medecine medecine : mService.getMedecineAll()) {
			System.out.println("$$$$$$$"+medecine.getName()+"$$$$$$$");
		}
		return "backend/medicines";
	}
	
	
	@GetMapping("/list")
	public String show(Model model){
		model.addAttribute("medicines",mService.getMedecineAll());
		for (medecine medecine : mService.getMedecineAll()) {
			System.out.println("$$$$$$$"+medecine.getName()+"$$$$$$$");
		}
		return "frontend/med";
	}
	
	@GetMapping("/addMedicine")
	public String addMedicine(Model model){
		medecine medecine = new medecine();
		model.addAttribute("medicine",medecine);
		return "backend/addMedicine";
	}
	
	private MedecineRepository medRepo;
	@PostMapping("/registerMedicine")
	public String registerMedicine(@ModelAttribute("medicine") medecine medicine,@RequestParam ("file") MultipartFile file,
			 RedirectAttributes redirAttrs ) {
		System.out.println("hello");
		System.out.println("$$$$$$$$"+medicine.getName());
		System.out.println("$$$$$$$$"+medicine.getPrice());
		System.out.println("$$$$$$$$"+medicine.isOkayForPregnancy());
		//medicine.ordonnance(true);
		String FileName = org.springframework.util.StringUtils.cleanPath(file.getOriginalFilename());
    	if(FileName.contains("..")) {
    		System.out.println("not a proper file ");
    	}
    	try {
    		medicine.setImg(Base64.getEncoder().encodeToString(file.getBytes()));
			System.out.println("cv");
		} catch (IOException e) {
			System.out.println("dowi");
			e.printStackTrace();
		}
		mService.addMedecine(medicine);
        System.out.println("hello2");
        return "redirect:/medicine/showAll";
    }
	
	
	@GetMapping("/delMedicine/{id}")
	public String deleteMedecinet(@PathVariable("id") Long id) {
	    mService.deleteMedecine(id);
		return "redirect:/medicine/showAll";
	}
	
	@GetMapping("/updMedicine/{id}")
	public String UpdMedicine(@PathVariable("id") int id, Model model) {
		medecine med = mService.getMedecine(id);
		model.addAttribute("medicine", med);
	    return "backend/updMedicine";
	}
	@PostMapping("/updMedicine/{id}")
	public String EditMedicine( Model model ,@PathVariable("id") long id,
			@RequestParam ("name") String name,
			@RequestParam ("price") double price , 
			@RequestParam ("okayForPregnancy") boolean okayForPregnancy , 
			@RequestParam("ordonnance") boolean ordonnance,
			@RequestParam("file") MultipartFile file  ) {
		medecine medecine =new medecine();
		medecine.setName(name);
		medecine.setPrice(price);;
		medecine.setOkayForPregnancy(okayForPregnancy);
		medecine.setOrdonnance(ordonnance);
		 
		 String FileName = org.springframework.util.StringUtils.cleanPath(file.getOriginalFilename());
	    	if(FileName.contains("..")) {
	    		System.out.println("not a proper file ");
	    	}
	    	try {
	    		if(!FileName.isEmpty())
	    			medecine.setImg(Base64.getEncoder().encodeToString(file.getBytes()));
				else 
					medecine.setImg(mService.getMedecine(id).getImg());
				
				System.out.println("cv");
			} catch (IOException e) {
				System.out.println("dowiw");
				e.printStackTrace();
			}
	    	mService.modifyMedicine(id, medecine);
		 return "redirect:/medicine/showAll"; 
	}
	}

