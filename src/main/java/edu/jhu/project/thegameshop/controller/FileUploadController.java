package edu.jhu.project.thegameshop.controller;

import java.util.ArrayList;
import java.util.List;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import edu.jhu.project.thegameshop.dto.FileUploadForm;

@Controller
public class FileUploadController {

	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String displayForm(Model m) {
		m.addAttribute("uploadForm", new FileUploadForm());
		return "file_upload_form";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(
			@ModelAttribute("uploadForm") FileUploadForm uploadForm,
					Model map) {
		
		MultipartFile file = uploadForm.getFile();

		return "hello";
	}
}
