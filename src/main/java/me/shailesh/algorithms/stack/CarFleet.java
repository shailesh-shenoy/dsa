package me.shailesh.algorithms.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class CarFleet {
    public record Car(Integer position, Double time) {};

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        var cars = new ArrayList<Car>(n);
        for(int i = 0; i < n; i++) {
            Double time = (target - position[i]) / (double) speed[i];
            Car c = new Car(position[i], time);
            cars.add(c);
        }

        cars.sort((a, b) -> b.position().compareTo(a.position()));

        var st = new Stack<Car>();

        for(Car c : cars) {
            if(st.isEmpty()) {
                st.push(c);
                continue;
            }
            Car top = st.peek();
            if(c.time() > top.time()) {
                st.push(c);
            }
        }

        return st.size();
    }

    public static void main(String[] args) {
        var cf = new CarFleet();
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        System.out.println(cf.carFleet(target, position, speed));
    }
}
