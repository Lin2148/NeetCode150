class Twitter {
    private Map<Integer, Set<Integer>> followMap = new HashMap<>();
    private Map<Integer, Tweet> tweetMap = new HashMap<>();
    private int time;
    
    public Twitter() {
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(tweetId,time++);
        newTweet.old = tweetMap.get(userId);
        tweetMap.put(userId, newTweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);

        //加自己跟follow的
        Set<Integer> targetUsers = new HashSet<>();
        targetUsers.add(userId); 
        if (followMap.containsKey(userId)) {
            targetUsers.addAll(followMap.get(userId));
        }

        for (int user:targetUsers){
            Tweet tweetHead = tweetMap.get(user);
            if (tweetHead != null) {
                pq.offer(tweetHead);
            }
        }

    int count = 0;
    while (!pq.isEmpty() && count < 10) {
        Tweet cur = pq.poll();   
        result.add(cur.id);      
        count++;
        
        if (cur.old != null) {
            pq.offer(cur.old);
        }
    }
    
    return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId){
            return;
        }
        // 第一次追蹤建立set
        followMap.putIfAbsent(followerId, new HashSet<>());


        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.get(followerId) != null){
            followMap.get(followerId).remove(followeeId);
        }
    }
}
class Tweet {
    int id;
    int time;
    Tweet old; 
    
    Tweet(int id, int time) {
        this.id = id;
        this.time = time;
    }
}
/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */