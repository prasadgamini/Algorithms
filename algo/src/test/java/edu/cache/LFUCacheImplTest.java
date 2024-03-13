package edu.cache;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LFUCacheImplTest {

    @Test
    public void testPutGet1() {
        Cache cache = new LFUCacheImpl(3);
        cache.put(1,10);
        cache.put(2,20);
        cache.put(3,30);
        assertEquals(10, cache.get(1));
        assertEquals(20, cache.get(2));
        assertEquals(30, cache.get(3));
    }

    @Test
    public void testPutGet2() {
        Cache cache = new LFUCacheImpl(3);
        cache.put(1,10);
        cache.put(2,20);
        cache.put(3,30);
        assertEquals(10, cache.get(1));
        assertEquals(20, cache.get(2));
        assertEquals(30, cache.get(3));

        cache.get(2);
        cache.get(3);
        cache.put(4,40);
        assertEquals(-1, cache.get(1));
        assertEquals(40, cache.get(4));

        cache.get(2);
        cache.get(3);
        cache.put(5,50);
        assertEquals(-1, cache.get(4));
    }


}