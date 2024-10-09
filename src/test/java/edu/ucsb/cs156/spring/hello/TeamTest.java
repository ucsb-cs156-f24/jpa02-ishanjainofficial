package edu.ucsb.cs156.spring.hello;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("f24-05");
        team.addMember("Ishan");
        team.addMember("Ben");
        team.addMember("Alex");
        team.addMember("William");
        team.addMember("Ryan");
        team.addMember("Beige"); 
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Team(name=f24-05, members=[Ishan, Ben, Alex, William, Ryan, Beige])", team.toString());
    }
   
    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team t = Developer.getTeam();
        assertEquals("f24-05", t.getName());
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=f24-05, members=[Ishan, Ben, Alex, William, Ryan, Beige])", team.toString());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Ishan"),"Team should contain Ishan");
        assertTrue(t.getMembers().contains("Ben"),"Team should contain Ben");
        assertTrue(t.getMembers().contains("Beige"),"Team should contain Beige");
        assertTrue(t.getMembers().contains("Ryan"),"Team should contain Ryan");
        assertTrue(t.getMembers().contains("William"),"Team should contain William");
        assertTrue(t.getMembers().contains("Alex"),"Team should contain Alex");
    }

   @Test
    public void test_same_object() {
        assertTrue(team.equals(team));
    }

    @Test
    public void test_different_classes() {
        String testTeam = "test-team";
        assertFalse(team.equals(testTeam));
    }

    @Test
    public void test_same_team_different_members() {
        Team t = new Team("test-team");
        team.addMember("foo");
        team.addMember("bar");
        assertFalse(team.equals(t));
    }

    @Test
    public void test_same_team_same_members() {
        Team t2 = new Team("f24-05");
        t2.addMember("Ishan");
        t2.addMember("Ben");
        t2.addMember("Alex");
        t2.addMember("William");
        t2.addMember("Ryan");
        t2.addMember("Beige"); 
        assertTrue(team.equals(t2));
    }

    @Test
    public void test_different_team_different_members() {
        Team t3 = new Team("test");
        t3.addMember("foo");
        assertFalse(team.equals(t3));
    }

    @Test
    public void test_hash_code_values() {
        ArrayList<String> first = new ArrayList<>();
        first.add("John");
        first.add("gian");
        first.add("Jack");

        ArrayList<String> second = new ArrayList<>();
        second.add("Pat");
        second.add("Mike");
        second.add("Adam");

        Team t1 = new Team("f24-01");
        Team t2 = new Team("f24-01");
        Team t3 = new Team("f24-02");
        Team t4 = new Team("f24-01");

        t1.setMembers(first);
        t2.setMembers(first);
        t3.setMembers(second);
        t4.setMembers(second);

        assertEquals(t1.hashCode(), t2.hashCode());
        assertNotEquals(t2.hashCode(), t3.hashCode());
        assertEquals(t3.hashCode(), t4.hashCode());
        assertNotEquals(t1.hashCode(), t3.hashCode());
    }
}