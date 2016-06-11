package com.flp.pms.service.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.flp.pms.domain.Category;
import com.flp.pms.service.ProductServiceImpl;

public class ServiceTest {

	
		ProductServiceImpl productServiceImpl=new ProductServiceImpl();
		
		
		@Test
		public void checkingrandomNumber() {
			int num=productServiceImpl.generateProductId();
			System.out.println(num);
			int arr[]=new int[4];
			String str=String.valueOf(num);
			
			assertEquals(arr.length,str.length() );
			
		}
		@Test
		public void checkingCategory(){
			List<Category> categories=productServiceImpl.getAllCategory();
			assertEquals(5, categories.size());
			
		}
		
	}


