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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import Insurance.Entities.AccountDTO;

@Controller
public class AccountController {
	@InitBinder
	public void initBinder(WebDataBinder date) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		date.registerCustomEditor(Date.class, new CustomDateEditor(sf, true));
	}

	@RequestMapping("/login")
	public String login(Model model) {
		AccountDTO acc = new AccountDTO();
		model.addAttribute("acc", acc);
		return "customer/login";
	}

	@RequestMapping("/postlogin")
	public String postlogin(@ModelAttribute("accLogin") AccountDTO acc,HttpServletRequest request,Model model) {
		Client client = Client.create();
		Gson son = new Gson();
		WebResource webResource = client
				.resource("http://localhost:8080/ProjectSem2_Insurance/rest/account-service/getEmailPassword/"+acc.getEmail());
		String data = webResource.get(String.class);
		GenericType<List<AccountDTO>> listType = new GenericType<List<AccountDTO>>() {
		};
		AccountDTO accountSession = new AccountDTO();
		Boolean checklog = false;
		List<AccountDTO> listAcc = son.fromJson(data, listType.getType());
		for (AccountDTO accDTO : listAcc) {
			if(accDTO.getRole() == 1) {
				if(BCrypt.checkpw(acc.getPassword(),accDTO.getPassword())) {
					accountSession = accDTO;
					checklog = true;
				}
			}
		}
		HttpSession session = request.getSession();
		if(checklog) {
			session.setAttribute("role", accountSession.getRole());
			session.setAttribute("user",accountSession);
			return "redirect:home";
		}else {
			return "redirect:login";
		}
	}

	@RequestMapping("/initregister")
	public String initregister(@ModelAttribute("acc")AccountDTO accDTO, Model model) {

		return "customer/register";
	}

	@RequestMapping("/logout")
	public String logout(Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "redirect:home";
	}
	@RequestMapping("/insertAccount")
	public String register(@Valid Model model, @ModelAttribute("acc") AccountDTO accDTO,
			@RequestParam("imgavt") MultipartFile multi, HttpServletRequest request, BindingResult bindingResult) {
		Gson son = new Gson();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(accDTO.getPassword());
		accDTO.setPassword(hashedPassword);
		accDTO.setStatusAccount(1);
		accDTO.setRole(1);
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
				.resource("http://localhost:8080/ProjectSem2_Insurance/rest/account-service/insertAccount");
		ClientResponse clientResponse = webResource.type("application/json").post(ClientResponse.class, data);
		String result = clientResponse.getEntity(String.class);
		Boolean bl = son.fromJson(result, Boolean.class);
		if (bl) {
			return "customer/index";
		} else {
			model.addAttribute("error", "Insert False!");
			return "customer/register";
		}
	}

}
