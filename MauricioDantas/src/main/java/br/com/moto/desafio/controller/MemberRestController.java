package br.com.moto.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.moto.desafio.data.MemberDao;
import br.com.moto.desafio.model.Member;

@Controller
public class MemberRestController {

	@Autowired
	private MemberDao memberDao;

	@RequestMapping(value = "/rest/members", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Member> listAllMembers() {
		return memberDao.findAllOrderedByName();
	}

	@RequestMapping(value = "/rest/members/{id}", method = RequestMethod.GET)
	public @ResponseBody Member lookupMemberById(@PathVariable("id") Long id) {
		return memberDao.findById(id);
	}
}
