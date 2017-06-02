package com.prj1.stand.artworldviewer.utilities;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Stand on 6/1/2017.
 */

public class SanInputStream extends FilterInputStream {
	public SanInputStream(InputStream in) {
		super(in);
	}
	public long skip(long n) throws IOException {
		long m = 0L;
		while (m < n) {
			long _m = in.skip(n-m);
			if (_m == 0L) break;
			m += _m;
		}
		
		return m;
	}
}
