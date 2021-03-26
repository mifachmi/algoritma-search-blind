package bsf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFs {

    private Queue<Node> queue;
    static ArrayList<Node> nodes=new ArrayList<Node>();

    static class Node {
        char data;
        boolean visited;
        List<Node> neighbours;

        Node(char data) {
            this.data = data;
            this.neighbours = new ArrayList<>();
        }

        public void addneighbours(Node neighbourNode) {
            this.neighbours.add(neighbourNode);
        }

        public List<Node> getNeighbours() {
            return neighbours;
        }

        public void setNeighbours(List<Node> neighbours) {
            this.neighbours = neighbours;
        }
    }

    public BreadthFs() {
        queue = new LinkedList<Node>();
    }

    public void SearchBFS(Node node) {
        queue.add(node);
        node.visited = true;
        while (!queue.isEmpty()) {
            Node element = queue.remove();
            System.out.print(element.data + "t ");
            List<Node> neighbours = element.getNeighbours();
            for (int i = 0; i < neighbours.size(); i++) {
                Node n = neighbours.get(i);
                if (n != null && !n.visited) {
                    queue.add(n);
                    n.visited = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Node node_s =new Node('S');
        Node node_b =new Node('B');
        Node node_a =new Node('A');
        Node node_c =new Node('C');
        Node node_d =new Node('D');
        Node node_e =new Node('E');
        Node node_f =new Node('F');
        Node node_z =new Node('Z');
        node_s.addneighbours(node_a);
        node_s.addneighbours(node_b);
        node_b.addneighbours(node_c);
        node_b.addneighbours(node_a);
        node_c.addneighbours(node_e);
        node_c.addneighbours(node_d);
        node_e.addneighbours(node_z);
        node_a.addneighbours(node_d);
        node_d.addneighbours(node_f);

//        Node node40 =new Node(40);
//        Node node10 =new Node(10);
//        Node node20 =new Node(20);
//        Node node30 =new Node(30);
//        Node node60 =new Node(60);
//        Node node50 =new Node(50);
//        Node node70 =new Node(70);
//        node40.addneighbours(node10);
//        node40.addneighbours(node20);
//        node10.addneighbours(node30);
//        node20.addneighbours(node10);
//        node20.addneighbours(node30);
//        node20.addneighbours(node60);
//        node20.addneighbours(node50);
//        node30.addneighbours(node60);
//        node60.addneighbours(node70);
//        node50.addneighbours(node70);
        System.out.println("The BFS traversal of the graph is ");

        BreadthFs bfsExample = new BreadthFs();
        bfsExample.SearchBFS(node_s);
    }
}
