package src.atlassian.voting.logic;

import src.atlassian.voting.entities.Ballot;
import src.atlassian.voting.entities.Vote;

import java.util.*;

public class VotingMachine implements IVotingMachine{
    Map<String, Integer> candidateScore;
    Map<Integer, Integer> rankToScoreMap;

    public VotingMachine(Map<Integer, Integer> rankToScoreMap) {
        candidateScore = new HashMap<>();
        this.rankToScoreMap = rankToScoreMap;
    }
    @Override
    public List<String> getResults(List<Ballot> ballots) {
        for (Ballot ballot: ballots) {
            updateScoreForVotee(ballot, candidateScore);
        }
        PriorityQueue<String> leaderboard = new PriorityQueue<>((a,b) -> candidateScore.getOrDefault(b,0) - candidateScore.getOrDefault(a,0));
        for (String key: candidateScore.keySet()) {
            leaderboard.offer(key);
        }
        List<String> result = new ArrayList<>();
        while (!leaderboard.isEmpty()){
            result.add(leaderboard.poll());
        }
        return result;
     }

    private void updateScoreForVotee(Ballot ballot, Map<String, Integer> candidateScore) {
        int rank = 1;
        for (Vote vote: ballot.votes) {
            candidateScore.put(vote.candidate.name, rankToScoreMap.get(rank) + candidateScore.getOrDefault(vote.candidate.name, 0));
            rank++;
        }
    }
}
