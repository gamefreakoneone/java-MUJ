package Lab.Lab7;
import java.util.*;

class Edge {  //Creating the Edge Class
    private String start;
    private String end;
    private int cost;

    Edge(String start, String end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }


    // getter functions
    public String getStart() {
        return this.start;
    }

    public String getEnd() {
        return this.end;
    }

    public int getCost() {
        return this.cost;
    }

}

public class Graph {
    private ArrayList<Edge> list_edges = new ArrayList<Edge>();  // To collect all the Edges of the Array

    Graph(ArrayList<Edge> list_edges) {
        this.list_edges = list_edges;
    }

    // Removing Loops
    public void removeLoop() {
        for (Edge edge : list_edges) {
            if (edge.getStart().equals(edge.getEnd())) {
                System.out.println("Removed edge with start: " + edge.getStart() + " and end: " + edge.getEnd());
                list_edges.remove(edge);
            }
        }
    }

    public Edge findParallelEdge(Edge n) {

        for (Edge edge : list_edges) {
            if (((edge.getStart().equals(n.getStart()) && edge.getEnd().equals(n.getEnd())) || (edge.getStart().equals(n.getEnd()) && edge.getEnd().equals(n.getStart()))) && edge != n) {
                System.out.println("Found a parallel edge");
                return edge;
            }

        }
        return null;
    }

    public void removeParallel() {
        Edge parallelEdge;
        for (Edge edge : list_edges) {
            parallelEdge = findParallelEdge(edge);
            if(parallelEdge != null) {
                if(parallelEdge.getCost() >= edge.getCost()) {
                    System.out.println("Removed edge with cost: "+ parallelEdge.getCost());
                    list_edges.remove(parallelEdge);
                    return;
                }
                else {
                    System.out.println("Removed edge with cost: "+ edge.getCost());
                    list_edges.remove(edge);
                    return;
                }
            }
        }
        System.out.println("Parallel Edges not found");
    }

    public void print() {
        for (Edge edge : list_edges) {
            System.out.println("-----------------------");
            System.out.println("Start: " + edge.getStart());
            System.out.println("End: "+ edge.getEnd());
            System.out.println("Cost: "+edge.getCost());
        }
    }

    public static void main(String[] args) {
        ArrayList<Edge> edges = new ArrayList<Edge>();
        edges.add(new Edge("Jaipur", "Pilani", 5));
        edges.add(new Edge("Pilani", "Delhi", 3));
        edges.add(new Edge("Delhi", "Sikar", 2));
        edges.add(new Edge("Sikar", "Jaipur", 2));
        edges.add(new Edge("Jaipur", "Delhi", 1));
        edges.add(new Edge("Pilani", "Pilani", 4));
        edges.add(new Edge("Sikar", "Delhi", 12));
        Graph graph = new Graph(edges);

        graph.print();
        System.out.println("\nREMOVING LOOPS\n");
        graph.removeLoop();
        graph.print();
        System.out.println("\nREMOVING PARALLEL\n");
        graph.removeParallel();
        graph.print();
    }

}