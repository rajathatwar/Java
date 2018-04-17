package com.home.practice.exercise1;

import java.io.*;
import java.util.*;

public class Solution {
	int jj = 0;

	public static void main(String[] args) {

		Solution s = new Solution();

		System.out.println(s.jj);

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();

		}

		for (int j = arr.length - 1; j >= 0; j--) {
			System.out.println(arr[j]);
		}
		System.out.println(n);
		in.close();
	}
}
