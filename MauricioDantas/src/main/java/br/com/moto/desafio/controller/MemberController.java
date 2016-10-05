package br.com.moto.desafio.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.moto.desafio.data.MemberDao;
import br.com.moto.desafio.model.Member;

@Controller
@RequestMapping(value = "/")
public class MemberController {
	@Autowired
	private MemberDao memberDao;

	@RequestMapping(method = RequestMethod.GET)
	public String displaySortedMembers(Model model) {
		model.addAttribute("members", memberDao.findAllOrderedByName());
		model.addAttribute("newMember", new Member());
		return "/index";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerNewMember(
			@Valid @ModelAttribute("newMember") Member newMember,
			BindingResult result, Model model) {
		if (!result.hasFieldErrors()) {
			memberDao.register(newMember);
			model.addAttribute("newMember", new Member());
		}
		model.addAttribute("members", memberDao.findAllOrderedByName());
		return "/index";
	}

	@RequestMapping(value = "deleteMember/{id}", method = RequestMethod.GET)
	public String deleteMember(@PathVariable("id") Long id, Model model) {
		memberDao.removeById(id);
		model.addAttribute("members", memberDao.findAllOrderedByName());
		model.addAttribute("newMember", new Member());
		return "redirect:/";
	}
}
