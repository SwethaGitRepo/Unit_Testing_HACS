package hacs;
/*
  Title:        HACS
  Description:  CSE870 Homework 3:  Implementing Design Patterns
  Copyright:    Copyright (c) 2002
  Company:      Department of Computer Science and Engineering, Michigan State University
  @author mjfindler
 * @version 1.0
 * @author Swetha Ganapathy
 * @version 2.0
 */

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@SuppressWarnings("ALL")
public class Assignment {
    protected String assName;
    protected Date dueDate = new Date();
    protected String assSpec;
    protected SolutionList theSolutionList = new SolutionList();
    protected Solution suggestSolution = new Solution();

    protected Boolean isSolnSubmitted = false;

    public Assignment() {
    }

    public void setDueDate(Date theDueDate) {
        this.dueDate = theDueDate;
    }

    public void setAssSpec(String theSpec) {
        this.assSpec = theSpec;
    }

    public boolean isOverDue() {
        Date today;
        today = new Date();
        return (today.after(this.dueDate));
    }

    public Solution addSolution() {
        Solution mySolution = new Solution();
        return mySolution;
    }

    ////add the theSolution to the SolutionList
    public void addSolution(Solution theSolution) {
        theSolutionList.add(theSolution);
    }

    public void submitSolution() {
        isSolnSubmitted = true;
    }

    public List<Solution> getSolutionList() {
        return theSolutionList;
    }

    /* return the solution of the give name
    */
    public Solution getSolution(String studentName) {
        SolutionIterator iterator = new SolutionIterator(theSolutionList);
        return (Solution) iterator.next(studentName);
    }

    public Solution getSugSolution() {
        return suggestSolution;
    }

    public SolutionIterator getSolutionIterator() {
        return new SolutionIterator(theSolutionList);
    }

    public String toString() {
        return assName;
    }

    public String getDueDateString() {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        return  dateFormat.format(dueDate);
    }

    public void accept(NodeVisitor visitor) {
        visitor.visitAssignment(this);
    }
}
