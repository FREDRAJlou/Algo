package brackets;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Paranthesis {
    // Function that print all combinations of
    // balanced parentheses
    // open store the count of opening parenthesis
    // close store the count of closing parenthesis
    static void _printParenthesis(char str[], int pos, int n, int open, int close)
    {
        if(close == n)
        {
            // print the possible combinations
            for(int i=0;i<str.length;i++)
                System.out.print(str[i]);
            System.out.println();
            return;
        }
        else
        {
            if(open > close) {
                str[pos] = '}';
                _printParenthesis(str, pos+1, n, open, close+1);
            }
            if(open < n) {
                str[pos] = '{';
                _printParenthesis(str, pos+1, n, open+1, close);
            }
        }
    }

    // Wrapper over _printParenthesis()
    static void printParenthesis(char str[], int n)
    {
        if(n > 0)
            _printParenthesis(str, 0, n, 0, 0);
        return;
    }

        public static List<String> generateParenthesis(int n) {
            List<String> r = new ArrayList<>();
            generate(n,"",0,0,r);
            return r;
        }

        public static void generate(int n, String s, int open, int close, List<String> r){

            if(open<n){
                generate(n,s+"(",open+1,close,r);
            }
            if(close<open){
                generate(n,s+")",open,close+1,r);
            }
            if(open==close && open == n)
            {
                if(!r.contains(s))
                    r.add(s);
            }
        }

    // driver program
    public static void main (String[] args)
    {
        int n = 9;
      /*  char[] str = new char[2 * n];
        printParenthesis(str, n);*/
       List<String> l =  generateParenthesis(n);
       System.out.println(String.join(", ",l));
      l.sort(Comparator.naturalOrder());
    }
}
