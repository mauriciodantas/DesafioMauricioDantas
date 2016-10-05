package br.com.moto.desafio.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.moto.desafio.data.MemberDao;
import br.com.moto.desafio.model.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml",
		"classpath:/META-INF/spring/applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class MemberDaoTest {
	@Autowired
	private MemberDao memberDao;

	
	@Test
	public void testFindById() {
		Member member = memberDao.findById(0L);
		assert (member != null);
		return;
	}

	@Test
	public void testFindByEmail() {
		Member member = memberDao.findByEmail("john.smith@mailinator.com");
		assert (member != null);
		return;
	}

	@Test
    public void testRegister() {
        Member newMember = new Member();
        newMember.setEmail("teste@teste.com");
        newMember.setName("Usuario teste");
        newMember.setPhoneNumber("551198765432");
    	try{
    		memberDao.register(newMember);
    		assert(true);
    	}
    	catch(Exception e){
    		assert(false);	
    	}
    	
    	return;
    }

	@Test
	public void testFindAllOrderedByName() {
		List<Member> members = memberDao.findAllOrderedByName();
		assert(!members.isEmpty());
		return;
	}
	
	@Test
	public void testRemoveById() {
		try{
    		memberDao.removeById(0L);
    		assert(true);
    	}
    	catch(Exception e){
    		assert(false);	
    	}
		return;
	}

}
