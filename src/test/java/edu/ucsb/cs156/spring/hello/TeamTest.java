package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

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

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_true_with_same_obj() {
        Team sameTeam = team;
        assertTrue(team.equals(sameTeam));
    }

    @Test
    public void equals_false_with_non_team_obj() {
        Object notTeam = new Object();
        assertFalse(team.equals(notTeam));
    }

    @Test
    public void equals_true_with_equal_vars() {
        Team team1 = new Team("test-team");
        Team team2 = new Team("test-team");
        team1.addMember("member");
        team2.addMember("member");
        assertTrue(team1.equals(team2));
    }

    @Test
    public void equals_false_with_unequal_name() {
        Team team1 = new Team("test-team-a");
        Team team2 = new Team("test-team-b");
        team1.addMember("member1");
        team2.addMember("member1");
        assertFalse(team1.equals(team2));
    }

    @Test
    public void equals_false_with_unequal_members() {
        Team team1 = new Team("test-team-a");
        Team team2 = new Team("test-team-a");
        team1.addMember("member1");
        team2.addMember("member2");
        assertFalse(team1.equals(team2));
    }

    @Test
    public void equals_false_with_unequal_name_and_members() {
        Team team1 = new Team("test-team-a");
        Team team2 = new Team("test-team-b");
        team1.addMember("member1");
        team2.addMember("member2");
        assertFalse(team1.equals(team2));
    }

    @Test
    public void hashCode_equal_with_equal_vars() {
        Team team1 = new Team();
        team1.setName("foo");
        team1.addMember("bar");
        Team team2 = new Team();
        team2.setName("foo");
        team2.addMember("bar");
        assertEquals(team1.hashCode(), team2.hashCode());
    }

    // Test to get around the equivalent mutation problem with hashCode.
    @Test
    public void hashCode_kill_the_survivors() {
        Team team = new Team();
        int result = team.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }

}
