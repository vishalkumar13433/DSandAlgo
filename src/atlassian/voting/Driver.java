package src.atlassian.voting;

import src.atlassian.voting.entities.Ballot;
import src.atlassian.voting.entities.Candidate;
import src.atlassian.voting.logic.IVotingMachine;
import src.atlassian.voting.logic.VotingMachine;

import java.util.*;

public class Driver {
    public static void main(String[] args) {
        Map<Integer, Integer> rankScores=new HashMap<>();
        rankScores.put(1,3);
        rankScores.put(2,2);
        rankScores.put(3,1);
        IVotingMachine machine = new VotingMachine(rankScores);

        Candidate candidate1 = new Candidate("Vishal");
        Candidate candidate2 = new Candidate("Swap");
        Candidate candidate3 = new Candidate("Tanuj");
        Candidate candidate4 = new Candidate("abc");
        Candidate candidate5 = new Candidate("def");

        List<Ballot> ballots = new ArrayList<>();
        ballots.add(new Ballot(Arrays.asList(candidate1, candidate2, candidate3)));
        ballots.add(new Ballot(Arrays.asList(candidate1, candidate3, candidate2)));
        ballots.add(new Ballot(Arrays.asList(candidate3, candidate2, candidate4)));
        ballots.add(new Ballot(Arrays.asList(candidate3, candidate4, candidate2)));
        ballots.add(new Ballot(Arrays.asList(candidate1, candidate4, candidate5)));

        List<String> result = machine.getResults(ballots);
        for (String candidate: result) {
            System.out.println(candidate + "->");
        }
    }
}
