package org.project.proxibank.controller;

import java.util.List;

import org.project.proxibank.entities.Account;
import org.project.proxibank.entities.CurrentAccount;
import org.project.proxibank.entities.SavingsAccount;
import org.project.proxibank.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountRestController {

	@Autowired
	IAccountService accountService;

	@GetMapping
	public List<Account> getAll() {
		return accountService.getListAccounts();
	}

	@GetMapping("/{id}")
	public Account getAccount(@PathVariable("id") Long id) {
		return accountService.getAccount(id);
	}
	
	
	@GetMapping("/by-client/{id}")
	public List<Account> getAccountByClient(@PathVariable("id") Long id) {
		return accountService.getAccountsByClient(id);
	}

	@PostMapping("/saving")
	public Account createAccount(@RequestBody SavingsAccount account) {
		return accountService.createAccount(account);
	}
	
	@PostMapping("/current")
	public Account createAccount(@RequestBody CurrentAccount account) {
		return accountService.createAccount(account);
	}
}
