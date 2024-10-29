Problem Description
--------------------------

Imagine you are given a stream of content ids along with an associated action to be performed on them.

Example of contents are video, pages, posts, etc. There can be two actions associated with a content id:

increasePopularity → increases the popularity of the content by 1. The popularity increases when someone comments on the content or likes the content.

decreasePopularity → decreases the popularity of the content by 1. The popularity decreases when a spam bot's/users comments are deleted from the content or its likes are removed from the content.

content ids are positive integers

Implement a class that can return the mostPopular content id at any time while consuming the stream of content ids and its associated action.
If there are no contentIds with popularity greater than 0, return -1.


interface MostPopular {
    void increasePopularity(Integer contentId);
    Integer mostPopular();
    void decreasePopularity(Integer contentId);
}

popularityTracker.increasePopularity(7);
popularityTracker.increasePopularity(7);
popularityTracker.increasePopularity(8);
popularityTracker.mostPopular();  // returns 7


popularityTracker.increasePopularity(7);
popularityTracker.increasePopularity(8);
popularityTracker.mostPopular();    // returns 7
popularityTracker.increasePopularity(8);
popularityTracker.increasePopularity(8);
popularityTracker.mostPopular();    // returns 8
popularityTracker.decreasePopularity(8);
popularityTracker.decreasePopularity(8);
popularityTracker.mostPopular();    // returns 7
popularityTracker.decreasePopularity(7);
popularityTracker.decreasePopularity(7);
popularityTracker.decreasePopularity(8);
popularityTracker.mostPopular();    // returns -1 since popularity of all content is 0


Clarifications

The above sample code is NOT complete. The candidate should clarify and gather the below requirements:

mostPopular method might be called even without adding any content. Return -1 in this case since content ids are always 
positive.
In case of a tie, the candidate can return any content id randomly with most popularity.
Edge case identification, if not, point it out during implementation:

Ensure that the popularity cannot be negative because the decreasePopularity will only be called if the increasePopularity
was called for that content id in the past.
