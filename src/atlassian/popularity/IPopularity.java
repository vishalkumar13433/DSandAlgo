package src.atlassian.popularity;

public interface IPopularity {
        void increasePopularity(Integer contentId);
        Integer mostPopular();
        void decreasePopularity(Integer contentId);
}
