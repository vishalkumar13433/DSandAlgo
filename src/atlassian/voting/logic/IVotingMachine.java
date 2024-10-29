package src.atlassian.voting.logic;

import src.atlassian.voting.entities.Ballot;

import java.util.List;

public interface IVotingMachine {
    List<String> getResults(List<Ballot> ballots);
}
