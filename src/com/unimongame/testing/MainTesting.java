package com.unimongame.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.unimongame.*;

public class MainTesting {




	public static void main(String[] args) {
		Player a = new Player("ian");
		//System.out.println();
		Player b = new Player("bob");
		
		Battle bat = new Battle(a,b);
		bat.run();

}
}
