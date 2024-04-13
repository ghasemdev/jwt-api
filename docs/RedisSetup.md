## Running a Basic Redis Container

### 1. Pull the Redis Image

```Bash
docker pull redis
```

### 2. Run the Redis Container

```Bash
docker run --name jwt-redis -p 6379:6379 -v /docker/host/dir:/data -d redis redis-server --save 60 1 --loglevel warning
```

## Verifying the Installation

### 1. Check Running Containers

```Bash
docker ps -a
```

### 2. Connect to Redis (Optional)

```Bash
docker exec -it jwt-redis redis-cli
```

## Adding Data (Create):

- Strings: Use `SET` command followed by the key and value.
- Lists: Use `LPUSH` (left-push) or `RPUSH` (right-push) to add elements.
- Sets: Use `SADD` to add members to a set.
- Hashes: Use `HSET` to add key-value pairs to a hash.
- Sorted Sets (ZSets): Use `ZADD` to add members with scores.

## Retrieving Data (Read):

- Strings: Use `GET` to retrieve the value associated with a key.
- Lists: Use commands like `LRANGE` (get elements within a range), `LINDEX` (get element at specific index), etc.
- Sets: Use `SMEMBERS` to get all members of a set.
- Hashes: Use `HGET` to retrieve the value of a specific field within a hash, or `HGETALL` to get all key-value pairs.
- Sorted Sets (ZSets): Use commands like `ZRANGE` (get elements within a specific score range), `ZRANK` (get the rank of a
  member), etc.

## Updating Data (Update):

- Strings: Use `SET` again to overwrite the existing value with a new one.
- Lists: Use commands like `LSET` (set the value of an element at a specific index), `LTRIM` (remove elements outside a
  specific range), etc.
- Sets: Use `SREM` to remove members from a set, and SADD to add new ones (effectively updating the set membership).
- Hashes: Use `HSET` again to update the value of an existing field within a hash or `HINCRBY` (increment a numeric field
  value).
- Sorted Sets (ZSets): Use `ZADD` again to update the score of an existing member or remove it using `ZREM` and re-add with
  the new score.

## Deleting Data (Delete):

- Strings: Use `DEL` to remove the key-value pair.
- Lists: Use commands like `LPOP` (remove and return the first element), RPOP (remove and return the last element), etc.
- Sets: Use `SREM` to remove specific members from a set.
- Hashes: Use `HDEL` to remove specific fields from a hash.
- Sorted Sets (ZSets): Use `ZREM` to remove members based on their names.
