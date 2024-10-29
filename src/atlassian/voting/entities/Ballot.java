package src.atlassian.voting.entities;

import java.util.ArrayList;
import java.util.List;

public class Ballot {
    public List<Vote> votes;

    public Ballot(List<Candidate> cand) {
        votes = new ArrayList<>();
        for (Candidate s : cand){
            votes.add(new Vote(s));
        }
    }

}
