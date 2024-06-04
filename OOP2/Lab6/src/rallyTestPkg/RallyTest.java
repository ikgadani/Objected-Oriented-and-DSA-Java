package rallyTestPkg;

import rallyPkg.RallyHeap;
import rallyPkg.RallyTeam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A class for testing and displaying rally team rankings based on leg results.
 */
public class RallyTest {

    /**
     * The main method to execute the rally team ranking display.
     *
     * @param args command line arguments (not used in this context).
     */
    public static void main(String[] args) {
        List<RallyTeam> rallyTeams = readRallyResults("RallyResults.csv");

        for (int leg = 1; leg <= 4; leg++) {
            List<RallyTeam> legResults = filterByLeg(rallyTeams, leg);
            displayTeamRankings(leg, legResults);
        }
    }

    /**
     * Reads rally results from a CSV file and returns a list of RallyTeam objects.
     *
     * @param filename the name of the CSV file containing rally results.
     * @return a list of RallyTeam objects representing the rally results.
     */
    private static List<RallyTeam> readRallyResults(String filename) {
        List<RallyTeam> rallyTeams = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int leg = Integer.parseInt(data[0]);
                String teamName = data[1];
                int time = Integer.parseInt(data[2]);

                RallyTeam rallyTeam = new RallyTeam(leg, teamName, time);
                rallyTeams.add(rallyTeam);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rallyTeams;
    }

    /**
     * Filters rally teams based on the specified leg.
     *
     * @param rallyTeams a list of RallyTeam objects representing all rally teams.
     * @param leg the leg for which teams are filtered.
     * @return a list of RallyTeam objects representing the results for the specified leg.
     */
    private static List<RallyTeam> filterByLeg(List<RallyTeam> rallyTeams, int leg) {
        List<RallyTeam> legResults = new ArrayList<>();
        for (RallyTeam team : rallyTeams) {
            if (team.getLeg() == leg) {
                legResults.add(team);
            }
        }
        return legResults;
    }

    /**
     * Displays the team rankings for a specific rally leg.
     *
     * @param leg the leg for which team rankings are displayed.
     * @param legResults a list of RallyTeam objects representing the results for the specified leg.
     */
    private static void displayTeamRankings(int leg, List<RallyTeam> legResults) {
        System.out.println("Team Rankings for Rally Leg " + leg);
        RallyHeap<RallyTeam> heap = new RallyHeap<>();

        for (RallyTeam team : legResults) {
            heap.insert(team);
        }

        RallyTeam result;
        while ((result = heap.extractMin()) != null) {
            System.out.println(result);
        }

        System.out.println();
    }
}
