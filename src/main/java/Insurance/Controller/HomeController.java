package Insurance.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import Insurance.Entities.AccountDTO;
import Insurance.Entities.InformationCarDTO;

@Controller
public class HomeController {
	@RequestMapping(value = { "/", "/home" })
	public String home(Model model) {
		return "customer/index";
	}

	@RequestMapping("/login")
	public String login(Model model) {
		AccountDTO acc = new AccountDTO();
		model.addAttribute("acc",acc);
		return "customer/login";
	}

	@RequestMapping("/register")
	public String register(Model model,@ModelAttribute("acc") AccountDTO accDTO,
			@RequestParam("avatar") MultipartFile multi, HttpServletRequest request, BindingResult bindingResult) {
		Gson son = new Gson();
		String path = request.getServletContext().getRealPath("Resources/images_Account");
		File f = new File(path);
		
		File dest = new File(f.getAbsoluteFile() + "/" + multi.getOriginalFilename());
		if (!dest.exists()) {
			try {
				Files.write(dest.toPath(), multi.getBytes(), StandardOpenOption.CREATE);
			} catch (IOException er) {
				// TODO Auto-generated catch block
				er.printStackTrace();
			}
		}
		accDTO.setAvatar(multi.getOriginalFilename());
		String data = son.toJson(accDTO);
		Client client = Client.create();
		WebResource webResource = client
				.resource("http://localhost:8080/ProjectSem2_Insurance/rest/insurance-service/insertAccount");
		ClientResponse clientResponse = webResource.accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, data);
		String result = clientResponse.getEntity(String.class);
		Boolean bl = son.fromJson(result, Boolean.class);
		if (bl) {
			return "customer/index";
		} else {
			model.addAttribute("error","Insert False!");
			return "customer/register";
		}
	}
	
	@RequestMapping("/insertCar")
	public String insertCar(Model model,@ModelAttribute("car") InformationCarDTO car) {
		return "customer/insertCar";
	}
}
