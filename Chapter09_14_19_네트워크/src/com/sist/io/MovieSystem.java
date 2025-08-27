package com.sist.io;
import java.util.*;
import java.io.*;
public class MovieSystem {
	private static ArrayList<MovieVO> mList=
			new ArrayList<MovieVO>();
	static
	{
		try
		{
			FileReader fr=new FileReader("c:\\javaDev\\movie.txt");
			StringBuffer sb=new StringBuffer();
			int i=0;
			/*
			 *    int read(char[] buffer,int offst,int len)
			 *    ---- 읽은 글자수 
			 *    int read()
			 *    ---- 문자
			 */
			while((i=fr.read())!=-1)
			{
				sb.append((char)i);
			}
			fr.close();
			
			String temp=sb.toString();
			String[] movies=temp.split("\n");
			for(String movie:movies)
			{
				String[] mm=movie.split("\\|");
				
			}
		}catch(Exception ex) {}
	}
}
