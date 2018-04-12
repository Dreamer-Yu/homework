package Triangle;
import static org.junit.Assert.*;
import org.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

public class TestTri {
	Triangle tri=new Triangle();
	
	@Test
	public void testisTriangle(){
		assertEquals(1,tri.isTriangle(1,1,1));
	}
	@Test
	public void testequilateral(){
		assertEquals(1,tri.equilateral(1,1,1));
	}
	@Test
	public void testisosceles(){
		assertEquals(1,tri.isosceles(1,1,1));
	}
	@Test
	public void testscalene(){
		assertEquals(1,tri.scalene(1,1,1));
	}
}
