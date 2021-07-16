package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ScannerBuffer {
	private ScannerBuffer instance = new ScannerBuffer();
	public ScannerBuffer getInstance() {
		return instance;
	}
	private ScannerBuffer() {}
	
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public String next() {
		try {
			return br.readLine();			
		}catch(Exception e) {
			return "";
		}
	}
	
	public int nextInt() {
		try {
			return Integer.parseInt(br.readLine());
		}catch(Exception e) {
			return 0;			
		}
	}
}
