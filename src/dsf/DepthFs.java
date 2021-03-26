package dsf;

import bsf.BreadthFs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFs {

    static class Node
    {
        char data;
        boolean visited;
        List<Node> neighbours;
        Node(char data)
        {
            this.data=data;
            this.neighbours=new ArrayList<>();
        }
        public void addneighbours(Node neighbourNode)
        {
            this.neighbours.add(neighbourNode);
        }
        public List<Node> getNeighbours() {
            return neighbours;
        }
        public void setNeighbours(List<Node> neighbours) {
            this.neighbours = neighbours;
        }
    }

    public void dfs(Node node){
        System.out.print(node.data + " ");
        List<Node> neighbours=node.getNeighbours();
        node.visited=true;
        for (int i = 0; i < neighbours.size(); i++) {
            Node n=neighbours.get(i);
            if(n!=null && !n.visited)
            {
                dfs(n);
            }
        }
    }

    public void dfsUsingStack(Node node)
    {
        Stack<Node> stack=new Stack<Node>();
        stack.add(node);
        while (!stack.isEmpty())
        {
            Node element=stack.pop();
            if(!element.visited)
            {
                System.out.print(element.data + " ");
                element.visited=true;
            }
            List<Node> neighbours=element.getNeighbours();
            for (int i = 0; i < neighbours.size(); i++) {
                Node n=neighbours.get(i);
                if(n!=null && !n.visited)
                {
                    stack.add(n);
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
//        node_b.addneighbours(node_s);
        node_b.addneighbours(node_a);
        node_b.addneighbours(node_c);
//        node_a.addneighbours(node_s);
//        node_a.addneighbours(node_b);
        node_a.addneighbours(node_d);
//        node_d.addneighbours(node_a);
        node_d.addneighbours(node_f);
//        node_d.addneighbours(node_c);
//        node_c.addneighbours(node_b);
        node_c.addneighbours(node_d);
        node_c.addneighbours(node_e);
//        node_e.addneighbours(node_c);
        node_e.addneighbours(node_z);
//        node_z.addneighbours(node_e);
//        node_f.addneighbours(node_d);

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

        DepthFs dfsExample = new DepthFs();
        System.out.println("The DFS traversal of the graph using stack ");
        dfsExample.dfsUsingStack(node_s);
        System.out.println();

        // Resetting the visited flag for nodes
        node_s.visited=false;
        node_a.visited=false;
        node_b.visited=false;
        node_c.visited=false;
        node_d.visited=false;
        node_f.visited=false;
        node_e.visited=false;
        node_z.visited=false;
        System.out.println("The DFS traversal of the graph using recursion ");
        dfsExample.dfs(node_s);
    }
}
