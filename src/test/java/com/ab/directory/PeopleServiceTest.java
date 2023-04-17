package com.ab.directory;

import com.ab.directory.model.Child;
import com.ab.directory.model.People;
import com.ab.directory.service.GenericChildService;
import com.ab.directory.service.GenericService;
import com.ab.directory.service.PeopleService;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class PeopleServiceTest {
    private Map<String, People> peopleMap ;
    private  People people ;
    @Before
    public void setUp(){
        peopleMap = new HashMap<>();
        people = new People();
        people.setName("Bhu Bhatt");
        people.setSpouceName("Bin Bhatt");
        people.setSsn("123456-9876");

        Child child1 = new Child();
        child1.setName("Ind Bha");
        child1.setDob("1960-05-02");
        Child child2 = new Child();
        child2.setName("Rin Bha");
        child2.setDob("1961-05-02");
        Child child3 = new Child();
        child3.setName("Cha Bha");
        child3.setDob("1970-06-20");

        TreeSet<Child> childTreeSet = new TreeSet<>();
        childTreeSet.add(child3);
        childTreeSet.add(child2);
        childTreeSet.add(child1);
        people.setChildern(childTreeSet);
        GenericService peppleService = new PeopleService();
        peppleService.save(people,peopleMap);

    }

    @Test
    public void getOldestChildName(){
        GenericChildService peopleService = new PeopleService();
        Child firstChild = (Child)peopleService.getFirstChild("123456-9876",peopleMap);
        assertEquals("Ind Bha",firstChild.getName());
    }

    @Test
    public void getAllChildren(){
        GenericChildService peopleChildService = new PeopleService();
        assertEquals(3,peopleChildService.getAllChildren("123456-9876",peopleMap).size());
    }

    @Test
    public void addSingleChild(){
        Child dadu = new Child();
        dadu.setName("dadu");
        dadu.setDob("1947-08-15");
        GenericChildService peopleChildService = new PeopleService();
        peopleChildService.addSingleChild("123456-9876",peopleMap,dadu);
        Child firstChild = (Child) peopleChildService.getFirstChild("123456-9876",peopleMap);
        assertEquals(4,peopleChildService.getAllChildren("123456-9876",peopleMap).size());
        assertEquals("dadu",firstChild.getName());
    }

}
