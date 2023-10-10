/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        List<Node> flag = new ArrayList<>();
        Stack<Node> pilha = new Stack<>();
        List<Node> ret = new LinkedList<>();
        
        Node atual;
        pilha.push(node);

        if (node == null || node.neighbors.isEmpty())
            return node;

        for (int i = 0; i < node.neighbors.size(); i++){
            while (!(pilha.isEmpty())) {
                atual = pilha.pop();
                
                for (int j = 0; j < atual.neighbors.size(); j++) {
                    Node novo = new Node(atual.val);
                    
                    if (!(flag.contains(atual.neighbors.get(j)))) {
                        flag.add(atual.neighbors.get(j));
                        
                        novo.neighbors.add(atual.neighbors.get(j));
                    }
                    ret.add(novo);
                }
            }
            
            if (!(flag.contains(node.neighbors.get(i)))){
                pilha.push(node.neighbors.get(i));
                flag.add(node.neighbors.get(i));
            }
            
        }
        
        return ret.get(0);
    }
}
