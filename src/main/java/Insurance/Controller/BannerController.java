package Insurance.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import Insurance.Entities.BannerDTO;
import Insurance.Entities.InsurancePackageDTO;

@Controller
@RequestMapping("/admin")
public class BannerController {
	@InitBinder
	public void initBinder(WebDataBinder date) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd");
		date.registerCustomEditor(Date.class, new CustomDateEditor(sf, true));
	}
	
	@RequestMapping("/listBanners")
	public String listPackages(Model model) {
		Client client = Client.create();
		Gson son = new Gson();
		WebResource webResource = client
				.resource("http://localhost:8080/ProjectSem2_Insurance/rest/banner-service/getAllBanner");
		String data = webResource.get(String.class);
		GenericType<List<BannerDTO>> listType = new GenericType<List<BannerDTO>>() {
		};
		List<BannerDTO> listBanners = son.fromJson(data, listType.getType());
		model.addAttribute("listBanners", listBanners);
		return "admin/banner/listBanner";
	}
	
	@RequestMapping("/initInsertBanner")
	public String initInsertBanner(@ModelAttribute("banner") BannerDTO banner, Model model) {

		return "admin/banner/insertBanner";
	}
	
	@RequestMapping("/initUpdateBanner")
	public String initUpdateBanner(@RequestParam("idBanner")Integer idBanner, Model model) {
		Client client = Client.create();
		Gson son = new Gson();
		WebResource webResource = client
				.resource("http://localhost:8080/ProjectSem2_Insurance/rest/banner-service/getBannerById/" + idBanner);
		String data = webResource.get(String.class);
		BannerDTO banner = son.fromJson(data, BannerDTO.class);
		model.addAttribute("banner", banner);
		return "admin/banner/updateBanner";
	}
	@RequestMapping("/updateBanner")
	public String updatePackage(@ModelAttribute("banner") InsurancePackageDTO insurancePackage,BindingResult bindingResult,
			@RequestParam("imgB") MultipartFile multi, HttpServletRequest request, Model model) {
		Gson son = new Gson();
		String path = request.getServletContext().getRealPath("Resources/image_Banner");
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
		insurancePackage.setImagePackage(multi.getOriginalFilename());
		String data = son.toJson(insurancePackage);
		Client client = Client.create();
		WebResource webResource = client
				.resource("http://localhost:8080/ProjectSem2_Insurance/rest/banner-service/updateBanner");
		ClientResponse clientResponse = webResource.type("application/json").post(ClientResponse.class, data);
		String result = clientResponse.getEntity(String.class);
		Boolean bl = son.fromJson(result, Boolean.class);
		if (bl) {
			model.addAttribute("messenger", "Update True!");
			return "redirect:/listBanners";
		} else {
			model.addAttribute("messenger", "Update False!");
			return "admin/banner/updateBanner";
		}
	}
	@RequestMapping("/insertBanner")
	public String insertBanner(@ModelAttribute("banner")BannerDTO bannerDTO, BindingResult bindingResult,
			@RequestParam("imgB") MultipartFile multi, HttpServletRequest request,Model model) {
		Gson son = new Gson();
		String path = request.getServletContext().getRealPath("Resources/image_Banner");
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
		bannerDTO.setImgBanner(multi.getOriginalFilename());
		String data = son.toJson(bannerDTO);
		Client client = Client.create();
		WebResource webResource = client
				.resource("http://localhost:8080/ProjectSem2_Insurance/rest/banner-service/insertBanner");
		ClientResponse clientResponse = webResource.type("application/json").post(ClientResponse.class, data);
		String result = clientResponse.getEntity(String.class);
		Boolean bl = son.fromJson(result, Boolean.class);
		if (bl) {
			return "redirect:listBanners";
		} else {
			model.addAttribute("error", "Insert False!");
			return "admin/banner/insertBanner";
		}
	}
	
	@RequestMapping("/deleteBanner")
	public String deleteBanner(@RequestParam("idBanner")Integer idBanner,Model model) {
		Gson son = new Gson();
		Client client = Client.create();
		WebResource webResource = client
				.resource("http://localhost:8080/ProjectSem2_Insurance/rest/banner-service/deleteBanenr/" + idBanner);
		String data = webResource.type("application/json").post(String.class);
		Boolean bl = son.fromJson(data, Boolean.class);
		if (bl) {
			model.addAttribute("messenger", "Delete True!");
		} else {
			model.addAttribute("messenger", "Delete False!");
		}
		return "redirect:listBanners";
	}
}
