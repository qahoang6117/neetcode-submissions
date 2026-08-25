

class Twitter {

    private Map<Integer, Set<Integer>> following;

    private Map<Integer, List<Tweet>> tweets;

    private int time;

    private static class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {

        tweets.putIfAbsent(userId, new ArrayList<>());

        tweets.get(userId).add(
            new Tweet(tweetId, time)
        );

        time++;
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> res = new ArrayList<>();

        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.time, a.time)
        );

        // Tweet của chính user
        if (tweets.containsKey(userId)) {
            maxHeap.addAll(tweets.get(userId));
        }

        // Tweet của những người user đang follow
        if (following.containsKey(userId)) {

            for (int followeeId : following.get(userId)) {

                if (tweets.containsKey(followeeId)) {
                    maxHeap.addAll(tweets.get(followeeId));
                }
            }
        }

        // Lấy tối đa 10 tweet mới nhất
        while (!maxHeap.isEmpty() && res.size() < 10) {
            res.add(maxHeap.poll().tweetId);
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {

        following.putIfAbsent(
            followerId,
            new HashSet<>()
        );

        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}