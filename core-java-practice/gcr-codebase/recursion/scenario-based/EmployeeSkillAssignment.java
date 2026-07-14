import java.util.ArrayList;
import java.util.List;

public class EmployeeSkillAssignment {
    public static void findTeams(int[] skills, int index, int target, List<Integer> currentTeam) {
        if (target == 0) {
            System.out.println(currentTeam);
            return;
        }
        if (index == skills.length || target < 0) {
            return;
        }

        // Include current skill
        currentTeam.add(skills[index]);
        findTeams(skills, index + 1, target - skills[index], currentTeam);
        currentTeam.remove(currentTeam.size() - 1);

        // Exclude current skill
        findTeams(skills, index + 1, target, currentTeam);
    }

    public static void main(String[] args) {
        int[] input = {2, 3, 5, 7};
        int target = 10;
        
        System.out.println("Output:");
        findTeams(input, 0, target, new ArrayList<>());
    }
}
