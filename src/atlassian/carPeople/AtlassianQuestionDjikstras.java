package src.atlassian.carPeople;

import java.util.*;


public class AtlassianQuestionDjikstras {

    /*
You and your friends are driving to a Campground to go camping. Only 2 of you have cars, so you will be carpooling.

Routes to the campground are linear, so each location will only lead to 1 location and there will be no loops or detours. Both cars will leave from their starting locations at the same time. The first car to pass someone's location will pick them up. If both cars arrive at the same time, the person can go in either car.

Roads are provided as a directed list of connected locations with the duration (in minutes) it takes to drive between the locations.
[Origin, Destination, Duration it takes to drive]

Given a list of roads, a list of starting locations and a list of people/where they live, return a collection of who will be in each car upon arrival to the Campground.
------------------------------------------------------
Bridgewater--(30)-->Caledonia--(15)-->New Grafton--(5)-->Campground
                                       ^
Liverpool---(10)---Milton-----(30)-----^

roads1 = [
    ["Bridgewater", "Caledonia", "30"], <= The road from Bridgewater to Caledonia takes 30 minutes to drive.
    ["Caledonia", "New Grafton", "15"],
    ["New Grafton", "Campground", "5"],
    ["Liverpool", "Milton", "10"],
    ["Milton", "New Grafton", "30"]
]
starts1 = ["Bridgewater", "Liverpool"]
people1 = [
    ["Jessie", "Bridgewater"], ["Travis", "Caledonia"],
    ["Jeremy", "New Grafton"], ["Katie", "Liverpool"]
]

Car1 path: (from Bridgewater): [Bridgewater(0, Jessie)->Caledonia(30, Travis)->New Grafton(45)->Campground(50)]
Car2 path: (from Liverpool): [Liverpool(0, Katie)->Milton(10)->New Grafton(40, Jeremy)->Campground(45)]

Output (In any order/format):
    [Jessie, Travis], [Katie, Jeremy]
--------------------------------------
Riverport->Chester->Campground
             ^
Halifax------^

roads2 = [["Riverport", "Chester", "40"], ["Chester", "Campground", "60"], ["Halifax", "Chester", "40"]]
starts2 = ["Riverport", "Halifax"]
people2 = [["Colin", "Riverport"], ["Sam", "Chester"], ["Alyssa", "Halifax"]]

Output (In any order/format):
    [Colin, Sam], [Alyssa] OR [Colin], [Alyssa, Sam]
----------------------------------------
Riverport->Bridgewater->Liverpool->Campground

roads3 = [["Riverport", "Bridgewater", "1"], ["Bridgewater", "Liverpool", "1"], ["Liverpool", "Campground", "1"]]
starts3_1 = ["Riverport", "Bridgewater"]
starts3_2 = ["Bridgewater", "Riverport"]
starts3_3 = ["Riverport", "Liverpool"]
people3 = [["Colin", "Riverport"], ["Jessie", "Bridgewater"], ["Sam", "Liverpool"]]

Output (starts3_1/starts3_2):  [Colin], [Jessie, Sam] - (Cars can be in any order)
Output (starts3_3): [Jessie, Colin], [Sam]
----------------------------------------
All Test Cases: (Cars can be in either order)
carpool(roads1, starts1, people1) => [Jessie, Travis], [Katie, Jeremy]
carpool(roads2, starts2, people2) => [Colin, Sam], [Alyssa] OR [Colin], [Alyssa, Sam]
carpool(roads3, starts3_1, people3) => [Colin], [Jessie, Sam]
carpool(roads3, starts3_2, people3) => [Jessie, Sam], [Colin]
carpool(roads3, starts3_3, people3) => [Jessie, Colin], [Sam]
----------------------------------------
Complexity Variable:
n = number of roads
*/

    public static void main(String[] argv) {
        AtlassianQuestionDjikstras questionDjikstras = new AtlassianQuestionDjikstras();
        String[][] roads1 = {
                {"Bridgewater", "Caledonia", "30"}, {"Caledonia", "New Grafton", "15"},
                {"New Grafton", "Campground", "5"}, {"Liverpool", "Milton", "10"},
                {"Milton", "New Grafton", "30"}
        };
        String[] starts1 = {"Bridgewater", "Liverpool"};
        String[][] people1 = {
                {"Jessie", "Bridgewater"}, {"Travis", "Caledonia"},
                {"Jeremy", "New Grafton"}, {"Katie", "Liverpool"}
        };
        // [Jessie, Travis], [Katie, Jeremy]

//        INPUT:2
        String[][] roads2 = {{"Riverport", "Chester", "40"}, {"Chester", "Campground", "60"}, {"Halifax", "Chester", "40"}};
        String[] starts2 = {"Riverport", "Halifax"};
        String[][] people2 = {{"Colin", "Riverport"}, {"Sam", "Chester"}, {"Alyssa", "Halifax"}};
//
//        INPUT:3
        String[][] roads3 = {{"Riverport", "Bridgewater", "1"}, {"Bridgewater", "Liverpool", "1"}, {"Liverpool", "Campground", "1"}};
        String[] starts3_1 = {"Riverport", "Bridgewater"};
        String[] starts3_2 = {"Bridgewater", "Riverport"};
        String[] starts3_3 = {"Riverport", "Liverpool"};
        String[][] people3 = {{"Colin", "Riverport"}, {"Jessie", "Bridgewater"}, {"Sam", "Liverpool"}};

        questionDjikstras.carPersons(roads1, starts1, people1);
    }

    class CityDistancePair {
        public int city;
        public int distance;
        public int car;

        public CityDistancePair(int c, int d, int car) {
            this.city = c;
            this.distance = d;
            this.car = car;
        }
    }

    Map<String, Integer> cityNumMap;
    private List<List<String>> carPersons(String[][] roads, String[] starts1, String[][] people1) {
        cityNumMap = new HashMap<>();
        int[][] graph = buildDAG(roads);

        int[] cityTimes = new int[graph.length];
        int[] cars = new int[graph.length];
        Arrays.fill(cityTimes, Integer.MAX_VALUE);

        PriorityQueue<CityDistancePair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        int car = 0;
        for (String start : starts1) {
            int city = cityNumMap.get(start);
            cityTimes[city] = 0;
            cars[city] = car++;
            pq.add(new CityDistancePair(city, 0, cars[city]));
        }
        doDjiktras(graph, cityTimes, pq, cars);
        List<String> car1 = new ArrayList<>();
        List<String> car2 = new ArrayList<>();
        for (int i=0; i< people1.length;i++) {
            String city =  people1[i][1];
            int assignedCar = cars[cityNumMap.get(city)];
            if (assignedCar == 0) {
                car1.add(people1[i][0]);
            } else {
                car2.add(people1[i][0]);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        ans.add(car1);
        ans.add(car2);
        return ans;
    }

    private void doDjiktras(int[][] graph, int[] cityTimes, PriorityQueue<CityDistancePair> pq, int[] cars) {
        while (!pq.isEmpty()) {
            CityDistancePair curStop = pq.poll();
            int city = curStop.city;
            int curDistance = curStop.distance;
            int car = curStop.car;

            for (int dest=0; dest< graph[city].length;dest++) {
                if (graph[city][dest] > 0) {
                    if (cityTimes[dest] > curDistance + graph[city][dest]) {
                        cityTimes[dest] = curDistance + graph[city][dest];
                        cars[dest] = car;
                    }
                    pq.add(new CityDistancePair(dest, cityTimes[dest], car));
                }
            }
        }
    }

    private  int[][] buildDAG(String[][] roads1) {
        int[][] graph = new int[roads1.length+1][roads1.length+1];
        int cnt = 0;
        for (int i=0; i< roads1.length;i++) {
            Integer num =  cityNumMap.get(roads1[i][0]);
            if (num == null ){
                num = cnt;
                cityNumMap.put(roads1[i][0], cnt++);
            }
            Integer num2 =  cityNumMap.get(roads1[i][1]);
            if (num2 == null ){
                num2 = cnt;
                cityNumMap.put(roads1[i][1], cnt++);
            }
            graph[num][num2] = Integer.parseInt(roads1[i][2]);
        }
        return graph;
    }
}
