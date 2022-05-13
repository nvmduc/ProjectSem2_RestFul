package Insurance.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Path;

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
		InformationCarDTO car = new InformationCarDTO();
		Integer id = car.getIdAccount();
		GenericType<List<InformationCarDTO>> listType = new GenericType<List<InformationCarDTO>>() {
		};
		List<InformationCarDTO> listCars = son.fromJson(data, listType.getType());
		model.addAttribute("listCars", listCars);
		return "admin/inforCar/listCar";
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
		String result = clientResponse.getEntity(String.class);
		Boolean bl = son.fromJson(result, Boolean.class);
		if (bl) {
			return "redirect:home";
		} else {
			model.addAttribute("messenger", "Insert False!");
			return "customer/car/insertCar";
		}
	}
	
}
