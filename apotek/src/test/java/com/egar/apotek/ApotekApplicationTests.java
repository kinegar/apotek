package com.egar.apotek;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

//@SpringBootTest
class ApotekApplicationTests {

	@Test
	void contextLoads() {
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(1);
		list.add(4);
		list.add(3);
		list.add(5);
		list.add(100);
		list.add(102);
		list.add(101);

		for (int i = 0; i < list.size()-1; i++) {
			for (int j = i+1; j <list.size() ; j++) {
				if(list.get(i)>= list.get(j)){
					Integer temp = list.get(i);
					list.set(i,list.get(j));
					list.set(j,temp);
				}
			}
		}

		System.out.println(list);

		Integer prev;
		Integer counter = 1;
		Integer maxSeq = 1;
		for (int i = 0; i < list.size()-1; i++) {
			if(list.get(i) == list.get(i+1)+1){
				counter = counter + 1;
				if(maxSeq<counter){
					maxSeq = counter;
				}
			}else {
				counter = 1;
			}
		}

		System.out.println(maxSeq);
	}

}
