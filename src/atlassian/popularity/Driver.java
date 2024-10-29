package src.atlassian.popularity;

public class Driver {
    public static void main(String[] args) {
        IPopularity popularityTracker = new Popularity();
//        popularityTracker.increasePopularity(7);
//        popularityTracker.increasePopularity(7);
//        popularityTracker.increasePopularity(8);
//        System.out.println(popularityTracker.mostPopular());  // returns 7

        popularityTracker.increasePopularity(7);
        popularityTracker.increasePopularity(8);
        System.out.println(popularityTracker.mostPopular());    // returns 7
        popularityTracker.increasePopularity(8);
        popularityTracker.increasePopularity(8);
        System.out.println(popularityTracker.mostPopular());    // returns 8
        popularityTracker.decreasePopularity(8);
        popularityTracker.decreasePopularity(8);
        System.out.println(popularityTracker.mostPopular());    // returns 7
        popularityTracker.decreasePopularity(7);
        popularityTracker.decreasePopularity(7);
        popularityTracker.decreasePopularity(8);
        System.out.println(popularityTracker.mostPopular());    // returns -1 since popularity of all content is 0

        // TODO:: if interviewer wants 0(1) for all ,this is converted to
//        https://leetcode.com/problems/all-oone-data-structure/description/
    }
}
