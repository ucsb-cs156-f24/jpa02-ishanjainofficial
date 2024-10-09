package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("f24-05", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Ishan"),"Team should contain Ishan");
        assertTrue(t.getMembers().contains("Ben"),"Team should contain Ben");
        assertTrue(t.getMembers().contains("Beige"),"Team should contain Beige");
        assertTrue(t.getMembers().contains("Ryan"),"Team should contain Ryan");
        assertTrue(t.getMembers().contains("William"),"Team should contain William");
        assertTrue(t.getMembers().contains("Alex"),"Team should contain Alex");
    }
}
