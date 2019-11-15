import java.lang.reflect.Array;
import java.util.*;  


// There are two properties in the node student id and scores, to
// ensure that each student will have at least 5 points, find the 
// average of 5 highest scores for each person.


class Record {
    public int id, score;
    public Record(int id, int score){
     this.id = id;
     this.score = score;
    }
}
public class HighFive {
    public HashMap<Integer, Double> highFive(Record[] results) {
        
        HashMap<Integer, Double> ret = new HashMap<>();
        
        HashMap<Integer, ArrayList<Integer> > map = new HashMap<>();
        for (Record r: results) {
            if (!map.containsKey(r.id)) {
                ArrayList<Integer> scoreList = new ArrayList<>();
                scoreList.add(r.score);
                map.put(r.id, scoreList);
                ret.put(r.id, 0.0);
            } else {
                // Keep top 5 scores only
                ArrayList<Integer> listScores = map.get(r.id);
                if (listScores.size() > 4) {
                    maintainTopFive(listScores, r.score);
                } else {
                    listScores.add(r.score);
                }
                map.put(r.id, listScores);
            }
        }

        for (int key: map.keySet()) {
            double average = getAverage(map.get(key));
            ret.put(key, average);
        }

        return ret;
    }

    public double getAverage(ArrayList<Integer> scores) {
        double ret = 0.0;
        for (int score: scores) {
            ret += score;
        }
        return ret/scores.size();
    }

    public void maintainTopFive(ArrayList<Integer> list, int score) {
        if (score > Collections.min(list)) {
            int index = list.indexOf(Collections.min(list));
            list.set(index, score);
        }
    }
    public static void main(String[] args) {
        Record[] res = new Record[10];

        // // Test Case 1:
        res[0] = new Record(1, 91);
        res[1] = new Record(1, 92);
        res[2] = new Record(2, 93);
        res[3] = new Record(2, 99);
        res[4] = new Record(2, 98);
        res[5] = new Record(2, 97);
        res[6] = new Record(1, 60);
        res[7] = new Record(1, 58);
        res[8] = new Record(2, 100);
        res[9] = new Record(1, 61);


        HighFive s = new HighFive();
        System.out.println(s.highFive(res));
        // Should return [[1, 72.4], [2, 97.4]]

////////////////////////////////////////////////////////////

        // Test Case 2
        res = new Record[6];

        res[0] = new Record(1, 90);
        res[1] = new Record(1, 90);
        res[2] = new Record(1, 90);
        res[3] = new Record(1, 90);
        res[4] = new Record(1, 90);
        res[5] = new Record(1, 90);
        s = new HighFive();
        System.out.println(s.highFive(res));
        // Should return [[1, 90.0]]

////////////////////////////////////////////////////////////

        // Test Case 3
        res = new Record[6];
        res[0] = new Record(1, 90);
        res[1] = new Record(1, 90);
        res[2] = new Record(1, 90);
        res[3] = new Record(1, 90);
        res[4] = new Record(1, 90);
        res[5] = new Record(1, 85);
        s = new HighFive();
        System.out.println(s.highFive(res));
        // Should return [[1, 90.0]]
    }
}

