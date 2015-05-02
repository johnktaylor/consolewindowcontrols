/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jktsoftware.consolewindowcontrols;

public class ConsoleProgressBar {
	public String getProgress(
			long progressbytes,
			long bytesread,
			long totalbytes) {
		String progress = "Bytes read: " +
			getProgressBar(progressbytes, bytesread, totalbytes, 20);
		return progress;
	}
	
	public String getProgressBar(
			long progressbytes, 
			long bytesread,
			long totalbytes,
			long totalsections) {
		String progressbar="";
		progressbar = progressbar + "[";
		float bytespersection = (float) totalbytes/totalsections;
		String bar = "";
		float completedsections = 0;
		for(long passes=1; passes<=totalsections; passes=passes+1) {
			if((passes)*bytespersection <= progressbytes) {
				completedsections=passes;
				bar = bar + "=";
			} else {
				bar = bar + " ";
			}
		}
		
		String in="          ";
		StringBuilder sb = new StringBuilder();
		sb.append(in);
		if(progressbytes>=(1024*1024*1024)) {
			float display = (float) progressbytes/(1024*1024*1024);
			String inprogress=String.format("%.1f", display) + " GiB";
			sb.insert(0, inprogress);
		} else if(progressbytes>=(1024*1024)) {
			float display = (float) progressbytes/(1024*1024);
			String inprogress=String.format("%.1f", display) + " MiB";
			sb.insert(0, inprogress);
		} else if(progressbytes>=1024) {
			float display = (float) progressbytes/1024;
			String inprogress=String.format("%.1f",display) + " kiB";
			sb.insert(0, inprogress);
		} else {
			float display = (float) progressbytes;
			String inprogress=String.format("%.0f",display) + " bytes";
			sb.insert(0, inprogress);
		}
		
		progressbar = progressbar + bar + "]";
		progressbar = progressbar + " " +
				  ( 
				  String.format("%.2f",((float)((completedsections * bytespersection) / totalbytes)*100))) 
				  + "% " + sb.toString() + " ";
		return progressbar;
	}
}
