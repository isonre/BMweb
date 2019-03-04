package org.lwt.BMweb.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.lwt.BMweb.model.Bbm_info;
import org.lwt.BMweb.model.Nation;
import org.lwt.BMweb.model.Place;
import org.lwt.BMweb.model.Professional;
import org.lwt.BMweb.model.Shool;
import org.lwt.BMweb.model.U_info;
import org.lwt.BMweb.model.User;
import org.lwt.BMweb.model.Zbm_info;
import org.lwt.BMweb.dao.UserDao;
import org.lwt.BMweb.service.impl.Bbm_infoManager;
import org.lwt.BMweb.service.impl.NationManager;
import org.lwt.BMweb.service.impl.PlaceManager;
import org.lwt.BMweb.service.impl.ProfessionalManager;
import org.lwt.BMweb.service.impl.ShoolManager;
import org.lwt.BMweb.service.impl.U_infoManager;
import org.lwt.BMweb.service.impl.UserManager;
import org.lwt.BMweb.service.impl.Zbm_infoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


@Controller
@RequestMapping("/admin")
@SessionAttributes("currUser")
public class AdminController {
	
	private UserDao userDao; 
	private UserManager userMgr;
	private U_infoManager uinfoMgr;
	private Zbm_infoManager zinfoMgr;
	private Bbm_infoManager binfoMgr;
	
	private NationManager nationMgr;
	private PlaceManager placeMgr;
	
	private ShoolManager shoolMgr;
	private ProfessionalManager proMgr;

	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public NationManager getNationMgr() {
		return nationMgr;
	}

	@Autowired
	@Qualifier("nationMgr")
	public void setNationMgr(NationManager nationMgr) {
		this.nationMgr = nationMgr;
	}

	@Autowired
	@Qualifier("userMgr")
	public void setUserMgr(UserManager userMgr) {
		this.userMgr = userMgr;
	}
	public UserManager getUserMgr() {
		return userMgr;
	}
	
	public U_infoManager getUinfoMgr() {
		return uinfoMgr;
	}

	@Autowired
	@Qualifier("uinfoMgr")
	public void setUinfoMgr(U_infoManager uinfoMgr) {
		this.uinfoMgr = uinfoMgr;
	}

	@RequestMapping("/login") 
	public String login() {
		return "admin/adminSingin";
	}
	
	public PlaceManager getPlaceMgr() {
		return placeMgr;
	}

	@Autowired
	@Qualifier("placeMgr")
	public void setPlaceMgr(PlaceManager placeMgr) {
		this.placeMgr = placeMgr;
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
	
	//��¼
	@RequestMapping(value="/process/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model) {
		String identity = request.getParameter("identity");
		String u_pwd = request.getParameter("pwd");
		User user = (User) userMgr.login(identity, u_pwd); 
		if(user==null){
			return "redirect:/admin/login?error=1";
		}
		if(identity.equals("450404199204300913")){
			model.addAttribute("currUser", user);
			return "redirect:/admin/index";
		}
		System.out.println(identity);
		return "redirect:/admin/login?error=1";
	}
	
	//��ҳ
	@RequestMapping("/index")
	public String index() {
		 return "admin/adminindex";
	}
	
	//iframeҳ
	@RequestMapping("/iframe")
	public String iframe() {
		 return "admin/iframe";
	}
	
	//�˳�ϵͳ
	@RequestMapping(value="/index",params="logout",method=RequestMethod.GET)
	public String logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/admin/login";
	}
	
	//ȫ���û�������Ϣչʾҳ
	@RequestMapping(value="/allUserInfo",method=RequestMethod.GET)
	public String showZuserInfo(HttpServletRequest request, Model model) {
		List<U_info> u_infoList;
		u_infoList = uinfoMgr.getU_infoDao().getAllU_info();
		model.addAttribute("u_infoList",u_infoList);
		return "admin/allUserInfo";
	}
	
	//ĳ�û�������Ϣչʾҳ��
	@RequestMapping(value="/showUserInfo/{identity}",method=RequestMethod.GET)
	public String showZuserinfo(@PathVariable String identity,HttpServletRequest request, Model model) {
		U_info uinfo = (U_info)uinfoMgr.testByIdentity(identity);
		model.addAttribute("uinfo",uinfo);
		return "admin/showUserInfo";
	}
	
	//ȫ��������Ϣչʾҳ
	@RequestMapping(value="/allNationInfo",method=RequestMethod.GET)
	public String showNationInfo(HttpServletRequest request, Model model) {
		List<Nation> nationList;
		nationList = nationMgr.getNationDao().getAllNation();
		model.addAttribute("nationList",nationList);
		return "admin/allNationInfo";
	}
	
	//ȫ��������Ϣչʾҳ
	@RequestMapping(value="/allPlaceInfo",method=RequestMethod.GET)
	public String showPlaceInfo(HttpServletRequest request, Model model) {
		List<Place> placeList;
		placeList = placeMgr.getPlaceDao().getAllPlace();
		model.addAttribute("placeList",placeList);
		return "admin/allPlaceInfo";
	}
	
	//ȫ��ר��־Ը��Ϣչʾҳ
	@RequestMapping(value="/allZbmInfo",method=RequestMethod.GET)
	public String showZbmInfo(HttpServletRequest request, Model model) {
		List<Zbm_info> zbmInfoList;
		zbmInfoList = zinfoMgr.getZbm_infoDao().getAllZbm_info();
		model.addAttribute("zbmInfoList",zbmInfoList);
		return "admin/allZbmInfo";
	}
	
	//ȫ������־Ը��Ϣչʾҳ
	@RequestMapping(value="/allBbmInfo",method=RequestMethod.GET)
	public String showBbmInfo(HttpServletRequest request, Model model) {
		
		List<Bbm_info> bbmInfoList;
		bbmInfoList = binfoMgr.getBbm_infoDao().getAllBbm_info();
		model.addAttribute("bbmInfoList",bbmInfoList);
		return "admin/allBbmInfo";
	}
	
	//ĳ�û�ר��־Ը��Ϣչʾҳ��
	@RequestMapping(value="/showZbmInfo/{identity}",method=RequestMethod.GET)
	public String showZbminfo(@PathVariable String identity,HttpServletRequest request, Model model) {
		Zbm_info zbm_info = (Zbm_info)zinfoMgr.testByIdentity(identity);
		model.addAttribute("zbm_info",zbm_info);
		return "admin/showZbmInfo";
	}
	
	//ĳ�û�����־Ը��Ϣչʾҳ��
	@RequestMapping(value="/showBbmInfo/{identity}",method=RequestMethod.GET)
	public String showBbminfo(@PathVariable String identity,HttpServletRequest request, Model model) {
		Bbm_info bbm_info = (Bbm_info)binfoMgr.testByIdentity(identity);
		model.addAttribute("bbm_info",bbm_info);
		return "admin/showBbmInfo";
	}
	
	//ȫ��ѧУ��Ϣչʾҳ
	@RequestMapping(value="/allShoolInfo",method=RequestMethod.GET)
	public String showShoolInfo(HttpServletRequest request, Model model) {
		List<Shool> shoolList;
		shoolList = shoolMgr.getShoolDao().getAllShool();
		model.addAttribute("shoolList",shoolList);
		return "admin/allShoolInfo";
	}
	
	//ȫ��רҵ��Ϣչʾҳ
	@RequestMapping(value="/allProInfo",method=RequestMethod.GET)
	public String showProInfo(HttpServletRequest request, Model model) {
		List<Professional> proList;
		proList = proMgr.getProfessionalDao().getAllProfessional();
		model.addAttribute("proList",proList);
		return "admin/allProInfo";
	}
	
	//ɾ���û���Ϣ������Ϣ
	@ResponseBody
	@RequestMapping(value="/ajax/deleteUserInfo",method=RequestMethod.POST)
	public String ajaxDeleteUserInfo(HttpServletRequest request) {
		int uid = Integer.parseInt(request.getParameter("u_id"));
		int result = uinfoMgr.getU_infoDao().delete(uid);
		return result == 1 ? "success":"fail";
	}
	
	//ɾ��������Ϣ
	@ResponseBody
	@RequestMapping(value="/ajax/deleteNationInfo",method=RequestMethod.POST)
	public String ajaxDeleteNaitonInfo(HttpServletRequest request) {
		int nid = Integer.parseInt(request.getParameter("n_id"));
		int result = nationMgr.getNationDao().delete(nid);
		return result == 1 ? "success":"fail";
	}
	
	//ɾ��������Ϣ
	@ResponseBody
	@RequestMapping(value="/ajax/deletePlaceInfo",method=RequestMethod.POST)
	public String ajaxDeletePlaceInfo(HttpServletRequest request) {
		int pid = Integer.parseInt(request.getParameter("p_id"));
		int result = placeMgr.getPlaceDao().delete(pid);
		return result == 1 ? "success":"fail";
	}
	
	//ɾ��ר�Ʊ�����Ϣ
	@ResponseBody
	@RequestMapping(value="/ajax/deleteZbmInfo",method=RequestMethod.POST)
	public String ajaxDeleteZbmInfo(HttpServletRequest request) {
		int zid = Integer.parseInt(request.getParameter("z_id"));
		int result = zinfoMgr.getZbm_infoDao().delete(zid);
		return result == 1 ? "success":"fail";
	}
	
	//ɾ�����Ʊ�����Ϣ
	@ResponseBody
	@RequestMapping(value="/ajax/deleteBbmInfo",method=RequestMethod.POST)
	public String ajaxDeleteBbmInfo(HttpServletRequest request) {
		int bid = Integer.parseInt(request.getParameter("b_id"));
		int result = binfoMgr.getBbm_infoDao().delete(bid);
		return result == 1 ? "success":"fail";
	}
	
	//ɾ��ѧУ��Ϣ
	@ResponseBody
	@RequestMapping(value="/ajax/deleteShoolInfo",method=RequestMethod.POST)
	public String ajaxDeleteShoolInfo(HttpServletRequest request) {
		int sid = Integer.parseInt(request.getParameter("s_id"));
		int result = shoolMgr.getShoolDao().delete(sid);
		return result == 1 ? "success":"fail";
	}
	
	//ɾ��רҵ��Ϣ
	@ResponseBody
	@RequestMapping(value="/ajax/deleteProInfo",method=RequestMethod.POST)
	public String ajaxDeleteProInfo(HttpServletRequest request) {
		int pid = Integer.parseInt(request.getParameter("pro_id"));
		int result = proMgr.getProfessionalDao().delete(pid);
		return result == 1 ? "success":"fail";
	}
	
	//����û���Ϣ������Ϣ
	@RequestMapping("UserInfoIdex")
	public String zusrInfo(Model model) {
		
		U_info u_info = new U_info();
		
		List<Nation> nations = nationMgr.getNationDao().getAllNation();
		List<Place> places = placeMgr.getPlaceDao().getAllPlace();
				
		model.addAttribute("nations", nations);
		model.addAttribute("places", places);
		model.addAttribute("u_info",u_info);
		return "admin/addUserInfo";
	}
	
	//����û���Ϣ������Ϣ
	@RequestMapping(value="/addUserInfoIdex", method = RequestMethod.POST)
	public String createzbmInfo(HttpServletRequest request,@Valid U_info u_info, BindingResult bindingResult, Model model) {
		Integer n_id = Integer.parseInt(request.getParameter("n_id"));
		Integer p_id = Integer.parseInt(request.getParameter("p_id"));
		if(bindingResult.hasErrors()){
			return "redirect:/admin/UserInfoIdex?error=2";
		}	
		else if(uinfoMgr.testByIdentity(u_info.getIdentity())!=null){
			//���������Ϣ�����ظ��ύ��Ϣ��
			return "redirect:/admin/UserInfoIdex?error=1";
		}else{
		uinfoMgr.addU_info(n_id, p_id, u_info);
		model.addAttribute("U_info", u_info);

		return "redirect:/admin/showUserInfo/"+u_info.getIdentity();
		}
	}
	
	//���������Ϣ
	@RequestMapping("NationInfoIdex")
	public String nationInfo(Model model) {
		
		Nation nation = new Nation();
		model.addAttribute("nation",nation);
		return "admin/addNationInfo";
	}
	
	//���������Ϣ
	@RequestMapping(value="/addNaitonInfoIdex", method = RequestMethod.POST)
	public String createNationInfo(HttpServletRequest request,@Valid Nation nation, BindingResult bindingResult, Model model) {
		String n_name = request.getParameter("n_name");
		if(bindingResult.hasErrors()||n_name.equals("")){
			return "redirect:/admin/NationInfoIdex?error=2";
		}	
		else{
			nationMgr.getNationDao().save(nation);
			model.addAttribute("nation", nation);
		   return "redirect:/admin/allNationInfo";
		}
	}
	
	//��Ӽ�����Ϣ
	@RequestMapping("PlaceInfoIdex")
	public String placeInfo(Model model) {
		Place place = new Place();
		model.addAttribute("place",place);
		return "admin/addPlaceInfo";
	}
	
	//��Ӽ�����Ϣ
	@RequestMapping(value="/addPlaceInfoIdex", method = RequestMethod.POST)
	public String createPlaceInfo(HttpServletRequest request,@Valid Place place, BindingResult bindingResult, Model model) {
		String p_name = request.getParameter("p_name");
		if(bindingResult.hasErrors()||p_name.equals("")){
			return "redirect:/admin/PlaceInfoIdex?error=2";
		}	
		else{
			placeMgr.getPlaceDao().save(place);
			model.addAttribute("place", place);
		   return "redirect:/admin/allPlaceInfo";
		}
	}
	
	//���ѧУ��Ϣ
	@RequestMapping("ShoolInfoIdex")
	public String shoolInfo(Model model) {
		Shool shool =new Shool();
		model.addAttribute("shool",shool);
		return "admin/addShoolInfo";
	}
	
	//���ѧУ��Ϣ
	@RequestMapping(value="/addShoolInfoIdex", method = RequestMethod.POST)
	public String createShoolInfo(HttpServletRequest request,@Valid Shool  shool, BindingResult bindingResult, Model model) {
		String s_name = request.getParameter("s_name");
		String category = request.getParameter("category");
		if(bindingResult.hasErrors()||s_name.equals("")||category.equals("")){
			return "redirect:/admin/ShoolInfoIdex?error=2";
		}	
		else{
			shoolMgr.getShoolDao().save(shool);
			model.addAttribute("shool", shool);
		   return "redirect:/admin/allShoolInfo";
		}
	}
	
	//���רҵ��Ϣ
	@RequestMapping("ProInfoIdex")
	public String proInfo(Model model) {
		Professional pro = new Professional();
		model.addAttribute("pro",pro);
		return "admin/addProInfo";
	}
	
	//���רҵ��Ϣ
	@RequestMapping(value="/addProlInfoIdex", method = RequestMethod.POST)
	public String createProInfo(HttpServletRequest request,@Valid Professional pro, BindingResult bindingResult, Model model) {
		String p_name = request.getParameter("p_name");
		String category = request.getParameter("category");
		if(bindingResult.hasErrors()||p_name.equals("")||category.equals("")){
			return "redirect:/admin/ProInfoIdex?error=2";
		}	
		else{
			proMgr.getProfessionalDao().save(pro);
			model.addAttribute("pro", pro);
		   return "redirect:/admin/allProInfo";
		}
	}
	
	//���ר��־Ը��Ϣ
	@RequestMapping("ZbmInfoIdex")
	public String zbmInfo(Model model) {
		
		Zbm_info zbm_info = new Zbm_info();
		List<Shool> shools = shoolMgr.getShoolDao().getAllShool();
		List<Professional> professionals = proMgr.getProfessionalDao().getAllProfessional();
		model.addAttribute("shools", shools);
		model.addAttribute("professionals", professionals);
		model.addAttribute("zbm_info",zbm_info);
		return "admin/addZbmInfo";
	}
	
	//���ר��־Ը��Ϣ
	@RequestMapping(value="/addZbmInfoIdex", method = RequestMethod.POST)
	public String createzbmfinalInfo(HttpServletRequest request,@Valid Zbm_info zbm_info, BindingResult bindingResult, Model model) {
		Integer shool1 = Integer.parseInt(request.getParameter("shool1"));
		Integer shool2 = Integer.parseInt(request.getParameter("shool2"));
		Integer pro1 = Integer.parseInt(request.getParameter("pro1"));
		Integer pro2 = Integer.parseInt(request.getParameter("pro2"));
		Integer pro3 = Integer.parseInt(request.getParameter("pro3"));
		Integer pro4 = Integer.parseInt(request.getParameter("pro4"));
		String identity = request.getParameter("identity");
		if(bindingResult.hasErrors()||identity.equals("")){
			List<Shool> shools = shoolMgr.getShoolDao().getAllShool();
			List<Professional> professionals = proMgr.getProfessionalDao().getAllProfessional();
			model.addAttribute("shools",shools);
			model.addAttribute("professionals", professionals);
			//������֤���벻��Ϊ��
			return "redirect:/admin/ZbmInfoIdex?error=2";
		}
		else if(zinfoMgr.testByIdentity(zbm_info.getIdentity())!=null){
			//���������Ϣ�����ظ��ύ��Ϣ��
			return "redirect:/admin/ZbmInfoIdex?error=1";
		}
		else{
		Integer zbminfo_Id = zinfoMgr.addZbm_info(shool1,shool2,pro1,pro2,pro3,pro4,zbm_info.getIdentity(), zbm_info);
		return "redirect:/admin/showZbmInfo/"+zbm_info.getIdentity();
		}
	}
	
	//��ӱ���־Ը��Ϣ
	@RequestMapping("BbmInfoIdex")
	public String bbmInfo(Model model) {
		
		Bbm_info bbm_info = new Bbm_info();
		List<Shool> shools = shoolMgr.getShoolDao().getAllShool();
		List<Professional> professionals = proMgr.getProfessionalDao().getAllProfessional();
		model.addAttribute("shools", shools);
		model.addAttribute("professionals", professionals);
		model.addAttribute("bbm_info",bbm_info);
		return "admin/addBbmInfo";
	}
	
	//��ӱ���־Ը��Ϣ
	@RequestMapping(value="/addBbmInfoIdex", method = RequestMethod.POST)
	public String createbbmfinalInfo(HttpServletRequest request,@Valid Bbm_info bbm_info, BindingResult bindingResult, Model model) {
		Integer shool1 = Integer.parseInt(request.getParameter("shool1"));
		Integer pro1 = Integer.parseInt(request.getParameter("pro1"));
		Integer pro2 = Integer.parseInt(request.getParameter("pro2"));
		Integer pro3 = Integer.parseInt(request.getParameter("pro3"));
		Integer pro4 = Integer.parseInt(request.getParameter("pro4"));
		String identity = request.getParameter("identity");
		if(bindingResult.hasErrors()||identity.equals("")){
			List<Shool> shools = shoolMgr.getShoolDao().getAllShool();
			List<Professional> professionals = proMgr.getProfessionalDao().getAllProfessional();
			model.addAttribute("shools",shools);
			model.addAttribute("professionals", professionals);
			//������֤���벻��Ϊ��
			return "redirect:/admin/BbmInfoIdex?error=2";
		}
		else if(binfoMgr.testByIdentity(bbm_info.getIdentity())!=null){
			//���������Ϣ�����ظ��ύ��Ϣ��
			return "redirect:/admin/BbmInfoIdex?error=1";
		}
		else{
		Integer zbminfo_Id = binfoMgr.addBbm_info(shool1, pro1, pro2, pro3, pro4, identity, bbm_info);
		return "redirect:/admin/showBbmInfo/"+bbm_info.getIdentity();
		}
	}
	
	//�༭������Ϣ
	@RequestMapping(value="/editZuserInfo/{identity}",method=RequestMethod.GET)
	public String editZusrInfo(@PathVariable String identity,Model model) {
		U_info uinfo = (U_info)uinfoMgr.testByIdentity(identity);
		model.addAttribute("uinfo",uinfo);
		
		List<Nation> nations = nationMgr.getNationDao().getAllNation();
		List<Place> places = placeMgr.getPlaceDao().getAllPlace();
				
		model.addAttribute("nations", nations);
		model.addAttribute("places", places);
		model.addAttribute("mode","update");
		
		return "admin/editZuserInfo";
	}
	
	//�༭������Ϣ��ת����Ϣҳ��
	@RequestMapping(value="/updateZuserInfo",params="update",method=RequestMethod.POST)
	public String updateZusrInfo(HttpServletRequest request,@Valid U_info u_info,BindingResult bindingResult,Model model) {
		Integer n_id = Integer.parseInt(request.getParameter("n_id"));
		Integer p_id = Integer.parseInt(request.getParameter("p_id"));
		//����쳣��������������Ϊ���������������ǲ����¼��ʱ��û������ID��ֵ���µ�
		Integer u_id = Integer.parseInt(request.getParameter("u_id"));
		if(bindingResult.hasErrors()){
			return "redirect:/admin/editZuserInfo/"+u_info.getIdentity()+"?error=2";
		}	
		u_info.setU_id(u_id);

		uinfoMgr.updateU_info(n_id, p_id, u_info);
		return "redirect:/admin/showUserInfo/"+u_info.getIdentity();
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

		return "admin/editZbmInfo";
	}
	
	// �༭ר��־Ը��Ϣ��ת����Ϣҳ��
	@RequestMapping(value = "/updateZbmInfo", params = "update", method = RequestMethod.POST)
	public String updateZbmInfo(
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
			return "/BMweb/admin/editZbmInfo"+zbm_info.getIdentity()+"?error=2";
		} else {
			// ����쳣��������������Ϊ���������������ǲ����¼��ʱ��û������ID��ֵ���µ�
			Integer z_id = Integer.parseInt(request.getParameter("z_id"));
			zbm_info.setZ_id(z_id);

			zinfoMgr.updateU_info(shool1, shool2, pro1, pro2, pro3, pro4,
					zbm_info.getIdentity(), zbm_info);
			model.addAttribute("zbm_info", zbm_info);

			return "redirect:/admin/showZbmInfo/" + zbm_info.getIdentity();
		}

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

		return "admin/editBbmInfo";
	}
	
	// �༭����־Ը��Ϣ��ת����Ϣҳ��
	@RequestMapping(value = "/updateBbmInfo", params = "update", method = RequestMethod.POST)
	public String updateBbmInfo(
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
			return "/BMweb/admin/editBbmInfo"+bbm_info.getIdentity()+"?error=2";
		} else {
			// ����쳣��������������Ϊ���������������ǲ����¼��ʱ��û������ID��ֵ���µ�
			Integer b_id = Integer.parseInt(request.getParameter("b_id"));
			bbm_info.setB_id(b_id);
			binfoMgr.updateU_info(shool1, pro1, pro2, pro3, pro4, bbm_info.getIdentity(), bbm_info);
			model.addAttribute("bbm_info", bbm_info);

			return "redirect:/admin/showBbmInfo/" + bbm_info.getIdentity();
		}

	}
	
}
