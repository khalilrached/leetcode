package org.example;

import java.util.HashMap;
import java.util.List;

public class Main {
    class Solution {
        // 
        public static int bestTeamScore(int[] scores, int[] ages) {
            int score = 0,conflict_key = 0,oldest_player_age = ages[0],oldest_player_score = scores[0];
            HashMap<Integer,Integer> highest_score = new HashMap<>();
            for(int i = 0;i<scores.length;i++){
                if(ages[i]>oldest_player_age) { oldest_player_age = ages[i]; oldest_player_score = scores[i]; }
                if(scores[i] > oldest_player_score && ages[i] < oldest_player_age) {
                    // conflict
                    highest_score.put(conflict_key,score);
                    conflict_key++;
                    oldest_player_age = ages[0];
                    oldest_player_score = scores[0];
                    i = i-1;
                }else {
                    score += scores[i];
                }
            }
            highest_score.put(conflict_key,score);
            return highest_score.values().stream().mapToInt(v -> v).max().orElseThrow(java.util.NoSuchElementException::new);
        }
    }
    public static void main(String[] args) {
        int[] ages = {2,1,2,1};
        int[] scores = {4,5,6,5};

        System.out.println("highest score: "+Solution.bestTeamScore(scores,ages));
    }
}