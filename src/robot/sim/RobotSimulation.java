package robot.sim;

/**
 * Represents a simulation of a robot moving on a table. The robot is placed on
 * a grid and can move in four directions: NORTH, EAST, SOUTH, WEST.
 */
public class RobotSimulation {
	private int x; 
	private int y; 
	private String direction; 
	private final int tabletopX; 
	private final int tabletopY; 
	private boolean placedOnTable;

	public RobotSimulation(int tabletopX, int tabletopY) {
		this.tabletopX = tabletopX;
		this.tabletopY = tabletopY;
		this.placedOnTable = false;
	}

	/**
	 * Get method for X
	 * 
	 * @return An Integer with the robots current x position
	 */
	public int getX() {
		return x;
	}

	/**
	 * Get method for Y
	 * 
	 * @return An Integer with the robots current y position
	 */
	public int getY() {
		return y;
	}

	/**
	 * Get method for table top X
	 * 
	 * @return An Integer with the size of grid in x direction
	 */
	public int getTabletopX() {
		return tabletopX;
	}

	/**
	 * Get method for table top Y
	 * 
	 * @return An Integer with the size of grid in y direction
	 */
	public int getTabletopY() {
		return tabletopY;
	}

	/**
	 * Get method for direction
	 * 
	 * @return A String with the direction the robot is facing
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * Place the robot on the table at the specified position and facing direction
	 */
	public void place(int x, int y, String direction) {
		if (isValidPosition(x, y)) {
			this.x = x;
			this.y = y;
			this.direction = direction;
			this.placedOnTable = true;
		} else {
			System.out.println("Invalid placement coordinates: (" + x + "," + y + ")");
		}
	}

	/**
	 * Move the robot one unit forward in the direction it is facing. Ignores the
	 * command if the robot has not been placed on the table.
	 */
	public void move() {
		if (!placedOnTable) {
			return;
		}

		int newX = x;
		int newY = y;

		switch (direction) {
		case "NORTH":
			newY++;
			break;
		case "EAST":
			newX++;
			break;
		case "SOUTH":
			newY--;
			break;
		case "WEST":
			newX--;
			break;
		}

		if (isValidPosition(newX, newY)) {
			x = newX;
			y = newY;
		}
		else {
			System.out.println("Not a valid move, the robot would fall of");
		}
	}

	/**
	 * Rotate the robot 90 degrees to the left. Ignores the command if the robot has
	 * not been placed on the table.
	 */
	public void left() {
		if (!placedOnTable) {
			System.out.println("Robot is not placed on table"); 
			return;
		}

		switch (direction) {
		case "NORTH":
			direction = "WEST";
			break;
		case "EAST":
			direction = "NORTH";
			break;
		case "SOUTH":
			direction = "EAST";
			break;
		case "WEST":
			direction = "SOUTH";
			break;
		}
	}

	/**
	 * Rotate the robot 90 degrees to the right. Ignores the command if the robot
	 * has not been placed on the table.
	 */
	public void right() {
		if (!placedOnTable) {
			System.out.println("Robot is not placed on table"); 
			return;
		}

		switch (direction) {
		case "NORTH":
			direction = "EAST";
			break;
		case "EAST":
			direction = "SOUTH";
			break;
		case "SOUTH":
			direction = "WEST";
			break;
		case "WEST":
			direction = "NORTH";
			break;
		}
	}

	/**
	 * Generate a report of the robot's current position and direction.
	 * 
	 * @return A string containing the robot's position and direction. Returns a
	 *         message if the robot has not been placed on the table yet.
	 */
	public String report() {
		if (!placedOnTable) {
			return "Robot has not been placed on the tabletop yet";
		}

		return "Output: " + x + "," + y + "," + direction;
	}

	private boolean isValidPosition(int x, int y) {
		return x >= 0 && x < tabletopX && y >= 0 && y < tabletopY;
	}
}
