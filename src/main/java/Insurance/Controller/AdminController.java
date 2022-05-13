package Insurance.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import Insurance.Entities.AccountDTO;

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

}
