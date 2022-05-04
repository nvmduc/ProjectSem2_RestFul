package Insurance.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
		model.addAttribute("listPackages", listPackages);
		return "admin/package/listPackage";
	}

	@RequestMapping("/initInsertPackage")
	public String initInsertPackage(@ModelAttribute("package") InsurancePackageDTO packageDTO, Model model) {
			
		return "admin/package/insertPackage";
	}
	@RequestMapping("/insertPackage")
	public String insertPackage(InsurancePackageDTO packageDTO, BindingResult bindingResult,
			@RequestParam("image") MultipartFile multi, HttpServletRequest request,Model model) {
		Gson son = new Gson();
		String path = request.getServletContext().getRealPath("Resources/images_Package");
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
		ClientResponse clientResponse = webResource.accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, data);
		String result = clientResponse.getEntity(String.class);
		Boolean bl = son.fromJson(result, Boolean.class);
		if (bl) {
			return "redirect:listPackages";
		} else {
			model.addAttribute("error", "Insert False!");
			return "admin/package/insertPackage";
		}
	}
}
