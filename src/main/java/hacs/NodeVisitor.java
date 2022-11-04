package hacs;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author Swetha Ganapathy
 * @version 3.0 update to Java 11
 */

abstract class NodeVisitor {

    public NodeVisitor() {
    }

    abstract void visitFacade(Facade facade);

    abstract void visitCourse(Course course);

    abstract void visitAssignment(Assignment assignment);

}
