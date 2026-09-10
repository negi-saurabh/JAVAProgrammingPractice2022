package com.saurabh.practice.prepforboo.topkhotels;


import java.util.*;

public class TopKHotel{

    public static List<Hotel> getTopK(List<Hotel> hotelList, int k){

        if (k <= 0) {
            return Collections.emptyList();
        }
        PriorityQueue<Hotel> minHeap = new PriorityQueue<>(Comparator.comparingDouble((Hotel h)->h.score())
                .thenComparing(h->h.name(), Comparator.reverseOrder()));

        List<Hotel> result = new ArrayList<>();

        for (Hotel hotel: hotelList) {
            minHeap.offer(hotel);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }

        Collections.reverse(result);
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        List<Hotel> hotelList = new ArrayList<>();
        hotelList.add(new Hotel("abx", 1.5));
        hotelList.add(new Hotel("cbb", 3.5));
        hotelList.add(new Hotel("ttt", 4.9));
        hotelList.add(new Hotel("erw", 1.5));
        hotelList.add(new Hotel("yyy", 3.5));
        hotelList.add(new Hotel("wer", 4.9));
        hotelList.add(new Hotel("uuu", 1.1));
        hotelList.add(new Hotel("cbb", 1.5));
        hotelList.add(new Hotel("ikk", 1.0));

        List<Hotel> topThree = getTopK(hotelList, 14);

        for (Hotel hotel: topThree){
            System.out.println(hotel.name()+":: Score:: " + hotel.score());
        }


    }
}
