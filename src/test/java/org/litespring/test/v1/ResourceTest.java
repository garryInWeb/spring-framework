package org.litespring.test.v1;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zhengtengfei on 2018/10/30.
 */
public class ResourceTest {
	@Test
	public void testClassLoader(){
		Resource resource = new ClassPathResource("petstore-v1.xml");

		InputStream in = null;
		try{
			in = resource.getInputStream();
			Assert.assertNotNull(in);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
