import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int answer = 0;
        List<Pair<Integer, Integer>> points=new ArrayList<Pair<Integer, Integer>>();
        points.add(new Pair<Integer, Integer>(1,1));
        points.add(new Pair<Integer, Integer>(1,3));
        points.add(new Pair<Integer, Integer>(2,1));
        points.add(new Pair<Integer, Integer>(2,3));
        points.add(new Pair<Integer, Integer>(3,1));
        points.add(new Pair<Integer, Integer>(3,3));


    //iterate through the points
    for(Pair<Integer,Integer> x:points)
    {
        //iterate through the points
        for(Pair<Integer,Integer> y:points)
        {
            Pair<Integer, Integer> p1 = x;
            Pair<Integer, Integer> p2 = y;

            //if these two points have different x's and y's it means they can be a diagonal
            //so p1-p2 will represent one diagonal
            if(p1.first!=p2.first && p1.second!=p2.second) {

                //we create the other two points, p3-p4 will represent the other diagonal
                Pair<Integer, Integer> p3 = new Pair(p1.first, p2.second);
                Pair<Integer, Integer> p4 = new Pair(p2.first, p1.second);

                //if p3 and p4 are in our list it means we will have p1-p2 the first diagonal in our list
                //and p3-p4 the second diagonal also in our list
                //So we have a rectangle and we increment answer
                Boolean ok1 = false;
                Boolean ok2 = false;
                for(Pair<Integer,Integer> p:points)
                {
                    if(p3.equals(p))
                        ok1=true;
                }
                for(Pair<Integer,Integer> p:points)
                {
                    if(p4.equals(p))
                        ok2=true;
                }

                if (ok1 && ok2)
                    ++answer;

            }
        }
    }

        //We have to divide answer by 4 because we take the diagonal points(p1 and p2) of a single rectangle in 4 ways
        System.out.println(answer/4);
    }
}
