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
        team = new Team("test-team");
        team.addMember("Ishan");
        team.addMember("Ben");
        team.addMember("Alex");
        team.addMember("William");
        team.addMember("Ryan");
        team.addMember("Beige"); 
    }

    @Test
    public void getName_returns_correct_name() {
        assert(team.getName().equals("test-team"));
    }
   
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[Ishan, Ben, Alex, William, Ryan, Beige])", team.toString());
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
        String a = "test-team";
        assertFalse(team.equals(a));
    }

    @Test
    public void test_same_team_different_members() {
        Team t = new Team("test-team");
        team.addMember("foo");
        team.addMember("bar");
        assertFalse(team.equals(t)); // same name, different members
    }

    @Test
    public void test_SameMembers_Case() {
        Team t2 = new Team("test-team");
        Team t3 = new Team("diff-team");

        t2.addMember("Ishan");
        t2.addMember("Ben");
        t2.addMember("Alex");
        t2.addMember("William");
        t2.addMember("Ryan");
        t2.addMember("Beige");

        t3.addMember("Ishan");
        t3.addMember("Ben");
        t3.addMember("Alex");
        t3.addMember("William");
        t3.addMember("Ryan");
        t3.addMember("Beige");

        assertTrue(team.equals(t2)); // same team, same members
        assertEquals(team.equals(t3), false); // different name, same members
    }

    @Test
    public void test_DifferentTeam_DifferentMembers() {
        Team t3 = new Team("test");
        t3.addMember("foo");
        assertFalse(team.equals(t3)); // different name, different members
    }

    @Test
    public void test_Hash_Code() {
        ArrayList<String> members = new ArrayList<>();
        members.add("John");
        members.add("gian");
        members.add("Jack");

        ArrayList<String> members2 = new ArrayList<>();
        members2.add("Pat");
        members2.add("Mike");
        members2.add("Adam");

        Team t1 = new Team("test-01");
        Team t2 = new Team("test-01");
        Team t3 = new Team("test-02");
        Team t4 = new Team("test-01");
        Team t5 = new Team("diff-team");

        t1.setMembers(members);
        t2.setMembers(members);
        t3.setMembers(members);
        t4.setMembers(members2);

        assertEquals(t1.hashCode() == t2.hashCode(), true); // same name, same members
        assertEquals(t1.hashCode() == t3.hashCode(), false); // different name, same members
        assertEquals(t1.hashCode() == t4.hashCode(), false); // same name, different members
        assertEquals(t1.hashCode() == t5.hashCode(), false); // different name, different members
    }

    @Test
    public void coverMutationEdgeCase(){
        Team team = new Team("test-team");
        assertEquals(team.hashCode(), -1226298695);
    }
}