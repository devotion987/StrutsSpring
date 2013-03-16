package junit.test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wgy.entity.Person;
import com.wgy.service.PersonService;

public class JdbcTest {

	private static PersonService personMgr = null;

	@BeforeClass
	public static void instanceSpring() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		personMgr = (PersonService) ctx.getBean("personMgr");
	}

	@Test
	public void testSave() {
		Person person = new Person(2, "zxx");
		personMgr.save(person);
	}

	@Test
	public void testSelect() {
		Person person = personMgr.getPerson(1);
		System.out.println(person.getName());
	}

	@Test
	public void testUpdate() {
		Person person = personMgr.getPerson(1);
		person.setName("wgy");
		personMgr.update(person);
	}

	@Test
	public void testGetPersons() {
		List<Person> persons = personMgr.getPersons();
		for(Person person : persons) {
			System.out.println(person.getName());
		}
	}

	@Test
	public void testDelete() {
		personMgr.delete(1);
	}
}
