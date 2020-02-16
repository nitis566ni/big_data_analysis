package com.prushal.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prushal.model.AccountInfo;
import com.prushal.model.Customer;
import com.prushal.model.DocumentUploads;
import com.prushal.model.Email;
import com.prushal.model.Employee;
import com.prushal.model.LoginPageInfo;
import com.prushal.model.Merchant;
import com.prushal.model.MerchantLimit;
import com.prushal.model.PotentialCorporateProjects;
import com.prushal.model.PotentialMerchants;
import com.prushal.model.Project;
import com.prushal.rest.service.AccountInfoService;
import com.prushal.rest.service.EmployeeService;
import com.prushal.rest.service.MerchantService;
import com.prushal.rest.service.PotentialService;
import com.prushal.rest.service.ProjectService;
import com.prushal.web.service.CustomerWebService;
import com.prushal.web.service.EmailWebService;
import com.prushal.web.service.LoginPageInfoService;
import com.prushal.web.service.LoginService;
import com.prushal.web.service.MerchantWebService;
import com.prushal.web.service.ProjectWebService;

@Controller
public class DashboardController {

	@Autowired
	CustomerWebService cservice;

	@Autowired
	ProjectService service;

	@Autowired
	LoginService lservice;

	@Autowired
	PotentialService pservice;

	@Autowired
	MerchantService mservice;

	@Autowired
	MerchantWebService mwservice;

	@Autowired
	AccountInfoService aiservice;

	@Autowired
	ProjectWebService pwservice;

	@Autowired
	LoginPageInfoService lpservice;

	@Autowired
	EmailWebService eservice;

	@Autowired
	EmployeeService empservice;

	@GetMapping("dashboard")
	public String goToDashboard(ModelMap model) {
		model.put("projectsCount", lservice.getProjectCount());
		model.put("potentialProjectsCount", lservice.getPotentialProjectCount());
		model.put("merchantsCount", lservice.getMerchantsCount());
		model.put("potentialMerchantsCount", lservice.getPotentialMerchantsCount());
		return "dashboard";
	}

	@GetMapping("services")
	public String goToServices() {
		return "welcome";
	}

	@GetMapping("profile")
	public String goToProfile(ModelMap model) {
		return "profile";
	}

	@GetMapping("merchant_login_page_info")
	public String goToMerchant_login_page_info(ModelMap model) {
		LoginPageInfo info = lpservice.getInfo();
		model.addAttribute("info", info);

		return "merchant_login_page_info";
	}

	@GetMapping("project_onboarding")
	public String goToProject_onboarding(ModelMap model) {
		List<Project> projects = service.getAllProjects();
		List<PotentialCorporateProjects> cprojects = pservice.getAllPotentialProjects();
		model.addAttribute("cprojects", cprojects);
		model.addAttribute("projects", projects);
		return "project_onboarding";
	}

	@GetMapping("merchant_onboarding")
	public String goToMerchant_onboarding(ModelMap model) {
		List<Merchant> merchants = mservice.getAllMerchants();
		List<PotentialMerchants> pmerchants = pservice.getAllPotentialMerchants();
		model.addAttribute("merchants", merchants);
		model.addAttribute("pmerchants", pmerchants);
		return "merchant_onboarding";
	}

	@GetMapping("send_merchant_credentials")
	public String goToSend_merchant_credentials(ModelMap model) {
		List<Project> projects = service.getAllProjects();
		model.addAttribute("projects", projects);
		return "send_merchant_credentials";
	}

	@GetMapping("merchant_limit_list")
	public String goToMerchantLimitList(ModelMap model) {
		List<MerchantLimit> limits = mwservice.getAllMerchantLimits();
		model.addAttribute("limits", limits);
		return "merchant_limit_list";
	}

	@GetMapping("update_merchant_topup_limit")
	public String goToUpdate_merchant_topup_limit(ModelMap model) {
		List<Project> projects = service.getAllProjects();
		model.addAttribute("projects", projects);
		return "update_merchant_topup_limit";
	}

	@GetMapping("merchant_reduce_limit")
	public String goToMerchant_reduce_limit(ModelMap model) {
		List<Project> projects = service.getAllProjects();
		model.addAttribute("projects", projects);
		return "merchant_reduce_limit";
	}

	@GetMapping("payment_details")
	public String goToUpdate_and_view_payment_details(ModelMap model) {
		List<Project> projects = service.getAllProjects();
		model.addAttribute("projects", projects);
		return "payment_details";
	}

	@GetMapping("enable_and_disable_merchant")
	public String goToEnable_and_disable_merchant(ModelMap model) {
		List<Project> projects = service.getAllProjects();
		model.addAttribute("projects", projects);
		return "enable_and_disable_merchant";
	}

	@GetMapping("pr_account_info")
	public String goToBp_account_info(ModelMap model) {
		AccountInfo info = aiservice.getInfo();
		model.addAttribute("account", info);
		return "pr_account_info";
	}

	@GetMapping("reports")
	public String goToReports(ModelMap model) {
		List<Project> projects = service.getAllProjects();
		model.addAttribute("projects", projects);
		List<Project> cprojects = service.getAllCorporateProjects();
		model.addAttribute("cprojects", cprojects);
		return "reports";
	}

	@GetMapping("employee_list")
	public String goToCreateEmployee(ModelMap model) {
		List<Employee> employees = empservice.findAll();
		model.addAttribute("employees", employees);
		return "employee_list";
	}

	@GetMapping("assign_employee_roles")
	public String goToAssignEmployeeRoles(ModelMap model) {
		List<Employee> employees = empservice.findAll();
		model.addAttribute("employees", employees);
		return "assign_employee_roles";
	}

	@GetMapping("send_notifications_merchant")
	public String goToSend_notifications_merchant(ModelMap model) {
		List<Project> projects = service.getAllProjects();
		model.addAttribute("projects", projects);
		return "send_notifications_merchant";
	}

	@GetMapping("send_notifications_customer")
	public String goToSend_notifications_customer(ModelMap model) {
		List<Customer> customers = cservice.getAllCustomers();
		model.addAttribute("customers", customers);
		List<Project> cprojects = service.getAllCorporateProjects();
		model.addAttribute("cprojects", cprojects);
		List<Project> ncprojects = service.getAllNonCorporateProjects();
		model.addAttribute("ncprojects", ncprojects);
		List<Project> projects = service.getAllProjects();
		model.addAttribute("projects", projects);
		return "send_notifications_customer";
	}

	@GetMapping("email_settings")
	public String goToEmail_settings(ModelMap model) {
		Email emails = eservice.getEmails();
		model.addAttribute("emails", emails);
		return "email_settings";
	}

	@PostMapping("update_email_settings")
	public String updateEmailSettings(@RequestParam("customer_email_id") String customerEmailID,
			@RequestParam("merchant_email_id") String merchantEmailID, ModelMap model) {

		String message = eservice.updateEmailSettings(customerEmailID, merchantEmailID);
		if (message.equalsIgnoreCase("Success")) {
			model.put("successMessage", "Emails Updated!");
			Email emails = eservice.getEmails();
			model.addAttribute("emails", emails);
			return "email_settings";
		} else {
			model.put("errorMessage", message);
			Email emails = eservice.getEmails();
			model.addAttribute("emails", emails);
			return "email_settings";
		}
	}

	@GetMapping("helpdesk_action")
	public String goToHelpdesk_action() {
		return "404";
	}

	@GetMapping("modify_customer_details")
	public String goToModify_customer_details() {
		return "modify_customer_details";
	}

	@GetMapping("merchant_uploads")
	public String goToMerchantUploads(ModelMap model) {
		DocumentUploads uploads = mwservice.getMerchantDocUploads();
		model.addAttribute("uploads", uploads);

		return "merchant_uploads";
	}

	@GetMapping("customer_uploads")
	public String goToCustomerUploads(ModelMap model) {
		DocumentUploads uploads = cservice.getCustomerDocUploads();
		model.addAttribute("uploads", uploads);
		return "customer_uploads";
	}
}
