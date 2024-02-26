package robotsim.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import robot.sim.RobotSimulation;

public class RobotSimulationTest {

	private RobotSimulation robot;

	/**
	 * Initializes the RobotSimulation object before each test.
	 */
	@Before
	public void setUp() throws Exception {
		robot = new RobotSimulation(5, 5);
	}

	/**
	 * Test for the place() method. Verifies that the robot is placed at the correct
	 * position and direction.
	 */
	@Test
	public void testPlace() {
		robot.place(1, 2, "NORTH");
		assertEquals(1, robot.getX());
		assertEquals(2, robot.getY());
		assertEquals("NORTH", robot.getDirection());
	}

	/**
	 * Test for the move() method. Verifies that the robot moves correctly based on
	 * its direction.
	 */
	@Test
	public void testMove() {
		robot.place(0, 0, "NORTH");
		robot.move();
		assertEquals(0, robot.getX());
		assertEquals(1, robot.getY());
		assertEquals("NORTH", robot.getDirection());
	}

	/**
	 * Test for the left() method. Verifies that the robot rotates 90 degrees to the
	 * left.
	 */
	@Test
	public void testLeft() {
		robot.place(0, 0, "NORTH");
		robot.left();
		assertEquals("WEST", robot.getDirection());
	}

	/**
	 * Test for the right() method. Verifies that the robot rotates 90 degrees to
	 * the right.
	 */
	@Test
	public void testRight() {
		robot.place(0, 0, "NORTH");
		robot.right();
		assertEquals("EAST", robot.getDirection());
	}

	/**
	 * Test for placing the robot outside the table bounds. Verifies that the
	 * robot's position and direction remain unchanged.
	 */
	@Test
	public void testPlaceOutsideTableBounds() {
		robot.place(6, 6, "NORTH");

		assertEquals(0, robot.getX());
		assertEquals(0, robot.getY());
		assertNull(robot.getDirection()); // Assuming direction is null if not placed correctly
	}

	/**
	 * Test for moving the robot outside the table bounds. Verifies that the robot's
	 * position and direction remain unchanged
	 */
	@Test
	public void testMoveAtTableBoundary() {
		robot.place(robot.getTabletopX() - 1, robot.getTabletopY() - 1, "NORTH");
		robot.move();

		assertEquals(robot.getTabletopX() - 1, robot.getX());
		assertEquals(robot.getTabletopY() - 1, robot.getY());
		assertEquals("NORTH", robot.getDirection());
	}

	/**
	 * Test for the report() method. Verifies that the report contains the correct
	 * position and direction of the robot.
	 */
	@Test
	public void testReport() {
		robot.place(1, 2, "NORTH");
		assertEquals("Output: 1,2,NORTH", robot.report());
	}
}
