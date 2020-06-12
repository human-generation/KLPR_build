package com.kimchi.biz.csv;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TransferCSV {
	public static void main(String args[]) {
        String s;
        Process p;
        try {
            p = Runtime.getRuntime().exec("mv seoul_gu.csv /var/lib/tomcat9/webapps/ ");
            BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null)
                System.out.println("line: " + s);
            p.waitFor();
            System.out.println ("exit: " + p.exitValue());
            p.destroy();
        } catch (Exception e) {}
    }
}
