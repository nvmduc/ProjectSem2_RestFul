package Insurance.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.PathParam;

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
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import Insurance.Entities.DetailPackageDTO;
import Insurance.Entities.InsurancePackageDTO;

@Controller
public class DetailPackageController {
	@InitBinder
	public void initBinder(WebDataBinder date) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd");
		date.registerCustomEditor(Date.class, new CustomDateEditor(sf, true));
	}
	
	@RequestMapping("/admin/detailPackageById")
	public String detailPackageById(Model model,@RequestParam("idPackage")Integer idPackage) {
		Client client = Client.create();
		Gson son = new Gson();
		WebResource webResource = client.resource("http://localhost:8080/ProjectSem2_Insurance/rest/detailpack-service/getPackageById/"+idPackage);
		String data = webResource.get(String.class);
		DetailPackageDTO dPack = son.fromJson(data, DetailPackageDTO.class);
		WebResource webResource2 = client
				.resource("http://localhost:8080/ProjectSem2_Insurance/rest/package-service/getAllPackage");
		String data2 = webResource2.get(String.class);
		GenericType<List<InsurancePackageDTO>> listType = new GenericType<List<InsurancePackageDTO>>() {
		};
		List<InsurancePackageDTO> listPackages = son.fromJson(data2, listType.getType());
		model.addAttribute("listPackages", listPackages);
		model.addAttribute("dPack", dPack);
		return "admin/detailPackage/showDetailPackage";
	}
	
	@RequestMapping("/admin/initInsertDetailPackage")
	public String initInsertDetailPackage(@ModelAttribute("detailPackage") DetailPackageDTO detailPackDTO, Model model,@PathParam("idPackage")Integer idPackage) {
		Client client = Client.create();
		Gson son = new Gson();
		WebResource webResource = client
				.resource("http://localhost:8080/ProjectSem2_Insurance/rest/package-service/getPackageById/" + idPackage);
		String data = webResource.get(String.class);
		InsurancePackageDTO pack = son.fromJson(data, InsurancePackageDTO.class);
		model.addAttribute("pack", pack);
		return "admin/detailPackage/insertDetailPackage";
	}
	
	@RequestMapping("/admin/insertDetailPackage")
	public String insertDetailPackage(@ModelAttribute("detailPackage")DetailPackageDTO detailPackageDTO,Model model,@PathParam("idPackage")Integer idPackage) {
		Gson son = new Gson();
		String data = son.toJson(detailPackageDTO);
		Client client = Client.create();
		WebResource webResource = client
				.resource("http://localhost:8080/ProjectSem2_Insurance/rest/detailpack-service/insertDetailPackage");
		ClientResponse clientResponse = webResource.type("application/json").post(ClientResponse.class, data);
		String result = clientResponse.getEntity(String.class);
		Boolean bl = son.fromJson(result, Boolean.class);
		if (bl) {
			return "redirect:detailPackageById";
		} else {
			model.addAttribute("error", "Insert False!");
			return "admin/package/insertDetailPackage";
		}
	}
	
	@RequestMapping("/admin/detailPackageByIdInHome")
	public String detailPackageByIdInHome(Model model,@RequestParam("idPackage")Integer idPackage) {
		Client client = Client.create();
		Gson son = new Gson();
		WebResource webResource = client.resource("http://localhost:8080/ProjectSem2_Insurance/rest/detailpack-service/getPackageById/"+idPackage);
		String data = webResource.get(String.class);
		DetailPackageDTO dPack = son.fromJson(data, DetailPackageDTO.class);
		WebResource webResource2 = client
				.resource("http://localhost:8080/ProjectSem2_Insurance/rest/package-service/getAllPackage");
		String data2 = webResource2.get(String.class);
		GenericType<List<InsurancePackageDTO>> listType = new GenericType<List<InsurancePackageDTO>>() {
		};
		List<InsurancePackageDTO> listPackages = son.fromJson(data2, listType.getType());
		model.addAttribute("listPackages", listPackages);
		model.addAttribute("dPack", dPack);
		return "customer/detailPackage";
	}
}
