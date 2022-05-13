package Insurance.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

@Controller
public class HomeController {
	@InitBinder
	public void initBinder(WebDataBinder date) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		date.registerCustomEditor(Date.class, new CustomDateEditor(sf, true));
	}

	@RequestMapping(value = { "/", "/home" })
	public String home(Model model) {
		return "customer/index";
	}
	
	@RequestMapping("/packages")
	public String packages(Model model) {
		Client client = Client.create();
		Gson son = new Gson();
		WebResource webResource = client
				.resource("http://localhost:8080/ProjectSem2_Insurance/rest/package-service/getAllPackage");
		String data = webResource.get(String.class);
		GenericType<List<InsurancePackageDTO>> listType = new GenericType<List<InsurancePackageDTO>>() {
		};
		List<InsurancePackageDTO> listPackages = son.fromJson(data, listType.getType());
		model.addAttribute("listPackages", listPackages);
		return "customer/packages";
	}
	
	
}
