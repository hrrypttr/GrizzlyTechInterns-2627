import java.util.*;

public class compression {
    static class HuffmanNode {
        char ch;
        int frequency;
        HuffmanNode left;
        HuffmanNode right;

        //Leafs
        HuffmanNode(char ch, int frequency) {
            this.ch = ch;
            this.frequency = frequency;
        }

        //Branches
        HuffmanNode(int frequency, HuffmanNode left, HuffmanNode right) {
            this.ch = '\0'; 
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }

        /*
        boolean isLeaf() {
            if (left == null && right == null){
                return true;
            }
            else {
                return false;
            }
        }
        */
    }

    public static void main(String[] args) {
        //Text
        Scanner read = new Scanner(System.in);
        System.out.println("Text:");
        String text = read.nextLine();

        HashMap<Character, Integer> frequencies  = new HashMap<>();

        for (char c: text.toCharArray()) {
          frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }
        
        //Frequency sort 
        PriorityQueue<HuffmanNode> priority = new PriorityQueue<>(Comparator.comparingInt(node -> node.frequency));

        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            priority.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        //Build Huffmantree
        while (priority.size() > 1) {

        }
    }
}
