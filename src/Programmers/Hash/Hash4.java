package Programmers.Hash;

import java.util.*;

public class Hash4 {
    public static void main(String[] args) {
        solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
    }

    public static int[] solution(String[] genres, int[] plays) {
        int size = genres.length;
        ArrayList<Music> musicArrayList = new ArrayList<>();    //각 노래별 재생 횟수 Arr
        ArrayList<Music> totalMusic = new ArrayList<>();    //장르별 전체 재생 횟수 Arr

        for (int i = 0; i < size; i++) {
            musicArrayList.add(new Music(i, genres[i], plays[i]));
        }
        //고유번호(순서값)를 가진 MusicArr을 재생횟수를 기준으로 내림차순정렬
        Collections.sort(musicArrayList);

        //<장르, 재생횟수>로 이루어진 HashMap
        HashMap<String, Long> totalCntMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            totalCntMap.put(genres[i], totalCntMap.getOrDefault(genres[i], 0L) + plays[i]);
        }

        //<장르, 전체 재생횟수> 집합을 ArrayList에 만들어 내림차순정렬
        totalCntMap.keySet().forEach(title -> totalMusic.add(new Music(title, totalCntMap.get(title))));
        Collections.sort(totalMusic);

        //장르별로 2가지 노래씩 담아야 함 -> 장르집합 * 2개의 저장공간 필요
        ArrayList<Integer> result = new ArrayList<>();

        //전체 재생횟수 내림차순정렬 되어있기 때문에 장르가 같을 경우 가장 먼저 나오는 Music 객체의 값으로 answer 배열에 추가
        for (int i = 0; i < totalCntMap.keySet().size(); i++) {
            int full = 0;
            for (int j = 0; j < size; j++) {
                if (totalMusic.get(i).getTitle().equals(musicArrayList.get(j).getTitle())) {
                    result.add(musicArrayList.get(j).getId());
                    full++;
                }
                if (full == 2) break;
            }
        }
        int resultSize = result.size();
        int[] answer = new int[resultSize];
        for (int i = 0; i < resultSize; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    static class Music implements Comparable<Music> {
        int id;
        String title;
        long count;

        public Music(int id, String title, long count) {
            this.id = id;
            this.title = title;
            this.count = count;
        }

        public Music(String title, long count) {
            this.title = title;
            this.count = count;
        }

        public String getTitle() {
            return title;
        }

        public int getId() {
            return id;
        }

        @Override
        public int compareTo(Music o) {
            if (o.count == count) return id - o.id;
            return (int) (o.count - count);
        }
    }
}
