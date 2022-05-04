package Insurance.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

import Insurance.Entities.RoleDTO;

@Controller
@RequestMapping("/admin")
public class RoleController {
	@InitBinder
	public void initBinder(WebDataBinder date) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd");
		date.registerCustomEditor(Date.class, new CustomDateEditor(sf, true));
	}

	@RequestMapping("/listRoles")
	public String listRoles(Model model) {
		Client client = Client.create();
		Gson son = new Gson();
		WebResource webResource = client
				.resource("http://localhost:8080/ProjectSem2_Insurance/rest/role-service/getAllRole");
		String data = webResource.get(String.class);
		GenericType<List<RoleDTO>> listType = new GenericType<List<RoleDTO>>() {
		};
		List<RoleDTO> listRoles = son.fromJson(data, listType.getType());
		model.addAttribute("listRoles", listRoles);
		return "admin/role/listRole";
	}

	@RequestMapping("/insertRole")
	public String insertRole(Model model, @ModelAttribute("role") RoleDTO roleDTO, BindingResult bindingResult) {
		Gson son = new Gson();
		String data = son.toJson(roleDTO);
		Client client = Client.create();
		WebResource webResource = client
				.resource("http://localhost:8080/ProjectSem2_Insurance/rest/role-service/insertRole");
		ClientResponse clientResponse = webResource.type("application/json").post(ClientResponse.class, data);
		String result = clientResponse.getEntity(String.class);
		Boolean bl = son.fromJson(result, Boolean.class);

		if (bl) {
			return "redirect:listRoles";
		} else {
			model.addAttribute("error", "Insert False!");
			return "admin/role/createRole";
		}
	}

	@RequestMapping("initUpdateRole")
	public String initUpdateRole(Model model, @RequestParam("idRole") Integer idRole) {
		Client client = Client.create();
		Gson son = new Gson();
		WebResource webResource = client
				.resource("http://localhost:8080/ProjectSem2_Insurance/rest/role-service/getRoleById/" + idRole);
		String data = webResource.get(String.class);
		RoleDTO role = son.fromJson(data, RoleDTO.class);
		model.addAttribute("role", role);
		return "admin/role/updateRole";
	}

	@RequestMapping("/updateRole")
	public String updateRole(Model model, @ModelAttribute("updateRole") RoleDTO roleDTO) {
		Gson son = new Gson();
		String data = son.toJson(roleDTO);
		Client client = Client.create();
		WebResource webResource = client
				.resource("http://localhost:8080/ProjectSem2_Insurance/rest/role-service/updateRole");
		ClientResponse clientResponse = webResource.accept(MediaType.APPLICATION_JSON).put(ClientResponse.class, data);
		String result = clientResponse.getEntity(String.class);
		Boolean bl = son.fromJson(result, Boolean.class);

		if (bl) {
			model.addAttribute("success", "Update True!");
			return "redirect:listRoles";
		} else {
			model.addAttribute("error", "Update False!");
			return "admin/role/updateRole";
		}

	}

	@RequestMapping("/deleteRole")
	public String deleteRole(Model model, @RequestParam("idRole") Integer idRole) {
		Gson son = new Gson();
		Client client = Client.create();
		WebResource webResource = client
				.resource("http://localhost:8080/ProjectSem2_Insurance/rest/role-service/deleteRole/" + idRole);
		String data = webResource.type(MediaType.APPLICATION_JSON).delete(String.class);
		Boolean bl = son.fromJson(data, Boolean.class);
		if (bl) {
			model.addAttribute("success", "Delete True!");
		} else {
			model.addAttribute("error", "Delete False!");
		}
		return "redirect:listRoles";

	}
}
