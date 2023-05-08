import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args) {
//        System.out.println(
//                romanToInt("CMXCVIII")
//        );

        System.out.println(romanToIntUsingHashmap("MCMXCIV"));

    }

    public static int romanToInt(String s) {
        int I = 1;
        int V = 5;
        int X = 10;
        int L = 50;
        int C = 100;
        int D = 500;
        int M = 1000;
        int num = 0;
        int i = 0;
        while(i<s.length()){
            if(i<s.length()-1) {
                if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'V') {
                    num = num + (V - I);
                    i = i + 2;continue;
                } else if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'X') {
                    num = num + (X - I);
                    i = i + 2; continue;
                } else if (s.charAt(i) == 'X' && s.charAt(i + 1) == 'L') {
                    num = num + (L - X);
                    i = i + 2; continue;
                } else if (s.charAt(i) == 'X' && s.charAt(i + 1) == 'C') {
                    num = num + (C - X);
                    i = i + 2;continue;
                } else if (s.charAt(i) == 'C' && s.charAt(i + 1) == 'D') {
                    num = num + (D - C);
                    i = i + 2;continue;
                } else if (s.charAt(i) == 'C' && s.charAt(i + 1) == 'M') {
                    num = num + (M - C);
                    i = i + 2;continue;
                }
            }
            switch (s.charAt(i)){
                case 'I': {num=num+I; i++; break;}
                case 'V': {num=num+V; i++; break;}
                case 'X': {num=num+X;i++; break;}
                case 'L': {num=num+L;i++; break;}
                case 'C': {num=num+C;i++; break;}
                case 'D': {num=num+D;i++; break;}
                case 'M': {num=num+M;i++; break;}
            }
        }
        return num;
    }

  public static int romanToIntUsingHashmap(String s){
      HashMap<Character, Integer> romanIntMap = new HashMap<>();
      romanIntMap.put('I', 1);
      romanIntMap.put('V', 5);
      romanIntMap.put('X', 10);
      romanIntMap.put('L', 50);
      romanIntMap.put('C', 100);
      romanIntMap.put('D', 500);
      romanIntMap.put('M', 1000);

//      point i and i+1 to check if previous value is less or more
//      To avoid index out of bound exception 1st check if i+1 < length of string
//      result = 0
//      Example: 998 => CMXCVIII
//      if(C value < M value) => 100 < 1000 => Yes => minus operation => result - current i value i.e. C => 0-100 => -100
//      if(M value < X value) => 1000 < 10 => No => Addition operation => result + current i value i.e. M => -100+1000 => 900
//      if(X value < C value) => 10 < 100 => Yes => Minus operation => result - current i value i.e. X => 900-10 => 890
//      if(C value < V value) => 100 < 5 => No => Addition operation => result + current i value i.e. C => 890 + 100 => 990
//      if(V value < I value) => 5 < 1 => No => Addition operation => result + current i value i.e. V => 990 + 5 => 995
//      if(I value < I value) => 1 < 1 => No => Addition operation => result + current i value i.e. I => 990 + 1 => 996
//      if(I value < I value) => 1 < 1 => No => Addition operation => result + current i value i.e. I => 990 + 1 => 997
//      if(I value < I value) => 1 < 1 => No => Addition operation => result + current i value i.e. I => 990 + 1 => 998

//      Exmaple 2: 1994 => MCMXCIV

      int num = 0;
      for(int i = 0;i<s.length();i++){
          if(i+1<s.length() && romanIntMap.get(s.charAt(i))<romanIntMap.get(s.charAt(i+1)))
                num -= romanIntMap.get(s.charAt(i));
          else
              num += romanIntMap.get(s.charAt(i));
      }
    return num;
  }
}
