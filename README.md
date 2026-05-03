Overview
 This is basically a backend project with Spring Boot, PostgreSQL, Redis, and Docker. It is a very similar to social medio post area with the 
 create post ,comment, like and interation with the user and the bot.

 Features
Create and manage posts
Track engagement (likes, comments, bot interactions)
Redis-based atomic operations for concurrency
Bot activity limit control
Fully containerized setup using Docker

Thread Safety (Atomic Locks - Phase 2)
In this phase I implemented atomic locking using Redis-based operations in which the uses Redis atomic commands such as:
redis.opsForValue().increment("post:" + postId + ":score", score) and most importantly they are use of variable which is being used to encounter the 
bot and the comment is being done by the user or the bot To control bot activity, an atomic counter is used:
Long botCount = redis.opsForValue().increment("post:" + postId + ":bot_count");
if (botCount > 100) {
    throw new RuntimeException("Too many bot replies");
}
This ensures:
Each request gets a unique incremented value
No duplicate or skipped counts
Limit is enforced safely even under high concurrency
