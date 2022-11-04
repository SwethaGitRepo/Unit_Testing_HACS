package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacadeTest {
    Facade facade = new Facade();
    Assignment assignment = new Assignment();
    Solution solution = new Solution();

    @Test
    void login() {
        assignment.theSolutionList.add(new Solution());
        facade.reportSolutions(assignment);
        assertTrue(assignment.theSolutionList.get(0).reported);
    }

    @Test
    void addAssignment() {
        facade.submitSolution(assignment, solution);
        assertTrue(assignment.theSolutionList.contains(solution));
    }

    @Test
    void submitSolution() {
        int count = 2;
        Solution s1 = new Solution();
        Solution s2 = new Solution();
        facade.submitSolution(assignment, s1);
        facade.submitSolution(assignment, s2);
        assertEquals(assignment.theSolutionList.size(), count);
    }

    @Test
    void createUser() {
        UserInfoItem user = new UserInfoItem();
        user.strUserName = "MichaelFindler";
        user.userType = UserInfoItem.UserType.INSTRUCTOR;
        facade.createUser(user);
        assertEquals(facade.thePerson.userName, "MichaelFindler");

        user.strUserName = "Swetha Ganapathy";
        user.userType = UserInfoItem.UserType.STUDENT;
        facade.createUser(user);
        assertEquals(facade.thePerson.userName, "Swetha Ganapathy");
    }

}
