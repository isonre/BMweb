package org.lwt.BMweb.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.lwt.BMweb.model.Bbm_info;
import org.lwt.BMweb.model.Place;
import org.lwt.BMweb.model.Professional;
import org.lwt.BMweb.model.Shool;
import org.lwt.BMweb.model.U_info;
import org.lwt.BMweb.model.Nation;
import org.lwt.BMweb.model.Zbm_info;
import org.lwt.BMweb.service.impl.Bbm_infoManager;
import org.lwt.BMweb.service.impl.NationManager;
import org.lwt.BMweb.service.impl.PlaceManager;
import org.lwt.BMweb.service.impl.ProfessionalManager;
import org.lwt.BMweb.service.impl.ShoolManager;
import org.lwt.BMweb.service.impl.U_infoManager;
import org.lwt.BMweb.service.impl.Zbm_infoManager;
import org.lwt.BMweb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/bminfo")
@SessionAttributes("currUser")
public class MainController {

	private PlaceManager placeMgr;
	private NationManager nationMgr;

	private ShoolManager shoolMgr;
	private ProfessionalManager proMgr;

	private U_infoManager uinfoMgr;
	private Zbm_infoManager zinfoMgr;
	private Bbm_infoManager binfoMgr;

	public U_infoManager getUinfoMgr() {
		return uinfoMgr;
	}

	@Autowired
	@Qualifier("uinfoMgr")
	public void setUinfoMgr(U_infoManager uinfoMgr) {
		this.uinfoMgr = uinfoMgr;
	}

	public Zbm_infoManager getZinfoMgr() {
		return zinfoMgr;
	}

	@Autowired
	@Qualifier("zinfoMgr")
	public void setZinfoMgr(Zbm_infoManager zinfoMgr) {
		this.zinfoMgr = zinfoMgr;
	}
	
	public Bbm_infoManager getBinfoMgr() {
		return binfoMgr;
	}

	@Autowired
	@Qualifier("binfoMgr")
	public void setBinfoMgr(Bbm_infoManager binfoMgr) {
		this.binfoMgr = binfoMgr;
	}


	public ProfessionalManager getProMgr() {
		return proMgr;
	}
	
	@Autowired
	@Qualifier("proMgr")
	public void setProMgr(ProfessionalManager proMgr) {
		this.proMgr = proMgr;
	}

	public ShoolManager getShoolMgr() {
		return shoolMgr;
	}

	@Autowired
	@Qualifier("shoolMgr")
	public void setShoolMgr(ShoolManager shoolMgr) {
		this.shoolMgr = shoolMgr;
	}

	public NationManager getNationMgr() {
		return nationMgr;
	}

	@Autowired
	@Qualifier("nationMgr")
	public void setNationMgr(NationManager nationMgr) {
		this.nationMgr = nationMgr;
	}

	public PlaceManager getPlaceMgr() {
		return placeMgr;
	}

	@Autowired
	@Qualifier("placeMgr")
	public void setPlaceMgr(PlaceManager placeMgr) {
		this.placeMgr = placeMgr;
	}

	// ѡ����ר�ƻ��Ǳ���
	@RequestMapping("selectPro")
	public String index(Model model) {
		return "selectPro";
	}

	@RequestMapping("ZuserInfoIdex")
	public String zusrInfo(HttpServletRequest request,Model model) {
		
		U_info u_info = new U_info();

		List<Nation> nations = nationMgr.getNationDao().getAllNation();
		List<Place> places = placeMgr.getPlaceDao().getAllPlace();

		model.addAttribute("nations", nations);
		model.addAttribute("places", places);
		model.addAttribute("u_info", u_info);
		
		if(request.getParameter("msg").equals("1")){
		return "Buser_info";
		}
		else{
		return "Zuser_info";
		}
	}

	// ��ӻ�����Ϣ,ת��ר�Ʊ���ҳ��
	@RequestMapping(value = "/ZbmInfoIdex", method = RequestMethod.POST)
	public String createzbmInfo(@ModelAttribute("currUser") User user,
			HttpServletRequest request, @Valid U_info u_info,
			BindingResult bindingResult, Model model) {
		Integer n_id = Integer.parseInt(request.getParameter("n_id"));
		Integer p_id = Integer.parseInt(request.getParameter("p_id"));
		if (bindingResult.hasErrors()) {
			return "redirect:/bminfo/ZuserInfoIdex?error=2&msg=2";
		} else if (uinfoMgr.testByIdentity(user.getIdentity()) != null) {
			// ���������Ϣ�����ظ��ύ��Ϣ��
			return "redirect:/bminfo/ZuserInfoIdex?error=1&msg=2";
		}
		else{
			uinfoMgr.addU_info(n_id, p_id, u_info);
			model.addAttribute("U_info", u_info);

			Zbm_info zbm_info = new Zbm_info();
			List<Shool> shools = shoolMgr.getShoolDao().getAllShool();
			List<Professional> professionals = proMgr.getProfessionalDao()
					.getAllProfessional();
			model.addAttribute("shools", shools);
			model.addAttribute("professionals", professionals);
			model.addAttribute("zbm_info", zbm_info);

			return "Zbm_info";
		}
		
	}
	
	// ��ӻ�����Ϣ��ת�����Ʊ���ҳ��
	@RequestMapping(value = "/BbmInfoIdex", method = RequestMethod.POST)
	public String createbmInfo(@ModelAttribute("currUser") User user,
			HttpServletRequest request, @Valid U_info u_info,
			BindingResult bindingResult, Model model) {
		Integer n_id = Integer.parseInt(request.getParameter("n_id"));
		Integer p_id = Integer.parseInt(request.getParameter("p_id"));
		if (bindingResult.hasErrors()) {
			return "redirect:/bminfo/ZuserInfoIdex?error=2&msg=1";
		} else if (uinfoMgr.testByIdentity(user.getIdentity()) != null) {
			// ���������Ϣ�����ظ��ύ��Ϣ��
			return "redirect:/bminfo/ZuserInfoIdex?error=1&msg=1";
		}
		else{
			uinfoMgr.addU_info(n_id, p_id, u_info);
			model.addAttribute("U_info", u_info);

			Bbm_info bbm_info = new Bbm_info();
			List<Shool> shools = shoolMgr.getShoolDao().getAllShool();
			List<Professional> professionals = proMgr.getProfessionalDao().getAllProfessional();
			model.addAttribute("shools", shools);
			model.addAttribute("professionals", professionals);
			model.addAttribute("bbm_info", bbm_info);

			return "Bbm_info";
		}

	}

	// ���ר��־Ը��Ϣ
	@RequestMapping(value = "/createZbmFinalInfo", method = RequestMethod.POST)
	public String createzbmfinalInfo(@ModelAttribute("currUser") User user,
			HttpServletRequest request, @Valid Zbm_info zbm_info,
			BindingResult bindingResult, Model model) {
		Integer shool1 = Integer.parseInt(request.getParameter("shool1"));
		Integer shool2 = Integer.parseInt(request.getParameter("shool2"));
		Integer pro1 = Integer.parseInt(request.getParameter("pro1"));
		Integer pro2 = Integer.parseInt(request.getParameter("pro2"));
		Integer pro3 = Integer.parseInt(request.getParameter("pro3"));
		Integer pro4 = Integer.parseInt(request.getParameter("pro4"));
		if (bindingResult.hasErrors() || shool1 == -1 || shool2 == -1
				|| pro1 == -1 || pro2 == -1 || pro3 == -1 || pro4 == -1) {
			List<Shool> shools = shoolMgr.getShoolDao().getAllShool();
			List<Professional> professionals = proMgr.getProfessionalDao()
					.getAllProfessional();
			model.addAttribute("shools", shools);
			model.addAttribute("professionals", professionals);
			if (shool1 == -1 || shool2 == -1 || pro1 == -1 || pro2 == -1
					|| pro3 == -1 || pro4 == -1) {
				model.addAttribute("cateError", "���಻��Ϊ��");
			}
			return "Zbm_info";
		} else if (zinfoMgr.testByIdentity(user.getIdentity()) != null) {
			// ���������Ϣ�����ظ��ύ��Ϣ��
			return "redirect:/bminfo/createZbmFinalInfo?error=1";
		} else {
			Integer zbminfo_Id = zinfoMgr.addZbm_info(shool1, shool2, pro1,
					pro2, pro3, pro4, user.getIdentity(), zbm_info);
			model.addAttribute("currUser", user);
			return "redirect:/bminfo/ZbmFinalInfoView";
		}
	}
	
	// ��ӱ���־Ը��Ϣ
	@RequestMapping(value = "/createBbmFinalInfo", method = RequestMethod.POST)
	public String createbbmfinalInfo(@ModelAttribute("currUser") User user,
			HttpServletRequest request, @Valid Bbm_info bbm_info,
			BindingResult bindingResult, Model model) {
		Integer shool1 = Integer.parseInt(request.getParameter("shool1"));
		Integer pro1 = Integer.parseInt(request.getParameter("pro1"));
		Integer pro2 = Integer.parseInt(request.getParameter("pro2"));
		Integer pro3 = Integer.parseInt(request.getParameter("pro3"));
		Integer pro4 = Integer.parseInt(request.getParameter("pro4"));
		if (bindingResult.hasErrors()) {
			List<Shool> shools = shoolMgr.getShoolDao().getAllShool();
			List<Professional> professionals = proMgr.getProfessionalDao()
					.getAllProfessional();
			model.addAttribute("shools", shools);
			model.addAttribute("professionals", professionals);
			return "Bbm_info";
		} else if (binfoMgr.testByIdentity(user.getIdentity()) != null) {
			// ���������Ϣ�����ظ��ύ��Ϣ��
			return "redirect:/bminfo/createBbmFinalInfo?error=1";
		} else {
			Integer zbminfo_Id = binfoMgr.addBbm_info(shool1, pro1, pro2, pro3, pro4, user.getIdentity(), bbm_info);
			model.addAttribute("currUser", user);
			return "redirect:/bminfo/BbmFinalInfoView";
		}
	}

	// ר�Ʊ�������ҳչʾ
	@RequestMapping("/ZbmFinalInfoView")
	public String ZbmFinalInfoView(Model model) {
		return "ZbmFinalInfoView";
	}
	
	// ���Ʊ�������ҳչʾ
	@RequestMapping("/BbmFinalInfoView")
	public String BbmFinalInfoView(Model model) {
		return "BbmFinalInfoView";
	}

	// ר�Ʊ���������Ϣչʾҳ��
	@RequestMapping(value = "/showZuserInfo/{identity}", method = RequestMethod.GET)
	public String showZuserinfo(@PathVariable String identity,
			HttpServletRequest request, Model model) {
		U_info uinfo = (U_info) uinfoMgr.testByIdentity(identity);
		model.addAttribute("uinfo", uinfo);
		return "showZuserInfo";
	}
	// ���Ʊ���������Ϣչʾҳ��
	@RequestMapping(value = "/showBuserInfo/{identity}", method = RequestMethod.GET)
	public String showBuserinfo(@PathVariable String identity,
			HttpServletRequest request, Model model) {
		U_info uinfo = (U_info) uinfoMgr.testByIdentity(identity);
		model.addAttribute("uinfo", uinfo);
		return "showBuserInfo";
	}

	// ר�Ʊ�����Ϣչʾҳ��
	@RequestMapping(value = "/showZbmInfo/{identity}", method = RequestMethod.GET)
	public String showZbminfo(@PathVariable String identity,
			HttpServletRequest request, Model model) {
		Zbm_info zbminfo = (Zbm_info) zinfoMgr.testByIdentity(identity);
		model.addAttribute("zbminfo", zbminfo);
		return "showZbmInfo";
	}
	
	// ���Ʊ�����Ϣչʾҳ��
	@RequestMapping(value = "/showBbmInfo/{identity}", method = RequestMethod.GET)
	public String showBbminfo(@PathVariable String identity,
			HttpServletRequest request, Model model) {
		Bbm_info bbminfo = (Bbm_info)binfoMgr.testByIdentity(identity);
		model.addAttribute("bbminfo", bbminfo);
		return "showBbmInfo";
	}

	// �༭ר���û����˻�����Ϣ
	@RequestMapping(value = "/editZuserInfo/{identity}", method = RequestMethod.GET)
	public String editZusrInfo(@PathVariable String identity, Model model) {
		U_info uinfo = (U_info) uinfoMgr.testByIdentity(identity);
		model.addAttribute("uinfo", uinfo);

		List<Nation> nations = nationMgr.getNationDao().getAllNation();
		List<Place> places = placeMgr.getPlaceDao().getAllPlace();

		model.addAttribute("nations", nations);
		model.addAttribute("places", places);
		model.addAttribute("mode", "update");

		return "editZuserInfo";
	}
	
	// �༭�����û����˻�����Ϣ
	@RequestMapping(value = "/editBuserInfo/{identity}", method = RequestMethod.GET)
	public String editBusrInfo(@PathVariable String identity, Model model) {
		U_info uinfo = (U_info) uinfoMgr.testByIdentity(identity);
		model.addAttribute("uinfo", uinfo);

		List<Nation> nations = nationMgr.getNationDao().getAllNation();
		List<Place> places = placeMgr.getPlaceDao().getAllPlace();

		model.addAttribute("nations", nations);
		model.addAttribute("places", places);
		model.addAttribute("mode", "update");

		return "editBuserInfo";
	}

	// �༭ר��־Ը��Ϣ
	@RequestMapping(value = "/editZbmInfo/{identity}", method = RequestMethod.GET)
	public String editZbmInfo(@PathVariable String identity, Model model) {
		Zbm_info zbminfo = (Zbm_info) zinfoMgr.testByIdentity(identity);
		model.addAttribute("zbminfo", zbminfo);

		List<Shool> shools = shoolMgr.getShoolDao().getAllShool();
		List<Professional> professionals = proMgr.getProfessionalDao()
				.getAllProfessional();

		model.addAttribute("shools", shools);
		model.addAttribute("professionals", professionals);
		model.addAttribute("mode", "update");

		return "editZbmInfo";
	}
	
	// �༭����־Ը��Ϣ
	@RequestMapping(value = "/editBbmInfo/{identity}", method = RequestMethod.GET)
	public String editBbmInfo(@PathVariable String identity, Model model) {
		Bbm_info bbminfo = (Bbm_info)binfoMgr.testByIdentity(identity);
		model.addAttribute("bbminfo", bbminfo);

		List<Shool> shools = shoolMgr.getShoolDao().getAllShool();
		List<Professional> professionals = proMgr.getProfessionalDao()
				.getAllProfessional();

		model.addAttribute("shools", shools);
		model.addAttribute("professionals", professionals);
		model.addAttribute("mode", "update");

		return "editBbmInfo";
	}

	// �༭ר�Ʊ����û����˻�����Ϣ��ת����Ϣҳ��
	@RequestMapping(value = "/updateZuserInfo", params = "update", method = RequestMethod.POST)
	public String updateZusrInfo(@ModelAttribute("currUser") User user,
			HttpServletRequest request, @Valid U_info u_info,
			BindingResult bindingResult, Model model) {
		Integer n_id = Integer.parseInt(request.getParameter("n_id"));
		Integer p_id = Integer.parseInt(request.getParameter("p_id"));
		// ����쳣��������������Ϊ���������������ǲ����¼��ʱ��û������ID��ֵ���µ�
		Integer u_id = Integer.parseInt(request.getParameter("u_id"));
		if (bindingResult.hasErrors()) {
			return "redirect:/bminfo/editZuserInfo/" + u_info.getIdentity()
					+ "?error=2";
		}
		u_info.setU_id(u_id);

		uinfoMgr.updateU_info(n_id, p_id, u_info);
		return "redirect:/bminfo/showZuserInfo/" + u_info.getIdentity();
	}
	
	// �༭���Ʊ����û����˻�����Ϣ��ת����Ϣҳ��
	@RequestMapping(value = "/updateBuserInfo", params = "update", method = RequestMethod.POST)
	public String updateBuserInfo(@ModelAttribute("currUser") User user,
			HttpServletRequest request, @Valid U_info u_info,
			BindingResult bindingResult, Model model) {
		Integer n_id = Integer.parseInt(request.getParameter("n_id"));
		Integer p_id = Integer.parseInt(request.getParameter("p_id"));
		// ����쳣��������������Ϊ���������������ǲ����¼��ʱ��û������ID��ֵ���µ�
		Integer u_id = Integer.parseInt(request.getParameter("u_id"));
		if (bindingResult.hasErrors()) {
			return "redirect:/bminfo/editBuserInfo/" + u_info.getIdentity()
					+ "?error=2";
		}
		u_info.setU_id(u_id);

		uinfoMgr.updateU_info(n_id, p_id, u_info);
		return "redirect:/bminfo/showBuserInfo/" + u_info.getIdentity();
	}

	// �༭ר��־Ը��Ϣ��ת����Ϣҳ��
	@RequestMapping(value = "/updateZbmInfo", params = "update", method = RequestMethod.POST)
	public String updateZbmInfo(@ModelAttribute("currUser") User user,
			HttpServletRequest request, @Valid Zbm_info zbm_info,
			BindingResult bindingResult, Model model) {
		Integer shool1 = Integer.parseInt(request.getParameter("shool1"));
		Integer shool2 = Integer.parseInt(request.getParameter("shool2"));
		Integer pro1 = Integer.parseInt(request.getParameter("pro1"));
		Integer pro2 = Integer.parseInt(request.getParameter("pro2"));
		Integer pro3 = Integer.parseInt(request.getParameter("pro3"));
		Integer pro4 = Integer.parseInt(request.getParameter("pro4"));
		if (bindingResult.hasErrors()) {
			List<Shool> shools = shoolMgr.getShoolDao().getAllShool();
			List<Professional> professionals = proMgr.getProfessionalDao()
					.getAllProfessional();
			model.addAttribute("shools", shools);
			model.addAttribute("professionals", professionals);
			return "/BMweb/bminfo/updateZbmInfo?update";
		} else {
			// ����쳣��������������Ϊ���������������ǲ����¼��ʱ��û������ID��ֵ���µ�
			Integer z_id = Integer.parseInt(request.getParameter("z_id"));
			zbm_info.setZ_id(z_id);

			zinfoMgr.updateU_info(shool1, shool2, pro1, pro2, pro3, pro4,
					user.getIdentity(), zbm_info);
			model.addAttribute("zbm_info", zbm_info);

			return "redirect:/bminfo/showZbmInfo/" + zbm_info.getIdentity();
		}

	}
	
	// �༭����־Ը��Ϣ��ת����Ϣҳ��
	@RequestMapping(value = "/updateBbmInfo", params = "update", method = RequestMethod.POST)
	public String updateBbmInfo(@ModelAttribute("currUser") User user,
			HttpServletRequest request, @Valid Bbm_info bbm_info,
			BindingResult bindingResult, Model model) {
		Integer shool1 = Integer.parseInt(request.getParameter("shool1"));
		Integer pro1 = Integer.parseInt(request.getParameter("pro1"));
		Integer pro2 = Integer.parseInt(request.getParameter("pro2"));
		Integer pro3 = Integer.parseInt(request.getParameter("pro3"));
		Integer pro4 = Integer.parseInt(request.getParameter("pro4"));
		if (bindingResult.hasErrors()) {
			List<Shool> shools = shoolMgr.getShoolDao().getAllShool();
			List<Professional> professionals = proMgr.getProfessionalDao().getAllProfessional();
			model.addAttribute("shools", shools);
			model.addAttribute("professionals", professionals);
			return "/BMweb/bminfo/updateBbmInfo?update";
		} else {
			// ����쳣��������������Ϊ���������������ǲ����¼��ʱ��û������ID��ֵ���µ�
			Integer b_id = Integer.parseInt(request.getParameter("b_id"));
			bbm_info.setB_id(b_id);
			binfoMgr.updateU_info(shool1, pro1, pro2, pro3, pro4, user.getIdentity(), bbm_info);
			model.addAttribute("bbm_info", bbm_info);

			return "redirect:/bminfo/showBbmInfo/" + bbm_info.getIdentity();
		}

	}
}
