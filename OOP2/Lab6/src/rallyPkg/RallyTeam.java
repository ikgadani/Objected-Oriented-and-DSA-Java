package rallyPkg;

/**
 * Represents a rally team with information about its leg, team name, and time.
 */
public class RallyTeam implements Comparable<RallyTeam> {
    private String teamName;
    private int leg;
    private int time;

    /**
     * Constructs a RallyTeam object.
     *
     * @param leg      the leg of the rally.
     * @param teamName the name of the team.
     * @param time     the time taken by the team.
     */
    public RallyTeam(int leg, String teamName, int time) {
        this.leg = leg;
        this.teamName = teamName;
        this.time = time;
    }

    /**
     * Gets the team name.
     *
     * @return the team name.
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Gets the leg of the rally.
     *
     * @return the leg of the rally.
     */
    public int getLeg() {
        return leg;
    }

    /**
     * Gets the time taken by the team.
     *
     * @return the time taken by the team.
     */
    public int getTime() {
        return time;
    }

    /**
     * Compares this RallyTeam with another based on their times.
     *
     * @param other the RallyTeam to compare to.
     * @return a negative integer, zero, or a positive integer if this team's time is less than, equal to, or greater than
     *         the other team's time.
     */
    @Override
    public int compareTo(RallyTeam other) {
        return Integer.compare(this.time, other.time);
    }

    /**
     * Returns a string representation of the RallyTeam.
     *
     * @return a string containing the team name and time.
     */
    @Override
    public String toString() {
        return teamName + " " + time;
    }
}
