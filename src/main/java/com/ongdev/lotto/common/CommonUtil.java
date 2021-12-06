package com.ongdev.lotto.common;

import java.util.*;

public class CommonUtil {

    public static Random random = new Random();

    /*번호 생성 및 정렬*/
    public static List<Integer> sortSet(Set<Integer> set){

        while (set.size() < 6){
            //1~45랜덤 번호 생성
            set.add(random.nextInt(45)+1);
        }

        List<Integer> list = new ArrayList<Integer>(set);
        Collections.sort(list);

        return list;
    }
}
