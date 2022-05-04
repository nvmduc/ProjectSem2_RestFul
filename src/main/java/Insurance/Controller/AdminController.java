package Insurance.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import Insurance.Entities.AccountDTO;
import Insurance.Entities.InsurancePackageDTO;
import Insurance.Entities.RoleDTO;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@RequestMapping("/dashboard")
	public String dashboard() {
		return "admin/index";
	}

	@InitBinder
	public void initBinder(WebDataBinder date) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd");
		date.registerCustomEditor(Date.class, new CustomDateEditor(sf, true));
	}
	
	

}
