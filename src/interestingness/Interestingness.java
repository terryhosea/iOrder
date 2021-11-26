//import java.util.*;
//
//
//class Thesis_Application {
//
//    // Utility Pair class for storing maximum distance
//    // Node with its distance
//    static class Pair<T,V> {
//        T first; // maximum distance Node
//        V second; // distance of maximum distance node
//
//        //Constructor
//        Pair(T first, V second) {
//            this.first = first;
//            this.second = second;
//        }
//    }
//
//    // This class represents a undirected graph using adjacency list
//    static class Graph {
//        int V; // No. of vertices
//        //LinkedList<Integer>[] adj; //Adjacency List - array of LinkedList<Integer>
//        Map<String, List<String>> adj = new HashMap<>();
//        // Constructor
//        Graph(int V) {
//            this.V = V;
//            /*
//                // Initializing Adjacency List
//                adj = new LinkedList[V];
//                for(int i = 0; i < V; ++i) {
//                    adj[i] = new LinkedList<Integer>();
//                }
//            */
//        }
//
//        // function to add an edge to graph
//        void addEdge(String s, String d) {
////            List<String> key = adj.get(s);
////            if (key != null) {
////                List<String> list = new List<String>();
////
////                adj.put(s, );
////            }
////            else {
////                adj.get(s).add(d); // Add d to s's list.
////            }
//            adj.putIfAbsent(s, new ArrayList<>());
//            adj.putIfAbsent(d, new ArrayList<>());
//
////            if(!d.isEmpty()) {
//                adj.get(s).add(d);
//                adj.get(d).add(s);
////            }
//
//
//            //adj[d].add(s); // Since the graph is undirected
//        }
//
//        void printGraph(){
//            for (Map.Entry<String, List<String>> entry : adj.entrySet()) {
//                System.out.println(entry.getKey() + ":" + entry.getValue().toString());
//            }
//        }
//
//
//        // method returns farthest node and its distance from node u
//        Pair<String, Integer> bfs(String u) {
////            int[] dis = new int[adj.size()];
//            Map<String, Integer> dis = new HashMap<>();
//            // mark all distance with -1
////            Arrays.fill(dis, -1);
//            for(String i: adj.keySet()) {
//                dis.put(i, -1);
//            }
//
//            Queue<String> q = new LinkedList<>();
//
//            q.add(u);
//
//            // distance of u from u will be 0
////            dis[u] = 0;
//            dis.put(u, 0);
//            while (!q.isEmpty()) {
//                String t = q.poll();
//
//                // loop for all adjacent nodes of node-t
//                for(int i = 0; i < adj.get(t).size(); ++i) {
////                for(String i: adj.get(t)){
////                    int v = adj[t].get(i);
//                    String v = adj.get(t).get(i);
//                    // push node into queue only if
//                    // it is not visited already
////                    if(dis[v] == -1) {
//                    if(dis.get(v) == -1) {
//                        q.add(v);
//                        // make distance of v, one more
//                        // than distance of t
////                        dis[v] = dis[t] + 1;
//                        dis.put(v, dis.get(t) + 1);
//                    }
//                }
//            }
//            System.out.println(dis);
//
//            int maxDis = 0;
//            String nodeIdx = "";
//
//            // get farthest node distance and its index
////            for(int i = 0; i < adj.size(); ++i) {
//            for(String i: adj.keySet()) {
//                if(dis.get(i) > maxDis) {
//                    maxDis = dis.get(i);
//                    nodeIdx = i;
//                }
//            }
//
//            return new Pair<String, Integer>(nodeIdx, maxDis);
//        }
//
//        // method prints longest path of given tree
//        void longestPathLength(String u) {
//            Pair<String, Integer> t1, t2;
//
//            // first bfs to find one end point of
//            // longest path
//            t1 = bfs(u);
//
//            // second bfs to find actual longest path
//            t2 = bfs(t1.first);
//
//            System.out.println("Longest path is from "+ t1.first
//                    + " to "+ t2.first +" of length "+t2.second);
//        }
//    }
//
//    // Driver code to test above methods
//    public static void main(String[] args){
//        // Create a graph given in the example
//
//        Graph graph = new Graph(10);
////        graph.addEdge(0, 1);
////        graph.addEdge(1, 2);
////        graph.addEdge(2, 3);
////        graph.addEdge(2, 9);
////        graph.addEdge(2, 4);
////        graph.addEdge(4, 5);
////        graph.addEdge(1, 6);
////        graph.addEdge(6, 7);
////        graph.addEdge(6, 8);
//
//        graph.addEdge("Corner", "Peach");
//        graph.addEdge("Corner", "Plum");
//        graph.addEdge("Peach", "Pomeg.");
//        graph.addEdge("Plum", "Pomeg.");
//        graph.addEdge("Pomeg.", "Winter");
//        graph.addEdge("Pomeg.", "Lotus");
//        graph.addEdge("Pomeg.", "Osman.");
//        graph.addEdge("Winter", "");
//        graph.addEdge("Lotus", "Chrys.");
//        graph.addEdge("Osman.", "Chrys.");
//        graph.addEdge("Chrys.", "");
////        graph.addEdge("Test", "Abc");
//
//
//        graph.printGraph();
//        graph.longestPathLength("Corner");
//    }
//}
package interestingness;

import java.util.*;
import java.lang.*;
import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;  

import od.MainClass;

class Interestingness {
    // private static Map<String, List<String>> generateGraph(String[] nodes, String[][] links) {

    //     Map<String, List<String>> graph =  new HashMap<>();

    //     for(int i = 0; i<nodes.length; i++){
    //         graph.put(nodes[i], Set.of(links[i]));
    //     }

    //     return graph;
    // }

    public static long factorial(int n){
        if(n == 1 || n <= 0){
            return 1;
        }

        long result = 1;

        for(int i = 2 ; i<= n; i++){
            result *= i;
        }
        return result;

    }

    public static long combinations(int n, int r){

        return factorial(n)/(factorial(r)*factorial(n-r));
    }

    public static String[] bfs(Map<String, List<String>> graph, String node){
        ArrayList<String> path = new ArrayList<>();
        ArrayList<String> visited = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(node);
        visited.add(node);

        while(queue.size() > 0) {
            String s = queue.remove();
            if (!node.equals(s)) {
                path.add(s);
            }

            List<String> nodeRelation = graph.get(s);
//            System.out.println("Test1: " + nodeRelation);

//            if(nodeRelation != null){
                for (String neighbour : nodeRelation) {
                    if (!visited.contains(neighbour)) {
                        visited.add(neighbour);
                        queue.add(neighbour);
                    }
                }
//            }

        }
//        System.out.println("path: " + path);
//        System.out.println("res: " + path.toArray(new String[path.size()]));
        //Convert arraylist to array
        return path.toArray(new String[path.size()]);
    }


//# Total complexity:
//
//# Assuming E as number of edge and V as number of vertices (where V is unique)
//# calculateInterestingness function's complexity is O(V)+ V*O(V+E) + O(V) + O(V choose 2)
//# Asymptotic notation: O(V+E)
//#O(M + (M^2/2)) where M is number of unique number of nodes so O(M^2)
//
//# M << N (Where M is number of unique values, n number of tuples in database)
    public static double calculateSingleInterestingness(Map<String, List<String>> graph, Map<String, Boolean> rescalingMethod) {
//        Map<String, String[]> graph = generateGraph(nodes, links);
//    System.out.println("graph: " + graph);
        Map<String, String[]> connections = new HashMap<>();
//
        for (String key : graph.keySet()) {
            connections.put(key, bfs(graph, key));
        }

        int pathCount = 0;
        for (String i: connections.keySet()){
            pathCount += connections.get(i).length;
        }
        System.out.println("graphSize: " + graph.size());
        int totalOfCombination = (int) combinations(graph.size(), 2);

        double result =  (float)pathCount  / totalOfCombination;
        System.out.println("Result = " + pathCount + " / " + totalOfCombination + " = " + result);

        double scaleFactor = 0;
        String printResult = "Result * scaleFactor = " + result + " * ";

        int longestPath = auxLongestPathDAG(graph);
        System.out.println("longestPathInGraph = " + longestPath);
        if(rescalingMethod.get("log")) {
            scaleFactor = Math.log10(longestPath);//(float)(totalOfCombination - pathCount)/totalOfCombination;
            System.out.println("scaleFactor (log) = log_base_10( longestPathInGraph ) = " + scaleFactor);
//            printResult += " - (" + totalOfCombination + " - " + pathCount+ ") / " + totalOfCombination;
        }
        else if(rescalingMethod.get("sqrt")) {
            scaleFactor = Math.sqrt(longestPath);//(float)(totalOfCombination - pathCount)/totalOfCombination;
            System.out.println("scaleFactor (sqrt) = sqrt( longestPathInGraph ) = " + scaleFactor);
//            printResult += " - (" + totalOfCombination + " - " + pathCount+ ") / " + totalOfCombination;
        }

        else if(rescalingMethod.get("square")) {
            scaleFactor = Math.pow(longestPath,2);//(float)(totalOfCombination - pathCount)/totalOfCombination;
            System.out.println("scaleFactor (square) = pow( longestPathInGraph, 2 ) = " + scaleFactor);
//            printResult += " - (" + totalOfCombination + " - " + pathCount+ ") / " + totalOfCombination;
        }
        result *= scaleFactor;
        printResult += scaleFactor + " = " + result + " \n";

        System.out.println(printResult);

        return result; //(float)Math.round(((float)pathCount  / totalOfCombination) * 1000) / 1000;
    }

    private static List<Double> calculateListInterestingness(List<Map<String, List<String>>> graphs, Map<String, Boolean> rescalingMethod) {
        List<Double> result = new ArrayList<Double>();

         for(int i = 0; i< graphs.size(); i++){
             System.out.println(graphs.get(i));
//             result[i] = calculateSingleInterestingness(graphs.get(i), rescalingMethod);
             result.add(calculateSingleInterestingness(graphs.get(i), rescalingMethod));
         }

        return result;
    }

    private static double avgConditionalInterestingness(List<Map<String, List<String>>> graphs, Map<String, Boolean> rescalingMethod){
        List<Double> interestingness = calculateListInterestingness(graphs, rescalingMethod);//new ArrayList<Double>();
        double sum = 0;


        for(int i = 0; i< interestingness.size(); i++){
//            double graphInterestingness = calculateSingleInterestingness(graphArray.get(i), rescalingMethod);
            sum += interestingness.get(i);
//            interestingness.add(graphInterestingness);

            System.out.println("Interestingness for graph " + i + " is: " + interestingness.get(i) + "\n");
        }

        double result = sum / interestingness.size();
        System.out.println("Average interestingness for all the graphs is: " + result);

        /*
            if(weightDifference) {
                result -= (sum - interestingness.size())/interestingness.size();
            }
         */

        return result;
    }

//    private static Map<String, Integer> longestPathFromNode(Map<String, Set<String>> singleOrder) {
//        Map<String, Integer> LongestPath = new HashMap<>();
//        for (String source :
//                singleOrder.keySet()) {
//            if (!LongestPath.containsKey(source)) {
//                dfsUtil(source, singleOrder, LongestPath);
//            }
//        }
////        System.out.println("LongestPath: " + LongestPath);
//        return LongestPath;
//    }

    //Compute complexity - TO DO
    private static Integer auxLongestPathDAG(Map<String, List<String>> singleOrder) {
        Map<String, Integer> LongestPath = new HashMap<>();

        //V*O(dsfUtil)
        for (String source : singleOrder.keySet()) {
            if (!LongestPath.containsKey(source)) {
                dfsUtil(source, singleOrder, LongestPath);
            }
        }

        return LongestPath.size() > 0 ? Collections.max(LongestPath.values()) : 0;
    }



    private static void dfsUtil(String node, Map<String, List<String>> singleOrder, Map<String, Integer> LongestPath) {
        LongestPath.put(node, 0);
        List<String> adj = singleOrder.get(node);
        for (String v : adj) {
            if (!LongestPath.containsKey(v)) {
                dfsUtil(v, singleOrder, LongestPath);
            }
            if (LongestPath.get(v) + 1 > LongestPath.get(node)) {
                LongestPath.put(node, LongestPath.get(v) + 1);
            }
        }
    }

    public static Map<String, Boolean> generateRescaleFlag(String flag, String[] flags){
        Map<String, Boolean> rescaleFlag = new HashMap<String, Boolean>();

        for(String i: flags){
            rescaleFlag.put(i, false);
            if(flag == i){
                rescaleFlag.put(i, true);
            }
        }

        return rescaleFlag;
    }

    public static List<Map<String, List<String>>> readMapFromCSV(String fileName) {
        // System.out.println("READMAPFROMCSV!!!!!!!!!");
        List<Map<String, List<String>>> res = new ArrayList<>();
        String fileDir = "../stats/" + fileName+ ".csv";
        try {  
            //parsing a CSV file into BufferedReader class constructor  
            BufferedReader br = new BufferedReader(new FileReader(fileDir));  
            String line; 
            while ((line = br.readLine()) != null){  
                String[] row = line.split(",");    // use comma as separator  
                // System.out.println(order[4]); 
                String rawOrder = row[4].substring(2, row[4].length()-3);
                String[] order = rawOrder.split(";");
                // System.out.println("Order[4]: " +Arrays.toString(order)  + "\n\n\n");
                for(String i: order) {
                    System.out.println(i);
                }
                System.out.println("\n\n");
            }  
        }   
        catch (IOException e) {  
            e.printStackTrace();  
        }  

        return res;
    }

    public static void main(String args[]) {
        MainClass.main(args);
        readMapFromCSV("orderGraph");
        /*

        //Generate testGraph1
        Map<String, Set<String>> testGraph1 = new HashMap<>();
        testGraph1.put("Corner", Set.of(new String[] {"Peach", "Plum"}));
        testGraph1.put("Peach", Set.of(new String[] {"Pomeg."}));
        testGraph1.put("Plum", Set.of(new String[] {"Pomeg."}));
        testGraph1.put("Pomeg.", Set.of(new String[] {"Winter","Lotus","Osman."}));
        testGraph1.put("Winter", Set.of(new String[] {}));
        testGraph1.put("Lotus", Set.of(new String[] {"Chrys."}));
        testGraph1.put("Osman.", Set.of(new String[] {"Chrys."}));
        testGraph1.put("Chrys.", Set.of(new String[] {}));

        //Generate testGraph2
        Map<String, Set<String>> testGraph2 = new HashMap<>();
        String[] nodes = {"0","1","2","3","4","5","6"};
        String[][] links = {
                {"1","2","3","4","5","6"},
                {"2","3","4","6"},
                {"3","4","6"},
                {"6"},
                {},
                {"6"},
                {},
        };
        testGraph2 = generateGraph(nodes, links);


        Map<String, Set<String>> beaufortScale = new HashMap<>();
        beaufortScale.put("Calm", Set.of(new String[] {"Light air"}));
        beaufortScale.put("Light air", Set.of(new String[] {"Light breeze"}));
        beaufortScale.put("Light breeze", Set.of(new String[] {"Gentle breeze"}));
        beaufortScale.put("Gentle breeze", Set.of(new String[] {"Moderate breeze"}));
        beaufortScale.put("Moderate breeze", Set.of(new String[] {"Fresh breeze"}));
        beaufortScale.put("Fresh breeze", Set.of(new String[] {"Strong breeze"}));
        beaufortScale.put("Strong breeze", Set.of(new String[] {"High wind"}));
        beaufortScale.put("High wind", Set.of(new String[] {"Gale"}));
        beaufortScale.put("Gale", Set.of(new String[] {"Strong/severe gale"}));
        beaufortScale.put("Strong/severe gale", Set.of(new String[] {"Storm"}));
        beaufortScale.put("Storm", Set.of(new String[] {"Violent storm"}));
        beaufortScale.put("Violent storm", Set.of(new String[] {"Hurricane force"}));
        beaufortScale.put("Hurricane force", Set.of(new String[] {}));
//        beaufortScale.put("", Set.of(new String[] {""}));


        Map<String, Set<String>> douglasSeaScale = new HashMap<>();
        douglasSeaScale.put("No swell", Set.of(new String[] {"Very Low (short or average and low wave)"}));
        douglasSeaScale.put("Very Low (short or average and low wave)", Set.of(new String[] {"Low (long and low wave)"}));
        douglasSeaScale.put("Low (long and low wave)", Set.of(new String[] {"Light (short and moderate wave)"}));
        douglasSeaScale.put("Light (short and moderate wave)", Set.of(new String[] {"Moderate (average and moderate wave)"}));
        douglasSeaScale.put("Moderate (average and moderate wave)", Set.of(new String[] {"Moderate rough (long and moderate wave)"}));
        douglasSeaScale.put("Moderate rough (long and moderate wave)", Set.of(new String[] {"Rough (short and high wave)"}));
        douglasSeaScale.put("Rough (short and high wave)", Set.of(new String[] {"High (average and high wave)"}));
        douglasSeaScale.put("High (average and high wave)", Set.of(new String[] {"Very high (long and high wave)"}));
        douglasSeaScale.put("Very high (long and high wave)", Set.of(new String[] {"Confused (wavelength and height indefinable)"}));
        douglasSeaScale.put("Confused (wavelength and height indefinable)", Set.of(new String[] {}));


        Map<String, Set<String>> tropicalCycloneScale = new HashMap<>();
        tropicalCycloneScale.put("Tropical Depression'", Set.of(new String[] {"Tropical Storm"}));
        tropicalCycloneScale.put("Tropical Storm", Set.of(new String[] {"SevereTropical Storm"}));
        tropicalCycloneScale.put("SevereTropical Storm", Set.of(new String[] {"Typhoon"}));
        tropicalCycloneScale.put("Typhoon", Set.of(new String[] {"Very Strong Typhoon"}));
        tropicalCycloneScale.put("Very Strong Typhoon", Set.of(new String[] {"Violent Typhoon"}));
        tropicalCycloneScale.put("Violent Typhoon", Set.of(new String[] {}));

        //https://en.wikipedia.org/wiki/International_Standard_Classification_of_Education
        Map<String, Set<String>> internationalEducation = new HashMap<>();
        internationalEducation.put("Early childhood education (01 Early childhood educational development)", Set.of(new String[] {"Primary education"}));
        internationalEducation.put("Early childhood education (02 Pre-primary education)", Set.of(new String[] {"Primary education"}));
        internationalEducation.put("Primary education", Set.of(new String[] {"Lower secondary education"}));
        internationalEducation.put("Lower secondary education", Set.of(new String[] {"Upper secondary education"}));
        internationalEducation.put("Upper secondary education", Set.of(new String[] {"Post-secondary non-tertiary education"}));
        internationalEducation.put("Post-secondary non-tertiary education", Set.of(new String[] {"Short-cycle tertiary education"}));
        internationalEducation.put("Short-cycle tertiary education", Set.of(new String[] {"Bachelor's or equivalent"}));
        internationalEducation.put("Bachelor's or equivalent", Set.of(new String[] {"Master's or equivalent"}));
        internationalEducation.put("Master's or equivalent", Set.of(new String[] {"Doctorate or equivalent"}));
        internationalEducation.put("Doctorate or equivalent", Set.of(new String[] {}));


        //Put graphs in list
        List<Map<String, Set<String>>> graphs = new ArrayList<Map<String, Set<String>>>();
        graphs.add(beaufortScale);
        graphs.add(douglasSeaScale);
        graphs.add(tropicalCycloneScale);
        graphs.add(internationalEducation);


        //Generate rescaling flags
        Map<String, Boolean> rescaleBool = new HashMap<String, Boolean>();
        String[] flags = new String[] { "log", "sqrt", "square"};


        System.out.println("************* LOG **********************");
        //Keep log as the main normalization
        rescaleBool.put("log", true);
        avgConditionalInterestingness(graphs, generateRescaleFlag("log", flags));
        System.out.println("\n\n\n");


        System.out.println("************* SQRT **********************");
        rescaleBool.put("sqrt", true);
        avgConditionalInterestingness(graphs, generateRescaleFlag("sqrt", flags));
        System.out.println("\n\n\n");


        System.out.println("************* SQUARE **********************");
        rescaleBool.put("sqrt", true);
        avgConditionalInterestingness(graphs, generateRescaleFlag("square", flags));
        System.out.println("\n\n\n");
    */
    }

}