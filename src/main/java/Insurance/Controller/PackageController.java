package Insurance.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.PathParam;
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
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.org.apache.regexp.internal.recompile;

import Insurance.Entities.DetailPackageDTO;
import Insurance.Entities.InsurancePackageDTO;

@Controller
@RequestMapping("/admin")
public class PackageController {
	@InitBinder
	public void initBinder(WebDataBinder date) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd");
		date.registerCustomEditor(Date.class, new CustomDateEditor(sf, true));
	}
	
	@RequestMapping("/listPackages")
	public String listPackages(Model model) {
		Client client = Client.create();
		Gson son = new Gson();
		WebResource webResource = client
				.resource("http://localhost:8080/ProjectSem2_Insurance/rest/package-service/getAllPackage");
		String data = webResource.get(String.class);
		GenericType<List<InsurancePackageDTO>> listType = new GenericType<List<InsurancePackageDTO>>() {
		};
		List<InsurancePackageDTO> listPackages = son.fromJson(data, listType.getType());
		
		WebResource webResource2 = client.resource("http://localhost:8080/ProjectSem2_Insurance/rest/detailpack-service/getAllDetailPackage");
		String data2 = webResource2.get(String.class);
		GenericType<List<DetailPackageDTO>> listType2 = new GenericType<List<DetailPackageDTO>>() {
		};
		List<DetailPackageDTO> dPack = son.fromJson(data2, listType2.getType());
		model.addAttribute("dPack", dPack);
		model.addAttribute("listPackages", listPackages);
		return "admin/package/listPackage";
	}
	
	@RequestMapping("/initUpdatePackage")
	public String initUpdatePackage(@RequestParam("idPackage")Integer idPackage, Model model) {
		Client client = Client.create();
		Gson son = new Gson();
		WebResource webResource = client
				.resource("http://localhost:8080/ProjectSem2_Insurance/rest/package-service/getPackageById/" + idPackage);
		String data = webResource.get(String.class);
		InsurancePackageDTO pack = son.fromJson(data, InsurancePackageDTO.class);
		model.addAttribute("pack", pack);
		return "admin/package/updatePackage";
	}
	
	@RequestMapping("/updatePackage")
	public String updatePackage(@ModelAttribute("pack") InsurancePackageDTO insurancePackage,BindingResult bindingResult,
			@RequestParam("image") MultipartFile multi, HttpServletRequest request, Model model) {
		Gson son = new Gson();
		String path = request.getServletContext().getRealPath("Resources/image_Package");
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
		String nameimg = multi.getOriginalFilename();
		if(nameimg.length()==0) {
        	insurancePackage.setImagePackage(insurancePackage.getImagePackage());
        }else {
        	insurancePackage.setImagePackage(nameimg);
        }
		insurancePackage.setImagePackage(multi.getOriginalFilename());
		String data = son.toJson(insurancePackage);
		Client client = Client.create();
		WebResource webResource = client
				.resource("http://localhost:8080/ProjectSem2_Insurance/rest/package-service/updatePackage");
		ClientResponse clientResponse = webResource.type("application/json").post(ClientResponse.class, data);
		String result = clientResponse.getEntity(String.class);
		Boolean bl = son.fromJson(result, Boolean.class);
		if (bl) {
			model.addAttribute("messenger", "Update True!");
			return "redirect:listPackages";
		} else {
			model.addAttribute("messenger", "Update False!");
			return "admin/package/updatePackage";
		}
	}
	
	@RequestMapping("/initInsertPackage")
	public String initInsertPackage(@ModelAttribute("package") InsurancePackageDTO insurancePackage, Model model) {

		return "admin/package/insertPackage";
	}
	
	@RequestMapping("/insertPackage")
	public String insertPackage(@ModelAttribute("package")InsurancePackageDTO packageDTO, BindingResult bindingResult,
			@RequestParam("image") MultipartFile multi, HttpServletRequest request,Model model) {

        
		Gson son = new Gson();
		String path = request.getServletContext().getRealPath("Resources/image_Package");
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
		packageDTO.setImagePackage(multi.getOriginalFilename());
		String data = son.toJson(packageDTO);
		Client client = Client.create();
		WebResource webResource = client
				.resource("http://localhost:8080/ProjectSem2_Insurance/rest/package-service/insertPackage");
		ClientResponse clientResponse = webResource.type("application/json").post(ClientResponse.class, data);
		String result = clientResponse.getEntity(String.class);
		Boolean bl = son.fromJson(result, Boolean.class);
		if (bl) {
			return "redirect:listPackages";
		} else {
			model.addAttribute("error", "Insert False!");
			return "admin/package/insertPackage";
		}
	}
	
	@RequestMapping("/deletePackage")
	public String deletePackage(@RequestParam("idPackage")Integer idPackage,Model model) {
		Gson son = new Gson();
		Client client = Client.create();
		WebResource webResource = client
				.resource("http://localhost:8080/ProjectSem2_Insurance/rest/package-service/deletePackage/" + idPackage);
		String data = webResource.type("application/json").post(String.class);
		Boolean bl = son.fromJson(data, Boolean.class);
		if (bl) {
			model.addAttribute("messenger", "Delete True!");
		} else {
			model.addAttribute("messenger", "Delete False!");
		}
		return "redirect:listPackages";
	}
}
