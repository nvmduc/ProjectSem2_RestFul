package Insurance.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import Insurance.Entities.AccountDTO;
import Insurance.Entities.InformationCarDTO;
import Insurance.Entities.InsurancePackageDTO;

@Controller
public class InformationCarController {
	@InitBinder
	public void initBinder(WebDataBinder date) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd");
		date.registerCustomEditor(Date.class, new CustomDateEditor(sf, true));
	}
	
	@RequestMapping("/admin/listCars")
	public String listCars(Model model) {
		Client client = Client.create();
		Gson son = new Gson();
		WebResource webResource = client
				.resource("http://localhost:8080/ProjectSem2_Insurance/rest/inforcar-service/getAllInforCar");
		String data = webResource.get(String.class);
		GenericType<List<InformationCarDTO>> listType = new GenericType<List<InformationCarDTO>>() {
		};
		List<InformationCarDTO> listCars = son.fromJson(data, listType.getType());
		
		WebResource webResource2 = client
				.resource("http://localhost:8080/ProjectSem2_Insurance/rest/account-service/getAllAccount");
		String data2 = webResource2.get(String.class);
		GenericType<List<AccountDTO>> listType2 = new GenericType<List<AccountDTO>>() {
		};
		List<AccountDTO> listAccounts = son.fromJson(data2, listType2.getType());
		model.addAttribute("listAccounts", listAccounts);
		model.addAttribute("listCars", listCars);
		return "admin/inforCar/listCar";
	}
	
	@RequestMapping("/showCars")
	public String showCars(Model model, @PathParam("idAccount")Integer idAccount) {
		Client client = Client.create();
		Gson son = new Gson();
		WebResource webResource = client
				.resource("http://localhost:8080/ProjectSem2_Insurance/rest/inforcar-service/getCarByAccountId/"+idAccount);
		String data = webResource.get(String.class);
		GenericType<List<InformationCarDTO>> listType = new GenericType<List<InformationCarDTO>>() {
		};
		List<InformationCarDTO> listCars = son.fromJson(data, listType.getType());
		model.addAttribute("listCars", listCars);
		return "customer/car/showCarInAccount";
	}
	
	@RequestMapping("/initInsertCar")
	public String initInsertPackage(@ModelAttribute("car")InformationCarDTO inforCar, Model model) {
		
		return "customer/car/insertCar";
	}
	
	@RequestMapping("/insertCar")
	public String insertCar(Model model,@ModelAttribute("car")InformationCarDTO inforCar) {
		Gson son = new Gson();
		String data = son.toJson(inforCar);
		Client client = Client.create();
		WebResource webResource = client
				.resource("http://localhost:8080/ProjectSem2_Insurance/rest/inforcar-service/insertCar");
		ClientResponse clientResponse = webResource.type("application/json").post(ClientResponse.class, data);
		inforCar.setStatusInformationCar(1);
		String result = clientResponse.getEntity(String.class);
		Boolean bl = son.fromJson(result, Boolean.class);
		if (bl) {
			return "redirect:home";
		} else {
			model.addAttribute("messenger", "Insert False!");
			return "customer/car/insertCar";
		}
	}
	
	@RequestMapping("deleteCar")
	public String deleteCar(Model model, @PathParam("idInformationCar")Integer idInformationCar) {
		Gson son = new Gson();
		Client client = Client.create();
		WebResource webResource = client
				.resource("http://localhost:8080/ProjectSem2_Insurance/rest/inforcar-service/deleteCar/" + idInformationCar);
		String data = webResource.type("application/json").post(String.class);
		Boolean bl = son.fromJson(data, Boolean.class);
		if (bl) {
			model.addAttribute("messenger", "Delete True!");
		} else {
			model.addAttribute("messenger", "Delete False!");
		}
		return "customer/car/showCarInAccount";
	}
	
}
