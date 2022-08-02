package Insurance.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import Insurance.Entities.AccountDTO;
import Insurance.Entities.InsurancePackageDTO;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@RequestMapping({"/","dashboard"})
	public String dashboard() {
		return "admin/index";
	}

	@RequestMapping({"/loginAdmin"})
	public String loginAdmin(Model model) {
		AccountDTO user = new AccountDTO();
		model.addAttribute("user",user);
		return "admin/loginAdmin";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder date) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd");
		date.registerCustomEditor(Date.class, new CustomDateEditor(sf, true));
	}

	@RequestMapping("/postloginAdmin")
	public String postloginAdmin(@ModelAttribute("accLogin") AccountDTO acc,InsurancePackageDTO pack,HttpServletRequest request,Model model) {
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
			if(accDTO.getRole() == 0) {
				if(BCrypt.checkpw(acc.getPassword(),accDTO.getPassword())) {
					accountSession = accDTO;
					checklog = true;
				}
			}
		}
		HttpSession session = request.getSession();
		if(checklog) {
			session.setAttribute("role", accountSession.getRole());
			session.setAttribute("user", accountSession);
			return "redirect:dashboard";
		}else {
			session.setAttribute("messenge","Thông tin tài khoản hoặc mật khẩu không chính xác");
			return "redirect:loginAdmin";
		}
	}
	
	@RequestMapping("/logoutAdmin")
	public String logout(Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "redirect:loginAdmin";
	}
	
	@RequestMapping("profileAccount")
	public String profileAccount() {
		
		return "";
	}
	
	@RequestMapping("/listAccount")
	public String listAccount(Model model) {
		Client client = Client.create();
		Gson son = new Gson();
		WebResource webResource = client
				.resource("http://localhost:8080/ProjectSem2_Insurance/rest/account-service/getAllAccount");
		String data = webResource.get(String.class);
		GenericType<List<AccountDTO>> listType = new GenericType<List<AccountDTO>>() {
		};
		List<AccountDTO> listAccounts = son.fromJson(data, listType.getType());
		model.addAttribute("listAccounts", listAccounts);
		return "admin/account/listAccount";
	}
	
	@RequestMapping("/deleteAccount")
	public String deleteAccount(@RequestParam("idAccount")Integer idAccount,Model model) {
		Gson son = new Gson();
		Client client = Client.create();
		WebResource webResource = client
				.resource("http://localhost:8080/ProjectSem2_Insurance/rest/account-service/deleteAccount/" + idAccount);
		String data = webResource.type("application/json").post(String.class);
		Boolean bl = son.fromJson(data, Boolean.class);
		if (bl) {
			model.addAttribute("messenger", "Delete True!");
		} else {
			model.addAttribute("messenger", "Delete False!");
		}
		return "redirect:listAccount";
	}

}
