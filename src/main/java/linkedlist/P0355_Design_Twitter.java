package linkedlist;

import common.ListNode;

import java.util.*;

public class P0355_Design_Twitter {
    Map<Integer, Set<Integer>> users;
    Tweet head = new Tweet(0,0,null);
    public P0355_Design_Twitter() {
        this.head = null;
        this.users = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        head = new Tweet(tweetId, userId, head != null ? head : null);
    }

    public List<Integer> getNewsFeed(int userId) {
        Tweet curr = head;
        List<Integer> ans = new LinkedList<>();
        Set<Integer> follows = users.getOrDefault(userId, Collections.emptySet());
        int i = 0;
        while (curr != null && i < 10) {
            if (curr.userId == userId || follows.contains(curr.userId)) {
                ans.add(curr.id);
                i++;
            }
            curr = curr.next;
        }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> follows = users.getOrDefault(followerId, new HashSet<>());
        follows.add(followeeId);
        users.put(followerId, follows);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            return;
        }
        Set<Integer> follows = users.get(followerId);
        follows.remove(followeeId);
    }
    public static class Tweet {
        int id;
        int userId;
        Tweet next;

        public Tweet(int id, int userId, Tweet next) {
            this.id = id;
            this.userId = userId;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        var obj = new P0355_Design_Twitter();
        obj.postTweet(1, 5);
        obj.postTweet(1, 3);
        obj.postTweet(1, 101);
        obj.postTweet(1, 13);
        obj.postTweet(1, 10);
        obj.postTweet(1, 2);
        obj.postTweet(1, 94);
        obj.postTweet(1, 505);
        obj.postTweet(1, 333);
        obj.postTweet(1, 22);
        obj.postTweet(1, 11);
        System.out.println(obj.getNewsFeed(1));
    }
}
