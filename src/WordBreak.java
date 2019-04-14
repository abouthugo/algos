import java.util.*;

public class WordBreak {

    Set<String> wordDictSet;
    Queue<Integer> queue;
    int[] visited;
    String s;

    public WordBreak(String s, List<String> wordDict) {
        this.wordDictSet = new HashSet<>(wordDict);
        this.s = s;
        queue = new LinkedList<>();
        visited = new int[s.length()];
    }

    /**
     * Breadth first solution
     * @return
     */
    public boolean solve(){
        queue.add(0);
        while(!queue.isEmpty()){
            int start = queue.remove();
            if(visited[start] == 0){
                for(int end = start + 1; end <= s.length(); end++){
                    if(wordDictSet.contains(s.substring(start, end))){
                        queue.add(end);
                        if(end == s.length()){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Brute force, recursive solution
     */
    public boolean mySolution(String s, List<String> wordDict){
        return mySolution(s, new HashSet<>(wordDict), 0);
    }

    public boolean mySolution(String s, Set<String> wordDictSet, int start){
        // Base case: we have reached the end of the string
        if(start == s.length()) return true;
        for(int end = start+1; end <= s.length(); end++){
            if(wordDictSet.contains(s.substring(start, end)) && mySolution(s, wordDictSet, end)){
                return true;
            }
        }
        return false;
    }

    /**
     * Slightly modified brute force solution with memoization to speed things up
     */
    public boolean mySolutionMemo(String s, List<String> dict){
        return mySolutionMemo(s, new HashSet<String>(dict), 0, new Boolean[s.length()]);
    }

    public boolean mySolutionMemo(String s, HashSet<String> dict, int start, Boolean[] memo){
        if(start == s.length()) return true;
        // memoization happens here
        if(memo[start] != null) return memo[start];
        for(int end =  start + 1; end <= s.length(); end++){
            if(dict.contains(s.substring(start,end)) && mySolutionMemo(s, dict, end, memo)){
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }

}
