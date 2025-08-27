

import java.util.*;

public class Main {
    static class Photo {
        int id, votes, time;
        Photo(int id, int votes, int time) {
            this.id = id;
            this.votes = votes;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Photo> frames = new ArrayList<>();
        Map<Integer, Photo> inFrame = new HashMap<>();

        for (int t = 0; t < K; t++) {
            int id = sc.nextInt();

            if(inFrame.containsKey(id)){
                inFrame.get(id).votes++;
                continue;
            }
            if(frames.size() < N){
                Photo p = new Photo(id, 1, t);
                frames.add(p);
                inFrame.put(id, p);
                continue;
            }

            Photo tmp = null;
            for (Photo p : frames) {
                if(tmp == null || p.votes < tmp.votes || (p.votes == tmp.votes && p.time < tmp.time)){
                    tmp = p;
                }
            }

            inFrame.remove(tmp.id);
            frames.remove(tmp);

            Photo np = new Photo(id, 1, t);
            frames.add(np);
            inFrame.put(id, np);
        }

        List<Integer> result = new ArrayList<>();
        for(Photo p : frames) result.add(p.id);
        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        for (int x : result) sb.append(x).append(' ');
        System.out.println(sb.toString().trim());
    }
}
